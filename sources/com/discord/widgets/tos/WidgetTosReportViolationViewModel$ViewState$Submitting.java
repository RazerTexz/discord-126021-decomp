package com.discord.widgets.tos;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetTosReportViolationViewModel$ViewState$Submitting extends WidgetTosReportViolationViewModel$ViewState {
    private final int reason;

    public WidgetTosReportViolationViewModel$ViewState$Submitting(int i) {
        super(null);
        this.reason = i;
    }

    public static /* synthetic */ WidgetTosReportViolationViewModel$ViewState$Submitting copy$default(WidgetTosReportViolationViewModel$ViewState$Submitting widgetTosReportViolationViewModel$ViewState$Submitting, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetTosReportViolationViewModel$ViewState$Submitting.reason;
        }
        return widgetTosReportViolationViewModel$ViewState$Submitting.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getReason() {
        return this.reason;
    }

    public final WidgetTosReportViolationViewModel$ViewState$Submitting copy(int reason) {
        return new WidgetTosReportViolationViewModel$ViewState$Submitting(reason);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetTosReportViolationViewModel$ViewState$Submitting) && this.reason == ((WidgetTosReportViolationViewModel$ViewState$Submitting) other).reason;
        }
        return true;
    }

    public final int getReason() {
        return this.reason;
    }

    public int hashCode() {
        return this.reason;
    }

    public String toString() {
        return a.B(a.U("Submitting(reason="), this.reason, ")");
    }
}
