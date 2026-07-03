package com.discord.utilities.views.viewstub;

import android.view.View;
import android.view.ViewStub;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: LazyViewStubDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyViewStubDelegate$viewField$1 extends AbstractC12240o implements Function0<View> {
    public final /* synthetic */ ViewStub $stub;
    public final /* synthetic */ LazyViewStubDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyViewStubDelegate$viewField$1(LazyViewStubDelegate lazyViewStubDelegate, ViewStub viewStub) {
        super(0);
        this.this$0 = lazyViewStubDelegate;
        this.$stub = viewStub;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final View invoke() {
        View viewInflate = this.$stub.inflate();
        viewInflate.setOnClickListener(this.this$0.listener);
        return viewInflate;
    }
}
