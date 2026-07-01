package b.i.c.k.d;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.firebase.appindexing.internal.zza;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends b.i.c.k.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f1661b;

    public b(Context context) {
        this.f1661b = new c(context);
    }

    @Override // b.i.c.k.b
    public final Task<Void> a(b.i.c.k.a aVar) {
        zza[] zzaVarArr = {(zza) aVar};
        zzaVarArr[0].n.j = 2;
        return this.f1661b.c(new d(zzaVarArr));
    }
}
