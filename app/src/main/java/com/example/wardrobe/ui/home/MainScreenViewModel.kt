package com.example.wardrobe.ui.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * 作用：
 *
 * @author chenkexi
 * @date :2023/11/8
 */
@HiltViewModel
class MainScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val plantId: String = savedStateHandle.get<String>(PLANT_ID_SAVED_STATE_KEY)!!


    companion object {
        private const val PLANT_ID_SAVED_STATE_KEY = "plantId"
    }
}