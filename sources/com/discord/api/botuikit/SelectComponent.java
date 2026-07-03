package com.discord.api.botuikit;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SelectComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class SelectComponent extends ActionComponent {
    private final String customId;
    private final boolean disabled;
    private final int maxValues;
    private final int minValues;
    private final List<SelectItem> options;
    private final String placeholder;
    private final ComponentType type;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getDisabled() {
        return this.disabled;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getMaxValues() {
        return this.maxValues;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getMinValues() {
        return this.minValues;
    }

    /* JADX INFO: renamed from: e */
    public final List<SelectItem> m7609e() {
        return this.options;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectComponent)) {
            return false;
        }
        SelectComponent selectComponent = (SelectComponent) other;
        return C12238m.areEqual(this.type, selectComponent.type) && C12238m.areEqual(this.customId, selectComponent.customId) && this.disabled == selectComponent.disabled && C12238m.areEqual(this.placeholder, selectComponent.placeholder) && this.minValues == selectComponent.minValues && this.maxValues == selectComponent.maxValues && C12238m.areEqual(this.options, selectComponent.options);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getPlaceholder() {
        return this.placeholder;
    }

    @Override // com.discord.api.botuikit.Component
    public ComponentType getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public int hashCode() {
        ComponentType componentType = this.type;
        int iHashCode = (componentType != null ? componentType.hashCode() : 0) * 31;
        String str = this.customId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.disabled;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        String str2 = this.placeholder;
        int iHashCode3 = (((((i + (str2 != null ? str2.hashCode() : 0)) * 31) + this.minValues) * 31) + this.maxValues) * 31;
        List<SelectItem> list = this.options;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("SelectComponent(type=");
        sbM833U.append(this.type);
        sbM833U.append(", customId=");
        sbM833U.append(this.customId);
        sbM833U.append(", disabled=");
        sbM833U.append(this.disabled);
        sbM833U.append(", placeholder=");
        sbM833U.append(this.placeholder);
        sbM833U.append(", minValues=");
        sbM833U.append(this.minValues);
        sbM833U.append(", maxValues=");
        sbM833U.append(this.maxValues);
        sbM833U.append(", options=");
        return C1643a.m824L(sbM833U, this.options, ")");
    }
}
