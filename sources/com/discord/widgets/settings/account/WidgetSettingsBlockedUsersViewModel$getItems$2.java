package com.discord.widgets.settings.account;

import com.discord.utilities.user.UserUtils;
import java.util.Comparator;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersViewModel$getItems$2<T> implements Comparator<WidgetSettingsBlockedUsersViewModel$Item> {
    public static final WidgetSettingsBlockedUsersViewModel$getItems$2 INSTANCE = new WidgetSettingsBlockedUsersViewModel$getItems$2();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(WidgetSettingsBlockedUsersViewModel$Item widgetSettingsBlockedUsersViewModel$Item, WidgetSettingsBlockedUsersViewModel$Item widgetSettingsBlockedUsersViewModel$Item2) {
        return compare2(widgetSettingsBlockedUsersViewModel$Item, widgetSettingsBlockedUsersViewModel$Item2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(WidgetSettingsBlockedUsersViewModel$Item widgetSettingsBlockedUsersViewModel$Item, WidgetSettingsBlockedUsersViewModel$Item widgetSettingsBlockedUsersViewModel$Item2) {
        return UserUtils.INSTANCE.compareUserNames(widgetSettingsBlockedUsersViewModel$Item.getUser(), widgetSettingsBlockedUsersViewModel$Item2.getUser());
    }
}
