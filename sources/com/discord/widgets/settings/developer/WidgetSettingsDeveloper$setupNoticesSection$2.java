package com.discord.widgets.settings.developer;

import androidx.core.app.NotificationCompat;
import d0.t.g0;
import d0.t.i0;
import d0.z.d.m;
import j0.k.b;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$setupNoticesSection$2<T, R> implements b<HashMap<String, Long>, List<? extends Pair<? extends String, ? extends Long>>> {
    public static final WidgetSettingsDeveloper$setupNoticesSection$2 INSTANCE = new WidgetSettingsDeveloper$setupNoticesSection$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends Pair<? extends String, ? extends Long>> call(HashMap<String, Long> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<Pair<String, Long>> call2(HashMap<String, Long> map) {
        m.checkNotNullExpressionValue(map, "noticesSeenMap");
        return i0.toList(g0.toSortedMap(map));
    }
}
