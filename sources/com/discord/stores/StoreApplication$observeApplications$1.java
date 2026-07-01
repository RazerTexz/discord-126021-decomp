package com.discord.stores;

import com.discord.api.application.Application;
import d0.z.d.o;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplication$observeApplications$1 extends o implements Function0<Map<Long, ? extends Application>> {
    public final /* synthetic */ Collection $applicationIds;
    public final /* synthetic */ StoreApplication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplication$observeApplications$1(StoreApplication storeApplication, Collection collection) {
        super(0);
        this.this$0 = storeApplication;
        this.$applicationIds = collection;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Application> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Application> invoke2() {
        HashMap mapAccess$getApplicationsSnapshot$p = StoreApplication.access$getApplicationsSnapshot$p(this.this$0);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry map$Entry : mapAccess$getApplicationsSnapshot$p.entrySet()) {
            if (this.$applicationIds.contains(Long.valueOf(((Number) map$Entry.getKey()).longValue()))) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        return linkedHashMap;
    }
}
