package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.c.SerializerProvider;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.u.n0, reason: use source file name */
/* JADX INFO: compiled from: StdKeySerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class StdKeySerializer extends StdSerializer<Object> {
    public StdKeySerializer() {
        super(Object.class);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.y(obj.toString());
    }
}
