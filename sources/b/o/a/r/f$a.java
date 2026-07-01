package b.o.a.r;

import android.content.Context;
import android.view.OrientationEventListener;
import b.o.a.j;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.CameraView$b;

/* JADX INFO: compiled from: OrientationHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$a extends OrientationEventListener {
    public final /* synthetic */ f a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$a(f fVar, Context context, int i) {
        super(context, i);
        this.a = fVar;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x002d  */
    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        int i2;
        if (i == -1) {
            i2 = this.a.e;
            if (i2 == -1) {
                i2 = 0;
            }
        } else if (i >= 315 || i < 45) {
            i2 = 0;
        } else if (i >= 45 && i < 135) {
            i2 = 90;
        } else if (i >= 135 && i < 225) {
            i2 = 180;
        } else if (i < 225 || i >= 315) {
            i2 = 0;
        } else {
            i2 = 270;
        }
        f fVar = this.a;
        if (i2 != fVar.e) {
            fVar.e = i2;
            CameraView$b cameraView$b = (CameraView$b) fVar.c;
            cameraView$b.f3177b.a(1, "onDeviceOrientationChanged", Integer.valueOf(i2));
            CameraView cameraView = cameraView$b.c;
            int i3 = cameraView.f3175y.g;
            if (cameraView.m) {
                b.o.a.n.t.a aVarE = cameraView.f3176z.e();
                aVarE.e(i2);
                aVarE.e = i2;
                aVarE.d();
            } else {
                int i4 = (360 - i3) % 360;
                b.o.a.n.t.a aVarE2 = cameraView.f3176z.e();
                aVarE2.e(i4);
                aVarE2.e = i4;
                aVarE2.d();
            }
            cameraView$b.c.u.post(new j(cameraView$b, (i2 + i3) % 360));
        }
    }
}
