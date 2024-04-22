package com.example.kotlinbasicexp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinbasicexp.ui.theme.KotlinBasicExpTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaunchedEffect(key1 = null) {
                GlobalScope.launch {
                    val data = producer()
                    data.collect {
                        Log.d("First collector", "$it")
                    }
                }
                GlobalScope.launch {
                    val data1 = producer()
                    data1.collect{
                        Log.d("Sec collector" ,"$it")
                    }
                }
            }

        }
    }
}

private fun producer(): Flow<Int> {
    var mutableSharedFlow = MutableSharedFlow<Int>()
    val list = listOf<Int>(1, 2, 3, 4, 5)
    GlobalScope.launch {
        list.forEach {

            mutableSharedFlow.emit(it)
            delay(1000)
        }
    }
    return mutableSharedFlow
}

