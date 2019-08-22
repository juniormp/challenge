package domain.order

import domain.billing.PaymentMethod

class CreditCard (val number: String) : PaymentMethod {
}