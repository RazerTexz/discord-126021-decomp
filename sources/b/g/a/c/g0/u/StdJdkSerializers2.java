package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.c.SerializerProvider;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: b.g.a.c.g0.u.l0, reason: use source file name */
/* JADX INFO: compiled from: StdJdkSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public class StdJdkSerializers2 extends StdScalarSerializer<AtomicInteger> {
    public StdJdkSerializers2() {
        super(AtomicInteger.class, false);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.H(((AtomicInteger) obj).get());
    }
}
