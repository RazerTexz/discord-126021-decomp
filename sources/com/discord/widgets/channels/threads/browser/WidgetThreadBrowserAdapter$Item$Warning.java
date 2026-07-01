package com.discord.widgets.channels.threads.browser;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadBrowserAdapter$Item$Warning extends WidgetThreadBrowserAdapter$Item {
    private final String key;
    private final int type;

    public WidgetThreadBrowserAdapter$Item$Warning() {
        this(null, 1, null);
    }

    public /* synthetic */ WidgetThreadBrowserAdapter$Item$Warning(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "warning" : str);
    }

    public static /* synthetic */ WidgetThreadBrowserAdapter$Item$Warning copy$default(WidgetThreadBrowserAdapter$Item$Warning widgetThreadBrowserAdapter$Item$Warning, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetThreadBrowserAdapter$Item$Warning.getKey();
        }
        return widgetThreadBrowserAdapter$Item$Warning.copy(str);
    }

    public final String component1() {
        return getKey();
    }

    public final WidgetThreadBrowserAdapter$Item$Warning copy(String key) {
        m.checkNotNullParameter(key, "key");
        return new WidgetThreadBrowserAdapter$Item$Warning(key);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetThreadBrowserAdapter$Item$Warning) && m.areEqual(getKey(), ((WidgetThreadBrowserAdapter$Item$Warning) other).getKey());
        }
        return true;
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
        String key = getKey();
        if (key != null) {
            return key.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Warning(key=");
        sbU.append(getKey());
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserAdapter$Item$Warning(String str) {
        super(null);
        m.checkNotNullParameter(str, "key");
        this.key = str;
        this.type = WidgetThreadBrowserAdapter$ItemType.WARNING.ordinal();
    }
}
