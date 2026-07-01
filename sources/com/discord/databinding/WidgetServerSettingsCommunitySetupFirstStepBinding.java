package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.discord.views.ScreenTitleView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsCommunitySetupFirstStepBinding implements ViewBinding {

    @NonNull
    public final ScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckedSetting f2554b;

    @NonNull
    public final CheckedSetting c;

    public WidgetServerSettingsCommunitySetupFirstStepBinding(@NonNull ScrollView scrollView, @NonNull ScrollView scrollView2, @NonNull ImageView imageView, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull ScreenTitleView screenTitleView) {
        this.a = scrollView;
        this.f2554b = checkedSetting;
        this.c = checkedSetting2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
