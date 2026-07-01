package com.discord.widgets.settings.billing;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetPaymentSourceEditDialog$StateEntry {
    private final String label;
    private final String value;

    public WidgetPaymentSourceEditDialog$StateEntry(String str, String str2) {
        m.checkNotNullParameter(str, "label");
        m.checkNotNullParameter(str2, "value");
        this.label = str;
        this.value = str2;
    }

    public static /* synthetic */ WidgetPaymentSourceEditDialog$StateEntry copy$default(WidgetPaymentSourceEditDialog$StateEntry widgetPaymentSourceEditDialog$StateEntry, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetPaymentSourceEditDialog$StateEntry.label;
        }
        if ((i & 2) != 0) {
            str2 = widgetPaymentSourceEditDialog$StateEntry.value;
        }
        return widgetPaymentSourceEditDialog$StateEntry.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final WidgetPaymentSourceEditDialog$StateEntry copy(String label, String value) {
        m.checkNotNullParameter(label, "label");
        m.checkNotNullParameter(value, "value");
        return new WidgetPaymentSourceEditDialog$StateEntry(label, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetPaymentSourceEditDialog$StateEntry)) {
            return false;
        }
        WidgetPaymentSourceEditDialog$StateEntry widgetPaymentSourceEditDialog$StateEntry = (WidgetPaymentSourceEditDialog$StateEntry) other;
        return m.areEqual(this.label, widgetPaymentSourceEditDialog$StateEntry.label) && m.areEqual(this.value, widgetPaymentSourceEditDialog$StateEntry.value);
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.label;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StateEntry(label=");
        sbU.append(this.label);
        sbU.append(", value=");
        return a.J(sbU, this.value, ")");
    }
}
