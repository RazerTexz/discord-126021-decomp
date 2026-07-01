package b.a.f;

import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {
    public final /* synthetic */ RelativeLayout j;
    public final /* synthetic */ a k;

    public b(RelativeLayout relativeLayout, a aVar) {
        this.j = relativeLayout;
        this.k = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar = this.k;
        RelativeLayout relativeLayout = this.j;
        m.checkNotNullExpressionValue(relativeLayout, "it");
        Drawable background = relativeLayout.getBackground();
        m.checkNotNullExpressionValue(background, "it.background");
        int i = this.k.p.c;
        Objects.requireNonNull(aVar);
        background.setColorFilter(i, PorterDuff$Mode.SRC_ATOP);
    }
}
