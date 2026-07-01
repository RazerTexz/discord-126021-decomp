package androidx.core.view;

import android.view.View;
import android.view.View$OnLayoutChangeListener;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewKt$doOnNextLayout$1 implements View$OnLayoutChangeListener {
    public final /* synthetic */ Function1<View, Unit> $action;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewKt$doOnNextLayout$1(Function1<? super View, Unit> function1) {
        this.$action = function1;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        m.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        this.$action.invoke(view);
    }
}
