package ar.edu.unahur.obj2.socios

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ClienteTest : DescribeSpec({
  describe("Un/a cliente") {
    val cliente1 = Cliente(Feliz, LasRosas, 600f)
    val pedido1 = Pedido(cliente1, 1000f)

    describe("propina feliz en las rosas") {
      it("25% + 50 de 600 = 200"){
        pedido1.propina().shouldBe(200)
      }
    }
  }
})
