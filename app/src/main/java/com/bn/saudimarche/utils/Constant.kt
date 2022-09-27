package com.bn.saudimarche.utils


object Constant {
    object UserActiveMode {

        var DEACTIVE = "deactive"

        var ACTIVE = "active"
    }

    object RequestCode {
        val GPS_ENABLING = 300

        val GET_LOCATION = 500

        val CHOOSE_CATEGORIES_RESUTL = 3

        val PICK_LOCATION_RESULT = 258
    }

    object RequestPermission {

        val REQUEST_GPS_LOCATION = 800

        val REQUEST_IMAGES = 400

        val REQUEST_CALL = 300

        val STORAGE = 1

        var GETLOCATION = 500
        val PHOTO_CHOOSE = 3
        val GPSEnabling = 300
        val Call = 100
        val Take_PICTURE = 9


    }

    object LocationConstant {

        var LAT = "lat"

        var LNG = "lng"

        var LOCATION = "location"
    }

    object InfinitScroll {

        val ITEM = 0

        val LOADING = 1

        val SELF_TEXT = 100

        val OTHER_TEXT = 101

        val SELF_IMAGE = 103

        val OTHER_IMAGE = 104
    }

    object Pagination {

        val INITIAL_PAGE = 1

    }


    object ResultData {

        val CHOOSE_COUNTRY = "choose_country"

        val CHOOSE_CITY = "choose_city"

        val CHOOSE_CATEGORIES = "choose_categories"

        val CHOOSE_CATEGORIES_ID = "choose_categories_id"
    }

    object NotificationType {

        val ChatSound = 1

        val NotificationSound = 0
    }

    object BundleData {

        val FORGET_PASS_MODEL = "forget_pass"

        val FOOD_MODEL = "food_model"
        val FOOD_ID = "food_id"

        val CATEGORY_ID = "category_id"

        val CATEGORY = "category"

        val FAMILY_MODEL = "family_model"

        val FAMILY_ID = "familey_id"

        val REGISTER_MODEL = "register_model"

        var ORDER = "order_details"
    }

    object
    APIsKey {
        const val OS_TYPE = "android"
    }

    object OrderStatus {

        val NO_ORDERS = "noOrder"

        val CREATED_ORDER = "orderCreated"

        val ACCEPTED_TRIP = "accepted"

        val TRIP_STARTED = "tripStarted"

        val ORDER_COST = "orderCost"

        var RATE_DRIVER = "rateDriver"
    }

    object ExtraKeys {
        val NAME = "extra_name"
        val ORDER_ID = "order_id"
        val RECIVER_ID = "reciver_id"
        val RECIVER_PHONE = "reciver_phone"
        val ORDER_STATUES = "order_statues"
        val ORDER_CAN_SEND_MESSAGE = "can_send_message"

    }
}
