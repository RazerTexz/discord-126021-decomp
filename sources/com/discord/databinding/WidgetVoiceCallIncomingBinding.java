package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.voice.fullscreen.grid.PrivateCallBlurredGridView;
import com.discord.widgets.voice.fullscreen.grid.PrivateCallGridView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallIncomingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f18446a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinearLayout f18447b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FloatingActionButton f18448c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final FloatingActionButton f18449d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final PrivateCallBlurredGridView f18450e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final FloatingActionButton f18451f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f18452g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f18453h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final PrivateCallGridView f18454i;

    public WidgetVoiceCallIncomingBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull FloatingActionButton floatingActionButton2, @NonNull PrivateCallBlurredGridView privateCallBlurredGridView, @NonNull FloatingActionButton floatingActionButton3, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull Guideline guideline, @NonNull PrivateCallGridView privateCallGridView) {
        this.f18446a = constraintLayout;
        this.f18447b = linearLayout;
        this.f18448c = floatingActionButton;
        this.f18449d = floatingActionButton2;
        this.f18450e = privateCallBlurredGridView;
        this.f18451f = floatingActionButton3;
        this.f18452g = textView;
        this.f18453h = textView2;
        this.f18454i = privateCallGridView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18446a;
    }
}
