package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.utilities.search.validation.SearchData;
import com.discord.utilities.search.validation.SearchData$Builder;
import d0.t.h0;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreSearchData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearchData$getChannelSearchData$1 extends o implements Function0<SearchData> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreSearchData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreSearchData$getChannelSearchData$1(StoreSearchData storeSearchData, long j) {
        super(0);
        this.this$0 = storeSearchData;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SearchData invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SearchData invoke() {
        Channel channel = StoreSearchData.access$getStoreChannels$p(this.this$0).getChannel(this.$channelId);
        MeUser meSnapshot = StoreSearchData.access$getStoreUser$p(this.this$0).getMeSnapshot();
        Map<Long, GuildMember> mapEmptyMap = StoreSearchData.access$getStoreGuilds$p(this.this$0).getMembers().get(channel != null ? Long.valueOf(channel.getGuildId()) : null);
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        return new SearchData$Builder().buildForChannel(channel, meSnapshot, mapEmptyMap);
    }
}
