package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.typing.TypingDots;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import p007b.p008a.p025i.C1084x4;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatOverlayBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16362a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final FloatingActionButton f16363b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RelativeLayout f16364c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TypingDots f16365d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16366e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ImageView f16367f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f16368g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final C1084x4 f16369h;

    public WidgetChatOverlayBinding(@NonNull ConstraintLayout constraintLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull RelativeLayout relativeLayout, @NonNull TypingDots typingDots, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull C1084x4 c1084x4) {
        this.f16362a = constraintLayout;
        this.f16363b = floatingActionButton;
        this.f16364c = relativeLayout;
        this.f16365d = typingDots;
        this.f16366e = textView;
        this.f16367f = imageView;
        this.f16368g = textView2;
        this.f16369h = c1084x4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16362a;
    }
}
