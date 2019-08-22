package domain.order

import domain.billing.Payment
import domain.customer.Address
import domain.customer.Customer
import domain.product.Product
import java.util.*

class Order(val id : Int, val customer: Customer, val address: Address) {

    val items = mutableListOf<OrderItem>()
    var closedAt: Date? = null
        private set
    var payment: Payment? = null
        private set
    val totalAmount
        get() = items.sumByDouble { it.total }

    fun addProduct(product: Product, quantity : Int) {
        var productAlreadyAdded = items.any { it.product == product }
        if (productAlreadyAdded)
            throw Exception("The product have already been added. Change the amount if you want more.")

        items.add(OrderItem(product, quantity, id))
    }

    fun pay(payment : Payment) {
        if (this.payment != null)
            throw Exception("The order has already been paid!")

        if (items.count() == 0)
            throw Exception("Empty order can not be paid!")

        this.payment = payment

        close()
    }

    private fun close() {
        closedAt = Date()
        items.forEach { it.close() }
    }
}