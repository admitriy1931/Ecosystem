# Ecosystem
 
Автор: Агафонов Дмитрий

Описание:
Cимулятор экосистемы в который пользователи могут добавлять различные виды растений и животных, а так - же прогнозировать будущую численность конкретного вида с помощью логистической модели роста(учитывается вместимость экосистемы, доступность ресурсов, скорость размножения, а так-же соотношение мужских и женских особей в случае животных видов).

Программа состоит из нескольких компонент:

Абстрактный класс Organizm - задает поля и методы присущие как растениям, так и животным.

Классы Animal и Plant

Класс Ecosystem - инициализация ресурсов, добавление растений и животных, так - же в нем реализована логика логистической модели роста.

FileHandler - в нем реализованы методы для чтения и записи в файл(используется BufferedWriter и BufferedReader).

EcosystemScanner - реализована логика для работы с консолью.

Так - же имеются классы для unit - тестов.

Пример запуска:
java -jar [Путь до jar - файла] - Откроется меню, в котором можно выбрать один из пунктов:
- Посмотреть доступные экосистемы - покажет список экосистем в текущей директории
- Загрузить экосистему - откроет раздел, в котором можно выбрать одну из уже созданных экосистем в текущей директории
- Создать новую экосистему - Откроет раздел, в котором после задания ресурсов экосистемы можно добавить животное/растение, посмотреть ресурсы/созданных растений/животных и предсказать число особей, сохранить созданную экосистему со всеми добавленными видами.
- Выйти
  
Пример:
Симулятор экосистемы

Выберите действие:
1. Создать новую экосистему
2. Загрузить экосистему
3. Посмотреть доступные экосистемы
4. Выйти
1
Введите имя экосистемы: 1
Введите емкость: 1
Введите доступность ресурсов (например, 1 для полной доступности): 1

Выберите действие:
1. Добавить растение
2. Добавить животное
3. Посмотреть ресурсы
4. Посмотреть растения
5. Посмотреть животных
6. Сохранить экосистему
7. Предсказать число особей
Нажмите 'm' для возврата в главное меню.

