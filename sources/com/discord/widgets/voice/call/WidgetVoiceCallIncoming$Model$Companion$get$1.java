package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.model.CallModel$Companion;
import d0.t.u;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.Set;
import rx.Observable;

/* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallIncoming$Model$Companion$get$1<T, R> implements b<Set<? extends Long>, Observable<? extends WidgetVoiceCallIncoming$Model>> {
    public static final WidgetVoiceCallIncoming$Model$Companion$get$1 INSTANCE = new WidgetVoiceCallIncoming$Model$Companion$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetVoiceCallIncoming$Model> call(Set<? extends Long> set) {
        return call2((Set<Long>) set);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetVoiceCallIncoming$Model> call2(Set<Long> set) {
        if (set.isEmpty()) {
            return new k(null);
        }
        CallModel$Companion callModel$Companion = CallModel.Companion;
        m.checkNotNullExpressionValue(set, "incomingCalls");
        return callModel$Companion.get(((Number) u.first(set)).longValue()).G(new WidgetVoiceCallIncoming$Model$Companion$get$1$1(set));
    }
}
