package com.discord.widgets.guilds.list;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildsListViewModel$ViewState$Loaded extends WidgetGuildsListViewModel$ViewState {
    private final boolean hasChannels;
    private final List<GuildListItem> items;
    private final boolean wasDragResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGuildsListViewModel$ViewState$Loaded(List<? extends GuildListItem> list, boolean z2, boolean z3) {
        super(null);
        m.checkNotNullParameter(list, "items");
        this.items = list;
        this.hasChannels = z2;
        this.wasDragResult = z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGuildsListViewModel$ViewState$Loaded copy$default(WidgetGuildsListViewModel$ViewState$Loaded widgetGuildsListViewModel$ViewState$Loaded, List list, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetGuildsListViewModel$ViewState$Loaded.items;
        }
        if ((i & 2) != 0) {
            z2 = widgetGuildsListViewModel$ViewState$Loaded.hasChannels;
        }
        if ((i & 4) != 0) {
            z3 = widgetGuildsListViewModel$ViewState$Loaded.wasDragResult;
        }
        return widgetGuildsListViewModel$ViewState$Loaded.copy(list, z2, z3);
    }

    public final List<GuildListItem> component1() {
        return this.items;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasChannels() {
        return this.hasChannels;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getWasDragResult() {
        return this.wasDragResult;
    }

    public final WidgetGuildsListViewModel$ViewState$Loaded copy(List<? extends GuildListItem> items, boolean hasChannels, boolean wasDragResult) {
        m.checkNotNullParameter(items, "items");
        return new WidgetGuildsListViewModel$ViewState$Loaded(items, hasChannels, wasDragResult);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildsListViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetGuildsListViewModel$ViewState$Loaded widgetGuildsListViewModel$ViewState$Loaded = (WidgetGuildsListViewModel$ViewState$Loaded) other;
        return m.areEqual(this.items, widgetGuildsListViewModel$ViewState$Loaded.items) && this.hasChannels == widgetGuildsListViewModel$ViewState$Loaded.hasChannels && this.wasDragResult == widgetGuildsListViewModel$ViewState$Loaded.wasDragResult;
    }

    public final boolean getHasChannels() {
        return this.hasChannels;
    }

    public final List<GuildListItem> getItems() {
        return this.items;
    }

    public final boolean getWasDragResult() {
        return this.wasDragResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        List<GuildListItem> list = this.items;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.hasChannels;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.wasDragResult;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(items=");
        sbU.append(this.items);
        sbU.append(", hasChannels=");
        sbU.append(this.hasChannels);
        sbU.append(", wasDragResult=");
        return a.O(sbU, this.wasDragResult, ")");
    }
}
