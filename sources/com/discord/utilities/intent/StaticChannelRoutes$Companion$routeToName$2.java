package com.discord.utilities.intent;

import d0.d0.f;
import d0.t.g0;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StaticChannelRoutes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StaticChannelRoutes$Companion$routeToName$2 extends o implements Function0<Map<String, ? extends StaticChannelRoutes>> {
    public static final StaticChannelRoutes$Companion$routeToName$2 INSTANCE = new StaticChannelRoutes$Companion$routeToName$2();

    public StaticChannelRoutes$Companion$routeToName$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<String, ? extends StaticChannelRoutes> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, ? extends StaticChannelRoutes> invoke2() {
        StaticChannelRoutes[] staticChannelRoutesArrValues = StaticChannelRoutes.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(1), 16));
        for (int i = 0; i < 1; i++) {
            StaticChannelRoutes staticChannelRoutes = staticChannelRoutesArrValues[i];
            linkedHashMap.put(staticChannelRoutes.getRoute(), staticChannelRoutes);
        }
        return linkedHashMap;
    }
}
