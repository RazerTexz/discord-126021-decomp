package com.discord.utilities.views.viewstub;

import android.view.View;
import android.view.ViewStub;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyViewStubDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyViewStubDelegate$viewField$1 extends o implements Function0<View> {
    public final /* synthetic */ ViewStub $stub;
    public final /* synthetic */ LazyViewStubDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyViewStubDelegate$viewField$1(LazyViewStubDelegate lazyViewStubDelegate, ViewStub viewStub) {
        super(0);
        this.this$0 = lazyViewStubDelegate;
        this.$stub = viewStub;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ View invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final View invoke() {
        View viewInflate = this.$stub.inflate();
        viewInflate.setOnClickListener(LazyViewStubDelegate.access$getListener$p(this.this$0));
        return viewInflate;
    }
}
