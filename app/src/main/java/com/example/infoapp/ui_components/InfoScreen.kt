package com.example.infoapp.ui_components

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.infoapp.ui.theme.MainRed
import com.example.infoapp.utils.ListItem
@Composable
fun InfoScreen(item: ListItem){
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AssetImage(
                imageName = item.imageName,
                contentDescription = item.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Card (
                shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp)
                ) {
                    Text(
                        modifier= Modifier
                            .fillMaxWidth()
                            .background(MainRed)
                            .padding(5.dp)
                        ,
                        text = item.title,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }

            HtmlLoader(htmlName = item.htmlName )
        }
    }
}

@Composable
fun HtmlLoader(htmlName: String){
    val context = LocalContext.current
    val assetManger = context.assets
    val inputStream = assetManger.open("html/$htmlName")
    val size = inputStream.available()
    val buffer = ByteArray(size)
    inputStream.read(buffer)
    val htmlString = String(buffer)

    AndroidView(
        modifier = Modifier.fillMaxSize()
        ,
        factory = {
        WebView(it).apply {
            webViewClient = WebViewClient()
            loadData(htmlString, "text/html", "utf-8")
        }
        } )
}
@Preview
@Composable
fun PrevInfoScreen () {
     val list = ListItem("Апельсин","apelsin.png","apelsin.html")
    InfoScreen(list)
}