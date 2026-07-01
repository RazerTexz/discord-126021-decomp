package com.discord.widgets.chat.managereactions;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ManageReactionsResultsAdapter$ReactionUserItem implements MGRecyclerDataPayload {
    private final boolean canDelete;
    private final long channelId;
    private final MessageReactionEmoji emoji;
    private final GuildMember guildMember;
    private final String key;
    private final long messageId;
    private final int type;
    private final User user;

    public ManageReactionsResultsAdapter$ReactionUserItem(User user, long j, long j2, MessageReactionEmoji messageReactionEmoji, boolean z2, GuildMember guildMember) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(messageReactionEmoji, "emoji");
        this.user = user;
        this.channelId = j;
        this.messageId = j2;
        this.emoji = messageReactionEmoji;
        this.canDelete = z2;
        this.guildMember = guildMember;
        this.key = String.valueOf(user.getId());
    }

    public static /* synthetic */ ManageReactionsResultsAdapter$ReactionUserItem copy$default(ManageReactionsResultsAdapter$ReactionUserItem manageReactionsResultsAdapter$ReactionUserItem, User user, long j, long j2, MessageReactionEmoji messageReactionEmoji, boolean z2, GuildMember guildMember, int i, Object obj) {
        return manageReactionsResultsAdapter$ReactionUserItem.copy((i & 1) != 0 ? manageReactionsResultsAdapter$ReactionUserItem.user : user, (i & 2) != 0 ? manageReactionsResultsAdapter$ReactionUserItem.channelId : j, (i & 4) != 0 ? manageReactionsResultsAdapter$ReactionUserItem.messageId : j2, (i & 8) != 0 ? manageReactionsResultsAdapter$ReactionUserItem.emoji : messageReactionEmoji, (i & 16) != 0 ? manageReactionsResultsAdapter$ReactionUserItem.canDelete : z2, (i & 32) != 0 ? manageReactionsResultsAdapter$ReactionUserItem.guildMember : guildMember);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MessageReactionEmoji getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanDelete() {
        return this.canDelete;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final ManageReactionsResultsAdapter$ReactionUserItem copy(User user, long channelId, long messageId, MessageReactionEmoji emoji, boolean canDelete, GuildMember guildMember) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(emoji, "emoji");
        return new ManageReactionsResultsAdapter$ReactionUserItem(user, channelId, messageId, emoji, canDelete, guildMember);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ManageReactionsResultsAdapter$ReactionUserItem)) {
            return false;
        }
        ManageReactionsResultsAdapter$ReactionUserItem manageReactionsResultsAdapter$ReactionUserItem = (ManageReactionsResultsAdapter$ReactionUserItem) other;
        return m.areEqual(this.user, manageReactionsResultsAdapter$ReactionUserItem.user) && this.channelId == manageReactionsResultsAdapter$ReactionUserItem.channelId && this.messageId == manageReactionsResultsAdapter$ReactionUserItem.messageId && m.areEqual(this.emoji, manageReactionsResultsAdapter$ReactionUserItem.emoji) && this.canDelete == manageReactionsResultsAdapter$ReactionUserItem.canDelete && m.areEqual(this.guildMember, manageReactionsResultsAdapter$ReactionUserItem.guildMember);
    }

    public final boolean getCanDelete() {
        return this.canDelete;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final MessageReactionEmoji getEmoji() {
        return this.emoji;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public int hashCode() {
        User user = this.user;
        int iA = (b.a(this.messageId) + ((b.a(this.channelId) + ((user != null ? user.hashCode() : 0) * 31)) * 31)) * 31;
        MessageReactionEmoji messageReactionEmoji = this.emoji;
        int iHashCode = (iA + (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0)) * 31;
        boolean z2 = this.canDelete;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        GuildMember guildMember = this.guildMember;
        return i + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ReactionUserItem(user=");
        sbU.append(this.user);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", emoji=");
        sbU.append(this.emoji);
        sbU.append(", canDelete=");
        sbU.append(this.canDelete);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(")");
        return sbU.toString();
    }
}
