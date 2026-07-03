package p007b.p225i.p361c.p369m.p370d.p373k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import java.util.List;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4362f;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p380q.C4721b;
import p007b.p225i.p361c.p369m.p370d.p380q.C4721b.d;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4741b;

/* JADX INFO: renamed from: b.i.c.m.d.k.f0 */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4623f0 implements InterfaceC4362f<C4741b, Void> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ List f12286a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f12287b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Executor f12288c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ CallableC4626g0 f12289d;

    public C4623f0(CallableC4626g0 callableC4626g0, List list, boolean z2, Executor executor) {
        this.f12289d = callableC4626g0;
        this.f12286a = list;
        this.f12287b = z2;
        this.f12288c = executor;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4362f
    @NonNull
    /* JADX INFO: renamed from: a */
    public Task<Void> mo4013a(@Nullable C4741b c4741b) throws Exception {
        C4741b c4741b2 = c4741b;
        if (c4741b2 == null) {
            C4592b.f12227a.m6376g("Received null app settings, cannot send reports during app startup.");
            return C3404f.m4264Z(null);
        }
        for (InterfaceC4724c interfaceC4724c : this.f12286a) {
            if (interfaceC4724c.mo6675d() == 1) {
                C4663x.m6463c(c4741b2.f12753e, interfaceC4724c.mo6674c());
            }
        }
        C4663x.m6462b(C4663x.this);
        C4721b c4721bM6431a = ((C4629h0) C4663x.this.f12438r).m6431a(c4741b2);
        List list = this.f12286a;
        boolean z2 = this.f12287b;
        float f = this.f12289d.f12295k.f12448b;
        synchronized (c4721bM6431a) {
            if (c4721bM6431a.f12704h != null) {
                C4592b.f12227a.m6371b("Report upload has already been started.");
            } else {
                Thread thread = new Thread(c4721bM6431a.new d(list, z2, f), "Crashlytics Report Uploader");
                c4721bM6431a.f12704h = thread;
                thread.start();
            }
        }
        C4663x.this.f12422A.m6400b(this.f12288c, C1563b.m763m(c4741b2));
        C4663x.this.f12426E.m9126b(null);
        return C3404f.m4264Z(null);
    }
}
