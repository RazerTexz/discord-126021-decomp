package com.discord.widgets.mobile_reports;

import b.d.b.a.a;
import com.discord.api.report.ReportNode;
import d0.z.d.m;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MobileReportsViewModel$NodeNavigationType$Next extends MobileReportsViewModel$NodeNavigationType {
    private final ReportNode nextNode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileReportsViewModel$NodeNavigationType$Next(ReportNode reportNode) {
        super(reportNode, null);
        m.checkNotNullParameter(reportNode, "nextNode");
        this.nextNode = reportNode;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final ReportNode getNextNode() {
        return this.nextNode;
    }

    public static /* synthetic */ MobileReportsViewModel$NodeNavigationType$Next copy$default(MobileReportsViewModel$NodeNavigationType$Next mobileReportsViewModel$NodeNavigationType$Next, ReportNode reportNode, int i, Object obj) {
        if ((i & 1) != 0) {
            reportNode = mobileReportsViewModel$NodeNavigationType$Next.nextNode;
        }
        return mobileReportsViewModel$NodeNavigationType$Next.copy(reportNode);
    }

    public final MobileReportsViewModel$NodeNavigationType$Next copy(ReportNode nextNode) {
        m.checkNotNullParameter(nextNode, "nextNode");
        return new MobileReportsViewModel$NodeNavigationType$Next(nextNode);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof MobileReportsViewModel$NodeNavigationType$Next) && m.areEqual(this.nextNode, ((MobileReportsViewModel$NodeNavigationType$Next) other).nextNode);
        }
        return true;
    }

    public int hashCode() {
        ReportNode reportNode = this.nextNode;
        if (reportNode != null) {
            return reportNode.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Next(nextNode=");
        sbU.append(this.nextNode);
        sbU.append(")");
        return sbU.toString();
    }
}
