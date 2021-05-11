package ar.edu.unahur.obj2.socios

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ClienteTest : DescribeSpec({
  describe("Un/a cliente y un pedido") {
    val cliente1 = Cliente(Feliz, LasRosas, 600f)
    val pedido1 = Pedido(cliente1, 1000f)

    describe("Propina feliz en las rosas") {
      it("25% de 1000 + 50 = 300"){
        pedido1.propina().shouldBe(300f)
      }
    }
  }
  describe("Un/a cliente y un pedido v2") {
    val cliente2 = Cliente(Indiferente, LasLauchas, 500f)
    val pedido2 = Pedido(cliente2, 150f)

    describe("Propina indiferente en las lauchas") {
      it("500 / 2 = 250"){
        pedido2.propina().shouldBe(250f)
      }
    }
  }
  describe("Un/a cliente y un pedido v3") {
    val cliente3 = Cliente(Enojado, BarrioVerde, 400f)
    val pedido3 = Pedido(cliente3, 1500f)

    describe("Propina enojado en barrio verde") {
      it("Mínimo 200 de 0 = 200"){
        pedido3.propina().shouldBe(200f)
      }
    }
  }
  describe("Un/a cliente y un pedido v4") {
    val cliente4 = Cliente(Resfriado, LasTorres, 300f)
    val pedido4 = Pedido(cliente4, 500f)

    describe("Propina resfriado en las torres") {
      it("100% de 500 = 500"){
        pedido4.propina().shouldBe(500f)
      }
    }
  }
})