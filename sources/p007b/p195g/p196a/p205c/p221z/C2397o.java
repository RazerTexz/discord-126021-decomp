package p007b.p195g.p196a.p205c.p221z;

import java.io.Serializable;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2238g;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2249r;
import p007b.p195g.p196a.p205c.p219i0.C2340b;

/* JADX INFO: renamed from: b.g.a.c.z.o */
/* JADX INFO: compiled from: SerializerFactoryConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2397o implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final InterfaceC2249r[] f5097j = new InterfaceC2249r[0];

    /* JADX INFO: renamed from: k */
    public static final AbstractC2238g[] f5098k = new AbstractC2238g[0];
    private static final long serialVersionUID = 1;
    public final InterfaceC2249r[] _additionalKeySerializers;
    public final InterfaceC2249r[] _additionalSerializers;
    public final AbstractC2238g[] _modifiers;

    public C2397o() {
        InterfaceC2249r[] interfaceC2249rArr = f5097j;
        this._additionalSerializers = interfaceC2249rArr;
        this._additionalKeySerializers = interfaceC2249rArr;
        this._modifiers = f5098k;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2282a() {
        return this._modifiers.length > 0;
    }

    /* JADX INFO: renamed from: b */
    public Iterable<AbstractC2238g> m2283b() {
        return new C2340b(this._modifiers);
    }
}
