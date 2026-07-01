package b.q.a;

import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView$a;

/* JADX INFO: compiled from: UCropActivity.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements HorizontalProgressWheelView$a {
    public final /* synthetic */ UCropActivity a;

    public c(UCropActivity uCropActivity) {
        this.a = uCropActivity;
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView$a
    public void a() {
        this.a.w.setImageToWrapCropBounds(true);
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView$a
    public void b(float f, float f2) {
        this.a.w.k(f / 42.0f);
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView$a
    public void c() {
        this.a.w.i();
    }
}
