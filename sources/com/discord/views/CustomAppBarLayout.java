package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: CustomAppBarLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CustomAppBarLayout extends AppBarLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public float percentCollapsed;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final AppBarLayout.OnOffsetChangedListener percentCollapsedOffsetChangeListener;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function1<? super Float, Unit> onPercentCollapsedCallback;

    /* JADX INFO: renamed from: com.discord.views.CustomAppBarLayout$a */
    /* JADX INFO: compiled from: CustomAppBarLayout.kt */
    public static final class C7073a extends AbstractC12240o implements Function1<Float, Unit> {

        /* JADX INFO: renamed from: j */
        public static final C7073a f19048j = new C7073a();

        public C7073a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Float f) {
            f.floatValue();
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.views.CustomAppBarLayout$b */
    /* JADX INFO: compiled from: CustomAppBarLayout.kt */
    public static final class C7074b implements AppBarLayout.OnOffsetChangedListener {
        public C7074b() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            C12238m.checkNotNullExpressionValue(appBarLayout, "appBar");
            float fAbs = appBarLayout.getTotalScrollRange() <= 0 ? 1.0f : Math.abs(i) / appBarLayout.getTotalScrollRange();
            CustomAppBarLayout customAppBarLayout = CustomAppBarLayout.this;
            if (fAbs != customAppBarLayout.percentCollapsed) {
                customAppBarLayout.percentCollapsed = fAbs;
                customAppBarLayout.onPercentCollapsedCallback.invoke(Float.valueOf(fAbs));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        this.percentCollapsedOffsetChangeListener = new C7074b();
        this.onPercentCollapsedCallback = C7073a.f19048j;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m8542a() {
        return this.percentCollapsed == 1.0f;
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        addOnOffsetChangedListener(this.percentCollapsedOffsetChangeListener);
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeOnOffsetChangedListener(this.percentCollapsedOffsetChangeListener);
        super.onDetachedFromWindow();
    }

    public final void setOnPercentCollapsedCallback(Function1<? super Float, Unit> callback) {
        C12238m.checkNotNullParameter(callback, "callback");
        this.onPercentCollapsedCallback = callback;
    }
}
