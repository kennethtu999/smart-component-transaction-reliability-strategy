<template>
  <div>
    <router-view />
    <footer class="common-footer">
      <p>
        <a href="http://127.0.0.1:8080/swagger-ui/index.html" target="_blank" rel="noopener noreferrer" class="clickable-link">
          Swagger UI
        </a>
      </p>
    </footer>
  </div>
</template>

<style scoped>
.common-footer {
  position: fixed;
  bottom: 0;
  left: 0;
  width: 100%;
  text-align: center;
}
</style>
