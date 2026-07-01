package com.discord.widgets.auth;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthMfa.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthMfa$tryPasteCodeFromClipboard$3 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetAuthMfa this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthMfa$tryPasteCodeFromClipboard$3(WidgetAuthMfa widgetAuthMfa) {
        super(1);
        this.this$0 = widgetAuthMfa;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        WidgetAuthMfa widgetAuthMfa = this.this$0;
        WidgetAuthMfa.access$evaluateCode(widgetAuthMfa, WidgetAuthMfa.access$getBinding$p(widgetAuthMfa).f2234b.getCom.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String());
    }
}
