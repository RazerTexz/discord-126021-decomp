package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSetCustomStatusBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f2692b;

    @NonNull
    public final FrameLayout c;

    @NonNull
    public final MaterialRadioButton d;

    @NonNull
    public final MaterialRadioButton e;

    @NonNull
    public final MaterialRadioButton f;

    @NonNull
    public final MaterialRadioButton g;

    @NonNull
    public final MaterialRadioButton h;

    @NonNull
    public final FloatingActionButton i;

    @NonNull
    public final TextInputLayout j;

    public WidgetUserSetCustomStatusBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull FrameLayout frameLayout, @NonNull RadioGroup radioGroup, @NonNull MaterialRadioButton materialRadioButton, @NonNull MaterialRadioButton materialRadioButton2, @NonNull MaterialRadioButton materialRadioButton3, @NonNull MaterialRadioButton materialRadioButton4, @NonNull MaterialRadioButton materialRadioButton5, @NonNull FloatingActionButton floatingActionButton, @NonNull TextInputLayout textInputLayout) {
        this.a = coordinatorLayout;
        this.f2692b = simpleDraweeView;
        this.c = frameLayout;
        this.d = materialRadioButton;
        this.e = materialRadioButton2;
        this.f = materialRadioButton3;
        this.g = materialRadioButton4;
        this.h = materialRadioButton5;
        this.i = floatingActionButton;
        this.j = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
