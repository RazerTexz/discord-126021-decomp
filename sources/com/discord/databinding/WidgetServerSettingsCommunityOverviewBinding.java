package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;
import com.discord.widgets.servers.community.CommunitySelectorView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsCommunityOverviewBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CommunitySelectorView f2553b;

    @NonNull
    public final CommunitySelectorView c;

    @NonNull
    public final CommunitySelectorView d;

    @NonNull
    public final LoadingButton e;

    public WidgetServerSettingsCommunityOverviewBinding(@NonNull LinearLayout linearLayout, @NonNull CommunitySelectorView communitySelectorView, @NonNull CommunitySelectorView communitySelectorView2, @NonNull CommunitySelectorView communitySelectorView3, @NonNull ScrollView scrollView, @NonNull LoadingButton loadingButton, @NonNull CommunitySelectorView communitySelectorView4) {
        this.a = linearLayout;
        this.f2553b = communitySelectorView;
        this.c = communitySelectorView2;
        this.d = communitySelectorView3;
        this.e = loadingButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
