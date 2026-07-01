package b.g.a.c.e0;

import b.d.b.a.outline;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.e0.b, reason: use source file name */
/* JADX INFO: compiled from: NamedType.java */
/* JADX INFO: loaded from: classes3.dex */
public final class NamedType implements Serializable {
    private static final long serialVersionUID = 1;
    public final Class<?> _class;
    public final int _hashCode;
    public String _name;

    public NamedType(Class<?> cls, String str) {
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
        if (obj == null || obj.getClass() != NamedType.class) {
            return false;
        }
        NamedType namedType = (NamedType) obj;
        return this._class == namedType._class && Objects.equals(this._name, namedType._name);
    }

    public int hashCode() {
        return this._hashCode;
    }

    public String toString() {
        StringBuilder sbU = outline.U("[NamedType, class ");
        outline.k0(this._class, sbU, ", name: ");
        return outline.J(sbU, this._name == null ? "null" : outline.J(outline.U("'"), this._name, "'"), "]");
    }
}
