package b.a.j;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.MainThread;
import com.discord.floating_view_manager.FloatingViewGravity;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.j.a, reason: use source file name */
/* JADX INFO: compiled from: FloatingViewManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FloatingViewManager {
    public Function1<? super Integer, Unit> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, a> f243b;
    public final Logger c;

    /* JADX INFO: renamed from: b.a.j.a$a */
    /* JADX INFO: compiled from: FloatingViewManager.kt */
    public static final class a {
        public final View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f244b;
        public final ViewTreeObserver.OnPreDrawListener c;

        public a(View view, ViewGroup viewGroup, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
            Intrinsics3.checkNotNullParameter(view, "floatingView");
            Intrinsics3.checkNotNullParameter(viewGroup, "ancestorViewGroup");
            Intrinsics3.checkNotNullParameter(onPreDrawListener, "ancestorPreDrawListener");
            this.a = view;
            this.f244b = viewGroup;
            this.c = onPreDrawListener;
        }
    }

    /* JADX INFO: renamed from: b.a.j.a$b */
    /* JADX INFO: compiled from: FloatingViewManager.kt */
    public static final class b {
        public static WeakReference<FloatingViewManager> a;
    }

    public FloatingViewManager(Logger logger) {
        Intrinsics3.checkNotNullParameter(logger, "logger");
        this.c = logger;
        this.f243b = new LinkedHashMap();
    }

    public static final void a(FloatingViewManager floatingViewManager, View view, View view2, FloatingViewGravity floatingViewGravity, int i, int i2) {
        int height;
        Objects.requireNonNull(floatingViewManager);
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
    public final void b(int i) {
        a aVar = this.f243b.get(Integer.valueOf(i));
        if (aVar != null) {
            ViewGroup viewGroup = aVar.f244b;
            View view = aVar.a;
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = aVar.c;
            this.f243b.remove(Integer.valueOf(i));
            viewGroup.getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
            viewGroup.removeView(view);
            Function1<? super Integer, Unit> function1 = this.a;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i));
            }
        }
    }
}
