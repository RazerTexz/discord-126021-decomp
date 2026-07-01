package b.f.h.a.b.f;

import android.graphics.Bitmap;
import b.f.h.a.b.c;
import b.f.j.a.c.d;
import b.f.j.a.c.d$a;

/* JADX INFO: compiled from: AnimatedDrawableBackendFrameRenderer.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements c {
    public final b.f.h.a.b.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b.f.j.a.a.a f531b;
    public d c;
    public final d$a d;

    public b(b.f.h.a.b.b bVar, b.f.j.a.a.a aVar) {
        b$a b_a = new b$a(this);
        this.d = b_a;
        this.a = bVar;
        this.f531b = aVar;
        this.c = new d(aVar, b_a);
    }

    public boolean a(int i, Bitmap bitmap) {
        try {
            this.c.d(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            b.f.d.e.a.d(b.class, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
