package com.example.anthonyodu

import com.example.anthonyodu.model.CarOwner
import com.example.anthonyodu.model.Filter


object FakeData {

    private val car1 = CarOwner(
        1, "Tony", "Scot",  "shainning0@so-net.ne.jp",
        "Thailand", "Lincoln",
        "1996", "Maroon", "Male",
        "Staff Accountant III", "Cras mi pede" +
                "malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, " +
                "consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices."
    )

    private val car2 = CarOwner(
        2, "	Vannie", "Fitzer",
        "vfitzer1@samsung.com", "France", "Chrysler", "2005", "Green",
        "Female", "VP Quality Control",
        "Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at" +
                " velit. Vivamus vel nulla eget eros elementum pellentesque."
    )

    private val car3 = CarOwner(
        3,
        "Sissy",
        "Willbourne",
        "swillbourne2@xinhuanet.com",
        "Bolivia",
        "Lexus",
        "2004",
        "Puce",
        "Female",
        "Staff Accountant",
        "I	Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, " +
                "condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. " +
                "Cras pellentesque volutpat dui."
    )


    val data = arrayListOf(car1, car2, car3)

//    val colours = arrayListOf<String>("Green","Pauce","Marron","Red")
//    val countries = arrayListOf<String>("Bolivia","France","Thailand")

//
//    var filter1 = Filter(
//        "1","hello","Odu Anthony","2010","male", colours, countries)
//    var filter2 =Filter(
//        "1", "",
//        "Odu Anthony",
//        "",
//        "female",
//        listOf("Bolivia", "France"),
//        listOf("Puce")
//    )

  //  val allFilterData = arrayListOf(filter2)
}