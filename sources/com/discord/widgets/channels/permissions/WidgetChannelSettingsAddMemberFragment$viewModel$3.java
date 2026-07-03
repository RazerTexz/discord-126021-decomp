package com.discord.widgets.channels.permissions;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragment$viewModel$3 extends AbstractC12240o implements Function0<WidgetChannelSettingsAddMemberFragmentViewModel> {
    public final /* synthetic */ WidgetChannelSettingsAddMemberFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsAddMemberFragment$viewModel$3(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        super(0);
        this.this$0 = widgetChannelSettingsAddMemberFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelSettingsAddMemberFragmentViewModel invoke() {
        return new WidgetChannelSettingsAddMemberFragmentViewModel(this.this$0.getChannelId(), this.this$0.getShowRolesWithGuildPermission(), null, null, null, null, null, 124, null);
    }
}
