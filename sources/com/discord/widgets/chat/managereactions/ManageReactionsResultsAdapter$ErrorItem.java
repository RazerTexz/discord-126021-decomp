package com.discord.widgets.chat.managereactions;

import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: ManageReactionsResultsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsResultsAdapter$ErrorItem implements MGRecyclerDataPayload {
    private final long channelId;
    private final MessageReactionEmoji emoji;
    private final String key;
    private final long messageId;
    private final int type;

    public ManageReactionsResultsAdapter$ErrorItem(long j, long j2, MessageReactionEmoji messageReactionEmoji) {
        m.checkNotNullParameter(messageReactionEmoji, "emoji");
        this.channelId = j;
        this.messageId = j2;
        this.emoji = messageReactionEmoji;
        this.type = 2;
        this.key = String.valueOf(getType());
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final MessageReactionEmoji getEmoji() {
        return this.emoji;
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
}
