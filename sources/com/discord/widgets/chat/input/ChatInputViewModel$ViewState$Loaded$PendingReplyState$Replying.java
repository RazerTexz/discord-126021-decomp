package com.discord.widgets.chat.input;

import b.d.b.a.a;
import com.discord.api.message.MessageReference;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying extends ChatInputViewModel$ViewState$Loaded$PendingReplyState {
    private final MessageReference messageReference;
    private final User repliedAuthor;
    private final GuildMember repliedAuthorGuildMember;
    private final boolean shouldMention;
    private final boolean showMentionToggle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying(MessageReference messageReference, boolean z2, boolean z3, User user, GuildMember guildMember) {
        super(null);
        m.checkNotNullParameter(messageReference, "messageReference");
        m.checkNotNullParameter(user, "repliedAuthor");
        this.messageReference = messageReference;
        this.shouldMention = z2;
        this.showMentionToggle = z3;
        this.repliedAuthor = user;
        this.repliedAuthorGuildMember = guildMember;
    }

    public static /* synthetic */ ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying copy$default(ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying, MessageReference messageReference, boolean z2, boolean z3, User user, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            messageReference = chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying.messageReference;
        }
        if ((i & 2) != 0) {
            z2 = chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying.shouldMention;
        }
        boolean z4 = z2;
        if ((i & 4) != 0) {
            z3 = chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying.showMentionToggle;
        }
        boolean z5 = z3;
        if ((i & 8) != 0) {
            user = chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying.repliedAuthor;
        }
        User user2 = user;
        if ((i & 16) != 0) {
            guildMember = chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying.repliedAuthorGuildMember;
        }
        return chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying.copy(messageReference, z4, z5, user2, guildMember);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MessageReference getMessageReference() {
        return this.messageReference;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShouldMention() {
        return this.shouldMention;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowMentionToggle() {
        return this.showMentionToggle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final User getRepliedAuthor() {
        return this.repliedAuthor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final GuildMember getRepliedAuthorGuildMember() {
        return this.repliedAuthorGuildMember;
    }

    public final ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying copy(MessageReference messageReference, boolean shouldMention, boolean showMentionToggle, User repliedAuthor, GuildMember repliedAuthorGuildMember) {
        m.checkNotNullParameter(messageReference, "messageReference");
        m.checkNotNullParameter(repliedAuthor, "repliedAuthor");
        return new ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying(messageReference, shouldMention, showMentionToggle, repliedAuthor, repliedAuthorGuildMember);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying)) {
            return false;
        }
        ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying = (ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying) other;
        return m.areEqual(this.messageReference, chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying.messageReference) && this.shouldMention == chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying.shouldMention && this.showMentionToggle == chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying.showMentionToggle && m.areEqual(this.repliedAuthor, chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying.repliedAuthor) && m.areEqual(this.repliedAuthorGuildMember, chatInputViewModel$ViewState$Loaded$PendingReplyState$Replying.repliedAuthorGuildMember);
    }

    public final MessageReference getMessageReference() {
        return this.messageReference;
    }

    public final User getRepliedAuthor() {
        return this.repliedAuthor;
    }

    public final GuildMember getRepliedAuthorGuildMember() {
        return this.repliedAuthorGuildMember;
    }

    public final boolean getShouldMention() {
        return this.shouldMention;
    }

    public final boolean getShowMentionToggle() {
        return this.showMentionToggle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        MessageReference messageReference = this.messageReference;
        int iHashCode = (messageReference != null ? messageReference.hashCode() : 0) * 31;
        boolean z2 = this.shouldMention;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z3 = this.showMentionToggle;
        int i2 = (i + (z3 ? 1 : z3)) * 31;
        User user = this.repliedAuthor;
        int iHashCode2 = (i2 + (user != null ? user.hashCode() : 0)) * 31;
        GuildMember guildMember = this.repliedAuthorGuildMember;
        return iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Replying(messageReference=");
        sbU.append(this.messageReference);
        sbU.append(", shouldMention=");
        sbU.append(this.shouldMention);
        sbU.append(", showMentionToggle=");
        sbU.append(this.showMentionToggle);
        sbU.append(", repliedAuthor=");
        sbU.append(this.repliedAuthor);
        sbU.append(", repliedAuthorGuildMember=");
        sbU.append(this.repliedAuthorGuildMember);
        sbU.append(")");
        return sbU.toString();
    }
}
