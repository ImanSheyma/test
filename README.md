# Описание таблиц в БД
Office:
  id,
  country,
  city,
  address

Employee:
  id,
  firstname,
  lastname,
  email,
  office_id

Таблица Employee связана с таблицей Office в отношении many-to-one

# Функциональность
- Просмотр списка всех офисов или работников
- Просмотр списка работников по офису
- Добавление записи в таблицу office/employee
- обновление записи в таблице office/employee
- Удаление записи из таблицы office/employee
  
 # Запуск
 подтяните docker image postgres : docker pull postgres
 при запуске приложения автоматически будет запущен контейнер с бд и будут добавлены тестовые записи в бд
