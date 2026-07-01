package com.discord.widgets.channels.settings;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.utilities.threads.ThreadUtils;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettingsViewModel$1 extends o implements Function0<WidgetThreadSettingsViewModel$StoreState> {
    public final /* synthetic */ StoreChannels $channelStore;
    public final /* synthetic */ StorePermissions $permissionStore;
    public final /* synthetic */ StoreUser $userStore;
    public final /* synthetic */ WidgetThreadSettingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadSettingsViewModel$1(WidgetThreadSettingsViewModel widgetThreadSettingsViewModel, StoreChannels storeChannels, StoreUser storeUser, StorePermissions storePermissions) {
        super(0);
        this.this$0 = widgetThreadSettingsViewModel;
        this.$channelStore = storeChannels;
        this.$userStore = storeUser;
        this.$permissionStore = storePermissions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetThreadSettingsViewModel$StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetThreadSettingsViewModel$StoreState invoke() {
        Channel channel = this.$channelStore.getChannel(this.this$0.getChannelId());
        return new WidgetThreadSettingsViewModel$StoreState(channel, channel != null ? ThreadUtils.INSTANCE.canManageThread(this.$userStore.getMeSnapshot(), channel, (Long) a.d(channel, this.$permissionStore.getPermissionsByChannel())) : false);
    }
}
