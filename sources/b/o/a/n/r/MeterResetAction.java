package b.o.a.n.r;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.o.a.n.o.ActionWrapper;
import b.o.a.n.o.BaseAction;

/* JADX INFO: renamed from: b.o.a.n.r.h, reason: use source file name */
/* JADX INFO: compiled from: MeterResetAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class MeterResetAction extends ActionWrapper {
    public final BaseAction e = b.i.a.f.e.o.f.x1(new ExposureReset(), new FocusReset(), new WhiteBalanceReset());

    @Override // b.o.a.n.o.ActionWrapper
    @NonNull
    public BaseAction m() {
        return this.e;
    }
}
