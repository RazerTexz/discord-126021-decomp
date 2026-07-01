package com.discord.widgets.guilds.list;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildsListViewModel$Event$AnnounceFolderToggleForAccessibility extends WidgetGuildsListViewModel$Event {
    private final GuildListItem$FolderItem item;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsListViewModel$Event$AnnounceFolderToggleForAccessibility(GuildListItem$FolderItem guildListItem$FolderItem) {
        super(null);
        m.checkNotNullParameter(guildListItem$FolderItem, "item");
        this.item = guildListItem$FolderItem;
    }

    public static /* synthetic */ WidgetGuildsListViewModel$Event$AnnounceFolderToggleForAccessibility copy$default(WidgetGuildsListViewModel$Event$AnnounceFolderToggleForAccessibility widgetGuildsListViewModel$Event$AnnounceFolderToggleForAccessibility, GuildListItem$FolderItem guildListItem$FolderItem, int i, Object obj) {
        if ((i & 1) != 0) {
            guildListItem$FolderItem = widgetGuildsListViewModel$Event$AnnounceFolderToggleForAccessibility.item;
        }
        return widgetGuildsListViewModel$Event$AnnounceFolderToggleForAccessibility.copy(guildListItem$FolderItem);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildListItem$FolderItem getItem() {
        return this.item;
    }

    public final WidgetGuildsListViewModel$Event$AnnounceFolderToggleForAccessibility copy(GuildListItem$FolderItem item) {
        m.checkNotNullParameter(item, "item");
        return new WidgetGuildsListViewModel$Event$AnnounceFolderToggleForAccessibility(item);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetGuildsListViewModel$Event$AnnounceFolderToggleForAccessibility) && m.areEqual(this.item, ((WidgetGuildsListViewModel$Event$AnnounceFolderToggleForAccessibility) other).item);
        }
        return true;
    }

    public final GuildListItem$FolderItem getItem() {
        return this.item;
    }

    public int hashCode() {
        GuildListItem$FolderItem guildListItem$FolderItem = this.item;
        if (guildListItem$FolderItem != null) {
            return guildListItem$FolderItem.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("AnnounceFolderToggleForAccessibility(item=");
        sbU.append(this.item);
        sbU.append(")");
        return sbU.toString();
    }
}
