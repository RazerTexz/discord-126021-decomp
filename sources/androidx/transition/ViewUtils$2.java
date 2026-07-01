package androidx.transition;

import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class ViewUtils$2 extends Property<View, Rect> {
    public ViewUtils$2(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Rect get(View view) {
        return get2(view);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(View view, Rect rect) {
        set2(view, rect);
    }

    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Rect get2(View view) {
        return ViewCompat.getClipBounds(view);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(View view, Rect rect) {
        ViewCompat.setClipBounds(view, rect);
    }
}
