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
import b.a.i.t4;
import b.a.i.u4;
import b.a.i.v4;

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
    public final u4 r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final t4 f2304s;

    @NonNull
    public final v4 t;

    public WidgetChatInputBinding(@NonNull LinearLayout linearLayout, @NonNull WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout, @NonNull AppCompatImageButton appCompatImageButton, @NonNull TextView textView, @NonNull LinearLayout linearLayout3, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull RecyclerView recyclerView2, @NonNull LinearLayout linearLayout4, @NonNull TextView textView4, @NonNull RecyclerView recyclerView3, @NonNull FragmentContainerView fragmentContainerView, @NonNull LinearLayout linearLayout5, @NonNull u4 u4Var, @NonNull t4 t4Var, @NonNull v4 v4Var) {
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
        this.r = u4Var;
        this.f2304s = t4Var;
        this.t = v4Var;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
