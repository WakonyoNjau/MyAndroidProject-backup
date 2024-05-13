package com.example.myandroidproject.ui.theme.Screens.reviews

//import android.os.Bundle
//import android.view.ViewGroup
//import android.widget.LinearLayout
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.compose.ui.text.font.Typeface
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.myandroidproject.R
//
//class ItineraryActivity : AppCompatActivity() {
//
//    private lateinit var tripDetails: TripDetails
//    private lateinit var itineraryItems: List<ItineraryItem>
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        // Initialize sample data
//        tripDetails = TripDetails(
//            destination = "Paris, France",
//            startDate = "2024-06-15",
//            endDate = "2024-06-22",
//            travelers = 2
//        )
//        itineraryItems = listOf(
//            ItineraryItem("Day 1: Arrive in Paris, check-in to hotel"),
//            ItineraryItem("Day 2: Visit the Eiffel Tower and Louvre Museum"),
//            ItineraryItem("Day 3: Explore the Champs-Élysées and Arc de Triomphe"),
//            ItineraryItem("Day 4: Take a day trip to Versailles Palace"),
//            ItineraryItem("Day 5: Visit the Notre-Dame Cathedral and Montmartre"),
//            ItineraryItem("Day 6: Free day for shopping or additional sightseeing"),
//            ItineraryItem("Day 7: Depart Paris")
//        )
//
//        // Create layout
//        val rootLayout = LinearLayout(this).apply {
//            orientation = LinearLayout.VERTICAL
//            setPadding(16.dp(), 16.dp(), 16.dp(), 16.dp())
//        }
//
//        // Add trip details
//        val tripDetailsText = getString(
//            R.string.trip_details_format,
//            tripDetails.destination,
//            tripDetails.startDate,
//            tripDetails.endDate,
//            tripDetails.travelers
//        )
//        val tvTripDetails = TextView(this).apply {
//            text = tripDetailsText
//            textSize = 18f
////            setTextStyle(Typeface.BOLD)
//        }
//        rootLayout.addView(tvTripDetails)
//
//        // Add itinerary title
//        val tvItineraryTitle = TextView(this).apply {
////            text = getString(R.string.itinerary)
//            textSize = 18f
////            setTextStyle(Typeface.BOLD)
//            setPadding(0, 16.dp(), 0, 0)
//        }
//        rootLayout.addView(tvItineraryTitle)
//
//        // Add itinerary items
//        val rvItinerary = RecyclerView(this)
//        rvItinerary.layoutManager = LinearLayoutManager(this)
//        rvItinerary.adapter = ItineraryAdapter(itineraryItems)
//        rootLayout.addView(rvItinerary)
//
//        setContentView(rootLayout)
//    }
//
//    data class TripDetails(
//        val destination: String,
//        val startDate: String,
//        val endDate: String,
//        val travelers: Int
//    )
//
//    data class ItineraryItem(val description: String)
//
//    inner class ItineraryAdapter(private val itineraryItems: List<ItineraryItem>) :
//        RecyclerView.Adapter<ItineraryAdapter.ViewHolder>() {
//
//        inner class ViewHolder(itemView: TextView) : RecyclerView.ViewHolder(itemView) {
//            val tvDescription: TextView = itemView as TextView
//        }
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//            val view = TextView(this@ItineraryActivity).apply {
//                textSize = 16f
//                setPadding(16.dp(), 16.dp(), 16.dp(), 16.dp())
//            }
//            return ViewHolder(view)
//        }
//
//        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//            val itineraryItem = itineraryItems[position]
//            holder.tvDescription.text = itineraryItem.description
//        }
//
//        override fun getItemCount(): Int {
//            return itineraryItems.size
//        }
//    }
//
//    private fun Int.dp(): Int = (this * resources.displayMetrics.density).toInt()
//
//    private fun TextView.setTextStyle(style: Int) {
//        setTypeface(null, style)
//    }
//}