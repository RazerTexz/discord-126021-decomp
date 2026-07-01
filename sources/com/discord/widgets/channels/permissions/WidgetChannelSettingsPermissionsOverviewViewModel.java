package com.discord.widgets.channels.permissions;

import b.a.d.d0;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverviewViewModel extends d0<WidgetChannelSettingsPermissionsOverviewViewModel$ViewState> {
    private final long channelId;

    public WidgetChannelSettingsPermissionsOverviewViewModel(long j, boolean z2) {
        super(WidgetChannelSettingsPermissionsOverviewViewModelKt.access$generateInitialViewState(z2));
        this.channelId = j;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final void selectTab(WidgetChannelSettingsPermissionsOverviewViewModel$Tab tab) {
        m.checkNotNullParameter(tab, "tab");
        updateViewState(WidgetChannelSettingsPermissionsOverviewViewModel$ViewState.copy$default(requireViewState(), tab, null, 2, null));
    }
}
