package com.discord.stores;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.restapi.RestAPIParams$ThreadMemberSettings;
import com.discord.restapi.RestAPIParams$UserGuildSettings;
import com.discord.restapi.RestAPIParams$UserGuildSettings$ChannelOverride;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserGuildSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserGuildSettings$setChannelMuted$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ ModelMuteConfig $muteConfig;
    public final /* synthetic */ boolean $muted;
    public final /* synthetic */ StoreUserGuildSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserGuildSettings$setChannelMuted$1(StoreUserGuildSettings storeUserGuildSettings, long j, Context context, boolean z2, ModelMuteConfig modelMuteConfig) {
        super(0);
        this.this$0 = storeUserGuildSettings;
        this.$channelId = j;
        this.$context = context;
        this.$muted = z2;
        this.$muteConfig = modelMuteConfig;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = StoreUserGuildSettings.access$getStoreChannels$p(this.this$0).findChannelByIdInternal$app_productionGoogleRelease(this.$channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
            StoreUserGuildSettings$SettingsUpdateType storeUserGuildSettings$SettingsUpdateTypeAccess$getSettingsUpdateType = StoreUserGuildSettings.access$getSettingsUpdateType(this.this$0, channelFindChannelByIdInternal$app_productionGoogleRelease);
            if (!ChannelUtils.H(channelFindChannelByIdInternal$app_productionGoogleRelease)) {
                StoreUserGuildSettings.access$updateUserGuildSettings(this.this$0, this.$context, channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId(), new RestAPIParams$UserGuildSettings(channelFindChannelByIdInternal$app_productionGoogleRelease.getId(), new RestAPIParams$UserGuildSettings$ChannelOverride(Boolean.valueOf(this.$muted), this.$muteConfig, null, null, 12, null)), storeUserGuildSettings$SettingsUpdateTypeAccess$getSettingsUpdateType);
            } else {
                StoreThreadsJoined$JoinedThread joinedThread = StoreUserGuildSettings.access$getStoreThreadsJoined$p(this.this$0).getJoinedThread(channelFindChannelByIdInternal$app_productionGoogleRelease.getId());
                StoreUserGuildSettings.access$updateThreadMemberSettings(this.this$0, this.$context, channelFindChannelByIdInternal$app_productionGoogleRelease.getId(), channelFindChannelByIdInternal$app_productionGoogleRelease.getParentId(), new RestAPIParams$ThreadMemberSettings(null, Boolean.valueOf(this.$muted), this.$muteConfig, 1, null), joinedThread != null ? joinedThread.getFlags() : 0);
            }
        }
    }
}
