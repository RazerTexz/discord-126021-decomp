package com.discord.utilities.views.viewstub;

import android.view.View;
import android.view.ViewStub;
import d0.Lazy5;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LazyViewStubDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyViewStubDelegate {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private View.OnClickListener listener;

    /* JADX INFO: renamed from: view$delegate, reason: from kotlin metadata */
    private final Lazy view;
    private final Lazy<View> viewField;

    /* JADX INFO: compiled from: LazyViewStubDelegate.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Lazy<LazyViewStubDelegate> lazyViewStub(Function0<ViewStub> getViewStub) {
            Intrinsics3.checkNotNullParameter(getViewStub, "getViewStub");
            return LazyJVM.lazy(Lazy5.NONE, new LazyViewStubDelegate2(getViewStub));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private LazyViewStubDelegate(ViewStub viewStub) {
        Lazy<View> lazy = LazyJVM.lazy(Lazy5.NONE, new LazyViewStubDelegate3(this, viewStub));
        this.viewField = lazy;
        this.view = lazy;
    }

    private final View getView() {
        return (View) this.view.getValue();
    }

    public final View getForceInitializedView() {
        View view = getView();
        Intrinsics3.checkNotNullExpressionValue(view, "view");
        return view;
    }

    public final View getMaybeView() {
        if (this.viewField.isInitialized()) {
            return getView();
        }
        return null;
    }

    public final boolean isVisible() {
        if (this.viewField.isInitialized()) {
            View view = getView();
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            if (view.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public final void setOnClickListener(View.OnClickListener listener) {
        if (this.viewField.isInitialized()) {
            getView().setOnClickListener(listener);
        } else {
            this.listener = listener;
        }
    }

    public final void setVisible(boolean z2) {
        if (z2 || this.viewField.isInitialized()) {
            View view = getView();
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            view.setVisibility(z2 ? 0 : 8);
        }
    }

    public /* synthetic */ LazyViewStubDelegate(ViewStub viewStub, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewStub);
    }
}
