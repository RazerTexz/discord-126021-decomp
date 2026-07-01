package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelBan;
import com.discord.stores.StoreStream;
import j0.k.b;
import j0.l.e.k;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans$Model$Companion$getBanItems$1<T, R> implements b<Map<Long, ? extends ModelBan>, Observable<? extends WidgetServerSettingsBans$Model>> {
    public final /* synthetic */ Observable $filterPublisher;
    public final /* synthetic */ long $guildId;

    public WidgetServerSettingsBans$Model$Companion$getBanItems$1(long j, Observable observable) {
        this.$guildId = j;
        this.$filterPublisher = observable;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsBans$Model> call(Map<Long, ? extends ModelBan> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsBans$Model> call2(Map<Long, ? extends ModelBan> map) {
        return map == null ? StoreStream.Companion.getGuilds().observeGuild(this.$guildId).G(WidgetServerSettingsBans$Model$Companion$getBanItems$1$1.INSTANCE) : Observable.i(StoreStream.Companion.getGuilds().observeGuild(this.$guildId), new k(Integer.valueOf(map.size())), this.$filterPublisher.Y(new WidgetServerSettingsBans$Model$Companion$getBanItems$1$2(map)), WidgetServerSettingsBans$Model$Companion$getBanItems$1$3.INSTANCE);
    }
}
