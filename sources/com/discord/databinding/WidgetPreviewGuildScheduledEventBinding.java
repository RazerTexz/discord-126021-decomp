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

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2512b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final CheckedSetting d;

    @NonNull
    public final GuildScheduledEventItemView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final MaterialButton i;

    @NonNull
    public final TextView j;

    public WidgetPreviewGuildScheduledEventBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull CheckedSetting checkedSetting, @NonNull GuildScheduledEventItemView guildScheduledEventItemView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView3, @NonNull MaterialButton materialButton, @NonNull TextView textView4) {
        this.a = constraintLayout;
        this.f2512b = imageView;
        this.c = imageView2;
        this.d = checkedSetting;
        this.e = guildScheduledEventItemView;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = materialButton;
        this.j = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
