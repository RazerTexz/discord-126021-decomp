package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsEnableCommunityBinding implements ViewBinding {

    @NonNull
    public final ScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2568b;

    public WidgetServerSettingsEnableCommunityBinding(@NonNull ScrollView scrollView, @NonNull ScreenTitleView screenTitleView, @NonNull ImageView imageView, @NonNull ScrollView scrollView2, @NonNull RelativeLayout relativeLayout, @NonNull MaterialButton materialButton) {
        this.a = scrollView;
        this.f2568b = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
