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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16238a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16239b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16240c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final FrameLayout f16241d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LinkifiedTextView f16242e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final SimpleDraweeView f16243f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f16244g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final MaterialButton f16245h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final MaterialButton f16246i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final View f16247j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final ServerMemberCount f16248k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final MaterialButton f16249l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final TextView f16250m;

    /* JADX INFO: renamed from: n */
    @NonNull
    public final SimpleDraweeView f16251n;

    /* JADX INFO: renamed from: o */
    @NonNull
    public final RoundedRelativeLayout f16252o;

    public WidgetChatListAdapterItemInviteBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Barrier barrier, @NonNull Barrier barrier2, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull FrameLayout frameLayout2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView3, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull View view, @NonNull ServerMemberCount serverMemberCount, @NonNull MaterialButton materialButton3, @NonNull TextView textView4, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull RoundedRelativeLayout roundedRelativeLayout, @NonNull ConstraintLayout constraintLayout2) {
        this.f16238a = constraintLayout;
        this.f16239b = textView;
        this.f16240c = textView2;
        this.f16241d = frameLayout2;
        this.f16242e = linkifiedTextView;
        this.f16243f = simpleDraweeView;
        this.f16244g = textView3;
        this.f16245h = materialButton;
        this.f16246i = materialButton2;
        this.f16247j = view;
        this.f16248k = serverMemberCount;
        this.f16249l = materialButton3;
        this.f16250m = textView4;
        this.f16251n = simpleDraweeView2;
        this.f16252o = roundedRelativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16238a;
    }
}
