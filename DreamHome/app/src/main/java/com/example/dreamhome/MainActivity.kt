package com.example.dreamhome

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.dreamhome.ui.theme.DreamHomeTheme
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DreamHomeTheme {
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

    BottomAppBar()
}


@Composable
fun BottomAppBar() {
    val scaffoldState = rememberScaffoldState()

    Scaffold (
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomAppBar(backgroundColor = Color(0xFFF9F9F9))
            {
                Button(
                    border = null,
                    elevation = null,
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
                    border = null,
                    elevation = null,
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
                    border = null,
                    elevation = null,
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
                    border = null,
                    elevation = null,
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
    ) {
        it
        MapScreen()
    }

}

@Composable
fun MapScreen() {
    val context = LocalContext.current
    val cameraPositionState = rememberCameraPositionState {
//        position = com.google.android.gms.maps.CameraPosition.fromLatLngZoom(LatLng(0.0, 0.0), 10f)
    }

    val selectedPosition = remember { mutableStateOf<LatLng?>(null) }

    GoogleMap(
        modifier = Modifier.fillMaxWidth().height(757.dp),
        cameraPositionState = cameraPositionState,
        onMapLongClick = { latLng ->
            selectedPosition.value = latLng
            Toast.makeText(context, "Long clicked at: ${latLng.latitude}, ${latLng.longitude}", Toast.LENGTH_SHORT).show()
        }
    )

    selectedPosition.value?.let { position ->
        Marker(
            state = MarkerState(position = position),
            title = "Selected Position"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DreamHomeTheme {
        Greeting("Android")
    }
}