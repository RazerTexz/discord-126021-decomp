package com.discord.widgets.channels.permissions;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelSettingsPermissionsOverviewBinding;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsPermissionsOverview$viewBinding$2 extends k implements Function1<View, WidgetChannelSettingsPermissionsOverviewBinding> {
    public static final WidgetChannelSettingsPermissionsOverview$viewBinding$2 INSTANCE = new WidgetChannelSettingsPermissionsOverview$viewBinding$2();

    public WidgetChannelSettingsPermissionsOverview$viewBinding$2() {
        super(1, WidgetChannelSettingsPermissionsOverviewBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsPermissionsOverviewBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelSettingsPermissionsOverviewBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelSettingsPermissionsOverviewBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.advanced_permissions_fragment;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R$id.advanced_permissions_fragment);
        if (fragmentContainerView != null) {
            i = R$id.flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.flipper);
            if (appViewFlipper != null) {
                i = R$id.segmented_control;
                SegmentedControlContainer segmentedControlContainer = (SegmentedControlContainer) view.findViewById(R$id.segmented_control);
                if (segmentedControlContainer != null) {
                    i = R$id.stage_moderator_permissions_fragment;
                    FragmentContainerView fragmentContainerView2 = (FragmentContainerView) view.findViewById(R$id.stage_moderator_permissions_fragment);
                    if (fragmentContainerView2 != null) {
                        return new WidgetChannelSettingsPermissionsOverviewBinding((CoordinatorLayout) view, fragmentContainerView, appViewFlipper, segmentedControlContainer, fragmentContainerView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
