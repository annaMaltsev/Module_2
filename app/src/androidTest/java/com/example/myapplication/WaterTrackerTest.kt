package com.example.myapplication

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.ui.theme.MyApplicationTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            MyApplicationTheme {
                WaterTracker()
            }
        }
    }

    private fun addWater(times: Int) {
        repeat(times) {
            composeTestRule.onNodeWithTag(WaterTrackerTags.ADD_WATER_BUTTON).performClick()
        }
    }

    private fun finishDay() {
        composeTestRule.onNodeWithTag(WaterTrackerTags.FINISH_DAY_BUTTON).performClick()
    }

    private fun assertWater(text: String) {
        composeTestRule.onNodeWithTag(WaterTrackerTags.WATER_COUNT).assertTextEquals(text)
    }

    private fun assertDays(text: String) {
        composeTestRule.onNodeWithTag(WaterTrackerTags.DAYS_COUNT).assertTextEquals(text)
    }



    @Test
    fun addWaterButton_isDisplayedAndClickable() {
        composeTestRule.onNodeWithText("+250 мл").assertIsDisplayed()
        composeTestRule.onNodeWithTag(WaterTrackerTags.ADD_WATER_BUTTON)
            .assertIsDisplayed()
            .assertIsEnabled()
            .assertHasClickAction()
    }

    @Test
    fun addWaterButton_initialValueIsZero() {
        assertWater("0 мл")
    }

    @Test
    fun addWaterButton_singleClick_adds250ml() {
        addWater(1)
        assertWater("250 мл")
    }

    @Test
    fun addWaterButton_multipleClicks_accumulateWater() {
        addWater(6)
        assertWater("1500 мл")
    }

    @Test
    fun addWaterButton_doesNotChangeDaysCount() {
        addWater(10)
        assertDays("0")
    }



    @Test
    fun finishDayButton_isDisplayedAndClickable() {
        composeTestRule.onNodeWithText("Завершить день").assertIsDisplayed()
        composeTestRule.onNodeWithTag(WaterTrackerTags.FINISH_DAY_BUTTON)
            .assertIsDisplayed()
            .assertIsEnabled()
            .assertHasClickAction()
    }

    @Test
    fun finishDayButton_withNormReached_resetsWaterAndIncrementsDays() {
        addWater(6)
        finishDay()
        assertWater("0 мл")
        assertDays("1")
    }

    @Test
    fun finishDayButton_withNormNotReached_resetsWaterAndDays() {
        addWater(5)
        finishDay()
        assertWater("0 мл")
        assertDays("0")
    }

    @Test
    fun finishDayButton_withoutWater_keepsZero() {
        finishDay()
        assertWater("0 мл")
        assertDays("0")
    }



    @Test
    fun daysCount_initiallyZero() {
        assertDays("0")
    }

    @Test
    fun daysCount_countsConsecutiveDaysWithNorm() {
        repeat(3) {
            addWater(6)
            finishDay()
        }
        assertDays("3")
    }

    @Test
    fun daysCount_countsDaysAboveNorm() {
        addWater(8)
        finishDay()
        addWater(7)
        finishDay()
        assertDays("2")
    }

    @Test
    fun daysCount_resetsWhenStreakBroken() {
        repeat(2) {
            addWater(6)
            finishDay()
        }
        assertDays("2")

        addWater(5)
        finishDay()
        assertDays("0")
    }

    @Test
    fun daysCount_startsNewStreakAfterReset() {
        addWater(6)
        finishDay()
        finishDay()
        assertDays("0")

        addWater(6)
        finishDay()
        assertDays("1")
    }
}
