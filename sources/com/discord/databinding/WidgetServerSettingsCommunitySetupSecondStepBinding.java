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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ScrollView f17584a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CommunitySelectorView f17585b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CommunitySelectorView f17586c;

    public WidgetServerSettingsCommunitySetupSecondStepBinding(@NonNull ScrollView scrollView, @NonNull ScrollView scrollView2, @NonNull ImageView imageView, @NonNull CommunitySelectorView communitySelectorView, @NonNull ScreenTitleView screenTitleView, @NonNull CommunitySelectorView communitySelectorView2) {
        this.f17584a = scrollView;
        this.f17585b = communitySelectorView;
        this.f17586c = communitySelectorView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17584a;
    }
}
