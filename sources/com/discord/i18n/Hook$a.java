package com.discord.i18n;

import android.view.View;
import androidx.annotation.ColorInt;
import b.a.k.c;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Hook.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Hook$a {

    @ColorInt
    public Integer a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super String, ? super View, Unit> f2709b;

    public Hook$a(@ColorInt Integer num, Function2<? super String, ? super View, Unit> function2) {
        m.checkNotNullParameter(function2, "onClick");
        this.f2709b = c.j;
        this.a = num;
        this.f2709b = function2;
    }
}
