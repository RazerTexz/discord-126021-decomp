package b.o.a.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.o.a.CameraOptions;
import b.o.a.CameraView2;
import com.google.android.gms.tasks.Task;
import com.otaliastudios.cameraview.CameraView;

/* JADX INFO: renamed from: b.o.a.n.k, reason: use source file name */
/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraEngine3 implements b.i.a.f.n.f<CameraOptions, Void> {
    public final /* synthetic */ CameraEngine a;

    public CameraEngine3(CameraEngine cameraEngine) {
        this.a = cameraEngine;
    }

    @Override // b.i.a.f.n.f
    @NonNull
    public Task<Void> a(@Nullable CameraOptions cameraOptions) throws Exception {
        CameraOptions cameraOptions2 = cameraOptions;
        if (cameraOptions2 == null) {
            throw new RuntimeException("Null options!");
        }
        CameraView.b bVar = (CameraView.b) this.a.m;
        bVar.f3177b.a(1, "dispatchOnCameraOpened", cameraOptions2);
        CameraView.this.u.post(new CameraView2(bVar, cameraOptions2));
        return b.i.a.f.e.o.f.Z(null);
    }
}
