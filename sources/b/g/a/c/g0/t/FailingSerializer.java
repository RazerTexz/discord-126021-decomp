package b.g.a.c.g0.t;

import b.g.a.b.JsonGenerator;
import b.g.a.c.SerializerProvider;
import b.g.a.c.g0.u.StdSerializer;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.t.c, reason: use source file name */
/* JADX INFO: compiled from: FailingSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class FailingSerializer extends StdSerializer<Object> {
    public final String _msg;

    public FailingSerializer(String str) {
        super(Object.class);
        this._msg = str;
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        serializerProvider.G(this._msg, new Object[0]);
        throw null;
    }
}
