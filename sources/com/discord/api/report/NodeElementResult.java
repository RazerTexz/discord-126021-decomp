package com.discord.api.report;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class NodeElementResult {
    private final List<ReportNodeElementData> data;
    private final String key;

    public NodeElementResult(String str, List<ReportNodeElementData> list) {
        m.checkNotNullParameter(str, "key");
        m.checkNotNullParameter(list, "data");
        this.key = str;
        this.data = list;
    }

    public final List<ReportNodeElementData> a() {
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
        return m.areEqual(this.key, nodeElementResult.key) && m.areEqual(this.data, nodeElementResult.data);
    }

    public int hashCode() {
        String str = this.key;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ReportNodeElementData> list = this.data;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("NodeElementResult(key=");
        sbU.append(this.key);
        sbU.append(", data=");
        return a.L(sbU, this.data, ")");
    }
}
