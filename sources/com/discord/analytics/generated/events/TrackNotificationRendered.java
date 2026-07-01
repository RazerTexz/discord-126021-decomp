package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        return m.areEqual(this.hasCache, trackNotificationRendered.hasCache) && m.areEqual(this.messageInPushPayload, trackNotificationRendered.messageInPushPayload) && m.areEqual(this.coldStartDurationMs, trackNotificationRendered.coldStartDurationMs) && m.areEqual(this.cachedRenderDurationMs, trackNotificationRendered.cachedRenderDurationMs) && m.areEqual(this.anyNewerMessagesRenderDurationMs, trackNotificationRendered.anyNewerMessagesRenderDurationMs) && m.areEqual(this.loadedMessagesRenderDurationMs, trackNotificationRendered.loadedMessagesRenderDurationMs) && m.areEqual(this.fullRenderDurationMs, trackNotificationRendered.fullRenderDurationMs) && m.areEqual(this.cacheLoadDurationMs, trackNotificationRendered.cacheLoadDurationMs) && m.areEqual(this.fullCacheLoadDurationMs, trackNotificationRendered.fullCacheLoadDurationMs) && m.areEqual(this.connectionPreOpenDurationMs, trackNotificationRendered.connectionPreOpenDurationMs) && m.areEqual(this.connectionOpenDurationMs, trackNotificationRendered.connectionOpenDurationMs) && m.areEqual(this.connectionResumeDurationMs, trackNotificationRendered.connectionResumeDurationMs) && m.areEqual(this.onlineDurationMs, trackNotificationRendered.onlineDurationMs) && m.areEqual(this.firstMessageFetchStartDurationMs, trackNotificationRendered.firstMessageFetchStartDurationMs) && m.areEqual(this.firstMessageFetchEndDurationMs, trackNotificationRendered.firstMessageFetchEndDurationMs) && m.areEqual(this.initialAppState, trackNotificationRendered.initialAppState) && m.areEqual(this.appActiveDurationMs, trackNotificationRendered.appActiveDurationMs) && m.areEqual(this.appInactiveDurationMs, trackNotificationRendered.appInactiveDurationMs) && m.areEqual(this.appBackgroundedDurationMs, trackNotificationRendered.appBackgroundedDurationMs);
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
        StringBuilder sbU = a.U("TrackNotificationRendered(hasCache=");
        sbU.append(this.hasCache);
        sbU.append(", messageInPushPayload=");
        sbU.append(this.messageInPushPayload);
        sbU.append(", coldStartDurationMs=");
        sbU.append(this.coldStartDurationMs);
        sbU.append(", cachedRenderDurationMs=");
        sbU.append(this.cachedRenderDurationMs);
        sbU.append(", anyNewerMessagesRenderDurationMs=");
        sbU.append(this.anyNewerMessagesRenderDurationMs);
        sbU.append(", loadedMessagesRenderDurationMs=");
        sbU.append(this.loadedMessagesRenderDurationMs);
        sbU.append(", fullRenderDurationMs=");
        sbU.append(this.fullRenderDurationMs);
        sbU.append(", cacheLoadDurationMs=");
        sbU.append(this.cacheLoadDurationMs);
        sbU.append(", fullCacheLoadDurationMs=");
        sbU.append(this.fullCacheLoadDurationMs);
        sbU.append(", connectionPreOpenDurationMs=");
        sbU.append(this.connectionPreOpenDurationMs);
        sbU.append(", connectionOpenDurationMs=");
        sbU.append(this.connectionOpenDurationMs);
        sbU.append(", connectionResumeDurationMs=");
        sbU.append(this.connectionResumeDurationMs);
        sbU.append(", onlineDurationMs=");
        sbU.append(this.onlineDurationMs);
        sbU.append(", firstMessageFetchStartDurationMs=");
        sbU.append(this.firstMessageFetchStartDurationMs);
        sbU.append(", firstMessageFetchEndDurationMs=");
        sbU.append(this.firstMessageFetchEndDurationMs);
        sbU.append(", initialAppState=");
        sbU.append(this.initialAppState);
        sbU.append(", appActiveDurationMs=");
        sbU.append(this.appActiveDurationMs);
        sbU.append(", appInactiveDurationMs=");
        sbU.append(this.appInactiveDurationMs);
        sbU.append(", appBackgroundedDurationMs=");
        return a.G(sbU, this.appBackgroundedDurationMs, ")");
    }
}
