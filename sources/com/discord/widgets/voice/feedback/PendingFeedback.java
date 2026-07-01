package com.discord.widgets.voice.feedback;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PendingFeedback.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class PendingFeedback implements Serializable {

    /* JADX INFO: compiled from: PendingFeedback.kt */
    public static final /* data */ class GuildDeleteFeedback extends PendingFeedback {
        private final long guildId;
        private final String issueDetails;
        private final FeedbackIssue reason;

        public /* synthetic */ GuildDeleteFeedback(long j, FeedbackIssue feedbackIssue, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? null : feedbackIssue, (i & 4) != 0 ? null : str);
        }

        public static /* synthetic */ GuildDeleteFeedback copy$default(GuildDeleteFeedback guildDeleteFeedback, long j, FeedbackIssue feedbackIssue, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = guildDeleteFeedback.guildId;
            }
            if ((i & 2) != 0) {
                feedbackIssue = guildDeleteFeedback.reason;
            }
            if ((i & 4) != 0) {
                str = guildDeleteFeedback.issueDetails;
            }
            return guildDeleteFeedback.copy(j, feedbackIssue, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final FeedbackIssue getReason() {
            return this.reason;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getIssueDetails() {
            return this.issueDetails;
        }

        public final GuildDeleteFeedback copy(long guildId, FeedbackIssue reason, String issueDetails) {
            return new GuildDeleteFeedback(guildId, reason, issueDetails);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildDeleteFeedback)) {
                return false;
            }
            GuildDeleteFeedback guildDeleteFeedback = (GuildDeleteFeedback) other;
            return this.guildId == guildDeleteFeedback.guildId && Intrinsics3.areEqual(this.reason, guildDeleteFeedback.reason) && Intrinsics3.areEqual(this.issueDetails, guildDeleteFeedback.issueDetails);
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final String getIssueDetails() {
            return this.issueDetails;
        }

        public final FeedbackIssue getReason() {
            return this.reason;
        }

        public int hashCode() {
            int iA = b.a(this.guildId) * 31;
            FeedbackIssue feedbackIssue = this.reason;
            int iHashCode = (iA + (feedbackIssue != null ? feedbackIssue.hashCode() : 0)) * 31;
            String str = this.issueDetails;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildDeleteFeedback(guildId=");
            sbU.append(this.guildId);
            sbU.append(", reason=");
            sbU.append(this.reason);
            sbU.append(", issueDetails=");
            return outline.J(sbU, this.issueDetails, ")");
        }

        public GuildDeleteFeedback(long j, FeedbackIssue feedbackIssue, String str) {
            super(null);
            this.guildId = j;
            this.reason = feedbackIssue;
            this.issueDetails = str;
        }
    }

    private PendingFeedback() {
    }

    /* JADX INFO: compiled from: PendingFeedback.kt */
    public static final /* data */ class CallFeedback extends PendingFeedback {
        private final long channelId;
        private final Long durationMs;
        private final FeedbackRating feedbackRating;
        private final String issueDetails;
        private final String mediaSessionId;
        private final Integer reasonCode;
        private final String reasonDescription;
        private final String rtcConnectionId;

        public /* synthetic */ CallFeedback(long j, String str, Long l, String str2, FeedbackRating feedbackRating, Integer num, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? FeedbackRating.NO_RESPONSE : feedbackRating, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : str4);
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

        public final CallFeedback copy(long channelId, String rtcConnectionId, Long durationMs, String mediaSessionId, FeedbackRating feedbackRating, Integer reasonCode, String reasonDescription, String issueDetails) {
            Intrinsics3.checkNotNullParameter(feedbackRating, "feedbackRating");
            return new CallFeedback(channelId, rtcConnectionId, durationMs, mediaSessionId, feedbackRating, reasonCode, reasonDescription, issueDetails);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CallFeedback)) {
                return false;
            }
            CallFeedback callFeedback = (CallFeedback) other;
            return this.channelId == callFeedback.channelId && Intrinsics3.areEqual(this.rtcConnectionId, callFeedback.rtcConnectionId) && Intrinsics3.areEqual(this.durationMs, callFeedback.durationMs) && Intrinsics3.areEqual(this.mediaSessionId, callFeedback.mediaSessionId) && Intrinsics3.areEqual(this.feedbackRating, callFeedback.feedbackRating) && Intrinsics3.areEqual(this.reasonCode, callFeedback.reasonCode) && Intrinsics3.areEqual(this.reasonDescription, callFeedback.reasonDescription) && Intrinsics3.areEqual(this.issueDetails, callFeedback.issueDetails);
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
            StringBuilder sbU = outline.U("CallFeedback(channelId=");
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
            return outline.J(sbU, this.issueDetails, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallFeedback(long j, String str, Long l, String str2, FeedbackRating feedbackRating, Integer num, String str3, String str4) {
            super(null);
            Intrinsics3.checkNotNullParameter(feedbackRating, "feedbackRating");
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

    /* JADX INFO: compiled from: PendingFeedback.kt */
    public static final /* data */ class StreamFeedback extends PendingFeedback {
        private final FeedbackRating feedbackRating;
        private final FeedbackIssue issue;
        private final String issueDetails;
        private final String mediaSessionId;
        private final ModelApplicationStream stream;

        public /* synthetic */ StreamFeedback(ModelApplicationStream modelApplicationStream, FeedbackRating feedbackRating, FeedbackIssue feedbackIssue, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(modelApplicationStream, (i & 2) != 0 ? FeedbackRating.NO_RESPONSE : feedbackRating, (i & 4) != 0 ? null : feedbackIssue, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2);
        }

        public static /* synthetic */ StreamFeedback copy$default(StreamFeedback streamFeedback, ModelApplicationStream modelApplicationStream, FeedbackRating feedbackRating, FeedbackIssue feedbackIssue, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                modelApplicationStream = streamFeedback.stream;
            }
            if ((i & 2) != 0) {
                feedbackRating = streamFeedback.feedbackRating;
            }
            FeedbackRating feedbackRating2 = feedbackRating;
            if ((i & 4) != 0) {
                feedbackIssue = streamFeedback.issue;
            }
            FeedbackIssue feedbackIssue2 = feedbackIssue;
            if ((i & 8) != 0) {
                str = streamFeedback.mediaSessionId;
            }
            String str3 = str;
            if ((i & 16) != 0) {
                str2 = streamFeedback.issueDetails;
            }
            return streamFeedback.copy(modelApplicationStream, feedbackRating2, feedbackIssue2, str3, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ModelApplicationStream getStream() {
            return this.stream;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final FeedbackRating getFeedbackRating() {
            return this.feedbackRating;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final FeedbackIssue getIssue() {
            return this.issue;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getIssueDetails() {
            return this.issueDetails;
        }

        public final StreamFeedback copy(ModelApplicationStream stream, FeedbackRating feedbackRating, FeedbackIssue issue, String mediaSessionId, String issueDetails) {
            Intrinsics3.checkNotNullParameter(stream, "stream");
            Intrinsics3.checkNotNullParameter(feedbackRating, "feedbackRating");
            return new StreamFeedback(stream, feedbackRating, issue, mediaSessionId, issueDetails);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StreamFeedback)) {
                return false;
            }
            StreamFeedback streamFeedback = (StreamFeedback) other;
            return Intrinsics3.areEqual(this.stream, streamFeedback.stream) && Intrinsics3.areEqual(this.feedbackRating, streamFeedback.feedbackRating) && Intrinsics3.areEqual(this.issue, streamFeedback.issue) && Intrinsics3.areEqual(this.mediaSessionId, streamFeedback.mediaSessionId) && Intrinsics3.areEqual(this.issueDetails, streamFeedback.issueDetails);
        }

        public final FeedbackRating getFeedbackRating() {
            return this.feedbackRating;
        }

        public final FeedbackIssue getIssue() {
            return this.issue;
        }

        public final String getIssueDetails() {
            return this.issueDetails;
        }

        public final String getMediaSessionId() {
            return this.mediaSessionId;
        }

        public final ModelApplicationStream getStream() {
            return this.stream;
        }

        public int hashCode() {
            ModelApplicationStream modelApplicationStream = this.stream;
            int iHashCode = (modelApplicationStream != null ? modelApplicationStream.hashCode() : 0) * 31;
            FeedbackRating feedbackRating = this.feedbackRating;
            int iHashCode2 = (iHashCode + (feedbackRating != null ? feedbackRating.hashCode() : 0)) * 31;
            FeedbackIssue feedbackIssue = this.issue;
            int iHashCode3 = (iHashCode2 + (feedbackIssue != null ? feedbackIssue.hashCode() : 0)) * 31;
            String str = this.mediaSessionId;
            int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.issueDetails;
            return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StreamFeedback(stream=");
            sbU.append(this.stream);
            sbU.append(", feedbackRating=");
            sbU.append(this.feedbackRating);
            sbU.append(", issue=");
            sbU.append(this.issue);
            sbU.append(", mediaSessionId=");
            sbU.append(this.mediaSessionId);
            sbU.append(", issueDetails=");
            return outline.J(sbU, this.issueDetails, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StreamFeedback(ModelApplicationStream modelApplicationStream, FeedbackRating feedbackRating, FeedbackIssue feedbackIssue, String str, String str2) {
            super(null);
            Intrinsics3.checkNotNullParameter(modelApplicationStream, "stream");
            Intrinsics3.checkNotNullParameter(feedbackRating, "feedbackRating");
            this.stream = modelApplicationStream;
            this.feedbackRating = feedbackRating;
            this.issue = feedbackIssue;
            this.mediaSessionId = str;
            this.issueDetails = str2;
        }
    }

    public /* synthetic */ PendingFeedback(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
