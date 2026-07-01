package com.discord.widgets.botuikit.views.select;

import b.d.b.a.a;
import com.discord.api.botuikit.SelectItem;
import d0.z.d.m;

/* JADX INFO: compiled from: SelectComponentBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SelectComponentBottomSheetItem {
    private final SelectItem selectItem;
    private final boolean selected;

    public SelectComponentBottomSheetItem(SelectItem selectItem, boolean z2) {
        m.checkNotNullParameter(selectItem, "selectItem");
        this.selectItem = selectItem;
        this.selected = z2;
    }

    public static /* synthetic */ SelectComponentBottomSheetItem copy$default(SelectComponentBottomSheetItem selectComponentBottomSheetItem, SelectItem selectItem, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            selectItem = selectComponentBottomSheetItem.selectItem;
        }
        if ((i & 2) != 0) {
            z2 = selectComponentBottomSheetItem.selected;
        }
        return selectComponentBottomSheetItem.copy(selectItem, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SelectItem getSelectItem() {
        return this.selectItem;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final SelectComponentBottomSheetItem copy(SelectItem selectItem, boolean selected) {
        m.checkNotNullParameter(selectItem, "selectItem");
        return new SelectComponentBottomSheetItem(selectItem, selected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectComponentBottomSheetItem)) {
            return false;
        }
        SelectComponentBottomSheetItem selectComponentBottomSheetItem = (SelectComponentBottomSheetItem) other;
        return m.areEqual(this.selectItem, selectComponentBottomSheetItem.selectItem) && this.selected == selectComponentBottomSheetItem.selected;
    }

    public final SelectItem getSelectItem() {
        return this.selectItem;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        SelectItem selectItem = this.selectItem;
        int iHashCode = (selectItem != null ? selectItem.hashCode() : 0) * 31;
        boolean z2 = this.selected;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("SelectComponentBottomSheetItem(selectItem=");
        sbU.append(this.selectItem);
        sbU.append(", selected=");
        return a.O(sbU, this.selected, ")");
    }
}
