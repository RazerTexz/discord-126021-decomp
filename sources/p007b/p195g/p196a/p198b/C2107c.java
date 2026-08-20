package p007b.p195g.p196a.p198b;

import java.io.Serializable;
import java.lang.ref.SoftReference;
import p007b.p195g.p196a.p198b.p200p.AbstractC2122b;
import p007b.p195g.p196a.p198b.p200p.AbstractC2124d;
import p007b.p195g.p196a.p198b.p200p.AbstractC2128h;
import p007b.p195g.p196a.p198b.p202r.C2135a;
import p007b.p195g.p196a.p198b.p202r.C2136b;
import p007b.p195g.p196a.p198b.p204t.C2139a;
import p007b.p195g.p196a.p198b.p204t.C2140b;
import p007b.p195g.p196a.p198b.p204t.C2142d;
import p007b.p195g.p196a.p198b.p204t.C2150l;
import p007b.p195g.p196a.p198b.p204t.InterfaceC2145g;

/* JADX INFO: renamed from: b.g.a.b.c */
/* JADX INFO: compiled from: JsonFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2107c extends AbstractC2118n implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final int f4455j = a.m1628h();

    /* JADX INFO: renamed from: k */
    public static final int f4456k = AbstractC2110f.a.m1672f();

    /* JADX INFO: renamed from: l */
    public static final int f4457l = AbstractC2108d.a.m1667f();

    /* JADX INFO: renamed from: m */
    public static final InterfaceC2115k f4458m = C2142d.f4599j;
    private static final long serialVersionUID = 2;
    public AbstractC2122b _characterEscapes;
    public int _factoryFeatures;
    public int _generatorFeatures;
    public AbstractC2124d _inputDecorator;
    public int _maximumNonEscapedChar;
    public AbstractC2113i _objectCodec;
    public AbstractC2128h _outputDecorator;
    public int _parserFeatures;
    public final char _quoteChar;
    public InterfaceC2115k _rootValueSeparator;

    /* JADX INFO: renamed from: b.g.a.b.c$a */
    /* JADX INFO: compiled from: JsonFactory.java */
    public enum a implements InterfaceC2145g {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true),
        FAIL_ON_SYMBOL_HASH_OVERFLOW(true),
        USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING(true);

        private final boolean _defaultState;

        a(boolean z2) {
            this._defaultState = z2;
        }

        /* JADX INFO: renamed from: h */
        public static int m1628h() {
            a[] aVarArrValues = values();
            int iMo1630g = 0;
            for (int i = 0; i < 4; i++) {
                a aVar = aVarArrValues[i];
                if (aVar._defaultState) {
                    iMo1630g |= aVar.mo1630g();
                }
            }
            return iMo1630g;
        }

        @Override // p007b.p195g.p196a.p198b.p204t.InterfaceC2145g
        /* JADX INFO: renamed from: f */
        public boolean mo1629f() {
            return this._defaultState;
        }

        @Override // p007b.p195g.p196a.p198b.p204t.InterfaceC2145g
        /* JADX INFO: renamed from: g */
        public int mo1630g() {
            return 1 << ordinal();
        }
    }

    public C2107c() {
        this(null);
    }

    /* JADX INFO: renamed from: a */
    public C2139a m1626a() {
        SoftReference<C2139a> softReference;
        if (!((a.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.mo1630g() & this._factoryFeatures) != 0)) {
            return new C2139a();
        }
        SoftReference<C2139a> softReference2 = C2140b.f4596b.get();
        C2139a c2139a = softReference2 == null ? null : softReference2.get();
        if (c2139a == null) {
            c2139a = new C2139a();
            C2150l c2150l = C2140b.f4595a;
            if (c2150l != null) {
                softReference = new SoftReference<>(c2139a, c2150l.f4615b);
                c2150l.f4614a.put(softReference, Boolean.TRUE);
                while (true) {
                    SoftReference softReference3 = (SoftReference) c2150l.f4615b.poll();
                    if (softReference3 == null) {
                        break;
                    }
                    c2150l.f4614a.remove(softReference3);
                }
            } else {
                softReference = new SoftReference<>(c2139a);
            }
            C2140b.f4596b.set(softReference);
        }
        return c2139a;
    }

    /* JADX INFO: renamed from: b */
    public AbstractC2113i mo1627b() {
        return this._objectCodec;
    }

    public Object readResolve() {
        return new C2107c(this, this._objectCodec);
    }

    public C2107c(AbstractC2113i abstractC2113i) {
        C2136b.m1726a();
        C2135a.m1725a();
        this._factoryFeatures = f4455j;
        this._parserFeatures = f4456k;
        this._generatorFeatures = f4457l;
        this._rootValueSeparator = f4458m;
        this._objectCodec = abstractC2113i;
        this._quoteChar = '\"';
    }

    public C2107c(C2107c c2107c, AbstractC2113i abstractC2113i) {
        C2136b.m1726a();
        C2135a.m1725a();
        this._factoryFeatures = f4455j;
        this._parserFeatures = f4456k;
        this._generatorFeatures = f4457l;
        this._rootValueSeparator = f4458m;
        this._objectCodec = abstractC2113i;
        this._factoryFeatures = c2107c._factoryFeatures;
        this._parserFeatures = c2107c._parserFeatures;
        this._generatorFeatures = c2107c._generatorFeatures;
        this._rootValueSeparator = c2107c._rootValueSeparator;
        this._maximumNonEscapedChar = c2107c._maximumNonEscapedChar;
        this._quoteChar = c2107c._quoteChar;
    }
}
