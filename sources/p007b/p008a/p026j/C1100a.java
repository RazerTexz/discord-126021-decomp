package p007b.p008a.p026j;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.MainThread;
import com.discord.floating_view_manager.FloatingViewGravity;
import com.discord.utilities.logging.Logger;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.j.a */
/* JADX INFO: compiled from: FloatingViewManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1100a {

    /* JADX INFO: renamed from: a */
    public Function1<? super Integer, Unit> f1454a;

    /* JADX INFO: renamed from: b */
    public final Map<Integer, a> f1455b;

    /* JADX INFO: renamed from: c */
    public final Logger f1456c;

    /* JADX INFO: renamed from: b.a.j.a$a */
    /* JADX INFO: compiled from: FloatingViewManager.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final View f1457a;

        /* JADX INFO: renamed from: b */
        public final ViewGroup f1458b;

        /* JADX INFO: renamed from: c */
        public final ViewTreeObserver.OnPreDrawListener f1459c;

        public a(View view, ViewGroup viewGroup, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
            C12238m.checkNotNullParameter(view, "floatingView");
            C12238m.checkNotNullParameter(viewGroup, "ancestorViewGroup");
            C12238m.checkNotNullParameter(onPreDrawListener, "ancestorPreDrawListener");
            this.f1457a = view;
            this.f1458b = viewGroup;
            this.f1459c = onPreDrawListener;
        }
    }

    /* JADX INFO: renamed from: b.a.j.a$b */
    /* JADX INFO: compiled from: FloatingViewManager.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public static WeakReference<C1100a> f1460a;
    }

    public C1100a(Logger logger) {
        C12238m.checkNotNullParameter(logger, "logger");
        this.f1456c = logger;
        this.f1455b = new LinkedHashMap();
    }

    /* JADX INFO: renamed from: a */
    public static final void m207a(C1100a c1100a, View view, View view2, FloatingViewGravity floatingViewGravity, int i, int i2) {
        int height;
        Objects.requireNonNull(c1100a);
        int[] iArr = new int[2];
        view2.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        int width = (((view2.getWidth() / 2) + i3) - (view.getWidth() / 2)) + i;
        int iOrdinal = floatingViewGravity.ordinal();
        if (iOrdinal == 0) {
            height = i4 - view.getHeight();
        } else if (iOrdinal == 1) {
            height = ((view2.getHeight() / 2) + i4) - (view.getHeight() / 2);
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            height = view2.getHeight() + i4;
        }
        view.setX(width);
        view.setY(height + i2);
    }

    @MainThread
    /* JADX INFO: renamed from: b */
    public final void m208b(int i) {
        a aVar = this.f1455b.get(Integer.valueOf(i));
        if (aVar != null) {
            ViewGroup viewGroup = aVar.f1458b;
            View view = aVar.f1457a;
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = aVar.f1459c;
            this.f1455b.remove(Integer.valueOf(i));
            viewGroup.getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
            viewGroup.removeView(view);
            Function1<? super Integer, Unit> function1 = this.f1454a;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i));
            }
        }
    }
}
