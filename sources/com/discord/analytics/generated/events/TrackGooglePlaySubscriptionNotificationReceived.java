package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.subscriptionId, trackGooglePlaySubscriptionNotificationReceived.subscriptionId) && C12238m.areEqual(this.subscriptionType, trackGooglePlaySubscriptionNotificationReceived.subscriptionType) && C12238m.areEqual(this.paymentGateway, trackGooglePlaySubscriptionNotificationReceived.paymentGateway) && C12238m.areEqual(this.paymentGatewayPlanId, trackGooglePlaySubscriptionNotificationReceived.paymentGatewayPlanId) && C12238m.areEqual(this.messageId, trackGooglePlaySubscriptionNotificationReceived.messageId) && C12238m.areEqual(this.version, trackGooglePlaySubscriptionNotificationReceived.version) && C12238m.areEqual(this.packageName, trackGooglePlaySubscriptionNotificationReceived.packageName) && C12238m.areEqual(this.eventTime, trackGooglePlaySubscriptionNotificationReceived.eventTime) && C12238m.areEqual(this.notificationVersion, trackGooglePlaySubscriptionNotificationReceived.notificationVersion) && C12238m.areEqual(this.notificationType, trackGooglePlaySubscriptionNotificationReceived.notificationType) && C12238m.areEqual(this.purchaseToken, trackGooglePlaySubscriptionNotificationReceived.purchaseToken) && C12238m.areEqual(this.subscriptionSkuId, trackGooglePlaySubscriptionNotificationReceived.subscriptionSkuId) && C12238m.areEqual(this.orderId, trackGooglePlaySubscriptionNotificationReceived.orderId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackGooglePlaySubscriptionNotificationReceived(subscriptionId=");
        sbM833U.append(this.subscriptionId);
        sbM833U.append(", subscriptionType=");
        sbM833U.append(this.subscriptionType);
        sbM833U.append(", paymentGateway=");
        sbM833U.append(this.paymentGateway);
        sbM833U.append(", paymentGatewayPlanId=");
        sbM833U.append(this.paymentGatewayPlanId);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", version=");
        sbM833U.append(this.version);
        sbM833U.append(", packageName=");
        sbM833U.append(this.packageName);
        sbM833U.append(", eventTime=");
        sbM833U.append(this.eventTime);
        sbM833U.append(", notificationVersion=");
        sbM833U.append(this.notificationVersion);
        sbM833U.append(", notificationType=");
        sbM833U.append(this.notificationType);
        sbM833U.append(", purchaseToken=");
        sbM833U.append(this.purchaseToken);
        sbM833U.append(", subscriptionSkuId=");
        sbM833U.append(this.subscriptionSkuId);
        sbM833U.append(", orderId=");
        return C1643a.m817E(sbM833U, this.orderId, ")");
    }
}
