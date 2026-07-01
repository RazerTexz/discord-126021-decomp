package com.discord.views.steps;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StepsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StepsView$b {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2843b;
    public final int c;
    public final Function1<View, Unit> d;
    public final Function1<View, Unit> e;
    public final Function1<View, Unit> f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public StepsView$b(int i, int i2, int i3, Function1 function1, Function1 function2, Function1 function3, boolean z2, boolean z3, boolean z4, DefaultConstructorMarker defaultConstructorMarker) {
        this.a = i;
        this.f2843b = i2;
        this.c = i3;
        this.d = function1;
        this.e = function2;
        this.f = function3;
        this.g = z2;
        this.h = z3;
        this.i = z4;
    }
}
