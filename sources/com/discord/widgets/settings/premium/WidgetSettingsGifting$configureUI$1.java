package com.discord.widgets.settings.premium;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGifting$configureUI$1 extends o implements Function2<Long, Long, Unit> {
    public final /* synthetic */ WidgetSettingsGifting this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGifting$configureUI$1(WidgetSettingsGifting widgetSettingsGifting) {
        super(2);
        this.this$0 = widgetSettingsGifting;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
        invoke(l.longValue(), l2);
        return Unit.a;
    }

    public final void invoke(long j, Long l) {
        WidgetSettingsGifting.access$getViewModel$p(this.this$0).handleSkuClicked(j, l);
    }
}
