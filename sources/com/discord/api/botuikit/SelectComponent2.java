package com.discord.api.botuikit;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.io.Serializable;

/* JADX INFO: renamed from: com.discord.api.botuikit.SelectItem, reason: use source file name */
/* JADX INFO: compiled from: SelectComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class SelectComponent2 implements Serializable {
    private final boolean default;
    private final String description;
    private final ComponentEmoji emoji;
    private final String label;
    private final String value;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getDefault() {
        return this.default;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final ComponentEmoji getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectComponent2)) {
            return false;
        }
        SelectComponent2 selectComponent2 = (SelectComponent2) other;
        return Intrinsics3.areEqual(this.label, selectComponent2.label) && Intrinsics3.areEqual(this.value, selectComponent2.value) && Intrinsics3.areEqual(this.emoji, selectComponent2.emoji) && Intrinsics3.areEqual(this.description, selectComponent2.description) && this.default == selectComponent2.default;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.label;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ComponentEmoji componentEmoji = this.emoji;
        int iHashCode3 = (iHashCode2 + (componentEmoji != null ? componentEmoji.hashCode() : 0)) * 31;
        String str3 = this.description;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z2 = this.default;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode4 + r1;
    }

    public String toString() {
        StringBuilder sbU = outline.U("SelectItem(label=");
        sbU.append(this.label);
        sbU.append(", value=");
        sbU.append(this.value);
        sbU.append(", emoji=");
        sbU.append(this.emoji);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", default=");
        return outline.O(sbU, this.default, ")");
    }
}
