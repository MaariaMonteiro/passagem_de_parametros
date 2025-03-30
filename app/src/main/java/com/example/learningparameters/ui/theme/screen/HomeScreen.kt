package com.example.learningparameters.ui.theme.screen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningparameters.R

@Composable
fun HomeScreen(user: com.example.learningparameters.data.User) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()) // Adiciona rolagem vertical
            .background(color = Color(0xFFF5F5F5)) // Fundo mais claro
            .padding(horizontal = 16.dp) // Margem lateral
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        // Cabeçalho estilizado
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = Color(0xFFD00656)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Bem-vindo à tela Home :)",
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Nome do usuário estilizado
        Text(
            text = "Olá, ${user.name}!",
            fontSize = 24.sp,
            color = Color(0xFFD00656),
            fontFamily = FontFamily.Serif,
            modifier = Modifier.padding(top = 16.dp)
        )

        // Imagem do perfil com borda arredondada
        Image(
            painter = painterResource(id = R.drawable.iconeh),
            contentDescription = "Imagem de perfil",
            modifier = Modifier
                .size(120.dp)
                .padding(top = 8.dp)
                .clip(RoundedCornerShape(60.dp)) // Torna a imagem circular
                .background(color = Color(0xFFD00656)) // Fundo atrás da imagem
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Biografia estilizada em um Card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .clip(RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Text(
                text = "Biografia:",
                fontSize = 18.sp,
                fontFamily = FontFamily.Serif,
                color = Color(0xFFD00656)
            )
            Text(
                text = "\"${user.bio}\"",
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Outros dados organizados e estilizados
        DataRow(label = "E-mail:", value = user.email)
        DataRow(label = "Turma:", value = user.turma)
        DataRow(label = "Nascimento:", value = user.registerDate)
        DataRow(label = "Pontuação:", value = "${user.score}", color = Color.Green)
        DataRow(label = "Idade:", value = "${user.age}")

        Spacer(modifier = Modifier.height(50.dp)) // Espaço para garantir a rolagem completa
    }
}

@Composable
fun DataRow(label: String, value: String, color: Color = Color.Black) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            fontFamily = FontFamily.Serif,
            color = Color.Gray,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = value,
            fontSize = 16.sp,
            fontFamily = FontFamily.Serif,
            color = color,
            modifier = Modifier.weight(2f) 
        )
    }
}
