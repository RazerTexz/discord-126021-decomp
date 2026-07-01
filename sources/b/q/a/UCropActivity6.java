package b.q.a;

import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;

/* JADX INFO: renamed from: b.q.a.f, reason: use source file name */
/* JADX INFO: compiled from: UCropActivity.java */
/* JADX INFO: loaded from: classes3.dex */
public class UCropActivity6 implements HorizontalProgressWheelView.a {
    public final /* synthetic */ UCropActivity a;

    public UCropActivity6(UCropActivity uCropActivity) {
        this.a = uCropActivity;
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
    public void a() {
        this.a.w.setImageToWrapCropBounds(true);
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
    public void b(float f, float f2) {
        if (f > 0.0f) {
            GestureCropImageView gestureCropImageView = this.a.w;
            gestureCropImageView.l((((this.a.w.getMaxScale() - this.a.w.getMinScale()) / 15000.0f) * f) + gestureCropImageView.getCurrentScale(), gestureCropImageView.f1987y.centerX(), gestureCropImageView.f1987y.centerY());
            return;
        }
        GestureCropImageView gestureCropImageView2 = this.a.w;
        float maxScale = (((this.a.w.getMaxScale() - this.a.w.getMinScale()) / 15000.0f) * f) + gestureCropImageView2.getCurrentScale();
        float fCenterX = gestureCropImageView2.f1987y.centerX();
        float fCenterY = gestureCropImageView2.f1987y.centerY();
        if (maxScale >= gestureCropImageView2.getMinScale()) {
            gestureCropImageView2.f(maxScale / gestureCropImageView2.getCurrentScale(), fCenterX, fCenterY);
        }
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
    public void c() {
        this.a.w.i();
    }
}
