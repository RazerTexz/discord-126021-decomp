package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelSettingsPermissionsOverviewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f15955a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final AppViewFlipper f15956b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SegmentedControlContainer f15957c;

    public WidgetChannelSettingsPermissionsOverviewBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FragmentContainerView fragmentContainerView, @NonNull AppViewFlipper appViewFlipper, @NonNull SegmentedControlContainer segmentedControlContainer, @NonNull FragmentContainerView fragmentContainerView2) {
        this.f15955a = coordinatorLayout;
        this.f15956b = appViewFlipper;
        this.f15957c = segmentedControlContainer;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15955a;
    }
}
