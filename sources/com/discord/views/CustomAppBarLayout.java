package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout$OnOffsetChangedListener;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CustomAppBarLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CustomAppBarLayout extends AppBarLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public float percentCollapsed;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final AppBarLayout$OnOffsetChangedListener percentCollapsedOffsetChangeListener;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function1<? super Float, Unit> onPercentCollapsedCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        this.percentCollapsedOffsetChangeListener = new CustomAppBarLayout$b(this);
        this.onPercentCollapsedCallback = CustomAppBarLayout$a.j;
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
        m.checkNotNullParameter(callback, "callback");
        this.onPercentCollapsedCallback = callback;
    }
}
