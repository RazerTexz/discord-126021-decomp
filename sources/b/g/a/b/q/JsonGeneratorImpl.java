package b.g.a.b.q;

import b.g.a.b.JsonGenerator;
import b.g.a.b.ObjectCodec;
import b.g.a.b.SerializableString;
import b.g.a.b.o.GeneratorBase;
import b.g.a.b.p.CharTypes;
import b.g.a.b.p.IOContext;
import b.g.a.b.t.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.JsonGenerationException;
import java.io.IOException;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.g.a.b.q.b, reason: use source file name */
/* JADX INFO: compiled from: JsonGeneratorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class JsonGeneratorImpl extends GeneratorBase {
    public static final int[] r = CharTypes.f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final IOContext f671s;
    public int[] t;
    public int u;
    public SerializableString v;
    public boolean w;

    public JsonGeneratorImpl(IOContext iOContext, int i, ObjectCodec objectCodec) {
        super(i, objectCodec);
        this.t = r;
        this.v = DefaultPrettyPrinter.j;
        this.f671s = iOContext;
        if (JsonGenerator.a.ESCAPE_NON_ASCII.g(i)) {
            this.u = Opcodes.LAND;
        }
        this.w = !JsonGenerator.a.QUOTE_FIELD_NAMES.g(i);
    }

    @Override // b.g.a.b.JsonGenerator
    public JsonGenerator b(JsonGenerator.a aVar) {
        int iH = aVar.h();
        this.o &= ~iH;
        if ((iH & GeneratorBase.m) != 0) {
            if (aVar == JsonGenerator.a.WRITE_NUMBERS_AS_STRINGS) {
                this.p = false;
            } else if (aVar == JsonGenerator.a.ESCAPE_NON_ASCII) {
                y0(0);
            } else if (aVar == JsonGenerator.a.STRICT_DUPLICATE_DETECTION) {
                JsonWriteContext jsonWriteContext = this.q;
                jsonWriteContext.d = null;
                this.q = jsonWriteContext;
            }
        }
        if (aVar == JsonGenerator.a.QUOTE_FIELD_NAMES) {
            this.w = true;
        }
        return this;
    }

    @Override // b.g.a.b.o.GeneratorBase
    public void r0(int i, int i2) {
        if ((GeneratorBase.m & i2) != 0) {
            this.p = JsonGenerator.a.WRITE_NUMBERS_AS_STRINGS.g(i);
            JsonGenerator.a aVar = JsonGenerator.a.ESCAPE_NON_ASCII;
            if (aVar.g(i2)) {
                if (aVar.g(i)) {
                    y0(Opcodes.LAND);
                } else {
                    y0(0);
                }
            }
            JsonGenerator.a aVar2 = JsonGenerator.a.STRICT_DUPLICATE_DETECTION;
            if (aVar2.g(i2)) {
                if (aVar2.g(i)) {
                    JsonWriteContext jsonWriteContext = this.q;
                    if (jsonWriteContext.d == null) {
                        jsonWriteContext.d = new DupDetector(this);
                        this.q = jsonWriteContext;
                    }
                } else {
                    JsonWriteContext jsonWriteContext2 = this.q;
                    jsonWriteContext2.d = null;
                    this.q = jsonWriteContext2;
                }
            }
        }
        this.w = !JsonGenerator.a.QUOTE_FIELD_NAMES.g(i);
    }

    public void x0(String str) throws IOException {
        throw new JsonGenerationException(String.format("Can not %s, expecting field name (context: %s)", str, this.q.e()), this);
    }

    public JsonGenerator y0(int i) {
        if (i < 0) {
            i = 0;
        }
        this.u = i;
        return this;
    }
}
