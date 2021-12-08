package com.deniskharlamov.internship_multithreading.hippodrome;

public class The_task {

	/*
	 * Задание 1 Сегодня мы напишем небольшую игру под названием "Ипподром". Когда я
	 * говорю мы - я имею ввиду тебя. Я же буду работать наставником.
	 * 
	 * Для начала нам понадобятся классы "ипподром" и "лошадь". Создай классы
	 * Hippodrome (ипподром), Horse(лошадь)
	 * 
	 * 
	 * Задание 2 Любая программа начинается с выполнения метода main. Добавь метод
	 * main в класс Hippodrome.
	 * 
	 * 
	 * Задание 3 Раз это ипподром, то на нем должны быть лошади. А, значит наш
	 * ипподром должен хранить список всех его лошадей. Добавь переменную horses
	 * типа ArrayList<Horse> в класс Hippodrome. Добавь getter для этого поля.
	 * 
	 * 
	 * Задание 4 Теперь вернемся к лошадям. У каждой лошади на скачках должны быть
	 * известны имя(name) и скорость(speed). Наши лошади будут бежать просто
	 * определенное время (100 секунд/"шагов"). Будем определять победителя, как
	 * лошадь, пробежавшая наибольшую дистанции.
	 * 
	 * Поэтому нам понадобится хранить расстояние(distance), которое лошадь уже
	 * пробежала. Добавь в класс Horse переменные name (String), speed (double),
	 * distance(double).
	 * 
	 * 
	 * Задание 5 Закончим написание класса "лошадь" Добавь конструктор с параметрами
	 * (name, speed, distance). Добавь getter'ы и setter'ы для всех полей класса
	 * Horse. Делай все методы public, если явно не указано обратное.
	 * 
	 * 
	 * Задание 6 Теперь перейдем к методу main. Нам нужно создать в нем объект
	 * класса Hippodrome и добавить ему несколько лошадей.
	 * 
	 * Для начала: Создай статическую переменную game типа Hippodrome. Должно
	 * получиться что-то вроде: public static Hippodrome game;
	 * 
	 * В методе main надо: а) Создать объект типа Hippodrome и сохранить его в
	 * переменную game. б) Создать три объекта "лошадь". Имена придумай сам.
	 * Начальные скорость у всех лошадей - 3, дистанция - 0. в) Добавить созданных
	 * лошадей в список лошадей ипподрома (horses).
	 * 
	 * 
	 * Задание 7 Но и это еще не все - надо чтобы лошади бежали. Добавь в класс
	 * Hippodrome методы run, move и print. Без параметров. Метод move будет
	 * управлять движением всех лошадей. Метод print отрисовывать их на экран. А
	 * метод run - управлять всем этим.
	 * 
	 * 
	 * Задание 8 В методе run сделай цикл от 1 до 100. Это и будет наш забег. В теле
	 * цикла вызываем сначала move, затем print. Что-то весь цикл не отработал за
	 * долю секунды - добавь в него еще Thread.sleep(500);
	 * 
	 * 
	 * Задание 9 Теперь вернемся к методам move и print. Начнем с move. В методе
	 * move класса Hippodrome в цикле у каждой лошади мы вызываем метод move.
	 * 
	 * Да ты прав, его еще нет у класса Horse. Поэтому в класс Horse надо добавить
	 * свой метод move :) И метод print, кстати тоже. Если я не говорю ничего насчет
	 * параметров метода, значит метод без параметров. Делай все методы public, если
	 * явно не указано обратное.
	 * 
	 * 
	 * Задание 10 Еще нужно написать метод print класса Hippodrome. В нем тоже все
	 * просто: в цикле для каждой лошади вызываем ее метод print. Ну, и еще выведи
	 * после цикла пару пустых строк: System.out.println() - чтобы было красивее.
	 * 
	 * 
	 * Задание 11 С классом Hippodrome почти закончили. Добавь в конец метода main
	 * вызов run().
	 * 
	 * 
	 * Задание 12 Осталось совсем немного - дописать класс Horse. Каждый ход у
	 * лошади будет вызываться метод move. Когда у лошади вызывают метод move,
	 * лошадь должна пробежать некоторую дистанцию. Дистанция зависит от скорости
	 * лошади (speed). В самом простом варианте, выглядеть этот метод должен
	 * примерно так: distance += speed;
	 * 
	 * Но, чтобы было интереснее, давай сделаем так, чтобы скорость все время
	 * немного менялась. Для этого умножь speed на случайное число. Случайное число
	 * можно получить с помощью метода Math.random()
	 * 
	 * 
	 * Задание 13 Теперь вернемся к методу print класса Horse. Т.к. мы работаем с
	 * консолью, то все лошади на бегах будут выглядеть примерно так: ........Sleven
	 * <- лошадь Слевин ....Lucky <- лошадь Лаки ..........Gomer <- лошадь Гомер
	 * 
	 * Другими словами, в методе print надо вывести на экран строку состоящую из
	 * точек и имени лошади. Количество точек равно distance, округленному до целого
	 * числа.
	 * 
	 * 
	 * Задание 14 Запускаем и любуемся. У нас каждые полсекунды отображается новый
	 * кадр с ситуацией на ипподроме. Мышкой уменьши размер консоли так, чтобы был
	 * виден только один "кадр" и на том же самом месте. Тогда можно наблюдать забег
	 * в живую и даже покомментировать: - Старт. - Гомер неожиданно обходит Лаки. -
	 * Слевен вырывается вперед. - Вперед Лаки! - 10 баксов на Слевина. - Похожу
	 * Лаки сбросил жокея и расслабился. - Гомер уверенно вырывается вперед. -
	 * Неожиданно для всех побеждает Гомер. Вот это номер!
	 * 
	 * 
	 * Задание 15 Добавим определение победителя. В классе Hippodrome сделаем два
	 * метода: public Horse getWinner() и public void printWinner()
	 * 
	 * Метод getWinner должен возвращать лошадь пробежавшую самую большую дистанцию.
	 * Метод printWinner выводит на экран имя победителя в виде: Winner is <NAME>!
	 * Пример: Winner is Lucky!
	 * 
	 * 
	 * Задание 16 Теперь уже точно все. Добавь вызов метода printWinner в конец
	 * метода main. Запускай и любуйся своей первой компьютерной игрой :)
	 * 
	 */
}
