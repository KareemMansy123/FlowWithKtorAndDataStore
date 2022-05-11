package com.mansy.datastorewithktor.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.mansy.datastorewithktor.core.flow.ViewModelFactory
import com.mansy.datastorewithktor.data.newModel.StoreViewModel
import com.mansy.datastorewithktor.data.remote.view_modes.PostsVM
import com.mansy.datastorewithktor.ui.theme.DataStoreWithKtorTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

/*
created by Mansy 30/4/2022
 */
class MainActivity : ComponentActivity() {
    lateinit var postsViewModel: PostsVM
    lateinit var storeViewModel: StoreViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postsViewModel = ViewModelProvider(this, ViewModelFactory)[PostsVM::class.java]
//        storeViewModel = ViewModelProvider(this, ViewModelFactory)[StoreViewModel::class.java]
        setContent {
            LaunchedEffect(key1 = true, block = {
                postsViewModel.requestPosts()
//                storeViewModel.storeData(postsViewModel.posts.data ?: emptyList())
            })
            DataStoreWithKtorTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn {
                        items(postsViewModel.posts.data ?: emptyList()) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(text = it.title!!, fontSize = 20.sp)
                            }
                        }
                    }
                }

            }
        }
    }
}