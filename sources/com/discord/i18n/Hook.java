package com.discord.i18n;

import android.view.View;
import androidx.annotation.ColorInt;
import b.a.k.Hook2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Hook.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Hook {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final List<Object> styles = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public CharSequence replacementText;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public a clickHandler;

    /* JADX INFO: compiled from: Hook.kt */
    public static final class a {

        @ColorInt
        public Integer a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function2<? super String, ? super View, Unit> f2709b;

        public a(@ColorInt Integer num, Function2<? super String, ? super View, Unit> function2) {
            Intrinsics3.checkNotNullParameter(function2, "onClick");
            this.f2709b = Hook2.j;
            this.a = num;
            this.f2709b = function2;
        }
    }
}
