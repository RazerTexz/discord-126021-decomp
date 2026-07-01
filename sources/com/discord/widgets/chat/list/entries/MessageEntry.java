package com.discord.widgets.chat.list.entries;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.api.sticker.BaseSticker;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageReplies;
import com.discord.stores.StoreMessageState;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MessageEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MessageEntry extends ChatListEntry {
    private final boolean animateEmojis;
    private final GuildMember author;
    private final CtaData ctaData;
    private final GuildMember firstMentionedUser;
    private final GuildMember interactionAuthor;
    private final boolean isExpandedBlocked;
    private final boolean isGuildForumPostAuthor;
    private final boolean isGuildForumPostFirstMessage;
    private final boolean isMinimal;
    private final boolean isThreadStarterMessage;
    private final String key;
    private final Message message;
    private final StoreMessageState.State messageState;
    private final Map<Long, String> nickOrUsernames;
    private final Long permissionsForChannel;
    private final ReplyData replyData;
    private final Map<Long, GuildRole> roles;
    private final int type;

    /* JADX INFO: compiled from: MessageEntry.kt */
    public static final /* data */ class CtaData {
        private final Channel channel;
        private final BaseSticker sticker;

        public CtaData(BaseSticker baseSticker, Channel channel) {
            Intrinsics3.checkNotNullParameter(baseSticker, "sticker");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.sticker = baseSticker;
            this.channel = channel;
        }

        public static /* synthetic */ CtaData copy$default(CtaData ctaData, BaseSticker baseSticker, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                baseSticker = ctaData.sticker;
            }
            if ((i & 2) != 0) {
                channel = ctaData.channel;
            }
            return ctaData.copy(baseSticker, channel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final BaseSticker getSticker() {
            return this.sticker;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final CtaData copy(BaseSticker sticker, Channel channel) {
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new CtaData(sticker, channel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CtaData)) {
                return false;
            }
            CtaData ctaData = (CtaData) other;
            return Intrinsics3.areEqual(this.sticker, ctaData.sticker) && Intrinsics3.areEqual(this.channel, ctaData.channel);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final BaseSticker getSticker() {
            return this.sticker;
        }

        public int hashCode() {
            BaseSticker baseSticker = this.sticker;
            int iHashCode = (baseSticker != null ? baseSticker.hashCode() : 0) * 31;
            Channel channel = this.channel;
            return iHashCode + (channel != null ? channel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("CtaData(sticker=");
            sbU.append(this.sticker);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: MessageEntry.kt */
    public static final /* data */ class ReplyData {
        private final boolean isRepliedUserBlocked;
        private final MessageEntry messageEntry;
        private final StoreMessageReplies.MessageState messageState;

        public ReplyData(StoreMessageReplies.MessageState messageState, MessageEntry messageEntry, boolean z2) {
            Intrinsics3.checkNotNullParameter(messageState, "messageState");
            this.messageState = messageState;
            this.messageEntry = messageEntry;
            this.isRepliedUserBlocked = z2;
        }

        public static /* synthetic */ ReplyData copy$default(ReplyData replyData, StoreMessageReplies.MessageState messageState, MessageEntry messageEntry, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                messageState = replyData.messageState;
            }
            if ((i & 2) != 0) {
                messageEntry = replyData.messageEntry;
            }
            if ((i & 4) != 0) {
                z2 = replyData.isRepliedUserBlocked;
            }
            return replyData.copy(messageState, messageEntry, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreMessageReplies.MessageState getMessageState() {
            return this.messageState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final MessageEntry getMessageEntry() {
            return this.messageEntry;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsRepliedUserBlocked() {
            return this.isRepliedUserBlocked;
        }

        public final ReplyData copy(StoreMessageReplies.MessageState messageState, MessageEntry messageEntry, boolean isRepliedUserBlocked) {
            Intrinsics3.checkNotNullParameter(messageState, "messageState");
            return new ReplyData(messageState, messageEntry, isRepliedUserBlocked);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplyData)) {
                return false;
            }
            ReplyData replyData = (ReplyData) other;
            return Intrinsics3.areEqual(this.messageState, replyData.messageState) && Intrinsics3.areEqual(this.messageEntry, replyData.messageEntry) && this.isRepliedUserBlocked == replyData.isRepliedUserBlocked;
        }

        public final MessageEntry getMessageEntry() {
            return this.messageEntry;
        }

        public final StoreMessageReplies.MessageState getMessageState() {
            return this.messageState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            StoreMessageReplies.MessageState messageState = this.messageState;
            int iHashCode = (messageState != null ? messageState.hashCode() : 0) * 31;
            MessageEntry messageEntry = this.messageEntry;
            int iHashCode2 = (iHashCode + (messageEntry != null ? messageEntry.hashCode() : 0)) * 31;
            boolean z2 = this.isRepliedUserBlocked;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public final boolean isRepliedUserBlocked() {
            return this.isRepliedUserBlocked;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ReplyData(messageState=");
            sbU.append(this.messageState);
            sbU.append(", messageEntry=");
            sbU.append(this.messageEntry);
            sbU.append(", isRepliedUserBlocked=");
            return outline.O(sbU, this.isRepliedUserBlocked, ")");
        }

        public /* synthetic */ ReplyData(StoreMessageReplies.MessageState messageState, MessageEntry messageEntry, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(messageState, messageEntry, (i & 4) != 0 ? false : z2);
        }
    }

    public /* synthetic */ MessageEntry(Message message, StoreMessageState.State state, GuildMember guildMember, GuildMember guildMember2, Map map, Map map2, boolean z2, boolean z3, boolean z4, ReplyData replyData, GuildMember guildMember3, boolean z5, boolean z6, boolean z7, CtaData ctaData, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(message, state, guildMember, (i & 8) != 0 ? null : guildMember2, map, map2, (i & 64) != 0 ? false : z2, z3, (i & 256) != 0 ? true : z4, (i & 512) != 0 ? null : replyData, (i & 1024) != 0 ? null : guildMember3, (i & 2048) != 0 ? false : z5, (i & 4096) != 0 ? false : z6, (i & 8192) != 0 ? false : z7, (i & 16384) != 0 ? null : ctaData, l);
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    private final boolean getIsMinimal() {
        return this.isMinimal;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    private final boolean getIsExpandedBlocked() {
        return this.isExpandedBlocked;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final ReplyData getReplyData() {
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
    public final CtaData getCtaData() {
        return this.ctaData;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Long getPermissionsForChannel() {
        return this.permissionsForChannel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreMessageState.State getMessageState() {
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

    public final MessageEntry copy(Message message, StoreMessageState.State messageState, GuildMember author, GuildMember firstMentionedUser, Map<Long, GuildRole> roles, Map<Long, String> nickOrUsernames, boolean isMinimal, boolean isExpandedBlocked, boolean animateEmojis, ReplyData replyData, GuildMember interactionAuthor, boolean isThreadStarterMessage, boolean isGuildForumPostFirstMessage, boolean isGuildForumPostAuthor, CtaData ctaData, Long permissionsForChannel) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(nickOrUsernames, "nickOrUsernames");
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
        return Intrinsics3.areEqual(this.message, messageEntry.message) && Intrinsics3.areEqual(this.messageState, messageEntry.messageState) && Intrinsics3.areEqual(this.author, messageEntry.author) && Intrinsics3.areEqual(this.firstMentionedUser, messageEntry.firstMentionedUser) && Intrinsics3.areEqual(this.roles, messageEntry.roles) && Intrinsics3.areEqual(this.nickOrUsernames, messageEntry.nickOrUsernames) && this.isMinimal == messageEntry.isMinimal && this.isExpandedBlocked == messageEntry.isExpandedBlocked && this.animateEmojis == messageEntry.animateEmojis && Intrinsics3.areEqual(this.replyData, messageEntry.replyData) && Intrinsics3.areEqual(this.interactionAuthor, messageEntry.interactionAuthor) && this.isThreadStarterMessage == messageEntry.isThreadStarterMessage && this.isGuildForumPostFirstMessage == messageEntry.isGuildForumPostFirstMessage && this.isGuildForumPostAuthor == messageEntry.isGuildForumPostAuthor && Intrinsics3.areEqual(this.ctaData, messageEntry.ctaData) && Intrinsics3.areEqual(this.permissionsForChannel, messageEntry.permissionsForChannel);
    }

    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    public final GuildMember getAuthor() {
        return this.author;
    }

    public final CtaData getCtaData() {
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

    public final StoreMessageState.State getMessageState() {
        return this.messageState;
    }

    public final Map<Long, String> getNickOrUsernames() {
        return this.nickOrUsernames;
    }

    public final Long getPermissionsForChannel() {
        return this.permissionsForChannel;
    }

    public final ReplyData getReplyData() {
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
        StoreMessageState.State state = this.messageState;
        int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
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
        ReplyData replyData = this.replyData;
        int iHashCode7 = (i3 + (replyData != null ? replyData.hashCode() : 0)) * 31;
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
        CtaData ctaData = this.ctaData;
        int iHashCode9 = (i6 + (ctaData != null ? ctaData.hashCode() : 0)) * 31;
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
        StringBuilder sbU = outline.U("MessageEntry(message=");
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
        return outline.G(sbU, this.permissionsForChannel, ")");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0059  */
    public MessageEntry(Message message, StoreMessageState.State state, GuildMember guildMember, GuildMember guildMember2, Map<Long, GuildRole> map, Map<Long, String> map2, boolean z2, boolean z3, boolean z4, ReplyData replyData, GuildMember guildMember3, boolean z5, boolean z6, boolean z7, CtaData ctaData, Long l) {
        Integer type;
        Integer type2;
        Integer type3;
        Integer type4;
        Integer type5;
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(map2, "nickOrUsernames");
        this.message = message;
        this.messageState = state;
        this.author = guildMember;
        this.firstMentionedUser = guildMember2;
        this.roles = map;
        this.nickOrUsernames = map2;
        this.isMinimal = z2;
        this.isExpandedBlocked = z3;
        this.animateEmojis = z4;
        this.replyData = replyData;
        this.interactionAuthor = guildMember3;
        this.isThreadStarterMessage = z5;
        this.isGuildForumPostFirstMessage = z6;
        this.isGuildForumPostAuthor = z7;
        this.ctaData = ctaData;
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
