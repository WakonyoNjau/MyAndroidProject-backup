package com.example.myandroidproject.ui.theme.Screens.OurServices

//import accommodation.kt.name

//@Composable
//    fun checkAvailability(checkInDate: java.util.Date, checkOutDate: Date): List<Accommodation> {
//        val availableAccommodations = mutableListOf<Accommodation>()
//        for (accommodation in availableAccommodations) {
//            if (accommodation.availability > 0) {
//                availableAccommodations.add(accommodation)
//            }
//        }
//        return availableAccommodations
//    }
//
//    fun bookAccommodation(accommodation: Accommodation, checkInDate: Date, checkOutDate: Date): Booking? {
//        if (accommodation.availability > 0) {
//            val booking = Booking(accommodation, checkInDate, checkOutDate)
//            accommodation.availability--
//            return booking
//        }
//        return null
//    }
//
//
//fun main() {
//    val accommodation1 = Accommodation("Serena Hotel", 50, 10)
//    val accommodation2 = Accommodation("Hilton Hotel", 100, 20)
//    val accommodations = listOf(accommodation1, accommodation2)
//
//    val service = AccommodationService.AccommodationService(accommodations)
//
//    val checkInDate = java.util.Date()
//    val calendar = java.util.Calendar.getInstance()
////    calendar.add(Calendar.DATE, 3)
//    val checkOutDate = calendar.time
//
////    val availableAccommodations = service.checkAvailability(checkInDate, checkOutDate)
////    println("Available accommodations:")
////    availableAccommodations.forEach { println(it.name) }
//
////    val bookedAccommodation = service.bookAccommodation(availableAccommodations.first(), checkInDate, checkOutDate)
////    if (bookedAccommodation != null) {
////        println("Booking successful:")
////        println("Accommodation: ${bookedAccommodation.accommodation.name}")
////        println("Check-in Date: ${bookedAccommodation.checkInDate}")
////        println("Check-out Date: ${bookedAccommodation.checkOutDate}")
////    } else {
////        println("Booking failed: No available accommodations")
////    }
////}
//
//fun Any.forEach(function: () -> Unit) {
//    TODO("Not yet implemented")
//}
//
//class AccommodationService(private val accommodations: List<Accommodation>) {
//    fun checkAvailability(checkInDate: java.util.Date, checkOutDate: java.util.Date): Any {
//
//return(accommodations)
//    }
//
//}
//}
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myandroidproject.R
import java.util.Date

// Replace with your actual hotel data class
data class Hotel(val name: String, val price: Double)

class HotelBookingViewModel {
    val location = mutableStateOf("")
    val checkInDate = mutableStateOf(Date())
    val checkOutDate = mutableStateOf(Date())
    val hotels = mutableListOf<Hotel>() // Replace with actual hotel data fetching
    val selectedHotel = mutableStateOf<Hotel?>(null)

    fun findHotels() {
        // Simulate searching for hotels based on location and dates
        // Replace with actual API call or data retrieval logic
        hotels.clear()
        hotels.add(Hotel("Hilton", 150.00))
        hotels.add(Hotel("Marriott", 200.00))
    }

    fun selectHotel(hotel: Hotel) {
        selectedHotel.value = hotel
    }

    fun simulateBooking() {
        // Simulate booking process (no actual booking functionality)
        val hotel = selectedHotel.value
        if (hotel != null) {
            println("Booking hotel: ${hotel.name}")
        }
    }
}

@Composable
fun HotelBookingApp() {
    val viewModel = HotelBookingViewModel()

    Column(modifier = Modifier.padding(16.dp)) {
        // Search bar for location
        OutlinedTextField(
            value = viewModel.location.value,
            onValueChange = { viewModel.location.value = it },
            label = { Text("Location") },
            modifier = Modifier.fillMaxWidth()
        )

        // Date pickers for check-in and check-out
        DatePicker(
            modifier = Modifier.fillMaxWidth(),
            selection = viewModel.checkInDate.value,
            onDateChange = { viewModel.checkInDate.value  }
        )
        DatePicker(
            modifier = Modifier.fillMaxWidth(),
            selection = viewModel.checkOutDate.value,
            onDateChange = { viewModel.checkOutDate.value  }
        )

        // Button to search for hotels
        Button(onClick = { viewModel.findHotels() }) {
            Text("Find Hotels")
        }

        // List of available hotels (replace with actual data)
        if (viewModel.hotels.isNotEmpty()) {
            Text("Available Hotels:")
            LazyColumn {
                items(viewModel.hotels) { hotel ->
                    HotelCard(hotel = hotel)
                }
            }
        }

        // Button to simulate booking (no actual booking functionality)
        if (viewModel.selectedHotel.value != null) {
            Button(onClick = { viewModel.simulateBooking() }) {
                Text("Book Now")
            }
        }
    }
}

fun DatePicker(modifier: Modifier,
               selection: Date
               , onDateChange: (String) -> Unit) {


}

@Composable
fun HotelCard(hotel: Hotel) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
//        onClick = { viewModel.selectHotel(hotel)
//        }
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.homepage), // Replace with actual hotel image loading
                contentDescription = "Hotel image",
                modifier = Modifier.size(80.dp)
            )
//            Spacer(modifier = Modifier(16.dp))
            Column {
                Text(text = hotel.name, fontSize = 18.sp)
                Text(text = "Price: ${hotel.price}", color = Color.Gray)
            }
        }
    }
}

