package com.discord.widgets.user;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualFriends$Model$Item$Empty extends WidgetUserMutualFriends$Model$Item {
    public static final WidgetUserMutualFriends$Model$Item$Empty INSTANCE;
    private static final String key;
    private static final int type = 0;

    static {
        WidgetUserMutualFriends$Model$Item$Empty widgetUserMutualFriends$Model$Item$Empty = new WidgetUserMutualFriends$Model$Item$Empty();
        INSTANCE = widgetUserMutualFriends$Model$Item$Empty;
        StringBuilder sbU = a.U("empty");
        sbU.append(widgetUserMutualFriends$Model$Item$Empty.getType());
        key = sbU.toString();
    }

    private WidgetUserMutualFriends$Model$Item$Empty() {
        super(null);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return type;
    }
}
