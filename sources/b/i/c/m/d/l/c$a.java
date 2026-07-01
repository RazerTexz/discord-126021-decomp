package b.i.c.m.d.l;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: QueueFile.java */
/* JADX INFO: loaded from: classes3.dex */
public class c$a implements c$d {
    public boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StringBuilder f1708b;

    public c$a(c cVar, StringBuilder sb) {
        this.f1708b = sb;
    }

    @Override // b.i.c.m.d.l.c$d
    public void a(InputStream inputStream, int i) throws IOException {
        if (this.a) {
            this.a = false;
        } else {
            this.f1708b.append(", ");
        }
        this.f1708b.append(i);
    }
}
