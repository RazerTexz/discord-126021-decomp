package b.i.c.p.h;

import androidx.annotation.NonNull;
import b.i.c.p.DataEncoder;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: renamed from: b.i.c.p.h.d, reason: use source file name */
/* JADX INFO: compiled from: JsonDataEncoderBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class JsonDataEncoderBuilder4 implements DataEncoder {
    public final /* synthetic */ JsonDataEncoderBuilder5 a;

    public JsonDataEncoderBuilder4(JsonDataEncoderBuilder5 jsonDataEncoderBuilder5) {
        this.a = jsonDataEncoderBuilder5;
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
        JsonDataEncoderBuilder5 jsonDataEncoderBuilder5 = this.a;
        JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(writer, jsonDataEncoderBuilder5.f1761b, jsonDataEncoderBuilder5.c, jsonDataEncoderBuilder5.d, jsonDataEncoderBuilder5.e);
        jsonValueObjectEncoderContext.g(obj, false);
        jsonValueObjectEncoderContext.i();
        jsonValueObjectEncoderContext.f1762b.flush();
    }
}
