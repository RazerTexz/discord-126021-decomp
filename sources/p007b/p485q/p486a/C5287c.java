package p007b.p485q.p486a;

import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;

/* JADX INFO: renamed from: b.q.a.c */
/* JADX INFO: compiled from: UCropActivity.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5287c implements HorizontalProgressWheelView.InterfaceC11207a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ UCropActivity f14390a;

    public C5287c(UCropActivity uCropActivity) {
        this.f14390a = uCropActivity;
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC11207a
    /* JADX INFO: renamed from: a */
    public void mo7468a() {
        this.f14390a.f22194w.setImageToWrapCropBounds(true);
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC11207a
    /* JADX INFO: renamed from: b */
    public void mo7469b(float f, float f2) {
        this.f14390a.f22194w.m7482k(f / 42.0f);
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC11207a
    /* JADX INFO: renamed from: c */
    public void mo7470c() {
        this.f14390a.f22194w.m7480i();
    }
}
