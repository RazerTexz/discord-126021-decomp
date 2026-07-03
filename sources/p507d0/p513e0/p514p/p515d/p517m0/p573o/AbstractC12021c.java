package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.c */
/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12021c {

    /* JADX INFO: renamed from: a */
    public final boolean f24900a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.c$a */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a extends AbstractC12021c {

        /* JADX INFO: renamed from: b */
        public static final a f24901b = new a();

        public a() {
            super(false, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.c$b */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class b extends AbstractC12021c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(false, null);
            C12238m.checkNotNullParameter(str, "error");
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.c$c */
    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class c extends AbstractC12021c {

        /* JADX INFO: renamed from: b */
        public static final c f24902b = new c();

        public c() {
            super(true, null);
        }
    }

    public AbstractC12021c(boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24900a = z2;
    }

    public final boolean isSuccess() {
        return this.f24900a;
    }
}
