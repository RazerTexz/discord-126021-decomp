package b.i.a.b.j.t.h;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes3.dex */
public class l {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.b.j.q.e f791b;
    public final b.i.a.b.j.t.i.c c;
    public final r d;
    public final Executor e;
    public final b.i.a.b.j.u.a f;
    public final b.i.a.b.j.v.a g;

    public l(Context context, b.i.a.b.j.q.e eVar, b.i.a.b.j.t.i.c cVar, r rVar, Executor executor, b.i.a.b.j.u.a aVar, b.i.a.b.j.v.a aVar2) {
        this.a = context;
        this.f791b = eVar;
        this.c = cVar;
        this.d = rVar;
        this.e = executor;
        this.f = aVar;
        this.g = aVar2;
    }

    public void a(b.i.a.b.j.i iVar, int i) {
        b.i.a.b.j.q.g gVarA;
        b.i.a.b.j.q.m mVar = this.f791b.get(iVar.b());
        Iterable iterable = (Iterable) this.f.a(new h(this, iVar));
        if (iterable.iterator().hasNext()) {
            if (mVar == null) {
                b.c.a.a0.d.X("Uploader", "Unknown backend for %s, deleting event batch for it...", iVar);
                gVarA = b.i.a.b.j.q.g.a();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((b.i.a.b.j.t.i.h) it.next()).a());
                }
                byte[] bArrC = iVar.c();
                if (1 == 0) {
                    throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", ""));
                }
                gVarA = mVar.a(new b.i.a.b.j.q.a(arrayList, bArrC, null));
            }
            this.f.a(new i(this, gVarA, iterable, iVar, i));
        }
    }
}
