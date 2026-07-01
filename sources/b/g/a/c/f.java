package b.g.a.c;

import b.g.a.c.c0.d0;
import java.io.Serializable;

/* JADX INFO: compiled from: DeserializationConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends b.g.a.c.z.m<h, f> implements Serializable {
    public static final int l = b.g.a.c.z.l.c(h.class);
    private static final long serialVersionUID = 2;
    public final b.g.a.c.z.d _coercionConfigs;
    public final b.g.a.c.z.h _ctorDetector;
    public final int _deserFeatures;
    public final int _formatReadFeatures;
    public final int _formatReadFeaturesToChange;
    public final b.g.a.c.f0.a _nodeFactory;
    public final int _parserFeatures;
    public final int _parserFeaturesToChange;
    public final b.g.a.c.i0.i<?> _problemHandlers;

    public f(b.g.a.c.z.a aVar, b.g.a.c.e0.d dVar, d0 d0Var, b.g.a.c.i0.p pVar, b.g.a.c.z.g gVar, b.g.a.c.z.d dVar2) {
        super(aVar, dVar, d0Var, pVar, gVar);
        this._deserFeatures = l;
        this._nodeFactory = b.g.a.c.f0.a.k;
        this._ctorDetector = null;
        this._coercionConfigs = dVar2;
        this._parserFeatures = 0;
        this._parserFeaturesToChange = 0;
        this._formatReadFeatures = 0;
        this._formatReadFeaturesToChange = 0;
    }

    @Override // b.g.a.c.z.m
    public b.g.a.c.z.m r(int i) {
        return new f(this, i, this._deserFeatures, this._parserFeatures, this._parserFeaturesToChange, this._formatReadFeatures, this._formatReadFeaturesToChange);
    }

    public f(f fVar, int i, int i2, int i3, int i4, int i5, int i6) {
        super(fVar, i);
        this._deserFeatures = i2;
        this._nodeFactory = fVar._nodeFactory;
        this._coercionConfigs = fVar._coercionConfigs;
        this._ctorDetector = fVar._ctorDetector;
        this._parserFeatures = i3;
        this._parserFeaturesToChange = i4;
        this._formatReadFeatures = i5;
        this._formatReadFeaturesToChange = i6;
    }
}
