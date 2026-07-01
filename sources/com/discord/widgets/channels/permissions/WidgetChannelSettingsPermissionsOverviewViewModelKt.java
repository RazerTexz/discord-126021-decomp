package com.discord.widgets.channels.permissions;

import d0.t.m;
import d0.t.n;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverviewViewModelKt {
    public static final /* synthetic */ WidgetChannelSettingsPermissionsOverviewViewModel$ViewState access$generateInitialViewState(boolean z2) {
        return generateInitialViewState(z2);
    }

    private static final WidgetChannelSettingsPermissionsOverviewViewModel$ViewState generateInitialViewState(boolean z2) {
        if (z2) {
            WidgetChannelSettingsPermissionsOverviewViewModel$Tab widgetChannelSettingsPermissionsOverviewViewModel$Tab = WidgetChannelSettingsPermissionsOverviewViewModel$Tab.MODERATOR;
            return new WidgetChannelSettingsPermissionsOverviewViewModel$ViewState(widgetChannelSettingsPermissionsOverviewViewModel$Tab, n.listOf((Object[]) new WidgetChannelSettingsPermissionsOverviewViewModel$Tab[]{widgetChannelSettingsPermissionsOverviewViewModel$Tab, WidgetChannelSettingsPermissionsOverviewViewModel$Tab.ADVANCED}));
        }
        WidgetChannelSettingsPermissionsOverviewViewModel$Tab widgetChannelSettingsPermissionsOverviewViewModel$Tab2 = WidgetChannelSettingsPermissionsOverviewViewModel$Tab.ADVANCED;
        return new WidgetChannelSettingsPermissionsOverviewViewModel$ViewState(widgetChannelSettingsPermissionsOverviewViewModel$Tab2, m.listOf(widgetChannelSettingsPermissionsOverviewViewModel$Tab2));
    }
}
