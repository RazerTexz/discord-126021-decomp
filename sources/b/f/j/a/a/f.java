package b.f.j.a.a;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.List;

/* JADX INFO: compiled from: AnimatedImageResultBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    public final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CloseableReference<Bitmap> f545b;
    public List<CloseableReference<Bitmap>> c;
    public int d;
    public b.f.j.t.a e;

    public f(c cVar) {
        this.a = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e a() {
        try {
            e eVar = new e(this);
            CloseableReference<Bitmap> closeableReference = this.f545b;
            return eVar;
        } finally {
            CloseableReference<Bitmap> closeableReference2 = this.f545b;
            Class<CloseableReference> cls = CloseableReference.j;
            if (closeableReference2 != null) {
                closeableReference2.close();
            }
            this.f545b = null;
            CloseableReference.t(this.c);
            this.c = null;
        }
    }
}
