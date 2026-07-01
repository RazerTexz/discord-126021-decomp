package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsEditMemberBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f2561b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextInputLayout e;

    @NonNull
    public final LinearLayout f;

    @NonNull
    public final RecyclerView g;

    @NonNull
    public final FloatingActionButton h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    public WidgetServerSettingsEditMemberBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextInputLayout textInputLayout, @NonNull LinearLayout linearLayout2, @NonNull RecyclerView recyclerView, @NonNull FloatingActionButton floatingActionButton, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.a = coordinatorLayout;
        this.f2561b = linearLayout;
        this.c = textView;
        this.d = textView2;
        this.e = textInputLayout;
        this.f = linearLayout2;
        this.g = recyclerView;
        this.h = floatingActionButton;
        this.i = textView3;
        this.j = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
