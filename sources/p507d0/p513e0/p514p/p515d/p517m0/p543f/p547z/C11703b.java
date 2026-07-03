package p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.EnumC11685j;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.EnumC11686k;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.EnumC11699x;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11728h;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.b */
/* JADX INFO: compiled from: Flags.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11703b {

    /* JADX INFO: renamed from: A */
    public static final b f24017A;

    /* JADX INFO: renamed from: B */
    public static final b f24018B;

    /* JADX INFO: renamed from: C */
    public static final b f24019C;

    /* JADX INFO: renamed from: D */
    public static final b f24020D;

    /* JADX INFO: renamed from: E */
    public static final b f24021E;

    /* JADX INFO: renamed from: F */
    public static final b f24022F;

    /* JADX INFO: renamed from: G */
    public static final b f24023G;

    /* JADX INFO: renamed from: H */
    public static final b f24024H;

    /* JADX INFO: renamed from: I */
    public static final b f24025I;

    /* JADX INFO: renamed from: J */
    public static final b f24026J;

    /* JADX INFO: renamed from: K */
    public static final b f24027K;

    /* JADX INFO: renamed from: L */
    public static final b f24028L;

    /* JADX INFO: renamed from: M */
    public static final b f24029M;

    /* JADX INFO: renamed from: a */
    public static final b f24030a = d.booleanFirst();

    /* JADX INFO: renamed from: b */
    public static final b f24031b;

    /* JADX INFO: renamed from: c */
    public static final d<EnumC11699x> f24032c;

    /* JADX INFO: renamed from: d */
    public static final d<EnumC11686k> f24033d;

    /* JADX INFO: renamed from: e */
    public static final d<C11678c.c> f24034e;

    /* JADX INFO: renamed from: f */
    public static final b f24035f;

    /* JADX INFO: renamed from: g */
    public static final b f24036g;

    /* JADX INFO: renamed from: h */
    public static final b f24037h;

    /* JADX INFO: renamed from: i */
    public static final b f24038i;

    /* JADX INFO: renamed from: j */
    public static final b f24039j;

    /* JADX INFO: renamed from: k */
    public static final b f24040k;

    /* JADX INFO: renamed from: l */
    public static final b f24041l;

    /* JADX INFO: renamed from: m */
    public static final b f24042m;

    /* JADX INFO: renamed from: n */
    public static final d<EnumC11685j> f24043n;

    /* JADX INFO: renamed from: o */
    public static final b f24044o;

    /* JADX INFO: renamed from: p */
    public static final b f24045p;

    /* JADX INFO: renamed from: q */
    public static final b f24046q;

    /* JADX INFO: renamed from: r */
    public static final b f24047r;

    /* JADX INFO: renamed from: s */
    public static final b f24048s;

    /* JADX INFO: renamed from: t */
    public static final b f24049t;

    /* JADX INFO: renamed from: u */
    public static final b f24050u;

    /* JADX INFO: renamed from: v */
    public static final b f24051v;

    /* JADX INFO: renamed from: w */
    public static final b f24052w;

    /* JADX INFO: renamed from: x */
    public static final b f24053x;

    /* JADX INFO: renamed from: y */
    public static final b f24054y;

    /* JADX INFO: renamed from: z */
    public static final b f24055z;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.b$b */
    /* JADX INFO: compiled from: Flags.java */
    public static class b extends d<Boolean> {
        public b(int i) {
            super(i, 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11703b.d
        public Boolean get(int i) {
            Boolean boolValueOf = Boolean.valueOf((i & (1 << this.f24057a)) != 0);
            if (boolValueOf != null) {
                return boolValueOf;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", "get"));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11703b.d
        public int toFlags(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.f24057a;
            }
            return 0;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.b$c */
    /* JADX INFO: compiled from: Flags.java */
    public static class c<E extends C11728h.a> extends d<E> {

        /* JADX INFO: renamed from: c */
        public final E[] f24056c;

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
                StringBuilder sbM833U = C1643a.m833U("Empty enum: ");
                sbM833U.append(eArr.getClass());
                throw new IllegalStateException(sbM833U.toString());
            }
            super(i, i2, null);
            this.f24056c = eArr;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11703b.d
        public E get(int i) {
            int i2 = (1 << this.f24058b) - 1;
            int i3 = this.f24057a;
            int i4 = (i & (i2 << i3)) >> i3;
            for (E e : this.f24056c) {
                if (e.getNumber() == i4) {
                    return e;
                }
            }
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11703b.d
        public int toFlags(E e) {
            return e.getNumber() << this.f24057a;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.b$d */
    /* JADX INFO: compiled from: Flags.java */
    public static abstract class d<E> {

        /* JADX INFO: renamed from: a */
        public final int f24057a;

        /* JADX INFO: renamed from: b */
        public final int f24058b;

        public d(int i, int i2, a aVar) {
            this.f24057a = i;
            this.f24058b = i2;
        }

        /* JADX WARN: Incorrect types in method signature: <E::Ld0/e0/p/d/m0/i/h$a;>(Ld0/e0/p/d/m0/f/z/b$d<*>;[TE;)Ld0/e0/p/d/m0/f/z/b$d<TE;>; */
        public static d after(d dVar, C11728h.a[] aVarArr) {
            return new c(dVar.f24057a + dVar.f24058b, aVarArr);
        }

        public static b booleanAfter(d<?> dVar) {
            return new b(dVar.f24057a + dVar.f24058b);
        }

        public static b booleanFirst() {
            return new b(0);
        }

        public abstract E get(int i);

        public abstract int toFlags(E e);
    }

    static {
        b bVarBooleanFirst = d.booleanFirst();
        f24031b = bVarBooleanFirst;
        d<EnumC11699x> dVarAfter = d.after(bVarBooleanFirst, EnumC11699x.values());
        f24032c = dVarAfter;
        d<EnumC11686k> dVarAfter2 = d.after(dVarAfter, EnumC11686k.values());
        f24033d = dVarAfter2;
        d<C11678c.c> dVarAfter3 = d.after(dVarAfter2, C11678c.c.values());
        f24034e = dVarAfter3;
        b bVarBooleanAfter = d.booleanAfter(dVarAfter3);
        f24035f = bVarBooleanAfter;
        b bVarBooleanAfter2 = d.booleanAfter(bVarBooleanAfter);
        f24036g = bVarBooleanAfter2;
        b bVarBooleanAfter3 = d.booleanAfter(bVarBooleanAfter2);
        f24037h = bVarBooleanAfter3;
        b bVarBooleanAfter4 = d.booleanAfter(bVarBooleanAfter3);
        f24038i = bVarBooleanAfter4;
        b bVarBooleanAfter5 = d.booleanAfter(bVarBooleanAfter4);
        f24039j = bVarBooleanAfter5;
        f24040k = d.booleanAfter(bVarBooleanAfter5);
        b bVarBooleanAfter6 = d.booleanAfter(dVarAfter);
        f24041l = bVarBooleanAfter6;
        f24042m = d.booleanAfter(bVarBooleanAfter6);
        d<EnumC11685j> dVarAfter4 = d.after(dVarAfter2, EnumC11685j.values());
        f24043n = dVarAfter4;
        b bVarBooleanAfter7 = d.booleanAfter(dVarAfter4);
        f24044o = bVarBooleanAfter7;
        b bVarBooleanAfter8 = d.booleanAfter(bVarBooleanAfter7);
        f24045p = bVarBooleanAfter8;
        b bVarBooleanAfter9 = d.booleanAfter(bVarBooleanAfter8);
        f24046q = bVarBooleanAfter9;
        b bVarBooleanAfter10 = d.booleanAfter(bVarBooleanAfter9);
        f24047r = bVarBooleanAfter10;
        b bVarBooleanAfter11 = d.booleanAfter(bVarBooleanAfter10);
        f24048s = bVarBooleanAfter11;
        b bVarBooleanAfter12 = d.booleanAfter(bVarBooleanAfter11);
        f24049t = bVarBooleanAfter12;
        b bVarBooleanAfter13 = d.booleanAfter(bVarBooleanAfter12);
        f24050u = bVarBooleanAfter13;
        f24051v = d.booleanAfter(bVarBooleanAfter13);
        b bVarBooleanAfter14 = d.booleanAfter(dVarAfter4);
        f24052w = bVarBooleanAfter14;
        b bVarBooleanAfter15 = d.booleanAfter(bVarBooleanAfter14);
        f24053x = bVarBooleanAfter15;
        b bVarBooleanAfter16 = d.booleanAfter(bVarBooleanAfter15);
        f24054y = bVarBooleanAfter16;
        b bVarBooleanAfter17 = d.booleanAfter(bVarBooleanAfter16);
        f24055z = bVarBooleanAfter17;
        b bVarBooleanAfter18 = d.booleanAfter(bVarBooleanAfter17);
        f24017A = bVarBooleanAfter18;
        b bVarBooleanAfter19 = d.booleanAfter(bVarBooleanAfter18);
        f24018B = bVarBooleanAfter19;
        b bVarBooleanAfter20 = d.booleanAfter(bVarBooleanAfter19);
        f24019C = bVarBooleanAfter20;
        b bVarBooleanAfter21 = d.booleanAfter(bVarBooleanAfter20);
        f24020D = bVarBooleanAfter21;
        f24021E = d.booleanAfter(bVarBooleanAfter21);
        b bVarBooleanAfter22 = d.booleanAfter(bVarBooleanFirst);
        f24022F = bVarBooleanAfter22;
        b bVarBooleanAfter23 = d.booleanAfter(bVarBooleanAfter22);
        f24023G = bVarBooleanAfter23;
        f24024H = d.booleanAfter(bVarBooleanAfter23);
        b bVarBooleanAfter24 = d.booleanAfter(dVarAfter2);
        f24025I = bVarBooleanAfter24;
        b bVarBooleanAfter25 = d.booleanAfter(bVarBooleanAfter24);
        f24026J = bVarBooleanAfter25;
        f24027K = d.booleanAfter(bVarBooleanAfter25);
        b bVarBooleanFirst2 = d.booleanFirst();
        f24028L = bVarBooleanFirst2;
        d.booleanAfter(bVarBooleanFirst2);
        f24029M = d.booleanFirst();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0021  */
    /* JADX WARN: Code duplicated, block: B:18:0x002b  */
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9814a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "modality";
        } else if (i == 2) {
            objArr[0] = "kind";
        } else if (i == 5) {
            objArr[0] = "modality";
        } else if (i == 6) {
            objArr[0] = "memberKind";
        } else if (i == 8) {
            objArr[0] = "modality";
        } else if (i == 9) {
            objArr[0] = "memberKind";
        } else if (i != 11) {
            objArr[0] = "visibility";
        } else {
            objArr[0] = "modality";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch (i) {
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

    public static int getAccessorFlags(boolean z2, EnumC11699x enumC11699x, EnumC11686k enumC11686k, boolean z3, boolean z4, boolean z5) {
        if (enumC11699x == null) {
            m9814a(10);
            throw null;
        }
        if (enumC11686k != null) {
            return f24031b.toFlags(Boolean.valueOf(z2)) | f24033d.toFlags(enumC11686k) | f24032c.toFlags(enumC11699x) | f24025I.toFlags(Boolean.valueOf(z3)) | f24026J.toFlags(Boolean.valueOf(z4)) | f24027K.toFlags(Boolean.valueOf(z5));
        }
        m9814a(11);
        throw null;
    }
}
