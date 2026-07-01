package b.g.a.b;

import java.io.Serializable;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: JsonFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends n implements Serializable {
    public static final int j = c$a.h();
    public static final int k = f$a.f();
    public static final int l = d$a.f();
    public static final k m = b.g.a.b.t.d.j;
    private static final long serialVersionUID = 2;
    public b.g.a.b.p.b _characterEscapes;
    public int _factoryFeatures;
    public int _generatorFeatures;
    public b.g.a.b.p.d _inputDecorator;
    public int _maximumNonEscapedChar;
    public i _objectCodec;
    public b.g.a.b.p.h _outputDecorator;
    public int _parserFeatures;
    public final char _quoteChar;
    public k _rootValueSeparator;

    public c() {
        this(null);
    }

    public b.g.a.b.t.a a() {
        SoftReference<b.g.a.b.t.a> softReference;
        if (!((c$a.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.g() & this._factoryFeatures) != 0)) {
            return new b.g.a.b.t.a();
        }
        SoftReference<b.g.a.b.t.a> softReference2 = b.g.a.b.t.b.f677b.get();
        b.g.a.b.t.a aVar = softReference2 == null ? null : softReference2.get();
        if (aVar == null) {
            aVar = new b.g.a.b.t.a();
            b.g.a.b.t.l lVar = b.g.a.b.t.b.a;
            if (lVar != null) {
                softReference = new SoftReference<>(aVar, lVar.f679b);
                lVar.a.put(softReference, Boolean.TRUE);
                while (true) {
                    SoftReference softReference3 = (SoftReference) lVar.f679b.poll();
                    if (softReference3 == null) {
                        break;
                    }
                    lVar.a.remove(softReference3);
                }
            } else {
                softReference = new SoftReference<>(aVar);
            }
            b.g.a.b.t.b.f677b.set(softReference);
        }
        return aVar;
    }

    public i b() {
        return this._objectCodec;
    }

    public Object readResolve() {
        return new c(this, this._objectCodec);
    }

    public c(i iVar) {
        b.g.a.b.r.b.a();
        b.g.a.b.r.a.a();
        this._factoryFeatures = j;
        this._parserFeatures = k;
        this._generatorFeatures = l;
        this._rootValueSeparator = m;
        this._objectCodec = iVar;
        this._quoteChar = '\"';
    }

    public c(c cVar, i iVar) {
        b.g.a.b.r.b.a();
        b.g.a.b.r.a.a();
        this._factoryFeatures = j;
        this._parserFeatures = k;
        this._generatorFeatures = l;
        this._rootValueSeparator = m;
        this._objectCodec = iVar;
        this._factoryFeatures = cVar._factoryFeatures;
        this._parserFeatures = cVar._parserFeatures;
        this._generatorFeatures = cVar._generatorFeatures;
        this._rootValueSeparator = cVar._rootValueSeparator;
        this._maximumNonEscapedChar = cVar._maximumNonEscapedChar;
        this._quoteChar = cVar._quoteChar;
    }
}
