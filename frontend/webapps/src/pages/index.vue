<script setup>
import { useRouter } from 'vue-router';

const router = useRouter();

const goToTxn001Home = () => {
  router.push('/txn001_home');
};
</script>

<template>
  <div class="flex h-screen items-center justify-center">
    <button
      @click="goToTxn001Home"
      class="px-4 py-2 font-bold text-white bg-blue-500 rounded-full hover:bg-blue-700 focus:outline-none focus:shadow-outline"
    >
      Go to Transaction Form
    </button>
  </div>
</template>

<style>
/* No styles needed */
</style>
