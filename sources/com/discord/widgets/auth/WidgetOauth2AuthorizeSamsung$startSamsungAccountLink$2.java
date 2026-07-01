package com.discord.widgets.auth;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2AuthorizeSamsung$startSamsungAccountLink$2 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ String $samsungAuthCode;
    public final /* synthetic */ WidgetOauth2AuthorizeSamsung this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2AuthorizeSamsung$startSamsungAccountLink$2(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung, String str) {
        super(1);
        this.this$0 = widgetOauth2AuthorizeSamsung;
        this.$samsungAuthCode = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r3) {
        WidgetOauth2AuthorizeSamsung.access$authorizeForSamsung(this.this$0, this.$samsungAuthCode, null);
    }
}
