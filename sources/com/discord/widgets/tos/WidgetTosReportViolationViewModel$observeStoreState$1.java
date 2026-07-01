package com.discord.widgets.tos;

import androidx.core.app.NotificationCompat;
import com.discord.api.report.ReportReason;
import d0.z.d.m;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: WidgetTosReportViolationViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolationViewModel$observeStoreState$1<T, R> implements b<List<? extends ReportReason>, WidgetTosReportViolationViewModel$StoreState> {
    public static final WidgetTosReportViolationViewModel$observeStoreState$1 INSTANCE = new WidgetTosReportViolationViewModel$observeStoreState$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetTosReportViolationViewModel$StoreState call(List<? extends ReportReason> list) {
        return call2((List<ReportReason>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetTosReportViolationViewModel$StoreState call2(List<ReportReason> list) {
        m.checkNotNullExpressionValue(list, "reportReasons");
        return new WidgetTosReportViolationViewModel$StoreState$ReportReasons(list);
    }
}
