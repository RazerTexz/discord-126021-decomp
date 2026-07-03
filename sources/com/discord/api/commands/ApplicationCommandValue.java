package com.discord.api.commands;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ApplicationCommandData.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApplicationCommandValue {
    private final Boolean focused;
    private final String name;
    private final List<ApplicationCommandValue> options;
    private final int type;
    private final Object value;

    public ApplicationCommandValue(String str, Object obj, int i, List<ApplicationCommandValue> list, Boolean bool) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.name = str;
        this.value = obj;
        this.type = i;
        this.options = list;
        this.focused = bool;
    }

    /* JADX INFO: renamed from: a */
    public static ApplicationCommandValue m7739a(ApplicationCommandValue applicationCommandValue, String str, Object obj, int i, List list, Boolean bool, int i2) {
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
        C12238m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ApplicationCommandValue(str2, obj2, i3, list2, bool2);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: c */
    public final List<ApplicationCommandValue> m7741c() {
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
        return C12238m.areEqual(this.name, applicationCommandValue.name) && C12238m.areEqual(this.value, applicationCommandValue.value) && this.type == applicationCommandValue.type && C12238m.areEqual(this.options, applicationCommandValue.options) && C12238m.areEqual(this.focused, applicationCommandValue.focused);
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
        StringBuilder sbM833U = C1643a.m833U("ApplicationCommandValue(name=");
        sbM833U.append(this.name);
        sbM833U.append(", value=");
        sbM833U.append(this.value);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", options=");
        sbM833U.append(this.options);
        sbM833U.append(", focused=");
        return C1643a.m816D(sbM833U, this.focused, ")");
    }
}
