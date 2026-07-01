package b.g.a.c;

import java.io.Serializable;
import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: PropertyName.java */
/* JADX INFO: loaded from: classes3.dex */
public class t implements Serializable {
    public static final t j = new t("", null);
    public static final t k = new t(new String(""), null);
    private static final long serialVersionUID = 1;
    public b.g.a.b.k _encodedSimple;
    public final String _namespace;
    public final String _simpleName;

    public t(String str) {
        Annotation[] annotationArr = b.g.a.c.i0.d.a;
        this._simpleName = str;
        this._namespace = null;
    }

    public static t a(String str) {
        return (str == null || str.isEmpty()) ? j : new t(b.g.a.b.t.f.j.a(str), null);
    }

    public static t b(String str, String str2) {
        if (str == null) {
            str = "";
        }
        return (str2 == null && str.isEmpty()) ? j : new t(b.g.a.b.t.f.j.a(str), str2);
    }

    public boolean c() {
        return !this._simpleName.isEmpty();
    }

    public boolean d() {
        return this._namespace == null && this._simpleName.isEmpty();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != t.class) {
            return false;
        }
        t tVar = (t) obj;
        String str = this._simpleName;
        if (str == null) {
            if (tVar._simpleName != null) {
                return false;
            }
        } else if (!str.equals(tVar._simpleName)) {
            return false;
        }
        String str2 = this._namespace;
        if (str2 == null) {
            return tVar._namespace == null;
        }
        return str2.equals(tVar._namespace);
    }

    public int hashCode() {
        String str = this._namespace;
        return str == null ? this._simpleName.hashCode() : str.hashCode() ^ this._simpleName.hashCode();
    }

    public Object readResolve() {
        String str;
        return (this._namespace == null && ((str = this._simpleName) == null || "".equals(str))) ? j : this;
    }

    public String toString() {
        if (this._namespace == null) {
            return this._simpleName;
        }
        StringBuilder sbU = b.d.b.a.a.U("{");
        sbU.append(this._namespace);
        sbU.append("}");
        sbU.append(this._simpleName);
        return sbU.toString();
    }

    public t(String str, String str2) {
        Annotation[] annotationArr = b.g.a.c.i0.d.a;
        this._simpleName = str == null ? "" : str;
        this._namespace = str2;
    }
}
