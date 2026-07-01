package com.discord.utilities.search.network;

import d0.z.d.m;
import d0.z.d.o;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SearchFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchFetcher$getRestObservable$1 extends o implements Function1<AtomicInteger, Integer> {
    public static final SearchFetcher$getRestObservable$1 INSTANCE = new SearchFetcher$getRestObservable$1();

    public SearchFetcher$getRestObservable$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(AtomicInteger atomicInteger) {
        return invoke2(atomicInteger);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Integer invoke2(AtomicInteger atomicInteger) {
        m.checkNotNullParameter(atomicInteger, "$this$getNullIfZero");
        int i = atomicInteger.get();
        if (i != 0) {
            return Integer.valueOf(i);
        }
        return null;
    }
}
