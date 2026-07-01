package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import b.a.i.WidgetDiscordHubEmailInputBinding;
import b.a.i.WidgetHubEmailFlowConfirmationBinding;
import b.a.i.WidgetHubEmailFlowWaitlistBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetHubEmailFlowBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final WidgetHubEmailFlowConfirmationBinding f2473b;

    @NonNull
    public final WidgetDiscordHubEmailInputBinding c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final LoadingButton e;

    @NonNull
    public final WidgetHubEmailFlowWaitlistBinding f;

    public WidgetHubEmailFlowBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull WidgetHubEmailFlowConfirmationBinding widgetHubEmailFlowConfirmationBinding, @NonNull WidgetDiscordHubEmailInputBinding widgetDiscordHubEmailInputBinding, @NonNull MaterialButton materialButton, @NonNull LoadingButton loadingButton, @NonNull WidgetHubEmailFlowWaitlistBinding widgetHubEmailFlowWaitlistBinding) {
        this.a = linearLayout;
        this.f2473b = widgetHubEmailFlowConfirmationBinding;
        this.c = widgetDiscordHubEmailInputBinding;
        this.d = materialButton;
        this.e = loadingButton;
        this.f = widgetHubEmailFlowWaitlistBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
