package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import b.a.i.WidgetChatInputCommunicationDisabledGuardBinding;
import b.a.i.WidgetChatInputGuardBinding;
import b.a.i.WidgetChatInputMemberVerificationGuardBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatInputBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final WidgetChatInputApplicationCommandsBinding f2303b;

    @NonNull
    public final RecyclerView c;

    @NonNull
    public final LinearLayout d;

    @NonNull
    public final RelativeLayout e;

    @NonNull
    public final AppCompatImageButton f;

    @NonNull
    public final TextView g;

    @NonNull
    public final LinearLayout h;

    @NonNull
    public final ImageView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final RecyclerView l;

    @NonNull
    public final LinearLayout m;

    @NonNull
    public final TextView n;

    @NonNull
    public final RecyclerView o;

    @NonNull
    public final FragmentContainerView p;

    @NonNull
    public final LinearLayout q;

    @NonNull
    public final WidgetChatInputGuardBinding r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final WidgetChatInputCommunicationDisabledGuardBinding f2304s;

    @NonNull
    public final WidgetChatInputMemberVerificationGuardBinding t;

    public WidgetChatInputBinding(@NonNull LinearLayout linearLayout, @NonNull WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout, @NonNull AppCompatImageButton appCompatImageButton, @NonNull TextView textView, @NonNull LinearLayout linearLayout3, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull RecyclerView recyclerView2, @NonNull LinearLayout linearLayout4, @NonNull TextView textView4, @NonNull RecyclerView recyclerView3, @NonNull FragmentContainerView fragmentContainerView, @NonNull LinearLayout linearLayout5, @NonNull WidgetChatInputGuardBinding widgetChatInputGuardBinding, @NonNull WidgetChatInputCommunicationDisabledGuardBinding widgetChatInputCommunicationDisabledGuardBinding, @NonNull WidgetChatInputMemberVerificationGuardBinding widgetChatInputMemberVerificationGuardBinding) {
        this.a = linearLayout;
        this.f2303b = widgetChatInputApplicationCommandsBinding;
        this.c = recyclerView;
        this.d = linearLayout2;
        this.e = relativeLayout;
        this.f = appCompatImageButton;
        this.g = textView;
        this.h = linearLayout3;
        this.i = imageView;
        this.j = textView2;
        this.k = textView3;
        this.l = recyclerView2;
        this.m = linearLayout4;
        this.n = textView4;
        this.o = recyclerView3;
        this.p = fragmentContainerView;
        this.q = linearLayout5;
        this.r = widgetChatInputGuardBinding;
        this.f2304s = widgetChatInputCommunicationDisabledGuardBinding;
        this.t = widgetChatInputMemberVerificationGuardBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
