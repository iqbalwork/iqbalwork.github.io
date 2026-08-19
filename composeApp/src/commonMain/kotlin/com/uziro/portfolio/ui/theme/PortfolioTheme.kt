package com.uziro.portfolio.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Material You (Material 3 Dynamic Tonal Palette)
 * Expressive, harmonious color tokens for Iqbal Fauzi's portfolio
 */
object PortfolioColors {
    // Primary Tone (Expressive Violet)
    val Primary = Color(0xFF8F7BFF)
    val OnPrimary = Color(0xFF1E0060)
    val PrimaryContainer = Color(0xFF3B258E)
    val OnPrimaryContainer = Color(0xFFE8DDFF)

    // Secondary Tone (Dynamic Cyan/Teal)
    val Secondary = Color(0xFF00DFC0)
    val OnSecondary = Color(0xFF00382E)
    val SecondaryContainer = Color(0xFF005144)
    val OnSecondaryContainer = Color(0xFF70FCDD)

    // Tertiary Tone (Warm Coral/Sunset)
    val Tertiary = Color(0xFFFF9B8E)
    val OnTertiary = Color(0xFF561E16)
    val TertiaryContainer = Color(0xFF73342A)
    val OnTertiaryContainer = Color(0xFFFFDAD5)

    // Neutral Surfaces & Containers
    val Background = Color(0xFF0B0E17)
    val OnBackground = Color(0xFFE2E7F5)

    val Surface = Color(0xFF0F1422)
    val OnSurface = Color(0xFFF1F4FD)

    val SurfaceVariant = Color(0xFF192033)
    val OnSurfaceVariant = Color(0xFF98A2B8)

    val SurfaceContainerLowest = Color(0xFF080B12)
    val SurfaceContainerLow = Color(0xFF131828)
    val SurfaceContainer = Color(0xFF181F33)
    val SurfaceContainerHigh = Color(0xFF202842)
    val SurfaceContainerHighest = Color(0xFF283252)

    val Outline = Color(0xFF384360)
    val OutlineVariant = Color(0xFF252D42)

    // Semantic Accents
    val Emerald = Color(0xFF10B981)
    val Amber = Color(0xFFF59E0B)
    val Rose = Color(0xFFF43F5E)

    // Legacy Aliases for seamless component compatibility
    val KotlinPurple = Primary
    val JetpackTeal = Secondary
    val ElectricIndigo = PrimaryContainer
    val EmeraldSuccess = Emerald
    val AmberAccent = Amber
    val RoseAlert = Rose

    val BgVoid = Background
    val BgSurfaceDark = Surface
    val BgCard = SurfaceContainer
    val BgCardHover = SurfaceContainerHigh
    val BgGlass = Color(0xD90F1422)

    val BorderSubtle = OutlineVariant
    val BorderLight = Outline
    val BorderPurple = Color(0x668F7BFF)
    val BorderTeal = Color(0x6600DFC0)

    val TextPrimary = OnSurface
    val TextSecondary = OnSurfaceVariant
    val TextMuted = Color(0xFF6A7694)

    // Dynamic Material You Gradients
    val MaterialYouBrandGradient = Brush.horizontalGradient(
        listOf(Primary, Color(0xFF6366F1), Secondary)
    )
    val HeroGradient = Brush.verticalGradient(
        listOf(Color(0xFF151C30), Background)
    )
    val CardGradient = Brush.verticalGradient(
        listOf(SurfaceContainerHigh, SurfaceContainer)
    )
    val GlowingAuraGradient = Brush.sweepGradient(
        listOf(Primary, Secondary, Tertiary, Primary)
    )
}

val MaterialYouDarkColorScheme: ColorScheme = darkColorScheme(
    primary = PortfolioColors.Primary,
    onPrimary = PortfolioColors.OnPrimary,
    primaryContainer = PortfolioColors.PrimaryContainer,
    onPrimaryContainer = PortfolioColors.OnPrimaryContainer,
    secondary = PortfolioColors.Secondary,
    onSecondary = PortfolioColors.OnSecondary,
    secondaryContainer = PortfolioColors.SecondaryContainer,
    onSecondaryContainer = PortfolioColors.OnSecondaryContainer,
    tertiary = PortfolioColors.Tertiary,
    onTertiary = PortfolioColors.OnTertiary,
    tertiaryContainer = PortfolioColors.TertiaryContainer,
    onTertiaryContainer = PortfolioColors.OnTertiaryContainer,
    background = PortfolioColors.Background,
    onBackground = PortfolioColors.OnBackground,
    surface = PortfolioColors.Surface,
    onSurface = PortfolioColors.OnSurface,
    surfaceVariant = PortfolioColors.SurfaceVariant,
    onSurfaceVariant = PortfolioColors.OnSurfaceVariant,
    surfaceContainerLowest = PortfolioColors.SurfaceContainerLowest,
    surfaceContainerLow = PortfolioColors.SurfaceContainerLow,
    surfaceContainer = PortfolioColors.SurfaceContainer,
    surfaceContainerHigh = PortfolioColors.SurfaceContainerHigh,
    surfaceContainerHighest = PortfolioColors.SurfaceContainerHighest,
    outline = PortfolioColors.Outline,
    outlineVariant = PortfolioColors.OutlineVariant,
    error = PortfolioColors.Rose,
    onError = Color.White
)

val MaterialYouShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(32.dp)
)

val MaterialYouTypography = Typography(
    displayLarge = TextStyle(
        fontWeight = FontWeight.Black,
        fontSize = 44.sp,
        lineHeight = 52.sp,
        letterSpacing = (-0.5).sp
    ),
    displayMedium = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 34.sp,
        lineHeight = 42.sp
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 28.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 20.sp
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)

@Composable
fun PortfolioTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = MaterialYouDarkColorScheme,
        shapes = MaterialYouShapes,
        typography = MaterialYouTypography,
        content = content
    )
}
