package com.discord.widgets.guild_automod;

import b.d.b.a.a;
import com.discord.models.message.Message;
import d0.z.d.m;

/* JADX INFO: compiled from: ReportIssueWithAutoModViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ReportIssueWithAutoModViewModel$StoreState {
    private final Message message;

    public ReportIssueWithAutoModViewModel$StoreState(Message message) {
        this.message = message;
    }

    public static /* synthetic */ ReportIssueWithAutoModViewModel$StoreState copy$default(ReportIssueWithAutoModViewModel$StoreState reportIssueWithAutoModViewModel$StoreState, Message message, int i, Object obj) {
        if ((i & 1) != 0) {
            message = reportIssueWithAutoModViewModel$StoreState.message;
        }
        return reportIssueWithAutoModViewModel$StoreState.copy(message);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    public final ReportIssueWithAutoModViewModel$StoreState copy(Message message) {
        return new ReportIssueWithAutoModViewModel$StoreState(message);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ReportIssueWithAutoModViewModel$StoreState) && m.areEqual(this.message, ((ReportIssueWithAutoModViewModel$StoreState) other).message);
        }
        return true;
    }

    public final Message getMessage() {
        return this.message;
    }

    public int hashCode() {
        Message message = this.message;
        if (message != null) {
            return message.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(message=");
        sbU.append(this.message);
        sbU.append(")");
        return sbU.toString();
    }
}
