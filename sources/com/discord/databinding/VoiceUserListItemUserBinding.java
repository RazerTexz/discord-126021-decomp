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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15624a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15625b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15626c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f15627d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f15628e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialButton f15629f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final VoiceUserView f15630g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f15631h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final StreamPreviewView f15632i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final ImageView f15633j;

    public VoiceUserListItemUserBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull MaterialButton materialButton, @NonNull VoiceUserView voiceUserView, @NonNull TextView textView2, @NonNull StreamPreviewView streamPreviewView, @NonNull ImageView imageView4) {
        this.f15624a = linearLayout;
        this.f15625b = imageView;
        this.f15626c = textView;
        this.f15627d = imageView2;
        this.f15628e = imageView3;
        this.f15629f = materialButton;
        this.f15630g = voiceUserView;
        this.f15631h = textView2;
        this.f15632i = streamPreviewView;
        this.f15633j = imageView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15624a;
    }
}
