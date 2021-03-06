package com.mapbox.mapboxsdk.utils

import android.support.test.espresso.IdlingResource

import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.maps.SupportMapFragment

class OnMapFragmentReadyIdlingResource(fragment: SupportMapFragment?) : IdlingResource, OnMapReadyCallback {

  var mapboxMap: MapboxMap? = null
  private var resourceCallback: IdlingResource.ResourceCallback? = null

  init {
    fragment?.getMapAsync(this)
  }

  override fun getName(): String {
    return javaClass.simpleName
  }

  override fun isIdleNow(): Boolean {
    return mapboxMap != null
  }

  override fun registerIdleTransitionCallback(resourceCallback: IdlingResource.ResourceCallback) {
    this.resourceCallback = resourceCallback
  }

  override fun onMapReady(mapboxMap: MapboxMap) {
    this.mapboxMap = mapboxMap
    if (resourceCallback != null) {
      resourceCallback!!.onTransitionToIdle()
    }
  }
}