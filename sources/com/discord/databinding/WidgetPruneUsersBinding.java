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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ScrollView f17387a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f17388b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f17389c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f17390d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f17391e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final CheckedSetting f17392f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final CheckedSetting f17393g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final ProgressBar f17394h;

    public WidgetPruneUsersBinding(@NonNull ScrollView scrollView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull MaterialButton materialButton2, @NonNull TextView textView2, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull ProgressBar progressBar) {
        this.f17387a = scrollView;
        this.f17388b = materialButton;
        this.f17389c = textView;
        this.f17390d = materialButton2;
        this.f17391e = textView2;
        this.f17392f = checkedSetting;
        this.f17393g = checkedSetting2;
        this.f17394h = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17387a;
    }
}
