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

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2237b;

    @NonNull
    public final CardSegment c;

    @NonNull
    public final PhoneOrEmailInputView d;

    @NonNull
    public final LinkifiedTextView e;

    @NonNull
    public final CardSegment f;

    @NonNull
    public final SegmentedControlContainer g;

    @NonNull
    public final DimmerView h;

    public WidgetAuthRegisterIdentityBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull MaterialButton materialButton, @NonNull CardSegment cardSegment, @NonNull PhoneOrEmailInputView phoneOrEmailInputView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull CardSegment cardSegment2, @NonNull SegmentedControlContainer segmentedControlContainer, @NonNull DimmerView dimmerView) {
        this.a = coordinatorLayout;
        this.f2237b = materialButton;
        this.c = cardSegment;
        this.d = phoneOrEmailInputView;
        this.e = linkifiedTextView;
        this.f = cardSegment2;
        this.g = segmentedControlContainer;
        this.h = dimmerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
