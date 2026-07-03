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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ScrollView f17581a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CheckedSetting f17582b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CheckedSetting f17583c;

    public WidgetServerSettingsCommunitySetupFirstStepBinding(@NonNull ScrollView scrollView, @NonNull ScrollView scrollView2, @NonNull ImageView imageView, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull ScreenTitleView screenTitleView) {
        this.f17581a = scrollView;
        this.f17582b = checkedSetting;
        this.f17583c = checkedSetting2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17581a;
    }
}
