package com.discord.widgets.channels.threads.browser;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadBrowserAdapter$Item$Header extends WidgetThreadBrowserAdapter$Item {
    private final int count;
    private final String key;
    private final int stringResId;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserAdapter$Item$Header(String str, int i, int i2) {
        super(null);
        m.checkNotNullParameter(str, "key");
        this.key = str;
        this.stringResId = i;
        this.count = i2;
        this.type = WidgetThreadBrowserAdapter$ItemType.HEADER.ordinal();
    }

    public static /* synthetic */ WidgetThreadBrowserAdapter$Item$Header copy$default(WidgetThreadBrowserAdapter$Item$Header widgetThreadBrowserAdapter$Item$Header, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = widgetThreadBrowserAdapter$Item$Header.getKey();
        }
        if ((i3 & 2) != 0) {
            i = widgetThreadBrowserAdapter$Item$Header.stringResId;
        }
        if ((i3 & 4) != 0) {
            i2 = widgetThreadBrowserAdapter$Item$Header.count;
        }
        return widgetThreadBrowserAdapter$Item$Header.copy(str, i, i2);
    }

    public final String component1() {
        return getKey();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStringResId() {
        return this.stringResId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    public final WidgetThreadBrowserAdapter$Item$Header copy(String key, int stringResId, int count) {
        m.checkNotNullParameter(key, "key");
        return new WidgetThreadBrowserAdapter$Item$Header(key, stringResId, count);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetThreadBrowserAdapter$Item$Header)) {
            return false;
        }
        WidgetThreadBrowserAdapter$Item$Header widgetThreadBrowserAdapter$Item$Header = (WidgetThreadBrowserAdapter$Item$Header) other;
        return m.areEqual(getKey(), widgetThreadBrowserAdapter$Item$Header.getKey()) && this.stringResId == widgetThreadBrowserAdapter$Item$Header.stringResId && this.count == widgetThreadBrowserAdapter$Item$Header.count;
    }

    public final int getCount() {
        return this.count;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final int getStringResId() {
        return this.stringResId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        String key = getKey();
        return ((((key != null ? key.hashCode() : 0) * 31) + this.stringResId) * 31) + this.count;
    }

    public String toString() {
        StringBuilder sbU = a.U("Header(key=");
        sbU.append(getKey());
        sbU.append(", stringResId=");
        sbU.append(this.stringResId);
        sbU.append(", count=");
        return a.B(sbU, this.count, ")");
    }
}
