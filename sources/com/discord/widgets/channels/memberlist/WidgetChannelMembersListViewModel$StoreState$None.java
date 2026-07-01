package com.discord.widgets.channels.memberlist;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelMembersListViewModel$StoreState$None extends WidgetChannelMembersListViewModel$StoreState {
    private final boolean isPanelOpen;

    public WidgetChannelMembersListViewModel$StoreState$None(boolean z2) {
        super(z2, null, null);
        this.isPanelOpen = z2;
    }

    public static /* synthetic */ WidgetChannelMembersListViewModel$StoreState$None copy$default(WidgetChannelMembersListViewModel$StoreState$None widgetChannelMembersListViewModel$StoreState$None, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetChannelMembersListViewModel$StoreState$None.getIsPanelOpen();
        }
        return widgetChannelMembersListViewModel$StoreState$None.copy(z2);
    }

    public final boolean component1() {
        return getIsPanelOpen();
    }

    public final WidgetChannelMembersListViewModel$StoreState$None copy(boolean isPanelOpen) {
        return new WidgetChannelMembersListViewModel$StoreState$None(isPanelOpen);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetChannelMembersListViewModel$StoreState$None) && getIsPanelOpen() == ((WidgetChannelMembersListViewModel$StoreState$None) other).getIsPanelOpen();
        }
        return true;
    }

    public int hashCode() {
        boolean isPanelOpen = getIsPanelOpen();
        if (isPanelOpen) {
            return 1;
        }
        return isPanelOpen ? 1 : 0;
    }

    @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$StoreState
    /* JADX INFO: renamed from: isPanelOpen, reason: from getter */
    public boolean getIsPanelOpen() {
        return this.isPanelOpen;
    }

    public String toString() {
        StringBuilder sbU = a.U("None(isPanelOpen=");
        sbU.append(getIsPanelOpen());
        sbU.append(")");
        return sbU.toString();
    }
}
