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

    @NonNull
    public final ScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckedSetting f2556b;

    @NonNull
    public final LinkifiedTextView c;

    @NonNull
    public final CheckedSetting d;

    @NonNull
    public final CheckedSetting e;

    public WidgetServerSettingsCommunitySetupThirdStepBinding(@NonNull ScrollView scrollView, @NonNull ScrollView scrollView2, @NonNull ImageView imageView, @NonNull CheckedSetting checkedSetting, @NonNull LinkifiedTextView linkifiedTextView, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull ScreenTitleView screenTitleView) {
        this.a = scrollView;
        this.f2556b = checkedSetting;
        this.c = linkifiedTextView;
        this.d = checkedSetting2;
        this.e = checkedSetting3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
