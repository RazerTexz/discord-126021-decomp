package com.discord.api.report;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class NodeResult {
    private final ReportNodeChild destination;
    private final NodeElementResult elementResult;
    private final ReportNode node;

    public NodeResult(ReportNode reportNode, ReportNodeChild reportNodeChild, NodeElementResult nodeElementResult) {
        C12238m.checkNotNullParameter(reportNode, "node");
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
        return C12238m.areEqual(this.node, nodeResult.node) && C12238m.areEqual(this.destination, nodeResult.destination) && C12238m.areEqual(this.elementResult, nodeResult.elementResult);
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
        StringBuilder sbM833U = C1643a.m833U("NodeResult(node=");
        sbM833U.append(this.node);
        sbM833U.append(", destination=");
        sbM833U.append(this.destination);
        sbM833U.append(", elementResult=");
        sbM833U.append(this.elementResult);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
