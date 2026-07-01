package b.i.c.p.h;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: compiled from: JsonDataEncoderBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements b.i.c.p.a {
    public final /* synthetic */ e a;

    public d(e eVar) {
        this.a = eVar;
    }

    public String a(@NonNull Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            b(obj, stringWriter);
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    public void b(@NonNull Object obj, @NonNull Writer writer) throws IOException {
        e eVar = this.a;
        f fVar = new f(writer, eVar.f1761b, eVar.c, eVar.d, eVar.e);
        fVar.g(obj, false);
        fVar.i();
        fVar.f1762b.flush();
    }
}
