package b.g.a.c;

import b.g.a.c.c0.b0;
import b.g.a.c.c0.d0;
import b.g.a.c.c0.w$b;
import b.g.a.c.c0.w$c;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: SerializationConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends b.g.a.c.z.m<w, v> implements Serializable {
    public static final b.g.a.b.j l = new b.g.a.b.t.d();
    public static final int m = b.g.a.c.z.l.c(w.class);
    private static final long serialVersionUID = 1;
    public final b.g.a.b.j _defaultPrettyPrinter;
    public final b.g.a.c.g0.k _filterProvider;
    public final int _formatWriteFeatures;
    public final int _formatWriteFeaturesToChange;
    public final int _generatorFeatures;
    public final int _generatorFeaturesToChange;
    public final int _serFeatures;

    public v(b.g.a.c.z.a aVar, b.g.a.c.e0.d dVar, d0 d0Var, b.g.a.c.i0.p pVar, b.g.a.c.z.g gVar) {
        super(aVar, dVar, d0Var, pVar, gVar);
        this._serFeatures = m;
        this._defaultPrettyPrinter = l;
        this._generatorFeatures = 0;
        this._generatorFeaturesToChange = 0;
        this._formatWriteFeatures = 0;
        this._formatWriteFeaturesToChange = 0;
    }

    @Override // b.g.a.c.z.m
    public b.g.a.c.z.m r(int i) {
        return new v(this, i, this._serFeatures, this._generatorFeatures, this._generatorFeaturesToChange, this._formatWriteFeatures, this._formatWriteFeaturesToChange);
    }

    public c u(j jVar) {
        b.g.a.c.c0.w wVar;
        b.g.a.c.c0.r rVar = (b.g.a.c.c0.r) this._base._classIntrospector;
        b.g.a.c.c0.q qVarA = rVar.a(this, jVar);
        if (qVarA != null) {
            return qVarA;
        }
        boolean z2 = false;
        if (jVar.v() && !(jVar instanceof b.g.a.c.h0.a)) {
            Class<?> cls = jVar._class;
            if (b.g.a.c.i0.d.r(cls) && (Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls))) {
                z2 = true;
            }
        }
        b.g.a.c.c0.q qVarE = z2 ? b.g.a.c.c0.q.e(this, jVar, rVar.b(this, jVar, this)) : null;
        if (qVarE != null) {
            return qVarE;
        }
        b.g.a.c.c0.c cVarB = rVar.b(this, jVar, this);
        if (jVar.A()) {
            Objects.requireNonNull((w$b) this._base._accessorNaming);
            wVar = new w$c(this, cVarB);
        } else {
            w$b w_b = (w$b) this._base._accessorNaming;
            wVar = new b.g.a.c.c0.w(this, cVarB, w_b._setterPrefix, w_b._getterPrefix, w_b._isGetterPrefix, w_b._baseNameValidator);
        }
        return new b.g.a.c.c0.q(new b0(this, true, jVar, cVarB, wVar));
    }

    public final boolean v(w wVar) {
        return (wVar.g() & this._serFeatures) != 0;
    }

    public v(v vVar, int i, int i2, int i3, int i4, int i5, int i6) {
        super(vVar, i);
        this._serFeatures = i2;
        this._defaultPrettyPrinter = vVar._defaultPrettyPrinter;
        this._generatorFeatures = i3;
        this._generatorFeaturesToChange = i4;
        this._formatWriteFeatures = i5;
        this._formatWriteFeaturesToChange = i6;
    }
}
