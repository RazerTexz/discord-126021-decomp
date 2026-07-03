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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15136a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final GuildScheduledEventBottomButtonView f15137b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ConstraintLayout f15138c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f15139d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final GuildScheduledEventDateView f15140e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final LinkifiedTextView f15141f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f15142g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final SimpleDraweeView f15143h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final TextView f15144i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final TextView f15145j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final TextView f15146k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final TextView f15147l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final ImageView f15148m;

    /* JADX INFO: renamed from: n */
    @NonNull
    public final LinkifiedTextView f15149n;

    public GuildScheduledEventItemViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull GuildScheduledEventBottomButtonView guildScheduledEventBottomButtonView, @NonNull ConstraintLayout constraintLayout2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull GuildScheduledEventDateView guildScheduledEventDateView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull Barrier barrier, @NonNull ImageView imageView, @NonNull LinkifiedTextView linkifiedTextView2) {
        this.f15136a = constraintLayout;
        this.f15137b = guildScheduledEventBottomButtonView;
        this.f15138c = constraintLayout2;
        this.f15139d = simpleDraweeView;
        this.f15140e = guildScheduledEventDateView;
        this.f15141f = linkifiedTextView;
        this.f15142g = textView;
        this.f15143h = simpleDraweeView2;
        this.f15144i = textView2;
        this.f15145j = textView3;
        this.f15146k = textView4;
        this.f15147l = textView5;
        this.f15148m = imageView;
        this.f15149n = linkifiedTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15136a;
    }
}
