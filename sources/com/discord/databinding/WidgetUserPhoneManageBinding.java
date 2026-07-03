package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneManageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f18348a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final DimmerView f18349b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f18350c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f18351d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialButton f18352e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final PhoneOrEmailInputView f18353f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f18354g;

    public WidgetUserPhoneManageBinding(@NonNull FrameLayout frameLayout, @NonNull DimmerView dimmerView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull MaterialButton materialButton, @NonNull PhoneOrEmailInputView phoneOrEmailInputView, @NonNull TextView textView3) {
        this.f18348a = frameLayout;
        this.f18349b = dimmerView;
        this.f18350c = textView;
        this.f18351d = textView2;
        this.f18352e = materialButton;
        this.f18353f = phoneOrEmailInputView;
        this.f18354g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18348a;
    }
}
