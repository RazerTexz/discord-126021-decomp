package com.discord.api.report;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ReportNodeElementData {
    private final String elementKey;
    private final String elementValue;

    public ReportNodeElementData(String str, String str2) {
        C12238m.checkNotNullParameter(str, "elementKey");
        C12238m.checkNotNullParameter(str2, "elementValue");
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
        return C12238m.areEqual(this.elementKey, reportNodeElementData.elementKey) && C12238m.areEqual(this.elementValue, reportNodeElementData.elementValue);
    }

    public int hashCode() {
        String str = this.elementKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.elementValue;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ReportNodeElementData(elementKey=");
        sbM833U.append(this.elementKey);
        sbM833U.append(", elementValue=");
        return C1643a.m822J(sbM833U, this.elementValue, ")");
    }
}
