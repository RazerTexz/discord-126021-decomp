package androidx.core.view;

import android.view.View;
import android.view.View$OnAttachStateChangeListener;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewKt$doOnDetach$1 implements View$OnAttachStateChangeListener {
    public final /* synthetic */ Function1<View, Unit> $action;
    public final /* synthetic */ View $this_doOnDetach;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewKt$doOnDetach$1(View view, Function1<? super View, Unit> function1) {
        this.$this_doOnDetach = view;
        this.$action = function1;
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        m.checkNotNullParameter(view, "view");
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        m.checkNotNullParameter(view, "view");
        this.$this_doOnDetach.removeOnAttachStateChangeListener(this);
        this.$action.invoke(view);
    }
}
