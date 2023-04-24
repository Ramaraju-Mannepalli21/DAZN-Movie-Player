package com.example.dazn_movie_player.models


import com.google.gson.annotations.SerializedName

data class Tile(
    @SerializedName("AgeRating")
    var ageRating: Any?,
    @SerializedName("ArticleNavParams")
    var articleNavParams: String?,
    @SerializedName("ArticleNavigateTo")
    var articleNavigateTo: String?,
    @SerializedName("AssetId")
    var assetId: String?,
    @SerializedName("AssetTypeId")
    var assetTypeId: String?,
    @SerializedName("BackgroundImage")
    var backgroundImage: Any?,
    @SerializedName("Competition")
    var competition: Competition?,
    @SerializedName("Description")
    var description: String?,
    @SerializedName("DisplayDate")
    var displayDate: String?,
    @SerializedName("End")
    var end: Any?,
    @SerializedName("EntitlementIds")
    var entitlementIds: List<Any>?,
    @SerializedName("EventId")
    var eventId: String?,
    @SerializedName("ExpirationDate")
    var expirationDate: String?,
    @SerializedName("Id")
    var id: String?,
    @SerializedName("Image")
    var image: Image?,
    @SerializedName("IsDownloadable")
    var isDownloadable: Boolean?,
    @SerializedName("IsFreeToView")
    var isFreeToView: Boolean?,
    @SerializedName("IsGeoRestricted")
    var isGeoRestricted: Boolean?,
    @SerializedName("IsLinear")
    var isLinear: Boolean?,
    @SerializedName("Label")
    var label: String?,
    @SerializedName("LinearSchedule")
    var linearSchedule: Any?,
    @SerializedName("LogoImage")
    var logoImage: Any?,
    @SerializedName("NavParams")
    var navParams: Any?,
    @SerializedName("NavigateTo")
    var navigateTo: Any?,
    @SerializedName("NewLabel")
    var newLabel: Boolean?,
    @SerializedName("PinProtect")
    var pinProtect: Boolean?,
    @SerializedName("PortraitImage")
    var portraitImage: Any?,
    @SerializedName("PromoImage")
    var promoImage: PromoImage?,
    @SerializedName("Related")
    var related: List<Any>?,
    @SerializedName("Sport")
    var sport: Sport?,
    @SerializedName("Start")
    var start: Any?,
    @SerializedName("Status")
    var status: Any?,
    @SerializedName("Title")
    var title: String?,
    @SerializedName("TournamentCalendar")
    var tournamentCalendar: Any?,
    @SerializedName("Type")
    var type: String?,
    @SerializedName("VerifyAge")
    var verifyAge: Boolean?,
    @SerializedName("VideoType")
    var videoType: String?,
    @SerializedName("Videos")
    var videos: List<Video>?
)