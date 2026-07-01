package com.discord.widgets.channels.permissions;

import com.discord.models.user.User;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsAdvanced$configureMembers$1 extends o implements Function1<User, Unit> {
    public final /* synthetic */ WidgetChannelSettingsPermissionsAdvanced$Model $model;
    public final /* synthetic */ WidgetChannelSettingsPermissionsAdvanced this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsPermissionsAdvanced$configureMembers$1(WidgetChannelSettingsPermissionsAdvanced widgetChannelSettingsPermissionsAdvanced, WidgetChannelSettingsPermissionsAdvanced$Model widgetChannelSettingsPermissionsAdvanced$Model) {
        super(1);
        this.this$0 = widgetChannelSettingsPermissionsAdvanced;
        this.$model = widgetChannelSettingsPermissionsAdvanced$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        m.checkNotNullParameter(user, "user");
        WidgetChannelSettingsEditPermissions.Companion.createForUser(this.this$0.requireContext(), this.$model.getGuild().getId(), this.$model.getChannel().getId(), user.getId());
    }
}
