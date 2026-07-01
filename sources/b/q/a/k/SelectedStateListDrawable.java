package b.q.a.k;

import android.R;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/* JADX INFO: renamed from: b.q.a.k.d, reason: use source file name */
/* JADX INFO: compiled from: SelectedStateListDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
public class SelectedStateListDrawable extends StateListDrawable {
    public int j;

    public SelectedStateListDrawable(Drawable drawable, int i) {
        this.j = i;
        addState(new int[]{R.attr.state_selected}, drawable);
        addState(new int[0], drawable);
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z2 = false;
        for (int i : iArr) {
            if (i == 16842913) {
                z2 = true;
            }
        }
        if (z2) {
            setColorFilter(this.j, PorterDuff.Mode.SRC_ATOP);
        } else {
            clearColorFilter();
        }
        return super.onStateChange(iArr);
    }
}
