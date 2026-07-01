package b.i.a.f.h.c;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends f {
    public final /* synthetic */ g a;

    public j(g gVar) {
        this.a = gVar;
    }

    @Override // b.i.a.f.h.c.f, b.i.a.f.h.c.r
    public final void O(Status status, Credential credential) {
        this.a.g(new e(status, credential));
    }

    @Override // b.i.a.f.h.c.r
    public final void l(Status status) {
        this.a.g(new e(status, null));
    }
}
