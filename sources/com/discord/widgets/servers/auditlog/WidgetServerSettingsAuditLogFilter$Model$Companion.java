package com.discord.widgets.servers.auditlog;

import android.annotation.SuppressLint;
import android.content.Context;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import j0.l.e.k;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter$Model$Companion {
    private WidgetServerSettingsAuditLogFilter$Model$Companion() {
    }

    private final Observable<Set<Long>> getPermissionUserIds(long guildId) {
        StoreGuilds guilds = StoreStream.Companion.getGuilds();
        Observable<Set<Long>> observableR = Observable.i(guilds.observeGuild(guildId), guilds.observeRoles(guildId), guilds.observeComputed(guildId), WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
        return observableR;
    }

    @SuppressLint({"DefaultLocale"})
    public final Observable<WidgetServerSettingsAuditLogFilter$Model> get(Context context, long guildId, int filterType, Observable<String> filterPublisher) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(filterPublisher, "filterPublisher");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetServerSettingsAuditLogFilter$Model> observableR = Observable.g(storeStream$Companion.getAuditLog().observeAuditLogState(guildId), getPermissionUserIds(guildId).Y(WidgetServerSettingsAuditLogFilter$Model$Companion$get$1.INSTANCE), storeStream$Companion.getGuilds().observeComputed(guildId), new k(AuditLogUtils.INSTANCE.getALL_ACTION_TYPES()), ObservableExtensionsKt.leadingEdgeThrottle(filterPublisher, 100L, TimeUnit.MILLISECONDS).r(), new WidgetServerSettingsAuditLogFilter$Model$Companion$get$2(filterType, context)).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n             …  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetServerSettingsAuditLogFilter$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
