package b.i.c.o.b;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.j.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends p<d, PendingDynamicLinkData> {
    public final String c;

    @Nullable
    public final b.i.c.j.a.a d;

    public i(b.i.c.j.a.a aVar, String str) {
        this.c = str;
        this.d = aVar;
    }

    @Override // b.i.a.f.e.h.j.p
    public final /* synthetic */ void c(a.b bVar, TaskCompletionSource<PendingDynamicLinkData> taskCompletionSource) throws RemoteException {
        d dVar = (d) bVar;
        try {
            ((j) dVar.w()).b0(new g(this.d, taskCompletionSource), this.c);
        } catch (RemoteException unused) {
        }
    }
}
