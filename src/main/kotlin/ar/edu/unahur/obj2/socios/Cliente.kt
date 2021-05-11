package ar.edu.unahur.obj2.socios

import kotlin.math.max

class Pedido(val cliente: Cliente, val montoPedido: Float) {
    fun propina() = cliente.calcularPropina(montoPedido)
}

class Cliente(var estadoDeAnimo: EstadoDeAnimo, var barrio: Barrio, var dineroEnBolsillo: Float) {
    fun calcularPropina(montoPedido: Float) : Float {
        return barrio.propinaPorBarrio(estadoDeAnimo, montoPedido, dineroEnBolsillo)
    }
}

abstract class EstadoDeAnimo() {
    abstract fun propinaPorAnimo(montoPedido: Float, dineroEnBolsillo: Float) : Float
}

object Enojado : EstadoDeAnimo() {
    override fun propinaPorAnimo(montoPedido: Float, dineroEnBolsillo: Float) = 0f
}
object Feliz : EstadoDeAnimo() {
    override fun propinaPorAnimo(montoPedido: Float, dineroEnBolsillo: Float) = (montoPedido * 0.25).toFloat()
}
object Indiferente : EstadoDeAnimo() {
    override fun propinaPorAnimo(montoPedido: Float, dineroEnBolsillo: Float) = dineroEnBolsillo
}
object Resfriado : EstadoDeAnimo() {
    override fun propinaPorAnimo(montoPedido: Float, dineroEnBolsillo: Float) = montoPedido
}

abstract class Barrio() {
    abstract fun propinaPorBarrio(estadoDeAnimo: EstadoDeAnimo, montoPedido: Float, dineroEnBolsillo: Float) : Float
}

object LasRosas : Barrio() {
    override fun propinaPorBarrio(estadoDeAnimo: EstadoDeAnimo, montoPedido: Float, dineroEnBolsillo: Float) =
        estadoDeAnimo.propinaPorAnimo(montoPedido, dineroEnBolsillo) + 50f
}
object LasLauchas : Barrio() {
    override fun propinaPorBarrio(estadoDeAnimo: EstadoDeAnimo, montoPedido: Float, dineroEnBolsillo: Float) =
        estadoDeAnimo.propinaPorAnimo(montoPedido, dineroEnBolsillo) / 2
}
object BarrioVerde : Barrio() {
    override fun propinaPorBarrio(estadoDeAnimo: EstadoDeAnimo, montoPedido: Float, dineroEnBolsillo: Float) =
        max(200f, estadoDeAnimo.propinaPorAnimo(montoPedido, dineroEnBolsillo))
}
object LasTorres : Barrio() {
    override fun propinaPorBarrio(estadoDeAnimo: EstadoDeAnimo, montoPedido: Float, dineroEnBolsillo: Float) =
        estadoDeAnimo.propinaPorAnimo(montoPedido, dineroEnBolsillo)
}