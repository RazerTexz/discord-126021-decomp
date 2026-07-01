package com.discord.widgets.tos;

import b.d.b.a.a;
import com.discord.api.report.ReportReason;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetTosReportViolationViewModel$ViewState$Loaded extends WidgetTosReportViolationViewModel$ViewState {
    private final List<ReportReason> reasons;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetTosReportViolationViewModel$ViewState$Loaded(List<ReportReason> list) {
        super(null);
        m.checkNotNullParameter(list, "reasons");
        this.reasons = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetTosReportViolationViewModel$ViewState$Loaded copy$default(WidgetTosReportViolationViewModel$ViewState$Loaded widgetTosReportViolationViewModel$ViewState$Loaded, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetTosReportViolationViewModel$ViewState$Loaded.reasons;
        }
        return widgetTosReportViolationViewModel$ViewState$Loaded.copy(list);
    }

    public final List<ReportReason> component1() {
        return this.reasons;
    }

    public final WidgetTosReportViolationViewModel$ViewState$Loaded copy(List<ReportReason> reasons) {
        m.checkNotNullParameter(reasons, "reasons");
        return new WidgetTosReportViolationViewModel$ViewState$Loaded(reasons);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetTosReportViolationViewModel$ViewState$Loaded) && m.areEqual(this.reasons, ((WidgetTosReportViolationViewModel$ViewState$Loaded) other).reasons);
        }
        return true;
    }

    public final List<ReportReason> getReasons() {
        return this.reasons;
    }

    public int hashCode() {
        List<ReportReason> list = this.reasons;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("Loaded(reasons="), this.reasons, ")");
    }
}
