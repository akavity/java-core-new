**Project 'Producer-Queue-Consumer'**
Решение проекта реализовано в пакете **producer_queue_consumer**.

task 1
Реализовать поток **Producer** бесконечно считывающий целые числа, которые пользователь вводит в **Standard Input**.
task 2
Поток **Producer** сохраняет целые числа в **Queue**.
task 3
При вводе -1 поток Producer завершает свою работу.

Solution 
Решение реализовано в пакете **supplier** классом **Producer**. 

task 4
Когда пользователь вводит некорректные данные, то поток **Producer** бросает исключение **UserInputException**, 
но при этом продолжает работать.

Solution
Добавлен пакет **exceptions**, содержащий класс **UserInputException**.

Specification of task 5
Реализовать поток **Consumer**, который забирает числа из Queue и засыпает на количество секунд равное этому числу. 
При этом засыпание потока **Consumer** происходит в том порядке, в котором значения целых чисел были введены пользователем.

Solution
Решение реализовано в пакете **job** классом **Consumer**. 

task 6
После того как поток **Consumer** проснется, он выводит в File: 
${timestamp} - ${thread-name} - I slept ${seconds} seconds.
task 7
Когда у потока **Consumer** нет текущих задач, то он выводит в File: 
${timestamp} - ${thread-name} - ... и засыпает на 1 секунду.

Solution
Решение реализовано в пакете **utils** классом **FileUtil**. 

task 8
Добавить несколько потоков **Consumer**.

Solution
Решение реализовано в  **test/java/home_work_1/producer_queue_consumer** классом **Demo1**. 

**Project 'Backup utility'**
Реализовать утилиту для резервного копирования директории.

Solution
Решение проекта реализовано в пакете **backupUtility**.
Добавление файлов в очередь реализовано в пакете **supplier** классом **FileMarker**.
Копирование файлов в резервную папку реализовано в пакете **supplier** классом **DirectoryCreator**.
В **test/java/home_work_1/backupUtility** в класск Demo1 реализовано добавление нескольких
потоков **DirectoryCreator**.