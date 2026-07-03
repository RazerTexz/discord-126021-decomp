package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackNotificationRendered.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNotificationRendered implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean hasCache = null;
    private final Boolean messageInPushPayload = null;
    private final Long coldStartDurationMs = null;
    private final Long cachedRenderDurationMs = null;
    private final Long anyNewerMessagesRenderDurationMs = null;
    private final Long loadedMessagesRenderDurationMs = null;
    private final Long fullRenderDurationMs = null;
    private final Long cacheLoadDurationMs = null;
    private final Long fullCacheLoadDurationMs = null;
    private final Long connectionPreOpenDurationMs = null;
    private final Long connectionOpenDurationMs = null;
    private final Long connectionResumeDurationMs = null;
    private final Long onlineDurationMs = null;
    private final Long firstMessageFetchStartDurationMs = null;
    private final Long firstMessageFetchEndDurationMs = null;
    private final CharSequence initialAppState = null;
    private final Long appActiveDurationMs = null;
    private final Long appInactiveDurationMs = null;
    private final Long appBackgroundedDurationMs = null;
    private final transient String analyticsSchemaTypeName = "notification_rendered";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotificationRendered)) {
            return false;
        }
        TrackNotificationRendered trackNotificationRendered = (TrackNotificationRendered) other;
        return C12238m.areEqual(this.hasCache, trackNotificationRendered.hasCache) && C12238m.areEqual(this.messageInPushPayload, trackNotificationRendered.messageInPushPayload) && C12238m.areEqual(this.coldStartDurationMs, trackNotificationRendered.coldStartDurationMs) && C12238m.areEqual(this.cachedRenderDurationMs, trackNotificationRendered.cachedRenderDurationMs) && C12238m.areEqual(this.anyNewerMessagesRenderDurationMs, trackNotificationRendered.anyNewerMessagesRenderDurationMs) && C12238m.areEqual(this.loadedMessagesRenderDurationMs, trackNotificationRendered.loadedMessagesRenderDurationMs) && C12238m.areEqual(this.fullRenderDurationMs, trackNotificationRendered.fullRenderDurationMs) && C12238m.areEqual(this.cacheLoadDurationMs, trackNotificationRendered.cacheLoadDurationMs) && C12238m.areEqual(this.fullCacheLoadDurationMs, trackNotificationRendered.fullCacheLoadDurationMs) && C12238m.areEqual(this.connectionPreOpenDurationMs, trackNotificationRendered.connectionPreOpenDurationMs) && C12238m.areEqual(this.connectionOpenDurationMs, trackNotificationRendered.connectionOpenDurationMs) && C12238m.areEqual(this.connectionResumeDurationMs, trackNotificationRendered.connectionResumeDurationMs) && C12238m.areEqual(this.onlineDurationMs, trackNotificationRendered.onlineDurationMs) && C12238m.areEqual(this.firstMessageFetchStartDurationMs, trackNotificationRendered.firstMessageFetchStartDurationMs) && C12238m.areEqual(this.firstMessageFetchEndDurationMs, trackNotificationRendered.firstMessageFetchEndDurationMs) && C12238m.areEqual(this.initialAppState, trackNotificationRendered.initialAppState) && C12238m.areEqual(this.appActiveDurationMs, trackNotificationRendered.appActiveDurationMs) && C12238m.areEqual(this.appInactiveDurationMs, trackNotificationRendered.appInactiveDurationMs) && C12238m.areEqual(this.appBackgroundedDurationMs, trackNotificationRendered.appBackgroundedDurationMs);
    }

    public int hashCode() {
        Boolean bool = this.hasCache;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.messageInPushPayload;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l = this.coldStartDurationMs;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.cachedRenderDurationMs;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.anyNewerMessagesRenderDurationMs;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.loadedMessagesRenderDurationMs;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.fullRenderDurationMs;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.cacheLoadDurationMs;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.fullCacheLoadDurationMs;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.connectionPreOpenDurationMs;
        int iHashCode10 = (iHashCode9 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.connectionOpenDurationMs;
        int iHashCode11 = (iHashCode10 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.connectionResumeDurationMs;
        int iHashCode12 = (iHashCode11 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.onlineDurationMs;
        int iHashCode13 = (iHashCode12 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.firstMessageFetchStartDurationMs;
        int iHashCode14 = (iHashCode13 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.firstMessageFetchEndDurationMs;
        int iHashCode15 = (iHashCode14 + (l13 != null ? l13.hashCode() : 0)) * 31;
        CharSequence charSequence = this.initialAppState;
        int iHashCode16 = (iHashCode15 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l14 = this.appActiveDurationMs;
        int iHashCode17 = (iHashCode16 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.appInactiveDurationMs;
        int iHashCode18 = (iHashCode17 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.appBackgroundedDurationMs;
        return iHashCode18 + (l16 != null ? l16.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackNotificationRendered(hasCache=");
        sbM833U.append(this.hasCache);
        sbM833U.append(", messageInPushPayload=");
        sbM833U.append(this.messageInPushPayload);
        sbM833U.append(", coldStartDurationMs=");
        sbM833U.append(this.coldStartDurationMs);
        sbM833U.append(", cachedRenderDurationMs=");
        sbM833U.append(this.cachedRenderDurationMs);
        sbM833U.append(", anyNewerMessagesRenderDurationMs=");
        sbM833U.append(this.anyNewerMessagesRenderDurationMs);
        sbM833U.append(", loadedMessagesRenderDurationMs=");
        sbM833U.append(this.loadedMessagesRenderDurationMs);
        sbM833U.append(", fullRenderDurationMs=");
        sbM833U.append(this.fullRenderDurationMs);
        sbM833U.append(", cacheLoadDurationMs=");
        sbM833U.append(this.cacheLoadDurationMs);
        sbM833U.append(", fullCacheLoadDurationMs=");
        sbM833U.append(this.fullCacheLoadDurationMs);
        sbM833U.append(", connectionPreOpenDurationMs=");
        sbM833U.append(this.connectionPreOpenDurationMs);
        sbM833U.append(", connectionOpenDurationMs=");
        sbM833U.append(this.connectionOpenDurationMs);
        sbM833U.append(", connectionResumeDurationMs=");
        sbM833U.append(this.connectionResumeDurationMs);
        sbM833U.append(", onlineDurationMs=");
        sbM833U.append(this.onlineDurationMs);
        sbM833U.append(", firstMessageFetchStartDurationMs=");
        sbM833U.append(this.firstMessageFetchStartDurationMs);
        sbM833U.append(", firstMessageFetchEndDurationMs=");
        sbM833U.append(this.firstMessageFetchEndDurationMs);
        sbM833U.append(", initialAppState=");
        sbM833U.append(this.initialAppState);
        sbM833U.append(", appActiveDurationMs=");
        sbM833U.append(this.appActiveDurationMs);
        sbM833U.append(", appInactiveDurationMs=");
        sbM833U.append(this.appInactiveDurationMs);
        sbM833U.append(", appBackgroundedDurationMs=");
        return C1643a.m819G(sbM833U, this.appBackgroundedDurationMs, ")");
    }
}
