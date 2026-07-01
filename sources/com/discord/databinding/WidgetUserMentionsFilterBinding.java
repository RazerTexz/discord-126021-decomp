package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentionsFilterBinding implements ViewBinding {

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckedSetting f2683b;

    @NonNull
    public final CheckedSetting c;

    @NonNull
    public final CheckedSetting d;

    public WidgetUserMentionsFilterBinding(@NonNull NestedScrollView nestedScrollView, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3) {
        this.a = nestedScrollView;
        this.f2683b = checkedSetting;
        this.c = checkedSetting2;
        this.d = checkedSetting3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
