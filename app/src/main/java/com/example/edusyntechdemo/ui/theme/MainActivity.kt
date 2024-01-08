package com.example.edusyntechdemo.ui.theme
import ChildModeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.*
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.edusyntechdemo.R
import gamesList

data class Game(val id: Int, val title: String)
data class Statistic(val title: String, val value: String)

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
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { DashboardScreen("Arda", "Selen") }
        composable("childMode") { ChildModeScreen(
            userProfileImage = painterResource(id = R.drawable.placeholder_user), // Örnek profil resmi
            userName = "İsim",
            userLevel = "X",
            onSettingsClicked = {},
            gamesList = gamesList )
        } // ChildModeScreen için rota ekle
    }
}
@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    EdusyntechdemoTheme {
        DashboardScreen(ebeveyn = "[Ebeveyn]", cocuk = "[Cocuk]")
    }
}
@Composable
fun DashboardScreen(ebeveyn: String, cocuk: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
    ) {
        // AppBar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = R.drawable.edusyntech), // Arka plan resminizi buraya yerleştirin
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(144.dp)
                    .clip(CircleShape)
                //.background(MaterialTheme.colorScheme.surfaceVariant)
            )

            Spacer(modifier = Modifier.weight(1f))
            // Replace with actual icon and action
            Button(onClick = { /* Handle menu click */ }
            ) {
                Text(
                    text = "☰",
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                ) // Menu Icon
            }
        }

        //  Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier
                .padding(horizontal = 10.dp) // Sağdan ve soldan boşluk ekler
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),

            //elevation = 4.dp // Kartın gölge yoğunluğu
        ) {
            Column(
                modifier = Modifier.padding(48.dp)
            ) {

                Text(
                    text = "Merhaba $ebeveyn \uD83D\uDC4B",
                    fontWeight = FontWeight.Medium,
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.height(42.dp))

                // Child's Progress
                Text(
                    text = "$cocuk bu hafta 20 oyun tamamladı",
                    fontWeight = FontWeight.Medium,
                    fontSize = 21.sp
                )

                Spacer(modifier = Modifier.height(12.dp))


                
                // Task Description
                Text(
                    text = "Kelime ile hece seçme ve Görsel eşleştirme görevlerine yönelik daha fazla oyun gösterilecek",
                    fontSize = 14.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))

        // Statistics Header
        Text(
            text = "İstatistikler",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        LazyRow {
            // Örnek veri listesi
            val statistics = listOf(
                Statistic("Kazanılan Puanlar", "1200"),
                Statistic("Tamamlanan Oyunlar", "15"),
                Statistic("Geçirilen Süre ", "20"),

                // Diğer istatistikler...
            )

            items(statistics) { stat ->
                StatisticCard(statistic = stat)
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        val navController = rememberNavController()

        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.padding(16.dp)
                               .fillMaxWidth()
        ) {
            val backgroundImage: Painter = painterResource(id = R.drawable.background_image)

            Box(
                //modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
                modifier = Modifier.shadow(6.dp, RoundedCornerShape(32.dp))
                                    .width(200.dp)
                                    .height(75.dp), // Gölge efekti ve köşe yuvarlaklığı
            // Box'ın tüm alanını kaplarshape = RoundedCornerShape(16.dp),

                ) {
                Image(
                    painter = backgroundImage,
                    contentDescription = null,
                    contentScale = ContentScale.Crop, // Resmi kutuya sığdırmak için ölçeklendirme
                    modifier = Modifier.matchParentSize() // Box'ın tüm alanını kaplarshape = RoundedCornerShape(16.dp),

                )
                // Child Mode Button
                TextButton(onClick = {
                    navController.navigate("childMode")
                })
            }

                Spacer(
                    modifier = Modifier.weight(1f)
                        .padding(12.dp)
                )

                //        Settings Icon
                Button(onClick = { /* Handle menu click */ }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Ayarlar",
                        modifier = Modifier.size(62.dp) // İkon boyutunu ayarla
                    )
                }
            }
        }

}
@Composable
fun TextButton(onClick: () -> Unit) {
    Text(
        text = "Çocuk Modu",
        modifier = Modifier.clickable(onClick = onClick),
        fontSize = 34.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White // Opsiyonel: Metin rengini ayarlayabilirsiniz.
    )
}
    @Composable
fun StatisticCard(statistic: Statistic) {

    Card(
        modifier = Modifier
            .padding(16.dp)
            .width(300.dp)
            .height(200.dp)
            .shadow(6.dp, RoundedCornerShape(48.dp)), // Gölge efekti ve köşe yuvarlaklığı
    )  {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF7991EC)) // #7991ec rengini burada kullan
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = statistic.title, fontWeight = FontWeight.Bold)
                Text(text = statistic.value)
            }
        }
    }
}
