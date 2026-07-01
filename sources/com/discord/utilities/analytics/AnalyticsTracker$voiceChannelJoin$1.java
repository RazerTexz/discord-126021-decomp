package com.discord.utilities.analytics;

import com.discord.utilities.collections.CollectionExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsTracker$voiceChannelJoin$1 extends o implements Function1<Map<String, Object>, Unit> {
    public final /* synthetic */ Map $voiceProperties;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsTracker$voiceChannelJoin$1(Map map) {
        super(1);
        this.$voiceProperties = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> map) {
        invoke2(map);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, Object> map) {
        m.checkNotNullParameter(map, "gameProperties");
        this.$voiceProperties.putAll(map);
        AnalyticsTracker.INSTANCE.getTracker().track("join_voice_channel", CollectionExtensionsKt.filterNonNullValues(this.$voiceProperties));
    }
}
