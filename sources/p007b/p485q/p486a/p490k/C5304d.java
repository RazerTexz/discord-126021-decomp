package p007b.p485q.p486a.p490k;

import android.R;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/* JADX INFO: renamed from: b.q.a.k.d */
/* JADX INFO: compiled from: SelectedStateListDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5304d extends StateListDrawable {

    /* JADX INFO: renamed from: j */
    public int f14453j;

    public C5304d(Drawable drawable, int i) {
        this.f14453j = i;
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
            setColorFilter(this.f14453j, PorterDuff.Mode.SRC_ATOP);
        } else {
            clearColorFilter();
        }
        return super.onStateChange(iArr);
    }
}
