package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.GuildView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class HubAddServerConfirmationDialogBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2125b;

    @NonNull
    public final GuildView c;

    @NonNull
    public final MaterialButton d;

    public HubAddServerConfirmationDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull GuildView guildView, @NonNull MaterialButton materialButton) {
        this.a = linearLayout;
        this.f2125b = textView;
        this.c = guildView;
        this.d = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
