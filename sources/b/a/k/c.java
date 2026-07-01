package b.a.k;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Hook.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c extends o implements Function2<String, View, Unit> {
    public static final c j = new c();

    public c() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(String str, View view) {
        m.checkNotNullParameter(str, "<anonymous parameter 0>");
        m.checkNotNullParameter(view, "<anonymous parameter 1>");
        return Unit.a;
    }
}
