package com.discord.utilities.views.viewstub;

import android.view.View;
import android.view.ViewStub;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.views.viewstub.LazyViewStubDelegate$viewField$1, reason: use source file name */
/* JADX INFO: compiled from: LazyViewStubDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyViewStubDelegate3 extends Lambda implements Function0<View> {
    public final /* synthetic */ ViewStub $stub;
    public final /* synthetic */ LazyViewStubDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyViewStubDelegate3(LazyViewStubDelegate lazyViewStubDelegate, ViewStub viewStub) {
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
