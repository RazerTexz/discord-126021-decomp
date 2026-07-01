package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.tooltips.SparkleView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildsListItemHubVerificationBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SparkleView f2463b;

    public WidgetGuildsListItemHubVerificationBinding(@NonNull FrameLayout frameLayout, @NonNull SparkleView sparkleView) {
        this.a = frameLayout;
        this.f2463b = sparkleView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
