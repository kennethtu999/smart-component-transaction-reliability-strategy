<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

// Assume these values are passed as route params or through a state management solution
const transactionDetails = ref({
  accountOut: '支票帳戶',
  accountIn: '投資帳戶',
  currency: '美元',
  amount: 1000,
  comment: '月度投資轉帳',
});

const confirmTransaction = () => {
  // Here you would typically send the transaction to a backend API
  // For now, we'll just navigate to the result page
  router.push({ name: 'txn001-result' });
};

const goBack = () => {
  router.push({ name: 'txn001-home' });
};
</script>

<template>
  <main class="mx-auto flex h-screen max-w-3xl flex-col items-center justify-center px-4 py-16">
    <h1 class="pb-10 text-center text-4xl text-gray-700 transition-colors dark:text-gray-100">
      確認交易
    </h1>

    <div class="mb-4 w-full max-w-lg rounded bg-white px-8 pb-8 pt-6 shadow-md dark:bg-gray-800">
      <div class="mb-4">
        <p class="text-gray-700 dark:text-gray-300">
          <strong>轉出帳戶:</strong> {{ transactionDetails.accountOut }}
        </p>
      </div>
      <div class="mb-4">
        <p class="text-gray-700 dark:text-gray-300">
          <strong>轉入帳戶:</strong> {{ transactionDetails.accountIn }}
        </p>
      </div>
      <div class="mb-4">
        <p class="text-gray-700 dark:text-gray-300">
          <strong>貨幣:</strong> {{ transactionDetails.currency }}
        </p>
      </div>
      <div class="mb-4">
        <p class="text-gray-700 dark:text-gray-300">
          <strong>金額:</strong> {{ transactionDetails.amount }}
        </p>
      </div>
      <div class="mb-6">
        <p class="text-gray-700 dark:text-gray-300">
          <strong>備註:</strong> {{ transactionDetails.comment }}
        </p>
      </div>

      <div class="flex justify-between">
        <button
          class="rounded bg-gray-500 px-4 py-2 font-bold text-white hover:bg-gray-700 focus:outline-none"
          @click="goBack"
        >
          返回
        </button>
        <button
          class="rounded bg-blue-500 px-4 py-2 font-bold text-white hover:bg-blue-700 focus:outline-none"
          @click="confirmTransaction"
        >
          確認交易
        </button>
      </div>
    </div>
  </main>
</template>
