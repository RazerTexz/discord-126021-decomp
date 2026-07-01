package com.discord.widgets.channels.permissions;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelSettingsPermissionsOverviewBinding;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$viewBinding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsPermissionsOverview3 extends FunctionReferenceImpl implements Function1<View, WidgetChannelSettingsPermissionsOverviewBinding> {
    public static final WidgetChannelSettingsPermissionsOverview3 INSTANCE = new WidgetChannelSettingsPermissionsOverview3();

    public WidgetChannelSettingsPermissionsOverview3() {
        super(1, WidgetChannelSettingsPermissionsOverviewBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsPermissionsOverviewBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelSettingsPermissionsOverviewBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.advanced_permissions_fragment;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.advanced_permissions_fragment);
        if (fragmentContainerView != null) {
            i = R.id.flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.flipper);
            if (appViewFlipper != null) {
                i = R.id.segmented_control;
                SegmentedControlContainer segmentedControlContainer = (SegmentedControlContainer) view.findViewById(R.id.segmented_control);
                if (segmentedControlContainer != null) {
                    i = R.id.stage_moderator_permissions_fragment;
                    FragmentContainerView fragmentContainerView2 = (FragmentContainerView) view.findViewById(R.id.stage_moderator_permissions_fragment);
                    if (fragmentContainerView2 != null) {
                        return new WidgetChannelSettingsPermissionsOverviewBinding((CoordinatorLayout) view, fragmentContainerView, appViewFlipper, segmentedControlContainer, fragmentContainerView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
