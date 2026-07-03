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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17512a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CheckedSetting f17513b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f17514c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f17515d;

    public WidgetServerSettingsAuditLogFilterActionListitemBinding(@NonNull LinearLayout linearLayout, @NonNull CheckedSetting checkedSetting, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView2) {
        this.f17512a = linearLayout;
        this.f17513b = checkedSetting;
        this.f17514c = imageView;
        this.f17515d = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17512a;
    }
}
