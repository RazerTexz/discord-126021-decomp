package com.discord.widgets.settings.account;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import j0.k.b;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersViewModel$Companion$observeStores$1<T, R> implements b<Map<Long, ? extends Integer>, Observable<? extends WidgetSettingsBlockedUsersViewModel$StoreState>> {
    public final /* synthetic */ StoreUser $storeUser;

    public WidgetSettingsBlockedUsersViewModel$Companion$observeStores$1(StoreUser storeUser) {
        this.$storeUser = storeUser;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetSettingsBlockedUsersViewModel$StoreState> call(Map<Long, ? extends Integer> map) {
        return call2((Map<Long, Integer>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetSettingsBlockedUsersViewModel$StoreState> call2(Map<Long, Integer> map) {
        m.checkNotNullExpressionValue(map, "relationships");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Integer> map$Entry : map.entrySet()) {
            if (map$Entry.getValue().intValue() == 2) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        return this.$storeUser.observeUsers(linkedHashMap.keySet()).G(WidgetSettingsBlockedUsersViewModel$Companion$observeStores$1$1.INSTANCE);
    }
}
