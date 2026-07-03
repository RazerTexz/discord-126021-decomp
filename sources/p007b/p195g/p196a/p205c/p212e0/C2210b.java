package p007b.p195g.p196a.p205c.p212e0;

import java.io.Serializable;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.g.a.c.e0.b */
/* JADX INFO: compiled from: NamedType.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2210b implements Serializable {
    private static final long serialVersionUID = 1;
    public final Class<?> _class;
    public final int _hashCode;
    public String _name;

    public C2210b(Class<?> cls, String str) {
        this._class = cls;
        this._hashCode = cls.getName().hashCode() + (str == null ? 0 : str.hashCode());
        this._name = (str == null || str.isEmpty()) ? null : str;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1944a() {
        return this._name != null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C2210b.class) {
            return false;
        }
        C2210b c2210b = (C2210b) obj;
        return this._class == c2210b._class && Objects.equals(this._name, c2210b._name);
    }

    public int hashCode() {
        return this._hashCode;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("[NamedType, class ");
        C1643a.m860k0(this._class, sbM833U, ", name: ");
        return C1643a.m822J(sbM833U, this._name == null ? "null" : C1643a.m822J(C1643a.m833U("'"), this._name, "'"), "]");
    }
}
