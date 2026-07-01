package b.g.a.b;

import b.g.a.b.p.SerializedString;
import b.g.a.b.t.Separators;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.b.j, reason: use source file name */
/* JADX INFO: compiled from: PrettyPrinter.java */
/* JADX INFO: loaded from: classes3.dex */
public interface PrettyPrinter2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Separators f663b = new Separators();

    static {
        new SerializedString(" ");
    }

    void a(JsonGenerator jsonGenerator) throws IOException;

    void b(JsonGenerator jsonGenerator) throws IOException;

    void c(JsonGenerator jsonGenerator) throws IOException;

    void d(JsonGenerator jsonGenerator) throws IOException;

    void f(JsonGenerator jsonGenerator, int i) throws IOException;

    void g(JsonGenerator jsonGenerator) throws IOException;

    void h(JsonGenerator jsonGenerator) throws IOException;

    void i(JsonGenerator jsonGenerator) throws IOException;

    void j(JsonGenerator jsonGenerator, int i) throws IOException;

    void k(JsonGenerator jsonGenerator) throws IOException;
}
