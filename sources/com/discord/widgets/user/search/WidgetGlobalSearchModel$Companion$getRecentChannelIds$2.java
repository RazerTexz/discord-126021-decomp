package com.discord.widgets.user.search;

import d0.z.d.m;
import d0.z.d.o;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$getRecentChannelIds$2 extends o implements Function1<Map$Entry<? extends Long, ? extends Long>, Long> {
    public static final WidgetGlobalSearchModel$Companion$getRecentChannelIds$2 INSTANCE = new WidgetGlobalSearchModel$Companion$getRecentChannelIds$2();

    public WidgetGlobalSearchModel$Companion$getRecentChannelIds$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(Map$Entry<? extends Long, ? extends Long> map$Entry) {
        return Long.valueOf(invoke2((Map$Entry<Long, Long>) map$Entry));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(Map$Entry<Long, Long> map$Entry) {
        m.checkNotNullParameter(map$Entry, "it");
        return map$Entry.getKey().longValue();
    }
}
