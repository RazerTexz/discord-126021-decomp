package b.g.a.c.c0;

import b.d.b.a.outline;
import b.g.a.a.ObjectIdGenerator;
import b.g.a.a.SimpleObjectIdResolver;
import b.g.a.c.PropertyName;
import b.g.a.c.i0.ClassUtil;

/* JADX INFO: renamed from: b.g.a.c.c0.a0, reason: use source file name */
/* JADX INFO: compiled from: ObjectIdInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public class ObjectIdInfo {
    public static final ObjectIdInfo a = new ObjectIdInfo(PropertyName.k, Object.class, null, false, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PropertyName f681b;
    public final Class<? extends ObjectIdGenerator<?>> c;
    public final Class<?> d;
    public final Class<?> e;
    public final boolean f;

    /* JADX WARN: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r5v0, types: [java.lang.Class<?>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ObjectIdInfo(PropertyName propertyName, Class<?> cls, Class<? extends ObjectIdGenerator<?>> cls2, boolean z2, Class cls3) {
        this.f681b = propertyName;
        this.e = cls;
        this.c = cls2;
        this.f = z2;
        this.d = cls3 == null ? SimpleObjectIdResolver.class : cls3;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ObjectIdInfo: propName=");
        sbU.append(this.f681b);
        sbU.append(", scope=");
        sbU.append(ClassUtil.u(this.e));
        sbU.append(", generatorType=");
        sbU.append(ClassUtil.u(this.c));
        sbU.append(", alwaysAsId=");
        sbU.append(this.f);
        return sbU.toString();
    }
}
