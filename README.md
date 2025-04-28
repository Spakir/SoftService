# Инструкция по сборке и запуску кода

### 1.Требования

    * JDK версии 17 или выше.
    * Apache Maven.
    * IDE (IntelliJ IDEA, Eclipse).

### 2. Клонирование репозитория

    * Клонировать репозиторий можно командой: git clone https://github.com/Spakir/SoftService.git

### 3. Настройка среды разработки   

1. Откройте проект в выбранной IDE.
2. Убедитесь, что Maven зависимости загружены корректно:
   * В IntelliJ IDEA: File > Invalidate Caches / Restart.
   * Запустите команду Maven для очистки и обновления зависимостей: mvn clean install

### 4.  Запуск приложения
1. Соберите и запустите приложение: mvn spring-boot:run
2. После запуска приложения Swagger UI будет доступен по адресу: http://localhost:8080/swagger-ui/index.html