package com.discord.widgets.channels;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChannelOnboardingBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetChannelOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelOnboarding extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelOnboarding.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelOnboardingBinding;", 0)};
    public static final WidgetChannelOnboarding$Companion Companion = new WidgetChannelOnboarding$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetChannelOnboarding() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelOnboarding$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetChannelOnboardingBinding getBinding() {
        return (WidgetChannelOnboardingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_channel_onboarding;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        new ChannelOnboardingManager().markSeenUserChannelOnboarding();
        getBinding().f2263b.setOnClickListener(new WidgetChannelOnboarding$onViewCreated$1(this));
    }
}
