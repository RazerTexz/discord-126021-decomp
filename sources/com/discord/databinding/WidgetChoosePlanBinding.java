package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChoosePlanBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f2349b;

    @NonNull
    public final LinkifiedTextView c;

    @NonNull
    public final RecyclerView d;

    @NonNull
    public final DimmerView e;

    public WidgetChoosePlanBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LinearLayout linearLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull RecyclerView recyclerView, @NonNull DimmerView dimmerView) {
        this.a = coordinatorLayout;
        this.f2349b = linearLayout;
        this.c = linkifiedTextView;
        this.d = recyclerView;
        this.e = dimmerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
