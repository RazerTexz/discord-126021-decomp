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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15161a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15162b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final GuildView f15163c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f15164d;

    public HubAddServerConfirmationDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull GuildView guildView, @NonNull MaterialButton materialButton) {
        this.f15161a = linearLayout;
        this.f15162b = textView;
        this.f15163c = guildView;
        this.f15164d = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15161a;
    }
}
