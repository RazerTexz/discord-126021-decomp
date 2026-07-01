package b.i.a.f.e.k;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i0<TListener> {

    @Nullable
    public TListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1387b = false;
    public final /* synthetic */ b c;

    public i0(b bVar, TListener tlistener) {
        this.c = bVar;
        this.a = tlistener;
    }

    public abstract void a();

    public abstract void b(TListener tlistener);

    public final void c() {
        synchronized (this) {
            this.a = null;
        }
        synchronized (this.c.m) {
            this.c.m.remove(this);
        }
    }
}
