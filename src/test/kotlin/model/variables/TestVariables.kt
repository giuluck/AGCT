package model.variables

import io.kotlintest.matchers.collections.shouldHaveSingleElement
import io.kotlintest.specs.StringSpec
import model.utils.shouldEqual
import model.utils.shouldMatchWithTolerance
import model.utils.shouldNotEqual

private const val SINGLE_ELEMENT = 20.0
private val MULTIPLE_ELEMENTS = setOf(1.0, 2.0, 3.0, 4.0, 5.0)

class TestVariables : StringSpec({
    "test rate" {
        val defaultRate = Rate()
        defaultRate.values shouldHaveSingleElement DEFAULT_RATE_VALUE
        val singleRate = Rate(SINGLE_ELEMENT)
        singleRate.values shouldHaveSingleElement SINGLE_ELEMENT
        val arrayRate = Rate(*MULTIPLE_ELEMENTS.toTypedArray())
        arrayRate.values shouldMatchWithTolerance MULTIPLE_ELEMENTS
        val sequenceRate = Rate(MULTIPLE_ELEMENTS.asSequence())
        sequenceRate.values shouldMatchWithTolerance MULTIPLE_ELEMENTS
        val setRate = Rate(MULTIPLE_ELEMENTS)
        setRate.values shouldMatchWithTolerance MULTIPLE_ELEMENTS
    }

    "test concentration" {
        val defaultConcentration = Concentration()
        defaultConcentration.values shouldHaveSingleElement DEFAULT_CONCENTRATION_VALUE
        val singleConcentration = Concentration(SINGLE_ELEMENT)
        singleConcentration.values shouldHaveSingleElement SINGLE_ELEMENT
        val arrayConcentration = Concentration(*MULTIPLE_ELEMENTS.toTypedArray())
        arrayConcentration.values shouldMatchWithTolerance MULTIPLE_ELEMENTS
        val sequenceConcentration = Concentration(MULTIPLE_ELEMENTS.asSequence())
        sequenceConcentration.values shouldMatchWithTolerance MULTIPLE_ELEMENTS
        val setConcentration = Concentration(MULTIPLE_ELEMENTS)
        setConcentration.values shouldMatchWithTolerance MULTIPLE_ELEMENTS
    }

    "test equality" {
        Rate(MULTIPLE_ELEMENTS) shouldEqual Rate(MULTIPLE_ELEMENTS)
        Concentration(MULTIPLE_ELEMENTS) shouldEqual Concentration(MULTIPLE_ELEMENTS)
        Rate(MULTIPLE_ELEMENTS) shouldNotEqual Concentration(MULTIPLE_ELEMENTS)

    }
})