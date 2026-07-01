package b.g.a.c.e0;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: NamedType.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements Serializable {
    private static final long serialVersionUID = 1;
    public final Class<?> _class;
    public final int _hashCode;
    public String _name;

    public b(Class<?> cls, String str) {
        this._class = cls;
        this._hashCode = cls.getName().hashCode() + (str == null ? 0 : str.hashCode());
        this._name = (str == null || str.isEmpty()) ? null : str;
    }

    public boolean a() {
        return this._name != null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != b.class) {
            return false;
        }
        b bVar = (b) obj;
        return this._class == bVar._class && Objects.equals(this._name, bVar._name);
    }

    public int hashCode() {
        return this._hashCode;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("[NamedType, class ");
        b.d.b.a.a.k0(this._class, sbU, ", name: ");
        return b.d.b.a.a.J(sbU, this._name == null ? "null" : b.d.b.a.a.J(b.d.b.a.a.U("'"), this._name, "'"), "]");
    }
}
