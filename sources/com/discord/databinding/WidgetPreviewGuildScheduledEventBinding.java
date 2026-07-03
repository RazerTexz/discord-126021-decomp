package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetPreviewGuildScheduledEventBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f17374a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f17375b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f17376c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final CheckedSetting f17377d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final GuildScheduledEventItemView f17378e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f17379f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f17380g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f17381h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final MaterialButton f17382i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final TextView f17383j;

    public WidgetPreviewGuildScheduledEventBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull CheckedSetting checkedSetting, @NonNull GuildScheduledEventItemView guildScheduledEventItemView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView3, @NonNull MaterialButton materialButton, @NonNull TextView textView4) {
        this.f17374a = constraintLayout;
        this.f17375b = imageView;
        this.f17376c = imageView2;
        this.f17377d = checkedSetting;
        this.f17378e = guildScheduledEventItemView;
        this.f17379f = textView;
        this.f17380g = textView2;
        this.f17381h = textView3;
        this.f17382i = materialButton;
        this.f17383j = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17374a;
    }
}
