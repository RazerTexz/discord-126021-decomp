package p007b.p195g.p196a.p205c;

import java.io.Serializable;
import p007b.p195g.p196a.p205c.p210c0.C2180d0;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2212d;
import p007b.p195g.p196a.p205c.p214f0.C2230a;
import p007b.p195g.p196a.p205c.p219i0.C2347i;
import p007b.p195g.p196a.p205c.p219i0.C2354p;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;
import p007b.p195g.p196a.p205c.p221z.AbstractC2395m;
import p007b.p195g.p196a.p205c.p221z.C2383a;
import p007b.p195g.p196a.p205c.p221z.C2386d;
import p007b.p195g.p196a.p205c.p221z.C2389g;
import p007b.p195g.p196a.p205c.p221z.C2390h;

/* JADX INFO: renamed from: b.g.a.c.f */
/* JADX INFO: compiled from: DeserializationConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2229f extends AbstractC2395m<EnumC2321h, C2229f> implements Serializable {

    /* JADX INFO: renamed from: l */
    public static final int f4781l = AbstractC2394l.m2264c(EnumC2321h.class);
    private static final long serialVersionUID = 2;
    public final C2386d _coercionConfigs;
    public final C2390h _ctorDetector;
    public final int _deserFeatures;
    public final int _formatReadFeatures;
    public final int _formatReadFeaturesToChange;
    public final C2230a _nodeFactory;
    public final int _parserFeatures;
    public final int _parserFeaturesToChange;
    public final C2347i<?> _problemHandlers;

    public C2229f(C2383a c2383a, AbstractC2212d abstractC2212d, C2180d0 c2180d0, C2354p c2354p, C2389g c2389g, C2386d c2386d) {
        super(c2383a, abstractC2212d, c2180d0, c2354p, c2389g);
        this._deserFeatures = f4781l;
        this._nodeFactory = C2230a.f4783k;
        this._ctorDetector = null;
        this._coercionConfigs = c2386d;
        this._parserFeatures = 0;
        this._parserFeaturesToChange = 0;
        this._formatReadFeatures = 0;
        this._formatReadFeaturesToChange = 0;
    }

    @Override // p007b.p195g.p196a.p205c.p221z.AbstractC2395m
    /* JADX INFO: renamed from: r */
    public AbstractC2395m mo1969r(int i) {
        return new C2229f(this, i, this._deserFeatures, this._parserFeatures, this._parserFeaturesToChange, this._formatReadFeatures, this._formatReadFeaturesToChange);
    }

    public C2229f(C2229f c2229f, int i, int i2, int i3, int i4, int i5, int i6) {
        super(c2229f, i);
        this._deserFeatures = i2;
        this._nodeFactory = c2229f._nodeFactory;
        this._coercionConfigs = c2229f._coercionConfigs;
        this._ctorDetector = c2229f._ctorDetector;
        this._parserFeatures = i3;
        this._parserFeaturesToChange = i4;
        this._formatReadFeatures = i5;
        this._formatReadFeaturesToChange = i6;
    }
}
