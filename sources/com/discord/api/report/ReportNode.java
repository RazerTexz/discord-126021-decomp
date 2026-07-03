package com.discord.api.report;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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

    /* JADX INFO: renamed from: b */
    public final List<ReportNodeChild> m8172b() {
        return this.children;
    }

    /* JADX INFO: renamed from: c */
    public final List<ReportNodeElement> m8173c() {
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
        return this.id == reportNode.id && C12238m.areEqual(this.menu_name, reportNode.menu_name) && C12238m.areEqual(this.header, reportNode.header) && C12238m.areEqual(this.subheader, reportNode.subheader) && C12238m.areEqual(this.info, reportNode.info) && C12238m.areEqual(this.description, reportNode.description) && C12238m.areEqual(this.children, reportNode.children) && C12238m.areEqual(this.elements, reportNode.elements) && C12238m.areEqual(this.button, reportNode.button);
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
        StringBuilder sbM833U = C1643a.m833U("ReportNode(id=");
        sbM833U.append(this.id);
        sbM833U.append(", menu_name=");
        sbM833U.append(this.menu_name);
        sbM833U.append(", header=");
        sbM833U.append(this.header);
        sbM833U.append(", subheader=");
        sbM833U.append(this.subheader);
        sbM833U.append(", info=");
        sbM833U.append(this.info);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", children=");
        sbM833U.append(this.children);
        sbM833U.append(", elements=");
        sbM833U.append(this.elements);
        sbM833U.append(", button=");
        sbM833U.append(this.button);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
