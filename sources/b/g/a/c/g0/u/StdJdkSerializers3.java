package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.c.SerializerProvider;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: b.g.a.c.g0.u.m0, reason: use source file name */
/* JADX INFO: compiled from: StdJdkSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public class StdJdkSerializers3 extends StdScalarSerializer<AtomicLong> {
    public StdJdkSerializers3() {
        super(AtomicLong.class, false);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.I(((AtomicLong) obj).get());
    }
}
