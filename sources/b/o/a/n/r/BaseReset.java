package b.o.a.n.r;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.o.a.n.o.ActionHolder;
import b.o.a.n.o.BaseAction;

/* JADX INFO: renamed from: b.o.a.n.r.b, reason: use source file name */
/* JADX INFO: compiled from: BaseReset.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class BaseReset extends BaseAction {
    public boolean e;

    public BaseReset(boolean z2) {
        this.e = z2;
    }

    @Override // b.o.a.n.o.BaseAction
    public final void j(@NonNull ActionHolder actionHolder) {
        this.c = actionHolder;
        m(actionHolder, this.e ? new MeteringRectangle((Rect) k(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new Rect()), 0) : null);
    }

    public abstract void m(@NonNull ActionHolder actionHolder, @Nullable MeteringRectangle meteringRectangle);
}
