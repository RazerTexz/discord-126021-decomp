package b.o.a.r;

import android.hardware.display.DisplayManager$DisplayListener;
import com.otaliastudios.cameraview.CameraView$b;

/* JADX INFO: compiled from: OrientationHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$b implements DisplayManager$DisplayListener {
    public final /* synthetic */ f a;

    public f$b(f fVar) {
        this.a = fVar;
    }

    @Override // android.hardware.display.DisplayManager$DisplayListener
    public void onDisplayAdded(int i) {
    }

    @Override // android.hardware.display.DisplayManager$DisplayListener
    public void onDisplayChanged(int i) {
        f fVar = this.a;
        int i2 = fVar.g;
        int iA = fVar.a();
        if (iA != i2) {
            f fVar2 = this.a;
            fVar2.g = iA;
            CameraView$b cameraView$b = (CameraView$b) fVar2.c;
            if (cameraView$b.c.d()) {
                cameraView$b.f3177b.a(2, "onDisplayOffsetChanged", "restarting the camera.");
                cameraView$b.c.close();
                cameraView$b.c.open();
            }
        }
    }

    @Override // android.hardware.display.DisplayManager$DisplayListener
    public void onDisplayRemoved(int i) {
    }
}
