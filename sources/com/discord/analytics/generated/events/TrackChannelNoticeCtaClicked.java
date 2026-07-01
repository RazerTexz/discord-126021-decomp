package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackChannelNoticeCtaClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChannelNoticeCtaClicked implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence source = null;
    private final Long guildId = null;
    private final CharSequence noticeType = null;
    private final transient String analyticsSchemaTypeName = "channel_notice_cta_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackChannelNoticeCtaClicked)) {
            return false;
        }
        TrackChannelNoticeCtaClicked trackChannelNoticeCtaClicked = (TrackChannelNoticeCtaClicked) other;
        return m.areEqual(this.source, trackChannelNoticeCtaClicked.source) && m.areEqual(this.guildId, trackChannelNoticeCtaClicked.guildId) && m.areEqual(this.noticeType, trackChannelNoticeCtaClicked.noticeType);
    }

    public int hashCode() {
        CharSequence charSequence = this.source;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.guildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.noticeType;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackChannelNoticeCtaClicked(source=");
        sbU.append(this.source);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", noticeType=");
        return a.E(sbU, this.noticeType, ")");
    }
}
