package com.discord.widgets.servers;

import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications$Model$Companion {
    private WidgetServerNotifications$Model$Companion() {
    }

    public final Observable<WidgetServerNotifications$Model> get(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableI = Observable.i(storeStream$Companion.getGuilds().observeGuild(guildId), storeStream$Companion.getUserGuildSettings().observeGuildSettings(guildId), storeStream$Companion.getGuildProfiles().observeGuildProfile(guildId), WidgetServerNotifications$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable\n          .co…  } else null\n          }");
        Observable<WidgetServerNotifications$Model> observableR = ObservableExtensionsKt.computationBuffered(observableI).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
        return observableR;
    }

    public final boolean isValid(Guild guild, ModelNotificationSettings guildSettings) {
        return (guild == null || guildSettings == null) ? false : true;
    }

    public /* synthetic */ WidgetServerNotifications$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
