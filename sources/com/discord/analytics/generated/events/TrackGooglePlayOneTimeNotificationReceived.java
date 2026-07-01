package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackGooglePlayOneTimeNotificationReceived.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGooglePlayOneTimeNotificationReceived implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long paymentId = null;
    private final Long skuId = null;
    private final CharSequence oneTimePurchaseSkuId = null;
    private final Long paymentGateway = null;
    private final CharSequence messageId = null;
    private final CharSequence version = null;
    private final CharSequence packageName = null;
    private final Long eventTime = null;
    private final CharSequence notificationVersion = null;
    private final Long notificationType = null;
    private final CharSequence purchaseToken = null;
    private final CharSequence orderId = null;
    private final transient String analyticsSchemaTypeName = "google_play_one_time_notification_received";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGooglePlayOneTimeNotificationReceived)) {
            return false;
        }
        TrackGooglePlayOneTimeNotificationReceived trackGooglePlayOneTimeNotificationReceived = (TrackGooglePlayOneTimeNotificationReceived) other;
        return m.areEqual(this.paymentId, trackGooglePlayOneTimeNotificationReceived.paymentId) && m.areEqual(this.skuId, trackGooglePlayOneTimeNotificationReceived.skuId) && m.areEqual(this.oneTimePurchaseSkuId, trackGooglePlayOneTimeNotificationReceived.oneTimePurchaseSkuId) && m.areEqual(this.paymentGateway, trackGooglePlayOneTimeNotificationReceived.paymentGateway) && m.areEqual(this.messageId, trackGooglePlayOneTimeNotificationReceived.messageId) && m.areEqual(this.version, trackGooglePlayOneTimeNotificationReceived.version) && m.areEqual(this.packageName, trackGooglePlayOneTimeNotificationReceived.packageName) && m.areEqual(this.eventTime, trackGooglePlayOneTimeNotificationReceived.eventTime) && m.areEqual(this.notificationVersion, trackGooglePlayOneTimeNotificationReceived.notificationVersion) && m.areEqual(this.notificationType, trackGooglePlayOneTimeNotificationReceived.notificationType) && m.areEqual(this.purchaseToken, trackGooglePlayOneTimeNotificationReceived.purchaseToken) && m.areEqual(this.orderId, trackGooglePlayOneTimeNotificationReceived.orderId);
    }

    public int hashCode() {
        Long l = this.paymentId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.skuId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.oneTimePurchaseSkuId;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.paymentGateway;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.messageId;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.version;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.packageName;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l4 = this.eventTime;
        int iHashCode8 = (iHashCode7 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.notificationVersion;
        int iHashCode9 = (iHashCode8 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l5 = this.notificationType;
        int iHashCode10 = (iHashCode9 + (l5 != null ? l5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.purchaseToken;
        int iHashCode11 = (iHashCode10 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.orderId;
        return iHashCode11 + (charSequence7 != null ? charSequence7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackGooglePlayOneTimeNotificationReceived(paymentId=");
        sbU.append(this.paymentId);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", oneTimePurchaseSkuId=");
        sbU.append(this.oneTimePurchaseSkuId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", version=");
        sbU.append(this.version);
        sbU.append(", packageName=");
        sbU.append(this.packageName);
        sbU.append(", eventTime=");
        sbU.append(this.eventTime);
        sbU.append(", notificationVersion=");
        sbU.append(this.notificationVersion);
        sbU.append(", notificationType=");
        sbU.append(this.notificationType);
        sbU.append(", purchaseToken=");
        sbU.append(this.purchaseToken);
        sbU.append(", orderId=");
        return a.E(sbU, this.orderId, ")");
    }
}
