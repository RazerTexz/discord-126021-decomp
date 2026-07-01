package b.o.a.n.p;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.o.a.n.o.ActionHolder;
import b.o.a.n.o.BaseAction;

/* JADX INFO: renamed from: b.o.a.n.p.a, reason: use source file name */
/* JADX INFO: compiled from: BaseLock.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class BaseLock extends BaseAction {
    @Override // b.o.a.n.o.BaseAction
    public final void j(@NonNull ActionHolder actionHolder) {
        this.c = actionHolder;
        boolean zN = n(actionHolder);
        if (!m(actionHolder) || zN) {
            l(Integer.MAX_VALUE);
        } else {
            o(actionHolder);
        }
    }

    public abstract boolean m(@NonNull ActionHolder actionHolder);

    public abstract boolean n(@NonNull ActionHolder actionHolder);

    public abstract void o(@NonNull ActionHolder actionHolder);
}
