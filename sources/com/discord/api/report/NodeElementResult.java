package com.discord.api.report;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class NodeElementResult {
    private final List<ReportNodeElementData> data;
    private final String key;

    public NodeElementResult(String str, List<ReportNodeElementData> list) {
        Intrinsics3.checkNotNullParameter(str, "key");
        Intrinsics3.checkNotNullParameter(list, "data");
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
        return Intrinsics3.areEqual(this.key, nodeElementResult.key) && Intrinsics3.areEqual(this.data, nodeElementResult.data);
    }

    public int hashCode() {
        String str = this.key;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ReportNodeElementData> list = this.data;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("NodeElementResult(key=");
        sbU.append(this.key);
        sbU.append(", data=");
        return outline.L(sbU, this.data, ")");
    }
}
