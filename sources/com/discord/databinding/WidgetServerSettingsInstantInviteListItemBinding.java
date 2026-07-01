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

    @NonNull
    public final CardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2574b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final SettingsMemberView f;

    public WidgetServerSettingsInstantInviteListItemBinding(@NonNull CardView cardView, @NonNull Barrier barrier, @NonNull Barrier barrier2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView3, @NonNull ImageView imageView, @NonNull TextView textView4, @NonNull LinearLayout linearLayout3, @NonNull SettingsMemberView settingsMemberView) {
        this.a = cardView;
        this.f2574b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = textView4;
        this.f = settingsMemberView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
