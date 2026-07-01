package com.discord.widgets.settings.premium;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGifting$handleGiftPurchaseEvent$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetSettingsGifting this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGifting$handleGiftPurchaseEvent$1(WidgetSettingsGifting widgetSettingsGifting) {
        super(0);
        this.this$0 = widgetSettingsGifting;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.requireAppActivity().setResult(-1);
    }
}
