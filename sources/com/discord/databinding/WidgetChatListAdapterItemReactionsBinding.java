package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.flexbox.FlexboxLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemReactionsBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f2329b;

    @NonNull
    public final View c;

    @NonNull
    public final FlexboxLayout d;

    public WidgetChatListAdapterItemReactionsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull View view2, @NonNull FlexboxLayout flexboxLayout) {
        this.a = constraintLayout;
        this.f2329b = view;
        this.c = view2;
        this.d = flexboxLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
