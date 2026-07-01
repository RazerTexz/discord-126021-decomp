package com.discord.widgets.mobile_reports;

import b.d.b.a.a;
import com.discord.api.report.ReportNode;
import d0.z.d.m;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MobileReportsViewModel$NodeNavigationType$Initial extends MobileReportsViewModel$NodeNavigationType {
    private final ReportNode initialNode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileReportsViewModel$NodeNavigationType$Initial(ReportNode reportNode) {
        super(reportNode, null);
        m.checkNotNullParameter(reportNode, "initialNode");
        this.initialNode = reportNode;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final ReportNode getInitialNode() {
        return this.initialNode;
    }

    public static /* synthetic */ MobileReportsViewModel$NodeNavigationType$Initial copy$default(MobileReportsViewModel$NodeNavigationType$Initial mobileReportsViewModel$NodeNavigationType$Initial, ReportNode reportNode, int i, Object obj) {
        if ((i & 1) != 0) {
            reportNode = mobileReportsViewModel$NodeNavigationType$Initial.initialNode;
        }
        return mobileReportsViewModel$NodeNavigationType$Initial.copy(reportNode);
    }

    public final MobileReportsViewModel$NodeNavigationType$Initial copy(ReportNode initialNode) {
        m.checkNotNullParameter(initialNode, "initialNode");
        return new MobileReportsViewModel$NodeNavigationType$Initial(initialNode);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof MobileReportsViewModel$NodeNavigationType$Initial) && m.areEqual(this.initialNode, ((MobileReportsViewModel$NodeNavigationType$Initial) other).initialNode);
        }
        return true;
    }

    public int hashCode() {
        ReportNode reportNode = this.initialNode;
        if (reportNode != null) {
            return reportNode.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Initial(initialNode=");
        sbU.append(this.initialNode);
        sbU.append(")");
        return sbU.toString();
    }
}
