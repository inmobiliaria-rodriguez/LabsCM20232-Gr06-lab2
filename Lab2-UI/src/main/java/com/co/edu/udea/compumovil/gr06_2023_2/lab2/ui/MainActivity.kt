/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.co.edu.udea.compumovil.gr06_2023_2.lab2.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import com.co.edu.udea.compumovil.gr06_2023_2.lab2.JetnewsApplication
import com.co.edu.udea.compumovil.gr06_2023_2.lab2.data.room.PostDataBase
import com.co.edu.udea.compumovil.gr06_2023_2.lab2.data.room.PostViewModel

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val database = PostDataBase.getDataBase(this)
        val viewModel : PostViewModel
        viewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        val appContainer = (application as JetnewsApplication).container
        setContent {
            val widthSizeClass = calculateWindowSizeClass(this).widthSizeClass
            //
            JetnewsApp(appContainer, widthSizeClass, viewModel)
        }
    }
}
