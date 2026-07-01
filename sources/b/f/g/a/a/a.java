package b.f.g.a.a;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import b.f.g.e.i;

/* JADX INFO: compiled from: DefaultDrawableFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b.f.j.i.a {
    public final Resources a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.j.i.a f476b;

    public a(Resources resources, b.f.j.i.a aVar) {
        this.a = resources;
        this.f476b = aVar;
    }

    @Override // b.f.j.i.a
    public boolean a(b.f.j.j.c cVar) {
        return true;
    }

    @Override // b.f.j.i.a
    public Drawable b(b.f.j.j.c cVar) {
        try {
            b.f.j.r.b.b();
            if (!(cVar instanceof b.f.j.j.d)) {
                b.f.j.i.a aVar = this.f476b;
                if (aVar == null || !aVar.a(cVar)) {
                    return null;
                }
                return this.f476b.b(cVar);
            }
            b.f.j.j.d dVar = (b.f.j.j.d) cVar;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.a, dVar.m);
            int i = dVar.o;
            if (!((i == 0 || i == -1) ? false : true)) {
                int i2 = dVar.p;
                if (!((i2 == 1 || i2 == 0) ? false : true)) {
                    return bitmapDrawable;
                }
            }
            return new i(bitmapDrawable, dVar.o, dVar.p);
        } finally {
            b.f.j.r.b.b();
        }
    }
}
