package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotices$clearSeen$1 extends o implements Function1<HashMap<String, Long>, HashMap<String, Long>> {
    public final /* synthetic */ String $noticeName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNotices$clearSeen$1(String str) {
        super(1);
        this.$noticeName = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ HashMap<String, Long> invoke(HashMap<String, Long> map) {
        return invoke2(map);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final HashMap<String, Long> invoke2(HashMap<String, Long> map) {
        m.checkNotNullParameter(map, "cache");
        map.remove(this.$noticeName);
        return map;
    }
}
