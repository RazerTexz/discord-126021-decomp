package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter$Payload;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetServerNotificationsOverrideSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotificationsOverrideSelector$Companion {
    private WidgetServerNotificationsOverrideSelector$Companion() {
    }

    public static final /* synthetic */ Observable access$get(WidgetServerNotificationsOverrideSelector$Companion widgetServerNotificationsOverrideSelector$Companion, long j, BehaviorSubject behaviorSubject) {
        return widgetServerNotificationsOverrideSelector$Companion.get(j, behaviorSubject);
    }

    private final Observable<List<CategoricalDragAndDropAdapter$Payload>> get(long guildId, BehaviorSubject<String> filterPublisher) {
        Observable observableI = Observable.i(StoreChannels.observeChannelsForGuild$default(StoreStream.Companion.getChannels(), guildId, null, 2, null), GuildChannelsInfo.Companion.get(guildId), ObservableExtensionsKt.leadingEdgeThrottle(filterPublisher, 100L, TimeUnit.MILLISECONDS), WidgetServerNotificationsOverrideSelector$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…              }\n        }");
        return ObservableExtensionsKt.computationBuffered(observableI).r();
    }

    public final void launch(Context context, long guildId) {
        m.checkNotNullParameter(context, "context");
        Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE….EXTRA_GUILD_ID, guildId)");
        j.d(context, WidgetServerNotificationsOverrideSelector.class, intentPutExtra);
    }

    public /* synthetic */ WidgetServerNotificationsOverrideSelector$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
