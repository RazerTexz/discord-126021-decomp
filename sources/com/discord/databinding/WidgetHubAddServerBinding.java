package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.ScreenTitleView;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetHubAddServerBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2468b;

    @NonNull
    public final ScreenTitleView c;

    @NonNull
    public final RecyclerView d;

    @NonNull
    public final SegmentedControlContainer e;

    @NonNull
    public final CardSegment f;

    @NonNull
    public final CardSegment g;

    public WidgetHubAddServerBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull ScreenTitleView screenTitleView, @NonNull RecyclerView recyclerView, @NonNull SegmentedControlContainer segmentedControlContainer, @NonNull CardSegment cardSegment, @NonNull CardSegment cardSegment2) {
        this.a = linearLayout;
        this.f2468b = materialButton;
        this.c = screenTitleView;
        this.d = recyclerView;
        this.e = segmentedControlContainer;
        this.f = cardSegment;
        this.g = cardSegment2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
