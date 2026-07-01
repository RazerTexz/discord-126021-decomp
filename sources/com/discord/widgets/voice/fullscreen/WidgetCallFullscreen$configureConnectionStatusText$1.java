package com.discord.widgets.voice.fullscreen;

import android.widget.TextView;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$configureConnectionStatusText$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ CallModel $callModel;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$configureConnectionStatusText$1(WidgetCallFullscreen widgetCallFullscreen, CallModel callModel) {
        super(1);
        this.this$0 = widgetCallFullscreen;
        this.$callModel = callModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        TextView textView = WidgetCallFullscreen.access$getBinding$p(this.this$0).f2246s.g;
        m.checkNotNullExpressionValue(textView, "binding.privateCall.privateCallStatusDuration");
        textView.setText(TimeUtils.toFriendlyString$default(TimeUtils.INSTANCE, this.$callModel.getTimeConnectedMs(), 0L, null, null, 14, null));
    }
}
