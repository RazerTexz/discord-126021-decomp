package com.discord.widgets.tos;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetTos.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTos$isAcknowledgement$2 extends o implements Function0<Boolean> {
    public final /* synthetic */ WidgetTos this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetTos$isAcknowledgement$2(WidgetTos widgetTos) {
        super(0);
        this.this$0 = widgetTos;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return this.this$0.getMostRecentIntent().getBooleanExtra("intent_args_key", false);
    }
}
