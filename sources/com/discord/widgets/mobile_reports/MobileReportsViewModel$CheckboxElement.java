package com.discord.widgets.mobile_reports;

import b.d.b.a.a;
import com.discord.api.report.ReportNodeElementData;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MobileReportsViewModel$CheckboxElement {
    private final List<ReportNodeElementData> data;
    private final String name;
    private final HashSet<ReportNodeElementData> selections;

    public MobileReportsViewModel$CheckboxElement(String str, List<ReportNodeElementData> list, HashSet<ReportNodeElementData> hashSet) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(list, "data");
        m.checkNotNullParameter(hashSet, "selections");
        this.name = str;
        this.data = list;
        this.selections = hashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MobileReportsViewModel$CheckboxElement copy$default(MobileReportsViewModel$CheckboxElement mobileReportsViewModel$CheckboxElement, String str, List list, HashSet hashSet, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mobileReportsViewModel$CheckboxElement.name;
        }
        if ((i & 2) != 0) {
            list = mobileReportsViewModel$CheckboxElement.data;
        }
        if ((i & 4) != 0) {
            hashSet = mobileReportsViewModel$CheckboxElement.selections;
        }
        return mobileReportsViewModel$CheckboxElement.copy(str, list, hashSet);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<ReportNodeElementData> component2() {
        return this.data;
    }

    public final HashSet<ReportNodeElementData> component3() {
        return this.selections;
    }

    public final MobileReportsViewModel$CheckboxElement copy(String name, List<ReportNodeElementData> data, HashSet<ReportNodeElementData> selections) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(data, "data");
        m.checkNotNullParameter(selections, "selections");
        return new MobileReportsViewModel$CheckboxElement(name, data, selections);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MobileReportsViewModel$CheckboxElement)) {
            return false;
        }
        MobileReportsViewModel$CheckboxElement mobileReportsViewModel$CheckboxElement = (MobileReportsViewModel$CheckboxElement) other;
        return m.areEqual(this.name, mobileReportsViewModel$CheckboxElement.name) && m.areEqual(this.data, mobileReportsViewModel$CheckboxElement.data) && m.areEqual(this.selections, mobileReportsViewModel$CheckboxElement.selections);
    }

    public final List<ReportNodeElementData> getData() {
        return this.data;
    }

    public final String getName() {
        return this.name;
    }

    public final HashSet<ReportNodeElementData> getSelections() {
        return this.selections;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ReportNodeElementData> list = this.data;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        HashSet<ReportNodeElementData> hashSet = this.selections;
        return iHashCode2 + (hashSet != null ? hashSet.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CheckboxElement(name=");
        sbU.append(this.name);
        sbU.append(", data=");
        sbU.append(this.data);
        sbU.append(", selections=");
        sbU.append(this.selections);
        sbU.append(")");
        return sbU.toString();
    }
}
