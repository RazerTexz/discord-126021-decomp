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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15108a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ChipsView f15109b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f15110c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ConstraintLayout f15111d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final AppCompatImageView f15112e;

    public GroupInviteFriendsBottomSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ChipsView chipsView, @NonNull RecyclerView recyclerView, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatImageView appCompatImageView) {
        this.f15108a = constraintLayout;
        this.f15109b = chipsView;
        this.f15110c = recyclerView;
        this.f15111d = constraintLayout2;
        this.f15112e = appCompatImageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15108a;
    }
}
