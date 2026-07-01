package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import b.a.i.WidgetUserProfileAdapterItemFriendMutualServerBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserProfileAdapterItemFriendBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final WidgetUserProfileAdapterItemFriendMutualServerBinding f2690b;

    @NonNull
    public final WidgetUserProfileAdapterItemFriendMutualServerBinding c;

    @NonNull
    public final WidgetUserProfileAdapterItemFriendMutualServerBinding d;

    @NonNull
    public final WidgetUserProfileAdapterItemFriendMutualServerBinding e;

    @NonNull
    public final SimpleDraweeView f;

    @NonNull
    public final StatusView g;

    @NonNull
    public final SimpleDraweeSpanTextView h;

    @NonNull
    public final TextView i;

    public WidgetUserProfileAdapterItemFriendBinding(@NonNull RelativeLayout relativeLayout, @NonNull WidgetUserProfileAdapterItemFriendMutualServerBinding widgetUserProfileAdapterItemFriendMutualServerBinding, @NonNull WidgetUserProfileAdapterItemFriendMutualServerBinding widgetUserProfileAdapterItemFriendMutualServerBinding2, @NonNull WidgetUserProfileAdapterItemFriendMutualServerBinding widgetUserProfileAdapterItemFriendMutualServerBinding3, @NonNull WidgetUserProfileAdapterItemFriendMutualServerBinding widgetUserProfileAdapterItemFriendMutualServerBinding4, @NonNull SimpleDraweeView simpleDraweeView, @NonNull LinearLayout linearLayout, @NonNull StatusView statusView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull TextView textView) {
        this.a = relativeLayout;
        this.f2690b = widgetUserProfileAdapterItemFriendMutualServerBinding;
        this.c = widgetUserProfileAdapterItemFriendMutualServerBinding2;
        this.d = widgetUserProfileAdapterItemFriendMutualServerBinding3;
        this.e = widgetUserProfileAdapterItemFriendMutualServerBinding4;
        this.f = simpleDraweeView;
        this.g = statusView;
        this.h = simpleDraweeSpanTextView;
        this.i = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
