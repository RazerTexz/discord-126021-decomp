package com.discord.widgets.guilds.list;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildListItem {
    public static final GuildListItem$Companion Companion = new GuildListItem$Companion(null);
    private static final long ID_BOTTOM_NAV_SPACE = -6;
    private static final long ID_CREATE = -3;
    private static final long ID_DIVIDER = -4;
    private static final long ID_FRIENDS_LIST = -2;
    private static final long ID_HELP = -5;
    private static final long ID_HUB = -8;
    public static final long ID_PENDING_GUILDS_FOLDER = -7;
    private static final long ID_UNIDENTIFIED = -1;
    public static final int TYPE_BOTTOM_NAV_SPACE = 8;
    public static final int TYPE_CREATE = 5;
    public static final int TYPE_DIVIDER = 1;
    public static final int TYPE_DM = 2;
    public static final int TYPE_FOLDER = 6;
    public static final int TYPE_FRIENDS = 0;
    public static final int TYPE_GUILD = 3;
    public static final int TYPE_HELP = 7;
    public static final int TYPE_HUB = 9;
    public static final int TYPE_UNAVAILABLE = 4;
    private final long itemId;

    private GuildListItem(long j) {
        this.itemId = j;
    }

    public final long getItemId() {
        return this.itemId;
    }

    public /* synthetic */ GuildListItem(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }
}
