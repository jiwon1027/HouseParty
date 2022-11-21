import axios from "axios";
import jwtDecode from "jwt-decode";

function logout() {
  let token = sessionStorage.getItem("access-token");
  let userid = jwtDecode(token).userid;
  return new Promise((resolve) => {
    axios.get(`http://localhost/happyhouse/users/logout/${userid}`).then((response) => {
      if (response.data.message === "success") {
        sessionStorage.setItem("access-token", null);
        sessionStorage.setItem("refresh-token", null);
        console.log("로그아웃 성공");
        resolve();
      }
    });
  });
}

export default logout;
