package com.discord.widgets.channels;

import android.animation.ObjectAnimator;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopic$onToggleTopicExpansionState$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetChannelTopic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelTopic$onToggleTopicExpansionState$1(WidgetChannelTopic widgetChannelTopic) {
        super(1);
        this.this$0 = widgetChannelTopic;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(WidgetChannelTopic.access$getBinding$p(this.this$0).g, "maxLines", i);
        m.checkNotNullExpressionValue(objectAnimatorOfInt, "animation");
        objectAnimatorOfInt.setDuration(150L);
        objectAnimatorOfInt.addListener(new WidgetChannelTopic$onToggleTopicExpansionState$1$animateMaxLines$$inlined$doOnEnd$1(this));
        objectAnimatorOfInt.start();
    }
}
