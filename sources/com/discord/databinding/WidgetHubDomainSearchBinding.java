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
public final class WidgetHubDomainSearchBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f17162a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinkifiedTextView f17163b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinearLayout f17164c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17165d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final RecyclerView f17166e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final FloatingActionButton f17167f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextInputLayout f17168g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextInputEditText f17169h;

    public WidgetHubDomainSearchBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppBarLayout appBarLayout, @NonNull Barrier barrier, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull FloatingActionButton floatingActionButton, @NonNull TextInputLayout textInputLayout, @NonNull TextInputEditText textInputEditText) {
        this.f17162a = constraintLayout;
        this.f17163b = linkifiedTextView;
        this.f17164c = linearLayout;
        this.f17165d = textView;
        this.f17166e = recyclerView;
        this.f17167f = floatingActionButton;
        this.f17168g = textInputLayout;
        this.f17169h = textInputEditText;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17162a;
    }
}
