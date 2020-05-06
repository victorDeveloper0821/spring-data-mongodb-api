# spring-data-mongodb-api

description:作為mongodb、spring-boot介接練習，將這個專案主要會員API作為練習主題

tech stack:
- spring boot
- spring-data-mongo
- mongodb

***

# api format

format : {status:狀態為ok或fail,results:如果fail回傳空陣列，反之為真正的結果}


> 新增
> > url : /mongo/api/user/create

> 修改
> > url : /mongo/api/user/update/{_id}

> 刪除
> > url : /mongo/api/user/delete/{_id}

> 查詢單一
> > url : /mongo/api/user/find/One/{_id}

> 新增全部
> > url : /mongo/api/user/list
