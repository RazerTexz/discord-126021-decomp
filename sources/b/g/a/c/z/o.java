package b.g.a.c.z;

import b.g.a.c.g0.r;
import java.io.Serializable;

/* JADX INFO: compiled from: SerializerFactoryConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements Serializable {
    public static final r[] j = new r[0];
    public static final b.g.a.c.g0.g[] k = new b.g.a.c.g0.g[0];
    private static final long serialVersionUID = 1;
    public final r[] _additionalKeySerializers;
    public final r[] _additionalSerializers;
    public final b.g.a.c.g0.g[] _modifiers;

    public o() {
        r[] rVarArr = j;
        this._additionalSerializers = rVarArr;
        this._additionalKeySerializers = rVarArr;
        this._modifiers = k;
    }

    public boolean a() {
        return this._modifiers.length > 0;
    }

    public Iterable<b.g.a.c.g0.g> b() {
        return new b.g.a.c.i0.b(this._modifiers);
    }
}
