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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f18377a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f18378b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FrameLayout f18379c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialRadioButton f18380d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialRadioButton f18381e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialRadioButton f18382f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final MaterialRadioButton f18383g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final MaterialRadioButton f18384h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final FloatingActionButton f18385i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final TextInputLayout f18386j;

    public WidgetUserSetCustomStatusBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull FrameLayout frameLayout, @NonNull RadioGroup radioGroup, @NonNull MaterialRadioButton materialRadioButton, @NonNull MaterialRadioButton materialRadioButton2, @NonNull MaterialRadioButton materialRadioButton3, @NonNull MaterialRadioButton materialRadioButton4, @NonNull MaterialRadioButton materialRadioButton5, @NonNull FloatingActionButton floatingActionButton, @NonNull TextInputLayout textInputLayout) {
        this.f18377a = coordinatorLayout;
        this.f18378b = simpleDraweeView;
        this.f18379c = frameLayout;
        this.f18380d = materialRadioButton;
        this.f18381e = materialRadioButton2;
        this.f18382f = materialRadioButton3;
        this.f18383g = materialRadioButton4;
        this.f18384h = materialRadioButton5;
        this.f18385i = floatingActionButton;
        this.f18386j = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18377a;
    }
}
