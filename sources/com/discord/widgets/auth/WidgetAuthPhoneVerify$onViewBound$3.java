package com.discord.widgets.auth;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthPhoneVerify$onViewBound$3 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetAuthPhoneVerify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthPhoneVerify$onViewBound$3(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
        super(1);
        this.this$0 = widgetAuthPhoneVerify;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
        WidgetAuthPhoneVerify.access$evaluateCode(this.this$0, str);
    }
}
