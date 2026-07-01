package com.discord.widgets.servers.community;

import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverview5 extends Lambda implements Function0<WidgetServerSettingsCommunityOverviewViewModel> {
    public final /* synthetic */ WidgetServerSettingsCommunityOverview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCommunityOverview5(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview) {
        super(0);
        this.this$0 = widgetServerSettingsCommunityOverview;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetServerSettingsCommunityOverviewViewModel invoke() {
        return new WidgetServerSettingsCommunityOverviewViewModel(this.this$0.getMostRecentIntent().getLongExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, -1L), null, 2, null);
    }
}
