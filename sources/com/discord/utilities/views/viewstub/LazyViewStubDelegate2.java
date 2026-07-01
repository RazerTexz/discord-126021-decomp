package com.discord.utilities.views.viewstub;

import android.view.ViewStub;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.views.viewstub.LazyViewStubDelegate$Companion$lazyViewStub$1, reason: use source file name */
/* JADX INFO: compiled from: LazyViewStubDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyViewStubDelegate2 extends Lambda implements Function0<LazyViewStubDelegate> {
    public final /* synthetic */ Function0 $getViewStub;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyViewStubDelegate2(Function0 function0) {
        super(0);
        this.$getViewStub = function0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final LazyViewStubDelegate invoke() {
        return new LazyViewStubDelegate((ViewStub) this.$getViewStub.invoke(), null);
    }
}
