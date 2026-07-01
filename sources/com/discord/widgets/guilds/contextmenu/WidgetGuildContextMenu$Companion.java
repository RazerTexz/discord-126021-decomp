package com.discord.widgets.guilds.contextmenu;

import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.databinding.WidgetGuildContextMenuBinding;
import d0.d0.f;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildContextMenu$Companion {
    private WidgetGuildContextMenu$Companion() {
    }

    private final int computeMaxContextMenuHeight(Context context) {
        WidgetGuildContextMenuBinding widgetGuildContextMenuBindingA = WidgetGuildContextMenuBinding.a(LayoutInflater.from(context).inflate(R$layout.widget_guild_context_menu, (ViewGroup) null, false));
        m.checkNotNullExpressionValue(widgetGuildContextMenuBindingA, "WidgetGuildContextMenuBi…om(context), null, false)");
        CardView cardView = widgetGuildContextMenuBindingA.a;
        m.checkNotNullExpressionValue(cardView, "WidgetGuildContextMenuBi…ntext), null, false).root");
        cardView.measure(0, 0);
        return cardView.getMeasuredHeight();
    }

    private final WidgetGuildContextMenu newInstance(long guildId) {
        Bundle bundleT = a.T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        WidgetGuildContextMenu widgetGuildContextMenu = new WidgetGuildContextMenu();
        widgetGuildContextMenu.setArguments(bundleT);
        return widgetGuildContextMenu;
    }

    public final void hide(FragmentActivity activity, boolean animate) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Fragment fragmentFindFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag("WidgetGuildContextMenu");
        if (!(fragmentFindFragmentByTag instanceof WidgetGuildContextMenu)) {
            fragmentFindFragmentByTag = null;
        }
        WidgetGuildContextMenu widgetGuildContextMenu = (WidgetGuildContextMenu) fragmentFindFragmentByTag;
        if (widgetGuildContextMenu != null) {
            if (animate) {
                WidgetGuildContextMenu.access$doCircularRemove(widgetGuildContextMenu);
                return;
            }
            activity.getSupportFragmentManager().beginTransaction().remove(widgetGuildContextMenu).commitAllowingStateLoss();
            Window window = activity.getWindow();
            m.checkNotNullExpressionValue(window, "activity.window");
            View decorView = window.getDecorView();
            m.checkNotNullExpressionValue(decorView, "activity.window.decorView");
            View rootView = decorView.getRootView();
            Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) rootView;
            Window window2 = activity.getWindow();
            m.checkNotNullExpressionValue(window2, "activity.window");
            View decorView2 = window2.getDecorView();
            m.checkNotNullExpressionValue(decorView2, "activity.window.decorView");
            FrameLayout frameLayout = (FrameLayout) decorView2.getRootView().findViewWithTag("WidgetGuildContextMenuViewContainer");
            if (frameLayout != null) {
                viewGroup.removeView(frameLayout);
            }
            WidgetGuildContextMenu.access$setShowingContextMenu$cp(false);
        }
    }

    public final void show(FragmentActivity activity, PointF absolutePosition, long guildId) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(absolutePosition, "absolutePosition");
        if (WidgetGuildContextMenu.access$isShowingContextMenu$cp()) {
            return;
        }
        WidgetGuildContextMenu.access$setShowingContextMenu$cp(true);
        computeMaxContextMenuHeight(activity);
        hide(activity, false);
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setLayoutParams(new ViewGroup$LayoutParams(-1, -1));
        frameLayout.setTag("WidgetGuildContextMenuViewContainer");
        Window window = activity.getWindow();
        m.checkNotNullExpressionValue(window, "activity.window");
        View decorView = window.getDecorView();
        m.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        View rootView = decorView.getRootView();
        Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) rootView;
        viewGroup.addView(frameLayout);
        frameLayout.setOnClickListener(new WidgetGuildContextMenu$Companion$show$1(activity));
        FrameLayout frameLayout2 = new FrameLayout(activity);
        frameLayout2.setId(View.generateViewId());
        frameLayout2.setLayoutParams(new ViewGroup$LayoutParams(-2, -2));
        frameLayout.addView(frameLayout2);
        frameLayout2.setX(absolutePosition.x);
        frameLayout2.setY(f.coerceAtMost(absolutePosition.y, (viewGroup.getHeight() - computeMaxContextMenuHeight(activity)) - WidgetGuildContextMenu.access$getSCREEN_BOTTOM_BUFFER$cp()));
        activity.getSupportFragmentManager().beginTransaction().add(frameLayout2.getId(), newInstance(guildId), "WidgetGuildContextMenu").commit();
    }

    public /* synthetic */ WidgetGuildContextMenu$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
