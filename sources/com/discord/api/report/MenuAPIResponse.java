package com.discord.api.report;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class MenuAPIResponse {
    private final String language;
    private final String name;
    private final Map<Integer, ReportNode> nodes;
    private final String postback_url;
    private final int root_node_id;
    private final int success_node_id;
    private final String variant;
    private final String version;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: c */
    public final Map<Integer, ReportNode> m8161c() {
        return this.nodes;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getRoot_node_id() {
        return this.root_node_id;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getSuccess_node_id() {
        return this.success_node_id;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MenuAPIResponse)) {
            return false;
        }
        MenuAPIResponse menuAPIResponse = (MenuAPIResponse) other;
        return C12238m.areEqual(this.name, menuAPIResponse.name) && C12238m.areEqual(this.variant, menuAPIResponse.variant) && C12238m.areEqual(this.version, menuAPIResponse.version) && C12238m.areEqual(this.language, menuAPIResponse.language) && this.success_node_id == menuAPIResponse.success_node_id && this.root_node_id == menuAPIResponse.root_node_id && C12238m.areEqual(this.postback_url, menuAPIResponse.postback_url) && C12238m.areEqual(this.nodes, menuAPIResponse.nodes);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.variant;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.version;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.language;
        int iHashCode4 = (((((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.success_node_id) * 31) + this.root_node_id) * 31;
        String str5 = this.postback_url;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Map<Integer, ReportNode> map = this.nodes;
        return iHashCode5 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("MenuAPIResponse(name=");
        sbM833U.append(this.name);
        sbM833U.append(", variant=");
        sbM833U.append(this.variant);
        sbM833U.append(", version=");
        sbM833U.append(this.version);
        sbM833U.append(", language=");
        sbM833U.append(this.language);
        sbM833U.append(", success_node_id=");
        sbM833U.append(this.success_node_id);
        sbM833U.append(", root_node_id=");
        sbM833U.append(this.root_node_id);
        sbM833U.append(", postback_url=");
        sbM833U.append(this.postback_url);
        sbM833U.append(", nodes=");
        return C1643a.m825M(sbM833U, this.nodes, ")");
    }
}
