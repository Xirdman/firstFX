Есть две задачки (во вложении), их нужно реализовать отдельными классами и написать пользовательский интерфейс(GUI) к ним.

GUI:

• Поле ввода условий, • Поле вывода результата, • Combobox с выбором задачи, • Кнопки: Посчитать, Сохранить, Загрузить.

При нажатии на «Сохранить»: сохраняет в текстовый файл данные из поля ввода и тип задачи. При нажатии на «Загрузить»: вызывает диалоговое окно с выбором файла и при выборе загружает данные и считает.

Работу с файлом отдельным классом. Комментарии там, где это нужно.

Задача 1 Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.

Example 1:

a1 = ["arp", "live", "strong"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns ["arp", "live", "strong"]

Example 2:

a1 = ["tarp", "mice", "bull"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns []

Beware: r must be without duplicates.

Задача 2 Write Number in Expanded Form

You will be given a number and you will need to return it as a string in Expanded Form. For example:

expanded(12); # Should return "10 + 2" expanded(42); # Should return "40 + 2" expandedm(70304); # Should return "70000 + 300 + 4" NOTE: All numbers will be whole numbers greater than 0.
