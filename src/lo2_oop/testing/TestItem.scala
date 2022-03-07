package lo2_oop.testing

import org.scalatest._

class TestItem extends FunSuite {

  test("Test Item") {

    val item: Item = new Item("Onions", 0.3)

    assert(item.description == "Onions")

    item.purchase()
    item.purchase()

    assert(item.timesPurchased == 2)


  }

}
