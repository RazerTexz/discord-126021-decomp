package com.discord.widgets.chat.list.entries;

import com.discord.api.message.embed.MessageEmbed;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageState;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: EmbedEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmbedEntry extends ChatListEntry {
    private final boolean allowAnimatedEmojis;
    private final boolean autoPlayGifs;
    private final MessageEmbed embed;
    private final int embedIndex;
    private final long guildId;
    private final boolean isBlockedExpanded;
    private final boolean isThreadStarterMessage;
    private final String key;
    private final Message message;
    private final StoreMessageState.State messageState;
    private final int type;

    public EmbedEntry(int i, long j, Message message, StoreMessageState.State state, MessageEmbed messageEmbed, boolean z2, boolean z3, boolean z4, boolean z5) {
        C12238m.checkNotNullParameter(message, "message");
        C12238m.checkNotNullParameter(messageEmbed, "embed");
        this.embedIndex = i;
        this.guildId = j;
        this.message = message;
        this.messageState = state;
        this.embed = messageEmbed;
        this.isBlockedExpanded = z2;
        this.allowAnimatedEmojis = z3;
        this.autoPlayGifs = z4;
        this.isThreadStarterMessage = z5;
        this.type = 21;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(message.getId());
        this.key = sb.toString();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getEmbedIndex() {
        return this.embedIndex;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StoreMessageState.State getMessageState() {
        return this.messageState;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MessageEmbed getEmbed() {
        return this.embed;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsBlockedExpanded() {
        return this.isBlockedExpanded;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getAutoPlayGifs() {
        return this.autoPlayGifs;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsThreadStarterMessage() {
        return this.isThreadStarterMessage;
    }

    public final EmbedEntry copy(int embedIndex, long guildId, Message message, StoreMessageState.State messageState, MessageEmbed embed, boolean isBlockedExpanded, boolean allowAnimatedEmojis, boolean autoPlayGifs, boolean isThreadStarterMessage) {
        C12238m.checkNotNullParameter(message, "message");
        C12238m.checkNotNullParameter(embed, "embed");
        return new EmbedEntry(embedIndex, guildId, message, messageState, embed, isBlockedExpanded, allowAnimatedEmojis, autoPlayGifs, isThreadStarterMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbedEntry)) {
            return false;
        }
        EmbedEntry embedEntry = (EmbedEntry) other;
        return this.embedIndex == embedEntry.embedIndex && this.guildId == embedEntry.guildId && C12238m.areEqual(this.message, embedEntry.message) && C12238m.areEqual(this.messageState, embedEntry.messageState) && C12238m.areEqual(this.embed, embedEntry.embed) && this.isBlockedExpanded == embedEntry.isBlockedExpanded && this.allowAnimatedEmojis == embedEntry.allowAnimatedEmojis && this.autoPlayGifs == embedEntry.autoPlayGifs && this.isThreadStarterMessage == embedEntry.isThreadStarterMessage;
    }

    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    public final boolean getAutoPlayGifs() {
        return this.autoPlayGifs;
    }

    public final MessageEmbed getEmbed() {
        return this.embed;
    }

    public final int getEmbedIndex() {
        return this.embedIndex;
    }

    public final long getGuildId() {
        return this.guildId;
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

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int iM3a = (C0002b.m3a(this.guildId) + (this.embedIndex * 31)) * 31;
        Message message = this.message;
        int iHashCode = (iM3a + (message != null ? message.hashCode() : 0)) * 31;
        StoreMessageState.State state = this.messageState;
        int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
        MessageEmbed messageEmbed = this.embed;
        int iHashCode3 = (iHashCode2 + (messageEmbed != null ? messageEmbed.hashCode() : 0)) * 31;
        boolean z2 = this.isBlockedExpanded;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iHashCode3 + r0) * 31;
        boolean z3 = this.allowAnimatedEmojis;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i2 = (i + r1) * 31;
        boolean z4 = this.autoPlayGifs;
        ?? r2 = z4;
        if (z4) {
            r2 = 1;
        }
        int i3 = (i2 + r2) * 31;
        boolean z5 = this.isThreadStarterMessage;
        return i3 + (z5 ? 1 : z5);
    }

    public final boolean isBlockedExpanded() {
        return this.isBlockedExpanded;
    }

    @Override // com.discord.widgets.chat.list.entries.ChatListEntry
    public boolean isInExpandedBlockedMessageChunk() {
        return this.isBlockedExpanded;
    }

    public final boolean isThreadStarterMessage() {
        return this.isThreadStarterMessage;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EmbedEntry(embedIndex=");
        sbM833U.append(this.embedIndex);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", message=");
        sbM833U.append(this.message);
        sbM833U.append(", messageState=");
        sbM833U.append(this.messageState);
        sbM833U.append(", embed=");
        sbM833U.append(this.embed);
        sbM833U.append(", isBlockedExpanded=");
        sbM833U.append(this.isBlockedExpanded);
        sbM833U.append(", allowAnimatedEmojis=");
        sbM833U.append(this.allowAnimatedEmojis);
        sbM833U.append(", autoPlayGifs=");
        sbM833U.append(this.autoPlayGifs);
        sbM833U.append(", isThreadStarterMessage=");
        return C1643a.m827O(sbM833U, this.isThreadStarterMessage, ")");
    }
}
