package com.discord.utilities.views.viewstub;

import android.view.View;
import android.view.ViewStub;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.C12083g;
import p507d0.EnumC12110i;
import p507d0.p592z.p594d.C12238m;

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
            C12238m.checkNotNullParameter(getViewStub, "getViewStub");
            return C12083g.lazy(EnumC12110i.NONE, new LazyViewStubDelegate$Companion$lazyViewStub$1(getViewStub));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private LazyViewStubDelegate(ViewStub viewStub) {
        Lazy<View> lazy = C12083g.lazy(EnumC12110i.NONE, new LazyViewStubDelegate$viewField$1(this, viewStub));
        this.viewField = lazy;
        this.view = lazy;
    }

    private final View getView() {
        return (View) this.view.getValue();
    }

    public final View getForceInitializedView() {
        View view = getView();
        C12238m.checkNotNullExpressionValue(view, "view");
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
            C12238m.checkNotNullExpressionValue(view, "view");
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
            C12238m.checkNotNullExpressionValue(view, "view");
            view.setVisibility(z2 ? 0 : 8);
        }
    }

    public /* synthetic */ LazyViewStubDelegate(ViewStub viewStub, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewStub);
    }
}
