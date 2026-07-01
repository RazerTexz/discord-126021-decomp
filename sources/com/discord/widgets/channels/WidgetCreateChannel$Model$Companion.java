package com.discord.widgets.channels;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.forums.ForumUtils;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannel$Model$Companion {
    private WidgetCreateChannel$Model$Companion() {
    }

    public final Observable<WidgetCreateChannel$Model> get(long guildId, Long categoryId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableF = Observable.f(StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getGuilds().observeGuild(guildId), storeStream$Companion.getPermissions().observePermissionsForGuild(guildId), storeStream$Companion.getPermissions().observePermissionsForChannel(categoryId != null ? categoryId.longValue() : 0L), storeStream$Companion.getGuilds().observeSortedRoles(guildId), ForumUtils.observeCanCreateForumChannels$default(ForumUtils.INSTANCE, guildId, null, null, 6, null), WidgetCreateChannel$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableF, "Observable\n            .…          }\n            }");
        Observable<WidgetCreateChannel$Model> observableR = ObservableExtensionsKt.computationLatest(observableF).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetCreateChannel$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
