package b.o.a.n.r;

import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.o.a.CameraLogger;
import b.o.a.n.o.ActionHolder;
import b.o.a.n.o.BaseAction;
import java.util.List;

/* JADX INFO: renamed from: b.o.a.n.r.a, reason: use source file name */
/* JADX INFO: compiled from: BaseMeter.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class BaseMeter extends BaseAction {
    public static final CameraLogger e = new CameraLogger(BaseMeter.class.getSimpleName());
    public final List<MeteringRectangle> f;
    public boolean g;
    public boolean h;

    public BaseMeter(@NonNull List<MeteringRectangle> list, boolean z2) {
        this.f = list;
        this.h = z2;
    }

    @Override // b.o.a.n.o.BaseAction
    public final void j(@NonNull ActionHolder actionHolder) {
        this.c = actionHolder;
        boolean z2 = this.h && n(actionHolder);
        if (m(actionHolder) && !z2) {
            e.a(1, "onStart:", "supported and not skipped. Dispatching onStarted.");
            o(actionHolder, this.f);
        } else {
            e.a(1, "onStart:", "not supported or skipped. Dispatching COMPLETED state.");
            this.g = true;
            l(Integer.MAX_VALUE);
        }
    }

    public abstract boolean m(@NonNull ActionHolder actionHolder);

    public abstract boolean n(@NonNull ActionHolder actionHolder);

    public abstract void o(@NonNull ActionHolder actionHolder, @NonNull List<MeteringRectangle> list);
}
