package ar.edu.unahur.obj2.socios

import kotlin.math.min

class Pedido(val cliente: Cliente, val montoPedido: Float) {
    fun propina() = cliente.propinaQueDeja(montoPedido)
}

class Cliente(var estadoDeAnimo: EstadoDeAnimo, var barrio: Barrio, var dineroEnBolsillo: Float) {
    fun propinaQueDeja(montoPedido: Float) : Float {
        return barrio.propinaPorBarrio(estadoDeAnimo)
    }
}

abstract class EstadoDeAnimo() {
    abstract fun propinaPorAnimo(montoPedido: Float) : Float
}

object Enojado : EstadoDeAnimo() {
    override fun propinaPorAnimo(montoPedido: Float) = 0f
}
object Feliz : EstadoDeAnimo() {
    override fun propinaPorAnimo(montoPedido: Float) = (montoPedido * 0.25).toFloat()
}
object Indiferente : EstadoDeAnimo() {
    override fun propinaPorAnimo(montoPedido: Float) = dineroEnBolsillo
}
object Resfriado : EstadoDeAnimo() {
    override fun propinaPorAnimo(montoPedido: Float) = montoPedido
}

abstract class Barrio() {
    abstract fun propinaPorBarrio(estadoDeAnimo: EstadoDeAnimo) : Float
}

object LasRosas : Barrio() {
    override fun propinaPorBarrio(estadoDeAnimo: EstadoDeAnimo) = estadoDeAnimo.propinaPorAnimo(montoPedido) + 50
}
object LasLauchas : Barrio() {
    override fun propinaPorBarrio(estadoDeAnimo: EstadoDeAnimo) = estadoDeAnimo.propinaPorAnimo(montoPedido) / 2
}
object BarrioVerde : Barrio() {
    override fun propinaPorBarrio(estadoDeAnimo: EstadoDeAnimo) = min(estadoDeAnimo.propinaPorAnimo(montoPedido), 200)
}