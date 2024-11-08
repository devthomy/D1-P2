package org.mathieu.sandboxdiiage12027.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.mathieu.sandboxdiiage12027.domain.models.Character
import org.mathieu.sandboxdiiage12027.domain.models.charactersMock
import kotlin.math.floor


//Nous avons 3 types d'affichage dans la largeur :
// a. une card à empilement horizontal
// b. plusieurs card à empilement horizontal
// c. une card à empilement vertical
//
// Le cas numéro (a.) advient si l'écran a une largeur minimale de 420
// Le cas numéro (b.) advient si l'écran a une largeur minimale supérieur à n fois (a.)
// Le cas numéro (c.) advient si l'écran a une largeur minimale inférieure à (a.)

@Composable
fun CharactersListContent(
    characters: List<Character>,
) {

    // Récupération de la largeur de l'écran en dp
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp

    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(
            floor(
                screenWidthDp / characterCardMinWidthRequired
            ).toInt().takeIf { it > 0 } ?: 1
        )
    ) {
        items(characters) {
            Box(contentAlignment = Alignment.Center) {
                CharacterCard(
                    character = it
                )

            }
        }
    }
}



@Preview(name = "VerticalCard should be displayed in a vertical scroll orientation", device = Devices.NEXUS_6P, showSystemUi = true)
@Composable
private fun CharacterCardTooTight() =
    Box(
        modifier = Modifier
            .background(pageBackground)
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        CharactersListContent(charactersMock)
    }

@Preview(name = "HorizontalCard should be displayed in a grid", device = Devices.NEXUS_10, showSystemUi = true)
@Composable
private fun CharacterCardWideScreen() =
    Box(
        modifier = Modifier
            .background(pageBackground)
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        CharactersListContent(charactersMock)
    }

