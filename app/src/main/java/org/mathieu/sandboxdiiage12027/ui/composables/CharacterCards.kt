@file:OptIn(ExperimentalFoundationApi::class)

package org.mathieu.sandboxdiiage12027.ui.composables

import android.content.Context
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import org.mathieu.sandboxdiiage12027.domain.models.Character
import org.mathieu.sandboxdiiage12027.domain.models.LivingStatus
import org.mathieu.sandboxdiiage12027.domain.models.charactersMock
import org.mathieu.sandboxdiiage12027.nativemanager.SoundManager

val pageBackground = Color(0xFF272B33)

private val cardBackgroundColor = Color(0xFF3C3E44)

private val labelColor = Color(0xFF9E9E9E)
private val statusColor = Color(0xFFFFFFFF)
private val textColor = Color(0xFFF5F5F5)

private val redDotColor = Color(0xFFD63D2E)
private val greenDotColor = Color(0xFF55CC44)
private val grayDotColor = Color(0xFF9E9E9E)


val LivingStatus.color: Color
    get() = when (this) {
        LivingStatus.Unknown -> grayDotColor
        LivingStatus.Dead -> redDotColor
        LivingStatus.Alive -> greenDotColor
    }


private val cardPadding = 13.5.dp
private val cardMaxWidth = 420.dp

val characterCardMinWidthRequired = cardMaxWidth + cardPadding * 2

@Composable
fun CharacterCard(
    character: Character
) {

    // Récupération de la largeur de l'écran en dp
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp

    // Affichage conditionnel en fonction de la largeur de l'écran
    if (screenWidthDp < characterCardMinWidthRequired) {
        CharacterCardBody(
            character = character,
            container = { modifier, content ->
                Column(
                    modifier = modifier,
                    content = { content() }
                )
            }
        )
    } else {
        CharacterCardBody(
            character = character,
            container = { modifier, content ->
                Row(
                    modifier = modifier,
                    content = { content() }
                )
            }
        )
    }

}


@Composable
private fun CharacterCardBody(
    character: Character,
    container: @Composable (modifier: Modifier, content: @Composable () -> Unit) -> Unit
) {

    var isPressed by remember { mutableStateOf(false) }

    val elevation by animateDpAsState(targetValue = if (isPressed) 0.dp else 8.dp, label = "elevation")


    val context: Context = LocalContext.current

    container(
        Modifier
            .padding(cardPadding)
            .rotate(0f)
            .shadow(elevation)
            .width(cardMaxWidth)
            .background(cardBackgroundColor)
            .height(IntrinsicSize.Max)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        tryAwaitRelease()
                        isPressed = false
                    },
                    onTap = {
                        SoundManager(context).playButtonClickedSound()
                    }

                )
            }
    ) {

        AsyncImage(
            modifier = Modifier
                .background(pageBackground.copy(alpha = 0.7f))
                .aspectRatio(1f) // L'image fait 1/1 de ratio
                .fillMaxHeight(),
            model = character.image,
            contentDescription = "character_image",
            imageLoader = ImageLoader(context),
            contentScale = ContentScale.Fit
        )


        CharacterCardContent(character)

    }

}

@Composable
private fun CharacterCardContent(character: Character) {

    Column(
        modifier = Modifier.padding(12.dp)
    ) {

        //Name of the character
        Text(
            modifier = Modifier
                .basicMarquee(iterations = Int.MAX_VALUE),
            text = character.name,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            color = textColor,
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(2.dp))

        //Its status
        CharacterStatusView(
            livingStatus = character.status,
            species = character.species
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Last known location:
        CharacterInformationView(
            label = "Last known location:",
            value = character.location.name
        )

        Spacer(modifier = Modifier.height(16.dp))

        //First seen in:
        CharacterInformationView(
            label = "First seen in:",
            value = character.origin.name
        )
    }

}

/**
 *
 * Petit point vert ou rouge ou gris avec un petit tiret avec un autre petit texte (espèce)
 *
 * @param livingStatus the living status
 * @param species the specie
 */
@Composable
private fun CharacterStatusView(
    livingStatus: LivingStatus,
    species: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier =
            Modifier
                .padding(end = 4.dp)
                .background(livingStatus.color, shape = CircleShape)
                .size(6.dp)
        )

        Text(
            modifier = Modifier
                .basicMarquee(iterations = Int.MAX_VALUE),
            text = "${livingStatus.name} - $species",
            fontSize = 12.sp,
            color = statusColor
        )

    }
}

@Composable
fun CharacterInformationView(
    label: String,
    value: String
) {
    Column {

        Text(
            modifier = Modifier
                .basicMarquee(iterations = Int.MAX_VALUE),
            color = labelColor,
            text = label,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            modifier = Modifier
                .basicMarquee(iterations = Int.MAX_VALUE),
            color = textColor,
            text = value,
            fontSize = 14.sp,
            maxLines = 1
        )
    }
}

@Preview(name = "VerticalCard should be displayed", device = Devices.NEXUS_6P, showSystemUi = true)
@Composable
private fun CharacterCardWithSmallScreen() =
    Box(
        modifier = Modifier
            .background(pageBackground)
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        CharacterCard(
            character = charactersMock.first()
        )
    }

@Preview(name = "HorizontalCard should be displayed", device = Devices.NEXUS_7, showSystemUi = true)
@Composable
private fun CharacterCardWithWideScreen() =
    Box(
        modifier = Modifier
            .background(pageBackground)
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        CharacterCard(
            character = charactersMock.first()
        )
    }
