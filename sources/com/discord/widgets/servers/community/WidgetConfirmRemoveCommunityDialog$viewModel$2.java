package com.discord.widgets.servers.community;

import com.discord.widgets.servers.WidgetServerSettingsChannels;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetConfirmRemoveCommunityDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetConfirmRemoveCommunityDialog$viewModel$2 extends AbstractC12240o implements Function0<WidgetServerSettingsCommunityOverviewViewModel> {
    public final /* synthetic */ WidgetConfirmRemoveCommunityDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetConfirmRemoveCommunityDialog$viewModel$2(WidgetConfirmRemoveCommunityDialog widgetConfirmRemoveCommunityDialog) {
        super(0);
        this.this$0 = widgetConfirmRemoveCommunityDialog;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetServerSettingsCommunityOverviewViewModel invoke() {
        return new WidgetServerSettingsCommunityOverviewViewModel(this.this$0.getArgumentsOrDefault().getLong(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, -1L), null, 2, null);
    }
}
