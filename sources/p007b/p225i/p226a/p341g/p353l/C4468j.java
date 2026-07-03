package p007b.p225i.p226a.p341g.p353l;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: renamed from: b.i.a.g.l.j */
/* JADX INFO: compiled from: TransitionUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4468j implements ShapeAppearanceModel.CornerSizeUnaryOperator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ RectF f11914a;

    public C4468j(RectF rectF) {
        this.f11914a = rectF;
    }

    @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
    @NonNull
    public CornerSize apply(@NonNull CornerSize cornerSize) {
        return cornerSize instanceof RelativeCornerSize ? cornerSize : new RelativeCornerSize(cornerSize.getCornerSize(this.f11914a) / this.f11914a.height());
    }
}
