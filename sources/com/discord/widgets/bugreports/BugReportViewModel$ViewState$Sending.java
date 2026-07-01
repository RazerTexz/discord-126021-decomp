package com.discord.widgets.bugreports;

import b.d.b.a.a;
import com.discord.api.sticker.Sticker;
import d0.z.d.m;

/* JADX INFO: compiled from: BugReportViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class BugReportViewModel$ViewState$Sending extends BugReportViewModel$ViewState {
    private final Sticker sendingSticker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BugReportViewModel$ViewState$Sending(Sticker sticker) {
        super(null);
        m.checkNotNullParameter(sticker, "sendingSticker");
        this.sendingSticker = sticker;
    }

    public static /* synthetic */ BugReportViewModel$ViewState$Sending copy$default(BugReportViewModel$ViewState$Sending bugReportViewModel$ViewState$Sending, Sticker sticker, int i, Object obj) {
        if ((i & 1) != 0) {
            sticker = bugReportViewModel$ViewState$Sending.sendingSticker;
        }
        return bugReportViewModel$ViewState$Sending.copy(sticker);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Sticker getSendingSticker() {
        return this.sendingSticker;
    }

    public final BugReportViewModel$ViewState$Sending copy(Sticker sendingSticker) {
        m.checkNotNullParameter(sendingSticker, "sendingSticker");
        return new BugReportViewModel$ViewState$Sending(sendingSticker);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof BugReportViewModel$ViewState$Sending) && m.areEqual(this.sendingSticker, ((BugReportViewModel$ViewState$Sending) other).sendingSticker);
        }
        return true;
    }

    public final Sticker getSendingSticker() {
        return this.sendingSticker;
    }

    public int hashCode() {
        Sticker sticker = this.sendingSticker;
        if (sticker != null) {
            return sticker.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Sending(sendingSticker=");
        sbU.append(this.sendingSticker);
        sbU.append(")");
        return sbU.toString();
    }
}
