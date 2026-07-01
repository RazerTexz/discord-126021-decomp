package com.discord.widgets.home;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout$LayoutParams;
import android.widget.ImageView;
import b.a.i.i5;
import b.a.i.m5;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHomeBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import d0.a0.a;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHomePanelLoading.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomePanelLoading {
    public static final WidgetHomePanelLoading$Companion Companion = new WidgetHomePanelLoading$Companion(null);
    private static boolean panelInitialized;
    private final WidgetHomeBinding binding;

    public WidgetHomePanelLoading(WidgetHomeBinding widgetHomeBinding) {
        m.checkNotNullParameter(widgetHomeBinding, "binding");
        this.binding = widgetHomeBinding;
        centerLogoRelativeToLoadingScreen();
    }

    public static final /* synthetic */ void access$setLoadingPanelVisibility(WidgetHomePanelLoading widgetHomePanelLoading, boolean z2, boolean z3) {
        widgetHomePanelLoading.setLoadingPanelVisibility(z2, z3);
    }

    private final void centerLogoRelativeToLoadingScreen() {
        ImageView imageView = this.binding.f2465b.f162b;
        m.checkNotNullExpressionValue(imageView, "binding.loading.logo");
        ViewGroup$LayoutParams layoutParams = imageView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams) layoutParams;
        ImageView imageView2 = this.binding.f2465b.f162b;
        m.checkNotNullExpressionValue(imageView2, "binding.loading.logo");
        Resources resources = imageView2.getResources();
        m.checkNotNullExpressionValue(resources, "binding.loading.logo.resources");
        frameLayout$LayoutParams.setMargins(((ViewGroup$MarginLayoutParams) frameLayout$LayoutParams).leftMargin, a.roundToInt(DisplayUtils.getStatusBarHeight(resources) / (-2.0f)), ((ViewGroup$MarginLayoutParams) frameLayout$LayoutParams).rightMargin, ((ViewGroup$MarginLayoutParams) frameLayout$LayoutParams).bottomMargin);
        ImageView imageView3 = this.binding.f2465b.f162b;
        m.checkNotNullExpressionValue(imageView3, "binding.loading.logo");
        imageView3.setLayoutParams(frameLayout$LayoutParams);
    }

    private final void setLoadingPanelVisibility(boolean initialized, boolean animate) {
        m5 m5Var = this.binding.f2465b;
        m.checkNotNullExpressionValue(m5Var, "binding.loading");
        FrameLayout frameLayout = m5Var.a;
        m.checkNotNullExpressionValue(frameLayout, "binding.loading.root");
        if ((frameLayout.getVisibility() == 0) || !initialized) {
            panelInitialized = initialized;
            if (!initialized) {
                i5 i5Var = this.binding.d;
                m.checkNotNullExpressionValue(i5Var, "binding.panelCenter");
                RoundedRelativeLayout roundedRelativeLayout = i5Var.a;
                m.checkNotNullExpressionValue(roundedRelativeLayout, "binding.panelCenter.root");
                roundedRelativeLayout.setVisibility(8);
                m5 m5Var2 = this.binding.f2465b;
                m.checkNotNullExpressionValue(m5Var2, "binding.loading");
                FrameLayout frameLayout2 = m5Var2.a;
                m.checkNotNullExpressionValue(frameLayout2, "binding.loading.root");
                frameLayout2.setVisibility(0);
                return;
            }
            if (animate) {
                m5 m5Var3 = this.binding.f2465b;
                m.checkNotNullExpressionValue(m5Var3, "binding.loading");
                ViewExtensions.fadeOut$default(m5Var3.a, 0L, null, null, 7, null);
                i5 i5Var2 = this.binding.d;
                m.checkNotNullExpressionValue(i5Var2, "binding.panelCenter");
                ViewExtensions.fadeIn$default(i5Var2.a, 0L, null, null, null, 15, null);
            } else {
                m5 m5Var4 = this.binding.f2465b;
                m.checkNotNullExpressionValue(m5Var4, "binding.loading");
                FrameLayout frameLayout3 = m5Var4.a;
                m.checkNotNullExpressionValue(frameLayout3, "binding.loading.root");
                frameLayout3.setVisibility(8);
                i5 i5Var3 = this.binding.d;
                m.checkNotNullExpressionValue(i5Var3, "binding.panelCenter");
                RoundedRelativeLayout roundedRelativeLayout2 = i5Var3.a;
                m.checkNotNullExpressionValue(roundedRelativeLayout2, "binding.panelCenter.root");
                roundedRelativeLayout2.setVisibility(0);
            }
            StoreStream.Companion.getAnalytics().appUiViewed(WidgetHome.class);
        }
    }

    public final void configure(AppFragment fragment) {
        m.checkNotNullParameter(fragment, "fragment");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetHomeModel.Companion.getInitialized(), fragment, null, 2, null), WidgetHomePanelLoading.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHomePanelLoading$configure$1(this), 62, (Object) null);
        setLoadingPanelVisibility(panelInitialized, false);
    }
}
