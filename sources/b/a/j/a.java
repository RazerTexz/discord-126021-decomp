package b.a.j;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver$OnPreDrawListener;
import androidx.annotation.MainThread;
import com.discord.floating_view_manager.FloatingViewGravity;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FloatingViewManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public Function1<? super Integer, Unit> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, a$a> f243b;
    public final Logger c;

    public a(Logger logger) {
        m.checkNotNullParameter(logger, "logger");
        this.c = logger;
        this.f243b = new LinkedHashMap();
    }

    public static final void a(a aVar, View view, View view2, FloatingViewGravity floatingViewGravity, int i, int i2) {
        int height;
        Objects.requireNonNull(aVar);
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
        a$a a_a = this.f243b.get(Integer.valueOf(i));
        if (a_a != null) {
            ViewGroup viewGroup = a_a.f244b;
            View view = a_a.a;
            ViewTreeObserver$OnPreDrawListener viewTreeObserver$OnPreDrawListener = a_a.c;
            this.f243b.remove(Integer.valueOf(i));
            viewGroup.getViewTreeObserver().removeOnPreDrawListener(viewTreeObserver$OnPreDrawListener);
            viewGroup.removeView(view);
            Function1<? super Integer, Unit> function1 = this.a;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i));
            }
        }
    }
}
