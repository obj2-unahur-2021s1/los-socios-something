package ar.edu.unahur.obj2.socios

class pedido(var cliente: Cliente, var montoPedido: Float) {
    fun propina() = cliente.propinaQueDeja(montoPedido)
}


class Cliente(var estadoDeAnimo: EstadoDeAnimo, var barrio: Barrio, var dineroEnBolsillo: Float) {
    fun propinaQueDeja(montoPedido: Float) {
        return estadoDeAnimo.propinaPorAnimo(montoPedido) + barrio.propinaPorBarrio()
    }
}




abstract class EstadoDeAnimo() {
    abstract fun propinaPorAnimo(montoPedido: Float)
}

object Enojado : EstadoDeAnimo() {
    override fun propinaPorAnimo(montoPedido: Float) = 0
}
object Feliz : EstadoDeAnimo() {
    override fun propinaPorAnimo(montoPedido: Float) = montoPedido * 0.25
}
object Indiferente : EstadoDeAnimo() {
    override fun propinaPorAnimo(montoPedido: Float) = dineroEnBolsillo
}
object Resfriado : EstadoDeAnimo() {
    override fun propinaPorAnimo(montoPedido: Float) = montoPedido
}

abstract class Barrio() {
    abstract fun propinaPorBarrio()
}

object LasRosas : Barrio() {
    override fun propinaPorBarrio() = 50
}
object LasLauchas : Barrio() {
    override fun propinaPorBarrio() = 
}
