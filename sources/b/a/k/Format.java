package b.a.k;

import android.view.View;
import androidx.core.view.ViewCompat;
import b.a.k.g.FormattingParserProvider;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: b.a.k.a, reason: use source file name */
/* JADX INFO: compiled from: Format.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Format {
    public static FormattingParserProvider a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Function0<Integer> f245b = a.j;
    public static Function2<? super String, ? super View, Unit> c = b.j;
    public static final Format d = null;

    /* JADX INFO: renamed from: b.a.k.a$a */
    /* JADX INFO: compiled from: Format.kt */
    public static final class a extends Lambda implements Function0<Integer> {
        public static final a j = new a();

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
    public static final class b extends Lambda implements Function2<String, View, Unit> {
        public static final b j = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(String str, View view) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 1>");
            return Unit.a;
        }
    }
}
