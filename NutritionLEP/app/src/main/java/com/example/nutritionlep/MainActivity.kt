package com.example.nutritionlep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nutritionlep.ui.theme.*
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NutritionLEPTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun LanguageSelectionScreen(
    onLanguageSelected: (String) -> Unit
) {
    var selectedLanguage by remember { mutableStateOf<String?>(null) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = LightMint
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 120.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
                Image(
                    painter = painterResource(id = R.drawable.project_1_logo),
                    contentDescription = "Nutrition Logo",
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .aspectRatio(1.5f)
                        .offset(x = 23.dp, y = (0).dp)
                )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "CHOOSE YOUR LANGUAGE",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = DarkGreen,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Elige tu idioma , Choisissez votre langue ,\n언어를 선택하세요 , Sie Ihre Sprache",
                fontSize = 16.sp,
                color = DarkGreen.copy(alpha = 0.75f),
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            val languages = listOf("English", "Español", "한국인", "Français", "Deutsch")
            languages.forEach { language ->
                LanguageButton(
                    text = language,
                    isSelected = selectedLanguage == language,
                    isDimmed = selectedLanguage != null && selectedLanguage != language,
                    onClick = { selectedLanguage = language
                                onLanguageSelected(language)
                    }
                )
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}

@Composable
fun LanguageButton(
    text: String,
    isSelected: Boolean,
    isDimmed: Boolean,
    onClick: () -> Unit
) {
    val containerColor = when {
        isSelected -> DeepForest
        isDimmed   -> Grey
        else       -> BrightMint
    }

    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(0.75f)
            .height(44.dp),
        shape = RoundedCornerShape(22.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = Color.White
        )
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}