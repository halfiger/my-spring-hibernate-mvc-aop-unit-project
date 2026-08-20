# 🧪 Практика №2 — Car

Твоє завдання — створити невеликий 
CRUD для автомобілів.

# 1. Entity

Створити:

com.example.entity.Car

Поля:

id
brand
model
year
price

Вимоги:

@Entity
таблиця БД повинна називатися cars
id — primary key
автоматична генерація id
no-args constructor
getters/setters
toString()

Типи полів обери сам.

Тут я навмисно вже не кажу тобі, який тип 
використовувати.

2. DAO

Створити:

CarDAO
CarDAOImpl

CRUD:

findAll()
findById()
save()
update()
deleteById()

DAO повинен працювати через:

SessionFactory
↓
getCurrentSession()
↓
Hibernate

Для findAll() використати HQL.

3. Service

Створити:

CarService
CarServiceImpl

Методи:

findAll()
findById()
save()
update()
deleteById()

Service повинен бути Spring bean і працювати в транзакції.

4. Controller

Створити:

CarController

Не даю готові mappings. Придумай їх сам.

Контролер повинен поддержувати:

Список

Показать все автомобили.

Один автомобиль

Открыть автомобиль по id.

Создание

Показать форму → отправить форму → сохранить → показать созданный автомобиль.

Обновление

Открыть существующий автомобиль → изменить → сохранить изменения → показать обновленный автомобиль.

Удаление

Удалить автомобиль → вернуться к списку.

5. JSP

Потрібно мінімум:

cars.jsp
car.jsp
car-form.jsp
cars.jsp

Показує:

ID | Brand | Model | Year | Price

і має посилання:

Show
Update
Delete

та:

Create new car
car.jsp

Показує один автомобіль.

car-form.jsp

Одна форма повинна працювати і для CREATE, і для UPDATE.

Тобто можеш повторити нашу ідею з:

info
url
modelAttribute

але цього разу спробуй відновити її сам.

6. Головна умова

Ось тут починається справжня практика.

Не відкривай User і Book, поки не спробуєш.

Твоє завдання:

Car
↓
CarDAO
↓
CarDAOImpl
↓
CarService
↓
CarServiceImpl
↓
CarController
↓
JSP
↓
MySQL

Повинен працювати повний:

CREATE
READ
UPDATE
DELETE
І ще одна маленька пастка

Я спеціально не написав, який Hibernate-метод використовувати для кожної операції.

Ти повинен сам згадати:

save   → ?
update → ?
delete → ?
find   → ?
findAll → ?

Оце вже буде хорошим тестом того, чи persist(), merge(), get() і HQL почали ставати твоїми інструментами, а не просто словами з нашого конспекту.

Відпочинь. Потім Car з нуля — і не поспішай. Якщо десь зависнеш, не дивись одразу старий код: спочатку спробуй відновити конструкцію сам. Це зараз набагато цінніше за швидкість.