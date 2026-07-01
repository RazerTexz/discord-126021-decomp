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

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppViewFlipper f2279b;

    @NonNull
    public final SegmentedControlContainer c;

    public WidgetChannelSettingsPermissionsOverviewBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FragmentContainerView fragmentContainerView, @NonNull AppViewFlipper appViewFlipper, @NonNull SegmentedControlContainer segmentedControlContainer, @NonNull FragmentContainerView fragmentContainerView2) {
        this.a = coordinatorLayout;
        this.f2279b = appViewFlipper;
        this.c = segmentedControlContainer;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
