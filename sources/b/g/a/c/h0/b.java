package b.g.a.c.h0;

import java.io.Serializable;

/* JADX INFO: compiled from: ClassKey.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements Comparable<b>, Serializable {
    private static final long serialVersionUID = 1;
    private Class<?> _class;
    private String _className;
    private int _hashCode;

    public b() {
        this._class = null;
        this._className = null;
        this._hashCode = 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(b bVar) {
        return this._className.compareTo(bVar._className);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass() == b.class && ((b) obj)._class == this._class;
    }

    public int hashCode() {
        return this._hashCode;
    }

    public String toString() {
        return this._className;
    }

    public b(Class<?> cls) {
        this._class = cls;
        String name = cls.getName();
        this._className = name;
        this._hashCode = name.hashCode();
    }
}
