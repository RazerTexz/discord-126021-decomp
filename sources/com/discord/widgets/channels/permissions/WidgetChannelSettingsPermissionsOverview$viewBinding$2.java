package com.discord.widgets.channels.permissions;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelSettingsPermissionsOverviewBinding;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsPermissionsOverview$viewBinding$2 extends C12236k implements Function1<View, WidgetChannelSettingsPermissionsOverviewBinding> {
    public static final WidgetChannelSettingsPermissionsOverview$viewBinding$2 INSTANCE = new WidgetChannelSettingsPermissionsOverview$viewBinding$2();

    public WidgetChannelSettingsPermissionsOverview$viewBinding$2() {
        super(1, WidgetChannelSettingsPermissionsOverviewBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsPermissionsOverviewBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelSettingsPermissionsOverviewBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.advanced_permissions_fragment;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(C5419R.id.advanced_permissions_fragment);
        if (fragmentContainerView != null) {
            i = C5419R.id.flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.flipper);
            if (appViewFlipper != null) {
                i = C5419R.id.segmented_control;
                SegmentedControlContainer segmentedControlContainer = (SegmentedControlContainer) view.findViewById(C5419R.id.segmented_control);
                if (segmentedControlContainer != null) {
                    i = C5419R.id.stage_moderator_permissions_fragment;
                    FragmentContainerView fragmentContainerView2 = (FragmentContainerView) view.findViewById(C5419R.id.stage_moderator_permissions_fragment);
                    if (fragmentContainerView2 != null) {
                        return new WidgetChannelSettingsPermissionsOverviewBinding((CoordinatorLayout) view, fragmentContainerView, appViewFlipper, segmentedControlContainer, fragmentContainerView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
