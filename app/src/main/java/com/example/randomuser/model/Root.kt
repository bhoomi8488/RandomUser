package com.example.randomuser.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

//
// Created by bhoom on 2/23/2024.
// Copyright (c) 2024 Bhoomi. All rights reserved.
//

data class Root(
    @SerializedName("results") var results: ArrayList<Results> = arrayListOf(),
    @SerializedName("info") var info: Info? = Info()
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createTypedArrayList(Results.CREATOR) ?: arrayListOf(),
        parcel.readParcelable(Info::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(results)
        parcel.writeParcelable(info, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Root> {
        override fun createFromParcel(parcel: Parcel): Root {
            return Root(parcel)
        }

        override fun newArray(size: Int): Array<Root?> {
            return arrayOfNulls(size)
        }
    }
}

data class Results(
    @SerializedName("gender") val gender: String,
    @SerializedName("name") val name: Name,
    @SerializedName("location") val location: Location,
    @SerializedName("email") val email: String,
    @SerializedName("login") val login: Login,
    @SerializedName("dob") val dob: Dob,
    @SerializedName("registered") val registered: Registered,
    @SerializedName("phone") val phone: String,
    @SerializedName("cell") val cell: String,
    @SerializedName("id") val id: Id,
    @SerializedName("picture") val picture: Picture,
    @SerializedName("nat") val nat: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readParcelable(Name::class.java.classLoader) ?: Name(),
        parcel.readParcelable(Location::class.java.classLoader) ?: Location(),
        parcel.readString() ?: "",
        parcel.readParcelable(Login::class.java.classLoader) ?: Login(),
        parcel.readParcelable(Dob::class.java.classLoader) ?: Dob(),
        parcel.readParcelable(Registered::class.java.classLoader) ?: Registered(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readParcelable(Id::class.java.classLoader) ?: Id(),
        parcel.readParcelable(Picture::class.java.classLoader) ?: Picture(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(gender)
        parcel.writeParcelable(name, flags)
        parcel.writeParcelable(location, flags)
        parcel.writeString(email)
        parcel.writeParcelable(login, flags)
        parcel.writeParcelable(dob, flags)
        parcel.writeParcelable(registered, flags)
        parcel.writeString(phone)
        parcel.writeString(cell)
        parcel.writeParcelable(id, flags)
        parcel.writeParcelable(picture, flags)
        parcel.writeString(nat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Results> {
        override fun createFromParcel(parcel: Parcel): Results {
            return Results(parcel)
        }

        override fun newArray(size: Int): Array<Results?> {
            return arrayOfNulls(size)
        }
    }
}

data class Name(
    @SerializedName("title") var title: String? = null,
    @SerializedName("first") var first: String? = null,
    @SerializedName("last") var last: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(first)
        parcel.writeString(last)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Name> {
        override fun createFromParcel(parcel: Parcel): Name {
            return Name(parcel)
        }

        override fun newArray(size: Int): Array<Name?> {
            return arrayOfNulls(size)
        }
    }
}

data class Location(
    @SerializedName("street") var street: Street? = Street(),
    @SerializedName("city") var city: String? = null,
    @SerializedName("state") var state: String? = null,
    @SerializedName("country") var country: String? = null,
    @SerializedName("postcode") var postcode: Any? = null,
    @SerializedName("coordinates") var coordinates: Coordinates? = Coordinates(),
    @SerializedName("timezone") var timezone: Timezone? = Timezone()
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Street::class.java.classLoader) ?: Street(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        null,
        parcel.readParcelable(Coordinates::class.java.classLoader) ?: Coordinates(),
        parcel.readParcelable(Timezone::class.java.classLoader) ?: Timezone()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(street, flags)
        parcel.writeString(city)
        parcel.writeString(state)
        parcel.writeString(country)
        // TODO: Handle "postcode" serialization/deserialization
        // parcel.writeParcelable(postcode, flags)
        parcel.writeParcelable(coordinates, flags)
        parcel.writeParcelable(timezone, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Location> {
        override fun createFromParcel(parcel: Parcel): Location {
            return Location(parcel)
        }

        override fun newArray(size: Int): Array<Location?> {
            return arrayOfNulls(size)
        }
    }
}

data class Picture(
    @SerializedName("large") var large: String? = null,
    @SerializedName("medium") var medium: String? = null,
    @SerializedName("thumbnail") var thumbnail: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(large)
        parcel.writeString(medium)
        parcel.writeString(thumbnail)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Picture> {
        override fun createFromParcel(parcel: Parcel): Picture {
            return Picture(parcel)
        }

        override fun newArray(size: Int): Array<Picture?> {
            return arrayOfNulls(size)
        }
    }
}

data class Registered(
    @SerializedName("date") var date: String? = null,
    @SerializedName("age") var age: Int? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readValue(Int::class.java.classLoader) as? Int
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(date)
        parcel.writeValue(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Registered> {
        override fun createFromParcel(parcel: Parcel): Registered {
            return Registered(parcel)
        }

        override fun newArray(size: Int): Array<Registered?> {
            return arrayOfNulls(size)
        }
    }
}

data class Street(
    @SerializedName("number") var number: Int? = null,
    @SerializedName("name") var name: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(number)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Street> {
        override fun createFromParcel(parcel: Parcel): Street {
            return Street(parcel)
        }

        override fun newArray(size: Int): Array<Street?> {
            return arrayOfNulls(size)
        }
    }
}

data class Coordinates(
    @SerializedName("latitude") var latitude: String? = null,
    @SerializedName("longitude") var longitude: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(latitude)
        parcel.writeString(longitude)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Coordinates> {
        override fun createFromParcel(parcel: Parcel): Coordinates {
            return Coordinates(parcel)
        }

        override fun newArray(size: Int): Array<Coordinates?> {
            return arrayOfNulls(size)
        }
    }
}

data class Dob(
    @SerializedName("date") var date: String? = null,
    @SerializedName("age") var age: Int? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(date)
        parcel.writeValue(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dob> {
        override fun createFromParcel(parcel: Parcel): Dob {
            return Dob(parcel)
        }

        override fun newArray(size: Int): Array<Dob?> {
            return arrayOfNulls(size)
        }
    }
}

data class Id(
    @SerializedName("name") var name: String? = null,
    @SerializedName("value") var value: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(value)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Id> {
        override fun createFromParcel(parcel: Parcel): Id {
            return Id(parcel)
        }

        override fun newArray(size: Int): Array<Id?> {
            return arrayOfNulls(size)
        }
    }
}

data class Login(
    @SerializedName("uuid") var uuid: String? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("password") var password: String? = null,
    @SerializedName("salt") var salt: String? = null,
    @SerializedName("md5") var md5: String? = null,
    @SerializedName("sha1") var sha1: String? = null,
    @SerializedName("sha256") var sha256: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(uuid)
        parcel.writeString(username)
        parcel.writeString(password)
        parcel.writeString(salt)
        parcel.writeString(md5)
        parcel.writeString(sha1)
        parcel.writeString(sha256)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Login> {
        override fun createFromParcel(parcel: Parcel): Login {
            return Login(parcel)
        }

        override fun newArray(size: Int): Array<Login?> {
            return arrayOfNulls(size)
        }
    }
}

data class Info(
    @SerializedName("seed") var seed: String? = null,
    @SerializedName("results") var results: Int? = null,
    @SerializedName("page") var page: Int? = null,
    @SerializedName("version") var version: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(seed)
        parcel.writeValue(results)
        parcel.writeValue(page)
        parcel.writeString(version)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Info> {
        override fun createFromParcel(parcel: Parcel): Info {
            return Info(parcel)
        }

        override fun newArray(size: Int): Array<Info?> {
            return arrayOfNulls(size)
        }
    }
}

data class Timezone(
    @SerializedName("offset") var offset: String? = null,
    @SerializedName("description") var description: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(offset)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Timezone> {
        override fun createFromParcel(parcel: Parcel): Timezone {
            return Timezone(parcel)
        }

        override fun newArray(size: Int): Array<Timezone?> {
            return arrayOfNulls(size)
        }
    }
}
