package com.discord.widgets.voice.feedback;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PendingFeedback.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class PendingFeedback$CallFeedback extends PendingFeedback {
    private final long channelId;
    private final Long durationMs;
    private final FeedbackRating feedbackRating;
    private final String issueDetails;
    private final String mediaSessionId;
    private final Integer reasonCode;
    private final String reasonDescription;
    private final String rtcConnectionId;

    public /* synthetic */ PendingFeedback$CallFeedback(long j, String str, Long l, String str2, FeedbackRating feedbackRating, Integer num, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? FeedbackRating.NO_RESPONSE : feedbackRating, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : str4);
    }

    public static /* synthetic */ PendingFeedback$CallFeedback copy$default(PendingFeedback$CallFeedback pendingFeedback$CallFeedback, long j, String str, Long l, String str2, FeedbackRating feedbackRating, Integer num, String str3, String str4, int i, Object obj) {
        return pendingFeedback$CallFeedback.copy((i & 1) != 0 ? pendingFeedback$CallFeedback.channelId : j, (i & 2) != 0 ? pendingFeedback$CallFeedback.rtcConnectionId : str, (i & 4) != 0 ? pendingFeedback$CallFeedback.durationMs : l, (i & 8) != 0 ? pendingFeedback$CallFeedback.mediaSessionId : str2, (i & 16) != 0 ? pendingFeedback$CallFeedback.feedbackRating : feedbackRating, (i & 32) != 0 ? pendingFeedback$CallFeedback.reasonCode : num, (i & 64) != 0 ? pendingFeedback$CallFeedback.reasonDescription : str3, (i & 128) != 0 ? pendingFeedback$CallFeedback.issueDetails : str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRtcConnectionId() {
        return this.rtcConnectionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getDurationMs() {
        return this.durationMs;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMediaSessionId() {
        return this.mediaSessionId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final FeedbackRating getFeedbackRating() {
        return this.feedbackRating;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getReasonCode() {
        return this.reasonCode;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getReasonDescription() {
        return this.reasonDescription;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getIssueDetails() {
        return this.issueDetails;
    }

    public final PendingFeedback$CallFeedback copy(long channelId, String rtcConnectionId, Long durationMs, String mediaSessionId, FeedbackRating feedbackRating, Integer reasonCode, String reasonDescription, String issueDetails) {
        m.checkNotNullParameter(feedbackRating, "feedbackRating");
        return new PendingFeedback$CallFeedback(channelId, rtcConnectionId, durationMs, mediaSessionId, feedbackRating, reasonCode, reasonDescription, issueDetails);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PendingFeedback$CallFeedback)) {
            return false;
        }
        PendingFeedback$CallFeedback pendingFeedback$CallFeedback = (PendingFeedback$CallFeedback) other;
        return this.channelId == pendingFeedback$CallFeedback.channelId && m.areEqual(this.rtcConnectionId, pendingFeedback$CallFeedback.rtcConnectionId) && m.areEqual(this.durationMs, pendingFeedback$CallFeedback.durationMs) && m.areEqual(this.mediaSessionId, pendingFeedback$CallFeedback.mediaSessionId) && m.areEqual(this.feedbackRating, pendingFeedback$CallFeedback.feedbackRating) && m.areEqual(this.reasonCode, pendingFeedback$CallFeedback.reasonCode) && m.areEqual(this.reasonDescription, pendingFeedback$CallFeedback.reasonDescription) && m.areEqual(this.issueDetails, pendingFeedback$CallFeedback.issueDetails);
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Long getDurationMs() {
        return this.durationMs;
    }

    public final FeedbackRating getFeedbackRating() {
        return this.feedbackRating;
    }

    public final String getIssueDetails() {
        return this.issueDetails;
    }

    public final String getMediaSessionId() {
        return this.mediaSessionId;
    }

    public final Integer getReasonCode() {
        return this.reasonCode;
    }

    public final String getReasonDescription() {
        return this.reasonDescription;
    }

    public final String getRtcConnectionId() {
        return this.rtcConnectionId;
    }

    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        String str = this.rtcConnectionId;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.durationMs;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.mediaSessionId;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        FeedbackRating feedbackRating = this.feedbackRating;
        int iHashCode4 = (iHashCode3 + (feedbackRating != null ? feedbackRating.hashCode() : 0)) * 31;
        Integer num = this.reasonCode;
        int iHashCode5 = (iHashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        String str3 = this.reasonDescription;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.issueDetails;
        return iHashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CallFeedback(channelId=");
        sbU.append(this.channelId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", durationMs=");
        sbU.append(this.durationMs);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", feedbackRating=");
        sbU.append(this.feedbackRating);
        sbU.append(", reasonCode=");
        sbU.append(this.reasonCode);
        sbU.append(", reasonDescription=");
        sbU.append(this.reasonDescription);
        sbU.append(", issueDetails=");
        return a.J(sbU, this.issueDetails, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PendingFeedback$CallFeedback(long j, String str, Long l, String str2, FeedbackRating feedbackRating, Integer num, String str3, String str4) {
        super(null);
        m.checkNotNullParameter(feedbackRating, "feedbackRating");
        this.channelId = j;
        this.rtcConnectionId = str;
        this.durationMs = l;
        this.mediaSessionId = str2;
        this.feedbackRating = feedbackRating;
        this.reasonCode = num;
        this.reasonDescription = str3;
        this.issueDetails = str4;
    }
}
