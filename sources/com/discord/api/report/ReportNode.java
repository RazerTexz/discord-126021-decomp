package com.discord.api.report;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ReportNode {
    private final ReportNodeBottomButton button;
    private final List<ReportNodeChild> children;
    private final String description;
    private final List<ReportNodeElement> elements;
    private final String header;
    private final int id;
    private final String info;
    private final String menu_name;
    private final String subheader;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final ReportNodeBottomButton getButton() {
        return this.button;
    }

    public final List<ReportNodeChild> b() {
        return this.children;
    }

    public final List<ReportNodeElement> c() {
        return this.elements;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportNode)) {
            return false;
        }
        ReportNode reportNode = (ReportNode) other;
        return this.id == reportNode.id && Intrinsics3.areEqual(this.menu_name, reportNode.menu_name) && Intrinsics3.areEqual(this.header, reportNode.header) && Intrinsics3.areEqual(this.subheader, reportNode.subheader) && Intrinsics3.areEqual(this.info, reportNode.info) && Intrinsics3.areEqual(this.description, reportNode.description) && Intrinsics3.areEqual(this.children, reportNode.children) && Intrinsics3.areEqual(this.elements, reportNode.elements) && Intrinsics3.areEqual(this.button, reportNode.button);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getInfo() {
        return this.info;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getSubheader() {
        return this.subheader;
    }

    public int hashCode() {
        int i = this.id * 31;
        String str = this.menu_name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.header;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.subheader;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.info;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.description;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        List<ReportNodeChild> list = this.children;
        int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        List<ReportNodeElement> list2 = this.elements;
        int iHashCode7 = (iHashCode6 + (list2 != null ? list2.hashCode() : 0)) * 31;
        ReportNodeBottomButton reportNodeBottomButton = this.button;
        return iHashCode7 + (reportNodeBottomButton != null ? reportNodeBottomButton.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ReportNode(id=");
        sbU.append(this.id);
        sbU.append(", menu_name=");
        sbU.append(this.menu_name);
        sbU.append(", header=");
        sbU.append(this.header);
        sbU.append(", subheader=");
        sbU.append(this.subheader);
        sbU.append(", info=");
        sbU.append(this.info);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", children=");
        sbU.append(this.children);
        sbU.append(", elements=");
        sbU.append(this.elements);
        sbU.append(", button=");
        sbU.append(this.button);
        sbU.append(")");
        return sbU.toString();
    }
}
