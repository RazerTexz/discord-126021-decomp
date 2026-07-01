package com.discord.widgets.auth;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthMfa.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthMfa$tryPasteCodeFromClipboard$2 extends k implements Function1<String, Unit> {
    public WidgetAuthMfa$tryPasteCodeFromClipboard$2(WidgetAuthMfa widgetAuthMfa) {
        super(1, widgetAuthMfa, WidgetAuthMfa.class, "evaluateCode", "evaluateCode(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "p1");
        WidgetAuthMfa.access$evaluateCode((WidgetAuthMfa) this.receiver, str);
    }
}
