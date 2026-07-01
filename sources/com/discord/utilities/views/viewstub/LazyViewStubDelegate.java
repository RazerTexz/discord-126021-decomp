package com.discord.utilities.views.viewstub;

import android.view.View;
import android.view.View$OnClickListener;
import android.view.ViewStub;
import d0.g;
import d0.i;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LazyViewStubDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyViewStubDelegate {
    public static final LazyViewStubDelegate$Companion Companion = new LazyViewStubDelegate$Companion(null);
    private View$OnClickListener listener;

    /* JADX INFO: renamed from: view$delegate, reason: from kotlin metadata */
    private final Lazy view;
    private final Lazy<View> viewField;

    private LazyViewStubDelegate(ViewStub viewStub) {
        Lazy<View> lazy = g.lazy(i.NONE, new LazyViewStubDelegate$viewField$1(this, viewStub));
        this.viewField = lazy;
        this.view = lazy;
    }

    public static final /* synthetic */ View$OnClickListener access$getListener$p(LazyViewStubDelegate lazyViewStubDelegate) {
        return lazyViewStubDelegate.listener;
    }

    public static final /* synthetic */ void access$setListener$p(LazyViewStubDelegate lazyViewStubDelegate, View$OnClickListener view$OnClickListener) {
        lazyViewStubDelegate.listener = view$OnClickListener;
    }

    private final View getView() {
        return (View) this.view.getValue();
    }

    public final View getForceInitializedView() {
        View view = getView();
        m.checkNotNullExpressionValue(view, "view");
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
            m.checkNotNullExpressionValue(view, "view");
            if (view.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public final void setOnClickListener(View$OnClickListener listener) {
        if (this.viewField.isInitialized()) {
            getView().setOnClickListener(listener);
        } else {
            this.listener = listener;
        }
    }

    public final void setVisible(boolean z2) {
        if (z2 || this.viewField.isInitialized()) {
            View view = getView();
            m.checkNotNullExpressionValue(view, "view");
            view.setVisibility(z2 ? 0 : 8);
        }
    }

    public /* synthetic */ LazyViewStubDelegate(ViewStub viewStub, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewStub);
    }
}
