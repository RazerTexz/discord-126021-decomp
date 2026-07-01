package b.q.a;

import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;

/* JADX INFO: renamed from: b.q.a.c, reason: use source file name */
/* JADX INFO: compiled from: UCropActivity.java */
/* JADX INFO: loaded from: classes3.dex */
public class UCropActivity3 implements HorizontalProgressWheelView.a {
    public final /* synthetic */ UCropActivity a;

    public UCropActivity3(UCropActivity uCropActivity) {
        this.a = uCropActivity;
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
    public void a() {
        this.a.w.setImageToWrapCropBounds(true);
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
    public void b(float f, float f2) {
        this.a.w.k(f / 42.0f);
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
    public void c() {
        this.a.w.i();
    }
}
