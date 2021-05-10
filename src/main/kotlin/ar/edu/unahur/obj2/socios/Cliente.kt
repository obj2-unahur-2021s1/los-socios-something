package ar.edu.unahur.obj2.socios

class pedido(var cliente: Cliente, var monto: Float) {
    fun propina() = cliente.propinaQueDeja(monto)
}


class Cliente(var estadoDeAnimo: EstadoDeAnimo, var barrio: Barrio) {
    fun propinaQueDeja(monto: Float) {

    }
}


abstract class EstadoDeAnimo() {

}


abstract class Barrio() {

}

