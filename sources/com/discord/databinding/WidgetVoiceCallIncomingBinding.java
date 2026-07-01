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

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f2700b;

    @NonNull
    public final FloatingActionButton c;

    @NonNull
    public final FloatingActionButton d;

    @NonNull
    public final PrivateCallBlurredGridView e;

    @NonNull
    public final FloatingActionButton f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final PrivateCallGridView i;

    public WidgetVoiceCallIncomingBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull FloatingActionButton floatingActionButton2, @NonNull PrivateCallBlurredGridView privateCallBlurredGridView, @NonNull FloatingActionButton floatingActionButton3, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull Guideline guideline, @NonNull PrivateCallGridView privateCallGridView) {
        this.a = constraintLayout;
        this.f2700b = linearLayout;
        this.c = floatingActionButton;
        this.d = floatingActionButton2;
        this.e = privateCallBlurredGridView;
        this.f = floatingActionButton3;
        this.g = textView;
        this.h = textView2;
        this.i = privateCallGridView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
