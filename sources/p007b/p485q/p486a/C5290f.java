package p007b.p485q.p486a;

import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;

/* JADX INFO: renamed from: b.q.a.f */
/* JADX INFO: compiled from: UCropActivity.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5290f implements HorizontalProgressWheelView.InterfaceC11207a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ UCropActivity f14393a;

    public C5290f(UCropActivity uCropActivity) {
        this.f14393a = uCropActivity;
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC11207a
    /* JADX INFO: renamed from: a */
    public void mo7468a() {
        this.f14393a.f22194w.setImageToWrapCropBounds(true);
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC11207a
    /* JADX INFO: renamed from: b */
    public void mo7469b(float f, float f2) {
        if (f > 0.0f) {
            GestureCropImageView gestureCropImageView = this.f14393a.f22194w;
            gestureCropImageView.m7483l((((this.f14393a.f22194w.getMaxScale() - this.f14393a.f22194w.getMinScale()) / 15000.0f) * f) + gestureCropImageView.getCurrentScale(), gestureCropImageView.f14464y.centerX(), gestureCropImageView.f14464y.centerY());
            return;
        }
        GestureCropImageView gestureCropImageView2 = this.f14393a.f22194w;
        float maxScale = (((this.f14393a.f22194w.getMaxScale() - this.f14393a.f22194w.getMinScale()) / 15000.0f) * f) + gestureCropImageView2.getCurrentScale();
        float fCenterX = gestureCropImageView2.f14464y.centerX();
        float fCenterY = gestureCropImageView2.f14464y.centerY();
        if (maxScale >= gestureCropImageView2.getMinScale()) {
            gestureCropImageView2.mo7478f(maxScale / gestureCropImageView2.getCurrentScale(), fCenterX, fCenterY);
        }
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC11207a
    /* JADX INFO: renamed from: c */
    public void mo7470c() {
        this.f14393a.f22194w.m7480i();
    }
}
