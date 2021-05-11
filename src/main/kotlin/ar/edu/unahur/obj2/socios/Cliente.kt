package ar.edu.unahur.obj2.socios

class Pedido(val cliente: Cliente, val monto: Float) {
    fun propina() = cliente.calcularPropina(monto)
}


class Cliente(var estadoDeAnimo: EstadoDeAnimo, var barrio: Barrio, var plata: Float) {
    fun calcularPropina(montoBase: Float) : Float {
        return estadoDeAnimo.propinaSegunEstadoDeAnimo(montoBase, this)
    }
}
