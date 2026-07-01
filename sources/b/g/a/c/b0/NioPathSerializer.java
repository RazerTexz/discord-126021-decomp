package b.g.a.c.b0;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.u.StdScalarSerializer;
import java.io.IOException;
import java.nio.file.Path;

/* JADX INFO: renamed from: b.g.a.c.b0.e, reason: use source file name */
/* JADX INFO: compiled from: NioPathSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class NioPathSerializer extends StdScalarSerializer<Path> {
    private static final long serialVersionUID = 1;

    public NioPathSerializer() {
        super(Path.class);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.j0(((Path) obj).toUri().toString());
    }

    @Override // b.g.a.c.g0.u.StdScalarSerializer, b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Path path = (Path) obj;
        WritableTypeId writableTypeIdD = typeSerializer.d(path, JsonToken2.VALUE_STRING);
        writableTypeIdD.f675b = Path.class;
        WritableTypeId writableTypeIdE = typeSerializer.e(jsonGenerator, writableTypeIdD);
        jsonGenerator.j0(path.toUri().toString());
        typeSerializer.f(jsonGenerator, writableTypeIdE);
    }
}
