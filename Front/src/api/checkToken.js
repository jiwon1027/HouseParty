import axios from "axios";
import jwtDecode from "jwt-decode";

function checkById(token) {
  let userid = jwtDecode(token).userid;
  return new Promise((resolve) => {
    axios
      .get(`http://localhost/happyhouse/users/info/${userid}`, {
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
      .then((response) => {
        if (response.data.message === "success") {
          resolve(true);
        }
      })
      .catch(async (response) => {
        console.log("토큰 재생성");
        let canCreate = await tokenRegeneration();
        resolve(canCreate);
      });
  });
}
function tokenRegeneration() {
  let token = sessionStorage.getItem("access-token");
  let userid = jwtDecode(token).userid;
  return new Promise((resolve) => {
    axios
      .post(
        `http://localhost/happyhouse/users/refresh`,
        {
          userId: userid,
        },
        {
          headers: {
            "refresh-token": sessionStorage.getItem("refresh-token"),
          },
        }
      )
      .then((response) => {
        if (response.data.message === "success") {
          sessionStorage.setItem("access-token", response.data["access-token"]);
          resolve(true);
        }
      })
      .catch(() => {
        console.log("로그인 필요");
      });
  });
}

export default checkById;
