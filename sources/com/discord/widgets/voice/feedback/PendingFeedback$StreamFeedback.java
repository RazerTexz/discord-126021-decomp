package com.discord.widgets.voice.feedback;

import b.d.b.a.a;
import com.discord.models.domain.ModelApplicationStream;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PendingFeedback.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class PendingFeedback$StreamFeedback extends PendingFeedback {
    private final FeedbackRating feedbackRating;
    private final FeedbackIssue issue;
    private final String issueDetails;
    private final String mediaSessionId;
    private final ModelApplicationStream stream;

    public /* synthetic */ PendingFeedback$StreamFeedback(ModelApplicationStream modelApplicationStream, FeedbackRating feedbackRating, FeedbackIssue feedbackIssue, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(modelApplicationStream, (i & 2) != 0 ? FeedbackRating.NO_RESPONSE : feedbackRating, (i & 4) != 0 ? null : feedbackIssue, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2);
    }

    public static /* synthetic */ PendingFeedback$StreamFeedback copy$default(PendingFeedback$StreamFeedback pendingFeedback$StreamFeedback, ModelApplicationStream modelApplicationStream, FeedbackRating feedbackRating, FeedbackIssue feedbackIssue, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            modelApplicationStream = pendingFeedback$StreamFeedback.stream;
        }
        if ((i & 2) != 0) {
            feedbackRating = pendingFeedback$StreamFeedback.feedbackRating;
        }
        FeedbackRating feedbackRating2 = feedbackRating;
        if ((i & 4) != 0) {
            feedbackIssue = pendingFeedback$StreamFeedback.issue;
        }
        FeedbackIssue feedbackIssue2 = feedbackIssue;
        if ((i & 8) != 0) {
            str = pendingFeedback$StreamFeedback.mediaSessionId;
        }
        String str3 = str;
        if ((i & 16) != 0) {
            str2 = pendingFeedback$StreamFeedback.issueDetails;
        }
        return pendingFeedback$StreamFeedback.copy(modelApplicationStream, feedbackRating2, feedbackIssue2, str3, str2);
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

    public final PendingFeedback$StreamFeedback copy(ModelApplicationStream stream, FeedbackRating feedbackRating, FeedbackIssue issue, String mediaSessionId, String issueDetails) {
        m.checkNotNullParameter(stream, "stream");
        m.checkNotNullParameter(feedbackRating, "feedbackRating");
        return new PendingFeedback$StreamFeedback(stream, feedbackRating, issue, mediaSessionId, issueDetails);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PendingFeedback$StreamFeedback)) {
            return false;
        }
        PendingFeedback$StreamFeedback pendingFeedback$StreamFeedback = (PendingFeedback$StreamFeedback) other;
        return m.areEqual(this.stream, pendingFeedback$StreamFeedback.stream) && m.areEqual(this.feedbackRating, pendingFeedback$StreamFeedback.feedbackRating) && m.areEqual(this.issue, pendingFeedback$StreamFeedback.issue) && m.areEqual(this.mediaSessionId, pendingFeedback$StreamFeedback.mediaSessionId) && m.areEqual(this.issueDetails, pendingFeedback$StreamFeedback.issueDetails);
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
        StringBuilder sbU = a.U("StreamFeedback(stream=");
        sbU.append(this.stream);
        sbU.append(", feedbackRating=");
        sbU.append(this.feedbackRating);
        sbU.append(", issue=");
        sbU.append(this.issue);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", issueDetails=");
        return a.J(sbU, this.issueDetails, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PendingFeedback$StreamFeedback(ModelApplicationStream modelApplicationStream, FeedbackRating feedbackRating, FeedbackIssue feedbackIssue, String str, String str2) {
        super(null);
        m.checkNotNullParameter(modelApplicationStream, "stream");
        m.checkNotNullParameter(feedbackRating, "feedbackRating");
        this.stream = modelApplicationStream;
        this.feedbackRating = feedbackRating;
        this.issue = feedbackIssue;
        this.mediaSessionId = str;
        this.issueDetails = str2;
    }
}
