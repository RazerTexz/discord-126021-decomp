package com.discord.widgets.chat.list.entries;

import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageState$State;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MessageEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MessageEntry extends ChatListEntry {
    private final boolean animateEmojis;
    private final GuildMember author;
    private final MessageEntry$CtaData ctaData;
    private final GuildMember firstMentionedUser;
    private final GuildMember interactionAuthor;
    private final boolean isExpandedBlocked;
    private final boolean isGuildForumPostAuthor;
    private final boolean isGuildForumPostFirstMessage;
    private final boolean isMinimal;
    private final boolean isThreadStarterMessage;
    private final String key;
    private final Message message;
    private final StoreMessageState$State messageState;
    private final Map<Long, String> nickOrUsernames;
    private final Long permissionsForChannel;
    private final MessageEntry$ReplyData replyData;
    private final Map<Long, GuildRole> roles;
    private final int type;

    public /* synthetic */ MessageEntry(Message message, StoreMessageState$State storeMessageState$State, GuildMember guildMember, GuildMember guildMember2, Map map, Map map2, boolean z2, boolean z3, boolean z4, MessageEntry$ReplyData messageEntry$ReplyData, GuildMember guildMember3, boolean z5, boolean z6, boolean z7, MessageEntry$CtaData messageEntry$CtaData, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(message, storeMessageState$State, guildMember, (i & 8) != 0 ? null : guildMember2, map, map2, (i & 64) != 0 ? false : z2, z3, (i & 256) != 0 ? true : z4, (i & 512) != 0 ? null : messageEntry$ReplyData, (i & 1024) != 0 ? null : guildMember3, (i & 2048) != 0 ? false : z5, (i & 4096) != 0 ? false : z6, (i & 8192) != 0 ? false : z7, (i & 16384) != 0 ? null : messageEntry$CtaData, l);
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    private final boolean getIsMinimal() {
        return this.isMinimal;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    private final boolean getIsExpandedBlocked() {
        return this.isExpandedBlocked;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageEntry copy$default(MessageEntry messageEntry, Message message, StoreMessageState$State storeMessageState$State, GuildMember guildMember, GuildMember guildMember2, Map map, Map map2, boolean z2, boolean z3, boolean z4, MessageEntry$ReplyData messageEntry$ReplyData, GuildMember guildMember3, boolean z5, boolean z6, boolean z7, MessageEntry$CtaData messageEntry$CtaData, Long l, int i, Object obj) {
        return messageEntry.copy((i & 1) != 0 ? messageEntry.message : message, (i & 2) != 0 ? messageEntry.messageState : storeMessageState$State, (i & 4) != 0 ? messageEntry.author : guildMember, (i & 8) != 0 ? messageEntry.firstMentionedUser : guildMember2, (i & 16) != 0 ? messageEntry.roles : map, (i & 32) != 0 ? messageEntry.nickOrUsernames : map2, (i & 64) != 0 ? messageEntry.isMinimal : z2, (i & 128) != 0 ? messageEntry.isExpandedBlocked : z3, (i & 256) != 0 ? messageEntry.animateEmojis : z4, (i & 512) != 0 ? messageEntry.replyData : messageEntry$ReplyData, (i & 1024) != 0 ? messageEntry.interactionAuthor : guildMember3, (i & 2048) != 0 ? messageEntry.isThreadStarterMessage : z5, (i & 4096) != 0 ? messageEntry.isGuildForumPostFirstMessage : z6, (i & 8192) != 0 ? messageEntry.isGuildForumPostAuthor : z7, (i & 16384) != 0 ? messageEntry.ctaData : messageEntry$CtaData, (i & 32768) != 0 ? messageEntry.permissionsForChannel : l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final MessageEntry$ReplyData getReplyData() {
        return this.replyData;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final GuildMember getInteractionAuthor() {
        return this.interactionAuthor;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsThreadStarterMessage() {
        return this.isThreadStarterMessage;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getIsGuildForumPostFirstMessage() {
        return this.isGuildForumPostFirstMessage;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getIsGuildForumPostAuthor() {
        return this.isGuildForumPostAuthor;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final MessageEntry$CtaData getCtaData() {
        return this.ctaData;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Long getPermissionsForChannel() {
        return this.permissionsForChannel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreMessageState$State getMessageState() {
        return this.messageState;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildMember getAuthor() {
        return this.author;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GuildMember getFirstMentionedUser() {
        return this.firstMentionedUser;
    }

    public final Map<Long, GuildRole> component5() {
        return this.roles;
    }

    public final Map<Long, String> component6() {
        return this.nickOrUsernames;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    public final MessageEntry copy(Message message, StoreMessageState$State messageState, GuildMember author, GuildMember firstMentionedUser, Map<Long, GuildRole> roles, Map<Long, String> nickOrUsernames, boolean isMinimal, boolean isExpandedBlocked, boolean animateEmojis, MessageEntry$ReplyData replyData, GuildMember interactionAuthor, boolean isThreadStarterMessage, boolean isGuildForumPostFirstMessage, boolean isGuildForumPostAuthor, MessageEntry$CtaData ctaData, Long permissionsForChannel) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(nickOrUsernames, "nickOrUsernames");
        return new MessageEntry(message, messageState, author, firstMentionedUser, roles, nickOrUsernames, isMinimal, isExpandedBlocked, animateEmojis, replyData, interactionAuthor, isThreadStarterMessage, isGuildForumPostFirstMessage, isGuildForumPostAuthor, ctaData, permissionsForChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageEntry)) {
            return false;
        }
        MessageEntry messageEntry = (MessageEntry) other;
        return m.areEqual(this.message, messageEntry.message) && m.areEqual(this.messageState, messageEntry.messageState) && m.areEqual(this.author, messageEntry.author) && m.areEqual(this.firstMentionedUser, messageEntry.firstMentionedUser) && m.areEqual(this.roles, messageEntry.roles) && m.areEqual(this.nickOrUsernames, messageEntry.nickOrUsernames) && this.isMinimal == messageEntry.isMinimal && this.isExpandedBlocked == messageEntry.isExpandedBlocked && this.animateEmojis == messageEntry.animateEmojis && m.areEqual(this.replyData, messageEntry.replyData) && m.areEqual(this.interactionAuthor, messageEntry.interactionAuthor) && this.isThreadStarterMessage == messageEntry.isThreadStarterMessage && this.isGuildForumPostFirstMessage == messageEntry.isGuildForumPostFirstMessage && this.isGuildForumPostAuthor == messageEntry.isGuildForumPostAuthor && m.areEqual(this.ctaData, messageEntry.ctaData) && m.areEqual(this.permissionsForChannel, messageEntry.permissionsForChannel);
    }

    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    public final GuildMember getAuthor() {
        return this.author;
    }

    public final MessageEntry$CtaData getCtaData() {
        return this.ctaData;
    }

    public final GuildMember getFirstMentionedUser() {
        return this.firstMentionedUser;
    }

    public final GuildMember getInteractionAuthor() {
        return this.interactionAuthor;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final StoreMessageState$State getMessageState() {
        return this.messageState;
    }

    public final Map<Long, String> getNickOrUsernames() {
        return this.nickOrUsernames;
    }

    public final Long getPermissionsForChannel() {
        return this.permissionsForChannel;
    }

    public final MessageEntry$ReplyData getReplyData() {
        return this.replyData;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Message message = this.message;
        int iHashCode = (message != null ? message.hashCode() : 0) * 31;
        StoreMessageState$State storeMessageState$State = this.messageState;
        int iHashCode2 = (iHashCode + (storeMessageState$State != null ? storeMessageState$State.hashCode() : 0)) * 31;
        GuildMember guildMember = this.author;
        int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        GuildMember guildMember2 = this.firstMentionedUser;
        int iHashCode4 = (iHashCode3 + (guildMember2 != null ? guildMember2.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map = this.roles;
        int iHashCode5 = (iHashCode4 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, String> map2 = this.nickOrUsernames;
        int iHashCode6 = (iHashCode5 + (map2 != null ? map2.hashCode() : 0)) * 31;
        boolean z2 = this.isMinimal;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode6 + r2) * 31;
        boolean z3 = this.isExpandedBlocked;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        boolean z4 = this.animateEmojis;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i3 = (i2 + r4) * 31;
        MessageEntry$ReplyData messageEntry$ReplyData = this.replyData;
        int iHashCode7 = (i3 + (messageEntry$ReplyData != null ? messageEntry$ReplyData.hashCode() : 0)) * 31;
        GuildMember guildMember3 = this.interactionAuthor;
        int iHashCode8 = (iHashCode7 + (guildMember3 != null ? guildMember3.hashCode() : 0)) * 31;
        boolean z5 = this.isThreadStarterMessage;
        ?? r5 = z5;
        if (z5) {
            r5 = 1;
        }
        int i4 = (iHashCode8 + r5) * 31;
        boolean z6 = this.isGuildForumPostFirstMessage;
        ?? r6 = z6;
        if (z6) {
            r6 = 1;
        }
        int i5 = (i4 + r6) * 31;
        boolean z7 = this.isGuildForumPostAuthor;
        int i6 = (i5 + (z7 ? 1 : z7)) * 31;
        MessageEntry$CtaData messageEntry$CtaData = this.ctaData;
        int iHashCode9 = (i6 + (messageEntry$CtaData != null ? messageEntry$CtaData.hashCode() : 0)) * 31;
        Long l = this.permissionsForChannel;
        return iHashCode9 + (l != null ? l.hashCode() : 0);
    }

    public final boolean isGuildForumPostAuthor() {
        return this.isGuildForumPostAuthor;
    }

    public final boolean isGuildForumPostFirstMessage() {
        return this.isGuildForumPostFirstMessage;
    }

    @Override // com.discord.widgets.chat.list.entries.ChatListEntry
    public boolean isInExpandedBlockedMessageChunk() {
        return this.isExpandedBlocked;
    }

    public final boolean isThreadStarterMessage() {
        return this.isThreadStarterMessage;
    }

    public String toString() {
        StringBuilder sbU = a.U("MessageEntry(message=");
        sbU.append(this.message);
        sbU.append(", messageState=");
        sbU.append(this.messageState);
        sbU.append(", author=");
        sbU.append(this.author);
        sbU.append(", firstMentionedUser=");
        sbU.append(this.firstMentionedUser);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", nickOrUsernames=");
        sbU.append(this.nickOrUsernames);
        sbU.append(", isMinimal=");
        sbU.append(this.isMinimal);
        sbU.append(", isExpandedBlocked=");
        sbU.append(this.isExpandedBlocked);
        sbU.append(", animateEmojis=");
        sbU.append(this.animateEmojis);
        sbU.append(", replyData=");
        sbU.append(this.replyData);
        sbU.append(", interactionAuthor=");
        sbU.append(this.interactionAuthor);
        sbU.append(", isThreadStarterMessage=");
        sbU.append(this.isThreadStarterMessage);
        sbU.append(", isGuildForumPostFirstMessage=");
        sbU.append(this.isGuildForumPostFirstMessage);
        sbU.append(", isGuildForumPostAuthor=");
        sbU.append(this.isGuildForumPostAuthor);
        sbU.append(", ctaData=");
        sbU.append(this.ctaData);
        sbU.append(", permissionsForChannel=");
        return a.G(sbU, this.permissionsForChannel, ")");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0059  */
    public MessageEntry(Message message, StoreMessageState$State storeMessageState$State, GuildMember guildMember, GuildMember guildMember2, Map<Long, GuildRole> map, Map<Long, String> map2, boolean z2, boolean z3, boolean z4, MessageEntry$ReplyData messageEntry$ReplyData, GuildMember guildMember3, boolean z5, boolean z6, boolean z7, MessageEntry$CtaData messageEntry$CtaData, Long l) {
        Integer type;
        Integer type2;
        Integer type3;
        Integer type4;
        Integer type5;
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(map2, "nickOrUsernames");
        this.message = message;
        this.messageState = storeMessageState$State;
        this.author = guildMember;
        this.firstMentionedUser = guildMember2;
        this.roles = map;
        this.nickOrUsernames = map2;
        this.isMinimal = z2;
        this.isExpandedBlocked = z3;
        this.animateEmojis = z4;
        this.replyData = messageEntry$ReplyData;
        this.interactionAuthor = guildMember3;
        this.isThreadStarterMessage = z5;
        this.isGuildForumPostFirstMessage = z6;
        this.isGuildForumPostAuthor = z7;
        this.ctaData = messageEntry$CtaData;
        this.permissionsForChannel = l;
        int i = 19;
        if (z2) {
            i = 1;
        } else if (!message.isInteraction() && (((type = message.getType()) == null || type.intValue() != 0) && ((type2 = message.getType()) == null || type2.intValue() != -1))) {
            Integer type6 = message.getType();
            if (((type6 != null && type6.intValue() == 20) || ((type3 = message.getType()) != null && type3.intValue() == 23)) && message.getInteraction() == null) {
                i = 33;
            } else {
                Integer type7 = message.getType();
                if ((type7 == null || type7.intValue() != 3) && ((type4 = message.getType()) == null || type4.intValue() != 13)) {
                    Integer type8 = message.getType();
                    if ((type8 != null && type8.intValue() == -2) || ((type5 = message.getType()) != null && type5.intValue() == -3)) {
                        i = 20;
                    } else {
                        Integer type9 = message.getType();
                        if (type9 != null && type9.intValue() == -6) {
                            i = 0;
                        } else {
                            Integer type10 = message.getType();
                            if (type10 != null && type10.intValue() == 19) {
                                i = 32;
                            } else {
                                Integer type11 = message.getType();
                                if (type11 != null && type11.intValue() == 22) {
                                    i = 38;
                                } else {
                                    Integer type12 = message.getType();
                                    i = (type12 != null && type12.intValue() == -8) ? 44 : 5;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            i = 0;
        }
        this.type = i;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(' ');
        Object nonce = message.getNonce();
        sb.append(nonce == null ? Long.valueOf(message.getId()) : nonce);
        this.key = sb.toString();
    }
}
