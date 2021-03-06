package com.example.anthonyodu.broadcastReceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.contactapp.utils.ConnectionStatus
import com.example.contactapp.utils.NetworkUtil
import com.example.contactapp.utils.NetworkUtil.getConnectivityStatusString


class NetworkChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent) {
        val status = context?.let { getConnectivityStatusString(it) }
        if ("android.net.conn.CONNECTIVITY_CHANGE" == intent.action) {
            val con: ConnectionStatus? = null
            if (status == NetworkUtil.NETWORK_STATUS_NOT_CONNECTED) {
                Toast.makeText(context,"Not Connected",Toast.LENGTH_LONG).show()
                con?.isConnected()
                Log.e("Helooo", "Not Connected")
            } else {
                Log.e("Helooo", "onnected")
                Toast.makeText(context,"Connected",Toast.LENGTH_LONG).show()
            }
        }

        fun isConnected2(){

        }

    }


}