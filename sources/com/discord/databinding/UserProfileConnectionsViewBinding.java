package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class UserProfileConnectionsViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15335a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15336b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15337c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final RecyclerView f15338d;

    public UserProfileConnectionsViewBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RecyclerView recyclerView) {
        this.f15335a = linearLayout;
        this.f15336b = textView;
        this.f15337c = textView2;
        this.f15338d = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15335a;
    }
}
