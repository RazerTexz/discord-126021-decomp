package com.discord.widgets.chat.input;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft;
import com.discord.stores.StoreChat$EditingMessage;
import com.discord.stores.StoreThreadDraft$ThreadDraftState;
import d0.z.d.m;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChatInputViewModel$StoreState$Loaded extends ChatInputViewModel$StoreState {
    private final Channel channel;
    private final Long channelPermissions;
    private final StoreChat$EditingMessage editingMessage;
    private final Guild guild;
    private final GuildJoinRequest guildJoinRequest;
    private final boolean isForumPostCreateInProgress;
    private final boolean isLurking;
    private final boolean isOnCooldown;
    private final MeUser me;
    private final GuildMember meGuildMember;
    private final ChatInputViewModel$StoreState$Loaded$PendingReply pendingReply;
    private final Integer relationshipType;
    private final StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft selectedThreadDraft;
    private final StoreThreadDraft$ThreadDraftState threadDraftState;
    private final GuildVerificationLevel verificationLevelTriggered;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$StoreState$Loaded(Channel channel, MeUser meUser, StoreChat$EditingMessage storeChat$EditingMessage, Integer num, Long l, GuildVerificationLevel guildVerificationLevel, boolean z2, boolean z3, Guild guild, ChatInputViewModel$StoreState$Loaded$PendingReply chatInputViewModel$StoreState$Loaded$PendingReply, StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft, GuildMember guildMember, GuildJoinRequest guildJoinRequest, StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState, boolean z4) {
        super(null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(meUser, "me");
        m.checkNotNullParameter(guildVerificationLevel, "verificationLevelTriggered");
        m.checkNotNullParameter(storeThreadDraft$ThreadDraftState, "threadDraftState");
        this.channel = channel;
        this.me = meUser;
        this.editingMessage = storeChat$EditingMessage;
        this.relationshipType = num;
        this.channelPermissions = l;
        this.verificationLevelTriggered = guildVerificationLevel;
        this.isLurking = z2;
        this.isOnCooldown = z3;
        this.guild = guild;
        this.pendingReply = chatInputViewModel$StoreState$Loaded$PendingReply;
        this.selectedThreadDraft = storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft;
        this.meGuildMember = guildMember;
        this.guildJoinRequest = guildJoinRequest;
        this.threadDraftState = storeThreadDraft$ThreadDraftState;
        this.isForumPostCreateInProgress = z4;
    }

    public static /* synthetic */ ChatInputViewModel$StoreState$Loaded copy$default(ChatInputViewModel$StoreState$Loaded chatInputViewModel$StoreState$Loaded, Channel channel, MeUser meUser, StoreChat$EditingMessage storeChat$EditingMessage, Integer num, Long l, GuildVerificationLevel guildVerificationLevel, boolean z2, boolean z3, Guild guild, ChatInputViewModel$StoreState$Loaded$PendingReply chatInputViewModel$StoreState$Loaded$PendingReply, StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft, GuildMember guildMember, GuildJoinRequest guildJoinRequest, StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState, boolean z4, int i, Object obj) {
        return chatInputViewModel$StoreState$Loaded.copy((i & 1) != 0 ? chatInputViewModel$StoreState$Loaded.channel : channel, (i & 2) != 0 ? chatInputViewModel$StoreState$Loaded.me : meUser, (i & 4) != 0 ? chatInputViewModel$StoreState$Loaded.editingMessage : storeChat$EditingMessage, (i & 8) != 0 ? chatInputViewModel$StoreState$Loaded.relationshipType : num, (i & 16) != 0 ? chatInputViewModel$StoreState$Loaded.channelPermissions : l, (i & 32) != 0 ? chatInputViewModel$StoreState$Loaded.verificationLevelTriggered : guildVerificationLevel, (i & 64) != 0 ? chatInputViewModel$StoreState$Loaded.isLurking : z2, (i & 128) != 0 ? chatInputViewModel$StoreState$Loaded.isOnCooldown : z3, (i & 256) != 0 ? chatInputViewModel$StoreState$Loaded.guild : guild, (i & 512) != 0 ? chatInputViewModel$StoreState$Loaded.pendingReply : chatInputViewModel$StoreState$Loaded$PendingReply, (i & 1024) != 0 ? chatInputViewModel$StoreState$Loaded.selectedThreadDraft : storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft, (i & 2048) != 0 ? chatInputViewModel$StoreState$Loaded.meGuildMember : guildMember, (i & 4096) != 0 ? chatInputViewModel$StoreState$Loaded.guildJoinRequest : guildJoinRequest, (i & 8192) != 0 ? chatInputViewModel$StoreState$Loaded.threadDraftState : storeThreadDraft$ThreadDraftState, (i & 16384) != 0 ? chatInputViewModel$StoreState$Loaded.isForumPostCreateInProgress : z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final ChatInputViewModel$StoreState$Loaded$PendingReply getPendingReply() {
        return this.pendingReply;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft getSelectedThreadDraft() {
        return this.selectedThreadDraft;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final GuildMember getMeGuildMember() {
        return this.meGuildMember;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final GuildJoinRequest getGuildJoinRequest() {
        return this.guildJoinRequest;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final StoreThreadDraft$ThreadDraftState getThreadDraftState() {
        return this.threadDraftState;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getIsForumPostCreateInProgress() {
        return this.isForumPostCreateInProgress;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StoreChat$EditingMessage getEditingMessage() {
        return this.editingMessage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getRelationshipType() {
        return this.relationshipType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getChannelPermissions() {
        return this.channelPermissions;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final GuildVerificationLevel getVerificationLevelTriggered() {
        return this.verificationLevelTriggered;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsLurking() {
        return this.isLurking;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsOnCooldown() {
        return this.isOnCooldown;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final ChatInputViewModel$StoreState$Loaded copy(Channel channel, MeUser me2, StoreChat$EditingMessage editingMessage, Integer relationshipType, Long channelPermissions, GuildVerificationLevel verificationLevelTriggered, boolean isLurking, boolean isOnCooldown, Guild guild, ChatInputViewModel$StoreState$Loaded$PendingReply pendingReply, StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft selectedThreadDraft, GuildMember meGuildMember, GuildJoinRequest guildJoinRequest, StoreThreadDraft$ThreadDraftState threadDraftState, boolean isForumPostCreateInProgress) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(me2, "me");
        m.checkNotNullParameter(verificationLevelTriggered, "verificationLevelTriggered");
        m.checkNotNullParameter(threadDraftState, "threadDraftState");
        return new ChatInputViewModel$StoreState$Loaded(channel, me2, editingMessage, relationshipType, channelPermissions, verificationLevelTriggered, isLurking, isOnCooldown, guild, pendingReply, selectedThreadDraft, meGuildMember, guildJoinRequest, threadDraftState, isForumPostCreateInProgress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatInputViewModel$StoreState$Loaded)) {
            return false;
        }
        ChatInputViewModel$StoreState$Loaded chatInputViewModel$StoreState$Loaded = (ChatInputViewModel$StoreState$Loaded) other;
        return m.areEqual(this.channel, chatInputViewModel$StoreState$Loaded.channel) && m.areEqual(this.me, chatInputViewModel$StoreState$Loaded.me) && m.areEqual(this.editingMessage, chatInputViewModel$StoreState$Loaded.editingMessage) && m.areEqual(this.relationshipType, chatInputViewModel$StoreState$Loaded.relationshipType) && m.areEqual(this.channelPermissions, chatInputViewModel$StoreState$Loaded.channelPermissions) && m.areEqual(this.verificationLevelTriggered, chatInputViewModel$StoreState$Loaded.verificationLevelTriggered) && this.isLurking == chatInputViewModel$StoreState$Loaded.isLurking && this.isOnCooldown == chatInputViewModel$StoreState$Loaded.isOnCooldown && m.areEqual(this.guild, chatInputViewModel$StoreState$Loaded.guild) && m.areEqual(this.pendingReply, chatInputViewModel$StoreState$Loaded.pendingReply) && m.areEqual(this.selectedThreadDraft, chatInputViewModel$StoreState$Loaded.selectedThreadDraft) && m.areEqual(this.meGuildMember, chatInputViewModel$StoreState$Loaded.meGuildMember) && m.areEqual(this.guildJoinRequest, chatInputViewModel$StoreState$Loaded.guildJoinRequest) && m.areEqual(this.threadDraftState, chatInputViewModel$StoreState$Loaded.threadDraftState) && this.isForumPostCreateInProgress == chatInputViewModel$StoreState$Loaded.isForumPostCreateInProgress;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Long getChannelPermissions() {
        return this.channelPermissions;
    }

    public final StoreChat$EditingMessage getEditingMessage() {
        return this.editingMessage;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final GuildJoinRequest getGuildJoinRequest() {
        return this.guildJoinRequest;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final GuildMember getMeGuildMember() {
        return this.meGuildMember;
    }

    public final ChatInputViewModel$StoreState$Loaded$PendingReply getPendingReply() {
        return this.pendingReply;
    }

    public final Integer getRelationshipType() {
        return this.relationshipType;
    }

    public final StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft getSelectedThreadDraft() {
        return this.selectedThreadDraft;
    }

    public final StoreThreadDraft$ThreadDraftState getThreadDraftState() {
        return this.threadDraftState;
    }

    public final GuildVerificationLevel getVerificationLevelTriggered() {
        return this.verificationLevelTriggered;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        MeUser meUser = this.me;
        int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
        StoreChat$EditingMessage storeChat$EditingMessage = this.editingMessage;
        int iHashCode3 = (iHashCode2 + (storeChat$EditingMessage != null ? storeChat$EditingMessage.hashCode() : 0)) * 31;
        Integer num = this.relationshipType;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Long l = this.channelPermissions;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        GuildVerificationLevel guildVerificationLevel = this.verificationLevelTriggered;
        int iHashCode6 = (iHashCode5 + (guildVerificationLevel != null ? guildVerificationLevel.hashCode() : 0)) * 31;
        boolean z2 = this.isLurking;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode6 + r2) * 31;
        boolean z3 = this.isOnCooldown;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        Guild guild = this.guild;
        int iHashCode7 = (i2 + (guild != null ? guild.hashCode() : 0)) * 31;
        ChatInputViewModel$StoreState$Loaded$PendingReply chatInputViewModel$StoreState$Loaded$PendingReply = this.pendingReply;
        int iHashCode8 = (iHashCode7 + (chatInputViewModel$StoreState$Loaded$PendingReply != null ? chatInputViewModel$StoreState$Loaded$PendingReply.hashCode() : 0)) * 31;
        StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft = this.selectedThreadDraft;
        int iHashCode9 = (iHashCode8 + (storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft != null ? storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft.hashCode() : 0)) * 31;
        GuildMember guildMember = this.meGuildMember;
        int iHashCode10 = (iHashCode9 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        GuildJoinRequest guildJoinRequest = this.guildJoinRequest;
        int iHashCode11 = (iHashCode10 + (guildJoinRequest != null ? guildJoinRequest.hashCode() : 0)) * 31;
        StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState = this.threadDraftState;
        int iHashCode12 = (iHashCode11 + (storeThreadDraft$ThreadDraftState != null ? storeThreadDraft$ThreadDraftState.hashCode() : 0)) * 31;
        boolean z4 = this.isForumPostCreateInProgress;
        return iHashCode12 + (z4 ? 1 : z4);
    }

    public final boolean isForumPostCreateInProgress() {
        return this.isForumPostCreateInProgress;
    }

    public final boolean isLurking() {
        return this.isLurking;
    }

    public final boolean isOnCooldown() {
        return this.isOnCooldown;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(channel=");
        sbU.append(this.channel);
        sbU.append(", me=");
        sbU.append(this.me);
        sbU.append(", editingMessage=");
        sbU.append(this.editingMessage);
        sbU.append(", relationshipType=");
        sbU.append(this.relationshipType);
        sbU.append(", channelPermissions=");
        sbU.append(this.channelPermissions);
        sbU.append(", verificationLevelTriggered=");
        sbU.append(this.verificationLevelTriggered);
        sbU.append(", isLurking=");
        sbU.append(this.isLurking);
        sbU.append(", isOnCooldown=");
        sbU.append(this.isOnCooldown);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", pendingReply=");
        sbU.append(this.pendingReply);
        sbU.append(", selectedThreadDraft=");
        sbU.append(this.selectedThreadDraft);
        sbU.append(", meGuildMember=");
        sbU.append(this.meGuildMember);
        sbU.append(", guildJoinRequest=");
        sbU.append(this.guildJoinRequest);
        sbU.append(", threadDraftState=");
        sbU.append(this.threadDraftState);
        sbU.append(", isForumPostCreateInProgress=");
        return a.O(sbU, this.isForumPostCreateInProgress, ")");
    }
}
