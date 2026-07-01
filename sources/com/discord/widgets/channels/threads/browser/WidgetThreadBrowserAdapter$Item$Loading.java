package com.discord.widgets.channels.threads.browser;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadBrowserAdapter$Item$Loading extends WidgetThreadBrowserAdapter$Item {
    private final String key;
    private final int type;

    public WidgetThreadBrowserAdapter$Item$Loading() {
        this(null, 1, null);
    }

    public /* synthetic */ WidgetThreadBrowserAdapter$Item$Loading(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "loading" : str);
    }

    public static /* synthetic */ WidgetThreadBrowserAdapter$Item$Loading copy$default(WidgetThreadBrowserAdapter$Item$Loading widgetThreadBrowserAdapter$Item$Loading, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetThreadBrowserAdapter$Item$Loading.getKey();
        }
        return widgetThreadBrowserAdapter$Item$Loading.copy(str);
    }

    public final String component1() {
        return getKey();
    }

    public final WidgetThreadBrowserAdapter$Item$Loading copy(String key) {
        m.checkNotNullParameter(key, "key");
        return new WidgetThreadBrowserAdapter$Item$Loading(key);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetThreadBrowserAdapter$Item$Loading) && m.areEqual(getKey(), ((WidgetThreadBrowserAdapter$Item$Loading) other).getKey());
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
        StringBuilder sbU = a.U("Loading(key=");
        sbU.append(getKey());
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserAdapter$Item$Loading(String str) {
        super(null);
        m.checkNotNullParameter(str, "key");
        this.key = str;
        this.type = WidgetThreadBrowserAdapter$ItemType.LOADING.ordinal();
    }
}
