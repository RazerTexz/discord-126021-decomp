package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackGooglePlaySubscriptionNotificationReceived.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGooglePlaySubscriptionNotificationReceived implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long subscriptionId = null;
    private final Long subscriptionType = null;
    private final Long paymentGateway = null;
    private final CharSequence paymentGatewayPlanId = null;
    private final CharSequence messageId = null;
    private final CharSequence version = null;
    private final CharSequence packageName = null;
    private final Long eventTime = null;
    private final CharSequence notificationVersion = null;
    private final Long notificationType = null;
    private final CharSequence purchaseToken = null;
    private final CharSequence subscriptionSkuId = null;
    private final CharSequence orderId = null;
    private final transient String analyticsSchemaTypeName = "google_play_subscription_notification_received";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGooglePlaySubscriptionNotificationReceived)) {
            return false;
        }
        TrackGooglePlaySubscriptionNotificationReceived trackGooglePlaySubscriptionNotificationReceived = (TrackGooglePlaySubscriptionNotificationReceived) other;
        return m.areEqual(this.subscriptionId, trackGooglePlaySubscriptionNotificationReceived.subscriptionId) && m.areEqual(this.subscriptionType, trackGooglePlaySubscriptionNotificationReceived.subscriptionType) && m.areEqual(this.paymentGateway, trackGooglePlaySubscriptionNotificationReceived.paymentGateway) && m.areEqual(this.paymentGatewayPlanId, trackGooglePlaySubscriptionNotificationReceived.paymentGatewayPlanId) && m.areEqual(this.messageId, trackGooglePlaySubscriptionNotificationReceived.messageId) && m.areEqual(this.version, trackGooglePlaySubscriptionNotificationReceived.version) && m.areEqual(this.packageName, trackGooglePlaySubscriptionNotificationReceived.packageName) && m.areEqual(this.eventTime, trackGooglePlaySubscriptionNotificationReceived.eventTime) && m.areEqual(this.notificationVersion, trackGooglePlaySubscriptionNotificationReceived.notificationVersion) && m.areEqual(this.notificationType, trackGooglePlaySubscriptionNotificationReceived.notificationType) && m.areEqual(this.purchaseToken, trackGooglePlaySubscriptionNotificationReceived.purchaseToken) && m.areEqual(this.subscriptionSkuId, trackGooglePlaySubscriptionNotificationReceived.subscriptionSkuId) && m.areEqual(this.orderId, trackGooglePlaySubscriptionNotificationReceived.orderId);
    }

    public int hashCode() {
        Long l = this.subscriptionId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.subscriptionType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.paymentGateway;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.paymentGatewayPlanId;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
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
        CharSequence charSequence7 = this.subscriptionSkuId;
        int iHashCode12 = (iHashCode11 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.orderId;
        return iHashCode12 + (charSequence8 != null ? charSequence8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackGooglePlaySubscriptionNotificationReceived(subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", subscriptionType=");
        sbU.append(this.subscriptionType);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", paymentGatewayPlanId=");
        sbU.append(this.paymentGatewayPlanId);
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
        sbU.append(", subscriptionSkuId=");
        sbU.append(this.subscriptionSkuId);
        sbU.append(", orderId=");
        return a.E(sbU, this.orderId, ")");
    }
}
