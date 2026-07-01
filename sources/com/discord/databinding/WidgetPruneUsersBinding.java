package com.discord.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsersBinding implements ViewBinding {

    @NonNull
    public final ScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2514b;

    @NonNull
    public final TextView c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final TextView e;

    @NonNull
    public final CheckedSetting f;

    @NonNull
    public final CheckedSetting g;

    @NonNull
    public final ProgressBar h;

    public WidgetPruneUsersBinding(@NonNull ScrollView scrollView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull MaterialButton materialButton2, @NonNull TextView textView2, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull ProgressBar progressBar) {
        this.a = scrollView;
        this.f2514b = materialButton;
        this.c = textView;
        this.d = materialButton2;
        this.e = textView2;
        this.f = checkedSetting;
        this.g = checkedSetting2;
        this.h = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
