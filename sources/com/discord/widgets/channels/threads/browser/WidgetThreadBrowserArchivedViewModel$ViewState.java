package com.discord.widgets.channels.threads.browser;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadBrowserArchivedViewModel$ViewState {
    private final boolean canCreateThread;
    private final boolean isError;
    private final boolean isModerator;
    private final List<WidgetThreadBrowserAdapter$Item> listItems;
    private final WidgetThreadBrowserArchivedViewModel$ViewMode viewMode;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetThreadBrowserArchivedViewModel$ViewState(WidgetThreadBrowserArchivedViewModel$ViewMode widgetThreadBrowserArchivedViewModel$ViewMode, List<? extends WidgetThreadBrowserAdapter$Item> list, boolean z2, boolean z3, boolean z4) {
        m.checkNotNullParameter(widgetThreadBrowserArchivedViewModel$ViewMode, "viewMode");
        m.checkNotNullParameter(list, "listItems");
        this.viewMode = widgetThreadBrowserArchivedViewModel$ViewMode;
        this.listItems = list;
        this.isModerator = z2;
        this.isError = z3;
        this.canCreateThread = z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetThreadBrowserArchivedViewModel$ViewState copy$default(WidgetThreadBrowserArchivedViewModel$ViewState widgetThreadBrowserArchivedViewModel$ViewState, WidgetThreadBrowserArchivedViewModel$ViewMode widgetThreadBrowserArchivedViewModel$ViewMode, List list, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            widgetThreadBrowserArchivedViewModel$ViewMode = widgetThreadBrowserArchivedViewModel$ViewState.viewMode;
        }
        if ((i & 2) != 0) {
            list = widgetThreadBrowserArchivedViewModel$ViewState.listItems;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            z2 = widgetThreadBrowserArchivedViewModel$ViewState.isModerator;
        }
        boolean z5 = z2;
        if ((i & 8) != 0) {
            z3 = widgetThreadBrowserArchivedViewModel$ViewState.isError;
        }
        boolean z6 = z3;
        if ((i & 16) != 0) {
            z4 = widgetThreadBrowserArchivedViewModel$ViewState.canCreateThread;
        }
        return widgetThreadBrowserArchivedViewModel$ViewState.copy(widgetThreadBrowserArchivedViewModel$ViewMode, list2, z5, z6, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WidgetThreadBrowserArchivedViewModel$ViewMode getViewMode() {
        return this.viewMode;
    }

    public final List<WidgetThreadBrowserAdapter$Item> component2() {
        return this.listItems;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsModerator() {
        return this.isModerator;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsError() {
        return this.isError;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanCreateThread() {
        return this.canCreateThread;
    }

    public final WidgetThreadBrowserArchivedViewModel$ViewState copy(WidgetThreadBrowserArchivedViewModel$ViewMode viewMode, List<? extends WidgetThreadBrowserAdapter$Item> listItems, boolean isModerator, boolean isError, boolean canCreateThread) {
        m.checkNotNullParameter(viewMode, "viewMode");
        m.checkNotNullParameter(listItems, "listItems");
        return new WidgetThreadBrowserArchivedViewModel$ViewState(viewMode, listItems, isModerator, isError, canCreateThread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetThreadBrowserArchivedViewModel$ViewState)) {
            return false;
        }
        WidgetThreadBrowserArchivedViewModel$ViewState widgetThreadBrowserArchivedViewModel$ViewState = (WidgetThreadBrowserArchivedViewModel$ViewState) other;
        return m.areEqual(this.viewMode, widgetThreadBrowserArchivedViewModel$ViewState.viewMode) && m.areEqual(this.listItems, widgetThreadBrowserArchivedViewModel$ViewState.listItems) && this.isModerator == widgetThreadBrowserArchivedViewModel$ViewState.isModerator && this.isError == widgetThreadBrowserArchivedViewModel$ViewState.isError && this.canCreateThread == widgetThreadBrowserArchivedViewModel$ViewState.canCreateThread;
    }

    public final boolean getCanCreateThread() {
        return this.canCreateThread;
    }

    public final List<WidgetThreadBrowserAdapter$Item> getListItems() {
        return this.listItems;
    }

    public final WidgetThreadBrowserArchivedViewModel$ViewMode getViewMode() {
        return this.viewMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        WidgetThreadBrowserArchivedViewModel$ViewMode widgetThreadBrowserArchivedViewModel$ViewMode = this.viewMode;
        int iHashCode = (widgetThreadBrowserArchivedViewModel$ViewMode != null ? widgetThreadBrowserArchivedViewModel$ViewMode.hashCode() : 0) * 31;
        List<WidgetThreadBrowserAdapter$Item> list = this.listItems;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.isModerator;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z3 = this.isError;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.canCreateThread;
        return i2 + (z4 ? 1 : z4);
    }

    public final boolean isError() {
        return this.isError;
    }

    public final boolean isModerator() {
        return this.isModerator;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(viewMode=");
        sbU.append(this.viewMode);
        sbU.append(", listItems=");
        sbU.append(this.listItems);
        sbU.append(", isModerator=");
        sbU.append(this.isModerator);
        sbU.append(", isError=");
        sbU.append(this.isError);
        sbU.append(", canCreateThread=");
        return a.O(sbU, this.canCreateThread, ")");
    }
}
