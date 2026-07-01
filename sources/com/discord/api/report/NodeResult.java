package com.discord.api.report;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class NodeResult {
    private final ReportNodeChild destination;
    private final NodeElementResult elementResult;
    private final ReportNode node;

    public NodeResult(ReportNode reportNode, ReportNodeChild reportNodeChild, NodeElementResult nodeElementResult) {
        Intrinsics3.checkNotNullParameter(reportNode, "node");
        this.node = reportNode;
        this.destination = reportNodeChild;
        this.elementResult = nodeElementResult;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final ReportNodeChild getDestination() {
        return this.destination;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final NodeElementResult getElementResult() {
        return this.elementResult;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final ReportNode getNode() {
        return this.node;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NodeResult)) {
            return false;
        }
        NodeResult nodeResult = (NodeResult) other;
        return Intrinsics3.areEqual(this.node, nodeResult.node) && Intrinsics3.areEqual(this.destination, nodeResult.destination) && Intrinsics3.areEqual(this.elementResult, nodeResult.elementResult);
    }

    public int hashCode() {
        ReportNode reportNode = this.node;
        int iHashCode = (reportNode != null ? reportNode.hashCode() : 0) * 31;
        ReportNodeChild reportNodeChild = this.destination;
        int iHashCode2 = (iHashCode + (reportNodeChild != null ? reportNodeChild.hashCode() : 0)) * 31;
        NodeElementResult nodeElementResult = this.elementResult;
        return iHashCode2 + (nodeElementResult != null ? nodeElementResult.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("NodeResult(node=");
        sbU.append(this.node);
        sbU.append(", destination=");
        sbU.append(this.destination);
        sbU.append(", elementResult=");
        sbU.append(this.elementResult);
        sbU.append(")");
        return sbU.toString();
    }
}
