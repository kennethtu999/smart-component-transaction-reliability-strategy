<script setup>
// 為表單輸入添加響應式引用
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const accountOut = ref('');
const accountIn = ref('');
const currency = ref('');
const amount = ref('');
const comment = ref('');

// 帳戶和貨幣的模擬數據
const mockAccountsOut = [
  { id: 1, name: '支票帳戶' },
  { id: 2, name: '儲蓄帳戶' },
];

const mockAccountsIn = [
  { id: 3, name: '投資帳戶' },
  { id: 4, name: '退休帳戶' },
];

const mockCurrencies = [
  { code: 'USD', name: '美元' },
  { code: 'EUR', name: '歐元' },
  { code: 'GBP', name: '英鎊' },
  { code: 'JPY', name: '日元' },
];

// 驗證函數
const validateForm = () => {
  if (!accountOut.value) return '請選擇轉出帳戶';
  if (!accountIn.value) return '請選擇轉入帳戶';
  if (!currency.value) return '請選擇貨幣';
  if (!amount.value || Number.isNaN(Number(amount.value))) return '請輸入有效的金額';
  if (!comment.value) return '請輸入備註';
  if (comment.value.length > 50) return '備註不能超過50個字符';
  return '';
};

// 處理表單提交的函數
const handleSubmit = () => {
  const error = validateForm();
  if (error) {
    alert(error);
    return;
  }
  // If validation passes, navigate to the confirm page
  router.push({ name: 'txn001-confirm' });
};

// 計算剩餘字符數
const remainingChars = computed(() => 50 - comment.value.length);
</script>

<template>
  <header class="absolute inset-x-0 top-0">
    <div class="container mx-auto flex justify-end p-4">
      <button
        class="overflow-hidden p-2"
        @click="switchTheme()"
      >
      </button>
    </div>
  </header>

  <main class="mx-auto flex h-screen max-w-3xl flex-col items-center justify-center px-4 py-16">
    <h1 class="pb-10 text-center text-4xl text-gray-700 transition-colors dark:text-gray-100">
      交易表單
    </h1>

    <form @submit.prevent="handleSubmit" class="w-full max-w-lg">
      <div class="mb-4">
        <label for="accountOut" class="block mb-2 text-sm font-bold text-gray-700 dark:text-gray-300">轉出帳戶 *</label>
        <select v-model="accountOut" id="accountOut" required class="w-full px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline dark:bg-gray-700 dark:text-gray-300 dark:border-gray-600">
          <option value="">選擇轉出帳戶</option>
          <option v-for="account in mockAccountsOut" :key="account.id" :value="account.id">{{ account.name }}</option>
        </select>
      </div>

      <div class="mb-4">
        <label for="accountIn" class="block mb-2 text-sm font-bold text-gray-700 dark:text-gray-300">轉入帳戶 *</label>
        <select v-model="accountIn" id="accountIn" required class="w-full px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline dark:bg-gray-700 dark:text-gray-300 dark:border-gray-600">
          <option value="">選擇轉入帳戶</option>
          <option v-for="account in mockAccountsIn" :key="account.id" :value="account.id">{{ account.name }}</option>
        </select>
      </div>

      <div class="mb-4">
        <label for="currency" class="block mb-2 text-sm font-bold text-gray-700 dark:text-gray-300">貨幣 *</label>
        <select v-model="currency" id="currency" required class="w-full px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline dark:bg-gray-700 dark:text-gray-300 dark:border-gray-600">
          <option value="">選擇貨幣</option>
          <option v-for="curr in mockCurrencies" :key="curr.code" :value="curr.code">{{ curr.name }}</option>
        </select>
      </div>

      <div class="mb-4">
        <label for="amount" class="block mb-2 text-sm font-bold text-gray-700 dark:text-gray-300">金額 *</label>
        <input v-model="amount" type="number" id="amount" required class="w-full px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline dark:bg-gray-700 dark:text-gray-300 dark:border-gray-600" placeholder="輸入金額">
      </div>

      <div class="mb-6">
        <label for="comment" class="block mb-2 text-sm font-bold text-gray-700 dark:text-gray-300">備註 * (最多50字)</label>
        <textarea v-model="comment" id="comment" required maxlength="50" class="w-full px-3 py-2 text-sm leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline dark:bg-gray-700 dark:text-gray-300 dark:border-gray-600" rows="3" placeholder="輸入備註"></textarea>
        <p class="text-sm text-gray-500 mt-1">剩餘字符數: {{ remainingChars }}</p>
      </div>

      <div class="flex justify-center">
        <button type="submit" class="px-4 py-2 font-bold text-white bg-blue-500 rounded-full hover:bg-blue-700 focus:outline-none focus:shadow-outline dark:bg-blue-600 dark:hover:bg-blue-800">
          下一步
        </button>
      </div>
    </form>
  </main>
</template>

<style>
body {
  @apply dark:bg-gray-900 dark:text-gray-50;
}
</style>
