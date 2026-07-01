package com.discord.utilities.search.history;

import com.discord.utilities.persister.Persister;
import d0.z.d.m;
import d0.z.d.o;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MGPreferenceSearchHistoryCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGPreferenceSearchHistoryCache$persistQuery$2 extends o implements Function1<LinkedList<MGPreferenceSearchHistoryCache$TargetHistory>, Unit> {
    public final /* synthetic */ MGPreferenceSearchHistoryCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MGPreferenceSearchHistoryCache$persistQuery$2(MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache) {
        super(1);
        this.this$0 = mGPreferenceSearchHistoryCache;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(LinkedList<MGPreferenceSearchHistoryCache$TargetHistory> linkedList) {
        invoke2(linkedList);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LinkedList<MGPreferenceSearchHistoryCache$TargetHistory> linkedList) {
        Persister persisterAccess$getBackingCache$p = MGPreferenceSearchHistoryCache.access$getBackingCache$p(this.this$0);
        m.checkNotNullExpressionValue(linkedList, "it");
        Persister.set$default(persisterAccess$getBackingCache$p, linkedList, false, 2, null);
    }
}
