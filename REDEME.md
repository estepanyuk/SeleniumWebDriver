Зависмости котрые используються в проекте:
• selenium-java – Selenium WebDriver для Java
• junit-jupiter – тестовый фреймворк Junit 5
• webdrivermanager – библиотека для управления
драйверами браузером WebDriver Manager
• selenide – готовый тестовый фреймворк

## Cтруктура проекта
```bash
.
├── README.md
├── pom.xml
├── src
│   └── test
│       └── java
│           └── org
│               └── example
│                   ├── page
│                   │   ├── BasePage.java //Родительский класс для всех страниц
│                   │   └── RandomNumberPage.java //Класс для страницы PracticeForm
│                   └── test
│                       ├── BaseTest.java //Родительский класс для тестов
│                       └── PracticeFormTest.java //Класс для тестов со страницы PracticeForm
```