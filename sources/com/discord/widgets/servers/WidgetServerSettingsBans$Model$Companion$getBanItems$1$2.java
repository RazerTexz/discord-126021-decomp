package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import j0.l.a.o2;
import j0.l.a.r;
import java.util.List;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans$Model$Companion$getBanItems$1$2<T, R> implements b<String, Observable<? extends List<WidgetServerSettingsBans$Model$BanItem>>> {
    public final /* synthetic */ Map $bannedUserMap;

    public WidgetServerSettingsBans$Model$Companion$getBanItems$1$2(Map map) {
        this.$bannedUserMap = map;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends List<WidgetServerSettingsBans$Model$BanItem>> call(String str) {
        return call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<WidgetServerSettingsBans$Model$BanItem>> call2(String str) {
        Observable<R> observableG = Observable.B(this.$bannedUserMap.values()).y(new WidgetServerSettingsBans$Model$Companion$getBanItems$1$2$1(str)).G(WidgetServerSettingsBans$Model$Companion$getBanItems$1$2$2.INSTANCE);
        return Observable.h0(new r(observableG.j, new o2(WidgetServerSettingsBans$Model$Companion$getBanItems$1$2$3.INSTANCE, 10)));
    }
}
