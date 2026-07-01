package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CustomAppBarLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CustomAppBarLayout extends AppBarLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public float percentCollapsed;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final AppBarLayout.OnOffsetChangedListener percentCollapsedOffsetChangeListener;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function1<? super Float, Unit> onPercentCollapsedCallback;

    /* JADX INFO: compiled from: CustomAppBarLayout.kt */
    public static final class a extends Lambda implements Function1<Float, Unit> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Float f) {
            f.floatValue();
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: CustomAppBarLayout.kt */
    public static final class b implements AppBarLayout.OnOffsetChangedListener {
        public b() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            Intrinsics3.checkNotNullExpressionValue(appBarLayout, "appBar");
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
        Intrinsics3.checkNotNullParameter(context, "context");
        this.percentCollapsedOffsetChangeListener = new b();
        this.onPercentCollapsedCallback = a.j;
    }

    public final boolean a() {
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
        Intrinsics3.checkNotNullParameter(callback, "callback");
        this.onPercentCollapsedCallback = callback;
    }
}
