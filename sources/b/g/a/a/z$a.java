package b.g.a.a;

import java.io.Serializable;

/* JADX INFO: compiled from: JsonSetter.java */
/* JADX INFO: loaded from: classes3.dex */
public class z$a implements Serializable {
    public static final z$a j;
    private static final long serialVersionUID = 1;
    private final h0 _contentNulls;
    private final h0 _nulls;

    static {
        h0 h0Var = h0.DEFAULT;
        j = new z$a(h0Var, h0Var);
    }

    public z$a(h0 h0Var, h0 h0Var2) {
        this._nulls = h0Var;
        this._contentNulls = h0Var2;
    }

    public h0 a() {
        h0 h0Var = this._contentNulls;
        if (h0Var == h0.DEFAULT) {
            return null;
        }
        return h0Var;
    }

    public h0 b() {
        h0 h0Var = this._nulls;
        if (h0Var == h0.DEFAULT) {
            return null;
        }
        return h0Var;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != z$a.class) {
            return false;
        }
        z$a z_a = (z$a) obj;
        return z_a._nulls == this._nulls && z_a._contentNulls == this._contentNulls;
    }

    public int hashCode() {
        return this._nulls.ordinal() + (this._contentNulls.ordinal() << 2);
    }

    public Object readResolve() {
        h0 h0Var = this._nulls;
        h0 h0Var2 = this._contentNulls;
        h0 h0Var3 = h0.DEFAULT;
        return h0Var == h0Var3 && h0Var2 == h0Var3 ? j : this;
    }

    public String toString() {
        return String.format("JsonSetter.Value(valueNulls=%s,contentNulls=%s)", this._nulls, this._contentNulls);
    }
}
