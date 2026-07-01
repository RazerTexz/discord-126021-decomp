package com.discord.widgets.user.search;

import d0.z.d.k;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function7;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1 extends k implements Function7<String, List<? extends Long>, Long, Long, Long, Map<Long, ? extends Long>, Map<Long, ? extends Integer>, WidgetGlobalSearchModel$SearchContext> {
    public static final WidgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1 INSTANCE = new WidgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1();

    public WidgetGlobalSearchModel$Companion$get$partialSearchContextObservable$1() {
        super(7, WidgetGlobalSearchModel$SearchContext.class, "<init>", "<init>(Ljava/lang/String;Ljava/util/List;JJJLjava/util/Map;Ljava/util/Map;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function7
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel$SearchContext invoke(String str, List<? extends Long> list, Long l, Long l2, Long l3, Map<Long, ? extends Long> map, Map<Long, ? extends Integer> map2) {
        return invoke(str, (List<Long>) list, l.longValue(), l2.longValue(), l3.longValue(), (Map<Long, Long>) map, (Map<Long, Integer>) map2);
    }

    public final WidgetGlobalSearchModel$SearchContext invoke(String str, List<Long> list, long j, long j2, long j3, Map<Long, Long> map, Map<Long, Integer> map2) {
        m.checkNotNullParameter(str, "p1");
        m.checkNotNullParameter(list, "p2");
        m.checkNotNullParameter(map, "p6");
        m.checkNotNullParameter(map2, "p7");
        return new WidgetGlobalSearchModel$SearchContext(str, list, j, j2, j3, map, map2);
    }
}
