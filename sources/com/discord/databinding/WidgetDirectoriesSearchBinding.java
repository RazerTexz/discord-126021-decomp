package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetDirectoriesSearchBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinkifiedTextView f2363b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final TextView d;

    @NonNull
    public final RecyclerView e;

    @NonNull
    public final FloatingActionButton f;

    @NonNull
    public final TextInputLayout g;

    @NonNull
    public final TextInputEditText h;

    public WidgetDirectoriesSearchBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppBarLayout appBarLayout, @NonNull Barrier barrier, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull FloatingActionButton floatingActionButton, @NonNull TextInputLayout textInputLayout, @NonNull TextInputEditText textInputEditText) {
        this.a = constraintLayout;
        this.f2363b = linkifiedTextView;
        this.c = linearLayout;
        this.d = textView;
        this.e = recyclerView;
        this.f = floatingActionButton;
        this.g = textInputLayout;
        this.h = textInputEditText;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
