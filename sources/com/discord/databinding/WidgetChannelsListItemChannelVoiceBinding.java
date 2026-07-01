package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.VoiceUserLimitView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelsListItemChannelVoiceBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2290b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final VoiceUserLimitView h;

    public WidgetChannelsListItemChannelVoiceBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull TextView textView3, @NonNull ImageView imageView3, @NonNull VoiceUserLimitView voiceUserLimitView, @NonNull LinearLayout linearLayout) {
        this.a = constraintLayout;
        this.f2290b = textView;
        this.c = imageView;
        this.d = textView2;
        this.e = imageView2;
        this.f = textView3;
        this.g = imageView3;
        this.h = voiceUserLimitView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
