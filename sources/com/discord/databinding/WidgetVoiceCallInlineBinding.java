package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallInlineBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f18455a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinearLayout f18456b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f18457c;

    public WidgetVoiceCallInlineBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull MaterialButton materialButton) {
        this.f18455a = linearLayout;
        this.f18456b = linearLayout2;
        this.f18457c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18455a;
    }
}
