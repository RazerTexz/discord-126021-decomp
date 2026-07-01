package b.a.o;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.View$OnLayoutChangeListener;
import android.view.ViewTreeObserver$OnScrollChangedListener;
import androidx.annotation.UiThread;
import d0.t.u;
import d0.z.d.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PanelsChildGestureRegionObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b implements View$OnLayoutChangeListener {
    public final Map<Integer, Rect> j = new LinkedHashMap();
    public final Map<Integer, ViewTreeObserver$OnScrollChangedListener> k = new LinkedHashMap();
    public final Set<b$a> l = new LinkedHashSet();

    public final void a() {
        List<Rect> list = u.toList(this.j.values());
        Iterator<T> it = this.l.iterator();
        while (it.hasNext()) {
            ((b$a) it.next()).onGestureRegionsUpdate(list);
        }
    }

    @UiThread
    public final void b(View view) {
        m.checkParameterIsNotNull(view, "view");
        if (!this.k.containsKey(Integer.valueOf(view.getId()))) {
            view.addOnLayoutChangeListener(this);
            b$c b_c = new b$c(this, view);
            view.getViewTreeObserver().addOnScrollChangedListener(b_c);
            this.k.put(Integer.valueOf(view.getId()), b_c);
            return;
        }
        String simpleName = b.class.getSimpleName();
        StringBuilder sbU = b.d.b.a.a.U("failed to register view with ID ");
        sbU.append(view.getId());
        sbU.append(". already registered");
        Log.w(simpleName, sbU.toString());
    }

    @UiThread
    public final void c(View view) {
        m.checkParameterIsNotNull(view, "view");
        ViewTreeObserver$OnScrollChangedListener viewTreeObserver$OnScrollChangedListenerRemove = this.k.remove(Integer.valueOf(view.getId()));
        if (viewTreeObserver$OnScrollChangedListenerRemove != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(viewTreeObserver$OnScrollChangedListenerRemove);
        }
        view.removeOnLayoutChangeListener(this);
        this.j.remove(Integer.valueOf(view.getId()));
        a();
    }

    @Override // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        m.checkParameterIsNotNull(view, "view");
        if (this.k.keySet().contains(Integer.valueOf(view.getId()))) {
            int[] iArr = {0, 0};
            view.getLocationInWindow(iArr);
            int i9 = iArr[0];
            int i10 = iArr[1];
            this.j.put(Integer.valueOf(view.getId()), new Rect(i9, i10, i3 + i9, i4 + i10));
            a();
        }
    }
}
