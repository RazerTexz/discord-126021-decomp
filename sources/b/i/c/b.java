package b.i.c;

import android.content.Context;

/* JADX INFO: compiled from: FirebaseApp.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements b.i.c.t.a {
    public final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1652b;

    public b(c cVar, Context context) {
        this.a = cVar;
        this.f1652b = context;
    }

    @Override // b.i.c.t.a
    public Object get() {
        c cVar = this.a;
        Context context = this.f1652b;
        Object obj = c.a;
        return new b.i.c.v.a(context, cVar.c(), (b.i.c.q.c) cVar.g.a(b.i.c.q.c.class));
    }
}
