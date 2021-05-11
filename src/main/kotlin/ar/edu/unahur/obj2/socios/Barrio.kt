package ar.edu.unahur.obj2.socios

abstract class Barrio() {
    abstract fun propinaSegunBarrio() : Float
}

class LasRosas() : Barrio() {
    override fun propinaSegunBarrio() = 50f
}