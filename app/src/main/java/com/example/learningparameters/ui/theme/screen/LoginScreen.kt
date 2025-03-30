package com.example.learningparameters.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.learningparameters.R
import com.example.learningparameters.ui.theme.LearningParametersTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {

    var text by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tela de Login") },


                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Magenta,
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        )
        {
            Spacer(modifier = Modifier.height(30.dp))

            Image(
                painter = painterResource(id = R.drawable.iconehe__2_),
                contentDescription = "Imagem de perfil",
                modifier = Modifier
                    .size(180.dp)
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(150.dp))
            )
            Text(
                text = "Você está na tela de login",
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 16.dp),
            )


            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.padding(10.dp),
                label = { Text("Digite o nome de usuário:") }
            )

            Button(
                onClick = {
                    val name = text.ifEmpty { "Cara" }
                    navController.navigate("home/$name")
                },
                modifier = Modifier.padding(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
            ) {
                Text(text = "Navegar para a Home",
                    fontSize = 15.sp,
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LearningParametersTheme {
        LoginScreen(
            navController = rememberNavController()
        )
    }
}
