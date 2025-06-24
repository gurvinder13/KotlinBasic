package com.example.kotlinbasicexp.higherOrderFn

/**
 * Checks if the provided email is valid using a dynamic validator.
 *
 * @param email The email address to validate.
 * @param checker A higher-order function that defines the validation logic.
 * @return True if the email passes the validation logic, false otherwise.
 */
fun validEmail(email: String, checker: (String) -> Boolean): Boolean {
    return checker(email)
}

/**
 * Represents a product with stock and discount information.
 *
 * @property id Unique product ID.
 * @property name Product name.
 * @property inStock Whether the product is currently in stock.
 * @property hasDiscount Whether the product has a discount.
 */
data class Product(
    val id: Long,
    val name: String,
    val inStock: Boolean,
    val hasDiscount: Boolean
)

/**
 * Processes the product by checking availability and applying discount logic.
 *
 * @param product The product to process.
 * @param discount A higher-order function that determines whether the discount should apply.
 * @param availableProduct A higher-order function that checks product availability.
 * @return True if the product is in stock and processed; false otherwise.
 */
fun productInStock(
    product: Product,
    discount: (Boolean) -> Boolean,
    availableProduct: (Boolean) -> Boolean
): Boolean {
    return if (availableProduct(product.inStock)) {
        println("Product '${product.name}' is in stock.")
        val isDiscount = discount(product.hasDiscount)
        println(if (isDiscount) "🎁 Discount available." else "ℹ️ No discount.")
        true
    } else {
        println("Product '${product.name}' is not in stock.")
        false
    }
}

/**
 * Demonstrates higher-order function usage in a real-world style.
 */
fun main() {
    val email = "gs@gmail.como"
    val isEmailValid = validEmail(email) { it.contains("@") && it.endsWith(".com") }
    println(if (isEmailValid) "Valid email" else "Invalid email")

    val product = Product(1, "Adidas Sneakers", inStock = true, hasDiscount = true)

    val result = productInStock(
        product,
        discount = { it },             // just return the Boolean directly
        availableProduct = { it }      // just return the Boolean directly
    )

    println("Final result: $result")
}
