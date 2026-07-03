package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p219i0.C2344f;

/* JADX INFO: renamed from: b.g.a.c.g0.u.o0 */
/* JADX INFO: compiled from: StdKeySerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2301o0 {

    /* JADX INFO: renamed from: a */
    public static final AbstractC2364n<Object> f4858a = new d();

    /* JADX INFO: renamed from: b.g.a.c.g0.u.o0$a */
    /* JADX INFO: compiled from: StdKeySerializers.java */
    public static class a extends AbstractC2305q0<Object> {
        public final int _typeId;

        public a(int i, Class<?> cls) {
            super(cls, false);
            this._typeId = i;
        }

        @Override // p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            String strValueOf;
            switch (this._typeId) {
                case 1:
                    Date date = (Date) obj;
                    Objects.requireNonNull(abstractC2374x);
                    if (!abstractC2374x.m2240D(EnumC2373w.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
                        abstractC2108d.mo1666y(abstractC2374x.m2246j().format(date));
                    } else {
                        abstractC2108d.mo1666y(String.valueOf(date.getTime()));
                    }
                    break;
                case 2:
                    long timeInMillis = ((Calendar) obj).getTimeInMillis();
                    Objects.requireNonNull(abstractC2374x);
                    if (!abstractC2374x.m2240D(EnumC2373w.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
                        abstractC2108d.mo1666y(abstractC2374x.m2246j().format(new Date(timeInMillis)));
                    } else {
                        abstractC2108d.mo1666y(String.valueOf(timeInMillis));
                    }
                    break;
                case 3:
                    abstractC2108d.mo1666y(((Class) obj).getName());
                    break;
                case 4:
                    if (abstractC2374x.m2240D(EnumC2373w.WRITE_ENUMS_USING_TO_STRING)) {
                        strValueOf = obj.toString();
                    } else {
                        Enum r3 = (Enum) obj;
                        strValueOf = abstractC2374x.m2240D(EnumC2373w.WRITE_ENUM_KEYS_USING_INDEX) ? String.valueOf(r3.ordinal()) : r3.name();
                    }
                    abstractC2108d.mo1666y(strValueOf);
                    break;
                case 5:
                case 6:
                    long jLongValue = ((Number) obj).longValue();
                    Objects.requireNonNull(abstractC2108d);
                    abstractC2108d.mo1666y(Long.toString(jLongValue));
                    break;
                case 7:
                    abstractC2108d.mo1666y(abstractC2374x._config._base._defaultBase64.m1622a((byte[]) obj));
                    break;
                default:
                    abstractC2108d.mo1666y(obj.toString());
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.o0$b */
    /* JADX INFO: compiled from: StdKeySerializers.java */
    public static class b extends AbstractC2305q0<Object> {

        /* JADX INFO: renamed from: k */
        public transient AbstractC2262l f4859k;

        public b() {
            super(String.class, false);
            this.f4859k = AbstractC2262l.b.f4828b;
        }

        @Override // p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            Class<?> cls = obj.getClass();
            AbstractC2262l abstractC2262l = this.f4859k;
            AbstractC2364n<Object> abstractC2364nMo2034c = abstractC2262l.mo2034c(cls);
            if (abstractC2364nMo2034c == null) {
                if (cls == Object.class) {
                    abstractC2364nMo2034c = new a(8, cls);
                    this.f4859k = abstractC2262l.mo2033b(cls, abstractC2364nMo2034c);
                } else {
                    abstractC2364nMo2034c = abstractC2374x.m2251o(abstractC2374x._config._base._typeFactory.m2160b(null, cls, C2335n.f4926l), null);
                    AbstractC2262l abstractC2262lMo2033b = abstractC2262l.mo2033b(cls, abstractC2364nMo2034c);
                    if (abstractC2262l != abstractC2262lMo2033b) {
                        this.f4859k = abstractC2262lMo2033b;
                    }
                }
            }
            abstractC2364nMo2034c.mo1807f(obj, abstractC2108d, abstractC2374x);
        }

        public Object readResolve() {
            this.f4859k = AbstractC2262l.b.f4828b;
            return this;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.o0$c */
    /* JADX INFO: compiled from: StdKeySerializers.java */
    public static class c extends AbstractC2305q0<Object> {
        public final C2344f _values;

        public c(Class<?> cls, C2344f c2344f) {
            super(cls, false);
            this._values = c2344f;
        }

        @Override // p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            if (abstractC2374x.m2240D(EnumC2373w.WRITE_ENUMS_USING_TO_STRING)) {
                abstractC2108d.mo1666y(obj.toString());
                return;
            }
            Enum<?> r2 = (Enum) obj;
            if (abstractC2374x.m2240D(EnumC2373w.WRITE_ENUM_KEYS_USING_INDEX)) {
                abstractC2108d.mo1666y(String.valueOf(r2.ordinal()));
            } else {
                abstractC2108d.mo1665x(this._values.m2200c(r2));
            }
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.u.o0$d */
    /* JADX INFO: compiled from: StdKeySerializers.java */
    public static class d extends AbstractC2305q0<Object> {
        public d() {
            super(String.class, false);
        }

        @Override // p007b.p195g.p196a.p205c.AbstractC2364n
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
            abstractC2108d.mo1666y((String) obj);
        }
    }
}
