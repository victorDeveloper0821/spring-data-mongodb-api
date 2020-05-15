# spring-data-mongodb-api

description:作為mongodb、spring-boot介接練習，將這個專案主要會員API作為練習主題

tech stack:
- spring boot
- spring-data-mongo
- mongodb

***

# api format以及執行畫面

format : {status:狀態為ok或fail,results:如果fail回傳空陣列，反之為真正的結果}


> 新增會員
> URL : /mongo/api/user/create
> ![新增會員](https://github.com/victorlikecode/spring-data-mongodb-api/blob/master/readme/create.png)

> 修改會員
> URL : /mongo/api/user/update/{_id}
> ![更新會員by objectId](https://github.com/victorlikecode/spring-data-mongodb-api/blob/master/readme/update.png)

> 刪除會員
> URL : /mongo/api/user/delete/{_id}
> ![刪除會員by objectId](https://github.com/victorlikecode/spring-data-mongodb-api/blob/master/readme/delete_successful.png)

> 查詢單一會員
> URL : /mongo/api/user/find/One/{_id}
> ![查詢單一會員](https://github.com/victorlikecode/spring-data-mongodb-api/blob/master/readme/findOne.png)


> 列出全部會員
> URL : /mongo/api/user/list
> ![列出全部會員](https://github.com/victorlikecode/spring-data-mongodb-api/blob/master/readme/findAll.png)

# 之後的規劃
- 增加JWT的API驗證
- 改善現有的格式
