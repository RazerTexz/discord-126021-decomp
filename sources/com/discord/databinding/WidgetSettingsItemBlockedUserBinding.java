package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsItemBlockedUserBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17979a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f17980b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f17981c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f17982d;

    public WidgetSettingsItemBlockedUserBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull MaterialButton materialButton) {
        this.f17979a = relativeLayout;
        this.f17980b = simpleDraweeView;
        this.f17981c = textView;
        this.f17982d = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17979a;
    }
}
