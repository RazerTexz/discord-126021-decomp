package b.g.a.c.c0;

import java.io.Serializable;

/* JADX INFO: compiled from: VisibilityChecker.java */
/* JADX INFO: loaded from: classes3.dex */
public class g0$a implements g0<g0$a>, Serializable {
    public static final g0$a j;
    private static final long serialVersionUID = 1;
    public final b.g.a.a.e$a _creatorMinLevel;
    public final b.g.a.a.e$a _fieldMinLevel;
    public final b.g.a.a.e$a _getterMinLevel;
    public final b.g.a.a.e$a _isGetterMinLevel;
    public final b.g.a.a.e$a _setterMinLevel;

    static {
        b.g.a.a.e$a e_a = b.g.a.a.e$a.PUBLIC_ONLY;
        b.g.a.a.e$a e_a2 = b.g.a.a.e$a.ANY;
        j = new g0$a(e_a, e_a, e_a2, e_a2, e_a);
    }

    public g0$a(b.g.a.a.e$a e_a, b.g.a.a.e$a e_a2, b.g.a.a.e$a e_a3, b.g.a.a.e$a e_a4, b.g.a.a.e$a e_a5) {
        this._getterMinLevel = e_a;
        this._isGetterMinLevel = e_a2;
        this._setterMinLevel = e_a3;
        this._creatorMinLevel = e_a4;
        this._fieldMinLevel = e_a5;
    }

    public final b.g.a.a.e$a a(b.g.a.a.e$a e_a, b.g.a.a.e$a e_a2) {
        return e_a2 == b.g.a.a.e$a.DEFAULT ? e_a : e_a2;
    }

    public g0$a b(b.g.a.a.e$a e_a, b.g.a.a.e$a e_a2, b.g.a.a.e$a e_a3, b.g.a.a.e$a e_a4, b.g.a.a.e$a e_a5) {
        return (e_a == this._getterMinLevel && e_a2 == this._isGetterMinLevel && e_a3 == this._setterMinLevel && e_a4 == this._creatorMinLevel && e_a5 == this._fieldMinLevel) ? this : new g0$a(e_a, e_a2, e_a3, e_a4, e_a5);
    }

    public String toString() {
        return String.format("[Visibility: getter=%s,isGetter=%s,setter=%s,creator=%s,field=%s]", this._getterMinLevel, this._isGetterMinLevel, this._setterMinLevel, this._creatorMinLevel, this._fieldMinLevel);
    }
}
