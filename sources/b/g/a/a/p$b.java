package b.g.a.a;

import java.io.Serializable;

/* JADX INFO: compiled from: JsonInclude.java */
/* JADX INFO: loaded from: classes3.dex */
public class p$b implements Serializable {
    public static final p$b j;
    private static final long serialVersionUID = 1;
    public final Class<?> _contentFilter;
    public final p$a _contentInclusion;
    public final Class<?> _valueFilter;
    public final p$a _valueInclusion;

    static {
        p$a p_a = p$a.USE_DEFAULTS;
        j = new p$b(p_a, p_a, null, null);
    }

    public p$b(p$a p_a, p$a p_a2, Class<?> cls, Class<?> cls2) {
        p$a p_a3 = p$a.USE_DEFAULTS;
        this._valueInclusion = p_a == null ? p_a3 : p_a;
        this._contentInclusion = p_a2 == null ? p_a3 : p_a2;
        this._valueFilter = cls == Void.class ? null : cls;
        this._contentFilter = cls2 == Void.class ? null : cls2;
    }

    public p$b a(p$b p_b) {
        p$a p_a = p$a.USE_DEFAULTS;
        if (p_b != null && p_b != j) {
            p$a p_a2 = p_b._valueInclusion;
            p$a p_a3 = p_b._contentInclusion;
            Class<?> cls = p_b._valueFilter;
            Class<?> cls2 = p_b._contentFilter;
            p$a p_a4 = this._valueInclusion;
            boolean z2 = true;
            boolean z3 = (p_a2 == p_a4 || p_a2 == p_a) ? false : true;
            p$a p_a5 = this._contentInclusion;
            boolean z4 = (p_a3 == p_a5 || p_a3 == p_a) ? false : true;
            Class<?> cls3 = this._valueFilter;
            if (cls == cls3 && cls2 == cls3) {
                z2 = false;
            }
            if (z3) {
                return z4 ? new p$b(p_a2, p_a3, cls, cls2) : new p$b(p_a2, p_a5, cls, cls2);
            }
            if (z4) {
                return new p$b(p_a4, p_a3, cls, cls2);
            }
            if (z2) {
                return new p$b(p_a4, p_a5, cls, cls2);
            }
        }
        return this;
    }

    public p$b b(p$a p_a) {
        return p_a == this._valueInclusion ? this : new p$b(p_a, this._contentInclusion, this._valueFilter, this._contentFilter);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != p$b.class) {
            return false;
        }
        p$b p_b = (p$b) obj;
        return p_b._valueInclusion == this._valueInclusion && p_b._contentInclusion == this._contentInclusion && p_b._valueFilter == this._valueFilter && p_b._contentFilter == this._contentFilter;
    }

    public int hashCode() {
        return this._contentInclusion.hashCode() + (this._valueInclusion.hashCode() << 2);
    }

    public Object readResolve() {
        p$a p_a = this._valueInclusion;
        p$a p_a2 = p$a.USE_DEFAULTS;
        return (p_a == p_a2 && this._contentInclusion == p_a2 && this._valueFilter == null && this._contentFilter == null) ? j : this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(80);
        sb.append("JsonInclude.Value(value=");
        sb.append(this._valueInclusion);
        sb.append(",content=");
        sb.append(this._contentInclusion);
        if (this._valueFilter != null) {
            sb.append(",valueFilter=");
            b.d.b.a.a.k0(this._valueFilter, sb, ".class");
        }
        if (this._contentFilter != null) {
            sb.append(",contentFilter=");
            b.d.b.a.a.k0(this._contentFilter, sb, ".class");
        }
        sb.append(')');
        return sb.toString();
    }
}
