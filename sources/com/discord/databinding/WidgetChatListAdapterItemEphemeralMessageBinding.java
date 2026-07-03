package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemEphemeralMessageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16202a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final View f16203b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final View f16204c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f16205d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16206e;

    public WidgetChatListAdapterItemEphemeralMessageBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull View view2, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull Guideline guideline) {
        this.f16202a = constraintLayout;
        this.f16203b = view;
        this.f16204c = view2;
        this.f16205d = imageView;
        this.f16206e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16202a;
    }
}
