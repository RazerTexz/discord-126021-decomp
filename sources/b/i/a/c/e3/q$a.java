package b.i.a.c.e3;

import android.content.Context;

/* JADX INFO: compiled from: DefaultDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q$a implements l$a {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l$a f949b;

    public q$a(Context context) {
        r$b r_b = new r$b();
        this.a = context.getApplicationContext();
        this.f949b = r_b;
    }

    @Override // b.i.a.c.e3.l$a
    public /* bridge */ /* synthetic */ l a() {
        return b();
    }

    public q b() {
        return new q(this.a, this.f949b.a());
    }
}
