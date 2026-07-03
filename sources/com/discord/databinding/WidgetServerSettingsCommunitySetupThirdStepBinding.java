package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;
import com.discord.views.ScreenTitleView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsCommunitySetupThirdStepBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ScrollView f17587a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CheckedSetting f17588b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinkifiedTextView f17589c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final CheckedSetting f17590d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final CheckedSetting f17591e;

    public WidgetServerSettingsCommunitySetupThirdStepBinding(@NonNull ScrollView scrollView, @NonNull ScrollView scrollView2, @NonNull ImageView imageView, @NonNull CheckedSetting checkedSetting, @NonNull LinkifiedTextView linkifiedTextView, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull ScreenTitleView screenTitleView) {
        this.f17587a = scrollView;
        this.f17588b = checkedSetting;
        this.f17589c = linkifiedTextView;
        this.f17590d = checkedSetting2;
        this.f17591e = checkedSetting3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17587a;
    }
}
