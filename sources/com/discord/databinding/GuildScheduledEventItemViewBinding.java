package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventBottomButtonView;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventDateView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class GuildScheduledEventItemViewBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildScheduledEventBottomButtonView f2120b;

    @NonNull
    public final ConstraintLayout c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final GuildScheduledEventDateView e;

    @NonNull
    public final LinkifiedTextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final SimpleDraweeView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final ImageView m;

    @NonNull
    public final LinkifiedTextView n;

    public GuildScheduledEventItemViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull GuildScheduledEventBottomButtonView guildScheduledEventBottomButtonView, @NonNull ConstraintLayout constraintLayout2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull GuildScheduledEventDateView guildScheduledEventDateView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull Barrier barrier, @NonNull ImageView imageView, @NonNull LinkifiedTextView linkifiedTextView2) {
        this.a = constraintLayout;
        this.f2120b = guildScheduledEventBottomButtonView;
        this.c = constraintLayout2;
        this.d = simpleDraweeView;
        this.e = guildScheduledEventDateView;
        this.f = linkifiedTextView;
        this.g = textView;
        this.h = simpleDraweeView2;
        this.i = textView2;
        this.j = textView3;
        this.k = textView4;
        this.l = textView5;
        this.m = imageView;
        this.n = linkifiedTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
