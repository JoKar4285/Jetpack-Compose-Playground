package com.steleot.jetpackcompose.playground.compose.materialiconsextended

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.navigation.graph.MaterialIconsExtendedNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold

private const val Url = "materialiconsextended/ExtendedSharpScreen.kt"

@Composable
fun ExtendedSharpScreen() {
    DefaultScaffold(
        title = MaterialIconsExtendedNavRoutes.ExtendedSharp,
        link = Url,
    ) {
        ExtendedSharpGrid()
    }
}

private val list = listOf(
    Icons.Sharp._3dRotation,
    Icons.Sharp._4k,
    Icons.Sharp._5g,
    Icons.Sharp._6FtApart,
    Icons.Sharp._360,
    Icons.Sharp.AccessAlarm,
    Icons.Sharp.AccessAlarms,
    Icons.Sharp.Accessibility,
    Icons.Sharp.AccessibilityNew,
    Icons.Sharp.AccessibleForward,
    Icons.Sharp.Accessible,
    Icons.Sharp.AccessTime,
    Icons.Sharp.AccountBalance,
    Icons.Sharp.AccountBalanceWallet,
    Icons.Sharp.AccountTree,
    Icons.Sharp.AcUnit,
    Icons.Sharp.Adb,
    Icons.Sharp.AddAlarm,
    Icons.Sharp.AddAlert,
    Icons.Sharp.AddAPhoto,
    Icons.Sharp.AddBox,
    Icons.Sharp.AddBusiness,
    Icons.Sharp.Addchart,
    Icons.Sharp.AddCircleOutline,
    Icons.Sharp.AddComment,
    Icons.Sharp.AddIcCall,
    Icons.Sharp.AddLocation,
    Icons.Sharp.AddLocationAlt,
    Icons.Sharp.AddPhotoAlternate,
    Icons.Sharp.AddRoad,
    Icons.Sharp.AddShoppingCart,
    Icons.Sharp.AddTask,
    Icons.Sharp.AddToHomeScreen,
    Icons.Sharp.AddToPhotos,
    Icons.Sharp.AddToQueue,
    Icons.Sharp.Adjust,
    Icons.Sharp.AdminPanelSettings,
    Icons.Sharp.AdUnits,
    Icons.Sharp.Agriculture,
    Icons.Sharp.AirlineSeatFlatAngled,
    Icons.Sharp.AirlineSeatFlat,
    Icons.Sharp.AirlineSeatIndividualSuite,
    Icons.Sharp.AirlineSeatLegroomExtra,
    Icons.Sharp.AirlineSeatLegroomNormal,
    Icons.Sharp.AirlineSeatLegroomReduced,
    Icons.Sharp.AirlineSeatReclineExtra,
    Icons.Sharp.AirlineSeatReclineNormal,
    Icons.Sharp.AirplanemodeActive,
    Icons.Sharp.AirplanemodeInactive,
    Icons.Sharp.Airplay,
    Icons.Sharp.AirportShuttle,
    Icons.Sharp.AlarmAdd,
    Icons.Sharp.Alarm,
    Icons.Sharp.AlarmOff,
    Icons.Sharp.AlarmOn,
    Icons.Sharp.Album,
    Icons.Sharp.AlignHorizontalCenter,
    Icons.Sharp.AlignHorizontalLeft,
    Icons.Sharp.AlignHorizontalRight,
    Icons.Sharp.AlignVerticalBottom,
    Icons.Sharp.AlignVerticalCenter,
    Icons.Sharp.AlignVerticalTop,
    Icons.Sharp.AllInbox,
    Icons.Sharp.AllInclusive,
    Icons.Sharp.AltRoute,
    Icons.Sharp.AmpStories,
    Icons.Sharp.Analytics,
    Icons.Sharp.Anchor,
    Icons.Sharp.Android,
    Icons.Sharp.Announcement,
    Icons.Sharp.Apartment,
    Icons.Sharp.Api,
    Icons.Sharp.AppBlocking,
    Icons.Sharp.AppSettingsAlt,
    Icons.Sharp.Apps,
    Icons.Sharp.Architecture,
    Icons.Sharp.Archive,
    Icons.Sharp.ArrowBackIos,
    Icons.Sharp.ArrowCircleDown,
    Icons.Sharp.ArrowCircleUp,
    Icons.Sharp.ArrowDownward,
    Icons.Sharp.ArrowDropDownCircle,
    Icons.Sharp.ArrowDropUp,
    Icons.Sharp.ArrowForwardIos,
    Icons.Sharp.ArrowLeft,
    Icons.Sharp.ArrowRightAlt,
    Icons.Sharp.ArrowRight,
    Icons.Sharp.ArrowUpward,
    Icons.Sharp.Article,
    Icons.Sharp.ArtTrack,
    Icons.Sharp.AspectRatio,
    Icons.Sharp.Assessment,
    Icons.Sharp.AssignmentInd,
    Icons.Sharp.Assignment,
    Icons.Sharp.AssignmentLate,
    Icons.Sharp.AssignmentReturned,
    Icons.Sharp.AssignmentReturn,
    Icons.Sharp.AssignmentTurnedIn,
    Icons.Sharp.Assistant,
    Icons.Sharp.AssistantPhoto,
    Icons.Sharp.Atm,
    Icons.Sharp.AttachEmail,
    Icons.Sharp.AttachFile,
    Icons.Sharp.Attachment,
    Icons.Sharp.AttachMoney,
    Icons.Sharp.Audiotrack,
    Icons.Sharp.AutoDelete,
    Icons.Sharp.Autorenew,
    Icons.Sharp.AvTimer,
    Icons.Sharp.BabyChangingStation,
    Icons.Sharp.Backpack,
    Icons.Sharp.Backspace,
    Icons.Sharp.Backup,
    Icons.Sharp.BackupTable,
    Icons.Sharp.Badge,
    Icons.Sharp.BakeryDining,
    Icons.Sharp.Balcony,
    Icons.Sharp.Ballot,
    Icons.Sharp.BarChart,
    Icons.Sharp.BatchPrediction,
    Icons.Sharp.Bathroom,
    Icons.Sharp.Bathtub,
    Icons.Sharp.BatteryAlert,
    Icons.Sharp.BatteryChargingFull,
    Icons.Sharp.BatteryFull,
    Icons.Sharp.BatterySaver,
    Icons.Sharp.BatteryStd,
    Icons.Sharp.BatteryUnknown,
    Icons.Sharp.BeachAccess,
    Icons.Sharp.Bed,
    Icons.Sharp.BedroomBaby,
    Icons.Sharp.BedroomChild,
    Icons.Sharp.BedroomParent,
    Icons.Sharp.Bedtime,
    Icons.Sharp.Beenhere,
    Icons.Sharp.Bento,
    Icons.Sharp.BikeScooter,
    Icons.Sharp.Biotech,
    Icons.Sharp.Blender,
    Icons.Sharp.Block,
    Icons.Sharp.Bloodtype,
    Icons.Sharp.BluetoothAudio,
    Icons.Sharp.BluetoothConnected,
    Icons.Sharp.BluetoothDisabled,
    Icons.Sharp.BluetoothDrive,
    Icons.Sharp.Bluetooth,
    Icons.Sharp.BluetoothSearching,
    Icons.Sharp.BlurCircular,
    Icons.Sharp.BlurLinear,
    Icons.Sharp.BlurOff,
    Icons.Sharp.BlurOn,
    Icons.Sharp.Bolt,
    Icons.Sharp.Book,
    Icons.Sharp.BookmarkAdded,
    Icons.Sharp.BookmarkAdd,
    Icons.Sharp.BookmarkBorder,
    Icons.Sharp.Bookmark,
    Icons.Sharp.BookmarkRemove,
    Icons.Sharp.Bookmarks,
    Icons.Sharp.BookOnline,
    Icons.Sharp.BorderAll,
    Icons.Sharp.BorderBottom,
    Icons.Sharp.BorderClear,
    Icons.Sharp.BorderColor,
    Icons.Sharp.BorderHorizontal,
    Icons.Sharp.BorderInner,
    Icons.Sharp.BorderLeft,
    Icons.Sharp.BorderOuter,
    Icons.Sharp.BorderRight,
    Icons.Sharp.BorderStyle,
    Icons.Sharp.BorderTop,
    Icons.Sharp.BorderVertical,
    Icons.Sharp.BrandingWatermark,
    Icons.Sharp.BreakfastDining,
    Icons.Sharp.Brightness1,
    Icons.Sharp.Brightness2,
    Icons.Sharp.Brightness3,
    Icons.Sharp.Brightness4,
    Icons.Sharp.Brightness5,
    Icons.Sharp.Brightness6,
    Icons.Sharp.Brightness7,
    Icons.Sharp.BrightnessAuto,
    Icons.Sharp.BrightnessHigh,
    Icons.Sharp.BrightnessLow,
    Icons.Sharp.BrightnessMedium,
    Icons.Sharp.BrokenImage,
    Icons.Sharp.BrowserNotSupported,
    Icons.Sharp.BrunchDining,
    Icons.Sharp.Brush,
    Icons.Sharp.BubbleChart,
    Icons.Sharp.BugReport,
    Icons.Sharp.BuildCircle,
    Icons.Sharp.Bungalow,
    Icons.Sharp.BurstMode,
    Icons.Sharp.BusAlert,
    Icons.Sharp.BusinessCenter,
    Icons.Sharp.Business,
    Icons.Sharp.Cabin,
    Icons.Sharp.Cable,
    Icons.Sharp.Cached,
    Icons.Sharp.Cake,
    Icons.Sharp.Calculate,
    Icons.Sharp.CalendarToday,
    Icons.Sharp.CalendarViewDay,
    Icons.Sharp.CalendarViewMonth,
    Icons.Sharp.CalendarViewWeek,
    Icons.Sharp.CallEnd,
    Icons.Sharp.CallMade,
    Icons.Sharp.CallMerge,
    Icons.Sharp.CallMissed,
    Icons.Sharp.CallMissedOutgoing,
    Icons.Sharp.CallReceived,
    Icons.Sharp.CallSplit,
    Icons.Sharp.CallToAction,
    Icons.Sharp.CameraAlt,
    Icons.Sharp.CameraEnhance,
    Icons.Sharp.CameraFront,
    Icons.Sharp.CameraIndoor,
    Icons.Sharp.Camera,
    Icons.Sharp.CameraOutdoor,
    Icons.Sharp.CameraRear,
    Icons.Sharp.CameraRoll,
)

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ExtendedSharpGrid() {
    LazyVerticalGrid(
        GridCells.Adaptive(60.dp)
    ) {
        items(list) {
            Icon(imageVector = it, contentDescription = null, modifier = Modifier.padding(8.dp))
        }
    }
}
