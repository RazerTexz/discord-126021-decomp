package com.discord.widgets.botuikit;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ModalComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModalComponent$onViewBound$2$2 extends o implements Function1<String, Unit> {
    public final /* synthetic */ ModalComponent$onViewBound$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalComponent$onViewBound$2$2(ModalComponent$onViewBound$2 modalComponent$onViewBound$2) {
        super(1);
        this.this$0 = modalComponent$onViewBound$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "nonce");
        ModalComponent.access$setSentNonce$p(this.this$0.this$0, str);
    }
}
