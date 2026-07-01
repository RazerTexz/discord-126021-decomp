package com.discord.widgets.settings.premium;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetOutboundPromoTerms$renderContext$1$onLongPressUrl$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetOutboundPromoTerms.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOutboundPromoTerms5 extends Lambda implements Function1<String, Unit> {
    public static final WidgetOutboundPromoTerms5 INSTANCE = new WidgetOutboundPromoTerms5();

    public WidgetOutboundPromoTerms5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "it");
    }
}
