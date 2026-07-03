package p007b.p225i.p361c.p393p.p395h;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import p007b.p225i.p361c.p393p.InterfaceC4782a;

/* JADX INFO: renamed from: b.i.c.p.h.d */
/* JADX INFO: compiled from: JsonDataEncoderBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4793d implements InterfaceC4782a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4794e f12820a;

    public C4793d(C4794e c4794e) {
        this.f12820a = c4794e;
    }

    /* JADX INFO: renamed from: a */
    public String m6711a(@NonNull Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            m6712b(obj, stringWriter);
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    /* JADX INFO: renamed from: b */
    public void m6712b(@NonNull Object obj, @NonNull Writer writer) throws IOException {
        C4794e c4794e = this.f12820a;
        C4795f c4795f = new C4795f(writer, c4794e.f12822b, c4794e.f12823c, c4794e.f12824d, c4794e.f12825e);
        c4795f.m6713g(obj, false);
        c4795f.m6715i();
        c4795f.f12828b.flush();
    }
}
