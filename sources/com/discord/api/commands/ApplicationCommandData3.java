package com.discord.api.commands;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: com.discord.api.commands.ApplicationCommandValue, reason: use source file name */
/* JADX INFO: compiled from: ApplicationCommandData.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApplicationCommandData3 {
    private final Boolean focused;
    private final String name;
    private final List<ApplicationCommandData3> options;
    private final int type;
    private final Object value;

    public ApplicationCommandData3(String str, Object obj, int i, List<ApplicationCommandData3> list, Boolean bool) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.name = str;
        this.value = obj;
        this.type = i;
        this.options = list;
        this.focused = bool;
    }

    public static ApplicationCommandData3 a(ApplicationCommandData3 applicationCommandData3, String str, Object obj, int i, List list, Boolean bool, int i2) {
        String str2 = (i2 & 1) != 0 ? applicationCommandData3.name : null;
        if ((i2 & 2) != 0) {
            obj = applicationCommandData3.value;
        }
        Object obj2 = obj;
        if ((i2 & 4) != 0) {
            i = applicationCommandData3.type;
        }
        int i3 = i;
        List<ApplicationCommandData3> list2 = (i2 & 8) != 0 ? applicationCommandData3.options : null;
        Boolean bool2 = (i2 & 16) != 0 ? applicationCommandData3.focused : null;
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ApplicationCommandData3(str2, obj2, i3, list2, bool2);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<ApplicationCommandData3> c() {
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
        if (!(other instanceof ApplicationCommandData3)) {
            return false;
        }
        ApplicationCommandData3 applicationCommandData3 = (ApplicationCommandData3) other;
        return Intrinsics3.areEqual(this.name, applicationCommandData3.name) && Intrinsics3.areEqual(this.value, applicationCommandData3.value) && this.type == applicationCommandData3.type && Intrinsics3.areEqual(this.options, applicationCommandData3.options) && Intrinsics3.areEqual(this.focused, applicationCommandData3.focused);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Object obj = this.value;
        int iHashCode2 = (((iHashCode + (obj != null ? obj.hashCode() : 0)) * 31) + this.type) * 31;
        List<ApplicationCommandData3> list = this.options;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool = this.focused;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandValue(name=");
        sbU.append(this.name);
        sbU.append(", value=");
        sbU.append(this.value);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", options=");
        sbU.append(this.options);
        sbU.append(", focused=");
        return outline.D(sbU, this.focused, ")");
    }
}
