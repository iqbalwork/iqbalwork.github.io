package com.uziro.portfolio.ui.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Curated Android Material You dynamic color palettes.
 * Each seed generates a full tonal Light & Dark Material 3 ColorScheme.
 */
enum class MaterialYouPalette(
    val displayName: String,
    val subtitle: String,
    val previewPrimary: Color,
    val previewSecondary: Color,
    val previewTertiary: Color
) {
    ANDROID_SAGE(
        displayName = "Android Sage",
        subtitle = "Botanical emerald & teal",
        previewPrimary = Color(0xFF006B54),
        previewSecondary = Color(0xFF4A635A),
        previewTertiary = Color(0xFF3E6375)
    ),
    PIXEL_VIOLET(
        displayName = "Pixel Violet",
        subtitle = "Expressive iris & lavender",
        previewPrimary = Color(0xFF5B4BA4),
        previewSecondary = Color(0xFF5E5C71),
        previewTertiary = Color(0xFF7B5266)
    ),
    COMPOSE_BLUE(
        displayName = "Compose Blue",
        subtitle = "Jetpack cobalt & sky",
        previewPrimary = Color(0xFF1A5FB4),
        previewSecondary = Color(0xFF535F70),
        previewTertiary = Color(0xFF6B5778)
    ),
    TERRACOTTA(
        displayName = "Warm Clay",
        subtitle = "Pixel terracotta & sand",
        previewPrimary = Color(0xFF9A452B),
        previewSecondary = Color(0xFF77574D),
        previewTertiary = Color(0xFF6A5E2F)
    ),
    SLATE_MONO(
        displayName = "Slate Mono",
        subtitle = "Minimal neutral studio",
        previewPrimary = Color(0xFF3E4A59),
        previewSecondary = Color(0xFF575F6B),
        previewTertiary = Color(0xFF625970)
    )
}

@Immutable
data class SemanticStatusColors(
    val success: Color,
    val onSuccess: Color,
    val successContainer: Color,
    val onSuccessContainer: Color,
    val warning: Color,
    val warningContainer: Color,
    val onWarningContainer: Color
)

private val LightStatusColors = SemanticStatusColors(
    success = Color(0xFF146C2E),
    onSuccess = Color(0xFFFFFFFF),
    successContainer = Color(0xFFC8F7D0),
    onSuccessContainer = Color(0xFF002109),
    warning = Color(0xFF8A5000),
    warningContainer = Color(0xFFFFDDB8),
    onWarningContainer = Color(0xFF2B1700)
)

private val DarkStatusColors = SemanticStatusColors(
    success = Color(0xFF82D995),
    onSuccess = Color(0xFF003915),
    successContainer = Color(0xFF005321),
    onSuccessContainer = Color(0xFFC8F7D0),
    warning = Color(0xFFFFB960),
    warningContainer = Color(0xFF683B00),
    onWarningContainer = Color(0xFFFFDDB8)
)

val LocalStatusColors = staticCompositionLocalOf { LightStatusColors }

val MaterialTheme.statusColors: SemanticStatusColors
    @Composable
    @ReadOnlyComposable
    get() = LocalStatusColors.current

private fun buildLightColorScheme(palette: MaterialYouPalette): ColorScheme = when (palette) {
    MaterialYouPalette.ANDROID_SAGE -> lightColorScheme(
        primary = Color(0xFF006B54),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFA2F2D5),
        onPrimaryContainer = Color(0xFF002118),
        secondary = Color(0xFF4A635A),
        onSecondary = Color(0xFFFFFFFF),
        secondaryContainer = Color(0xFFCCE9DD),
        onSecondaryContainer = Color(0xFF072019),
        tertiary = Color(0xFF3E6375),
        onTertiary = Color(0xFFFFFFFF),
        tertiaryContainer = Color(0xFFC2E8FD),
        onTertiaryContainer = Color(0xFF001F2B),
        error = Color(0xFFBA1A1A),
        onError = Color(0xFFFFFFFF),
        errorContainer = Color(0xFFFFDAD6),
        onErrorContainer = Color(0xFF410002),
        background = Color(0xFFF5FBF7),
        onBackground = Color(0xFF171D1A),
        surface = Color(0xFFF5FBF7),
        onSurface = Color(0xFF171D1A),
        surfaceVariant = Color(0xFFDBE5DF),
        onSurfaceVariant = Color(0xFF3F4944),
        surfaceDim = Color(0xFFD5DBD7),
        surfaceBright = Color(0xFFF5FBF7),
        surfaceContainerLowest = Color(0xFFFFFFFF),
        surfaceContainerLow = Color(0xFFEFF5F1),
        surfaceContainer = Color(0xFFE9EFEB),
        surfaceContainerHigh = Color(0xFFE3EAE5),
        surfaceContainerHighest = Color(0xFFDDE4E0),
        outline = Color(0xFF707974),
        outlineVariant = Color(0xFFBFC9C3),
        inverseSurface = Color(0xFF2B322F),
        inverseOnSurface = Color(0xFFECF2EE),
        inversePrimary = Color(0xFF86D6BA)
    )

    MaterialYouPalette.PIXEL_VIOLET -> lightColorScheme(
        primary = Color(0xFF5B4BA4),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFE4DFFF),
        onPrimaryContainer = Color(0xFF170362),
        secondary = Color(0xFF5E5C71),
        onSecondary = Color(0xFFFFFFFF),
        secondaryContainer = Color(0xFFE4E0F9),
        onSecondaryContainer = Color(0xFF1B192C),
        tertiary = Color(0xFF7B5266),
        onTertiary = Color(0xFFFFFFFF),
        tertiaryContainer = Color(0xFFFFD8E8),
        onTertiaryContainer = Color(0xFF301122),
        error = Color(0xFFBA1A1A),
        onError = Color(0xFFFFFFFF),
        errorContainer = Color(0xFFFFDAD6),
        onErrorContainer = Color(0xFF410002),
        background = Color(0xFFFCF8FF),
        onBackground = Color(0xFF1C1B20),
        surface = Color(0xFFFCF8FF),
        onSurface = Color(0xFF1C1B20),
        surfaceVariant = Color(0xFFE5E1EC),
        onSurfaceVariant = Color(0xFF47464F),
        surfaceDim = Color(0xFFDCD9E0),
        surfaceBright = Color(0xFFFCF8FF),
        surfaceContainerLowest = Color(0xFFFFFFFF),
        surfaceContainerLow = Color(0xFFF6F2FA),
        surfaceContainer = Color(0xFFF0ECF4),
        surfaceContainerHigh = Color(0xFFEAE7EF),
        surfaceContainerHighest = Color(0xFFE4E1E9),
        outline = Color(0xFF787680),
        outlineVariant = Color(0xFFC8C5D0),
        inverseSurface = Color(0xFF313036),
        inverseOnSurface = Color(0xFFF3EFF7),
        inversePrimary = Color(0xFFC7BFFF)
    )

    MaterialYouPalette.COMPOSE_BLUE -> lightColorScheme(
        primary = Color(0xFF1A5FB4),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFD6E3FF),
        onPrimaryContainer = Color(0xFF001B3E),
        secondary = Color(0xFF535F70),
        onSecondary = Color(0xFFFFFFFF),
        secondaryContainer = Color(0xFFD7E3F8),
        onSecondaryContainer = Color(0xFF101C2B),
        tertiary = Color(0xFF6B5778),
        onTertiary = Color(0xFFFFFFFF),
        tertiaryContainer = Color(0xFFF3DAFF),
        onTertiaryContainer = Color(0xFF251432),
        error = Color(0xFFBA1A1A),
        onError = Color(0xFFFFFFFF),
        errorContainer = Color(0xFFFFDAD6),
        onErrorContainer = Color(0xFF410002),
        background = Color(0xFFF8F9FF),
        onBackground = Color(0xFF191C20),
        surface = Color(0xFFF8F9FF),
        onSurface = Color(0xFF191C20),
        surfaceVariant = Color(0xFFE0E2EC),
        onSurfaceVariant = Color(0xFF43474E),
        surfaceDim = Color(0xFFD8DAE0),
        surfaceBright = Color(0xFFF8F9FF),
        surfaceContainerLowest = Color(0xFFFFFFFF),
        surfaceContainerLow = Color(0xFFF2F3FA),
        surfaceContainer = Color(0xFFECEEF4),
        surfaceContainerHigh = Color(0xFFE6E8EE),
        surfaceContainerHighest = Color(0xFFE0E2E8),
        outline = Color(0xFF74777F),
        outlineVariant = Color(0xFFC4C6D0),
        inverseSurface = Color(0xFF2E3136),
        inverseOnSurface = Color(0xFFEFF0F7),
        inversePrimary = Color(0xFFA9C7FF)
    )

    MaterialYouPalette.TERRACOTTA -> lightColorScheme(
        primary = Color(0xFF9A452B),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFFFDBD0),
        onPrimaryContainer = Color(0xFF3A0B00),
        secondary = Color(0xFF77574D),
        onSecondary = Color(0xFFFFFFFF),
        secondaryContainer = Color(0xFFFFDBD0),
        onSecondaryContainer = Color(0xFF2C150E),
        tertiary = Color(0xFF6A5E2F),
        onTertiary = Color(0xFFFFFFFF),
        tertiaryContainer = Color(0xFFF3E2A7),
        onTertiaryContainer = Color(0xFF221B00),
        error = Color(0xFFBA1A1A),
        onError = Color(0xFFFFFFFF),
        errorContainer = Color(0xFFFFDAD6),
        onErrorContainer = Color(0xFF410002),
        background = Color(0xFFFFF8F6),
        onBackground = Color(0xFF231917),
        surface = Color(0xFFFFF8F6),
        onSurface = Color(0xFF231917),
        surfaceVariant = Color(0xFFF5DDD6),
        onSurfaceVariant = Color(0xFF53433E),
        surfaceDim = Color(0xFFE8D6D1),
        surfaceBright = Color(0xFFFFF8F6),
        surfaceContainerLowest = Color(0xFFFFFFFF),
        surfaceContainerLow = Color(0xFFFFF1EC),
        surfaceContainer = Color(0xFFFCEAE5),
        surfaceContainerHigh = Color(0xFFF6E4DF),
        surfaceContainerHighest = Color(0xFFF0DFDA),
        outline = Color(0xFF85736D),
        outlineVariant = Color(0xFFD8C2BB),
        inverseSurface = Color(0xFF392E2B),
        inverseOnSurface = Color(0xFFFFEDE8),
        inversePrimary = Color(0xFFFFB59E)
    )

    MaterialYouPalette.SLATE_MONO -> lightColorScheme(
        primary = Color(0xFF3E4A59),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFD6E3F7),
        onPrimaryContainer = Color(0xFF101C2B),
        secondary = Color(0xFF575F6B),
        onSecondary = Color(0xFFFFFFFF),
        secondaryContainer = Color(0xFFDBE3F1),
        onSecondaryContainer = Color(0xFF141C26),
        tertiary = Color(0xFF625970),
        onTertiary = Color(0xFFFFFFFF),
        tertiaryContainer = Color(0xFFE8DCF8),
        onTertiaryContainer = Color(0xFF1E172B),
        error = Color(0xFFBA1A1A),
        onError = Color(0xFFFFFFFF),
        errorContainer = Color(0xFFFFDAD6),
        onErrorContainer = Color(0xFF410002),
        background = Color(0xFFF8F9FA),
        onBackground = Color(0xFF191C1E),
        surface = Color(0xFFF8F9FA),
        onSurface = Color(0xFF191C1E),
        surfaceVariant = Color(0xFFE1E2E6),
        onSurfaceVariant = Color(0xFF44474C),
        surfaceDim = Color(0xFFD8DADF),
        surfaceBright = Color(0xFFF8F9FA),
        surfaceContainerLowest = Color(0xFFFFFFFF),
        surfaceContainerLow = Color(0xFFF2F3F6),
        surfaceContainer = Color(0xFFECEDF0),
        surfaceContainerHigh = Color(0xFFE6E8EB),
        surfaceContainerHighest = Color(0xFFE1E2E5),
        outline = Color(0xFF74777D),
        outlineVariant = Color(0xFFC4C6CC),
        inverseSurface = Color(0xFF2E3133),
        inverseOnSurface = Color(0xFFF0F1F4),
        inversePrimary = Color(0xFFB9C7DC)
    )
}

private fun buildDarkColorScheme(palette: MaterialYouPalette): ColorScheme = when (palette) {
    MaterialYouPalette.ANDROID_SAGE -> darkColorScheme(
        primary = Color(0xFF86D6BA),
        onPrimary = Color(0xFF00382B),
        primaryContainer = Color(0xFF00513F),
        onPrimaryContainer = Color(0xFFA2F2D5),
        secondary = Color(0xFFB1CCC1),
        onSecondary = Color(0xFF1D352D),
        secondaryContainer = Color(0xFF334C43),
        onSecondaryContainer = Color(0xFFCCE9DD),
        tertiary = Color(0xFFA6CCE0),
        onTertiary = Color(0xFF093545),
        tertiaryContainer = Color(0xFF254B5D),
        onTertiaryContainer = Color(0xFFC2E8FD),
        error = Color(0xFFFFB4AB),
        onError = Color(0xFF690005),
        errorContainer = Color(0xFF93000A),
        onErrorContainer = Color(0xFFFFDAD6),
        background = Color(0xFF0F1512),
        onBackground = Color(0xFFDDE4E0),
        surface = Color(0xFF0F1512),
        onSurface = Color(0xFFDDE4E0),
        surfaceVariant = Color(0xFF3F4944),
        onSurfaceVariant = Color(0xFFBFC9C3),
        surfaceDim = Color(0xFF0F1512),
        surfaceBright = Color(0xFF343B38),
        surfaceContainerLowest = Color(0xFF0A0F0D),
        surfaceContainerLow = Color(0xFF171D1A),
        surfaceContainer = Color(0xFF1B211E),
        surfaceContainerHigh = Color(0xFF252B28),
        surfaceContainerHighest = Color(0xFF303633),
        outline = Color(0xFF89938D),
        outlineVariant = Color(0xFF3F4944),
        inverseSurface = Color(0xFFDDE4E0),
        inverseOnSurface = Color(0xFF2B322F),
        inversePrimary = Color(0xFF006B54)
    )

    MaterialYouPalette.PIXEL_VIOLET -> darkColorScheme(
        primary = Color(0xFFC7BFFF),
        onPrimary = Color(0xFF2D1C73),
        primaryContainer = Color(0xFF43338B),
        onPrimaryContainer = Color(0xFFE4DFFF),
        secondary = Color(0xFFC8C3DC),
        onSecondary = Color(0xFF302E41),
        secondaryContainer = Color(0xFF474459),
        onSecondaryContainer = Color(0xFFE4E0F9),
        tertiary = Color(0xFFECB8CE),
        onTertiary = Color(0xFF482537),
        tertiaryContainer = Color(0xFF613B4E),
        onTertiaryContainer = Color(0xFFFFD8E8),
        error = Color(0xFFFFB4AB),
        onError = Color(0xFF690005),
        errorContainer = Color(0xFF93000A),
        onErrorContainer = Color(0xFFFFDAD6),
        background = Color(0xFF131318),
        onBackground = Color(0xFFE4E1E9),
        surface = Color(0xFF131318),
        onSurface = Color(0xFFE4E1E9),
        surfaceVariant = Color(0xFF47464F),
        onSurfaceVariant = Color(0xFFC8C5D0),
        surfaceDim = Color(0xFF131318),
        surfaceBright = Color(0xFF39383E),
        surfaceContainerLowest = Color(0xFF0E0E13),
        surfaceContainerLow = Color(0xFF1C1B20),
        surfaceContainer = Color(0xFF201F25),
        surfaceContainerHigh = Color(0xFF2A292F),
        surfaceContainerHighest = Color(0xFF35343A),
        outline = Color(0xFF928F99),
        outlineVariant = Color(0xFF47464F),
        inverseSurface = Color(0xFFE4E1E9),
        inverseOnSurface = Color(0xFF313036),
        inversePrimary = Color(0xFF5B4BA4)
    )

    MaterialYouPalette.COMPOSE_BLUE -> darkColorScheme(
        primary = Color(0xFFA9C7FF),
        onPrimary = Color(0xFF003063),
        primaryContainer = Color(0xFF00468C),
        onPrimaryContainer = Color(0xFFD6E3FF),
        secondary = Color(0xFFBBC7DB),
        onSecondary = Color(0xFF253141),
        secondaryContainer = Color(0xFF3C4758),
        onSecondaryContainer = Color(0xFFD7E3F8),
        tertiary = Color(0xFFD7BEE4),
        onTertiary = Color(0xFF3B2948),
        tertiaryContainer = Color(0xFF533F5F),
        onTertiaryContainer = Color(0xFFF3DAFF),
        error = Color(0xFFFFB4AB),
        onError = Color(0xFF690005),
        errorContainer = Color(0xFF93000A),
        onErrorContainer = Color(0xFFFFDAD6),
        background = Color(0xFF111318),
        onBackground = Color(0xFFE0E2E8),
        surface = Color(0xFF111318),
        onSurface = Color(0xFFE0E2E8),
        surfaceVariant = Color(0xFF43474E),
        onSurfaceVariant = Color(0xFFC4C6D0),
        surfaceDim = Color(0xFF111318),
        surfaceBright = Color(0xFF37393E),
        surfaceContainerLowest = Color(0xFF0C0E13),
        surfaceContainerLow = Color(0xFF191C20),
        surfaceContainer = Color(0xFF1D2024),
        surfaceContainerHigh = Color(0xFF282A2F),
        surfaceContainerHighest = Color(0xFF33353A),
        outline = Color(0xFF8E9099),
        outlineVariant = Color(0xFF43474E),
        inverseSurface = Color(0xFFE0E2E8),
        inverseOnSurface = Color(0xFF2E3136),
        inversePrimary = Color(0xFF1A5FB4)
    )

    MaterialYouPalette.TERRACOTTA -> darkColorScheme(
        primary = Color(0xFFFFB59E),
        onPrimary = Color(0xFF5D1904),
        primaryContainer = Color(0xFF7B2E16),
        onPrimaryContainer = Color(0xFFFFDBD0),
        secondary = Color(0xFFE7BDB0),
        onSecondary = Color(0xFF442A21),
        secondaryContainer = Color(0xFF5D4036),
        onSecondaryContainer = Color(0xFFFFDBD0),
        tertiary = Color(0xFFD6C68D),
        onTertiary = Color(0xFF393005),
        tertiaryContainer = Color(0xFF51461A),
        onTertiaryContainer = Color(0xFFF3E2A7),
        error = Color(0xFFFFB4AB),
        onError = Color(0xFF690005),
        errorContainer = Color(0xFF93000A),
        onErrorContainer = Color(0xFFFFDAD6),
        background = Color(0xFF1A110F),
        onBackground = Color(0xFFF0DFDA),
        surface = Color(0xFF1A110F),
        onSurface = Color(0xFFF0DFDA),
        surfaceVariant = Color(0xFF53433E),
        onSurfaceVariant = Color(0xFFD8C2BB),
        surfaceDim = Color(0xFF1A110F),
        surfaceBright = Color(0xFF423734),
        surfaceContainerLowest = Color(0xFF140C0A),
        surfaceContainerLow = Color(0xFF231917),
        surfaceContainer = Color(0xFF271D1B),
        surfaceContainerHigh = Color(0xFF322825),
        surfaceContainerHighest = Color(0xFF3D322F),
        outline = Color(0xFFA08D87),
        outlineVariant = Color(0xFF53433E),
        inverseSurface = Color(0xFFF0DFDA),
        inverseOnSurface = Color(0xFF392E2B),
        inversePrimary = Color(0xFF9A452B)
    )

    MaterialYouPalette.SLATE_MONO -> darkColorScheme(
        primary = Color(0xFFB9C7DC),
        onPrimary = Color(0xFF243140),
        primaryContainer = Color(0xFF3B4858),
        onPrimaryContainer = Color(0xFFD6E3F7),
        secondary = Color(0xFFBFC7D5),
        onSecondary = Color(0xFF29313C),
        secondaryContainer = Color(0xFF3F4853),
        onSecondaryContainer = Color(0xFFDBE3F1),
        tertiary = Color(0xFFCCC1DA),
        onTertiary = Color(0xFF332C3F),
        tertiaryContainer = Color(0xFF4A4257),
        onTertiaryContainer = Color(0xFFE8DCF8),
        error = Color(0xFFFFB4AB),
        onError = Color(0xFF690005),
        errorContainer = Color(0xFF93000A),
        onErrorContainer = Color(0xFFFFDAD6),
        background = Color(0xFF111316),
        onBackground = Color(0xFFE1E2E5),
        surface = Color(0xFF111316),
        onSurface = Color(0xFFE1E2E5),
        surfaceVariant = Color(0xFF44474C),
        onSurfaceVariant = Color(0xFFC4C6CC),
        surfaceDim = Color(0xFF111316),
        surfaceBright = Color(0xFF37393C),
        surfaceContainerLowest = Color(0xFF0C0E10),
        surfaceContainerLow = Color(0xFF191C1E),
        surfaceContainer = Color(0xFF1D2022),
        surfaceContainerHigh = Color(0xFF282A2D),
        surfaceContainerHighest = Color(0xFF333538),
        outline = Color(0xFF8E9096),
        outlineVariant = Color(0xFF44474C),
        inverseSurface = Color(0xFFE1E2E5),
        inverseOnSurface = Color(0xFF2E3133),
        inversePrimary = Color(0xFF3E4A59)
    )
}

@Composable
private fun animateColor(target: Color): Color {
    val animated by animateColorAsState(
        targetValue = target,
        animationSpec = tween(durationMillis = 320)
    )
    return animated
}

@Composable
private fun rememberAnimatedColorScheme(target: ColorScheme): ColorScheme = target.copy(
    primary = animateColor(target.primary),
    onPrimary = animateColor(target.onPrimary),
    primaryContainer = animateColor(target.primaryContainer),
    onPrimaryContainer = animateColor(target.onPrimaryContainer),
    inversePrimary = animateColor(target.inversePrimary),
    secondary = animateColor(target.secondary),
    onSecondary = animateColor(target.onSecondary),
    secondaryContainer = animateColor(target.secondaryContainer),
    onSecondaryContainer = animateColor(target.onSecondaryContainer),
    tertiary = animateColor(target.tertiary),
    onTertiary = animateColor(target.onTertiary),
    tertiaryContainer = animateColor(target.tertiaryContainer),
    onTertiaryContainer = animateColor(target.onTertiaryContainer),
    background = animateColor(target.background),
    onBackground = animateColor(target.onBackground),
    surface = animateColor(target.surface),
    onSurface = animateColor(target.onSurface),
    surfaceVariant = animateColor(target.surfaceVariant),
    onSurfaceVariant = animateColor(target.onSurfaceVariant),
    surfaceTint = animateColor(target.surfaceTint),
    inverseSurface = animateColor(target.inverseSurface),
    inverseOnSurface = animateColor(target.inverseOnSurface),
    error = animateColor(target.error),
    onError = animateColor(target.onError),
    errorContainer = animateColor(target.errorContainer),
    onErrorContainer = animateColor(target.onErrorContainer),
    outline = animateColor(target.outline),
    outlineVariant = animateColor(target.outlineVariant),
    surfaceBright = animateColor(target.surfaceBright),
    surfaceDim = animateColor(target.surfaceDim),
    surfaceContainer = animateColor(target.surfaceContainer),
    surfaceContainerHigh = animateColor(target.surfaceContainerHigh),
    surfaceContainerHighest = animateColor(target.surfaceContainerHighest),
    surfaceContainerLow = animateColor(target.surfaceContainerLow),
    surfaceContainerLowest = animateColor(target.surfaceContainerLowest),
)

val MaterialYouShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(28.dp)
)

val MaterialYouTypography = Typography(
    displayLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 52.sp,
        lineHeight = 60.sp,
        letterSpacing = (-0.5).sp
    ),
    displayMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        lineHeight = 48.sp,
        letterSpacing = (-0.25).sp
    ),
    displaySmall = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp
    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 30.sp,
        lineHeight = 38.sp
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 26.sp,
        lineHeight = 34.sp
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 30.sp
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 28.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.25.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 21.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)

@Composable
fun PortfolioTheme(
    darkTheme: Boolean = false,
    palette: MaterialYouPalette = MaterialYouPalette.ANDROID_SAGE,
    content: @Composable () -> Unit
) {
    val targetScheme = if (darkTheme) {
        buildDarkColorScheme(palette)
    } else {
        buildLightColorScheme(palette)
    }
    val animatedScheme = rememberAnimatedColorScheme(targetScheme)
    val statusColors = if (darkTheme) DarkStatusColors else LightStatusColors

    CompositionLocalProvider(LocalStatusColors provides statusColors) {
        MaterialTheme(
            colorScheme = animatedScheme,
            shapes = MaterialYouShapes,
            typography = MaterialYouTypography,
            content = content
        )
    }
}
