package com.discord.widgets.voice.controls;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppTransitionActivity$Transition;
import com.discord.databinding.WidgetScreenShareNfxSheetBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$Companion;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$Companion;
import com.discord.widgets.voice.stream.StreamNavigator;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetScreenShareNfxSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetScreenShareNfxSheet extends AppBottomSheet {
    private static final String ARG_VOICE_BOTTOM_SHEET_PARAMS = "ARG_VOICE_BOTTOM_SHEET_PARAMS";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetScreenShareNfxSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetScreenShareNfxSheetBinding;", 0)};
    public static final WidgetScreenShareNfxSheet$Companion Companion = new WidgetScreenShareNfxSheet$Companion(null);

    public WidgetScreenShareNfxSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetScreenShareNfxSheet$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$maybeNavigateToVoiceBottomSheet(WidgetScreenShareNfxSheet widgetScreenShareNfxSheet) {
        widgetScreenShareNfxSheet.maybeNavigateToVoiceBottomSheet();
    }

    private final WidgetScreenShareNfxSheetBinding getBinding() {
        return (WidgetScreenShareNfxSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return requireArguments().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID");
    }

    private final long getGuildId() {
        return requireArguments().getLong("com.discord.intent.extra.EXTRA_GUILD_ID");
    }

    private final WidgetScreenShareNfxSheet$VoiceBottomSheetParams getVoiceBottomSheetParams() {
        return (WidgetScreenShareNfxSheet$VoiceBottomSheetParams) requireArguments().getSerializable(ARG_VOICE_BOTTOM_SHEET_PARAMS);
    }

    private final void maybeNavigateToVoiceBottomSheet() {
        WidgetScreenShareNfxSheet$VoiceBottomSheetParams voiceBottomSheetParams = getVoiceBottomSheetParams();
        if (voiceBottomSheetParams != null) {
            if (TextInVoiceFeatureFlag.Companion.getINSTANCE().isEnabled(Long.valueOf(getGuildId()))) {
                WidgetCallPreviewFullscreen$Companion widgetCallPreviewFullscreen$Companion = WidgetCallPreviewFullscreen.Companion;
                Context contextRequireContext = requireContext();
                m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                widgetCallPreviewFullscreen$Companion.launch(contextRequireContext, getChannelId(), AppTransitionActivity$Transition.TYPE_SLIDE_VERTICAL_WITH_FADE);
                return;
            }
            WidgetVoiceBottomSheet$Companion widgetVoiceBottomSheet$Companion = WidgetVoiceBottomSheet.Companion;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            widgetVoiceBottomSheet$Companion.show(parentFragmentManager, getChannelId(), voiceBottomSheetParams.getForwardToFullscreenIfVideoActivated(), voiceBottomSheetParams.getFeatureContext());
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_screen_share_nfx_sheet;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        StreamNavigator.handleActivityResult(requestCode, resultCode, intent, new WidgetScreenShareNfxSheet$onActivityResult$1(this));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnCancelListener
    public void onCancel(DialogInterface dialog) {
        m.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        maybeNavigateToVoiceBottomSheet();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().c.setOnClickListener(new WidgetScreenShareNfxSheet$onViewCreated$1(this));
        getBinding().f2521b.setOnClickListener(new WidgetScreenShareNfxSheet$onViewCreated$2(this));
    }
}
