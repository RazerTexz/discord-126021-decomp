package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.chips_view.ChipsView;

/* JADX INFO: loaded from: classes.dex */
public final class GroupInviteFriendsBottomSheetBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ChipsView f2114b;

    @NonNull
    public final RecyclerView c;

    @NonNull
    public final ConstraintLayout d;

    @NonNull
    public final AppCompatImageView e;

    public GroupInviteFriendsBottomSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ChipsView chipsView, @NonNull RecyclerView recyclerView, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatImageView appCompatImageView) {
        this.a = constraintLayout;
        this.f2114b = chipsView;
        this.c = recyclerView;
        this.d = constraintLayout2;
        this.e = appCompatImageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
