<p align='center'>
  <img src='https://repository-images.githubusercontent.com/442005408/3f8d7fed-9d3f-45c8-bcd5-0fa64e9ac535' alt='Vue.js starter template' width='600'/>
</p>

# Vue.js starter template

Features:

- 🛠 [Vue 3](https://v3.vuejs.org/guide/introduction.html)
- ⚡️ [Vite](https://vitejs.dev/guide/)
- 🛣 [Vue Router](https://github.com/vuejs/vue-router-next)
- 🔄 [Auto import](https://github.com/unplugin/unplugin-auto-import)
- 🎨 [Tailwind CSS](https://tailwindcss.com/docs/)
- 🔍 [Eslint with airbnb / Tailwind CSS / stylelint](https://github.com/airbnb/javascript)
- 🌗 [Light and dark mode composable](https://github.com/lecoueyl/vue3-template/blob/main/src/composables/theme.js)
- 🔡 [Inter var font](https://rsms.me/inter/)
- 📄 [Github pages action](https://pages.github.com)

[Open in Visual Studio Code](https://open.vscode.dev/lecoueyl/vue3-template)

## Getting Started

```sh
yarn
yarn dev
```

## Deployment

### Netlify

[![Deploy to Netlify](https://www.netlify.com/img/deploy/button.svg)](https://app.netlify.com/start/deploy?repository=https://github.com/lecoueyl/vue3-template)

### Github pages

The default github action will build to `gh-page` when pushing on `main` branch.

For a project page, the base path of the repository must be specified. Add the following secret in the Github repository `Settings` > `Secrets` > `Actions`

| Name                  | Value               |
| --------------------- | ------------------- |
| VITE_BASE_PUBLIC_PATH | `/repository-name/` |
