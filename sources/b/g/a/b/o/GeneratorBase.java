package b.g.a.b.o;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonStreamContext;
import b.g.a.b.ObjectCodec;
import b.g.a.b.q.DupDetector;
import b.g.a.b.q.JsonWriteContext;
import com.fasterxml.jackson.core.JsonGenerationException;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX INFO: renamed from: b.g.a.b.o.a, reason: use source file name */
/* JADX INFO: compiled from: GeneratorBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class GeneratorBase extends JsonGenerator {
    public static final int m = (JsonGenerator.a.WRITE_NUMBERS_AS_STRINGS.h() | JsonGenerator.a.ESCAPE_NON_ASCII.h()) | JsonGenerator.a.STRICT_DUPLICATE_DETECTION.h();
    public ObjectCodec n;
    public int o;
    public boolean p;
    public JsonWriteContext q;

    public GeneratorBase(int i, ObjectCodec objectCodec) {
        this.o = i;
        this.n = objectCodec;
        this.q = new JsonWriteContext(0, null, JsonGenerator.a.STRICT_DUPLICATE_DETECTION.g(i) ? new DupDetector(this) : null);
        this.p = JsonGenerator.a.WRITE_NUMBERS_AS_STRINGS.g(i);
    }

    @Override // b.g.a.b.JsonGenerator
    public void V(String str) throws IOException {
        t0("write raw value");
        T(str);
    }

    @Override // b.g.a.b.JsonGenerator
    public JsonStreamContext c() {
        return this.q;
    }

    @Override // b.g.a.b.JsonGenerator
    public final boolean d(JsonGenerator.a aVar) {
        return (aVar.h() & this.o) != 0;
    }

    @Override // b.g.a.b.JsonGenerator
    public void e(Object obj) {
        JsonWriteContext jsonWriteContext = this.q;
        if (jsonWriteContext != null) {
            jsonWriteContext.g = obj;
        }
    }

    public String o0(BigDecimal bigDecimal) throws IOException {
        if (!JsonGenerator.a.WRITE_BIGDECIMAL_AS_PLAIN.g(this.o)) {
            return bigDecimal.toString();
        }
        int iScale = bigDecimal.scale();
        if (iScale < -9999 || iScale > 9999) {
            throw new JsonGenerationException(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(iScale), 9999, 9999), this);
        }
        return bigDecimal.toPlainString();
    }

    public abstract void r0(int i, int i2);

    public abstract void t0(String str) throws IOException;

    public JsonGenerator w0(int i, int i2) {
        int i3 = this.o;
        int i4 = (i & i2) | ((~i2) & i3);
        int i5 = i3 ^ i4;
        if (i5 != 0) {
            this.o = i4;
            r0(i4, i5);
        }
        return this;
    }
}
