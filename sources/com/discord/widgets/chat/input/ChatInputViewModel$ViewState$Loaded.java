package com.discord.widgets.chat.input;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft;
import com.discord.stores.StoreChat$EditingMessage;
import com.discord.stores.StoreThreadDraft$ThreadDraftState;
import d0.z.d.m;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChatInputViewModel$ViewState$Loaded extends ChatInputViewModel$ViewState {
    private final boolean ableToSendMessage;
    private final Channel channel;
    private final long channelId;
    private final StoreChat$EditingMessage editingMessage;
    private final boolean isBlocked;
    private final boolean isCommunicationDisabled;
    private final boolean isEditing;
    private final boolean isInputShowing;
    private final boolean isLurking;
    private final boolean isOnCooldown;
    private final boolean isReplying;
    private final boolean isSystemDM;
    private final boolean isVerificationLevelTriggered;
    private final ApplicationStatus joinRequestStatus;
    private final int maxFileSizeMB;
    private final MeUser me;
    private final GuildMember meGuildMember;
    private final ChatInputViewModel$ViewState$Loaded$PendingReplyState pendingReplyState;
    private final StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft selectedThreadDraft;
    private final boolean shouldBadgeChatInput;
    private final boolean shouldShowFollow;
    private final boolean shouldShowVerificationGate;
    private final boolean showCreateThreadOption;
    private final StoreThreadDraft$ThreadDraftState threadDraftState;
    private final long timeoutLeftMs;
    private final GuildVerificationLevel verificationLevelTriggered;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$ViewState$Loaded(Channel channel, long j, MeUser meUser, GuildMember guildMember, StoreChat$EditingMessage storeChat$EditingMessage, boolean z2, GuildVerificationLevel guildVerificationLevel, boolean z3, boolean z4, boolean z5, int i, boolean z6, ChatInputViewModel$ViewState$Loaded$PendingReplyState chatInputViewModel$ViewState$Loaded$PendingReplyState, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, long j2, StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft, boolean z14, ApplicationStatus applicationStatus, StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState, boolean z15) {
        super(null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(guildVerificationLevel, "verificationLevelTriggered");
        m.checkNotNullParameter(chatInputViewModel$ViewState$Loaded$PendingReplyState, "pendingReplyState");
        m.checkNotNullParameter(storeThreadDraft$ThreadDraftState, "threadDraftState");
        this.channel = channel;
        this.channelId = j;
        this.me = meUser;
        this.meGuildMember = guildMember;
        this.editingMessage = storeChat$EditingMessage;
        this.ableToSendMessage = z2;
        this.verificationLevelTriggered = guildVerificationLevel;
        this.isLurking = z3;
        this.isSystemDM = z4;
        this.isOnCooldown = z5;
        this.maxFileSizeMB = i;
        this.shouldShowFollow = z6;
        this.pendingReplyState = chatInputViewModel$ViewState$Loaded$PendingReplyState;
        this.shouldBadgeChatInput = z7;
        this.isBlocked = z8;
        this.isInputShowing = z9;
        this.isVerificationLevelTriggered = z10;
        this.isEditing = z11;
        this.isReplying = z12;
        this.isCommunicationDisabled = z13;
        this.timeoutLeftMs = j2;
        this.selectedThreadDraft = storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft;
        this.shouldShowVerificationGate = z14;
        this.joinRequestStatus = applicationStatus;
        this.threadDraftState = storeThreadDraft$ThreadDraftState;
        this.showCreateThreadOption = z15;
    }

    public static /* synthetic */ ChatInputViewModel$ViewState$Loaded copy$default(ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded, Channel channel, long j, MeUser meUser, GuildMember guildMember, StoreChat$EditingMessage storeChat$EditingMessage, boolean z2, GuildVerificationLevel guildVerificationLevel, boolean z3, boolean z4, boolean z5, int i, boolean z6, ChatInputViewModel$ViewState$Loaded$PendingReplyState chatInputViewModel$ViewState$Loaded$PendingReplyState, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, long j2, StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft, boolean z14, ApplicationStatus applicationStatus, StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState, boolean z15, int i2, Object obj) {
        return chatInputViewModel$ViewState$Loaded.copy((i2 & 1) != 0 ? chatInputViewModel$ViewState$Loaded.channel : channel, (i2 & 2) != 0 ? chatInputViewModel$ViewState$Loaded.channelId : j, (i2 & 4) != 0 ? chatInputViewModel$ViewState$Loaded.me : meUser, (i2 & 8) != 0 ? chatInputViewModel$ViewState$Loaded.meGuildMember : guildMember, (i2 & 16) != 0 ? chatInputViewModel$ViewState$Loaded.editingMessage : storeChat$EditingMessage, (i2 & 32) != 0 ? chatInputViewModel$ViewState$Loaded.ableToSendMessage : z2, (i2 & 64) != 0 ? chatInputViewModel$ViewState$Loaded.verificationLevelTriggered : guildVerificationLevel, (i2 & 128) != 0 ? chatInputViewModel$ViewState$Loaded.isLurking : z3, (i2 & 256) != 0 ? chatInputViewModel$ViewState$Loaded.isSystemDM : z4, (i2 & 512) != 0 ? chatInputViewModel$ViewState$Loaded.isOnCooldown : z5, (i2 & 1024) != 0 ? chatInputViewModel$ViewState$Loaded.maxFileSizeMB : i, (i2 & 2048) != 0 ? chatInputViewModel$ViewState$Loaded.shouldShowFollow : z6, (i2 & 4096) != 0 ? chatInputViewModel$ViewState$Loaded.pendingReplyState : chatInputViewModel$ViewState$Loaded$PendingReplyState, (i2 & 8192) != 0 ? chatInputViewModel$ViewState$Loaded.shouldBadgeChatInput : z7, (i2 & 16384) != 0 ? chatInputViewModel$ViewState$Loaded.isBlocked : z8, (i2 & 32768) != 0 ? chatInputViewModel$ViewState$Loaded.isInputShowing : z9, (i2 & 65536) != 0 ? chatInputViewModel$ViewState$Loaded.isVerificationLevelTriggered : z10, (i2 & 131072) != 0 ? chatInputViewModel$ViewState$Loaded.isEditing : z11, (i2 & 262144) != 0 ? chatInputViewModel$ViewState$Loaded.isReplying : z12, (i2 & 524288) != 0 ? chatInputViewModel$ViewState$Loaded.isCommunicationDisabled : z13, (i2 & 1048576) != 0 ? chatInputViewModel$ViewState$Loaded.timeoutLeftMs : j2, (i2 & 2097152) != 0 ? chatInputViewModel$ViewState$Loaded.selectedThreadDraft : storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft, (4194304 & i2) != 0 ? chatInputViewModel$ViewState$Loaded.shouldShowVerificationGate : z14, (i2 & 8388608) != 0 ? chatInputViewModel$ViewState$Loaded.joinRequestStatus : applicationStatus, (i2 & 16777216) != 0 ? chatInputViewModel$ViewState$Loaded.threadDraftState : storeThreadDraft$ThreadDraftState, (i2 & 33554432) != 0 ? chatInputViewModel$ViewState$Loaded.showCreateThreadOption : z15);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsOnCooldown() {
        return this.isOnCooldown;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getMaxFileSizeMB() {
        return this.maxFileSizeMB;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getShouldShowFollow() {
        return this.shouldShowFollow;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final ChatInputViewModel$ViewState$Loaded$PendingReplyState getPendingReplyState() {
        return this.pendingReplyState;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getShouldBadgeChatInput() {
        return this.shouldBadgeChatInput;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getIsBlocked() {
        return this.isBlocked;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getIsInputShowing() {
        return this.isInputShowing;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getIsVerificationLevelTriggered() {
        return this.isVerificationLevelTriggered;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final boolean getIsEditing() {
        return this.isEditing;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final boolean getIsReplying() {
        return this.isReplying;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final boolean getIsCommunicationDisabled() {
        return this.isCommunicationDisabled;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final long getTimeoutLeftMs() {
        return this.timeoutLeftMs;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft getSelectedThreadDraft() {
        return this.selectedThreadDraft;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final boolean getShouldShowVerificationGate() {
        return this.shouldShowVerificationGate;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final ApplicationStatus getJoinRequestStatus() {
        return this.joinRequestStatus;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final StoreThreadDraft$ThreadDraftState getThreadDraftState() {
        return this.threadDraftState;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final boolean getShowCreateThreadOption() {
        return this.showCreateThreadOption;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GuildMember getMeGuildMember() {
        return this.meGuildMember;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final StoreChat$EditingMessage getEditingMessage() {
        return this.editingMessage;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getAbleToSendMessage() {
        return this.ableToSendMessage;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final GuildVerificationLevel getVerificationLevelTriggered() {
        return this.verificationLevelTriggered;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsLurking() {
        return this.isLurking;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsSystemDM() {
        return this.isSystemDM;
    }

    public final ChatInputViewModel$ViewState$Loaded copy(Channel channel, long channelId, MeUser me2, GuildMember meGuildMember, StoreChat$EditingMessage editingMessage, boolean ableToSendMessage, GuildVerificationLevel verificationLevelTriggered, boolean isLurking, boolean isSystemDM, boolean isOnCooldown, int maxFileSizeMB, boolean shouldShowFollow, ChatInputViewModel$ViewState$Loaded$PendingReplyState pendingReplyState, boolean shouldBadgeChatInput, boolean isBlocked, boolean isInputShowing, boolean isVerificationLevelTriggered, boolean isEditing, boolean isReplying, boolean isCommunicationDisabled, long timeoutLeftMs, StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft selectedThreadDraft, boolean shouldShowVerificationGate, ApplicationStatus joinRequestStatus, StoreThreadDraft$ThreadDraftState threadDraftState, boolean showCreateThreadOption) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(verificationLevelTriggered, "verificationLevelTriggered");
        m.checkNotNullParameter(pendingReplyState, "pendingReplyState");
        m.checkNotNullParameter(threadDraftState, "threadDraftState");
        return new ChatInputViewModel$ViewState$Loaded(channel, channelId, me2, meGuildMember, editingMessage, ableToSendMessage, verificationLevelTriggered, isLurking, isSystemDM, isOnCooldown, maxFileSizeMB, shouldShowFollow, pendingReplyState, shouldBadgeChatInput, isBlocked, isInputShowing, isVerificationLevelTriggered, isEditing, isReplying, isCommunicationDisabled, timeoutLeftMs, selectedThreadDraft, shouldShowVerificationGate, joinRequestStatus, threadDraftState, showCreateThreadOption);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatInputViewModel$ViewState$Loaded)) {
            return false;
        }
        ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded = (ChatInputViewModel$ViewState$Loaded) other;
        return m.areEqual(this.channel, chatInputViewModel$ViewState$Loaded.channel) && this.channelId == chatInputViewModel$ViewState$Loaded.channelId && m.areEqual(this.me, chatInputViewModel$ViewState$Loaded.me) && m.areEqual(this.meGuildMember, chatInputViewModel$ViewState$Loaded.meGuildMember) && m.areEqual(this.editingMessage, chatInputViewModel$ViewState$Loaded.editingMessage) && this.ableToSendMessage == chatInputViewModel$ViewState$Loaded.ableToSendMessage && m.areEqual(this.verificationLevelTriggered, chatInputViewModel$ViewState$Loaded.verificationLevelTriggered) && this.isLurking == chatInputViewModel$ViewState$Loaded.isLurking && this.isSystemDM == chatInputViewModel$ViewState$Loaded.isSystemDM && this.isOnCooldown == chatInputViewModel$ViewState$Loaded.isOnCooldown && this.maxFileSizeMB == chatInputViewModel$ViewState$Loaded.maxFileSizeMB && this.shouldShowFollow == chatInputViewModel$ViewState$Loaded.shouldShowFollow && m.areEqual(this.pendingReplyState, chatInputViewModel$ViewState$Loaded.pendingReplyState) && this.shouldBadgeChatInput == chatInputViewModel$ViewState$Loaded.shouldBadgeChatInput && this.isBlocked == chatInputViewModel$ViewState$Loaded.isBlocked && this.isInputShowing == chatInputViewModel$ViewState$Loaded.isInputShowing && this.isVerificationLevelTriggered == chatInputViewModel$ViewState$Loaded.isVerificationLevelTriggered && this.isEditing == chatInputViewModel$ViewState$Loaded.isEditing && this.isReplying == chatInputViewModel$ViewState$Loaded.isReplying && this.isCommunicationDisabled == chatInputViewModel$ViewState$Loaded.isCommunicationDisabled && this.timeoutLeftMs == chatInputViewModel$ViewState$Loaded.timeoutLeftMs && m.areEqual(this.selectedThreadDraft, chatInputViewModel$ViewState$Loaded.selectedThreadDraft) && this.shouldShowVerificationGate == chatInputViewModel$ViewState$Loaded.shouldShowVerificationGate && m.areEqual(this.joinRequestStatus, chatInputViewModel$ViewState$Loaded.joinRequestStatus) && m.areEqual(this.threadDraftState, chatInputViewModel$ViewState$Loaded.threadDraftState) && this.showCreateThreadOption == chatInputViewModel$ViewState$Loaded.showCreateThreadOption;
    }

    public final boolean getAbleToSendMessage() {
        return this.ableToSendMessage;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final StoreChat$EditingMessage getEditingMessage() {
        return this.editingMessage;
    }

    public final ApplicationStatus getJoinRequestStatus() {
        return this.joinRequestStatus;
    }

    public final int getMaxFileSizeMB() {
        return this.maxFileSizeMB;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final GuildMember getMeGuildMember() {
        return this.meGuildMember;
    }

    public final ChatInputViewModel$ViewState$Loaded$PendingReplyState getPendingReplyState() {
        return this.pendingReplyState;
    }

    public final StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft getSelectedThreadDraft() {
        return this.selectedThreadDraft;
    }

    public final boolean getShouldBadgeChatInput() {
        return this.shouldBadgeChatInput;
    }

    public final boolean getShouldShowFollow() {
        return this.shouldShowFollow;
    }

    public final boolean getShouldShowVerificationGate() {
        return this.shouldShowVerificationGate;
    }

    public final boolean getShowCreateThreadOption() {
        return this.showCreateThreadOption;
    }

    public final StoreThreadDraft$ThreadDraftState getThreadDraftState() {
        return this.threadDraftState;
    }

    public final long getTimeoutLeftMs() {
        return this.timeoutLeftMs;
    }

    public final GuildVerificationLevel getVerificationLevelTriggered() {
        return this.verificationLevelTriggered;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v31, types: [int] */
    /* JADX WARN: Type inference failed for: r0v33, types: [int] */
    /* JADX WARN: Type inference failed for: r0v35, types: [int] */
    /* JADX WARN: Type inference failed for: r0v37, types: [int] */
    /* JADX WARN: Type inference failed for: r0v39, types: [int] */
    /* JADX WARN: Type inference failed for: r0v41, types: [int] */
    /* JADX WARN: Type inference failed for: r0v43, types: [int] */
    /* JADX WARN: Type inference failed for: r0v55, types: [int] */
    /* JADX WARN: Type inference failed for: r0v56 */
    /* JADX WARN: Type inference failed for: r0v57 */
    /* JADX WARN: Type inference failed for: r0v58 */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r0v62 */
    /* JADX WARN: Type inference failed for: r0v64 */
    /* JADX WARN: Type inference failed for: r0v65 */
    /* JADX WARN: Type inference failed for: r0v66 */
    /* JADX WARN: Type inference failed for: r0v67 */
    /* JADX WARN: Type inference failed for: r0v69 */
    /* JADX WARN: Type inference failed for: r0v74 */
    /* JADX WARN: Type inference failed for: r0v75 */
    /* JADX WARN: Type inference failed for: r0v76 */
    /* JADX WARN: Type inference failed for: r0v77 */
    /* JADX WARN: Type inference failed for: r0v78 */
    /* JADX WARN: Type inference failed for: r0v79 */
    /* JADX WARN: Type inference failed for: r0v80 */
    /* JADX WARN: Type inference failed for: r0v81 */
    /* JADX WARN: Type inference failed for: r0v82 */
    /* JADX WARN: Type inference failed for: r0v83 */
    /* JADX WARN: Type inference failed for: r0v84 */
    /* JADX WARN: Type inference failed for: r0v85 */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v44, types: [int] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Channel channel = this.channel;
        int iA = (b.a(this.channelId) + ((channel != null ? channel.hashCode() : 0) * 31)) * 31;
        MeUser meUser = this.me;
        int iHashCode = (iA + (meUser != null ? meUser.hashCode() : 0)) * 31;
        GuildMember guildMember = this.meGuildMember;
        int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        StoreChat$EditingMessage storeChat$EditingMessage = this.editingMessage;
        int iHashCode3 = (iHashCode2 + (storeChat$EditingMessage != null ? storeChat$EditingMessage.hashCode() : 0)) * 31;
        boolean z2 = this.ableToSendMessage;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iHashCode3 + r0) * 31;
        GuildVerificationLevel guildVerificationLevel = this.verificationLevelTriggered;
        int iHashCode4 = (i + (guildVerificationLevel != null ? guildVerificationLevel.hashCode() : 0)) * 31;
        boolean z3 = this.isLurking;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i2 = (iHashCode4 + r1) * 31;
        boolean z4 = this.isSystemDM;
        ?? r2 = z4;
        if (z4) {
            r2 = 1;
        }
        int i3 = (i2 + r2) * 31;
        boolean z5 = this.isOnCooldown;
        ?? r3 = z5;
        if (z5) {
            r3 = 1;
        }
        int i4 = (((i3 + r3) * 31) + this.maxFileSizeMB) * 31;
        boolean z6 = this.shouldShowFollow;
        ?? r4 = z6;
        if (z6) {
            r4 = 1;
        }
        int i5 = (i4 + r4) * 31;
        ChatInputViewModel$ViewState$Loaded$PendingReplyState chatInputViewModel$ViewState$Loaded$PendingReplyState = this.pendingReplyState;
        int iHashCode5 = (i5 + (chatInputViewModel$ViewState$Loaded$PendingReplyState != null ? chatInputViewModel$ViewState$Loaded$PendingReplyState.hashCode() : 0)) * 31;
        boolean z7 = this.shouldBadgeChatInput;
        ?? r5 = z7;
        if (z7) {
            r5 = 1;
        }
        int i6 = (iHashCode5 + r5) * 31;
        boolean z8 = this.isBlocked;
        ?? r6 = z8;
        if (z8) {
            r6 = 1;
        }
        int i7 = (i6 + r6) * 31;
        boolean z9 = this.isInputShowing;
        ?? r7 = z9;
        if (z9) {
            r7 = 1;
        }
        int i8 = (i7 + r7) * 31;
        boolean z10 = this.isVerificationLevelTriggered;
        ?? r8 = z10;
        if (z10) {
            r8 = 1;
        }
        int i9 = (i8 + r8) * 31;
        boolean z11 = this.isEditing;
        ?? r9 = z11;
        if (z11) {
            r9 = 1;
        }
        int i10 = (i9 + r9) * 31;
        boolean z12 = this.isReplying;
        ?? r10 = z12;
        if (z12) {
            r10 = 1;
        }
        int i11 = (i10 + r10) * 31;
        boolean z13 = this.isCommunicationDisabled;
        ?? r11 = z13;
        if (z13) {
            r11 = 1;
        }
        int iA2 = (b.a(this.timeoutLeftMs) + ((i11 + r11) * 31)) * 31;
        StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft = this.selectedThreadDraft;
        int iHashCode6 = (iA2 + (storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft != null ? storeChannelsSelected$ResolvedSelectedChannel$ThreadDraft.hashCode() : 0)) * 31;
        boolean z14 = this.shouldShowVerificationGate;
        ?? r12 = z14;
        if (z14) {
            r12 = 1;
        }
        int i12 = (iHashCode6 + r12) * 31;
        ApplicationStatus applicationStatus = this.joinRequestStatus;
        int iHashCode7 = (i12 + (applicationStatus != null ? applicationStatus.hashCode() : 0)) * 31;
        StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState = this.threadDraftState;
        int iHashCode8 = (iHashCode7 + (storeThreadDraft$ThreadDraftState != null ? storeThreadDraft$ThreadDraftState.hashCode() : 0)) * 31;
        boolean z15 = this.showCreateThreadOption;
        return iHashCode8 + (z15 ? 1 : z15);
    }

    public final boolean isBlocked() {
        return this.isBlocked;
    }

    public final boolean isCommunicationDisabled() {
        return this.isCommunicationDisabled;
    }

    public final boolean isEditing() {
        return this.isEditing;
    }

    public final boolean isInputShowing() {
        return this.isInputShowing;
    }

    public final boolean isLurking() {
        return this.isLurking;
    }

    public final boolean isOnCooldown() {
        return this.isOnCooldown;
    }

    public final boolean isReplying() {
        return this.isReplying;
    }

    public final boolean isSystemDM() {
        return this.isSystemDM;
    }

    public final boolean isVerificationLevelTriggered() {
        return this.isVerificationLevelTriggered;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(channel=");
        sbU.append(this.channel);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", me=");
        sbU.append(this.me);
        sbU.append(", meGuildMember=");
        sbU.append(this.meGuildMember);
        sbU.append(", editingMessage=");
        sbU.append(this.editingMessage);
        sbU.append(", ableToSendMessage=");
        sbU.append(this.ableToSendMessage);
        sbU.append(", verificationLevelTriggered=");
        sbU.append(this.verificationLevelTriggered);
        sbU.append(", isLurking=");
        sbU.append(this.isLurking);
        sbU.append(", isSystemDM=");
        sbU.append(this.isSystemDM);
        sbU.append(", isOnCooldown=");
        sbU.append(this.isOnCooldown);
        sbU.append(", maxFileSizeMB=");
        sbU.append(this.maxFileSizeMB);
        sbU.append(", shouldShowFollow=");
        sbU.append(this.shouldShowFollow);
        sbU.append(", pendingReplyState=");
        sbU.append(this.pendingReplyState);
        sbU.append(", shouldBadgeChatInput=");
        sbU.append(this.shouldBadgeChatInput);
        sbU.append(", isBlocked=");
        sbU.append(this.isBlocked);
        sbU.append(", isInputShowing=");
        sbU.append(this.isInputShowing);
        sbU.append(", isVerificationLevelTriggered=");
        sbU.append(this.isVerificationLevelTriggered);
        sbU.append(", isEditing=");
        sbU.append(this.isEditing);
        sbU.append(", isReplying=");
        sbU.append(this.isReplying);
        sbU.append(", isCommunicationDisabled=");
        sbU.append(this.isCommunicationDisabled);
        sbU.append(", timeoutLeftMs=");
        sbU.append(this.timeoutLeftMs);
        sbU.append(", selectedThreadDraft=");
        sbU.append(this.selectedThreadDraft);
        sbU.append(", shouldShowVerificationGate=");
        sbU.append(this.shouldShowVerificationGate);
        sbU.append(", joinRequestStatus=");
        sbU.append(this.joinRequestStatus);
        sbU.append(", threadDraftState=");
        sbU.append(this.threadDraftState);
        sbU.append(", showCreateThreadOption=");
        return a.O(sbU, this.showCreateThreadOption, ")");
    }
}
