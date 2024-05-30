package com.example.newapp_buttons.ui.theme

// Importa as bibliotecas necessárias
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Cria uma variável para o tema escuro
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

// Cria uma variável para o tema claro
private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

// Cria uma função para o tema escuro
@Composable
fun Newapp_buttonsTheme(

    // Define se o tema é escuro
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+

    // Define se o tema é dinâmico
    dynamicColor: Boolean = true,

    // Define o conteúdo do tema
    content: @Composable () -> Unit
) {

    // Define o esquema de cores
    val colorScheme =
        // Verifica se o tema é escuro
        when {
            // Verifica se o sistema é Android 12 ou superior
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                // Define o esquema de cores para o tema escuro
                val context = LocalContext.current
                /* Verifica se o tema é escuro e define o esquema de cores para o tema escuro, caso contrário,
                define o esquema de cores para o tema claro.*/
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            }

            // Define o esquema de cores para o tema escuro
            darkTheme -> DarkColorScheme

            // Define o esquema de cores para o tema claro
            else -> LightColorScheme
        }

    // Define a view
    val view = LocalView.current

    // Verifica se a view é em modo de edição
    if(!view.isInEditMode){

        // Define o efeito colateral
        SideEffect{

            // Obtém a janela da atividade atual
            val window = (view.context as Activity).window

            // Define a cor do da barra de status para a cor priméria do esquema de cores
            window.statusBarColor = colorScheme.primary.toArgb()

            // Define se a barra de status deve ter uma aparência clara ou escura.
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    // Define o tema
    MaterialTheme(

        // Define o esquema de cores
        colorScheme = colorScheme,

        // Define a fonte do tema
        typography = Typography,

        // Define o conteúdo
        content = content
    )
}

// Cria uma funçao para o botão de debug
@Composable
fun DebugButtonColors() = ButtonDefaults.buttonColors(containerColor = DarkGreen)

// Cria uma funçao para o botão de aviso
@Composable
fun WarningButtonColors() = ButtonDefaults.buttonColors(containerColor = DarkOrange)

// Cria uma funçao para o botão de erro
@Composable
fun ErrorButtonColors() = ButtonDefaults.buttonColors(containerColor = DarkRed)

// Cria uma funçao para o botão de informação
@Composable
fun InfoButtonColors() = ButtonDefaults.buttonColors(containerColor = DarkBlue)