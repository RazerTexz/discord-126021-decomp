package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.GuildView;
import com.discord.views.LoadingButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetHubAddNameBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17138a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final GuildView f17139b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputEditText f17140c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextInputLayout f17141d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f17142e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final LoadingButton f17143f;

    public WidgetHubAddNameBinding(@NonNull LinearLayout linearLayout, @NonNull GuildView guildView, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView, @NonNull LoadingButton loadingButton) {
        this.f17138a = linearLayout;
        this.f17139b = guildView;
        this.f17140c = textInputEditText;
        this.f17141d = textInputLayout;
        this.f17142e = textView;
        this.f17143f = loadingButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17138a;
    }
}
