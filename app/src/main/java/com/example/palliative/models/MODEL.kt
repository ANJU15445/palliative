package com.example.palliative.models

data class Service(var title:String)
object Supplier {
    val services = listOf<Service>(
        Service("VOLUNTEER"),
        Service("HOME NURSE"),
        Service("CLEANING"),
        Service("PSYCHOLOGIST"),
        Service("DOCTORS"),
        Service("NURSE"),
        Service("BABY CARE")
    )
}