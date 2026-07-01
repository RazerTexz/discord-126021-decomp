package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.ScreenTitleView;
import com.discord.widgets.servers.community.CommunitySelectorView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsCommunitySetupSecondStepBinding implements ViewBinding {

    @NonNull
    public final ScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CommunitySelectorView f2555b;

    @NonNull
    public final CommunitySelectorView c;

    public WidgetServerSettingsCommunitySetupSecondStepBinding(@NonNull ScrollView scrollView, @NonNull ScrollView scrollView2, @NonNull ImageView imageView, @NonNull CommunitySelectorView communitySelectorView, @NonNull ScreenTitleView screenTitleView, @NonNull CommunitySelectorView communitySelectorView2) {
        this.a = scrollView;
        this.f2555b = communitySelectorView;
        this.c = communitySelectorView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
