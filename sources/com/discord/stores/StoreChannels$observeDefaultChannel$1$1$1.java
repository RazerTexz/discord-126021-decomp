package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannels$observeDefaultChannel$1$1$1 extends o implements Function1<Channel, Boolean> {
    public final /* synthetic */ StoreChannels$observeDefaultChannel$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannels$observeDefaultChannel$1$1$1(StoreChannels$observeDefaultChannel$1$1 storeChannels$observeDefaultChannel$1$1) {
        super(1);
        this.this$0 = storeChannels$observeDefaultChannel$1$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        return PermissionUtils.can(Permission.VIEW_CHANNEL, (Long) a.d(channel, this.this$0.$guildChannelPermissions));
    }
}
