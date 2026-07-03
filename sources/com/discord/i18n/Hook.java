package com.discord.i18n;

import android.view.View;
import androidx.annotation.ColorInt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p027k.C1108c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Hook.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Hook {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final List<Object> styles = new ArrayList();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public CharSequence replacementText;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public C5524a clickHandler;

    /* JADX INFO: renamed from: com.discord.i18n.Hook$a */
    /* JADX INFO: compiled from: Hook.kt */
    public static final class C5524a {

        /* JADX INFO: renamed from: a */
        @ColorInt
        public Integer f18546a;

        /* JADX INFO: renamed from: b */
        public Function2<? super String, ? super View, Unit> f18547b;

        public C5524a(@ColorInt Integer num, Function2<? super String, ? super View, Unit> function2) {
            C12238m.checkNotNullParameter(function2, "onClick");
            this.f18547b = C1108c.f1497j;
            this.f18546a = num;
            this.f18547b = function2;
        }
    }
}
