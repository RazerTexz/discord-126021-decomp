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

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildView f2467b;

    @NonNull
    public final TextInputEditText c;

    @NonNull
    public final TextInputLayout d;

    @NonNull
    public final TextView e;

    @NonNull
    public final LoadingButton f;

    public WidgetHubAddNameBinding(@NonNull LinearLayout linearLayout, @NonNull GuildView guildView, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView, @NonNull LoadingButton loadingButton) {
        this.a = linearLayout;
        this.f2467b = guildView;
        this.c = textInputEditText;
        this.d = textInputLayout;
        this.e = textView;
        this.f = loadingButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
