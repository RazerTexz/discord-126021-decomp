package com.discord.widgets.channels.permissions;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$showRolesWithGuildPermission$2 */
/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7528x94d74945 extends AbstractC12240o implements Function0<Boolean> {
    public final /* synthetic */ WidgetChannelSettingsAddMemberFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7528x94d74945(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        super(0);
        this.this$0 = widgetChannelSettingsAddMemberFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        return arguments.getBoolean(WidgetChannelSettingsAddMemberFragment.EXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION);
    }
}
