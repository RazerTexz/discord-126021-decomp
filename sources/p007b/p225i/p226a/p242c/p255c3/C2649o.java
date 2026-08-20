package p007b.p225i.p226a.p242c.p255c3;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.InterfaceC2963w0;
import p007b.p225i.p226a.p242c.p243a3.C2556n0;
import p007b.p225i.p226a.p242c.p259f3.C2739f;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractC4493a;
import p007b.p225i.p355b.p357b.AbstractC4519n;
import p007b.p225i.p355b.p357b.AbstractC4523p;
import p007b.p225i.p355b.p357b.AbstractC4525q;
import p007b.p225i.p355b.p357b.C4508h0;
import p007b.p225i.p355b.p357b.C4510i0;
import p007b.p225i.p355b.p358c.C4538a;

/* JADX INFO: renamed from: b.i.a.c.c3.o */
/* JADX INFO: compiled from: TrackSelectionOverrides.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2649o implements InterfaceC2963w0 {

    /* JADX INFO: renamed from: j */
    public static final C2649o f6270j = new C2649o(C4510i0.f12015m);

    /* JADX INFO: renamed from: k */
    public static final InterfaceC2963w0.a<C2649o> f6271k = new InterfaceC2963w0.a() { // from class: b.i.a.c.c3.d
        @Override // p007b.p225i.p226a.p242c.InterfaceC2963w0.a
        /* JADX INFO: renamed from: a */
        public final InterfaceC2963w0 mo2576a(Bundle bundle) {
            C2649o c2649o = C2649o.f6270j;
            int i = C2649o.a.f6273j;
            C2639e c2639e = new InterfaceC2963w0.a() { // from class: b.i.a.c.c3.e
                @Override // p007b.p225i.p226a.p242c.InterfaceC2963w0.a
                /* JADX INFO: renamed from: a */
                public final InterfaceC2963w0 mo2576a(Bundle bundle2) {
                    int i2 = C2649o.a.f6273j;
                    Bundle bundle3 = bundle2.getBundle(Integer.toString(0, 36));
                    Objects.requireNonNull(bundle3);
                    int i3 = C2556n0.f5660j;
                    InterfaceC2963w0.a<C2811j1> aVar = C2811j1.f7126k;
                    ArrayList parcelableArrayList = bundle3.getParcelableArrayList(Integer.toString(0, 36));
                    AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
                    C2556n0 c2556n0 = new C2556n0((C2811j1[]) C2739f.m3020b(aVar, parcelableArrayList, C4508h0.f12012l).toArray(new C2811j1[0]));
                    int[] intArray = bundle2.getIntArray(Integer.toString(1, 36));
                    if (intArray == null) {
                        return new C2649o.a(c2556n0);
                    }
                    return new C2649o.a(c2556n0, intArray.length == 0 ? Collections.emptyList() : new C4538a(intArray));
                }
            };
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(Integer.toString(0, 36));
            AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
            List listM3020b = C2739f.m3020b(c2639e, parcelableArrayList, C4508h0.f12012l);
            AbstractC4525q.a aVar = new AbstractC4525q.a(4);
            for (int i2 = 0; i2 < listM3020b.size(); i2++) {
                C2649o.a aVar2 = (C2649o.a) listM3020b.get(i2);
                aVar.m6277c(aVar2.f6274k, aVar2);
            }
            return new C2649o(aVar.m6275a());
        }
    };

    /* JADX INFO: renamed from: l */
    public final AbstractC4525q<C2556n0, a> f6272l;

    public C2649o(Map<C2556n0, a> map) {
        this.f6272l = AbstractC4525q.m6273a(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2649o.class != obj.getClass()) {
            return false;
        }
        return this.f6272l.equals(((C2649o) obj).f6272l);
    }

    public int hashCode() {
        return this.f6272l.hashCode();
    }

    /* JADX INFO: renamed from: b.i.a.c.c3.o$a */
    /* JADX INFO: compiled from: TrackSelectionOverrides.java */
    public static final class a implements InterfaceC2963w0 {

        /* JADX INFO: renamed from: j */
        public static final /* synthetic */ int f6273j = 0;

        /* JADX INFO: renamed from: k */
        public final C2556n0 f6274k;

        /* JADX INFO: renamed from: l */
        public final AbstractC4523p<Integer> f6275l;

        public a(C2556n0 c2556n0) {
            this.f6274k = c2556n0;
            C3404f.m4189A(4, "initialCapacity");
            Object[] objArrCopyOf = new Object[4];
            int i = 0;
            int i2 = 0;
            while (i < c2556n0.f5661k) {
                Integer numValueOf = Integer.valueOf(i);
                Objects.requireNonNull(numValueOf);
                int i3 = i2 + 1;
                if (objArrCopyOf.length < i3) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, AbstractC4519n.b.m6260a(objArrCopyOf.length, i3));
                }
                objArrCopyOf[i2] = numValueOf;
                i++;
                i2 = i3;
            }
            this.f6275l = AbstractC4523p.m6262l(objArrCopyOf, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f6274k.equals(aVar.f6274k) && this.f6275l.equals(aVar.f6275l);
        }

        public int hashCode() {
            return (this.f6275l.hashCode() * 31) + this.f6274k.hashCode();
        }

        public a(C2556n0 c2556n0, List<Integer> list) {
            if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= c2556n0.f5661k)) {
                throw new IndexOutOfBoundsException();
            }
            this.f6274k = c2556n0;
            this.f6275l = AbstractC4523p.m6264n(list);
        }
    }
}
