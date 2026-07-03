package p007b.p225i.p361c.p401u;

import com.google.android.gms.tasks.TaskCompletionSource;
import p007b.p225i.p361c.p401u.p402o.AbstractC4854d;
import p007b.p225i.p361c.p401u.p402o.C4853c;

/* JADX INFO: renamed from: b.i.c.u.j */
/* JADX INFO: compiled from: GetIdListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4846j implements InterfaceC4849m {

    /* JADX INFO: renamed from: a */
    public final TaskCompletionSource<String> f12945a;

    public C4846j(TaskCompletionSource<String> taskCompletionSource) {
        this.f12945a = taskCompletionSource;
    }

    @Override // p007b.p225i.p361c.p401u.InterfaceC4849m
    /* JADX INFO: renamed from: a */
    public boolean mo6767a(Exception exc) {
        return false;
    }

    @Override // p007b.p225i.p361c.p401u.InterfaceC4849m
    /* JADX INFO: renamed from: b */
    public boolean mo6768b(AbstractC4854d abstractC4854d) {
        if (!(abstractC4854d.mo6779f() == C4853c.a.UNREGISTERED) && !abstractC4854d.m6791j() && !abstractC4854d.m6789h()) {
            return false;
        }
        this.f12945a.m9126b(abstractC4854d.mo6776c());
        return true;
    }
}
