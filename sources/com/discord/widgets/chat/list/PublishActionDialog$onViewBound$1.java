package com.discord.widgets.chat.list;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: PublishActionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublishActionDialog$onViewBound$1 extends o implements Function0<Unit> {
    public final /* synthetic */ PublishActionDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishActionDialog$onViewBound$1(PublishActionDialog publishActionDialog) {
        super(0);
        this.this$0 = publishActionDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.dismiss();
    }
}
