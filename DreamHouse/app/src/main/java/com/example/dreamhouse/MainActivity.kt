package com.example.dreamhouse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.fragment.app.FragmentContainerView
import com.example.dreamhouse.ui.theme.DreamHouseTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DreamHouseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    BottomAppBarExample()
    NaverMapScreen()
    ConstraintLayout() {
        val (searchEdittext, mapView) = createRefs()

    }
}

@Composable
fun BottomAppBarExample() {
    val scaffoldState = rememberScaffoldState()

    Scaffold (
        scaffoldState = scaffoldState,
        bottomBar = {
                    BottomAppBar(backgroundColor = Color(0xFFF9F9F9))
            {
                Button(
//                    border = BorderStroke(0.dp, Color(0xFFF9F9F9)),
                    shape = RoundedCornerShape(0.dp),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF9F9F9)),
                    modifier = Modifier.weight(1f)) {
                    Column {
                        Icon(
                            painter = painterResource(R.drawable.home),
                            contentDescription = "",
                            modifier = Modifier
                                .size(27.dp)
                                .align(Alignment.CenterHorizontally),
                            tint = Color(0xFFAAAEB7)
                        )
                        Text(text = "홈", modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 10.sp, color = Color(0xFFAAAEB7))
                    }
                }
                Button(
//                    border = BorderStroke(0.dp, Color(0xFFF9F9F9)),
                    shape = RoundedCornerShape(0.dp),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF9F9F9)),
                    modifier = Modifier.weight(1f)) {
                    Column {
                        Icon(
                            painter = painterResource(R.drawable.marker),
                            contentDescription = "",
                            modifier = Modifier
                                .size(27.dp)
                                .align(Alignment.CenterHorizontally),
                            tint = Color(0xFFAAAEB7)
                        )
                        Text(text = "지도", modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 10.sp, color = Color(0xFFAAAEB7))
                    }
                }
                Button(
//                    border = BorderStroke(0.dp, Color(0xFFF9F9F9)),
                    shape = RoundedCornerShape(0.dp),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF9F9F9)),
                    modifier = Modifier.weight(1f)) {
                    Column {
                        Icon(
                            painter = painterResource(R.drawable.like),
                            contentDescription = "",
                            modifier = Modifier
                                .size(27.dp)
                                .align(Alignment.CenterHorizontally),
                            tint = Color(0xFFAAAEB7)
                        )
                        Text(text = "찜 목록", modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 10.sp, color = Color(0xFFAAAEB7))
                    }
                }
                Button(
//                    border = BorderStroke(0.dp, Color(0xFFF9F9F9)),
                    shape = RoundedCornerShape(0.dp),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF9F9F9)),
                    modifier = Modifier.weight(1f)) {
                    Column {
                        Icon(
                            painter = painterResource(R.drawable.etc),
                            contentDescription = "",
                            modifier = Modifier
                                .size(27.dp)
                                .align(Alignment.CenterHorizontally),
                            tint = Color(0xFFAAAEB7)
                        )
                        Text(text = "더보기", modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 10.sp, color = Color(0xFFAAAEB7))
                    }
                }
            }
        }
    ) {}

}

@Composable
fun NaverMapScreen() {
//    AndroidView(
//        factory = { context ->
//            MapView(context).apply {
//                getMapAsync { naverMap ->
//                    // 기본 카메라 위치 설정 (서울 시청)
//                    val cameraUpdate = CameraUpdate.scrollTo(LatLng(37.5665, 126.9780))
//                    naverMap.moveCamera(cameraUpdate)
//
//                    // UI 설정 (줌 컨트롤 활성화)
//                    naverMap.uiSettings.isZoomControlEnabled = true
//                }
//            }
//        },
//        modifier = Modifier.fillMaxSize()
//    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DreamHouseTheme {
        Greeting("Android")
    }
}