package com.discord.widgets.chat.list.entries;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: MessageHeaderEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MessageHeaderEntry extends ChatListEntry {
    private final String channelName;
    private final String key;
    private final Message message;
    private final String text;
    private final int type;

    public MessageHeaderEntry(Message message, String str, String str2) {
        Intrinsics3.checkNotNullParameter(message, "message");
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
        Intrinsics3.checkNotNullParameter(message, "message");
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
        return Intrinsics3.areEqual(this.message, messageHeaderEntry.message) && Intrinsics3.areEqual(this.text, messageHeaderEntry.text) && Intrinsics3.areEqual(this.channelName, messageHeaderEntry.channelName);
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
        StringBuilder sbU = outline.U("MessageHeaderEntry(message=");
        sbU.append(this.message);
        sbU.append(", text=");
        sbU.append(this.text);
        sbU.append(", channelName=");
        return outline.J(sbU, this.channelName, ")");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageHeaderEntry(Message message, Channel channel, Guild guild) {
        this(message, guild != null ? guild.getName() : null, channel != null ? ChannelUtils.c(channel) : null);
        Intrinsics3.checkNotNullParameter(message, "message");
    }
}
