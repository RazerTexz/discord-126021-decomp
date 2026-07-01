package com.discord.widgets.hubs;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthentication$onViewBound$1 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetHubAuthentication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAuthentication$onViewBound$1(WidgetHubAuthentication widgetHubAuthentication) {
        super(1);
        this.this$0 = widgetHubAuthentication;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
        WidgetHubAuthentication.access$getViewModel$p(this.this$0).verifyCode(str);
    }
}
