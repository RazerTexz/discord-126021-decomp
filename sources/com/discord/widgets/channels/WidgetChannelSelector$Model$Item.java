package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelSelector$Model$Item implements MGRecyclerDataPayload {
    private final Channel channel;
    private final String key;
    private final int type;

    public WidgetChannelSelector$Model$Item(Channel channel, int i, String str) {
        m.checkNotNullParameter(str, "key");
        this.channel = channel;
        this.type = i;
        this.key = str;
    }

    public static /* synthetic */ WidgetChannelSelector$Model$Item copy$default(WidgetChannelSelector$Model$Item widgetChannelSelector$Model$Item, Channel channel, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            channel = widgetChannelSelector$Model$Item.channel;
        }
        if ((i2 & 2) != 0) {
            i = widgetChannelSelector$Model$Item.getType();
        }
        if ((i2 & 4) != 0) {
            str = widgetChannelSelector$Model$Item.getKey();
        }
        return widgetChannelSelector$Model$Item.copy(channel, i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final int component2() {
        return getType();
    }

    public final String component3() {
        return getKey();
    }

    public final WidgetChannelSelector$Model$Item copy(Channel channel, int type, String key) {
        m.checkNotNullParameter(key, "key");
        return new WidgetChannelSelector$Model$Item(channel, type, key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelSelector$Model$Item)) {
            return false;
        }
        WidgetChannelSelector$Model$Item widgetChannelSelector$Model$Item = (WidgetChannelSelector$Model$Item) other;
        return m.areEqual(this.channel, widgetChannelSelector$Model$Item.channel) && getType() == widgetChannelSelector$Model$Item.getType() && m.areEqual(getKey(), widgetChannelSelector$Model$Item.getKey());
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Channel channel = this.channel;
        int type = (getType() + ((channel != null ? channel.hashCode() : 0) * 31)) * 31;
        String key = getKey();
        return type + (key != null ? key.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Item(channel=");
        sbU.append(this.channel);
        sbU.append(", type=");
        sbU.append(getType());
        sbU.append(", key=");
        sbU.append(getKey());
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChannelSelector$Model$Item(Channel channel, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        i = (i2 & 2) != 0 ? channel != null ? channel.getType() : -1 : i;
        if ((i2 & 4) != 0 && (channel == null || (str = String.valueOf(channel.getId())) == null)) {
            str = "";
        }
        this(channel, i, str);
    }
}
