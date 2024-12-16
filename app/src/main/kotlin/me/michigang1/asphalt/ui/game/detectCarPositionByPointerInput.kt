package me.michigang1.asphalt.ui.game

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.RequestDisallowInterceptTouchEvent
import androidx.compose.ui.input.pointer.pointerInteropFilter
import me.michigang1.asphalt.models.CarPosition
import com.example.racingcar.utils.Constants

@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.detectCarPositionByPointerInput(
    maxWidth: Int,
    onDetectPosition: (CarPosition) -> Unit
) = pointerInteropFilter(
    requestDisallowInterceptTouchEvent = RequestDisallowInterceptTouchEvent()
) {
    val currentX = it.x

    val laneIndex = (currentX / maxWidth)
        .toInt()
        .coerceIn(0, Constants.LANE_COUNT)

    CarPosition.entries
        .find { position ->
            position
                .fromLeftOffsetIndex()
                .toInt() == laneIndex
        }?.let { position ->
            onDetectPosition(position)
        }

    true
}