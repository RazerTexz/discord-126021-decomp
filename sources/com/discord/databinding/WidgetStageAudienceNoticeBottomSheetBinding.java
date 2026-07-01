package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStageAudienceNoticeBottomSheetBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2648b;

    @NonNull
    public final TextView c;

    @NonNull
    public final MaterialButton d;

    public WidgetStageAudienceNoticeBottomSheetBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Barrier barrier, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull ImageView imageView3, @NonNull TextView textView3, @NonNull ImageView imageView4, @NonNull TextView textView4, @NonNull MaterialButton materialButton, @NonNull ImageView imageView5, @NonNull TextView textView5) {
        this.a = coordinatorLayout;
        this.f2648b = imageView4;
        this.c = textView4;
        this.d = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
