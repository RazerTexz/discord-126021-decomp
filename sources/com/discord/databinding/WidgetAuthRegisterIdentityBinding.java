package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetAuthRegisterIdentityBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f15708a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f15709b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CardSegment f15710c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final PhoneOrEmailInputView f15711d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LinkifiedTextView f15712e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final CardSegment f15713f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final SegmentedControlContainer f15714g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final DimmerView f15715h;

    public WidgetAuthRegisterIdentityBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull MaterialButton materialButton, @NonNull CardSegment cardSegment, @NonNull PhoneOrEmailInputView phoneOrEmailInputView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull CardSegment cardSegment2, @NonNull SegmentedControlContainer segmentedControlContainer, @NonNull DimmerView dimmerView) {
        this.f15708a = coordinatorLayout;
        this.f15709b = materialButton;
        this.f15710c = cardSegment;
        this.f15711d = phoneOrEmailInputView;
        this.f15712e = linkifiedTextView;
        this.f15713f = cardSegment2;
        this.f15714g = segmentedControlContainer;
        this.f15715h = dimmerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15708a;
    }
}
