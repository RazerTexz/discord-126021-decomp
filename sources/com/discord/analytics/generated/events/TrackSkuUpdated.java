package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackPriceByCurrency;
import com.discord.analytics.generated.traits.TrackPriceByCurrencyReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: TrackSkuUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSkuUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackPriceByCurrencyReceiver {
    private TrackBase trackBase;
    private TrackPriceByCurrency trackPriceByCurrency;
    private final Long skuId = null;
    private final CharSequence updateFrom = null;
    private final CharSequence updateType = null;
    private final CharSequence storeTitle = null;
    private final Long dependentSkuId = null;
    private final List<Long> bundledSkuIds = null;
    private final CharSequence accessType = null;
    private final Long releaseDate = null;
    private final Boolean isPremium = null;
    private final Boolean isDistribution = null;
    private final Boolean available = null;
    private final List<CharSequence> availableLocales = null;
    private final CharSequence metacriticId = null;
    private final Boolean isExclusive = null;
    private final List<CharSequence> genres = null;
    private final List<CharSequence> features = null;
    private final CharSequence contentRatingPegi = null;
    private final CharSequence contentRatingEsrb = null;
    private final Long regularPriceTier = null;
    private final Long priceTier = null;
    private final transient String analyticsSchemaTypeName = "sku_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSkuUpdated)) {
            return false;
        }
        TrackSkuUpdated trackSkuUpdated = (TrackSkuUpdated) other;
        return m.areEqual(this.skuId, trackSkuUpdated.skuId) && m.areEqual(this.updateFrom, trackSkuUpdated.updateFrom) && m.areEqual(this.updateType, trackSkuUpdated.updateType) && m.areEqual(this.storeTitle, trackSkuUpdated.storeTitle) && m.areEqual(this.dependentSkuId, trackSkuUpdated.dependentSkuId) && m.areEqual(this.bundledSkuIds, trackSkuUpdated.bundledSkuIds) && m.areEqual(this.accessType, trackSkuUpdated.accessType) && m.areEqual(this.releaseDate, trackSkuUpdated.releaseDate) && m.areEqual(this.isPremium, trackSkuUpdated.isPremium) && m.areEqual(this.isDistribution, trackSkuUpdated.isDistribution) && m.areEqual(this.available, trackSkuUpdated.available) && m.areEqual(this.availableLocales, trackSkuUpdated.availableLocales) && m.areEqual(this.metacriticId, trackSkuUpdated.metacriticId) && m.areEqual(this.isExclusive, trackSkuUpdated.isExclusive) && m.areEqual(this.genres, trackSkuUpdated.genres) && m.areEqual(this.features, trackSkuUpdated.features) && m.areEqual(this.contentRatingPegi, trackSkuUpdated.contentRatingPegi) && m.areEqual(this.contentRatingEsrb, trackSkuUpdated.contentRatingEsrb) && m.areEqual(this.regularPriceTier, trackSkuUpdated.regularPriceTier) && m.areEqual(this.priceTier, trackSkuUpdated.priceTier);
    }

    public int hashCode() {
        Long l = this.skuId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.updateFrom;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.updateType;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.storeTitle;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l2 = this.dependentSkuId;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        List<Long> list = this.bundledSkuIds;
        int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.accessType;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l3 = this.releaseDate;
        int iHashCode8 = (iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.isPremium;
        int iHashCode9 = (iHashCode8 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isDistribution;
        int iHashCode10 = (iHashCode9 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.available;
        int iHashCode11 = (iHashCode10 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        List<CharSequence> list2 = this.availableLocales;
        int iHashCode12 = (iHashCode11 + (list2 != null ? list2.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.metacriticId;
        int iHashCode13 = (iHashCode12 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Boolean bool4 = this.isExclusive;
        int iHashCode14 = (iHashCode13 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        List<CharSequence> list3 = this.genres;
        int iHashCode15 = (iHashCode14 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<CharSequence> list4 = this.features;
        int iHashCode16 = (iHashCode15 + (list4 != null ? list4.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.contentRatingPegi;
        int iHashCode17 = (iHashCode16 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.contentRatingEsrb;
        int iHashCode18 = (iHashCode17 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        Long l4 = this.regularPriceTier;
        int iHashCode19 = (iHashCode18 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.priceTier;
        return iHashCode19 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackSkuUpdated(skuId=");
        sbU.append(this.skuId);
        sbU.append(", updateFrom=");
        sbU.append(this.updateFrom);
        sbU.append(", updateType=");
        sbU.append(this.updateType);
        sbU.append(", storeTitle=");
        sbU.append(this.storeTitle);
        sbU.append(", dependentSkuId=");
        sbU.append(this.dependentSkuId);
        sbU.append(", bundledSkuIds=");
        sbU.append(this.bundledSkuIds);
        sbU.append(", accessType=");
        sbU.append(this.accessType);
        sbU.append(", releaseDate=");
        sbU.append(this.releaseDate);
        sbU.append(", isPremium=");
        sbU.append(this.isPremium);
        sbU.append(", isDistribution=");
        sbU.append(this.isDistribution);
        sbU.append(", available=");
        sbU.append(this.available);
        sbU.append(", availableLocales=");
        sbU.append(this.availableLocales);
        sbU.append(", metacriticId=");
        sbU.append(this.metacriticId);
        sbU.append(", isExclusive=");
        sbU.append(this.isExclusive);
        sbU.append(", genres=");
        sbU.append(this.genres);
        sbU.append(", features=");
        sbU.append(this.features);
        sbU.append(", contentRatingPegi=");
        sbU.append(this.contentRatingPegi);
        sbU.append(", contentRatingEsrb=");
        sbU.append(this.contentRatingEsrb);
        sbU.append(", regularPriceTier=");
        sbU.append(this.regularPriceTier);
        sbU.append(", priceTier=");
        return a.G(sbU, this.priceTier, ")");
    }
}
