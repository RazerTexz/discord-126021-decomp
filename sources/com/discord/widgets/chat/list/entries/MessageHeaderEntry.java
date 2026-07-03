package com.discord.widgets.chat.list.entries;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MessageHeaderEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MessageHeaderEntry extends ChatListEntry {
    private final String channelName;
    private final String key;
    private final Message message;
    private final String text;
    private final int type;

    public MessageHeaderEntry(Message message, String str, String str2) {
        C12238m.checkNotNullParameter(message, "message");
        this.message = message;
        this.text = str;
        this.channelName = str2;
        this.type = 17;
        this.key = String.valueOf(getType());
    }

    public static /* synthetic */ MessageHeaderEntry copy$default(MessageHeaderEntry messageHeaderEntry, Message message, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            message = messageHeaderEntry.message;
        }
        if ((i & 2) != 0) {
            str = messageHeaderEntry.text;
        }
        if ((i & 4) != 0) {
            str2 = messageHeaderEntry.channelName;
        }
        return messageHeaderEntry.copy(message, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    public final MessageHeaderEntry copy(Message message, String text, String channelName) {
        C12238m.checkNotNullParameter(message, "message");
        return new MessageHeaderEntry(message, text, channelName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageHeaderEntry)) {
            return false;
        }
        MessageHeaderEntry messageHeaderEntry = (MessageHeaderEntry) other;
        return C12238m.areEqual(this.message, messageHeaderEntry.message) && C12238m.areEqual(this.text, messageHeaderEntry.text) && C12238m.areEqual(this.channelName, messageHeaderEntry.channelName);
    }

    public final String getChannelName() {
        return this.channelName;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final String getText() {
        return this.text;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Message message = this.message;
        int iHashCode = (message != null ? message.hashCode() : 0) * 31;
        String str = this.text;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.channelName;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("MessageHeaderEntry(message=");
        sbM833U.append(this.message);
        sbM833U.append(", text=");
        sbM833U.append(this.text);
        sbM833U.append(", channelName=");
        return C1643a.m822J(sbM833U, this.channelName, ")");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageHeaderEntry(Message message, Channel channel, Guild guild) {
        this(message, guild != null ? guild.getName() : null, channel != null ? ChannelUtils.m7679c(channel) : null);
        C12238m.checkNotNullParameter(message, "message");
    }
}
