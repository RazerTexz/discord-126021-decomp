package com.discord.widgets.settings.account;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsBlockedUsersViewModel$ViewState$Loaded extends WidgetSettingsBlockedUsersViewModel$ViewState {
    private final List<WidgetSettingsBlockedUsersViewModel$Item> items;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsBlockedUsersViewModel$ViewState$Loaded(List<WidgetSettingsBlockedUsersViewModel$Item> list) {
        super(null);
        m.checkNotNullParameter(list, "items");
        this.items = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetSettingsBlockedUsersViewModel$ViewState$Loaded copy$default(WidgetSettingsBlockedUsersViewModel$ViewState$Loaded widgetSettingsBlockedUsersViewModel$ViewState$Loaded, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetSettingsBlockedUsersViewModel$ViewState$Loaded.items;
        }
        return widgetSettingsBlockedUsersViewModel$ViewState$Loaded.copy(list);
    }

    public final List<WidgetSettingsBlockedUsersViewModel$Item> component1() {
        return this.items;
    }

    public final WidgetSettingsBlockedUsersViewModel$ViewState$Loaded copy(List<WidgetSettingsBlockedUsersViewModel$Item> items) {
        m.checkNotNullParameter(items, "items");
        return new WidgetSettingsBlockedUsersViewModel$ViewState$Loaded(items);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetSettingsBlockedUsersViewModel$ViewState$Loaded) && m.areEqual(this.items, ((WidgetSettingsBlockedUsersViewModel$ViewState$Loaded) other).items);
        }
        return true;
    }

    public final List<WidgetSettingsBlockedUsersViewModel$Item> getItems() {
        return this.items;
    }

    public int hashCode() {
        List<WidgetSettingsBlockedUsersViewModel$Item> list = this.items;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("Loaded(items="), this.items, ")");
    }
}
