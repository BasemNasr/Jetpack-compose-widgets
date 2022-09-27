package com.bn.saudimarche.data.model.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    val id: Int? = null,
    val first_name: String? = null,
    val last_name: String? = null,
    val email: String? = null,
    val phone: String? = null,
    val phone_code: String? = null,
    val phone_complete_form: String? = null,
    val is_active: Boolean? = null,
    var locale: String? = null,
    val gender: String? = null,
    val rate_avg: Float? = null,
    val registration_step: RegistrationStep? = null,
    val unread_notifications: Int? = null,
    val wallet: Float? = null,
    val avatar: String? = null,
    val id_front_image: String? = null,
    val id_back_image: String? = null,
    val driver_license_image: String? = null,
    val criminal_record_info_image: String? = null,
    var is_available: Boolean? = null,
    var available_from: String? = null,
    var available_to: String? = null,
    var is_delivering_package: Boolean? = null,
    var is_city_to_city_active: Boolean? = null,
    var is_trip_active: Boolean? = null,
    var is_package_delivering_active: Boolean? = null,
    var is_contributor_activate_driver: Boolean? = null,
    var allow_notifications: Boolean? = null,
    val token: String? = null,
    val is_driver_contributer: Boolean? = null,
) : Parcelable {
    @Parcelize
    data class RegistrationStep(
        val phone_step: Boolean? = false,
        val basic_information: Boolean? = false,
        val id_information: Boolean? = false,
        val driving_license_info: Boolean? = false,
        val criminal_record_info: Boolean? = false
    ) : Parcelable
}
