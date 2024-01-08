import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.edusyntechdemo.R
import androidx.compose.material.Card


public data class Game(val id: Int, val title: String)

// Örnek oyun listesi
val gamesList = listOf(
    Game(1, "Oyun 1"),
    Game(2, "Oyun 2"),
    Game(3, "Oyun 3"),
    Game(1, "Oyun 4"),
    Game(2, "Oyun 5"),
    Game(3, "Oyun 6")
)

@Composable
fun ChildModeScreen(
    userProfileImage: Painter,
    userName: String,
    userLevel: String,
    onSettingsClicked: () -> Unit,
    gamesList: List<Game>
) {
    var currentGameIndex by remember { mutableStateOf(0) }

    // Background Image and Overlay
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.3f),
                            Color.Transparent
                        )
                    )
                )
        )

        // Main Content - Now centered within
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center // İçeriği merkeze hizala
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment =  Alignment.CenterVertically) {
                Spacer(modifier = Modifier.height(52.dp))

                // User card
                UserCard(userProfileImage, userName, userLevel, onSettingsClicked)

                // Game navigation
                Box(
                    contentAlignment = Alignment.Center, // Box içindeki içeriği merkeze hizala
                    modifier = Modifier
                        .fillMaxWidth() // Box'ın genişliğini maksimum yap
                        .padding(16.dp) // Box'a padding ekle
                        .background(Color.Black)                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Button(onClick = { if (currentGameIndex > 0) currentGameIndex-- }) {
                            Text("<")
                        }
                        GameCard(gamesList[currentGameIndex])
                        Button(onClick = { if (currentGameIndex < gamesList.size - 1) currentGameIndex++ }) {
                            Text(">")
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun UserCard(
    userProfileImage: Painter,
    userName: String,
    userLevel: String,
    onSettingsClicked: () -> Unit
) {
    Box(
    modifier = Modifier
        .width(500.dp)
        .height(500.dp)
        .padding(16.dp))
    {

    Card(
        backgroundColor = Color(0x99FFFFFF), // %50 saydamlıkta beyaz
        modifier = Modifier
            .padding(16.dp),
        shape = RoundedCornerShape(68.dp)
    ) {

        Row(
            modifier = Modifier
                .padding(88.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(48.dp)
                ) {
                    Image(
                        painter = userProfileImage,
                        contentDescription = "User Profile",
                        modifier = Modifier
                            .size(84.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                    )
                    IconButton(
                        onClick = onSettingsClicked,
                        modifier = Modifier.size(96.dp) // IconButton boyutunu ayarla
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Ayarlar",
                            modifier = Modifier
                                .size(84.dp) // İkon boyutunu ayarla
                        )
                    }
                }

                Text(
                    text = userName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 48.sp,
                    modifier = Modifier
                        .padding(start = 16.dp), // Metne her yönden 8.dp padding ekle
                    textAlign = TextAlign.Start // Metni sola hizala
                )
                Text(
                    text = "Seviye $userLevel",
                    fontSize = 36.sp,
                    modifier = Modifier.padding(start = 16.dp), // Metne her yönden 8.dp padding ekle
                    textAlign = TextAlign.Start // Metni sola hizala
                )
            }

        }
    }

    }
}

@Composable
fun GameCard(game: Game) {
    Card(
        backgroundColor = Color(0x99FFFFFF), // %50 saydamlıkta beyaz
        modifier = Modifier
            .width(500.dp)
            .height(300.dp)
            .padding(end = 25.dp),
        shape = RoundedCornerShape(68.dp)
        // color = MaterialTheme.colorScheme.primaryContainer
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = game.title, color = MaterialTheme.colorScheme.onPrimaryContainer)
        }
    }
}
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    device = "spec:shape=Normal,width=1330,height=680,unit=dp,dpi=480"
)
@Composable
fun ChildModeScreenPreview() {
    ChildModeScreen(
        userProfileImage = painterResource(id = R.drawable.userprofile), // Örnek profil resmi
        userName = "İsim",
        userLevel = "X",
        onSettingsClicked = {},
        gamesList = gamesList
    )
}
