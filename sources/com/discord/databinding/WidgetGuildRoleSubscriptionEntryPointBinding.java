package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildRoleSubscriptionEntryPointBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16921a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16922b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16923c;

    public WidgetGuildRoleSubscriptionEntryPointBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Toolbar toolbar, @NonNull AppBarLayout appBarLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f16921a = constraintLayout;
        this.f16922b = textView;
        this.f16923c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16921a;
    }
}
