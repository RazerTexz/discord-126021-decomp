package b.i.a.g.a;

import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: HeaderBehavior.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a implements Runnable {
    public final CoordinatorLayout j;

    /* JADX INFO: Incorrect field signature: TV; */
    public final View k;
    public final /* synthetic */ a l;

    /* JADX WARN: Multi-variable type inference failed */
    public a$a(a aVar, CoordinatorLayout coordinatorLayout, V v) {
        this.l = aVar;
        this.j = coordinatorLayout;
        this.k = v;
    }

    @Override // java.lang.Runnable
    public void run() {
        OverScroller overScroller;
        if (this.k == null || (overScroller = this.l.scroller) == null) {
            return;
        }
        if (!overScroller.computeScrollOffset()) {
            this.l.onFlingFinished(this.j, this.k);
            return;
        }
        a aVar = this.l;
        aVar.setHeaderTopBottomOffset(this.j, this.k, aVar.scroller.getCurrY());
        ViewCompat.postOnAnimation(this.k, this);
    }
}
