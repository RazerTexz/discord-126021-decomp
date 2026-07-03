package p007b.p195g.p196a.p205c.p218h0;

import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.c.h0.b */
/* JADX INFO: compiled from: ClassKey.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2323b implements Comparable<C2323b>, Serializable {
    private static final long serialVersionUID = 1;
    private Class<?> _class;
    private String _className;
    private int _hashCode;

    public C2323b() {
        this._class = null;
        this._className = null;
        this._hashCode = 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(C2323b c2323b) {
        return this._className.compareTo(c2323b._className);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass() == C2323b.class && ((C2323b) obj)._class == this._class;
    }

    public int hashCode() {
        return this._hashCode;
    }

    public String toString() {
        return this._className;
    }

    public C2323b(Class<?> cls) {
        this._class = cls;
        String name = cls.getName();
        this._className = name;
        this._hashCode = name.hashCode();
    }
}
