package b.f.j.p;

import b.f.j.j.CloseableImage;
import b.f.j.p.PostprocessorProducer;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: renamed from: b.f.j.p.u0, reason: use source file name */
/* JADX INFO: compiled from: PostprocessorProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class PostprocessorProducer2 implements Runnable {
    public final /* synthetic */ PostprocessorProducer.b j;

    public PostprocessorProducer2(PostprocessorProducer.b bVar) {
        this.j = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        CloseableReference<CloseableImage> closeableReference;
        int i;
        boolean zS;
        synchronized (this.j) {
            PostprocessorProducer.b bVar = this.j;
            closeableReference = bVar.g;
            i = bVar.h;
            bVar.g = null;
            bVar.i = false;
        }
        if (CloseableReference.y(closeableReference)) {
            try {
                PostprocessorProducer.b.n(this.j, closeableReference, i);
                closeableReference.close();
            } catch (Throwable th) {
                if (closeableReference != null) {
                    closeableReference.close();
                }
                throw th;
            }
        }
        PostprocessorProducer.b bVar2 = this.j;
        synchronized (bVar2) {
            bVar2.j = false;
            zS = bVar2.s();
        }
        if (zS) {
            PostprocessorProducer.this.c.execute(new PostprocessorProducer2(bVar2));
        }
    }
}
