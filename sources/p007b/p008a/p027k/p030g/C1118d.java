package p007b.p008a.p027k.p030g;

import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.k.g.d */
/* JADX INFO: compiled from: FormattingParserProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1118d extends AbstractC1116b {

    /* JADX INFO: renamed from: a */
    public static final Lazy f1503a = C12083g.lazy(a.f1506j);

    /* JADX INFO: renamed from: b */
    public static final C1118d f1504b = null;

    /* JADX INFO: renamed from: c */
    public final ThreadLocal<C1115a> f1505c = new b();

    /* JADX INFO: renamed from: b.a.k.g.d$a */
    /* JADX INFO: compiled from: FormattingParserProvider.kt */
    public static final class a extends AbstractC12240o implements Function0<C1118d> {

        /* JADX INFO: renamed from: j */
        public static final a f1506j = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public C1118d invoke() {
            return new C1118d();
        }
    }

    /* JADX INFO: renamed from: b.a.k.g.d$b */
    /* JADX INFO: compiled from: FormattingParserProvider.kt */
    public static final class b extends ThreadLocal<C1115a> {
        @Override // java.lang.ThreadLocal
        public C1115a initialValue() {
            return new C1115a();
        }
    }

    @Override // p007b.p008a.p027k.p030g.AbstractC1116b
    /* JADX INFO: renamed from: a */
    public C1115a mo224a() {
        C1115a c1115a = this.f1505c.get();
        C12238m.checkNotNull(c1115a);
        return c1115a;
    }
}
