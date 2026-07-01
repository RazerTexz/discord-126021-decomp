package com.discord.widgets.channels.list;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetChannelListUnreads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelListUnreads$Model$Indicator {
    private final int index;
    private final int type;

    public WidgetChannelListUnreads$Model$Indicator(int i, int i2) {
        this.type = i;
        this.index = i2;
    }

    public static /* synthetic */ WidgetChannelListUnreads$Model$Indicator copy$default(WidgetChannelListUnreads$Model$Indicator widgetChannelListUnreads$Model$Indicator, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = widgetChannelListUnreads$Model$Indicator.type;
        }
        if ((i3 & 2) != 0) {
            i2 = widgetChannelListUnreads$Model$Indicator.index;
        }
        return widgetChannelListUnreads$Model$Indicator.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    public final WidgetChannelListUnreads$Model$Indicator copy(int type, int index) {
        return new WidgetChannelListUnreads$Model$Indicator(type, index);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelListUnreads$Model$Indicator)) {
            return false;
        }
        WidgetChannelListUnreads$Model$Indicator widgetChannelListUnreads$Model$Indicator = (WidgetChannelListUnreads$Model$Indicator) other;
        return this.type == widgetChannelListUnreads$Model$Indicator.type && this.index == widgetChannelListUnreads$Model$Indicator.index;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type * 31) + this.index;
    }

    public String toString() {
        StringBuilder sbU = a.U("Indicator(type=");
        sbU.append(this.type);
        sbU.append(", index=");
        return a.B(sbU, this.index, ")");
    }
}
