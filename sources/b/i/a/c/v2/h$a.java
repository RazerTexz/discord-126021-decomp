package b.i.a.c.v2;

import java.util.Objects;

/* JADX INFO: compiled from: SimpleDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public class h$a extends Thread {
    public final /* synthetic */ h j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$a(h hVar, String str) {
        super(str);
        this.j = hVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        h hVar = this.j;
        Objects.requireNonNull(hVar);
        do {
            try {
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        } while (hVar.f());
    }
}
