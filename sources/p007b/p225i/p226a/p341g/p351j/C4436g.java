package p007b.p225i.p226a.p341g.p351j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: renamed from: b.i.a.g.j.g */
/* JADX INFO: compiled from: CutoutDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4436g extends MaterialShapeDrawable {

    /* JADX INFO: renamed from: j */
    @NonNull
    public final Paint f11788j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final RectF f11789k;

    /* JADX INFO: renamed from: l */
    public int f11790l;

    public C4436g() {
        this(null);
    }

    /* JADX INFO: renamed from: a */
    public void m6149a(float f, float f2, float f3, float f4) {
        RectF rectF = this.f11789k;
        if (f == rectF.left && f2 == rectF.top && f3 == rectF.right && f4 == rectF.bottom) {
            return;
        }
        rectF.set(f, f2, f3, f4);
        invalidateSelf();
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
            }
        } else {
            this.f11790l = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        }
        super.draw(canvas);
        canvas.drawRect(this.f11789k, this.f11788j);
        if (getCallback() instanceof View) {
            return;
        }
        canvas.restoreToCount(this.f11790l);
    }

    public C4436g(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        super(shapeAppearanceModel == null ? new ShapeAppearanceModel() : shapeAppearanceModel);
        Paint paint = new Paint(1);
        this.f11788j = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f11789k = new RectF();
    }
}
