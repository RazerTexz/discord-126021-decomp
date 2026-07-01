package androidx.transition;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ChangeBounds$6 extends Property<View, PointF> {
    public ChangeBounds$6(Class cls, String str) {
        super(cls, str);
    }

    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public PointF get2(View view) {
        return null;
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ PointF get(View view) {
        return get2(view);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(View view, PointF pointF) {
        set2(view, pointF);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(View view, PointF pointF) {
        int iRound = Math.round(pointF.x);
        int iRound2 = Math.round(pointF.y);
        ViewUtils.setLeftTopRightBottom(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
    }
}
