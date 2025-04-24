# N-th Minimum API (Spring Boot + Swagger)

Небольшой REST-сервис на Java/Spring Boot, который:

- Принимает путь к `.xlsx`-файлу и число `N`
- Читает первый столбец Excel-файла с целыми числами
- Возвращает **N-й по величине минимум** (учитывая дубликаты)
- Работает **без встроенной сортировки** (используется max-heap)

---

## 🚀 Быстрый старт

```bash
mvn clean install
mvn spring-boot:run
Swagger UI: http://localhost:8080/swagger-ui/index.html

📌 Пример запроса
http
Копировать
Редактировать
GET /api/nth-min?path=C:/example.xlsx&n=3
Ответ:

json
Копировать
Редактировать
{
  "value": 4
}
⚠️ Обработка ошибок

Код	Сценарий	Ошибка
404	Файл не найден	FileNotFoundAppException
400	N выходит за допустимые границы	InvalidNAppException
500	Ошибка чтения файла или системная ошибка	Общее исключение
✅ Тесты
bash
Копировать
Редактировать
mvn test
Покрытие:

ExcelReaderTest — чтение Excel-файлов

NumberServiceTest — бизнес-логика

MinControllerTest — HTTP-эндпоинт (MockMvc)

🛠 Технологии
Java 17

Spring Boot 3.2.5

Apache POI — чтение Excel

Swagger / OpenAPI 3

JUnit 5 + MockMvc

📂 Структура проекта
css
Копировать
Редактировать
src
├── main
│   ├── java
│   │   └── com.grishyin.nth_min_service
│   │       ├── controller
│   │       ├── service
│   │       ├── util
│   │       └── exception
│   └── resources
└── test
    ├── java
    └── resources
✍️ Автор
Григорий
GitHub: @HaroshiyGrigoriy
