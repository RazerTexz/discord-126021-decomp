package com.discord.widgets.chat.input;

import b.d.b.a.a;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StorePendingReplies$PendingReply;
import d0.z.d.m;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChatInputViewModel$StoreState$Loaded$PendingReply {
    private final StorePendingReplies$PendingReply pendingReply;
    private final User repliedAuthor;
    private final GuildMember repliedAuthorGuildMember;

    public ChatInputViewModel$StoreState$Loaded$PendingReply(StorePendingReplies$PendingReply storePendingReplies$PendingReply, User user, GuildMember guildMember) {
        m.checkNotNullParameter(storePendingReplies$PendingReply, "pendingReply");
        this.pendingReply = storePendingReplies$PendingReply;
        this.repliedAuthor = user;
        this.repliedAuthorGuildMember = guildMember;
    }

    public static /* synthetic */ ChatInputViewModel$StoreState$Loaded$PendingReply copy$default(ChatInputViewModel$StoreState$Loaded$PendingReply chatInputViewModel$StoreState$Loaded$PendingReply, StorePendingReplies$PendingReply storePendingReplies$PendingReply, User user, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            storePendingReplies$PendingReply = chatInputViewModel$StoreState$Loaded$PendingReply.pendingReply;
        }
        if ((i & 2) != 0) {
            user = chatInputViewModel$StoreState$Loaded$PendingReply.repliedAuthor;
        }
        if ((i & 4) != 0) {
            guildMember = chatInputViewModel$StoreState$Loaded$PendingReply.repliedAuthorGuildMember;
        }
        return chatInputViewModel$StoreState$Loaded$PendingReply.copy(storePendingReplies$PendingReply, user, guildMember);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StorePendingReplies$PendingReply getPendingReply() {
        return this.pendingReply;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final User getRepliedAuthor() {
        return this.repliedAuthor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildMember getRepliedAuthorGuildMember() {
        return this.repliedAuthorGuildMember;
    }

    public final ChatInputViewModel$StoreState$Loaded$PendingReply copy(StorePendingReplies$PendingReply pendingReply, User repliedAuthor, GuildMember repliedAuthorGuildMember) {
        m.checkNotNullParameter(pendingReply, "pendingReply");
        return new ChatInputViewModel$StoreState$Loaded$PendingReply(pendingReply, repliedAuthor, repliedAuthorGuildMember);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatInputViewModel$StoreState$Loaded$PendingReply)) {
            return false;
        }
        ChatInputViewModel$StoreState$Loaded$PendingReply chatInputViewModel$StoreState$Loaded$PendingReply = (ChatInputViewModel$StoreState$Loaded$PendingReply) other;
        return m.areEqual(this.pendingReply, chatInputViewModel$StoreState$Loaded$PendingReply.pendingReply) && m.areEqual(this.repliedAuthor, chatInputViewModel$StoreState$Loaded$PendingReply.repliedAuthor) && m.areEqual(this.repliedAuthorGuildMember, chatInputViewModel$StoreState$Loaded$PendingReply.repliedAuthorGuildMember);
    }

    public final StorePendingReplies$PendingReply getPendingReply() {
        return this.pendingReply;
    }

    public final User getRepliedAuthor() {
        return this.repliedAuthor;
    }

    public final GuildMember getRepliedAuthorGuildMember() {
        return this.repliedAuthorGuildMember;
    }

    public int hashCode() {
        StorePendingReplies$PendingReply storePendingReplies$PendingReply = this.pendingReply;
        int iHashCode = (storePendingReplies$PendingReply != null ? storePendingReplies$PendingReply.hashCode() : 0) * 31;
        User user = this.repliedAuthor;
        int iHashCode2 = (iHashCode + (user != null ? user.hashCode() : 0)) * 31;
        GuildMember guildMember = this.repliedAuthorGuildMember;
        return iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("PendingReply(pendingReply=");
        sbU.append(this.pendingReply);
        sbU.append(", repliedAuthor=");
        sbU.append(this.repliedAuthor);
        sbU.append(", repliedAuthorGuildMember=");
        sbU.append(this.repliedAuthorGuildMember);
        sbU.append(")");
        return sbU.toString();
    }
}
