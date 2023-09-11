# Homework


В рамках БД интернет-магазин напишите след/запросы:

Вывести названия товаров от 50 до 500 EUR

```javascript
db.products.find(
    { price: { $gte: 50, $lte: 500 } },
    { _id: 0 }
)
```

Применить скидку в размере 10% к товарам от 50 EUR

```javascript
db.products.updateMany(
    { price: { $gte: 50} }, //filter
    { $mul: { price: 0.9} } //action
)
```

Применить ко всем товарам наценку в размере 5%

```javascript
db.products.updateMany(
    { }, //filter
    { $mul: { price: 1.05} } //action
)
```
Заблокировать юзеров не из USA

```javascript
db.users.updateMany(
    { country: { $ne: "USA" } },
    { $set: { isBlocked: true } } // action
)

```

Вывести имена незаблокированных юзеров 

```javascript
db.users.find(
   { isBlocked: false },
   { _id: 0, isBlocked: 0, country: 0}
)

```

