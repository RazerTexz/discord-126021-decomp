package b.i.c.m.d.k;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: CrashlyticsFileMarker.java */
/* JADX INFO: loaded from: classes3.dex */
public class m0 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.c.m.d.o.h f1690b;

    public m0(String str, b.i.c.m.d.o.h hVar) {
        this.a = str;
        this.f1690b = hVar;
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e) {
            b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
            StringBuilder sbU = b.d.b.a.a.U("Error creating marker: ");
            sbU.append(this.a);
            bVar.e(sbU.toString(), e);
            return false;
        }
    }

    public final File b() {
        return new File(this.f1690b.a(), this.a);
    }
}
