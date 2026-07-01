package e0.a.a.a;

import android.hardware.Camera;
import android.hardware.Camera$AutoFocusCallback;

/* JADX INFO: compiled from: CameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$b implements Camera$AutoFocusCallback {
    public final /* synthetic */ d a;

    public d$b(d dVar) {
        this.a = dVar;
    }

    @Override // android.hardware.Camera$AutoFocusCallback
    public void onAutoFocus(boolean z2, Camera camera) {
        this.a.b();
    }
}
