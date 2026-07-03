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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f16979a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final GuildScheduledEventBottomButtonView f16980b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f16981c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LinkifiedTextView f16982d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16983e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final SimpleDraweeView f16984f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final GuildScheduledEventDateView f16985g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final LinkifiedTextView f16986h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final SimpleDraweeView f16987i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final TextView f16988j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final TextView f16989k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final ImageView f16990l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final TextView f16991m;

    /* JADX INFO: renamed from: n */
    @NonNull
    public final ConstraintLayout f16992n;

    /* JADX INFO: renamed from: o */
    @NonNull
    public final TextView f16993o;

    /* JADX INFO: renamed from: p */
    @NonNull
    public final ConstraintLayout f16994p;

    /* JADX INFO: renamed from: q */
    @NonNull
    public final ConstraintLayout f16995q;

    /* JADX INFO: renamed from: r */
    @NonNull
    public final RecyclerView f16996r;

    /* JADX INFO: renamed from: s */
    @NonNull
    public final ProgressBar f16997s;

    /* JADX INFO: renamed from: t */
    @NonNull
    public final SegmentedControlContainer f16998t;

    /* JADX INFO: renamed from: u */
    @NonNull
    public final CardSegment f16999u;

    /* JADX INFO: renamed from: v */
    @NonNull
    public final CardSegment f17000v;

    public WidgetGuildScheduledEventDetailsBottomSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull GuildScheduledEventBottomButtonView guildScheduledEventBottomButtonView, @NonNull ImageView imageView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull GuildScheduledEventDateView guildScheduledEventDateView, @NonNull LinkifiedTextView linkifiedTextView2, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView2, @NonNull TextView textView4, @NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView3, @NonNull TextView textView5, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull RecyclerView recyclerView, @NonNull ProgressBar progressBar, @NonNull ConstraintLayout constraintLayout4, @NonNull SegmentedControlContainer segmentedControlContainer, @NonNull CardSegment cardSegment, @NonNull CardSegment cardSegment2) {
        this.f16979a = nestedScrollView;
        this.f16980b = guildScheduledEventBottomButtonView;
        this.f16981c = imageView;
        this.f16982d = linkifiedTextView;
        this.f16983e = textView;
        this.f16984f = simpleDraweeView;
        this.f16985g = guildScheduledEventDateView;
        this.f16986h = linkifiedTextView2;
        this.f16987i = simpleDraweeView2;
        this.f16988j = textView2;
        this.f16989k = textView3;
        this.f16990l = imageView2;
        this.f16991m = textView4;
        this.f16992n = constraintLayout;
        this.f16993o = textView5;
        this.f16994p = constraintLayout2;
        this.f16995q = constraintLayout3;
        this.f16996r = recyclerView;
        this.f16997s = progressBar;
        this.f16998t = segmentedControlContainer;
        this.f16999u = cardSegment;
        this.f17000v = cardSegment2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16979a;
    }
}
