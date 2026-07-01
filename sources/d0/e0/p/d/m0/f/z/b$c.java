package d0.e0.p.d.m0.f.z;

import d0.e0.p.d.m0.i.h$a;

/* JADX INFO: compiled from: Flags.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$c<E extends d0.e0.p.d.m0.i.h$a> extends b$d<E> {
    public final E[] c;

    /* JADX WARN: Illegal instructions before constructor call */
    public b$c(int i, E[] eArr) {
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
            StringBuilder sbU = b.d.b.a.a.U("Empty enum: ");
            sbU.append(eArr.getClass());
            throw new IllegalStateException(sbU.toString());
        }
        super(i, i2, null);
        this.c = eArr;
    }

    @Override // d0.e0.p.d.m0.f.z.b$d
    public /* bridge */ /* synthetic */ Object get(int i) {
        return get(i);
    }

    @Override // d0.e0.p.d.m0.f.z.b$d
    public /* bridge */ /* synthetic */ int toFlags(Object obj) {
        return toFlags((d0.e0.p.d.m0.i.h$a) obj);
    }

    @Override // d0.e0.p.d.m0.f.z.b$d
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

    public int toFlags(E e) {
        return e.getNumber() << this.a;
    }
}
