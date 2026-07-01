package b.i.c.x;

import android.content.Context;

/* JADX INFO: compiled from: LibraryVersionComponent.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements b.i.c.l.f {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f1805b;

    public f(String str, g gVar) {
        this.a = str;
        this.f1805b = gVar;
    }

    @Override // b.i.c.l.f
    public Object a(b.i.c.l.e eVar) {
        return new a(this.a, this.f1805b.a((Context) eVar.a(Context.class)));
    }
}
