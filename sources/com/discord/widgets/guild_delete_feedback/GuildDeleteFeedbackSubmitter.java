package com.discord.widgets.guild_delete_feedback;

import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackSubmitter;
import com.discord.widgets.voice.feedback.PendingFeedback;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildDeleteFeedbackSubmitter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildDeleteFeedbackSubmitter implements FeedbackSubmitter {
    private final PendingFeedback.GuildDeleteFeedback pendingFeedback;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FeedbackIssue.values();
            int[] iArr = new int[24];
            $EnumSwitchMapping$0 = iArr;
            iArr[FeedbackIssue.GUILD_DELETE_TOO_HARD.ordinal()] = 1;
            iArr[FeedbackIssue.GUILD_DELETE_TEST.ordinal()] = 2;
            iArr[FeedbackIssue.GUILD_DELETE_ACCIDENT.ordinal()] = 3;
            iArr[FeedbackIssue.GUILD_DELETE_TEMPLATE.ordinal()] = 4;
            iArr[FeedbackIssue.GUILD_DELETE_LONELY.ordinal()] = 5;
            iArr[FeedbackIssue.GUILD_DELETE_INACTIVE.ordinal()] = 6;
            iArr[FeedbackIssue.GUILD_DELETE_OTHER.ordinal()] = 7;
        }
    }

    public GuildDeleteFeedbackSubmitter(PendingFeedback.GuildDeleteFeedback guildDeleteFeedback) {
        C12238m.checkNotNullParameter(guildDeleteFeedback, "pendingFeedback");
        this.pendingFeedback = guildDeleteFeedback;
    }

    private final String getReasonFromFeedbackIssue(FeedbackIssue issue) {
        if (issue != null) {
            switch (issue.ordinal()) {
                case 17:
                    return "Too hard";
                case 18:
                    return "Testing purposes";
                case 19:
                    return "Created on accident";
                case 20:
                    return "Curious about server/template";
                case 21:
                    return "Empty server";
                case 22:
                    return "Inactive server";
                case 23:
                    return "Other";
            }
        }
        return null;
    }

    public final PendingFeedback.GuildDeleteFeedback getPendingFeedback() {
        return this.pendingFeedback;
    }

    public final void skip() {
        AnalyticsTracker.INSTANCE.userReportSubmitted("Guild Deletion", this.pendingFeedback.getGuildId(), null, null, true);
    }

    @Override // com.discord.widgets.voice.feedback.FeedbackSubmitter
    public void submit(String issueDetails) {
        AnalyticsTracker.INSTANCE.userReportSubmitted("Guild Deletion", this.pendingFeedback.getGuildId(), getReasonFromFeedbackIssue(this.pendingFeedback.getReason()), issueDetails, false);
    }
}
