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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16474a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f16475b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16476c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextInputLayout f16477d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16478e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final CheckedSetting f16479f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final CheckedSetting f16480g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final CheckedSetting f16481h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final CheckedSetting f16482i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final CheckedSetting f16483j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final CheckedSetting f16484k;

    public WidgetDisableGuildCommunicationBinding(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull View view, @NonNull TextView textView5, @NonNull ConstraintLayout constraintLayout2, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull CheckedSetting checkedSetting4, @NonNull CheckedSetting checkedSetting5, @NonNull CheckedSetting checkedSetting6) {
        this.f16474a = constraintLayout;
        this.f16475b = materialButton;
        this.f16476c = textView;
        this.f16477d = textInputLayout;
        this.f16478e = textView3;
        this.f16479f = checkedSetting;
        this.f16480g = checkedSetting2;
        this.f16481h = checkedSetting3;
        this.f16482i = checkedSetting4;
        this.f16483j = checkedSetting5;
        this.f16484k = checkedSetting6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16474a;
    }
}
