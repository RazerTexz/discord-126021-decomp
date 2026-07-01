package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.c.SerializerProvider;
import java.io.File;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.u.o, reason: use source file name */
/* JADX INFO: compiled from: FileSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class FileSerializer extends StdScalarSerializer<File> {
    public FileSerializer() {
        super(File.class);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.j0(((File) obj).getAbsolutePath());
    }
}
