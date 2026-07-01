package com.discord.widgets.channels.list;

import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewStub;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$configureBottomNavSpace$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetChannelsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsList$configureBottomNavSpace$1(WidgetChannelsList widgetChannelsList) {
        super(1);
        this.this$0 = widgetChannelsList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        WidgetChannelsList.access$getAdapter$p(this.this$0).handleBottomNavHeight(i);
        ViewStub viewStub = WidgetChannelsList.access$getBinding$p(this.this$0).m;
        m.checkNotNullExpressionValue(viewStub, "binding.channelsListUnreadsStub");
        ViewGroup$LayoutParams layoutParams = viewStub.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams;
        viewGroup$MarginLayoutParams.setMargins(viewGroup$MarginLayoutParams.leftMargin, viewGroup$MarginLayoutParams.topMargin, viewGroup$MarginLayoutParams.rightMargin, i);
        ViewStub viewStub2 = WidgetChannelsList.access$getBinding$p(this.this$0).m;
        m.checkNotNullExpressionValue(viewStub2, "binding.channelsListUnreadsStub");
        viewStub2.setLayoutParams(viewGroup$MarginLayoutParams);
    }
}
