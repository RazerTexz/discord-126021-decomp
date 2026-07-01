package androidx.transition;

import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
public class ChangeBounds$3 extends Property<ChangeBounds$ViewBounds, PointF> {
    public ChangeBounds$3(Class cls, String str) {
        super(cls, str);
    }

    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public PointF get2(ChangeBounds$ViewBounds changeBounds$ViewBounds) {
        return null;
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ PointF get(ChangeBounds$ViewBounds changeBounds$ViewBounds) {
        return get2(changeBounds$ViewBounds);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(ChangeBounds$ViewBounds changeBounds$ViewBounds, PointF pointF) {
        set2(changeBounds$ViewBounds, pointF);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(ChangeBounds$ViewBounds changeBounds$ViewBounds, PointF pointF) {
        changeBounds$ViewBounds.setBottomRight(pointF);
    }
}
