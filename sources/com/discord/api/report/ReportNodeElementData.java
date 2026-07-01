package com.discord.api.report;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ReportNodeElementData {
    private final String elementKey;
    private final String elementValue;

    public ReportNodeElementData(String str, String str2) {
        m.checkNotNullParameter(str, "elementKey");
        m.checkNotNullParameter(str2, "elementValue");
        this.elementKey = str;
        this.elementValue = str2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getElementKey() {
        return this.elementKey;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getElementValue() {
        return this.elementValue;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportNodeElementData)) {
            return false;
        }
        ReportNodeElementData reportNodeElementData = (ReportNodeElementData) other;
        return m.areEqual(this.elementKey, reportNodeElementData.elementKey) && m.areEqual(this.elementValue, reportNodeElementData.elementValue);
    }

    public int hashCode() {
        String str = this.elementKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.elementValue;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ReportNodeElementData(elementKey=");
        sbU.append(this.elementKey);
        sbU.append(", elementValue=");
        return a.J(sbU, this.elementValue, ")");
    }
}
