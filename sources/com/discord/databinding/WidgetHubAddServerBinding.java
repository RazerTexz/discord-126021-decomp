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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17144a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f17145b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ScreenTitleView f17146c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final RecyclerView f17147d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SegmentedControlContainer f17148e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final CardSegment f17149f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final CardSegment f17150g;

    public WidgetHubAddServerBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull ScreenTitleView screenTitleView, @NonNull RecyclerView recyclerView, @NonNull SegmentedControlContainer segmentedControlContainer, @NonNull CardSegment cardSegment, @NonNull CardSegment cardSegment2) {
        this.f17144a = linearLayout;
        this.f17145b = materialButton;
        this.f17146c = screenTitleView;
        this.f17147d = recyclerView;
        this.f17148e = segmentedControlContainer;
        this.f17149f = cardSegment;
        this.f17150g = cardSegment2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17144a;
    }
}
