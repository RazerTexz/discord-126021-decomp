package b.g.a.c.c0;

import b.g.a.a.i0;
import b.g.a.a.n0;

/* JADX INFO: compiled from: ObjectIdInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public class a0 {
    public static final a0 a = new a0(b.g.a.c.t.k, Object.class, null, false, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.g.a.c.t f681b;
    public final Class<? extends i0<?>> c;
    public final Class<?> d;
    public final Class<?> e;
    public final boolean f;

    /* JADX WARN: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r5v0, types: [java.lang.Class<?>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a0(b.g.a.c.t tVar, Class<?> cls, Class<? extends i0<?>> cls2, boolean z2, Class cls3) {
        this.f681b = tVar;
        this.e = cls;
        this.c = cls2;
        this.f = z2;
        this.d = cls3 == null ? n0.class : cls3;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ObjectIdInfo: propName=");
        sbU.append(this.f681b);
        sbU.append(", scope=");
        sbU.append(b.g.a.c.i0.d.u(this.e));
        sbU.append(", generatorType=");
        sbU.append(b.g.a.c.i0.d.u(this.c));
        sbU.append(", alwaysAsId=");
        sbU.append(this.f);
        return sbU.toString();
    }
}
