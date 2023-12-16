package com.example.edusyntechdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.edusyntechdemo.ui.theme.EdusyntechdemoTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.shape.RoundedCornerShape


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EdusyntechdemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    DashboardScreen(ebeveyn = "Ebeveyn", cocuk = "Çocuk")
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    EdusyntechdemoTheme {
        DashboardScreen(ebeveyn = "Omer", cocuk = "Ali")
    }
}
@Composable
fun DashboardScreen(ebeveyn: String, cocuk: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        /*
                    .background(Color.White)
        */
    ) {
        // AppBar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "EdusynTech",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            // Replace with actual icon and action
            Button(onClick = { /* Handle menu click */ }) {
                Text(text = "☰") // Menu Icon
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Welcome Message
        Text(
            text = "Merhaba $ebeveyn",
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Child's Progress
        Text(
            text = "$cocuk bu hafta 20 oyun tamamladı",
            fontWeight = FontWeight.Light,
            fontSize = 16.sp
        )

        // Task Description
        Text(
            text = "Kelime ile hece seçme ve Görsel eşleştirme görevlerine yönelik daha fazla oyun gösterilecek",
            fontSize = 14.sp
        )

        // Statistics Header
        Text(
            text = "İstatistikler",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Placeholder for statistics content
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
//                .background(Color.LightGray)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Child Mode Button
        Button(
            onClick = { /* Handle child mode click */ },
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
//                .background(Color.Cyan)
        ) {
            Text(
                text = "Çocuk modu",
                fontSize = 16.sp
            )
        }

        // Settings Icon
//        Image(
//            painter = painterResource(android.R.drawable.ic_menu_settings),
//            contentDescription = "Settings"
//        )

    }
}