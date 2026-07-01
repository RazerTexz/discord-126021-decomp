package com.discord.widgets.voice.fullscreen;

import android.content.res.Resources;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$Builder;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$initializeSystemUiListeners$5 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$initializeSystemUiListeners$5(WidgetCallFullscreen widgetCallFullscreen) {
        this.this$0 = widgetCallFullscreen;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        m.checkNotNullExpressionValue(windowInsetsCompat, "insets");
        DisplayCutoutCompat displayCutout = windowInsetsCompat.getDisplayCutout();
        VideoCallGridAdapter videoCallGridAdapterAccess$getGridAdapter$p = WidgetCallFullscreen.access$getGridAdapter$p(this.this$0);
        Resources resources = this.this$0.getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        videoCallGridAdapterAccess$getGridAdapter$p.setDisplayCutout(displayCutout, resources.getConfiguration().orientation == 2);
        WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat$Builder().setSystemWindowInsets(Insets.of(Math.max(windowInsetsCompat.getSystemWindowInsetLeft(), displayCutout != null ? displayCutout.getSafeInsetLeft() : 0), Math.max(windowInsetsCompat.getSystemWindowInsetTop(), displayCutout != null ? displayCutout.getSafeInsetTop() : 0), Math.max(windowInsetsCompat.getSystemWindowInsetRight(), displayCutout != null ? displayCutout.getSafeInsetRight() : 0), Math.max(windowInsetsCompat.getSystemWindowInsetBottom(), displayCutout != null ? displayCutout.getSafeInsetBottom() : 0))).build();
        m.checkNotNullExpressionValue(windowInsetsCompatBuild, "WindowInsetsCompat.Build…        )\n      ).build()");
        VideoCallGridAdapter videoCallGridAdapterAccess$getGridAdapter$p2 = WidgetCallFullscreen.access$getGridAdapter$p(this.this$0);
        AppBarLayout appBarLayout = WidgetCallFullscreen.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(appBarLayout, "binding.actionBarToolbarLayout");
        videoCallGridAdapterAccess$getGridAdapter$p2.setInsetsForAvoidingCallUiOverlap(appBarLayout.getMeasuredHeight(), windowInsetsCompat.getSystemWindowInsetBottom(), windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetRight());
        ViewCompat.dispatchApplyWindowInsets(WidgetCallFullscreen.access$getBinding$p(this.this$0).f, windowInsetsCompatBuild);
        ViewCompat.dispatchApplyWindowInsets(WidgetCallFullscreen.access$getBinding$p(this.this$0).i, windowInsetsCompatBuild);
        RecyclerView recyclerView = WidgetCallFullscreen.access$getBinding$p(this.this$0).m;
        m.checkNotNullExpressionValue(recyclerView, "binding.callStageRecycler");
        recyclerView.setPadding(recyclerView.getPaddingLeft(), this.this$0.getResources().getDimensionPixelOffset(2131165740) + windowInsetsCompatBuild.getSystemWindowInsetTop(), recyclerView.getPaddingRight(), recyclerView.getPaddingBottom());
        return windowInsetsCompatBuild;
    }
}
