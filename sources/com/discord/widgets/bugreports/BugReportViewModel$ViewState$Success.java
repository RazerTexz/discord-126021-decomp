package com.discord.widgets.bugreports;

import b.d.b.a.a;
import com.discord.api.sticker.Sticker;
import d0.z.d.m;

/* JADX INFO: compiled from: BugReportViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class BugReportViewModel$ViewState$Success extends BugReportViewModel$ViewState {
    private final Sticker successSticker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BugReportViewModel$ViewState$Success(Sticker sticker) {
        super(null);
        m.checkNotNullParameter(sticker, "successSticker");
        this.successSticker = sticker;
    }

    public static /* synthetic */ BugReportViewModel$ViewState$Success copy$default(BugReportViewModel$ViewState$Success bugReportViewModel$ViewState$Success, Sticker sticker, int i, Object obj) {
        if ((i & 1) != 0) {
            sticker = bugReportViewModel$ViewState$Success.successSticker;
        }
        return bugReportViewModel$ViewState$Success.copy(sticker);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Sticker getSuccessSticker() {
        return this.successSticker;
    }

    public final BugReportViewModel$ViewState$Success copy(Sticker successSticker) {
        m.checkNotNullParameter(successSticker, "successSticker");
        return new BugReportViewModel$ViewState$Success(successSticker);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof BugReportViewModel$ViewState$Success) && m.areEqual(this.successSticker, ((BugReportViewModel$ViewState$Success) other).successSticker);
        }
        return true;
    }

    public final Sticker getSuccessSticker() {
        return this.successSticker;
    }

    public int hashCode() {
        Sticker sticker = this.successSticker;
        if (sticker != null) {
            return sticker.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Success(successSticker=");
        sbU.append(this.successSticker);
        sbU.append(")");
        return sbU.toString();
    }
}
