package com.discord.widgets.guild_automod;

import b.d.b.a.a;
import com.discord.models.message.Message;
import d0.z.d.m;

/* JADX INFO: compiled from: ReportIssueWithAutoModViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ReportIssueWithAutoModViewModel$ViewState$Valid extends ReportIssueWithAutoModViewModel$ViewState {
    private final Message message;
    private final String selectedOption;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportIssueWithAutoModViewModel$ViewState$Valid(Message message, String str) {
        super(null);
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(str, "selectedOption");
        this.message = message;
        this.selectedOption = str;
    }

    public static /* synthetic */ ReportIssueWithAutoModViewModel$ViewState$Valid copy$default(ReportIssueWithAutoModViewModel$ViewState$Valid reportIssueWithAutoModViewModel$ViewState$Valid, Message message, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            message = reportIssueWithAutoModViewModel$ViewState$Valid.message;
        }
        if ((i & 2) != 0) {
            str = reportIssueWithAutoModViewModel$ViewState$Valid.selectedOption;
        }
        return reportIssueWithAutoModViewModel$ViewState$Valid.copy(message, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSelectedOption() {
        return this.selectedOption;
    }

    public final ReportIssueWithAutoModViewModel$ViewState$Valid copy(Message message, String selectedOption) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(selectedOption, "selectedOption");
        return new ReportIssueWithAutoModViewModel$ViewState$Valid(message, selectedOption);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportIssueWithAutoModViewModel$ViewState$Valid)) {
            return false;
        }
        ReportIssueWithAutoModViewModel$ViewState$Valid reportIssueWithAutoModViewModel$ViewState$Valid = (ReportIssueWithAutoModViewModel$ViewState$Valid) other;
        return m.areEqual(this.message, reportIssueWithAutoModViewModel$ViewState$Valid.message) && m.areEqual(this.selectedOption, reportIssueWithAutoModViewModel$ViewState$Valid.selectedOption);
    }

    public final Message getMessage() {
        return this.message;
    }

    public final String getSelectedOption() {
        return this.selectedOption;
    }

    public int hashCode() {
        Message message = this.message;
        int iHashCode = (message != null ? message.hashCode() : 0) * 31;
        String str = this.selectedOption;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(message=");
        sbU.append(this.message);
        sbU.append(", selectedOption=");
        return a.J(sbU, this.selectedOption, ")");
    }
}
