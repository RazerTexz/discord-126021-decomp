package b.a.f;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;
import d0.z.d.Intrinsics3;
import java.util.Objects;

/* JADX INFO: renamed from: b.a.f.b, reason: use source file name */
/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Chip3 implements Runnable {
    public final /* synthetic */ RelativeLayout j;
    public final /* synthetic */ Chip2 k;

    public Chip3(RelativeLayout relativeLayout, Chip2 chip2) {
        this.j = relativeLayout;
        this.k = chip2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Chip2 chip2 = this.k;
        RelativeLayout relativeLayout = this.j;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "it");
        Drawable background = relativeLayout.getBackground();
        Intrinsics3.checkNotNullExpressionValue(background, "it.background");
        int i = this.k.p.c;
        Objects.requireNonNull(chip2);
        background.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    }
}
