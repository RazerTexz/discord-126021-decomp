package com.discord.utilities.views.viewstub;

import android.view.ViewStub;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: LazyViewStubDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyViewStubDelegate$Companion$lazyViewStub$1 extends AbstractC12240o implements Function0<LazyViewStubDelegate> {
    public final /* synthetic */ Function0 $getViewStub;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyViewStubDelegate$Companion$lazyViewStub$1(Function0 function0) {
        super(0);
        this.$getViewStub = function0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final LazyViewStubDelegate invoke() {
        return new LazyViewStubDelegate((ViewStub) this.$getViewStub.invoke(), null);
    }
}
