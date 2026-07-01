package b.f.j.a.a;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: AnimatedImageResult.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    public final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CloseableReference<Bitmap> f544b;
    public List<CloseableReference<Bitmap>> c;
    public b.f.j.t.a d;

    public e(f fVar) {
        c cVar = fVar.a;
        Objects.requireNonNull(cVar);
        this.a = cVar;
        this.f544b = CloseableReference.n(fVar.f545b);
        this.c = CloseableReference.q(fVar.c);
        this.d = fVar.e;
    }
}
