package ar.edu.unahur.obj2.socios

abstract class EstadoDeAnimo() {
    abstract fun propinaSegunEstadoDeAnimo(montoBase: Float, cliente: Cliente) : Float
}

class Enojado() : EstadoDeAnimo() {
    override fun propinaSegunEstadoDeAnimo(montoBase: Float, cliente: Cliente) = 0f
}

class Feliz() : EstadoDeAnimo() {
    override fun propinaSegunEstadoDeAnimo(montoBase: Float, cliente: Cliente) = (montoBase * 1.25).toFloat()
}

class Indiferente() : EstadoDeAnimo() {
    override fun propinaSegunEstadoDeAnimo(montoBase: Float, cliente: Cliente) = cliente.plata
}

class Resfriado() : EstadoDeAnimo() {
    override fun propinaSegunEstadoDeAnimo(montoBase: Float, cliente: Cliente) = montoBase * 2
}