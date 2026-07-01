package com.discord.widgets.channels.threads.browser;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetThreadBrowserActiveViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadBrowserActiveViewModel$ViewState {
    private final boolean canCreateThread;
    private final List<WidgetThreadBrowserAdapter$Item> listItems;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetThreadBrowserActiveViewModel$ViewState(List<? extends WidgetThreadBrowserAdapter$Item> list, boolean z2) {
        m.checkNotNullParameter(list, "listItems");
        this.listItems = list;
        this.canCreateThread = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetThreadBrowserActiveViewModel$ViewState copy$default(WidgetThreadBrowserActiveViewModel$ViewState widgetThreadBrowserActiveViewModel$ViewState, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetThreadBrowserActiveViewModel$ViewState.listItems;
        }
        if ((i & 2) != 0) {
            z2 = widgetThreadBrowserActiveViewModel$ViewState.canCreateThread;
        }
        return widgetThreadBrowserActiveViewModel$ViewState.copy(list, z2);
    }

    public final List<WidgetThreadBrowserAdapter$Item> component1() {
        return this.listItems;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanCreateThread() {
        return this.canCreateThread;
    }

    public final WidgetThreadBrowserActiveViewModel$ViewState copy(List<? extends WidgetThreadBrowserAdapter$Item> listItems, boolean canCreateThread) {
        m.checkNotNullParameter(listItems, "listItems");
        return new WidgetThreadBrowserActiveViewModel$ViewState(listItems, canCreateThread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetThreadBrowserActiveViewModel$ViewState)) {
            return false;
        }
        WidgetThreadBrowserActiveViewModel$ViewState widgetThreadBrowserActiveViewModel$ViewState = (WidgetThreadBrowserActiveViewModel$ViewState) other;
        return m.areEqual(this.listItems, widgetThreadBrowserActiveViewModel$ViewState.listItems) && this.canCreateThread == widgetThreadBrowserActiveViewModel$ViewState.canCreateThread;
    }

    public final boolean getCanCreateThread() {
        return this.canCreateThread;
    }

    public final List<WidgetThreadBrowserAdapter$Item> getListItems() {
        return this.listItems;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        List<WidgetThreadBrowserAdapter$Item> list = this.listItems;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.canCreateThread;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(listItems=");
        sbU.append(this.listItems);
        sbU.append(", canCreateThread=");
        return a.O(sbU, this.canCreateThread, ")");
    }
}
