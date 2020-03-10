package com.example.anthonyodu.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.internal.*
import javax.inject.Inject

typealias FilterArray = ArrayList<Filter>


@Parcelize
data class Filter @Inject constructor(
    val id: String,
    val avatar: String,
    val fullName:  String,
    val createdAt: String,
    val gender: String,
    val colors: List<String>,
    val countries: List<String>
):Parcelable


@Parcelize
@Serializable(with = Color.Companion::class)
enum class Color(val value: String):Parcelable {
    Aquamarine("Aquamarine"),
    Blue("Blue"),
    Green("Green"),
    Maroon("Maroon"),
    Mauv("Mauv"),
    Orange("Orange"),
    Red("Red"),
    Teal("Teal"),
    Violet("Violet"),
    Yellow("Yellow");

    companion object : KSerializer<Color> {
        override val descriptor: SerialDescriptor get() {
            return StringDescriptor
        }
        override fun deserialize(decoder: Decoder): Color = when (decoder.decodeString()) {
            "Aquamarine" -> Aquamarine
            "Blue"       -> Blue
            "Green"      -> Green
            "Maroon"     -> Maroon
            "Mauv"       -> Mauv
            "Orange"     -> Orange
            "Red"        -> Red
            "Teal"       -> Teal
            "Violet"     -> Violet
            "Yellow"     -> Yellow
            else         -> throw IllegalArgumentException()
        }
        override fun serialize(encoder: Encoder, obj: Color) {
            return encoder.encodeString(obj.value)
        }
    }
}


@Serializable(with = Country.Companion::class)
enum class Country(val value: String){
    China("China"),
    Colombia("Colombia"),
    Estonia("Estonia"),
    France("france"),
    Japan("Japan"),
    Mexico("Mexico"),
    SouthAfrica("South Africa");

    companion object : KSerializer<Country> {
        override val descriptor: SerialDescriptor get() {
            return StringDescriptor
        }
        override fun deserialize(decoder: Decoder): Country = when (decoder.decodeString()) {
            "China"        -> China
            "Colombia"     -> Colombia
            "Estonia"      -> Estonia
            "france"       -> France
            "Japan"        -> Japan
            "Mexico"       -> Mexico
            "South Africa" -> SouthAfrica
            else           -> throw IllegalArgumentException()
        }
        override fun serialize(encoder: Encoder, obj: Country) {
            return encoder.encodeString(obj.value)
        }
    }
}


@Serializable(with = Gender.Companion::class)
enum class Gender(val value: String) {
    Female("female"),
    Male("male");

    companion object : KSerializer<Gender> {
        override val descriptor: SerialDescriptor get() {
            return StringDescriptor
        }
        override fun deserialize(decoder: Decoder): Gender = when (decoder.decodeString()) {
            "female" -> Female
            "male"   -> Male
            else     -> throw IllegalArgumentException()
        }
        override fun serialize(encoder: Encoder, obj: Gender) {
            return encoder.encodeString(obj.value)
        }
    }
}