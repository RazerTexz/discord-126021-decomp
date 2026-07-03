package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.viewbinding.ViewBinding;
import com.discord.views.user.SettingsMemberView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsInstantInviteListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CardView f17681a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17682b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f17683c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17684d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f17685e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final SettingsMemberView f17686f;

    public WidgetServerSettingsInstantInviteListItemBinding(@NonNull CardView cardView, @NonNull Barrier barrier, @NonNull Barrier barrier2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView3, @NonNull ImageView imageView, @NonNull TextView textView4, @NonNull LinearLayout linearLayout3, @NonNull SettingsMemberView settingsMemberView) {
        this.f17681a = cardView;
        this.f17682b = textView;
        this.f17683c = textView2;
        this.f17684d = textView3;
        this.f17685e = textView4;
        this.f17686f = settingsMemberView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17681a;
    }
}
