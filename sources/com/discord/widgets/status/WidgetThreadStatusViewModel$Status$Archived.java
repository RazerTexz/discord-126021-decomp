package com.discord.widgets.status;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadStatusViewModel$Status$Archived extends WidgetThreadStatusViewModel$Status {
    private final boolean canArchive;
    private final boolean isLocked;

    public WidgetThreadStatusViewModel$Status$Archived(boolean z2, boolean z3) {
        super(null);
        this.isLocked = z2;
        this.canArchive = z3;
    }

    public static /* synthetic */ WidgetThreadStatusViewModel$Status$Archived copy$default(WidgetThreadStatusViewModel$Status$Archived widgetThreadStatusViewModel$Status$Archived, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetThreadStatusViewModel$Status$Archived.isLocked;
        }
        if ((i & 2) != 0) {
            z3 = widgetThreadStatusViewModel$Status$Archived.canArchive;
        }
        return widgetThreadStatusViewModel$Status$Archived.copy(z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsLocked() {
        return this.isLocked;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanArchive() {
        return this.canArchive;
    }

    public final WidgetThreadStatusViewModel$Status$Archived copy(boolean isLocked, boolean canArchive) {
        return new WidgetThreadStatusViewModel$Status$Archived(isLocked, canArchive);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetThreadStatusViewModel$Status$Archived)) {
            return false;
        }
        WidgetThreadStatusViewModel$Status$Archived widgetThreadStatusViewModel$Status$Archived = (WidgetThreadStatusViewModel$Status$Archived) other;
        return this.isLocked == widgetThreadStatusViewModel$Status$Archived.isLocked && this.canArchive == widgetThreadStatusViewModel$Status$Archived.canArchive;
    }

    public final boolean getCanArchive() {
        return this.canArchive;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z2 = this.isLocked;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.canArchive;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public String toString() {
        StringBuilder sbU = a.U("Archived(isLocked=");
        sbU.append(this.isLocked);
        sbU.append(", canArchive=");
        return a.O(sbU, this.canArchive, ")");
    }
}
