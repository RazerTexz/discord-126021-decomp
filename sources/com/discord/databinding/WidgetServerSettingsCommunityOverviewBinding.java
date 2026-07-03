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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17576a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CommunitySelectorView f17577b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CommunitySelectorView f17578c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final CommunitySelectorView f17579d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LoadingButton f17580e;

    public WidgetServerSettingsCommunityOverviewBinding(@NonNull LinearLayout linearLayout, @NonNull CommunitySelectorView communitySelectorView, @NonNull CommunitySelectorView communitySelectorView2, @NonNull CommunitySelectorView communitySelectorView3, @NonNull ScrollView scrollView, @NonNull LoadingButton loadingButton, @NonNull CommunitySelectorView communitySelectorView4) {
        this.f17576a = linearLayout;
        this.f17577b = communitySelectorView;
        this.f17578c = communitySelectorView2;
        this.f17579d = communitySelectorView3;
        this.f17580e = loadingButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17576a;
    }
}
