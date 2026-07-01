package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.c.SerializerProvider;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.u.i, reason: use source file name */
/* JADX INFO: compiled from: ClassSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class ClassSerializer2 extends StdScalarSerializer<Class<?>> {
    public ClassSerializer2() {
        super(Class.class, false);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.j0(((Class) obj).getName());
    }
}
