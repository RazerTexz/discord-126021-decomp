package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetDisableGuildCommunicationBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2367b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextInputLayout d;

    @NonNull
    public final TextView e;

    @NonNull
    public final CheckedSetting f;

    @NonNull
    public final CheckedSetting g;

    @NonNull
    public final CheckedSetting h;

    @NonNull
    public final CheckedSetting i;

    @NonNull
    public final CheckedSetting j;

    @NonNull
    public final CheckedSetting k;

    public WidgetDisableGuildCommunicationBinding(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull View view, @NonNull TextView textView5, @NonNull ConstraintLayout constraintLayout2, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull CheckedSetting checkedSetting4, @NonNull CheckedSetting checkedSetting5, @NonNull CheckedSetting checkedSetting6) {
        this.a = constraintLayout;
        this.f2367b = materialButton;
        this.c = textView;
        this.d = textInputLayout;
        this.e = textView3;
        this.f = checkedSetting;
        this.g = checkedSetting2;
        this.h = checkedSetting3;
        this.i = checkedSetting4;
        this.j = checkedSetting5;
        this.k = checkedSetting6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
