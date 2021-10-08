
fun main() {

//    var name1: String = "Николай"
//    var surname1 = "Иванов"
//    var age1 = 16
//
//    var name2 = "Иванов"
//    var surname2 = "Николай"
//    var age2 = 17
//
//    var name3 = "Петров"
//    var surname3 = "Николай"
//    var age3 = 16


//    println("$name1,  $surname1,  $age1")

    var person1 = Person()
    person1.name = "Иван"
    person1.surname = "Николаев"
    person1.age = 16
    person1.show()

    var person2 = Person()
    person2.name = "Николай"
    person2.surname = "Иванов"
    person2.age = 19
    person2.greeting("Привет!")
    person2.takeLoan("Berbank")

    var person3 = person1.clone()
    person3.name = "Вася"
    person3.show()
    person1.show()

    var notebooksToCheck = ArrayList<Notebook>()

    for (i in 1..2){
        var note = Notebook()
        note.setData(i)
        notebooksToCheck.add(note)
    }

    person3.checkNotebooks(notebooksToCheck)

//    var note1 = Notebook()
//    note1.setData()
//    note1.showInfo()
//
//    person3.checkNotebook(note1)



}

class Notebook {
    var brand: String = ""
    var model: String = ""
    var screenDiagonal: Float = 0.0f
    var proc: String = ""
    var ram: Int = 0
    var capacity: Int = 0

    fun showInfo(){
        println("$brand, $model, $screenDiagonal, $proc, $ram, $capacity")
    }

    fun setData(id: Int){
        println("Укажите брэнд ноутбука $id")
        brand = readLine().toString()
        println("Укажите модель ноутбука")
        model = readLine().toString()
        println("Укажите диагональ?")
        screenDiagonal = readLine().toString().toFloat()
        println("Укажите название процессора")
        proc = readLine().toString()
        println("Сколько оперативной памяти")
        ram = readLine().toString().toInt()
        println("Обьем внутренней памяти")
        capacity = readLine().toString().toInt()
    }
}

class Person{
    var name: String = ""
    var surname: String = ""
    var age: Int = 0
    var count: Int = 0

    fun checkNotebooks(comps: ArrayList<Notebook>){
        for (curComp in comps){
            checkNotebook(curComp)
        }

        if (count == 0){
            println("Сегодня не ваш день :(")
        }
    }

    fun checkNotebook(comp: Notebook){
        if (comp.ram >= 16 && comp.screenDiagonal >= 15.0f  || comp.brand == "Apple"){
            println("Вам подходит модель ${comp.model} ${comp.brand}")
            count += 1
        }
    }

    fun show(){
        println("$name, $surname, $age")
    }

    fun greeting(word: String){
        println("$word, $name")
    }

    fun takeLoan(bankName: String){
       if (age>= 18) {
           println("банк $bankName готов Вам выдать кредит!")
       } else{
            print("Вы пока не можете брать кредит!")
       }
    }

    fun clone(): Person{
        var newPerson = Person()
        newPerson.name = name
        newPerson.surname = surname
        newPerson.age = age
        return newPerson
    }
}

