package com.discord.widgets.chat.list.entries;

import com.discord.models.message.Message;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: EphemeralMessageEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EphemeralMessageEntry extends ChatListEntry {
    private final String key;
    private final Message message;
    private final int type;

    public EphemeralMessageEntry(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        this.message = message;
        this.type = 34;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(' ');
        Object nonce = message.getNonce();
        sb.append(nonce == null ? Long.valueOf(message.getId()) : nonce);
        this.key = sb.toString();
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }
}
