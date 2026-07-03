package com.discord.widgets.home;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHomeBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C0980i5;
import p007b.p008a.p025i.C1008m5;
import p507d0.p508a0.C11210a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetHomePanelLoading.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomePanelLoading {
    private static boolean panelInitialized;
    private final WidgetHomeBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHomePanelLoading$configure$1 */
    /* JADX INFO: compiled from: WidgetHomePanelLoading.kt */
    public static final class C89741 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public C89741() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            WidgetHomePanelLoading.this.setLoadingPanelVisibility(z2, true);
        }
    }

    public WidgetHomePanelLoading(WidgetHomeBinding widgetHomeBinding) {
        C12238m.checkNotNullParameter(widgetHomeBinding, "binding");
        this.binding = widgetHomeBinding;
        centerLogoRelativeToLoadingScreen();
    }

    private final void centerLogoRelativeToLoadingScreen() {
        ImageView imageView = this.binding.f17125b.f1064b;
        C12238m.checkNotNullExpressionValue(imageView, "binding.loading.logo");
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        ImageView imageView2 = this.binding.f17125b.f1064b;
        C12238m.checkNotNullExpressionValue(imageView2, "binding.loading.logo");
        Resources resources = imageView2.getResources();
        C12238m.checkNotNullExpressionValue(resources, "binding.loading.logo.resources");
        layoutParams2.setMargins(((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin, C11210a.roundToInt(DisplayUtils.getStatusBarHeight(resources) / (-2.0f)), ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        ImageView imageView3 = this.binding.f17125b.f1064b;
        C12238m.checkNotNullExpressionValue(imageView3, "binding.loading.logo");
        imageView3.setLayoutParams(layoutParams2);
    }

    private final void setLoadingPanelVisibility(boolean initialized, boolean animate) {
        C1008m5 c1008m5 = this.binding.f17125b;
        C12238m.checkNotNullExpressionValue(c1008m5, "binding.loading");
        FrameLayout frameLayout = c1008m5.f1063a;
        C12238m.checkNotNullExpressionValue(frameLayout, "binding.loading.root");
        if ((frameLayout.getVisibility() == 0) || !initialized) {
            panelInitialized = initialized;
            if (!initialized) {
                C0980i5 c0980i5 = this.binding.f17127d;
                C12238m.checkNotNullExpressionValue(c0980i5, "binding.panelCenter");
                RoundedRelativeLayout roundedRelativeLayout = c0980i5.f960a;
                C12238m.checkNotNullExpressionValue(roundedRelativeLayout, "binding.panelCenter.root");
                roundedRelativeLayout.setVisibility(8);
                C1008m5 c1008m6 = this.binding.f17125b;
                C12238m.checkNotNullExpressionValue(c1008m6, "binding.loading");
                FrameLayout frameLayout2 = c1008m6.f1063a;
                C12238m.checkNotNullExpressionValue(frameLayout2, "binding.loading.root");
                frameLayout2.setVisibility(0);
                return;
            }
            if (animate) {
                C1008m5 c1008m7 = this.binding.f17125b;
                C12238m.checkNotNullExpressionValue(c1008m7, "binding.loading");
                ViewExtensions.fadeOut$default(c1008m7.f1063a, 0L, null, null, 7, null);
                C0980i5 c0980i6 = this.binding.f17127d;
                C12238m.checkNotNullExpressionValue(c0980i6, "binding.panelCenter");
                ViewExtensions.fadeIn$default(c0980i6.f960a, 0L, null, null, null, 15, null);
            } else {
                C1008m5 c1008m8 = this.binding.f17125b;
                C12238m.checkNotNullExpressionValue(c1008m8, "binding.loading");
                FrameLayout frameLayout3 = c1008m8.f1063a;
                C12238m.checkNotNullExpressionValue(frameLayout3, "binding.loading.root");
                frameLayout3.setVisibility(8);
                C0980i5 c0980i7 = this.binding.f17127d;
                C12238m.checkNotNullExpressionValue(c0980i7, "binding.panelCenter");
                RoundedRelativeLayout roundedRelativeLayout2 = c0980i7.f960a;
                C12238m.checkNotNullExpressionValue(roundedRelativeLayout2, "binding.panelCenter.root");
                roundedRelativeLayout2.setVisibility(0);
            }
            StoreStream.INSTANCE.getAnalytics().appUiViewed(WidgetHome.class);
        }
    }

    public final void configure(AppFragment fragment) {
        C12238m.checkNotNullParameter(fragment, "fragment");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(WidgetHomeModel.INSTANCE.getInitialized(), fragment, null, 2, null), (Class<?>) WidgetHomePanelLoading.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89741());
        setLoadingPanelVisibility(panelInitialized, false);
    }
}
