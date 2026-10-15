package com.example.medication.features.patients.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val BoxBorder   = Color(0xFFCBD5E1)
private val BoxBorderOn = Color(0xFF16A34A)
private val TextPrimary = Color(0xFF0F2A2E)
private val BoxBg       = Color(0xFFF3F6F8)

@Composable
fun CodeInputField(
    value: String,
    onValueChange: (String) -> Unit,
    length: Int = 6
) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        // Campo invisible que captura el teclado; las cajas de abajo solo dibujan el valor.
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Characters
            ),
            textStyle = TextStyle(color = Color.Transparent),
            cursorBrush = SolidColor(Color.Transparent),
            modifier = Modifier.matchParentSize()
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            repeat(length) { index ->
                val char = value.getOrNull(index)?.toString() ?: ""
                val isActive = char.isNotEmpty() || index == value.length
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .background(BoxBg, RoundedCornerShape(10.dp))
                        .border(
                            width = if (isActive) 1.5.dp else 1.dp,
                            color = if (isActive) BoxBorderOn else BoxBorder,
                            shape = RoundedCornerShape(10.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        char,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}