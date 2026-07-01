package com.discord.utilities.views.viewstub;

import android.view.ViewStub;
import d0.g;
import d0.i;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LazyViewStubDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyViewStubDelegate$Companion {
    private LazyViewStubDelegate$Companion() {
    }

    public final Lazy<LazyViewStubDelegate> lazyViewStub(Function0<ViewStub> getViewStub) {
        m.checkNotNullParameter(getViewStub, "getViewStub");
        return g.lazy(i.NONE, new LazyViewStubDelegate$Companion$lazyViewStub$1(getViewStub));
    }

    public /* synthetic */ LazyViewStubDelegate$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
