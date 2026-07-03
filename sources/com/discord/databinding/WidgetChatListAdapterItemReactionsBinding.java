package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.flexbox.FlexboxLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemReactionsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16268a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final View f16269b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final View f16270c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final FlexboxLayout f16271d;

    public WidgetChatListAdapterItemReactionsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull View view2, @NonNull FlexboxLayout flexboxLayout) {
        this.f16268a = constraintLayout;
        this.f16269b = view;
        this.f16270c = view2;
        this.f16271d = flexboxLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16268a;
    }
}
