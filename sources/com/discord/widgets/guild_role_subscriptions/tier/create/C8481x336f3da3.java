package com.discord.widgets.guild_role_subscriptions.tier.create;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionReviewViewModel;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionReviewViewModel$Companion$observeStoreState$1 */
/* JADX INFO: compiled from: GuildRoleSubscriptionReviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8481x336f3da3 extends AbstractC12240o implements Function0<GuildRoleSubscriptionReviewViewModel.StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreChannels $storeChannels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8481x336f3da3(StoreChannels storeChannels, long j) {
        super(0);
        this.$storeChannels = storeChannels;
        this.$guildId = j;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionReviewViewModel.StoreState invoke() {
        Collection<Channel> collectionValues = this.$storeChannels.getChannelsForGuild(this.$guildId).values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (!ChannelUtils.m7687k((Channel) obj)) {
                arrayList.add(obj);
            }
        }
        return new GuildRoleSubscriptionReviewViewModel.StoreState(arrayList.size());
    }
}
