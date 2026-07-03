package p007b.p225i.p361c.p401u;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p401u.p402o.AbstractC4854d;

/* JADX INFO: renamed from: b.i.c.u.i */
/* JADX INFO: compiled from: GetAuthTokenListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4845i implements InterfaceC4849m {

    /* JADX INFO: renamed from: a */
    public final C4850n f12943a;

    /* JADX INFO: renamed from: b */
    public final TaskCompletionSource<AbstractC4847k> f12944b;

    public C4845i(C4850n c4850n, TaskCompletionSource<AbstractC4847k> taskCompletionSource) {
        this.f12943a = c4850n;
        this.f12944b = taskCompletionSource;
    }

    @Override // p007b.p225i.p361c.p401u.InterfaceC4849m
    /* JADX INFO: renamed from: a */
    public boolean mo6767a(Exception exc) {
        this.f12944b.m9125a(exc);
        return true;
    }

    @Override // p007b.p225i.p361c.p401u.InterfaceC4849m
    /* JADX INFO: renamed from: b */
    public boolean mo6768b(AbstractC4854d abstractC4854d) {
        if (!abstractC4854d.m6791j() || this.f12943a.m6773d(abstractC4854d)) {
            return false;
        }
        TaskCompletionSource<AbstractC4847k> taskCompletionSource = this.f12944b;
        String strMo6774a = abstractC4854d.mo6774a();
        Objects.requireNonNull(strMo6774a, "Null token");
        Long lValueOf = Long.valueOf(abstractC4854d.mo6775b());
        Long lValueOf2 = Long.valueOf(abstractC4854d.mo6780g());
        String strM883w = lValueOf == null ? C1643a.m883w("", " tokenExpirationTimestamp") : "";
        if (lValueOf2 == null) {
            strM883w = C1643a.m883w(strM883w, " tokenCreationTimestamp");
        }
        if (!strM883w.isEmpty()) {
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
        }
        taskCompletionSource.f20845a.m6024s(new C4837a(strMo6774a, lValueOf.longValue(), lValueOf2.longValue(), null));
        return true;
    }
}
