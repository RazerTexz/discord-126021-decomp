package b.a.k;

import android.view.View;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: b.a.k.c, reason: use source file name */
/* JADX INFO: compiled from: Hook.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Hook2 extends Lambda implements Function2<String, View, Unit> {
    public static final Hook2 j = new Hook2();

    public Hook2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(String str, View view) {
        Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 1>");
        return Unit.a;
    }
}
