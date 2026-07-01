package b.a.o;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.UiThread;
import b.d.b.a.outline;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: b.a.o.b, reason: use source file name */
/* JADX INFO: compiled from: PanelsChildGestureRegionObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PanelsChildGestureRegionObserver implements View.OnLayoutChangeListener {
    public final Map<Integer, Rect> j = new LinkedHashMap();
    public final Map<Integer, ViewTreeObserver.OnScrollChangedListener> k = new LinkedHashMap();
    public final Set<a> l = new LinkedHashSet();

    /* JADX INFO: renamed from: b.a.o.b$a */
    /* JADX INFO: compiled from: PanelsChildGestureRegionObserver.kt */
    public interface a {
        void onGestureRegionsUpdate(List<Rect> list);
    }

    /* JADX INFO: renamed from: b.a.o.b$b */
    /* JADX INFO: compiled from: PanelsChildGestureRegionObserver.kt */
    public static final class b {
        public static WeakReference<PanelsChildGestureRegionObserver> a = new WeakReference<>(null);

        @UiThread
        public static final PanelsChildGestureRegionObserver a() {
            PanelsChildGestureRegionObserver panelsChildGestureRegionObserver = a.get();
            if (panelsChildGestureRegionObserver != null) {
                return panelsChildGestureRegionObserver;
            }
            PanelsChildGestureRegionObserver panelsChildGestureRegionObserver2 = new PanelsChildGestureRegionObserver();
            a = new WeakReference<>(panelsChildGestureRegionObserver2);
            return panelsChildGestureRegionObserver2;
        }
    }

    /* JADX INFO: renamed from: b.a.o.b$c */
    /* JADX INFO: compiled from: PanelsChildGestureRegionObserver.kt */
    public static final class c implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f252b;

        public c(View view) {
            this.f252b = view;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            PanelsChildGestureRegionObserver panelsChildGestureRegionObserver = PanelsChildGestureRegionObserver.this;
            View view = this.f252b;
            panelsChildGestureRegionObserver.onLayoutChange(view, view.getLeft(), this.f252b.getTop(), this.f252b.getRight(), this.f252b.getBottom(), 0, 0, 0, 0);
        }
    }

    public final void a() {
        List<Rect> list = _Collections.toList(this.j.values());
        Iterator<T> it = this.l.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onGestureRegionsUpdate(list);
        }
    }

    @UiThread
    public final void b(View view) {
        Intrinsics3.checkParameterIsNotNull(view, "view");
        if (!this.k.containsKey(Integer.valueOf(view.getId()))) {
            view.addOnLayoutChangeListener(this);
            c cVar = new c(view);
            view.getViewTreeObserver().addOnScrollChangedListener(cVar);
            this.k.put(Integer.valueOf(view.getId()), cVar);
            return;
        }
        String simpleName = PanelsChildGestureRegionObserver.class.getSimpleName();
        StringBuilder sbU = outline.U("failed to register view with ID ");
        sbU.append(view.getId());
        sbU.append(". already registered");
        Log.w(simpleName, sbU.toString());
    }

    @UiThread
    public final void c(View view) {
        Intrinsics3.checkParameterIsNotNull(view, "view");
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListenerRemove = this.k.remove(Integer.valueOf(view.getId()));
        if (onScrollChangedListenerRemove != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListenerRemove);
        }
        view.removeOnLayoutChangeListener(this);
        this.j.remove(Integer.valueOf(view.getId()));
        a();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics3.checkParameterIsNotNull(view, "view");
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
