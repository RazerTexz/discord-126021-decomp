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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16451a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinkifiedTextView f16452b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinearLayout f16453c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16454d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final RecyclerView f16455e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final FloatingActionButton f16456f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextInputLayout f16457g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextInputEditText f16458h;

    public WidgetDirectoriesSearchBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppBarLayout appBarLayout, @NonNull Barrier barrier, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull FloatingActionButton floatingActionButton, @NonNull TextInputLayout textInputLayout, @NonNull TextInputEditText textInputEditText) {
        this.f16451a = constraintLayout;
        this.f16452b = linkifiedTextView;
        this.f16453c = linearLayout;
        this.f16454d = textView;
        this.f16455e = recyclerView;
        this.f16456f = floatingActionButton;
        this.f16457g = textInputLayout;
        this.f16458h = textInputEditText;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16451a;
    }
}
