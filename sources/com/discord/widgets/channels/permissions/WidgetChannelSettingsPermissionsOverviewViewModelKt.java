package com.discord.widgets.channels.permissions;

import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverviewViewModel;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverviewViewModelKt {
    private static final WidgetChannelSettingsPermissionsOverviewViewModel.ViewState generateInitialViewState(boolean z2) {
        if (z2) {
            WidgetChannelSettingsPermissionsOverviewViewModel.Tab tab = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.MODERATOR;
            return new WidgetChannelSettingsPermissionsOverviewViewModel.ViewState(tab, C12147n.listOf((Object[]) new WidgetChannelSettingsPermissionsOverviewViewModel.Tab[]{tab, WidgetChannelSettingsPermissionsOverviewViewModel.Tab.ADVANCED}));
        }
        WidgetChannelSettingsPermissionsOverviewViewModel.Tab tab2 = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.ADVANCED;
        return new WidgetChannelSettingsPermissionsOverviewViewModel.ViewState(tab2, C12145m.listOf(tab2));
    }
}
