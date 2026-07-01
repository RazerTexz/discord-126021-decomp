package com.discord.api.commands;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ApplicationCommandData.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApplicationCommandValue {
    private final Boolean focused;
    private final String name;
    private final List<ApplicationCommandValue> options;
    private final int type;
    private final Object value;

    public ApplicationCommandValue(String str, Object obj, int i, List<ApplicationCommandValue> list, Boolean bool) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.name = str;
        this.value = obj;
        this.type = i;
        this.options = list;
        this.focused = bool;
    }

    public static ApplicationCommandValue a(ApplicationCommandValue applicationCommandValue, String str, Object obj, int i, List list, Boolean bool, int i2) {
        String str2 = (i2 & 1) != 0 ? applicationCommandValue.name : null;
        if ((i2 & 2) != 0) {
            obj = applicationCommandValue.value;
        }
        Object obj2 = obj;
        if ((i2 & 4) != 0) {
            i = applicationCommandValue.type;
        }
        int i3 = i;
        List<ApplicationCommandValue> list2 = (i2 & 8) != 0 ? applicationCommandValue.options : null;
        Boolean bool2 = (i2 & 16) != 0 ? applicationCommandValue.focused : null;
        m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ApplicationCommandValue(str2, obj2, i3, list2, bool2);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<ApplicationCommandValue> c() {
        return this.options;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Object getValue() {
        return this.value;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandValue)) {
            return false;
        }
        ApplicationCommandValue applicationCommandValue = (ApplicationCommandValue) other;
        return m.areEqual(this.name, applicationCommandValue.name) && m.areEqual(this.value, applicationCommandValue.value) && this.type == applicationCommandValue.type && m.areEqual(this.options, applicationCommandValue.options) && m.areEqual(this.focused, applicationCommandValue.focused);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Object obj = this.value;
        int iHashCode2 = (((iHashCode + (obj != null ? obj.hashCode() : 0)) * 31) + this.type) * 31;
        List<ApplicationCommandValue> list = this.options;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool = this.focused;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ApplicationCommandValue(name=");
        sbU.append(this.name);
        sbU.append(", value=");
        sbU.append(this.value);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", options=");
        sbU.append(this.options);
        sbU.append(", focused=");
        return a.D(sbU, this.focused, ")");
    }
}
