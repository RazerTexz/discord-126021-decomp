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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f18128a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f18129b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f18130c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f18131d;

    public WidgetStageAudienceNoticeBottomSheetBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Barrier barrier, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull ImageView imageView3, @NonNull TextView textView3, @NonNull ImageView imageView4, @NonNull TextView textView4, @NonNull MaterialButton materialButton, @NonNull ImageView imageView5, @NonNull TextView textView5) {
        this.f18128a = coordinatorLayout;
        this.f18129b = imageView4;
        this.f18130c = textView4;
        this.f18131d = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18128a;
    }
}
