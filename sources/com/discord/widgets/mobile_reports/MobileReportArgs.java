package com.discord.widgets.mobile_reports;

import android.os.Parcelable;
import com.discord.api.report.ReportType;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetMobileReports.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MobileReportArgs implements Parcelable {
    private final long channelId;
    private final ReportType reportType;

    private MobileReportArgs(ReportType reportType, long j) {
        this.reportType = reportType;
        this.channelId = j;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public final ReportType getReportType() {
        return this.reportType;
    }

    public /* synthetic */ MobileReportArgs(ReportType reportType, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(reportType, j);
    }
}
