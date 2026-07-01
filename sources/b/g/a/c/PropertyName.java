package b.g.a.c;

import b.d.b.a.outline;
import b.g.a.b.SerializableString;
import b.g.a.b.t.InternCache;
import b.g.a.c.i0.ClassUtil;
import java.io.Serializable;
import java.lang.annotation.Annotation;

/* JADX INFO: renamed from: b.g.a.c.t, reason: use source file name */
/* JADX INFO: compiled from: PropertyName.java */
/* JADX INFO: loaded from: classes3.dex */
public class PropertyName implements Serializable {
    public static final PropertyName j = new PropertyName("", null);
    public static final PropertyName k = new PropertyName(new String(""), null);
    private static final long serialVersionUID = 1;
    public SerializableString _encodedSimple;
    public final String _namespace;
    public final String _simpleName;

    public PropertyName(String str) {
        Annotation[] annotationArr = ClassUtil.a;
        this._simpleName = str;
        this._namespace = null;
    }

    public static PropertyName a(String str) {
        return (str == null || str.isEmpty()) ? j : new PropertyName(InternCache.j.a(str), null);
    }

    public static PropertyName b(String str, String str2) {
        if (str == null) {
            str = "";
        }
        return (str2 == null && str.isEmpty()) ? j : new PropertyName(InternCache.j.a(str), str2);
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
        if (obj == null || obj.getClass() != PropertyName.class) {
            return false;
        }
        PropertyName propertyName = (PropertyName) obj;
        String str = this._simpleName;
        if (str == null) {
            if (propertyName._simpleName != null) {
                return false;
            }
        } else if (!str.equals(propertyName._simpleName)) {
            return false;
        }
        String str2 = this._namespace;
        if (str2 == null) {
            return propertyName._namespace == null;
        }
        return str2.equals(propertyName._namespace);
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
        StringBuilder sbU = outline.U("{");
        sbU.append(this._namespace);
        sbU.append("}");
        sbU.append(this._simpleName);
        return sbU.toString();
    }

    public PropertyName(String str, String str2) {
        Annotation[] annotationArr = ClassUtil.a;
        this._simpleName = str == null ? "" : str;
        this._namespace = str2;
    }
}
