package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VoiceConfigurationCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceConfigurationCache$read$2 extends o implements Function2<String, String, Pair<? extends Long, ? extends Float>> {
    public static final VoiceConfigurationCache$read$2 INSTANCE = new VoiceConfigurationCache$read$2();

    public VoiceConfigurationCache$read$2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Pair<? extends Long, ? extends Float> invoke(String str, String str2) {
        return invoke2(str, str2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<Long, Float> invoke2(String str, String str2) {
        m.checkNotNullParameter(str, "key");
        m.checkNotNullParameter(str2, "value");
        return d0.o.to(Long.valueOf(Long.parseLong(str)), Float.valueOf(Float.parseFloat(str2)));
    }
}
