package com.discord.widgets.chat.input;

import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft;
import com.discord.stores.StoreChat$EditingMessage;
import com.discord.stores.StoreThreadDraft$ThreadDraftState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function13;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$Companion$observeStoreState$1$1 extends o implements Function13<MeUser, StoreChat$EditingMessage, Integer, Long, GuildVerificationLevel, Boolean, Boolean, Guild, ChatInputViewModel$StoreState$Loaded$PendingReply, GuildMember, GuildJoinRequest, StoreThreadDraft$ThreadDraftState, Boolean, ChatInputViewModel$StoreState$Loaded> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ StoreChannelsSelected$ResolvedSelectedChannel $selectedChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$Companion$observeStoreState$1$1(Channel channel, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        super(13);
        this.$channel = channel;
        this.$selectedChannel = storeChannelsSelected$ResolvedSelectedChannel;
    }

    @Override // kotlin.jvm.functions.Function13
    public /* bridge */ /* synthetic */ ChatInputViewModel$StoreState$Loaded invoke(MeUser meUser, StoreChat$EditingMessage storeChat$EditingMessage, Integer num, Long l, GuildVerificationLevel guildVerificationLevel, Boolean bool, Boolean bool2, Guild guild, ChatInputViewModel$StoreState$Loaded$PendingReply chatInputViewModel$StoreState$Loaded$PendingReply, GuildMember guildMember, GuildJoinRequest guildJoinRequest, StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState, Boolean bool3) {
        return invoke(meUser, storeChat$EditingMessage, num, l, guildVerificationLevel, bool.booleanValue(), bool2, guild, chatInputViewModel$StoreState$Loaded$PendingReply, guildMember, guildJoinRequest, storeThreadDraft$ThreadDraftState, bool3.booleanValue());
    }

    public final ChatInputViewModel$StoreState$Loaded invoke(MeUser meUser, StoreChat$EditingMessage storeChat$EditingMessage, Integer num, Long l, GuildVerificationLevel guildVerificationLevel, boolean z2, Boolean bool, Guild guild, ChatInputViewModel$StoreState$Loaded$PendingReply chatInputViewModel$StoreState$Loaded$PendingReply, GuildMember guildMember, GuildJoinRequest guildJoinRequest, StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState, boolean z3) {
        m.checkNotNullParameter(meUser, "me");
        m.checkNotNullParameter(guildVerificationLevel, "verificationLevelTriggered");
        m.checkNotNullParameter(storeThreadDraft$ThreadDraftState, "threadDraftState");
        Channel channel = this.$channel;
        m.checkNotNullExpressionValue(bool, "isOnCooldown");
        boolean zBooleanValue = bool.booleanValue();
        StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel = this.$selectedChannel;
        if (!(storeChannelsSelected$ResolvedSelectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft)) {
            storeChannelsSelected$ResolvedSelectedChannel = null;
        }
        return new ChatInputViewModel$StoreState$Loaded(channel, meUser, storeChat$EditingMessage, num, l, guildVerificationLevel, z2, zBooleanValue, guild, chatInputViewModel$StoreState$Loaded$PendingReply, (StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft) storeChannelsSelected$ResolvedSelectedChannel, guildMember, guildJoinRequest, storeThreadDraft$ThreadDraftState, z3);
    }
}
