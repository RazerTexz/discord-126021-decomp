package p007b.p008a.p021f;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.f.b */
/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0896b implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ RelativeLayout f615j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ ViewOnClickListenerC0895a f616k;

    public RunnableC0896b(RelativeLayout relativeLayout, ViewOnClickListenerC0895a viewOnClickListenerC0895a) {
        this.f615j = relativeLayout;
        this.f616k = viewOnClickListenerC0895a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewOnClickListenerC0895a viewOnClickListenerC0895a = this.f616k;
        RelativeLayout relativeLayout = this.f615j;
        C12238m.checkNotNullExpressionValue(relativeLayout, "it");
        Drawable background = relativeLayout.getBackground();
        C12238m.checkNotNullExpressionValue(background, "it.background");
        int i = this.f616k.f607p.f611c;
        Objects.requireNonNull(viewOnClickListenerC0895a);
        background.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    }
}
