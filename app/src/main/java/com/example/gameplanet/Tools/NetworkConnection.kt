package com.example.gameplanet.Tools

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log

    class NetworkConnectionState(val context: Context) {
        fun checkNetwork():Boolean{
            var answer=false
            val connectivityManager =context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if(android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.M){
                Log.d(Constants.TAG,"Version mayor o igual a M")

                val network =  connectivityManager.activeNetwork
                if(network!=null){
                    connectivityManager.getNetworkCapabilities(network)?.run {
                        answer = when{
                            hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)-> {
                                Log.d(Constants.TAG,"TRANSPORT_CELLULAR activo")
                                true
                            }
                            hasTransport(NetworkCapabilities.TRANSPORT_WIFI)-> {
                                Log.d(Constants.TAG,"TRANSPORT_WIFI activo")
                                true
                            }
                            else-> {
                                Log.d(Constants.TAG,"Sin acceso a internet")
                                false
                            }
                        }
                    }
                }else{
                    Log.d(Constants.TAG,"network null")
                }
            }else{
                Log.d(Constants.TAG,"Version menor a M")
                connectivityManager.activeNetworkInfo?.run {
                    answer = isConnected
                }
            }

            return answer
        }
    }