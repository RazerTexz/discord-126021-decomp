package b.o.a.w;

import java.util.Iterator;

/* JADX INFO: compiled from: GlCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$c$a implements Runnable {
    public final /* synthetic */ int j;
    public final /* synthetic */ d$c k;

    public d$c$a(d$c d_c, int i) {
        this.k = d_c;
        this.j = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<f> it = this.k.j.m.iterator();
        while (it.hasNext()) {
            it.next().b(this.j);
        }
    }
}
