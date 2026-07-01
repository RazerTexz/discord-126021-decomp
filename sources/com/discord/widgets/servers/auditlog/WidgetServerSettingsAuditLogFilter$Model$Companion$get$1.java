package com.discord.widgets.servers.auditlog;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;
import java.util.Set;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter$Model$Companion$get$1<T, R> implements b<Set<? extends Long>, Observable<? extends Map<Long, ? extends User>>> {
    public static final WidgetServerSettingsAuditLogFilter$Model$Companion$get$1 INSTANCE = new WidgetServerSettingsAuditLogFilter$Model$Companion$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends User>> call(Set<? extends Long> set) {
        return call2((Set<Long>) set);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, User>> call2(Set<Long> set) {
        StoreUser users = StoreStream.Companion.getUsers();
        m.checkNotNullExpressionValue(set, "it");
        return users.observeUsers(set);
    }
}
