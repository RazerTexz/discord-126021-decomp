package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventBottomButtonView;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventDateView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheetBinding implements ViewBinding {

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildScheduledEventBottomButtonView f2443b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final LinkifiedTextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final SimpleDraweeView f;

    @NonNull
    public final GuildScheduledEventDateView g;

    @NonNull
    public final LinkifiedTextView h;

    @NonNull
    public final SimpleDraweeView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final ImageView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final ConstraintLayout n;

    @NonNull
    public final TextView o;

    @NonNull
    public final ConstraintLayout p;

    @NonNull
    public final ConstraintLayout q;

    @NonNull
    public final RecyclerView r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final ProgressBar f2444s;

    @NonNull
    public final SegmentedControlContainer t;

    @NonNull
    public final CardSegment u;

    @NonNull
    public final CardSegment v;

    public WidgetGuildScheduledEventDetailsBottomSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull GuildScheduledEventBottomButtonView guildScheduledEventBottomButtonView, @NonNull ImageView imageView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull GuildScheduledEventDateView guildScheduledEventDateView, @NonNull LinkifiedTextView linkifiedTextView2, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView2, @NonNull TextView textView4, @NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView3, @NonNull TextView textView5, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull RecyclerView recyclerView, @NonNull ProgressBar progressBar, @NonNull ConstraintLayout constraintLayout4, @NonNull SegmentedControlContainer segmentedControlContainer, @NonNull CardSegment cardSegment, @NonNull CardSegment cardSegment2) {
        this.a = nestedScrollView;
        this.f2443b = guildScheduledEventBottomButtonView;
        this.c = imageView;
        this.d = linkifiedTextView;
        this.e = textView;
        this.f = simpleDraweeView;
        this.g = guildScheduledEventDateView;
        this.h = linkifiedTextView2;
        this.i = simpleDraweeView2;
        this.j = textView2;
        this.k = textView3;
        this.l = imageView2;
        this.m = textView4;
        this.n = constraintLayout;
        this.o = textView5;
        this.p = constraintLayout2;
        this.q = constraintLayout3;
        this.r = recyclerView;
        this.f2444s = progressBar;
        this.t = segmentedControlContainer;
        this.u = cardSegment;
        this.v = cardSegment2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
