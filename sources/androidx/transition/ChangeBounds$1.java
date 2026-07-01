package androidx.transition;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
public class ChangeBounds$1 extends Property<Drawable, PointF> {
    private Rect mBounds;

    public ChangeBounds$1(Class cls, String str) {
        super(cls, str);
        this.mBounds = new Rect();
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ PointF get(Drawable drawable) {
        return get2(drawable);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Drawable drawable, PointF pointF) {
        set2(drawable, pointF);
    }

    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public PointF get2(Drawable drawable) {
        drawable.copyBounds(this.mBounds);
        Rect rect = this.mBounds;
        return new PointF(rect.left, rect.top);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(Drawable drawable, PointF pointF) {
        drawable.copyBounds(this.mBounds);
        this.mBounds.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
        drawable.setBounds(this.mBounds);
    }
}
