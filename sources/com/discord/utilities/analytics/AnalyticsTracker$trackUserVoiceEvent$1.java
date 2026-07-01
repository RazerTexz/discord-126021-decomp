package com.discord.utilities.analytics;

import com.discord.api.channel.Channel;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsTracker$trackUserVoiceEvent$1 extends o implements Function1<Map<String, Object>, Unit> {
    public final /* synthetic */ String $inputMode;
    public final /* synthetic */ Channel $this_trackUserVoiceEvent;
    public final /* synthetic */ Pair $throttleKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsTracker$trackUserVoiceEvent$1(Channel channel, Pair pair, String str) {
        super(1);
        this.$this_trackUserVoiceEvent = channel;
        this.$throttleKey = pair;
        this.$inputMode = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> map) {
        invoke2(map);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, Object> map) {
        m.checkNotNullParameter(map, "gameProperties");
        AnalyticsTracker.INSTANCE.getTracker().track(this.$throttleKey, 900000L, new AnalyticsTracker$trackUserVoiceEvent$1$1(this, map));
    }
}
