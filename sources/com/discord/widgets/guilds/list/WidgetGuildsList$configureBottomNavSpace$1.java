package com.discord.widgets.guilds.list;

import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewStub;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsList$configureBottomNavSpace$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetGuildsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildsList$configureBottomNavSpace$1(WidgetGuildsList widgetGuildsList) {
        super(1);
        this.this$0 = widgetGuildsList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        WidgetGuildsList.access$getAdapter$p(this.this$0).handleBottomNavHeight(i);
        ViewStub viewStub = WidgetGuildsList.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(viewStub, "binding.guildListUnreadsStub");
        ViewGroup$LayoutParams layoutParams = viewStub.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams;
        viewGroup$MarginLayoutParams.setMargins(viewGroup$MarginLayoutParams.leftMargin, viewGroup$MarginLayoutParams.topMargin, viewGroup$MarginLayoutParams.rightMargin, i);
        ViewStub viewStub2 = WidgetGuildsList.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(viewStub2, "binding.guildListUnreadsStub");
        viewStub2.setLayoutParams(viewGroup$MarginLayoutParams);
    }
}
