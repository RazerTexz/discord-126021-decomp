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

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final DimmerView f2687b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final MaterialButton e;

    @NonNull
    public final PhoneOrEmailInputView f;

    @NonNull
    public final TextView g;

    public WidgetUserPhoneManageBinding(@NonNull FrameLayout frameLayout, @NonNull DimmerView dimmerView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull MaterialButton materialButton, @NonNull PhoneOrEmailInputView phoneOrEmailInputView, @NonNull TextView textView3) {
        this.a = frameLayout;
        this.f2687b = dimmerView;
        this.c = textView;
        this.d = textView2;
        this.e = materialButton;
        this.f = phoneOrEmailInputView;
        this.g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
