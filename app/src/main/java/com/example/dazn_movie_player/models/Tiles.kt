package com.example.dazn_movie_player.models

import com.google.gson.annotations.SerializedName

data class Tiles(

    @SerializedName("Id") var Id: String? = null,
    @SerializedName("AgeRating") var AgeRating: String? = null,
    @SerializedName("AssetId") var AssetId: String? = null,
    @SerializedName("AssetTypeId") var AssetTypeId: String? = null,
    @SerializedName("EventId") var EventId: String? = null,
    @SerializedName("Type") var Type: String? = null,
    @SerializedName("NavigateTo") var NavigateTo: String? = null,
    @SerializedName("NavParams") var NavParams: String? = null,
    @SerializedName("Title") var Title: String? = null,
    @SerializedName("Description") var Description: String? = null,
    @SerializedName("Url") var Url: String? = null,
    @SerializedName("Start") var Start: String? = null,
    @SerializedName("End") var End: String? = null,
    @SerializedName("DisplayDate") var DisplayDate: String? = null,
    @SerializedName("Image") var Image: Image? = Image(),
    @SerializedName("BackgroundImage") var BackgroundImage: String? = null,
    @SerializedName("PromoImage") var PromoImage: String? = null,
    @SerializedName("LogoImage") var LogoImage: String? = null,
    @SerializedName("PortraitImage") var PortraitImage: String? = null,
    @SerializedName("Competition") var Competition: Competition? = Competition(),
    @SerializedName("Sport") var Sport: Sport? = Sport(),
    @SerializedName("Videos") var Videos: ArrayList<Videos> = arrayListOf(),
    @SerializedName("Related") var Related: ArrayList<String> = arrayListOf(),
    @SerializedName("TournamentCalendar") var TournamentCalendar: String? = null,
    @SerializedName("ExpirationDate") var ExpirationDate: String? = null,
    @SerializedName("VideoType") var VideoType: String? = null,
    @SerializedName("IsGeoRestricted") var IsGeoRestricted: Boolean? = null,
    @SerializedName("IsLinear") var IsLinear: Boolean? = null,
    @SerializedName("Status") var Status: String? = null,
    @SerializedName("Label") var Label: String? = null,
    @SerializedName("IsDownloadable") var IsDownloadable: Boolean? = null,
    @SerializedName("VerifyAge") var VerifyAge: Boolean? = null,
    @SerializedName("NewLabel") var NewLabel: Boolean? = null,
    @SerializedName("IsFreeToView") var IsFreeToView: Boolean? = null,
    @SerializedName("PinProtect") var PinProtect: Boolean? = null,
    @SerializedName("ArticleNavParams") var ArticleNavParams: String? = null,
    @SerializedName("ArticleNavigateTo") var ArticleNavigateTo: String? = null,
    @SerializedName("EntitlementIds") var EntitlementIds: ArrayList<String> = arrayListOf(),
    @SerializedName("LinearSchedule") var LinearSchedule: String? = null

)