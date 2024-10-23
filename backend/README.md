# smart-component-transaction-reliability-strategy

以為智能組件的可靠性交易策略

**主要機制**

- [ ] 功能啟動時由智能組件生成 txntoken，後送後由 Dispatcher 透過 GateService 啟用 txntoken
- [ ] 智能組件接收 prop txntoken，所有對後端請求都會帶上，確認智能組件是為那個功能提供服務
- [ ] 每個智能組件都會有對應的 GateService，負責接收 Dispatcher 的請求，並使用 txntoken 從 GateSession 取得/寫入 資料
  - [ ] 對應的 GateService 會在載入資料時把資料暫存在 GateSesion 中，供交易執行時驗證
- [x] 交易執行時同步驗證智能組件資料，執行時會透過 AOP 強制啟動各個智能組件的 GateService 驗證，如果有錯就會回 Excption

**非功能考量**

- [ ] 為何需要 activate txntoken？
  - 要確保每個智能組件的請求都是為了特定交易而執行

**智能組件**

- [ ] 與功能相關的智能組件
  - [x] 帳號(Account)
  - [x] 同意書(Agreement)
  - [x] 安全控管(Security)
- [ ] 與功能無關的智能組件
  - [ ] 廣告(Advertisement)
  - [ ] 最近消息(RecentMessage)
