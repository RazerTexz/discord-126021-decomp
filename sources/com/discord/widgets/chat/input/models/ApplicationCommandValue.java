package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ApplicationCommandValue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ApplicationCommandValue {
    private final Boolean focused;
    private final String name;
    private final List<ApplicationCommandValue> options;
    private final int type;
    private final Object value;

    public ApplicationCommandValue(String str, Object obj, int i, List<ApplicationCommandValue> list, Boolean bool) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.name = str;
        this.value = obj;
        this.type = i;
        this.options = list;
        this.focused = bool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApplicationCommandValue copy$default(ApplicationCommandValue applicationCommandValue, String str, Object obj, int i, List list, Boolean bool, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            str = applicationCommandValue.name;
        }
        if ((i2 & 2) != 0) {
            obj = applicationCommandValue.value;
        }
        Object obj3 = obj;
        if ((i2 & 4) != 0) {
            i = applicationCommandValue.type;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            list = applicationCommandValue.options;
        }
        List list2 = list;
        if ((i2 & 16) != 0) {
            bool = applicationCommandValue.focused;
        }
        return applicationCommandValue.copy(str, obj3, i3, list2, bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Object getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final List<ApplicationCommandValue> component4() {
        return this.options;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getFocused() {
        return this.focused;
    }

    public final ApplicationCommandValue copy(String name, Object value, int type, List<ApplicationCommandValue> options, Boolean focused) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ApplicationCommandValue(name, value, type, options, focused);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandValue)) {
            return false;
        }
        ApplicationCommandValue applicationCommandValue = (ApplicationCommandValue) other;
        return Intrinsics3.areEqual(this.name, applicationCommandValue.name) && Intrinsics3.areEqual(this.value, applicationCommandValue.value) && this.type == applicationCommandValue.type && Intrinsics3.areEqual(this.options, applicationCommandValue.options) && Intrinsics3.areEqual(this.focused, applicationCommandValue.focused);
    }

    public final Boolean getFocused() {
        return this.focused;
    }

    public final String getName() {
        return this.name;
    }

    public final List<ApplicationCommandValue> getOptions() {
        return this.options;
    }

    public final int getType() {
        return this.type;
    }

    public final Object getValue() {
        return this.value;
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

    public /* synthetic */ ApplicationCommandValue(String str, Object obj, int i, List list, Boolean bool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : obj, i, (i2 & 8) != 0 ? null : list, (i2 & 16) != 0 ? null : bool);
    }
}
