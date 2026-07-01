package b.o.a.n.r;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: BaseReset.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class b extends b.o.a.n.o.e {
    public boolean e;

    public b(boolean z2) {
        this.e = z2;
    }

    @Override // b.o.a.n.o.e
    public final void j(@NonNull b.o.a.n.o.c cVar) {
        this.c = cVar;
        m(cVar, this.e ? new MeteringRectangle((Rect) k(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new Rect()), 0) : null);
    }

    public abstract void m(@NonNull b.o.a.n.o.c cVar, @Nullable MeteringRectangle meteringRectangle);
}
