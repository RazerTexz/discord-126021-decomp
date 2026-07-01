package com.discord.widgets.settings.premium;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium$showContent$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ Integer $scrollTargetSection;
    public final /* synthetic */ WidgetSettingsPremium this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPremium$showContent$1(WidgetSettingsPremium widgetSettingsPremium, Integer num) {
        super(1);
        this.this$0 = widgetSettingsPremium;
        this.$scrollTargetSection = num;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        WidgetSettingsPremium.access$scrollToSection(this.this$0, this.$scrollTargetSection);
    }
}
