package com.discord.widgets.channels;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetTextInVoiceOnboardingBinding;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextInVoiceOnboarding extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetTextInVoiceOnboarding.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTextInVoiceOnboardingBinding;", 0)};
    public static final WidgetTextInVoiceOnboarding$Companion Companion = new WidgetTextInVoiceOnboarding$Companion(null);
    public static final String VIDEO_URL = "https://cdn.discordapp.com/attachments/727325253608538113/942859496601043024/Text_in_Voice_NUX_Mobile_In-App.mp4";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function0<Unit> onCtaClicked;

    public WidgetTextInVoiceOnboarding() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetTextInVoiceOnboarding$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ WidgetTextInVoiceOnboardingBinding access$getBinding$p(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding) {
        return widgetTextInVoiceOnboarding.getBinding();
    }

    public static final /* synthetic */ Function0 access$getOnCtaClicked$p(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding) {
        return widgetTextInVoiceOnboarding.onCtaClicked;
    }

    public static final /* synthetic */ void access$hideVideoOverlay(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding) {
        widgetTextInVoiceOnboarding.hideVideoOverlay();
    }

    public static final /* synthetic */ void access$setOnCtaClicked$p(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding, Function0 function0) {
        widgetTextInVoiceOnboarding.onCtaClicked = function0;
    }

    public static final /* synthetic */ void access$showVideoOverlay(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding) {
        widgetTextInVoiceOnboarding.showVideoOverlay();
    }

    private final void configureMedia(String videoUrl) {
        View view = getView();
        if (view != null) {
            view.post(new WidgetTextInVoiceOnboarding$configureMedia$1(this));
        }
        FrameLayout frameLayout = getBinding().e;
        m.checkNotNullExpressionValue(frameLayout, "binding.textInVoiceOnboardingVideoContainer");
        frameLayout.setClipToOutline(true);
        getBinding().d.setVideoPath(videoUrl);
        hideVideoOverlay();
        getBinding().d.setOnClickListener(new WidgetTextInVoiceOnboarding$configureMedia$2(this));
        getBinding().d.setOnPreparedListener(new WidgetTextInVoiceOnboarding$configureMedia$3(this));
        getBinding().d.setOnInfoListener(new WidgetTextInVoiceOnboarding$configureMedia$4(this));
    }

    private final WidgetTextInVoiceOnboardingBinding getBinding() {
        return (WidgetTextInVoiceOnboardingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void hideVideoOverlay() {
        ViewExtensions.fadeOut$default(getBinding().f, 200L, WidgetTextInVoiceOnboarding$hideVideoOverlay$1.INSTANCE, null, 4, null);
    }

    private final void showVideoOverlay() {
        ViewExtensions.fadeIn$default(getBinding().f, 200L, WidgetTextInVoiceOnboarding$showVideoOverlay$1.INSTANCE, WidgetTextInVoiceOnboarding$showVideoOverlay$2.INSTANCE, null, 8, null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_text_in_voice_onboarding;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        new TextInVoiceOnboardingManager().markSeen();
        getBinding().f2666b.setOnClickListener(new WidgetTextInVoiceOnboarding$onViewCreated$1(this));
        getBinding().c.setOnClickListener(new WidgetTextInVoiceOnboarding$onViewCreated$2(this));
        configureMedia(VIDEO_URL);
    }
}
