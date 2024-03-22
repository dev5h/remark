    package com.shazin.remark.Views

    import android.content.Context
    import android.webkit.WebSettings
    import androidx.compose.ui.graphics.vector.ImageVector
    import androidx.compose.ui.res.vectorResource
    import android.webkit.WebView
    import android.webkit.WebViewClient
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.rememberScrollState
    import androidx.compose.foundation.text.BasicTextField
    import androidx.compose.foundation.text.KeyboardOptions
    import androidx.compose.foundation.verticalScroll
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.ArrowBack
    import androidx.compose.material3.Button
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Icon
    import androidx.compose.material3.IconButton
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Text
    import androidx.compose.material3.TopAppBar
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.LaunchedEffect
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.ui.ExperimentalComposeUiApi
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.focus.FocusRequester
    import androidx.compose.ui.focus.focusRequester
    import androidx.compose.ui.graphics.Brush
    import androidx.compose.ui.graphics.SolidColor
    import androidx.compose.ui.graphics.toArgb
    import androidx.compose.ui.platform.LocalContext
    import androidx.compose.ui.platform.LocalSoftwareKeyboardController
    import androidx.compose.ui.platform.LocalWindowInfo
    import androidx.compose.ui.text.TextStyle
    import androidx.compose.ui.text.input.KeyboardType
    import androidx.compose.ui.text.input.TextFieldValue
    import androidx.compose.ui.text.input.VisualTransformation
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.compose.ui.viewinterop.AndroidView
    import androidx.navigation.NavHostController
    import com.shazin.remark.R
    import com.shazin.remark.getPreviewTemplate
    import com.shazin.remark.getRGB


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Writer(navHostController: NavHostController){
        val context = LocalContext.current
        val showPreview = remember {
            mutableStateOf(false)
        }
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { /*TODO*/ },
                    navigationIcon = {
                        IconButton(onClick = { navHostController.popBackStack() }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back button" )
                        }
                    },
                    actions = {
                        IconButton(onClick = { showPreview.value = !showPreview.value }) {
                            Icon(imageVector = ImageVector.vectorResource(R.drawable.visibility), contentDescription ="Preview Icon" )
                        }
                    }
                )
            }
        ) {paddingValues ->
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)){
                if (!showPreview.value){
                    Writer_Input(navHostController = navHostController)
                }else {
                    WebViewScreen(context = context)
                }
            }
        }
    }

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun Writer_Input(navHostController: NavHostController){
        val textState = remember { mutableStateOf("") }
        val keyboardController = LocalSoftwareKeyboardController.current
        val focusRequester = FocusRequester()
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 15.dp)
        ) {
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)){
                Text(
                    text = "March 12 · 123 Characters",
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
                    style = MaterialTheme.typography.bodySmall
                )
            }
                    BasicTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .focusRequester(focusRequester),
                        value = textState.value,
                        cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
                        onValueChange = {textState.value = it},
                        textStyle = TextStyle(
                            color = MaterialTheme.colorScheme.onBackground,
                        ),
                        maxLines = Int.MAX_VALUE,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, autoCorrect = false),
                )
        }

    }


    @Composable
    fun WebViewScreen(context: Context){
        val htmlTemplate = getPreviewTemplate(context)
        val bg =MaterialTheme.colorScheme.background
        val onBg =MaterialTheme.colorScheme.onBackground
        val webView = remember { WebView(context) }
        val webViewInitiated = remember{ mutableStateOf(false) }
        AndroidView(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            factory = { context ->
                webView.apply {
                    settings.javaScriptEnabled = true
                    settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
                    webViewClient = WebViewClient()


                }
            },
            update = { wv ->
                wv.loadUrl("file:///android_asset/html/index.html?fg=white}")
                wv.setBackgroundColor(bg.toArgb())
                webViewInitiated.value = true
            }
        )
        LaunchedEffect(key1 = webViewInitiated.value) {
            println("Ran")
            webView.evaluateJavascript("document.body.style.color = 'red'",null)
        }

        Button(onClick = {
            webView.evaluateJavascript("document.body.style.color = 'red'",null)
        }) {

            Text(text = "hello")
        }
    }