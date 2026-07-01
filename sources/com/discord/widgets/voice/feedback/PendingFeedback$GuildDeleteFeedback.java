package com.discord.widgets.voice.feedback;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PendingFeedback.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class PendingFeedback$GuildDeleteFeedback extends PendingFeedback {
    private final long guildId;
    private final String issueDetails;
    private final FeedbackIssue reason;

    public /* synthetic */ PendingFeedback$GuildDeleteFeedback(long j, FeedbackIssue feedbackIssue, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : feedbackIssue, (i & 4) != 0 ? null : str);
    }

    public static /* synthetic */ PendingFeedback$GuildDeleteFeedback copy$default(PendingFeedback$GuildDeleteFeedback pendingFeedback$GuildDeleteFeedback, long j, FeedbackIssue feedbackIssue, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = pendingFeedback$GuildDeleteFeedback.guildId;
        }
        if ((i & 2) != 0) {
            feedbackIssue = pendingFeedback$GuildDeleteFeedback.reason;
        }
        if ((i & 4) != 0) {
            str = pendingFeedback$GuildDeleteFeedback.issueDetails;
        }
        return pendingFeedback$GuildDeleteFeedback.copy(j, feedbackIssue, str);
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

    public final PendingFeedback$GuildDeleteFeedback copy(long guildId, FeedbackIssue reason, String issueDetails) {
        return new PendingFeedback$GuildDeleteFeedback(guildId, reason, issueDetails);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PendingFeedback$GuildDeleteFeedback)) {
            return false;
        }
        PendingFeedback$GuildDeleteFeedback pendingFeedback$GuildDeleteFeedback = (PendingFeedback$GuildDeleteFeedback) other;
        return this.guildId == pendingFeedback$GuildDeleteFeedback.guildId && m.areEqual(this.reason, pendingFeedback$GuildDeleteFeedback.reason) && m.areEqual(this.issueDetails, pendingFeedback$GuildDeleteFeedback.issueDetails);
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
        StringBuilder sbU = a.U("GuildDeleteFeedback(guildId=");
        sbU.append(this.guildId);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", issueDetails=");
        return a.J(sbU, this.issueDetails, ")");
    }

    public PendingFeedback$GuildDeleteFeedback(long j, FeedbackIssue feedbackIssue, String str) {
        super(null);
        this.guildId = j;
        this.reason = feedbackIssue;
        this.issueDetails = str;
    }
}
