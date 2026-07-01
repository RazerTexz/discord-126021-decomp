package com.discord.widgets.channels.permissions;

import android.content.Context;
import com.discord.api.role.GuildRole;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsAdvanced$configureRoles$1 extends o implements Function1<GuildRole, Unit> {
    public final /* synthetic */ WidgetChannelSettingsPermissionsAdvanced$Model $model;
    public final /* synthetic */ WidgetChannelSettingsPermissionsAdvanced this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsPermissionsAdvanced$configureRoles$1(WidgetChannelSettingsPermissionsAdvanced widgetChannelSettingsPermissionsAdvanced, WidgetChannelSettingsPermissionsAdvanced$Model widgetChannelSettingsPermissionsAdvanced$Model) {
        super(1);
        this.this$0 = widgetChannelSettingsPermissionsAdvanced;
        this.$model = widgetChannelSettingsPermissionsAdvanced$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRole guildRole) {
        invoke2(guildRole);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRole guildRole) {
        WidgetChannelSettingsEditPermissions$Companion widgetChannelSettingsEditPermissions$Companion = WidgetChannelSettingsEditPermissions.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        long id2 = this.$model.getGuild().getId();
        long id3 = this.$model.getChannel().getId();
        m.checkNotNull(guildRole);
        widgetChannelSettingsEditPermissions$Companion.createForRole(contextRequireContext, id2, id3, guildRole.getId());
    }
}
