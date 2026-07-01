package com.discord.widgets.channels.permissions;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragment$viewModel$3 extends o implements Function0<WidgetChannelSettingsAddMemberFragmentViewModel> {
    public final /* synthetic */ WidgetChannelSettingsAddMemberFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsAddMemberFragment$viewModel$3(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        super(0);
        this.this$0 = widgetChannelSettingsAddMemberFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChannelSettingsAddMemberFragmentViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelSettingsAddMemberFragmentViewModel invoke() {
        return new WidgetChannelSettingsAddMemberFragmentViewModel(WidgetChannelSettingsAddMemberFragment.access$getChannelId$p(this.this$0), WidgetChannelSettingsAddMemberFragment.access$getShowRolesWithGuildPermission$p(this.this$0), null, null, null, null, null, 124, null);
    }
}
