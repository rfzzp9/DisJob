package com.example.dreamhome

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.*
import com.example.dreamhome.ui.theme.DreamHomeTheme


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomAppBar()
            FragmentContainer(
                modifier = Modifier.fillMaxSize(),
                fragmentManager = supportFragmentManager,
                commit = { add(it, MapFragment())}
            )
        }
    }
}



@Composable
fun FragmentContainer(
    modifier: Modifier = Modifier,
    fragmentManager: FragmentManager,
    commit: FragmentTransaction.(containerId: Int) -> Unit
) {
    val containerId = remember { View.generateViewId() }
    var initialized by remember { mutableStateOf(false) }

    AndroidView(
        modifier = modifier,
        factory = { context ->
            FragmentContainerView(context)
                .apply { id = containerId }
        },
        update = { view ->
            if (!initialized) {
                fragmentManager.commit { commit(view.id) }
                initialized = true
            } else {
                fragmentManager.onContainerAvailable(view)
            }
        }
    )
}

private fun FragmentManager.onContainerAvailable(view: FragmentContainerView) {
    val method = FragmentManager::class.java.getDeclaredMethod(
        "onContainerAvailable",
        FragmentContainerView::class.java
    )
    method.isAccessible = true
    method.invoke(this, view)
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
        Log.e(it.toString(), "str")
    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DreamHomeTheme {

    }
}