<script setup>
import logout from "@/api/logout";
</script>

<script>
export default {
  async mounted() {
    await logout();
    this.$router.push({ name: "presentation" });
  },
};
</script>
