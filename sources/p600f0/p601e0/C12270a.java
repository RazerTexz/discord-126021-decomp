package p600f0.p601e0;

import androidx.core.app.NotificationCompat;
import p507d0.p592z.p594d.C12238m;
import p600f0.AbstractC12376t;
import p600f0.InterfaceC12269e;

/* JADX INFO: renamed from: f0.e0.a */
/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12270a implements AbstractC12376t.b {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractC12376t f25394a;

    public C12270a(AbstractC12376t abstractC12376t) {
        this.f25394a = abstractC12376t;
    }

    @Override // p600f0.AbstractC12376t.b
    /* JADX INFO: renamed from: a */
    public AbstractC12376t mo10115a(InterfaceC12269e interfaceC12269e) {
        C12238m.checkParameterIsNotNull(interfaceC12269e, NotificationCompat.CATEGORY_CALL);
        return this.f25394a;
    }
}
