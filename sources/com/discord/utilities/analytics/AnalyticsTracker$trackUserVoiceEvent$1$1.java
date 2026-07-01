package com.discord.utilities.analytics;

import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsTracker$trackUserVoiceEvent$1$1 extends o implements Function0<Map<String, ? extends Object>> {
    public final /* synthetic */ Map $gameProperties;
    public final /* synthetic */ AnalyticsTracker$trackUserVoiceEvent$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsTracker$trackUserVoiceEvent$1$1(AnalyticsTracker$trackUserVoiceEvent$1 analyticsTracker$trackUserVoiceEvent$1, Map map) {
        super(0);
        this.this$0 = analyticsTracker$trackUserVoiceEvent$1;
        this.$gameProperties = map;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<String, ? extends Object> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, ? extends Object> invoke2() {
        this.$gameProperties.put("mode", this.this$0.$inputMode);
        this.$gameProperties.put("channel", Long.valueOf(this.this$0.$this_trackUserVoiceEvent.getId()));
        this.$gameProperties.put("channel_type", Integer.valueOf(this.this$0.$this_trackUserVoiceEvent.getType()));
        this.$gameProperties.put("server", Long.valueOf(this.this$0.$this_trackUserVoiceEvent.getGuildId()));
        return this.$gameProperties;
    }
}
