# TAandFL
my labs and pracs

Lab1 - Есть вводи вывод. На вооде нужно ввести выражение состоящие из цифр(также дробных, разделять дробную часть запятой), поставить знак сложения,вычитания, умножения и деления.
Числа можно закрывать в скобки. Проверка реализована через подсчитывание того, одинаково ли количество открытий и закрытий скобок
Для завершения выражения, нужно поставить знак равенства и дать конечное число, а также написав ; (по условию лабы это конец выражения, 
значит все, что пойдет после него, будет идти в следующее выражение (может принимать много выражений)
пример ввода : (((13-35,53)*43,43)-35)=43,3556; 
Программа отправит на провергу по reg ex грамматики, после чего посчитает скобочки, если все хорошо, то пойдет в лексер, который я на момент
реализации первой лабе сделал на языке JS запускаемым из Java кода (это оба языка Oracle и они прекрасно работают дург с другом через JDK)


Каждая практика это практика №X+1, потому что первая практика не будет находиться на гитхабе.
Prac1 - нахождение знаков степеней. Тоже по вводу-выводу. Тоже регулярным выражением. 
Пример ввода : 234^23434^23442^4343^43243

С данного момента ввод будет через String string для скорости тестировки. Могу сделать ввод, если это будет необходимо, мне 
просто было удобнее редактировать значение строки. Быстрее проходило.(Scanner и любые ридеры в Java по определению являются очень
медленными, на фоне других языков программировани, я этому убидился когда пытался получить стажировку в Яндекс, а мои программы
не успевали за 0,25 секунд срабатывать)

Prac2 - там был непонятный язык, я погуглил, и решил что это Bash. мне не очень понятно было как этот язык должен выглядеть,
так что я решил написать регулярное выражение проверяющее грамматику Bash loops'ов (while done) Выражение ищет нужную
последовательность. Ему нужно, чтобы человек написал while, может перед ним или после него ставить пробелы, как в языке
программирования практически. (могу показать как это выглядит на веб сайте одном, по которому я научился писать
регулярные выражения) и дальше соответственно необходимые скобки, statment для loops, начало цикла и конец (внутренности цикла
игнорируются, ибо иначе это во-первых не по заданию, во-вторых будет тянуть на анализатор языка программирования Bash, что
является очень тяжелой и высокооплачиваемой работой в том же JetBrains) 
Ввода нет, вместо него поле String string, т.к. вводить в среду разработки в терминал код на bash сложно 
и не практично. каждое новое выражение будет выделяться надписью NEW EXRPESSION (НОВОЕ ВЫРАЖЕНИЕ)

Prac3- первое появление некой рекусрисвной части регулярко. Там просто идут в ряд числа и знак сложения, их может быть от 
двух до бесконечности. Опять же на регулярках все, дальше я как раз научился очень умело делать лексеры на Java при помощи
matcher.group . Там по условиям ищет групу число, группу плюс, и еще одну группу число (издержки разработки, т.к. иначе нельзя 
дать порог "от двух чисел") Тем не менее это не мешает человеку видеть конечный лексический разбор.

Prac4 - по сути все тоже самое, но теперь у нас числа могут быть отрицательными, могут быть минус, умножить, делить, плюс
и идет лексический разбор этого добра. Здесь уже group 1 только числа, потому что я додумался писать второе регулярное выражение
для лексического разбора грамматически верного выражения. 

Prac5 калькулятор. Все тоже самое, но теперь считает. Как это получилось? Лексический разбор позволяет мне поэтапно отобрать
числа и знаки, а я их ложу в лист (по-моему мнению, лист гораздо удобнее массивов в Java. Я в целом недоволен очень работе
с массивами в Java, именно из-за этого в первой лабе принял решение писать Lexer на JS). В общем потом, после синаксического разбора
из calc начинает разбор Листа, который смотрит, если число, то парсит его в int, и и записывает в ответ, если оно отрицательное,
то записывает в int число и домножает на -1 (т.к. язык программирования в листе уже разделил отрицательный знак на отдельный
элемент листа) Потом на каждом этапе, он видя, что у нас идет действие, начинает проводить его, для запарсеного интеджера предыдущего
знаичения с последующим число(элементом массива, т.к. грамматику проверили уже два шага назад, она корректна)

Prac6 -  это хэш таблица для идентефикаторов. Я даже постарался сделать так, чтобы на выводе была реально таблица.
Считал количество пробелов и писа "___" и "|" чтобы отделять строчки и столбцы. Как и в второй практике, каждое новое выражение будет
выделяться надписью NEW EXRPESSION (НОВОЕ ВЫРАЖЕНИЕ)

Lab2 - надо разбораться немного пока что от меня нужно. По существу YACC не делает ничего такого, чего я просто еще не сделал 
до этого сам на Java (по крайней мере из примера, который был указан в методичке). Только файл читает, но я тоже могу buffreader
подрубить просто. 
