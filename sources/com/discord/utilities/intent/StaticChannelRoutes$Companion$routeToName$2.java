package com.discord.utilities.intent;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: StaticChannelRoutes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StaticChannelRoutes$Companion$routeToName$2 extends AbstractC12240o implements Function0<Map<String, ? extends StaticChannelRoutes>> {
    public static final StaticChannelRoutes$Companion$routeToName$2 INSTANCE = new StaticChannelRoutes$Companion$routeToName$2();

    public StaticChannelRoutes$Companion$routeToName$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Map<String, ? extends StaticChannelRoutes> invoke() {
        StaticChannelRoutes[] staticChannelRoutesArrValues = StaticChannelRoutes.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(1), 16));
        for (int i = 0; i < 1; i++) {
            StaticChannelRoutes staticChannelRoutes = staticChannelRoutesArrValues[i];
            linkedHashMap.put(staticChannelRoutes.getRoute(), staticChannelRoutes);
        }
        return linkedHashMap;
    }
}
