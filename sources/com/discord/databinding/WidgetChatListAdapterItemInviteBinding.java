package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.guilds.ServerMemberCount;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemInviteBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2325b;

    @NonNull
    public final TextView c;

    @NonNull
    public final FrameLayout d;

    @NonNull
    public final LinkifiedTextView e;

    @NonNull
    public final SimpleDraweeView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final MaterialButton h;

    @NonNull
    public final MaterialButton i;

    @NonNull
    public final View j;

    @NonNull
    public final ServerMemberCount k;

    @NonNull
    public final MaterialButton l;

    @NonNull
    public final TextView m;

    @NonNull
    public final SimpleDraweeView n;

    @NonNull
    public final RoundedRelativeLayout o;

    public WidgetChatListAdapterItemInviteBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Barrier barrier, @NonNull Barrier barrier2, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull FrameLayout frameLayout2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView3, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull View view, @NonNull ServerMemberCount serverMemberCount, @NonNull MaterialButton materialButton3, @NonNull TextView textView4, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull RoundedRelativeLayout roundedRelativeLayout, @NonNull ConstraintLayout constraintLayout2) {
        this.a = constraintLayout;
        this.f2325b = textView;
        this.c = textView2;
        this.d = frameLayout2;
        this.e = linkifiedTextView;
        this.f = simpleDraweeView;
        this.g = textView3;
        this.h = materialButton;
        this.i = materialButton2;
        this.j = view;
        this.k = serverMemberCount;
        this.l = materialButton3;
        this.m = textView4;
        this.n = simpleDraweeView2;
        this.o = roundedRelativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
