package com.discord.widgets.mobile_reports;

import b.d.b.a.a;
import com.discord.api.report.ReportNode;
import d0.z.d.m;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MobileReportsViewModel$NodeNavigationType$Back extends MobileReportsViewModel$NodeNavigationType {
    private final ReportNode prevNode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileReportsViewModel$NodeNavigationType$Back(ReportNode reportNode) {
        super(reportNode, null);
        m.checkNotNullParameter(reportNode, "prevNode");
        this.prevNode = reportNode;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final ReportNode getPrevNode() {
        return this.prevNode;
    }

    public static /* synthetic */ MobileReportsViewModel$NodeNavigationType$Back copy$default(MobileReportsViewModel$NodeNavigationType$Back mobileReportsViewModel$NodeNavigationType$Back, ReportNode reportNode, int i, Object obj) {
        if ((i & 1) != 0) {
            reportNode = mobileReportsViewModel$NodeNavigationType$Back.prevNode;
        }
        return mobileReportsViewModel$NodeNavigationType$Back.copy(reportNode);
    }

    public final MobileReportsViewModel$NodeNavigationType$Back copy(ReportNode prevNode) {
        m.checkNotNullParameter(prevNode, "prevNode");
        return new MobileReportsViewModel$NodeNavigationType$Back(prevNode);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof MobileReportsViewModel$NodeNavigationType$Back) && m.areEqual(this.prevNode, ((MobileReportsViewModel$NodeNavigationType$Back) other).prevNode);
        }
        return true;
    }

    public int hashCode() {
        ReportNode reportNode = this.prevNode;
        if (reportNode != null) {
            return reportNode.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Back(prevNode=");
        sbU.append(this.prevNode);
        sbU.append(")");
        return sbU.toString();
    }
}
