package p007b.p225i.p361c.p365k.p367d;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.firebase.appindexing.internal.zza;
import p007b.p225i.p361c.p365k.AbstractC4561b;
import p007b.p225i.p361c.p365k.InterfaceC4560a;

/* JADX INFO: renamed from: b.i.c.k.d.b */
/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4564b extends AbstractC4561b {

    /* JADX INFO: renamed from: b */
    public C4565c f12170b;

    public C4564b(Context context) {
        this.f12170b = new C4565c(context);
    }

    @Override // p007b.p225i.p361c.p365k.AbstractC4561b
    /* JADX INFO: renamed from: a */
    public final Task<Void> mo6345a(InterfaceC4560a interfaceC4560a) {
        zza[] zzaVarArr = {(zza) interfaceC4560a};
        zzaVarArr[0].f21409n.f21412j = 2;
        return this.f12170b.m4046c(new C4566d(zzaVarArr));
    }
}
