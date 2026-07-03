package com.discord.api.report;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class NodeElementResult {
    private final List<ReportNodeElementData> data;
    private final String key;

    public NodeElementResult(String str, List<ReportNodeElementData> list) {
        C12238m.checkNotNullParameter(str, "key");
        C12238m.checkNotNullParameter(list, "data");
        this.key = str;
        this.data = list;
    }

    /* JADX INFO: renamed from: a */
    public final List<ReportNodeElementData> m8166a() {
        return this.data;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NodeElementResult)) {
            return false;
        }
        NodeElementResult nodeElementResult = (NodeElementResult) other;
        return C12238m.areEqual(this.key, nodeElementResult.key) && C12238m.areEqual(this.data, nodeElementResult.data);
    }

    public int hashCode() {
        String str = this.key;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ReportNodeElementData> list = this.data;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("NodeElementResult(key=");
        sbM833U.append(this.key);
        sbM833U.append(", data=");
        return C1643a.m824L(sbM833U, this.data, ")");
    }
}
