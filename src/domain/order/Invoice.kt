package domain.order

import domain.customer.Address

class Invoice(private val order: Order) {
    val billingAddress: Address = order.address
    val shippingAddress: Address = order.address
}