package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.c.SerializerProvider;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: b.g.a.c.g0.u.k0, reason: use source file name */
/* JADX INFO: compiled from: StdJdkSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public class StdJdkSerializers extends StdScalarSerializer<AtomicBoolean> {
    public StdJdkSerializers() {
        super(AtomicBoolean.class, false);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.s(((AtomicBoolean) obj).get());
    }
}
