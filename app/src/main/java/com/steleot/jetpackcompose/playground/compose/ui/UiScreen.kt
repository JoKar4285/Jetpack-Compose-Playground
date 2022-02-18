package com.steleot.jetpackcompose.playground.compose.ui

import androidx.compose.runtime.Composable
import com.steleot.jetpackcompose.playground.compose.rest.MainScreen
import com.steleot.jetpackcompose.playground.navigation.MainNavRoutes
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

val routes = listOf(
    UiNavRoutes.AlignmentLine,
    UiNavRoutes.Alpha,
    UiNavRoutes.AndroidViewBinding,
    UiNavRoutes.AnnotatedString,
    UiNavRoutes.Blur,
    UiNavRoutes.Brush,
    UiNavRoutes.Clip,
//    UiNavRoutes.ClipToBounds,
    UiNavRoutes.Color,
    UiNavRoutes.DebugInspectorInfo,
    UiNavRoutes.Dialog,
    UiNavRoutes.Drawable,
    UiNavRoutes.DrawBehind,
    UiNavRoutes.DrawWithCache,
//    UiNavRoutes.DrawWithContent,
    UiNavRoutes.Font,
    UiNavRoutes.GraphicsLayer,
    UiNavRoutes.ImageBitmapToPixelMap,
    UiNavRoutes.Inspectable,
    UiNavRoutes.LayoutId,
    UiNavRoutes.Layout,
//    UiNavRoutes.LocalAccessibilityManager,
//    UiNavRoutes.LocalAutofill,
//    UiNavRoutes.LocalAutofillTree,
    UiNavRoutes.LocalClipboardManager,
    UiNavRoutes.LocalConfiguration,
    UiNavRoutes.LocalContext,
    UiNavRoutes.LocalDensity,
    UiNavRoutes.LocalFocusManager,
    UiNavRoutes.LocalFontFamilyResolver,
    UiNavRoutes.LocalHapticFeedback,
    UiNavRoutes.LocalLayoutDirection,
    UiNavRoutes.LocalLifecycleOwner,
    UiNavRoutes.LocalSavedStateRegistryOwner,
    UiNavRoutes.LocalSoftwareKeyboardController,
    UiNavRoutes.LocalTextInputService,
    UiNavRoutes.LocalTextToolbar,
    UiNavRoutes.LocalUriHandler,
    UiNavRoutes.LocalViewConfiguration,
    UiNavRoutes.LocalWindowInfo,
    UiNavRoutes.ModifierLocal,
    UiNavRoutes.NestedScroll,
    UiNavRoutes.OnGloballyPositioned,
//    UiNavRoutes.OnKeyEvent,
    UiNavRoutes.OnPlaced,
    UiNavRoutes.OnSizeChanged,
    UiNavRoutes.Paint,
    UiNavRoutes.PathEffect,
    UiNavRoutes.PointerInput,
    UiNavRoutes.Popup,
    UiNavRoutes.Primitive,
    UiNavRoutes.Rotate,
    UiNavRoutes.Scale,
    UiNavRoutes.Shadow,
    UiNavRoutes.SpanStyle,
    UiNavRoutes.String,
    UiNavRoutes.SubComposeLayout,
    UiNavRoutes.TestTag,
    UiNavRoutes.TextDecoration,
    UiNavRoutes.TextIndent,
    UiNavRoutes.VisualTransformation,
    UiNavRoutes.ZIndex,
)

@Composable
fun UiScreen() {
    MainScreen(
        title = MainNavRoutes.Ui,
        list = routes,
    )
}
