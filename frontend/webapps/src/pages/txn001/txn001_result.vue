<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const transactionStatus = ref('成功');
const transactionId = ref(`TXN${Math.floor(Math.random() * 1000000)}`);

const goHome = () => {
  router.push({ name: 'txn001-home' });
};

const goToIndex = () => {
  router.push('/');
};
</script>

<template>
  <main class="mx-auto flex h-screen max-w-3xl flex-col items-center justify-center px-4 py-16">
    <h1 class="pb-10 text-center text-4xl text-gray-700 transition-colors dark:text-gray-100">
      交易結果
    </h1>

    <div class="mb-4 w-full max-w-lg rounded bg-white px-8 pb-8 pt-6 shadow-md dark:bg-gray-800">
      <div class="mb-4">
        <p class="text-gray-700 dark:text-gray-300">
          <strong>交易狀態:</strong> {{ transactionStatus }}
        </p>
      </div>
      <div class="mb-6">
        <p class="text-gray-700 dark:text-gray-300">
          <strong>交易編號:</strong> {{ transactionId }}
        </p>
      </div>

      <div class="flex justify-center space-x-4">
        <button
          class="rounded bg-blue-500 px-6 py-2 font-bold text-white transition-colors hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2"
          @click="goHome"
        >
          返回首頁
        </button>

        <button
          class="rounded bg-gray-500 px-6 py-2 font-bold text-white transition-colors hover:bg-gray-700 focus:outline-none focus:ring-2 focus:ring-gray-500 focus:ring-offset-2"
          @click="goToIndex"
        >
          返回主頁
        </button>
      </div>
    </div>
  </main>
</template>
