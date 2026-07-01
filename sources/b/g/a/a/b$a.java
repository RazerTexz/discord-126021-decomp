package b.g.a.a;

import java.io.Serializable;

/* JADX INFO: compiled from: JacksonInject.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$a implements Serializable {
    public static final b$a j = new b$a(null, null);
    private static final long serialVersionUID = 1;
    public final Object _id;
    public final Boolean _useInput;

    public b$a(Object obj, Boolean bool) {
        this._id = obj;
        this._useInput = bool;
    }

    public static b$a a(Object obj, Boolean bool) {
        if ("".equals(obj)) {
            obj = null;
        }
        return obj == null && bool == null ? j : new b$a(obj, bool);
    }

    public boolean equals(Object obj) {
        boolean zEquals;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == b$a.class) {
            b$a b_a = (b$a) obj;
            Boolean bool = this._useInput;
            Boolean bool2 = b_a._useInput;
            if (bool == null) {
                zEquals = bool2 == null;
            } else {
                zEquals = bool.equals(bool2);
            }
            if (zEquals) {
                Object obj2 = this._id;
                if (obj2 == null) {
                    return b_a._id == null;
                }
                return obj2.equals(b_a._id);
            }
        }
        return false;
    }

    public int hashCode() {
        Object obj = this._id;
        int iHashCode = obj != null ? 1 + obj.hashCode() : 1;
        Boolean bool = this._useInput;
        return bool != null ? iHashCode + bool.hashCode() : iHashCode;
    }

    public String toString() {
        return String.format("JacksonInject.Value(id=%s,useInput=%s)", this._id, this._useInput);
    }
}
