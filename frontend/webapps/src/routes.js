import Index from '@/pages/index.vue';
import NotFound from '@/pages/not-found.vue';
import Txn001Home from '@/pages/txn001/txn001_home.vue';
import Txn001Confirm from '@/pages/txn001/txn001_confirm.vue';
import Txn001Result from '@/pages/txn001/txn001_result.vue';

export const routes = [
  { path: '/txn001_home', component: Txn001Home },
  { path: '/', component: Index },
  { path: '/:path(.*)', component: NotFound },
  {
    path: '/txn001',
    component: Txn001Home,
    name: 'txn001-home',
  },
  {
    path: '/txn001/confirm',
    component: Txn001Confirm,
    name: 'txn001-confirm',
  },
  {
    path: '/txn001/result',
    component: Txn001Result,
    name: 'txn001-result',
  },
];

export default routes;
