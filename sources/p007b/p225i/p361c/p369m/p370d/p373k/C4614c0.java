package p007b.p225i.p361c.p369m.p370d.p373k;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4362f;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p380q.C4721b;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.C4725d;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4741b;

/* JADX INFO: renamed from: b.i.c.m.d.k.c0 */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4614c0 implements InterfaceC4362f<C4741b, Void> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Executor f12270a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CallableC4617d0 f12271b;

    public C4614c0(CallableC4617d0 callableC4617d0, Executor executor) {
        this.f12271b = callableC4617d0;
        this.f12270a = executor;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4362f
    @NonNull
    /* JADX INFO: renamed from: a */
    public Task<Void> mo4013a(@Nullable C4741b c4741b) throws Exception {
        C4741b c4741b2 = c4741b;
        if (c4741b2 == null) {
            C4592b.f12227a.m6376g("Received null app settings, cannot send reports at crash time.");
            return C3404f.m4264Z(null);
        }
        C4663x c4663x = this.f12271b.f12277n;
        Context context = c4663x.f12429i;
        C4721b c4721bM6431a = ((C4629h0) c4663x.f12438r).m6431a(c4741b2);
        for (File file : c4663x.m6480q()) {
            C4663x.m6463c(c4741b2.f12753e, file);
            C4725d c4725d = new C4725d(file, C4663x.f12420f);
            C4631i c4631i = c4663x.f12433m;
            c4631i.m6437b(new CallableC4634j(c4631i, new C4663x.m(context, c4725d, c4721bM6431a, true)));
        }
        return C3404f.m4194B1(Arrays.asList(C4663x.m6462b(this.f12271b.f12277n), this.f12271b.f12277n.f12422A.m6400b(this.f12270a, C1563b.m763m(c4741b2))));
    }
}
