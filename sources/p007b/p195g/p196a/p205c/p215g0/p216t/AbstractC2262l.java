package p007b.p195g.p196a.p205c.p215g0.p216t;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.Arrays;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.InterfaceC2206d;

/* JADX INFO: renamed from: b.g.a.c.g0.t.l */
/* JADX INFO: compiled from: PropertySerializerMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2262l {

    /* JADX INFO: renamed from: a */
    public final boolean f4823a;

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$a */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class a extends AbstractC2262l {

        /* JADX INFO: renamed from: b */
        public final Class<?> f4824b;

        /* JADX INFO: renamed from: c */
        public final Class<?> f4825c;

        /* JADX INFO: renamed from: d */
        public final AbstractC2364n<Object> f4826d;

        /* JADX INFO: renamed from: e */
        public final AbstractC2364n<Object> f4827e;

        public a(AbstractC2262l abstractC2262l, Class<?> cls, AbstractC2364n<Object> abstractC2364n, Class<?> cls2, AbstractC2364n<Object> abstractC2364n2) {
            super(abstractC2262l);
            this.f4824b = cls;
            this.f4826d = abstractC2364n;
            this.f4825c = cls2;
            this.f4827e = abstractC2364n2;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l
        /* JADX INFO: renamed from: b */
        public AbstractC2262l mo2033b(Class<?> cls, AbstractC2364n<Object> abstractC2364n) {
            return new c(this, new f[]{new f(this.f4824b, this.f4826d), new f(this.f4825c, this.f4827e), new f(cls, abstractC2364n)});
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l
        /* JADX INFO: renamed from: c */
        public AbstractC2364n<Object> mo2034c(Class<?> cls) {
            if (cls == this.f4824b) {
                return this.f4826d;
            }
            if (cls == this.f4825c) {
                return this.f4827e;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$b */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class b extends AbstractC2262l {

        /* JADX INFO: renamed from: b */
        public static final b f4828b = new b(false);

        public b(boolean z2) {
            super(z2);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l
        /* JADX INFO: renamed from: b */
        public AbstractC2262l mo2033b(Class<?> cls, AbstractC2364n<Object> abstractC2364n) {
            return new e(this, cls, abstractC2364n);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l
        /* JADX INFO: renamed from: c */
        public AbstractC2364n<Object> mo2034c(Class<?> cls) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$c */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class c extends AbstractC2262l {

        /* JADX INFO: renamed from: b */
        public final f[] f4829b;

        public c(AbstractC2262l abstractC2262l, f[] fVarArr) {
            super(abstractC2262l);
            this.f4829b = fVarArr;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l
        /* JADX INFO: renamed from: b */
        public AbstractC2262l mo2033b(Class<?> cls, AbstractC2364n<Object> abstractC2364n) {
            f[] fVarArr = this.f4829b;
            int length = fVarArr.length;
            if (length == 8) {
                return this.f4823a ? new e(this, cls, abstractC2364n) : this;
            }
            f[] fVarArr2 = (f[]) Arrays.copyOf(fVarArr, length + 1);
            fVarArr2[length] = new f(cls, abstractC2364n);
            return new c(this, fVarArr2);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l
        /* JADX INFO: renamed from: c */
        public AbstractC2364n<Object> mo2034c(Class<?> cls) {
            f[] fVarArr = this.f4829b;
            f fVar = fVarArr[0];
            if (fVar.f4834a == cls) {
                return fVar.f4835b;
            }
            f fVar2 = fVarArr[1];
            if (fVar2.f4834a == cls) {
                return fVar2.f4835b;
            }
            f fVar3 = fVarArr[2];
            if (fVar3.f4834a == cls) {
                return fVar3.f4835b;
            }
            switch (fVarArr.length) {
                case 8:
                    f fVar4 = fVarArr[7];
                    if (fVar4.f4834a == cls) {
                        return fVar4.f4835b;
                    }
                case 7:
                    f fVar5 = fVarArr[6];
                    if (fVar5.f4834a == cls) {
                        return fVar5.f4835b;
                    }
                case 6:
                    f fVar6 = fVarArr[5];
                    if (fVar6.f4834a == cls) {
                        return fVar6.f4835b;
                    }
                case 5:
                    f fVar7 = fVarArr[4];
                    if (fVar7.f4834a == cls) {
                        return fVar7.f4835b;
                    }
                case 4:
                    f fVar8 = fVarArr[3];
                    if (fVar8.f4834a == cls) {
                        return fVar8.f4835b;
                    }
                    return null;
                default:
                    return null;
            }
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$d */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class d {

        /* JADX INFO: renamed from: a */
        public final AbstractC2364n<Object> f4830a;

        /* JADX INFO: renamed from: b */
        public final AbstractC2262l f4831b;

        public d(AbstractC2364n<Object> abstractC2364n, AbstractC2262l abstractC2262l) {
            this.f4830a = abstractC2364n;
            this.f4831b = abstractC2262l;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$e */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class e extends AbstractC2262l {

        /* JADX INFO: renamed from: b */
        public final Class<?> f4832b;

        /* JADX INFO: renamed from: c */
        public final AbstractC2364n<Object> f4833c;

        public e(AbstractC2262l abstractC2262l, Class<?> cls, AbstractC2364n<Object> abstractC2364n) {
            super(abstractC2262l);
            this.f4832b = cls;
            this.f4833c = abstractC2364n;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l
        /* JADX INFO: renamed from: b */
        public AbstractC2262l mo2033b(Class<?> cls, AbstractC2364n<Object> abstractC2364n) {
            return new a(this, this.f4832b, this.f4833c, cls, abstractC2364n);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l
        /* JADX INFO: renamed from: c */
        public AbstractC2364n<Object> mo2034c(Class<?> cls) {
            if (cls == this.f4832b) {
                return this.f4833c;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.g0.t.l$f */
    /* JADX INFO: compiled from: PropertySerializerMap.java */
    public static final class f {

        /* JADX INFO: renamed from: a */
        public final Class<?> f4834a;

        /* JADX INFO: renamed from: b */
        public final AbstractC2364n<Object> f4835b;

        public f(Class<?> cls, AbstractC2364n<Object> abstractC2364n) {
            this.f4834a = cls;
            this.f4835b = abstractC2364n;
        }
    }

    public AbstractC2262l(boolean z2) {
        this.f4823a = z2;
    }

    /* JADX INFO: renamed from: a */
    public final d m2032a(AbstractC2360j abstractC2360j, AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        AbstractC2364n<Object> abstractC2364nM2249m = abstractC2374x.m2249m(abstractC2360j, interfaceC2206d);
        return new d(abstractC2364nM2249m, mo2033b(abstractC2360j._class, abstractC2364nM2249m));
    }

    /* JADX INFO: renamed from: b */
    public abstract AbstractC2262l mo2033b(Class<?> cls, AbstractC2364n<Object> abstractC2364n);

    /* JADX INFO: renamed from: c */
    public abstract AbstractC2364n<Object> mo2034c(Class<?> cls);

    public AbstractC2262l(AbstractC2262l abstractC2262l) {
        this.f4823a = abstractC2262l.f4823a;
    }
}
