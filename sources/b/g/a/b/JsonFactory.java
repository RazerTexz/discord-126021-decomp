package b.g.a.b;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonParser;
import b.g.a.b.p.CharacterEscapes;
import b.g.a.b.p.InputDecorator;
import b.g.a.b.p.OutputDecorator;
import b.g.a.b.r.ByteQuadsCanonicalizer;
import b.g.a.b.r.CharsToNameCanonicalizer;
import b.g.a.b.t.BufferRecycler;
import b.g.a.b.t.BufferRecyclers;
import b.g.a.b.t.DefaultPrettyPrinter;
import b.g.a.b.t.JacksonFeature;
import b.g.a.b.t.ThreadLocalBufferManager;
import java.io.Serializable;
import java.lang.ref.SoftReference;

/* JADX INFO: renamed from: b.g.a.b.c, reason: use source file name */
/* JADX INFO: compiled from: JsonFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class JsonFactory extends TokenStreamFactory implements Serializable {
    public static final int j = a.h();
    public static final int k = JsonParser.a.f();
    public static final int l = JsonGenerator.a.f();
    public static final SerializableString m = DefaultPrettyPrinter.j;
    private static final long serialVersionUID = 2;
    public CharacterEscapes _characterEscapes;
    public int _factoryFeatures;
    public int _generatorFeatures;
    public InputDecorator _inputDecorator;
    public int _maximumNonEscapedChar;
    public ObjectCodec _objectCodec;
    public OutputDecorator _outputDecorator;
    public int _parserFeatures;
    public final char _quoteChar;
    public SerializableString _rootValueSeparator;

    /* JADX INFO: renamed from: b.g.a.b.c$a */
    /* JADX INFO: compiled from: JsonFactory.java */
    public enum a implements JacksonFeature {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true),
        FAIL_ON_SYMBOL_HASH_OVERFLOW(true),
        USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING(true);

        private final boolean _defaultState;

        a(boolean z2) {
            this._defaultState = z2;
        }

        public static int h() {
            a[] aVarArrValues = values();
            int iG = 0;
            for (int i = 0; i < 4; i++) {
                a aVar = aVarArrValues[i];
                if (aVar._defaultState) {
                    iG |= aVar.g();
                }
            }
            return iG;
        }

        @Override // b.g.a.b.t.JacksonFeature
        public boolean f() {
            return this._defaultState;
        }

        @Override // b.g.a.b.t.JacksonFeature
        public int g() {
            return 1 << ordinal();
        }
    }

    public JsonFactory() {
        this(null);
    }

    public BufferRecycler a() {
        SoftReference<BufferRecycler> softReference;
        if (!((a.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.g() & this._factoryFeatures) != 0)) {
            return new BufferRecycler();
        }
        SoftReference<BufferRecycler> softReference2 = BufferRecyclers.f677b.get();
        BufferRecycler bufferRecycler = softReference2 == null ? null : softReference2.get();
        if (bufferRecycler == null) {
            bufferRecycler = new BufferRecycler();
            ThreadLocalBufferManager threadLocalBufferManager = BufferRecyclers.a;
            if (threadLocalBufferManager != null) {
                softReference = new SoftReference<>(bufferRecycler, threadLocalBufferManager.f679b);
                threadLocalBufferManager.a.put(softReference, Boolean.TRUE);
                while (true) {
                    SoftReference softReference3 = (SoftReference) threadLocalBufferManager.f679b.poll();
                    if (softReference3 == null) {
                        break;
                    }
                    threadLocalBufferManager.a.remove(softReference3);
                }
            } else {
                softReference = new SoftReference<>(bufferRecycler);
            }
            BufferRecyclers.f677b.set(softReference);
        }
        return bufferRecycler;
    }

    public ObjectCodec b() {
        return this._objectCodec;
    }

    public Object readResolve() {
        return new JsonFactory(this, this._objectCodec);
    }

    public JsonFactory(ObjectCodec objectCodec) {
        CharsToNameCanonicalizer.a();
        ByteQuadsCanonicalizer.a();
        this._factoryFeatures = j;
        this._parserFeatures = k;
        this._generatorFeatures = l;
        this._rootValueSeparator = m;
        this._objectCodec = objectCodec;
        this._quoteChar = '\"';
    }

    public JsonFactory(JsonFactory jsonFactory, ObjectCodec objectCodec) {
        CharsToNameCanonicalizer.a();
        ByteQuadsCanonicalizer.a();
        this._factoryFeatures = j;
        this._parserFeatures = k;
        this._generatorFeatures = l;
        this._rootValueSeparator = m;
        this._objectCodec = objectCodec;
        this._factoryFeatures = jsonFactory._factoryFeatures;
        this._parserFeatures = jsonFactory._parserFeatures;
        this._generatorFeatures = jsonFactory._generatorFeatures;
        this._rootValueSeparator = jsonFactory._rootValueSeparator;
        this._maximumNonEscapedChar = jsonFactory._maximumNonEscapedChar;
        this._quoteChar = jsonFactory._quoteChar;
    }
}
