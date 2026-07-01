package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.StreamPreviewView;
import com.discord.views.VoiceUserView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class VoiceUserListItemUserBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2222b;

    @NonNull
    public final TextView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final MaterialButton f;

    @NonNull
    public final VoiceUserView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final StreamPreviewView i;

    @NonNull
    public final ImageView j;

    public VoiceUserListItemUserBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull MaterialButton materialButton, @NonNull VoiceUserView voiceUserView, @NonNull TextView textView2, @NonNull StreamPreviewView streamPreviewView, @NonNull ImageView imageView4) {
        this.a = linearLayout;
        this.f2222b = imageView;
        this.c = textView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = materialButton;
        this.g = voiceUserView;
        this.h = textView2;
        this.i = streamPreviewView;
        this.j = imageView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
