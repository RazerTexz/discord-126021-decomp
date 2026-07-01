package b.o.a.q;

import android.view.GestureDetector$SimpleOnGestureListener;
import android.view.MotionEvent;

/* JADX INFO: compiled from: TapGestureFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public class g$a extends GestureDetector$SimpleOnGestureListener {
    public final /* synthetic */ g j;

    public g$a(g gVar) {
        this.j = gVar;
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        g gVar = this.j;
        gVar.e = true;
        gVar.f1947b = a.l;
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        g gVar = this.j;
        gVar.e = true;
        gVar.f1947b = a.k;
        return true;
    }
}
