package p007b.p225i.p226a.p341g.p353l.p354l;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: renamed from: b.i.a.g.l.l.j */
/* JADX INFO: compiled from: TransitionUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4479j implements ShapeAppearanceModel.CornerSizeUnaryOperator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ RectF f11936a;

    public C4479j(RectF rectF) {
        this.f11936a = rectF;
    }

    @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
    @NonNull
    public CornerSize apply(@NonNull CornerSize cornerSize) {
        return cornerSize instanceof RelativeCornerSize ? cornerSize : new RelativeCornerSize(cornerSize.getCornerSize(this.f11936a) / this.f11936a.height());
    }
}
