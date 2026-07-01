package androidx.legacy.app;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.InsetDrawable;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarDrawerToggle$SlideDrawable extends InsetDrawable implements Drawable$Callback {
    private final boolean mHasMirroring;
    private float mOffset;
    private float mPosition;
    private final Rect mTmpRect;
    public final /* synthetic */ ActionBarDrawerToggle this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionBarDrawerToggle$SlideDrawable(ActionBarDrawerToggle actionBarDrawerToggle, Drawable drawable) {
        super(drawable, 0);
        this.this$0 = actionBarDrawerToggle;
        this.mHasMirroring = true;
        this.mTmpRect = new Rect();
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        copyBounds(this.mTmpRect);
        canvas.save();
        boolean z2 = ViewCompat.getLayoutDirection(this.this$0.mActivity.getWindow().getDecorView()) == 1;
        int i = z2 ? -1 : 1;
        float fWidth = this.mTmpRect.width();
        canvas.translate((-this.mOffset) * fWidth * this.mPosition * i, 0.0f);
        if (z2 && !this.mHasMirroring) {
            canvas.translate(fWidth, 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        super.draw(canvas);
        canvas.restore();
    }

    public float getPosition() {
        return this.mPosition;
    }

    public void setOffset(float f) {
        this.mOffset = f;
        invalidateSelf();
    }

    public void setPosition(float f) {
        this.mPosition = f;
        invalidateSelf();
    }
}
