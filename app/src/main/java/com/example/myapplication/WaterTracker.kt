package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val primaryColor = Color(0xFF265DC0)
private val buttonTextColor = Color.White

object WaterTrackerTags {
    const val WATER_COUNT = "water_count"
    const val DAYS_COUNT = "days_count"
    const val ADD_WATER_BUTTON = "add_water_button"
    const val FINISH_DAY_BUTTON = "finish_day_button"
}


@Composable
fun WaterTracker() {
    var waterCount by remember { mutableStateOf(0) }
    var daysCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

        ) {
        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = primaryColor
        )

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = "$waterCount мл",
            modifier = Modifier.testTag(WaterTrackerTags.WATER_COUNT),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "$daysCount",
            modifier = Modifier.testTag(WaterTrackerTags.DAYS_COUNT),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = primaryColor),
            onClick = { waterCount += 250 },
            modifier = Modifier.testTag(WaterTrackerTags.ADD_WATER_BUTTON),
            shape = ShapeDefaults.Small
        ) {
            Text(
                text = "+250 мл",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = primaryColor),
            onClick = {
                if (waterCount >= 1500){
                    daysCount += 1
                    waterCount = 0
                }else{
                    waterCount = 0
                    daysCount = 0
                }
            },
            modifier = Modifier.testTag(WaterTrackerTags.FINISH_DAY_BUTTON),
            shape = ShapeDefaults.Small
        ) {
            Text(
                text = "Завершить день",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor
            )
        }
    }
}
