package com.example.swiggy_test

import androidx.recyclerview.widget.DiffUtil
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class City(
    @Json(name = "Version") val version: Int,
    @Json(name = "Key") val key: String,
    @Json(name = "Type") val type: String,
    @Json(name = "Rank") val rank: Int,
    @Json(name = "LocalizedName") val localizedName: String,
    @Json(name = "EnglishName") val englishName: String,
    @Json(name = "PrimaryPostalCode") val primaryPostalCode: String?,
    @Json(name = "Region") val region: Region,
    @Json(name = "Country") val country: Country,
    @Json(name = "AdministrativeArea") val administrativeArea: AdministrativeArea,
    @Json(name = "TimeZone") val timeZone: TimeZone,
    @Json(name = "GeoPosition") val geoPosition: GeoPosition,
    @Json(name = "IsAlias") val isAlias: Boolean,
    @Json(name = "SupplementalAdminAreas") val supplementalAdminAreas: List<SupplementalAdminArea>,
    @Json(name = "DataSets") val dataSets: List<String>
){
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<City>() {
            override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
                return oldItem.key == newItem.key
            }
            override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
                return oldItem == newItem
            }
        }
    }

}

@JsonClass(generateAdapter = true)
data class Region(
    @Json(name = "ID") val id: String,
    @Json(name = "LocalizedName") val localizedName: String,
    @Json(name = "EnglishName") val englishName: String
)

@JsonClass(generateAdapter = true)
data class Country(
    @Json(name = "ID") val id: String,
    @Json(name = "LocalizedName") val localizedName: String,
    @Json(name = "EnglishName") val englishName: String
)

@JsonClass(generateAdapter = true)
data class AdministrativeArea(
    @Json(name = "ID") val id: String,
    @Json(name = "LocalizedName") val localizedName: String,
    @Json(name = "EnglishName") val englishName: String,
    @Json(name = "Level") val level: Int,
    @Json(name = "LocalizedType") val localizedType: String,
    @Json(name = "EnglishType") val englishType: String,
    @Json(name = "CountryID") val countryId: String
)

@JsonClass(generateAdapter = true)
data class TimeZone(
    @Json(name = "Code") val code: String,
    @Json(name = "Name") val name: String,
    @Json(name = "GmtOffset") val gmtOffset: Double,
    @Json(name = "IsDaylightSaving") val isDaylightSaving: Boolean,
    @Json(name = "NextOffsetChange") val nextOffsetChange: String?
)

@JsonClass(generateAdapter = true)
data class GeoPosition(
    @Json(name = "Latitude") val latitude: Double,
    @Json(name = "Longitude") val longitude: Double,
    @Json(name = "Elevation") val elevation: Elevation
)

@JsonClass(generateAdapter = true)
data class Elevation(
    @Json(name = "Metric") val metric: MetricElevation,
    @Json(name = "Imperial") val imperial: ImperialElevation
)

@JsonClass(generateAdapter = true)
data class MetricElevation(
    @Json(name = "Value") val value: Double,
    @Json(name = "Unit") val unit: String,
    @Json(name = "UnitType") val unitType: Int
)

@JsonClass(generateAdapter = true)
data class ImperialElevation(
    @Json(name = "Value") val value: Double,
    @Json(name = "Unit") val unit: String,
    @Json(name = "UnitType") val unitType: Int
)

@JsonClass(generateAdapter = true)
data class SupplementalAdminArea(
    @Json(name = "Level") val level: Int,
    @Json(name = "LocalizedName") val localizedName: String,
    @Json(name = "EnglishName") val englishName: String
)

@JsonClass(generateAdapter = true)
data class WeatherResponse(
    @Json(name = "Headline") val headline: Headline,
    @Json(name = "DailyForecasts") val dailyForecasts: List<DailyForecast>
) {
}

@JsonClass(generateAdapter = true)
data class Headline(
    @Json(name = "EffectiveDate") val effectiveDate: String,
    @Json(name = "EffectiveEpochDate") val effectiveEpochDate: Long,
    @Json(name = "Severity") val severity: Int,
    @Json(name = "Text") val text: String,
    @Json(name = "Category") val category: String,
    @Json(name = "EndDate") val endDate: String?,
    @Json(name = "EndEpochDate") val endEpochDate: Long?,
    @Json(name = "MobileLink") val mobileLink: String,
    @Json(name = "Link") val link: String
)

@JsonClass(generateAdapter = true)
data class DailyForecast(
    @Json(name = "Date") val date: String,
    @Json(name = "EpochDate") val epochDate: Long,
    @Json(name = "Temperature") val temperature: Temperature,
    @Json(name = "Day") val day: DayNight,
    @Json(name = "Night") val night: DayNight,
    @Json(name = "Sources") val sources: List<String>,
    @Json(name = "MobileLink") val mobileLink: String,
    @Json(name = "Link") val link: String
) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DailyForecast>() {
            override fun areItemsTheSame(oldItem: DailyForecast, newItem: DailyForecast): Boolean {
                return oldItem.date == newItem.date
            }

            override fun areContentsTheSame(oldItem: DailyForecast, newItem: DailyForecast): Boolean {
                return oldItem == newItem
            }
        }
    }
}

@JsonClass(generateAdapter = true)
data class Temperature(
    @Json(name = "Minimum") val minimum: TemperatureValue,
    @Json(name = "Maximum") val maximum: TemperatureValue
)

@JsonClass(generateAdapter = true)
data class TemperatureValue(
    @Json(name = "Value") val value: Double,
    @Json(name = "Unit") val unit: String,
    @Json(name = "UnitType") val unitType: Int
)

@JsonClass(generateAdapter = true)
data class DayNight(
    @Json(name = "Icon") val icon: Int,
    @Json(name = "IconPhrase") val iconPhrase: String,
    @Json(name = "HasPrecipitation") val hasPrecipitation: Boolean
)

