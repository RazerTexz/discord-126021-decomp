package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2239h;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.u.i0 */
/* JADX INFO: compiled from: StdArraySerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2289i0 {

    /* JADX INFO: renamed from: a */
    public static final HashMap<String, AbstractC2364n<?>> f4855a;

    /* JADX INFO: renamed from: b.g.a.c.g0.u.i0$a */
    /* JADX INFO: compiled from: StdArraySerializers.java */
    @InterfaceC2375a
    public static class a extends AbstractC2272a<boolean[]> {
        static {
            C2335n.f4925k.m2168j(Boolean.class);
        }

        public a() {
            super(boolean[].class);
        }

        @Override // p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: d */
        public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
            return ((boolean[]) obj).length == 0;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a, p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            boolean[] zArr = (boolean[]) obj;
            int length = zArr.length;
            if (length == 1 && m2044r(abstractC2374x)) {
                m2061u(zArr, abstractC2108d);
                return;
            }
            abstractC2108d.mo1649b0(zArr, length);
            m2061u(zArr, abstractC2108d);
            abstractC2108d.mo1663t();
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
        /* JADX INFO: renamed from: p */
        public AbstractC2239h<?> mo1995p(AbstractC2215g abstractC2215g) {
            return this;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
        /* JADX INFO: renamed from: q */
        public boolean mo1996q(Object obj) {
            return ((boolean[]) obj).length == 1;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a
        /* JADX INFO: renamed from: s */
        public AbstractC2364n<?> mo2037s(InterfaceC2206d interfaceC2206d, Boolean bool) {
            return new a(this, interfaceC2206d, bool);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a
        /* JADX INFO: renamed from: t */
        public /* bridge */ /* synthetic */ void mo2038t(boolean[] zArr, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            m2061u(zArr, abstractC2108d);
        }

        /* JADX INFO: renamed from: u */
        public void m2061u(boolean[] zArr, AbstractC2108d abstractC2108d) throws IOException {
            for (boolean z2 : zArr) {
                abstractC2108d.mo1662s(z2);
            }
        }

        public a(a aVar, InterfaceC2206d interfaceC2206d, Boolean bool) {
            super(aVar, interfaceC2206d, bool);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.i0$b */
    /* JADX INFO: compiled from: StdArraySerializers.java */
    @InterfaceC2375a
    public static class b extends AbstractC2305q0<char[]> {
        public b() {
            super(char[].class);
        }

        @Override // p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: d */
        public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
            return ((char[]) obj).length == 0;
        }

        @Override // p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            char[] cArr = (char[]) obj;
            if (!abstractC2374x.m2240D(EnumC2373w.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                abstractC2108d.mo1659m0(cArr, 0, cArr.length);
                return;
            }
            abstractC2108d.mo1649b0(cArr, cArr.length);
            int length = cArr.length;
            for (int i = 0; i < length; i++) {
                abstractC2108d.mo1659m0(cArr, i, 1);
            }
            abstractC2108d.mo1663t();
        }

        @Override // p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: g */
        public void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
            C2138b c2138bMo1959e;
            char[] cArr = (char[]) obj;
            if (abstractC2374x.m2240D(EnumC2373w.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                c2138bMo1959e = abstractC2215g.mo1959e(abstractC2108d, abstractC2215g.m1958d(cArr, EnumC2112h.START_ARRAY));
                int length = cArr.length;
                for (int i = 0; i < length; i++) {
                    abstractC2108d.mo1659m0(cArr, i, 1);
                }
            } else {
                c2138bMo1959e = abstractC2215g.mo1959e(abstractC2108d, abstractC2215g.m1958d(cArr, EnumC2112h.VALUE_STRING));
                abstractC2108d.mo1659m0(cArr, 0, cArr.length);
            }
            abstractC2215g.mo1960f(abstractC2108d, c2138bMo1959e);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.i0$c */
    /* JADX INFO: compiled from: StdArraySerializers.java */
    @InterfaceC2375a
    public static class c extends AbstractC2272a<double[]> {
        static {
            C2335n.f4925k.m2168j(Double.TYPE);
        }

        public c() {
            super(double[].class);
        }

        @Override // p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: d */
        public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
            return ((double[]) obj).length == 0;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a, p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            double[] dArr = (double[]) obj;
            int i = 0;
            if (dArr.length == 1 && m2044r(abstractC2374x)) {
                int length = dArr.length;
                while (i < length) {
                    abstractC2108d.mo1632C(dArr[i]);
                    i++;
                }
                return;
            }
            int length2 = dArr.length;
            Objects.requireNonNull(abstractC2108d);
            abstractC2108d.m1647a(dArr.length, 0, length2);
            abstractC2108d.mo1649b0(dArr, length2);
            int i2 = length2 + 0;
            while (i < i2) {
                abstractC2108d.mo1632C(dArr[i]);
                i++;
            }
            abstractC2108d.mo1663t();
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
        /* JADX INFO: renamed from: p */
        public AbstractC2239h<?> mo1995p(AbstractC2215g abstractC2215g) {
            return this;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
        /* JADX INFO: renamed from: q */
        public boolean mo1996q(Object obj) {
            return ((double[]) obj).length == 1;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a
        /* JADX INFO: renamed from: s */
        public AbstractC2364n<?> mo2037s(InterfaceC2206d interfaceC2206d, Boolean bool) {
            return new c(this, interfaceC2206d, bool);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a
        /* JADX INFO: renamed from: t */
        public void mo2038t(double[] dArr, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            for (double d : dArr) {
                abstractC2108d.mo1632C(d);
            }
        }

        public c(c cVar, InterfaceC2206d interfaceC2206d, Boolean bool) {
            super(cVar, interfaceC2206d, bool);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.i0$d */
    /* JADX INFO: compiled from: StdArraySerializers.java */
    @InterfaceC2375a
    public static class d extends h<float[]> {
        static {
            C2335n.f4925k.m2168j(Float.TYPE);
        }

        public d() {
            super(float[].class);
        }

        @Override // p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: d */
        public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
            return ((float[]) obj).length == 0;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a, p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            float[] fArr = (float[]) obj;
            int length = fArr.length;
            if (length == 1 && m2044r(abstractC2374x)) {
                m2062u(fArr, abstractC2108d);
                return;
            }
            abstractC2108d.mo1649b0(fArr, length);
            m2062u(fArr, abstractC2108d);
            abstractC2108d.mo1663t();
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
        /* JADX INFO: renamed from: q */
        public boolean mo1996q(Object obj) {
            return ((float[]) obj).length == 1;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a
        /* JADX INFO: renamed from: s */
        public AbstractC2364n<?> mo2037s(InterfaceC2206d interfaceC2206d, Boolean bool) {
            return new d(this, interfaceC2206d, bool);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a
        /* JADX INFO: renamed from: t */
        public /* bridge */ /* synthetic */ void mo2038t(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            m2062u((float[]) obj, abstractC2108d);
        }

        /* JADX INFO: renamed from: u */
        public void m2062u(float[] fArr, AbstractC2108d abstractC2108d) throws IOException {
            for (float f : fArr) {
                abstractC2108d.mo1633D(f);
            }
        }

        public d(d dVar, InterfaceC2206d interfaceC2206d, Boolean bool) {
            super(dVar, interfaceC2206d, bool);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.i0$e */
    /* JADX INFO: compiled from: StdArraySerializers.java */
    @InterfaceC2375a
    public static class e extends AbstractC2272a<int[]> {
        static {
            C2335n.f4925k.m2168j(Integer.TYPE);
        }

        public e() {
            super(int[].class);
        }

        @Override // p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: d */
        public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
            return ((int[]) obj).length == 0;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a, p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            int[] iArr = (int[]) obj;
            int i = 0;
            if (iArr.length == 1 && m2044r(abstractC2374x)) {
                int length = iArr.length;
                while (i < length) {
                    abstractC2108d.mo1634H(iArr[i]);
                    i++;
                }
                return;
            }
            int length2 = iArr.length;
            Objects.requireNonNull(abstractC2108d);
            abstractC2108d.m1647a(iArr.length, 0, length2);
            abstractC2108d.mo1649b0(iArr, length2);
            int i2 = length2 + 0;
            while (i < i2) {
                abstractC2108d.mo1634H(iArr[i]);
                i++;
            }
            abstractC2108d.mo1663t();
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
        /* JADX INFO: renamed from: p */
        public AbstractC2239h<?> mo1995p(AbstractC2215g abstractC2215g) {
            return this;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
        /* JADX INFO: renamed from: q */
        public boolean mo1996q(Object obj) {
            return ((int[]) obj).length == 1;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a
        /* JADX INFO: renamed from: s */
        public AbstractC2364n<?> mo2037s(InterfaceC2206d interfaceC2206d, Boolean bool) {
            return new e(this, interfaceC2206d, bool);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a
        /* JADX INFO: renamed from: t */
        public void mo2038t(int[] iArr, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            for (int i : iArr) {
                abstractC2108d.mo1634H(i);
            }
        }

        public e(e eVar, InterfaceC2206d interfaceC2206d, Boolean bool) {
            super(eVar, interfaceC2206d, bool);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.i0$f */
    /* JADX INFO: compiled from: StdArraySerializers.java */
    @InterfaceC2375a
    public static class f extends h<long[]> {
        static {
            C2335n.f4925k.m2168j(Long.TYPE);
        }

        public f() {
            super(long[].class);
        }

        @Override // p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: d */
        public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
            return ((long[]) obj).length == 0;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a, p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            long[] jArr = (long[]) obj;
            int i = 0;
            if (jArr.length == 1 && m2044r(abstractC2374x)) {
                int length = jArr.length;
                while (i < length) {
                    abstractC2108d.mo1635I(jArr[i]);
                    i++;
                }
                return;
            }
            int length2 = jArr.length;
            Objects.requireNonNull(abstractC2108d);
            abstractC2108d.m1647a(jArr.length, 0, length2);
            abstractC2108d.mo1649b0(jArr, length2);
            int i2 = length2 + 0;
            while (i < i2) {
                abstractC2108d.mo1635I(jArr[i]);
                i++;
            }
            abstractC2108d.mo1663t();
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
        /* JADX INFO: renamed from: q */
        public boolean mo1996q(Object obj) {
            return ((long[]) obj).length == 1;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a
        /* JADX INFO: renamed from: s */
        public AbstractC2364n<?> mo2037s(InterfaceC2206d interfaceC2206d, Boolean bool) {
            return new f(this, interfaceC2206d, bool);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a
        /* JADX INFO: renamed from: t */
        public void mo2038t(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            for (long j : (long[]) obj) {
                abstractC2108d.mo1635I(j);
            }
        }

        public f(f fVar, InterfaceC2206d interfaceC2206d, Boolean bool) {
            super(fVar, interfaceC2206d, bool);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.i0$g */
    /* JADX INFO: compiled from: StdArraySerializers.java */
    @InterfaceC2375a
    public static class g extends h<short[]> {
        static {
            C2335n.f4925k.m2168j(Short.TYPE);
        }

        public g() {
            super(short[].class);
        }

        @Override // p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: d */
        public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
            return ((short[]) obj).length == 0;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a, p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            short[] sArr = (short[]) obj;
            int length = sArr.length;
            if (length == 1 && m2044r(abstractC2374x)) {
                m2063u(sArr, abstractC2108d);
                return;
            }
            abstractC2108d.mo1649b0(sArr, length);
            m2063u(sArr, abstractC2108d);
            abstractC2108d.mo1663t();
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
        /* JADX INFO: renamed from: q */
        public boolean mo1996q(Object obj) {
            return ((short[]) obj).length == 1;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a
        /* JADX INFO: renamed from: s */
        public AbstractC2364n<?> mo2037s(InterfaceC2206d interfaceC2206d, Boolean bool) {
            return new g(this, interfaceC2206d, bool);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2272a
        /* JADX INFO: renamed from: t */
        public /* bridge */ /* synthetic */ void mo2038t(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            m2063u((short[]) obj, abstractC2108d);
        }

        /* JADX INFO: renamed from: u */
        public void m2063u(short[] sArr, AbstractC2108d abstractC2108d) throws IOException {
            for (short s2 : sArr) {
                abstractC2108d.mo1634H(s2);
            }
        }

        public g(g gVar, InterfaceC2206d interfaceC2206d, Boolean bool) {
            super(gVar, interfaceC2206d, bool);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.i0$h */
    /* JADX INFO: compiled from: StdArraySerializers.java */
    public static abstract class h<T> extends AbstractC2272a<T> {
        public h(Class<T> cls) {
            super(cls);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
        /* JADX INFO: renamed from: p */
        public final AbstractC2239h<?> mo1995p(AbstractC2215g abstractC2215g) {
            return this;
        }

        public h(h<T> hVar, InterfaceC2206d interfaceC2206d, Boolean bool) {
            super(hVar, interfaceC2206d, bool);
        }
    }

    static {
        HashMap<String, AbstractC2364n<?>> map = new HashMap<>();
        f4855a = map;
        map.put(boolean[].class.getName(), new a());
        map.put(byte[].class.getName(), new C2282f());
        map.put(char[].class.getName(), new b());
        map.put(short[].class.getName(), new g());
        map.put(int[].class.getName(), new e());
        map.put(long[].class.getName(), new f());
        map.put(float[].class.getName(), new d());
        map.put(double[].class.getName(), new c());
    }
}
