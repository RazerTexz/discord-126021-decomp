package com.discord.widgets.user.search;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$6 extends o implements Function1<Channel, Boolean> {
    public final /* synthetic */ WidgetGlobalSearchModel$ChannelContext $channelContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$6(WidgetGlobalSearchModel$ChannelContext widgetGlobalSearchModel$ChannelContext) {
        super(1);
        this.$channelContext = widgetGlobalSearchModel$ChannelContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "it");
        Object objD = a.d(channel, this.$channelContext.getChannelPerms());
        if (objD == null) {
            objD = 0L;
        }
        long jLongValue = ((Number) objD).longValue();
        return PermissionUtils.can(Permission.VIEW_CHANNEL, Long.valueOf(jLongValue)) && PermissionUtils.can(Permission.CONNECT, Long.valueOf(jLongValue));
    }
}
