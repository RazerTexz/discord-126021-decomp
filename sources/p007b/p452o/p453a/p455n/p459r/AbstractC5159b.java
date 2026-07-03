package p007b.p452o.p453a.p455n.p459r;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import p007b.p452o.p453a.p455n.p456o.AbstractC5145e;
import p007b.p452o.p453a.p455n.p456o.InterfaceC5143c;

/* JADX INFO: renamed from: b.o.a.n.r.b */
/* JADX INFO: compiled from: BaseReset.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class AbstractC5159b extends AbstractC5145e {

    /* JADX INFO: renamed from: e */
    public boolean f13969e;

    public AbstractC5159b(boolean z2) {
        this.f13969e = z2;
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e
    /* JADX INFO: renamed from: j */
    public final void mo7249j(@NonNull InterfaceC5143c interfaceC5143c) {
        this.f13939c = interfaceC5143c;
        mo7352m(interfaceC5143c, this.f13969e ? new MeteringRectangle((Rect) m7340k(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new Rect()), 0) : null);
    }

    /* JADX INFO: renamed from: m */
    public abstract void mo7352m(@NonNull InterfaceC5143c interfaceC5143c, @Nullable MeteringRectangle meteringRectangle);
}
