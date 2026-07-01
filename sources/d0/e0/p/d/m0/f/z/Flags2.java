package d0.e0.p.d.m0.f.z;

import b.d.b.a.outline;
import d0.e0.p.d.m0.f.c;
import d0.e0.p.d.m0.f.k;
import d0.e0.p.d.m0.f.x;
import d0.e0.p.d.m0.i.Internal;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.b, reason: use source file name */
/* JADX INFO: compiled from: Flags.java */
/* JADX INFO: loaded from: classes3.dex */
public class Flags2 {
    public static final b A;
    public static final b B;
    public static final b C;
    public static final b D;
    public static final b E;
    public static final b F;
    public static final b G;
    public static final b H;
    public static final b I;
    public static final b J;
    public static final b K;
    public static final b L;
    public static final b M;
    public static final b a = d.booleanFirst();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f3412b;
    public static final d<x> c;
    public static final d<k> d;
    public static final d<c.EnumC0397c> e;
    public static final b f;
    public static final b g;
    public static final b h;
    public static final b i;
    public static final b j;
    public static final b k;
    public static final b l;
    public static final b m;
    public static final d<d0.e0.p.d.m0.f.j> n;
    public static final b o;
    public static final b p;
    public static final b q;
    public static final b r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final b f3413s;
    public static final b t;
    public static final b u;
    public static final b v;
    public static final b w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final b f3414x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final b f3415y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final b f3416z;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.b$b */
    /* JADX INFO: compiled from: Flags.java */
    public static class b extends d<Boolean> {
        public b(int i) {
            super(i, 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d0.e0.p.d.m0.f.z.Flags2.d
        public Boolean get(int i) {
            Boolean boolValueOf = Boolean.valueOf((i & (1 << this.a)) != 0);
            if (boolValueOf != null) {
                return boolValueOf;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", "get"));
        }

        @Override // d0.e0.p.d.m0.f.z.Flags2.d
        public int toFlags(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.a;
            }
            return 0;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.b$c */
    /* JADX INFO: compiled from: Flags.java */
    public static class c<E extends Internal.a> extends d<E> {
        public final E[] c;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(int i, E[] eArr) {
            int i2 = 1;
            if (eArr == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
            }
            int length = eArr.length - 1;
            if (length != 0) {
                for (int i3 = 31; i3 >= 0; i3--) {
                    if (((1 << i3) & length) != 0) {
                        i2 = 1 + i3;
                    }
                }
                StringBuilder sbU = outline.U("Empty enum: ");
                sbU.append(eArr.getClass());
                throw new IllegalStateException(sbU.toString());
            }
            super(i, i2, null);
            this.c = eArr;
        }

        @Override // d0.e0.p.d.m0.f.z.Flags2.d
        public E get(int i) {
            int i2 = (1 << this.f3417b) - 1;
            int i3 = this.a;
            int i4 = (i & (i2 << i3)) >> i3;
            for (E e : this.c) {
                if (e.getNumber() == i4) {
                    return e;
                }
            }
            return null;
        }

        @Override // d0.e0.p.d.m0.f.z.Flags2.d
        public int toFlags(E e) {
            return e.getNumber() << this.a;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.b$d */
    /* JADX INFO: compiled from: Flags.java */
    public static abstract class d<E> {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3417b;

        public d(int i, int i2, a aVar) {
            this.a = i;
            this.f3417b = i2;
        }

        /* JADX WARN: Incorrect types in method signature: <E::Ld0/e0/p/d/m0/i/h$a;>(Ld0/e0/p/d/m0/f/z/b$d<*>;[TE;)Ld0/e0/p/d/m0/f/z/b$d<TE;>; */
        public static d after(d dVar, Internal.a[] aVarArr) {
            return new c(dVar.a + dVar.f3417b, aVarArr);
        }

        public static b booleanAfter(d<?> dVar) {
            return new b(dVar.a + dVar.f3417b);
        }

        public static b booleanFirst() {
            return new b(0);
        }

        public abstract E get(int i);

        public abstract int toFlags(E e);
    }

    static {
        b bVarBooleanFirst = d.booleanFirst();
        f3412b = bVarBooleanFirst;
        d<x> dVarAfter = d.after(bVarBooleanFirst, x.values());
        c = dVarAfter;
        d<k> dVarAfter2 = d.after(dVarAfter, k.values());
        d = dVarAfter2;
        d<c.EnumC0397c> dVarAfter3 = d.after(dVarAfter2, c.EnumC0397c.values());
        e = dVarAfter3;
        b bVarBooleanAfter = d.booleanAfter(dVarAfter3);
        f = bVarBooleanAfter;
        b bVarBooleanAfter2 = d.booleanAfter(bVarBooleanAfter);
        g = bVarBooleanAfter2;
        b bVarBooleanAfter3 = d.booleanAfter(bVarBooleanAfter2);
        h = bVarBooleanAfter3;
        b bVarBooleanAfter4 = d.booleanAfter(bVarBooleanAfter3);
        i = bVarBooleanAfter4;
        b bVarBooleanAfter5 = d.booleanAfter(bVarBooleanAfter4);
        j = bVarBooleanAfter5;
        k = d.booleanAfter(bVarBooleanAfter5);
        b bVarBooleanAfter6 = d.booleanAfter(dVarAfter);
        l = bVarBooleanAfter6;
        m = d.booleanAfter(bVarBooleanAfter6);
        d<d0.e0.p.d.m0.f.j> dVarAfter4 = d.after(dVarAfter2, d0.e0.p.d.m0.f.j.values());
        n = dVarAfter4;
        b bVarBooleanAfter7 = d.booleanAfter(dVarAfter4);
        o = bVarBooleanAfter7;
        b bVarBooleanAfter8 = d.booleanAfter(bVarBooleanAfter7);
        p = bVarBooleanAfter8;
        b bVarBooleanAfter9 = d.booleanAfter(bVarBooleanAfter8);
        q = bVarBooleanAfter9;
        b bVarBooleanAfter10 = d.booleanAfter(bVarBooleanAfter9);
        r = bVarBooleanAfter10;
        b bVarBooleanAfter11 = d.booleanAfter(bVarBooleanAfter10);
        f3413s = bVarBooleanAfter11;
        b bVarBooleanAfter12 = d.booleanAfter(bVarBooleanAfter11);
        t = bVarBooleanAfter12;
        b bVarBooleanAfter13 = d.booleanAfter(bVarBooleanAfter12);
        u = bVarBooleanAfter13;
        v = d.booleanAfter(bVarBooleanAfter13);
        b bVarBooleanAfter14 = d.booleanAfter(dVarAfter4);
        w = bVarBooleanAfter14;
        b bVarBooleanAfter15 = d.booleanAfter(bVarBooleanAfter14);
        f3414x = bVarBooleanAfter15;
        b bVarBooleanAfter16 = d.booleanAfter(bVarBooleanAfter15);
        f3415y = bVarBooleanAfter16;
        b bVarBooleanAfter17 = d.booleanAfter(bVarBooleanAfter16);
        f3416z = bVarBooleanAfter17;
        b bVarBooleanAfter18 = d.booleanAfter(bVarBooleanAfter17);
        A = bVarBooleanAfter18;
        b bVarBooleanAfter19 = d.booleanAfter(bVarBooleanAfter18);
        B = bVarBooleanAfter19;
        b bVarBooleanAfter20 = d.booleanAfter(bVarBooleanAfter19);
        C = bVarBooleanAfter20;
        b bVarBooleanAfter21 = d.booleanAfter(bVarBooleanAfter20);
        D = bVarBooleanAfter21;
        E = d.booleanAfter(bVarBooleanAfter21);
        b bVarBooleanAfter22 = d.booleanAfter(bVarBooleanFirst);
        F = bVarBooleanAfter22;
        b bVarBooleanAfter23 = d.booleanAfter(bVarBooleanAfter22);
        G = bVarBooleanAfter23;
        H = d.booleanAfter(bVarBooleanAfter23);
        b bVarBooleanAfter24 = d.booleanAfter(dVarAfter2);
        I = bVarBooleanAfter24;
        b bVarBooleanAfter25 = d.booleanAfter(bVarBooleanAfter24);
        J = bVarBooleanAfter25;
        K = d.booleanAfter(bVarBooleanAfter25);
        b bVarBooleanFirst2 = d.booleanFirst();
        L = bVarBooleanFirst2;
        d.booleanAfter(bVarBooleanFirst2);
        M = d.booleanFirst();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0021  */
    /* JADX WARN: Code duplicated, block: B:18:0x002b  */
    public static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        if (i2 == 1) {
            objArr[0] = "modality";
        } else if (i2 == 2) {
            objArr[0] = "kind";
        } else if (i2 == 5) {
            objArr[0] = "modality";
        } else if (i2 == 6) {
            objArr[0] = "memberKind";
        } else if (i2 == 8) {
            objArr[0] = "modality";
        } else if (i2 == 9) {
            objArr[0] = "memberKind";
        } else if (i2 != 11) {
            objArr[0] = "visibility";
        } else {
            objArr[0] = "modality";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch (i2) {
            case 3:
                objArr[2] = "getConstructorFlags";
                break;
            case 4:
            case 5:
            case 6:
                objArr[2] = "getFunctionFlags";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "getPropertyFlags";
                break;
            case 10:
            case 11:
                objArr[2] = "getAccessorFlags";
                break;
            default:
                objArr[2] = "getClassFlags";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static int getAccessorFlags(boolean z2, x xVar, k kVar, boolean z3, boolean z4, boolean z5) {
        if (xVar == null) {
            a(10);
            throw null;
        }
        if (kVar != null) {
            return f3412b.toFlags(Boolean.valueOf(z2)) | d.toFlags(kVar) | c.toFlags(xVar) | I.toFlags(Boolean.valueOf(z3)) | J.toFlags(Boolean.valueOf(z4)) | K.toFlags(Boolean.valueOf(z5));
        }
        a(11);
        throw null;
    }
}
