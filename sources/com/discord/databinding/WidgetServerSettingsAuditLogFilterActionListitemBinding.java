package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsAuditLogFilterActionListitemBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckedSetting f2540b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    public WidgetServerSettingsAuditLogFilterActionListitemBinding(@NonNull LinearLayout linearLayout, @NonNull CheckedSetting checkedSetting, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView2) {
        this.a = linearLayout;
        this.f2540b = checkedSetting;
        this.c = imageView;
        this.d = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
