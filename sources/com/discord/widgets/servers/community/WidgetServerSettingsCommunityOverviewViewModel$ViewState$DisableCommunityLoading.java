package com.discord.widgets.servers.community;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsCommunityOverviewViewModel$ViewState$DisableCommunityLoading extends WidgetServerSettingsCommunityOverviewViewModel$ViewState {
    private final boolean isLoading;

    public WidgetServerSettingsCommunityOverviewViewModel$ViewState$DisableCommunityLoading(boolean z2) {
        super(null);
        this.isLoading = z2;
    }

    public static /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel$ViewState$DisableCommunityLoading copy$default(WidgetServerSettingsCommunityOverviewViewModel$ViewState$DisableCommunityLoading widgetServerSettingsCommunityOverviewViewModel$ViewState$DisableCommunityLoading, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetServerSettingsCommunityOverviewViewModel$ViewState$DisableCommunityLoading.isLoading;
        }
        return widgetServerSettingsCommunityOverviewViewModel$ViewState$DisableCommunityLoading.copy(z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    public final WidgetServerSettingsCommunityOverviewViewModel$ViewState$DisableCommunityLoading copy(boolean isLoading) {
        return new WidgetServerSettingsCommunityOverviewViewModel$ViewState$DisableCommunityLoading(isLoading);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetServerSettingsCommunityOverviewViewModel$ViewState$DisableCommunityLoading) && this.isLoading == ((WidgetServerSettingsCommunityOverviewViewModel$ViewState$DisableCommunityLoading) other).isLoading;
        }
        return true;
    }

    public int hashCode() {
        boolean z2 = this.isLoading;
        if (z2) {
            return 1;
        }
        return z2 ? 1 : 0;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public String toString() {
        return a.O(a.U("DisableCommunityLoading(isLoading="), this.isLoading, ")");
    }
}
