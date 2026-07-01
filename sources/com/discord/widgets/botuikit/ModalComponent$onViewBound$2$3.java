package com.discord.widgets.botuikit;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ModalComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModalComponent$onViewBound$2$3 extends o implements Function0<Unit> {
    public final /* synthetic */ ModalComponent$onViewBound$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalComponent$onViewBound$2$3(ModalComponent$onViewBound$2 modalComponent$onViewBound$2) {
        super(0);
        this.this$0 = modalComponent$onViewBound$2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.$view.post(new ModalComponent$onViewBound$2$3$1(this));
    }
}
