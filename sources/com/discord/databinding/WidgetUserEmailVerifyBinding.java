package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserEmailVerifyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f18330a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f18331b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f18332c;

    public WidgetUserEmailVerifyBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2) {
        this.f18330a = relativeLayout;
        this.f18331b = materialButton;
        this.f18332c = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18330a;
    }
}
