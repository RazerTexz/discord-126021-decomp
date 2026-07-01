package com.discord.views;

import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PileView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PileView$c {
    public final Function1<Integer, String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f2835b;

    /* JADX WARN: Multi-variable type inference failed */
    public PileView$c(Function1<? super Integer, String> function1, Function0<String> function0) {
        m.checkNotNullParameter(function1, "getImageURI");
        this.a = function1;
        this.f2835b = function0;
    }
}
