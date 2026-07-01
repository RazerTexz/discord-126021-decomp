package com.discord.widgets.user.search;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetGlobalSearchGuildsModel {
    public static final WidgetGlobalSearchGuildsModel$Companion Companion = new WidgetGlobalSearchGuildsModel$Companion(null);
    private final boolean hasChannels;
    private final List<WidgetGlobalSearchGuildsModel$Item> items;

    public WidgetGlobalSearchGuildsModel(List<WidgetGlobalSearchGuildsModel$Item> list, boolean z2) {
        m.checkNotNullParameter(list, "items");
        this.items = list;
        this.hasChannels = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGlobalSearchGuildsModel copy$default(WidgetGlobalSearchGuildsModel widgetGlobalSearchGuildsModel, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetGlobalSearchGuildsModel.items;
        }
        if ((i & 2) != 0) {
            z2 = widgetGlobalSearchGuildsModel.hasChannels;
        }
        return widgetGlobalSearchGuildsModel.copy(list, z2);
    }

    public final List<WidgetGlobalSearchGuildsModel$Item> component1() {
        return this.items;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasChannels() {
        return this.hasChannels;
    }

    public final WidgetGlobalSearchGuildsModel copy(List<WidgetGlobalSearchGuildsModel$Item> items, boolean hasChannels) {
        m.checkNotNullParameter(items, "items");
        return new WidgetGlobalSearchGuildsModel(items, hasChannels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalSearchGuildsModel)) {
            return false;
        }
        WidgetGlobalSearchGuildsModel widgetGlobalSearchGuildsModel = (WidgetGlobalSearchGuildsModel) other;
        return m.areEqual(this.items, widgetGlobalSearchGuildsModel.items) && this.hasChannels == widgetGlobalSearchGuildsModel.hasChannels;
    }

    public final boolean getHasChannels() {
        return this.hasChannels;
    }

    public final List<WidgetGlobalSearchGuildsModel$Item> getItems() {
        return this.items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        List<WidgetGlobalSearchGuildsModel$Item> list = this.items;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.hasChannels;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("WidgetGlobalSearchGuildsModel(items=");
        sbU.append(this.items);
        sbU.append(", hasChannels=");
        return a.O(sbU, this.hasChannels, ")");
    }

    public /* synthetic */ WidgetGlobalSearchGuildsModel(List list, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? true : z2);
    }
}
