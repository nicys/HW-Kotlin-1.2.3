const val BASE_DISCOUNT = 5
const val USER_DISCOUNT = 1

fun main(args: Array<String>) {
    // Все деньги в Инте (в копейках)
    val totalLastPurchase = 1_800_000 // Стоимость предыдущих покупок
    val currentPurchase = 300_560 // Стоимость текущей покупки
    val meloman = true

    val baseDiscount = amountBaseDiscount(totalLastPurchase, currentPurchase)
    val userDiscount = amountUserDiscount(meloman, currentPurchase, baseDiscount)
    val toBePaid = currentPurchase - baseDiscount - userDiscount

    println("\t\t\t\tЧек покупки:" +
            "\n\tСтоимость покупки: ${currentPurchase / 100}руб. ${currentPurchase % 100}коп." +
            "\n\t*Сумма основной скидки: ${baseDiscount / 100}руб. ${baseDiscount % 100}коп." +
            "\n\t*Сумма дополнительной скидки: ${userDiscount / 100}руб. ${userDiscount % 100}коп." +
            "\n\tК оплате: ${toBePaid / 100}руб. ${toBePaid % 100}коп.")
}

fun amountUserDiscount(meloman: Boolean, currentPurchase: Int, baseDiscount: Int): Int {
    return if (meloman) {
        (currentPurchase - baseDiscount) * USER_DISCOUNT / 100
    } else {
        0
    }
}

fun amountBaseDiscount(totalLastPurchase: Int, currentPurchase: Int): Int {
    return when (totalLastPurchase) {
        in 0 until 100_100 -> 0
        in 100_100..1_000_000 -> 10_000
        else -> currentPurchase * BASE_DISCOUNT / 100
    }
}