package com.discord.widgets.bugreports;

import android.net.Uri;
import b.d.b.a.a;
import com.discord.api.bugreport.Feature;
import com.discord.utilities.error.Error;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BugReportViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class BugReportViewModel$ViewState$Report extends BugReportViewModel$ViewState {
    private final Error error;
    private final Feature feature;
    private final Integer priority;
    private final String reportDescription;
    private final String reportName;
    private final Uri screenshotUri;
    private final boolean useScreenshot;

    public /* synthetic */ BugReportViewModel$ViewState$Report(Uri uri, String str, String str2, Integer num, Feature feature, boolean z2, Error error, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, str, str2, num, feature, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? null : error);
    }

    public static /* synthetic */ BugReportViewModel$ViewState$Report copy$default(BugReportViewModel$ViewState$Report bugReportViewModel$ViewState$Report, Uri uri, String str, String str2, Integer num, Feature feature, boolean z2, Error error, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = bugReportViewModel$ViewState$Report.screenshotUri;
        }
        if ((i & 2) != 0) {
            str = bugReportViewModel$ViewState$Report.reportName;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = bugReportViewModel$ViewState$Report.reportDescription;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            num = bugReportViewModel$ViewState$Report.priority;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            feature = bugReportViewModel$ViewState$Report.feature;
        }
        Feature feature2 = feature;
        if ((i & 32) != 0) {
            z2 = bugReportViewModel$ViewState$Report.useScreenshot;
        }
        boolean z3 = z2;
        if ((i & 64) != 0) {
            error = bugReportViewModel$ViewState$Report.error;
        }
        return bugReportViewModel$ViewState$Report.copy(uri, str3, str4, num2, feature2, z3, error);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Uri getScreenshotUri() {
        return this.screenshotUri;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getReportName() {
        return this.reportName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getReportDescription() {
        return this.reportDescription;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getPriority() {
        return this.priority;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Feature getFeature() {
        return this.feature;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getUseScreenshot() {
        return this.useScreenshot;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Error getError() {
        return this.error;
    }

    public final BugReportViewModel$ViewState$Report copy(Uri screenshotUri, String reportName, String reportDescription, Integer priority, Feature feature, boolean useScreenshot, Error error) {
        m.checkNotNullParameter(screenshotUri, "screenshotUri");
        return new BugReportViewModel$ViewState$Report(screenshotUri, reportName, reportDescription, priority, feature, useScreenshot, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BugReportViewModel$ViewState$Report)) {
            return false;
        }
        BugReportViewModel$ViewState$Report bugReportViewModel$ViewState$Report = (BugReportViewModel$ViewState$Report) other;
        return m.areEqual(this.screenshotUri, bugReportViewModel$ViewState$Report.screenshotUri) && m.areEqual(this.reportName, bugReportViewModel$ViewState$Report.reportName) && m.areEqual(this.reportDescription, bugReportViewModel$ViewState$Report.reportDescription) && m.areEqual(this.priority, bugReportViewModel$ViewState$Report.priority) && m.areEqual(this.feature, bugReportViewModel$ViewState$Report.feature) && this.useScreenshot == bugReportViewModel$ViewState$Report.useScreenshot && m.areEqual(this.error, bugReportViewModel$ViewState$Report.error);
    }

    public final Error getError() {
        return this.error;
    }

    public final Feature getFeature() {
        return this.feature;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final String getReportDescription() {
        return this.reportDescription;
    }

    public final String getReportName() {
        return this.reportName;
    }

    public final Uri getScreenshotUri() {
        return this.screenshotUri;
    }

    public final boolean getUseScreenshot() {
        return this.useScreenshot;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v20 */
    public int hashCode() {
        Uri uri = this.screenshotUri;
        int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
        String str = this.reportName;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.reportDescription;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.priority;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Feature feature = this.feature;
        int iHashCode5 = (iHashCode4 + (feature != null ? feature.hashCode() : 0)) * 31;
        boolean z2 = this.useScreenshot;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode5 + r2) * 31;
        Error error = this.error;
        return i + (error != null ? error.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Report(screenshotUri=");
        sbU.append(this.screenshotUri);
        sbU.append(", reportName=");
        sbU.append(this.reportName);
        sbU.append(", reportDescription=");
        sbU.append(this.reportDescription);
        sbU.append(", priority=");
        sbU.append(this.priority);
        sbU.append(", feature=");
        sbU.append(this.feature);
        sbU.append(", useScreenshot=");
        sbU.append(this.useScreenshot);
        sbU.append(", error=");
        sbU.append(this.error);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BugReportViewModel$ViewState$Report(Uri uri, String str, String str2, Integer num, Feature feature, boolean z2, Error error) {
        super(null);
        m.checkNotNullParameter(uri, "screenshotUri");
        this.screenshotUri = uri;
        this.reportName = str;
        this.reportDescription = str2;
        this.priority = num;
        this.feature = feature;
        this.useScreenshot = z2;
        this.error = error;
    }
}
