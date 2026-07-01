package b.o.a.n.p;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.i.a.f.e.o.f;
import b.o.a.n.o.ActionWrapper;
import b.o.a.n.o.BaseAction;

/* JADX INFO: renamed from: b.o.a.n.p.d, reason: use source file name */
/* JADX INFO: compiled from: LockAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class LockAction extends ActionWrapper {
    public final BaseAction e = f.x1(new ExposureLock(), new FocusLock(), new WhiteBalanceLock());

    @Override // b.o.a.n.o.ActionWrapper
    @NonNull
    public BaseAction m() {
        return this.e;
    }
}
