package com.discord.api.botuikit;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.Serializable;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SelectComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class SelectItem implements Serializable {
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
        if (!(other instanceof SelectItem)) {
            return false;
        }
        SelectItem selectItem = (SelectItem) other;
        return C12238m.areEqual(this.label, selectItem.label) && C12238m.areEqual(this.value, selectItem.value) && C12238m.areEqual(this.emoji, selectItem.emoji) && C12238m.areEqual(this.description, selectItem.description) && this.default == selectItem.default;
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
        StringBuilder sbM833U = C1643a.m833U("SelectItem(label=");
        sbM833U.append(this.label);
        sbM833U.append(", value=");
        sbM833U.append(this.value);
        sbM833U.append(", emoji=");
        sbM833U.append(this.emoji);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", default=");
        return C1643a.m827O(sbM833U, this.default, ")");
    }
}
