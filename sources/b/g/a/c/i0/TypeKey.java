package b.g.a.c.i0;

import b.d.b.a.outline;
import b.g.a.c.JavaType;

/* JADX INFO: renamed from: b.g.a.c.i0.u, reason: use source file name */
/* JADX INFO: compiled from: TypeKey.java */
/* JADX INFO: loaded from: classes3.dex */
public class TypeKey {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class<?> f730b;
    public JavaType c;
    public boolean d;

    public TypeKey() {
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != TypeKey.class) {
            return false;
        }
        TypeKey typeKey = (TypeKey) obj;
        if (typeKey.d != this.d) {
            return false;
        }
        Class<?> cls = this.f730b;
        if (cls != null) {
            return typeKey.f730b == cls;
        }
        return this.c.equals(typeKey.c);
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        if (this.f730b != null) {
            StringBuilder sbU = outline.U("{class: ");
            outline.k0(this.f730b, sbU, ", typed? ");
            return outline.O(sbU, this.d, "}");
        }
        StringBuilder sbU2 = outline.U("{type: ");
        sbU2.append(this.c);
        sbU2.append(", typed? ");
        return outline.O(sbU2, this.d, "}");
    }

    public TypeKey(Class<?> cls, boolean z2) {
        this.f730b = cls;
        this.c = null;
        this.d = z2;
        this.a = z2 ? cls.getName().hashCode() + 1 : cls.getName().hashCode();
    }

    public TypeKey(JavaType javaType, boolean z2) {
        int i;
        this.c = javaType;
        this.f730b = null;
        this.d = z2;
        if (z2) {
            i = javaType._hash - 2;
        } else {
            i = javaType._hash - 1;
        }
        this.a = i;
    }
}
