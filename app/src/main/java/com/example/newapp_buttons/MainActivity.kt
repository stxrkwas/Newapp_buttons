// Copyright (c) 2023. All rights reserved.

// Importando as bibliotecas
package com.example.newapp_buttons
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newapp_buttons.ui.theme.DebugButtonColors
import com.example.newapp_buttons.ui.theme.ErrorButtonColors
import com.example.newapp_buttons.ui.theme.InfoButtonColors
import com.example.newapp_buttons.ui.theme.WarningButtonColors
import com.example.newapp_buttons.ui.theme.Newapp_buttonsTheme

// Criando a variável com o valor do TAG
const val TAG = "TestAndroid"

// Declara a classe MainActivity como uma subclasse de ComponentActivity.
class MainActivity : ComponentActivity() {

    ////Sobrescreve o método onCreate da classe base para definir o conteúdo da atividade.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Define o conteúdo da atividade como um tema personalizado
            Newapp_buttonsTheme {

                // Chama a função App para exibir a interface
                App()
            }
        }
    }
}

// Declara a função App como um Composable
@Composable
private fun App() {

    // Cria um Surface para exibir a interface
    Surface(

        // Define o tamanho da tela
        modifier = Modifier.fillMaxSize(),

        // Define a cor de fundo
        color = MaterialTheme.colorScheme.background
    ){

        // Cria uma Column para exibir os botões
        Column(

            // Define o alinhamento vertical e horizontal
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            // Chama a função Greeting para exibir o texto
            Greeting("JetPack")

            // Cria os botões
            ActionButton(

                // Define o texto do botão
                text = "Debug",

                // Chaam a função que define as cores dos botões
                buttonColors = DebugButtonColors(),

                // Define o tamanho do botão
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                // Imprime no Logcat o texto do botão
                Log.d(TAG, "App: Clicou em DEBUG!")
            }

            // Adiciona mais um botão
            ActionButton(

                // Define o texto do botão
                text = "Info",

                // Chama a função que define as cores dos botões
                buttonColors = InfoButtonColors(),

                // Define o tamanho do botão
                modifier = Modifier.fillMaxWidth(0.5f)
            ){

                // Imprime no Logcat o texto do botão
                Log.i(TAG, "App: Clicou em INFO!")
            }

            // Adiciona mais um botão
            ActionButton(

                // Define o texto do botão
                text = "Warning",

                // Chama a função que define as cores dos botões
                buttonColors = WarningButtonColors(),

                // Define o tamanho do botão
                modifier = Modifier.fillMaxWidth(0.5f)
            ){

                // Imprime no Logcat o texto do botão
                Log.w(TAG, "App; Clicou em Warning")
            }

            // Adiciona mais um botão
            ActionButton(

                // Define o texto do botão
                text = "Error",

                // Chama a função que define as cores dos botões
                buttonColors = ErrorButtonColors(),

                // Define o tamanho do botão
                modifier = Modifier.fillMaxWidth(0.5f)
            ){

                // Lê o conteúdo do botão e lança uma exceção
                try{

                    // Cria uma exceção
                    throw RuntimeException("Clicou em Error!")

                }

                // Captura a exceção
                catch(ex: Exception){

                    // Imprime no Logcat a exceção
                    Log.e(TAG, "${ex.message}")
                }
            }
        }
    }
}

// Declara a função ActionButton como um Composable
@Composable
fun ActionButton(

    // Declara as variáveis
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
){

    // Define o tipo do botão
    ElevatedButton(

        // Define a ação do botão
        onClick = block,

        // Define a forma do botão
        shape = RoundedCornerShape(5.dp),

        // Define as cores do botão
        colors = buttonColors,

        // Define o tamanho do botão
        modifier = modifier
    ) {

        // Exibe o texto do botão
        Text(text = text)
    }
}

// Declara a função Greeting como um Composable
@Composable

// Declara as variáveis
fun Greeting(name: String, modifier: Modifier = Modifier){

    // Exibe o texto
    Text(

        // Define o texto
        text = "Aula de $name!",

        // Define o estilo do texto
        style = MaterialTheme.typography.bodyLarge.copy(

            // Define a densidade do texto
            fontWeight = FontWeight.Bold
        ),

        // Define a cor do texto
        color = MaterialTheme.colorScheme.secondary
    )
}

// Define as configurações do Preview
@Preview(showBackground = true, widthDp = 120)

// Declara a função ActionButtonPreview como um Composable
@Composable
fun ActionButtonPreview() {

    // Chama a função ActionButton para exibir o botão
    ActionButton(text = "Cadastrar"){}
}

// Define as configurações do Preview
@Preview

// Declara a função GreetingPreview como um Composable
@Composable
fun GreetingPreview(){

    // Chama a função Greeting para exibir o texto
    Newapp_buttonsTheme {
        Greeting("JetPack")
    }
}

//Os avisos aparecem em Logcat.