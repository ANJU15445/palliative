package com.example.palliative.api.Model

import java.net.Inet4Address

data class PatientRequest (var name:String,
                           var address: String,
                           var age:String,
                           var phoneno:String,
                           var Gender:String,
                           var occupation:String,
                           var disease:String,
                           var doctor:String)
