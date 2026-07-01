package com.discord.widgets.settings.account;

import com.discord.models.user.User;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersViewModel$getItems$1 extends o implements Function1<Map$Entry<? extends Long, ? extends User>, WidgetSettingsBlockedUsersViewModel$Item> {
    public static final WidgetSettingsBlockedUsersViewModel$getItems$1 INSTANCE = new WidgetSettingsBlockedUsersViewModel$getItems$1();

    public WidgetSettingsBlockedUsersViewModel$getItems$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsBlockedUsersViewModel$Item invoke(Map$Entry<? extends Long, ? extends User> map$Entry) {
        return invoke2((Map$Entry<Long, ? extends User>) map$Entry);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsBlockedUsersViewModel$Item invoke2(Map$Entry<Long, ? extends User> map$Entry) {
        m.checkNotNullParameter(map$Entry, "userEntry");
        return new WidgetSettingsBlockedUsersViewModel$Item(map$Entry.getValue());
    }
}
