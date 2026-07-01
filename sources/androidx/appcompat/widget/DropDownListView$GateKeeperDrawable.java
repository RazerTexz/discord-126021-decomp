package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.appcompat.graphics.drawable.DrawableWrapper;

/* JADX INFO: loaded from: classes.dex */
public class DropDownListView$GateKeeperDrawable extends DrawableWrapper {
    private boolean mEnabled;

    public DropDownListView$GateKeeperDrawable(Drawable drawable) {
        super(drawable);
        this.mEnabled = true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mEnabled) {
            super.draw(canvas);
        }
    }

    public void setEnabled(boolean z2) {
        this.mEnabled = z2;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        if (this.mEnabled) {
            super.setHotspot(f, f2);
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.mEnabled) {
            super.setHotspotBounds(i, i2, i3, i4);
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (this.mEnabled) {
            return super.setState(iArr);
        }
        return false;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        if (this.mEnabled) {
            return super.setVisible(z2, z3);
        }
        return false;
    }
}
