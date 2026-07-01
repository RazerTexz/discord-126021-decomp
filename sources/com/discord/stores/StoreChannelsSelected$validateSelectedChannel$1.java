package com.discord.stores;

import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelsSelected$validateSelectedChannel$1 extends o implements Function0<StoreChannelsSelected$ResolvedSelectedChannel> {
    public final /* synthetic */ Map $allChannels;
    public final /* synthetic */ StoreChannelsSelected$UserChannelSelection $channelSelection;
    public final /* synthetic */ boolean $isChannelStoreInitializedForAuthedUser;
    public final /* synthetic */ Map $permissionsForChannelsInGuild;
    public final /* synthetic */ long $selectedGuildId;
    public final /* synthetic */ StoreChannelsSelected this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelsSelected$validateSelectedChannel$1(StoreChannelsSelected storeChannelsSelected, StoreChannelsSelected$UserChannelSelection storeChannelsSelected$UserChannelSelection, Map map, long j, Map map2, boolean z2) {
        super(0);
        this.this$0 = storeChannelsSelected;
        this.$channelSelection = storeChannelsSelected$UserChannelSelection;
        this.$allChannels = map;
        this.$selectedGuildId = j;
        this.$permissionsForChannelsInGuild = map2;
        this.$isChannelStoreInitializedForAuthedUser = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreChannelsSelected$ResolvedSelectedChannel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreChannelsSelected$ResolvedSelectedChannel invoke() {
        StoreChannelsSelected$UserChannelSelection storeChannelsSelected$UserChannelSelection = this.$channelSelection;
        return StoreChannelsSelected.access$resolveSelectedChannel(this.this$0, this.$channelSelection, storeChannelsSelected$UserChannelSelection != null ? StoreChannelsSelected.access$getStoreChannels$p(this.this$0).getChannel(storeChannelsSelected$UserChannelSelection.getId()) : null, this.$allChannels, this.$selectedGuildId, this.$permissionsForChannelsInGuild, this.$isChannelStoreInitializedForAuthedUser);
    }
}
