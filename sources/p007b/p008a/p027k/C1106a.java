package p007b.p008a.p027k;

import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p027k.p030g.AbstractC1116b;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.k.a */
/* JADX INFO: compiled from: Format.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1106a {

    /* JADX INFO: renamed from: a */
    public static AbstractC1116b f1483a;

    /* JADX INFO: renamed from: b */
    public static Function0<Integer> f1484b = a.f1487j;

    /* JADX INFO: renamed from: c */
    public static Function2<? super String, ? super View, Unit> f1485c = b.f1488j;

    /* JADX INFO: renamed from: d */
    public static final C1106a f1486d = null;

    /* JADX INFO: renamed from: b.a.k.a$a */
    /* JADX INFO: compiled from: Format.kt */
    public static final class a extends AbstractC12240o implements Function0<Integer> {

        /* JADX INFO: renamed from: j */
        public static final a f1487j = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    /* JADX INFO: renamed from: b.a.k.a$b */
    /* JADX INFO: compiled from: Format.kt */
    public static final class b extends AbstractC12240o implements Function2<String, View, Unit> {

        /* JADX INFO: renamed from: j */
        public static final b f1488j = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(String str, View view) {
            C12238m.checkNotNullParameter(str, "<anonymous parameter 0>");
            C12238m.checkNotNullParameter(view, "<anonymous parameter 1>");
            return Unit.f27425a;
        }
    }
}
