package com.discord.widgets.chat.list.entries;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.sticker.BaseSticker;
import d0.z.d.m;

/* JADX INFO: compiled from: MessageEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MessageEntry$CtaData {
    private final Channel channel;
    private final BaseSticker sticker;

    public MessageEntry$CtaData(BaseSticker baseSticker, Channel channel) {
        m.checkNotNullParameter(baseSticker, "sticker");
        m.checkNotNullParameter(channel, "channel");
        this.sticker = baseSticker;
        this.channel = channel;
    }

    public static /* synthetic */ MessageEntry$CtaData copy$default(MessageEntry$CtaData messageEntry$CtaData, BaseSticker baseSticker, Channel channel, int i, Object obj) {
        if ((i & 1) != 0) {
            baseSticker = messageEntry$CtaData.sticker;
        }
        if ((i & 2) != 0) {
            channel = messageEntry$CtaData.channel;
        }
        return messageEntry$CtaData.copy(baseSticker, channel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BaseSticker getSticker() {
        return this.sticker;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final MessageEntry$CtaData copy(BaseSticker sticker, Channel channel) {
        m.checkNotNullParameter(sticker, "sticker");
        m.checkNotNullParameter(channel, "channel");
        return new MessageEntry$CtaData(sticker, channel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageEntry$CtaData)) {
            return false;
        }
        MessageEntry$CtaData messageEntry$CtaData = (MessageEntry$CtaData) other;
        return m.areEqual(this.sticker, messageEntry$CtaData.sticker) && m.areEqual(this.channel, messageEntry$CtaData.channel);
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
        StringBuilder sbU = a.U("CtaData(sticker=");
        sbU.append(this.sticker);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(")");
        return sbU.toString();
    }
}
