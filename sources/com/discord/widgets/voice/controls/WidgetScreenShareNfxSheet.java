package com.discord.widgets.voice.controls;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetScreenShareNfxSheetBinding;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.voice.VoiceEngineServiceController;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import com.discord.widgets.voice.stream.StreamNavigator;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetScreenShareNfxSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetScreenShareNfxSheet extends AppBottomSheet {
    private static final String ARG_VOICE_BOTTOM_SHEET_PARAMS = "ARG_VOICE_BOTTOM_SHEET_PARAMS";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetScreenShareNfxSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetScreenShareNfxSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetScreenShareNfxSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, long j, long j2, VoiceBottomSheetParams voiceBottomSheetParams, int i, Object obj) {
            if ((i & 8) != 0) {
                voiceBottomSheetParams = null;
            }
            companion.show(fragmentManager, j, j2, voiceBottomSheetParams);
        }

        public final boolean canShow() {
            return !SharedPreferencesProvider.INSTANCE.get().getBoolean("CACHE_KEY_SCREEN_SHARE_NFX_SHEET_SHOWN", false);
        }

        public final void show(FragmentManager fragmentManager, long channelId, long guildId, VoiceBottomSheetParams voiceBottomSheetParams) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetScreenShareNfxSheet widgetScreenShareNfxSheet = new WidgetScreenShareNfxSheet();
            Bundle bundleM832T = C1643a.m832T("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            bundleM832T.putSerializable(WidgetScreenShareNfxSheet.ARG_VOICE_BOTTOM_SHEET_PARAMS, voiceBottomSheetParams);
            widgetScreenShareNfxSheet.setArguments(bundleM832T);
            widgetScreenShareNfxSheet.show(fragmentManager, WidgetScreenShareNfxSheet.class.getName());
            SharedPreferences.Editor editorEdit = SharedPreferencesProvider.INSTANCE.get().edit();
            C12238m.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.putBoolean("CACHE_KEY_SCREEN_SHARE_NFX_SHEET_SHOWN", true);
            editorEdit.apply();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetScreenShareNfxSheet.kt */
    public static final /* data */ class VoiceBottomSheetParams implements Serializable {
        private final WidgetVoiceBottomSheet.FeatureContext featureContext;
        private final boolean forwardToFullscreenIfVideoActivated;

        public VoiceBottomSheetParams(boolean z2, WidgetVoiceBottomSheet.FeatureContext featureContext) {
            C12238m.checkNotNullParameter(featureContext, "featureContext");
            this.forwardToFullscreenIfVideoActivated = z2;
            this.featureContext = featureContext;
        }

        public static /* synthetic */ VoiceBottomSheetParams copy$default(VoiceBottomSheetParams voiceBottomSheetParams, boolean z2, WidgetVoiceBottomSheet.FeatureContext featureContext, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = voiceBottomSheetParams.forwardToFullscreenIfVideoActivated;
            }
            if ((i & 2) != 0) {
                featureContext = voiceBottomSheetParams.featureContext;
            }
            return voiceBottomSheetParams.copy(z2, featureContext);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getForwardToFullscreenIfVideoActivated() {
            return this.forwardToFullscreenIfVideoActivated;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final WidgetVoiceBottomSheet.FeatureContext getFeatureContext() {
            return this.featureContext;
        }

        public final VoiceBottomSheetParams copy(boolean forwardToFullscreenIfVideoActivated, WidgetVoiceBottomSheet.FeatureContext featureContext) {
            C12238m.checkNotNullParameter(featureContext, "featureContext");
            return new VoiceBottomSheetParams(forwardToFullscreenIfVideoActivated, featureContext);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VoiceBottomSheetParams)) {
                return false;
            }
            VoiceBottomSheetParams voiceBottomSheetParams = (VoiceBottomSheetParams) other;
            return this.forwardToFullscreenIfVideoActivated == voiceBottomSheetParams.forwardToFullscreenIfVideoActivated && C12238m.areEqual(this.featureContext, voiceBottomSheetParams.featureContext);
        }

        public final WidgetVoiceBottomSheet.FeatureContext getFeatureContext() {
            return this.featureContext;
        }

        public final boolean getForwardToFullscreenIfVideoActivated() {
            return this.forwardToFullscreenIfVideoActivated;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z2 = this.forwardToFullscreenIfVideoActivated;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            WidgetVoiceBottomSheet.FeatureContext featureContext = this.featureContext;
            return i + (featureContext != null ? featureContext.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("VoiceBottomSheetParams(forwardToFullscreenIfVideoActivated=");
            sbM833U.append(this.forwardToFullscreenIfVideoActivated);
            sbM833U.append(", featureContext=");
            sbM833U.append(this.featureContext);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.controls.WidgetScreenShareNfxSheet$onActivityResult$1 */
    /* JADX INFO: compiled from: WidgetScreenShareNfxSheet.kt */
    public static final class C104441 extends AbstractC12240o implements Function1<Intent, Unit> {
        public C104441() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
            invoke2(intent);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Intent intent) {
            C12238m.checkNotNullParameter(intent, "it");
            VoiceEngineServiceController.INSTANCE.getINSTANCE().startStream(intent);
            if (!WidgetScreenShareNfxSheet.this.requireAppActivity().m8348h(C12216a0.getOrCreateKotlinClass(WidgetCallFullscreen.class))) {
                WidgetCallFullscreen.Companion companion = WidgetCallFullscreen.INSTANCE;
                Context contextRequireContext = WidgetScreenShareNfxSheet.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                WidgetCallFullscreen.Companion.launch$default(companion, contextRequireContext, WidgetScreenShareNfxSheet.this.requireArguments().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID"), false, null, null, 28, null);
            }
            WidgetScreenShareNfxSheet.this.dismiss();
        }
    }

    public WidgetScreenShareNfxSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetScreenShareNfxSheet$binding$2.INSTANCE, null, 2, null);
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

    private final VoiceBottomSheetParams getVoiceBottomSheetParams() {
        return (VoiceBottomSheetParams) requireArguments().getSerializable(ARG_VOICE_BOTTOM_SHEET_PARAMS);
    }

    private final void maybeNavigateToVoiceBottomSheet() {
        VoiceBottomSheetParams voiceBottomSheetParams = getVoiceBottomSheetParams();
        if (voiceBottomSheetParams != null) {
            if (TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(getGuildId()))) {
                WidgetCallPreviewFullscreen.Companion companion = WidgetCallPreviewFullscreen.INSTANCE;
                Context contextRequireContext = requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.launch(contextRequireContext, getChannelId(), AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE);
                return;
            }
            WidgetVoiceBottomSheet.Companion companion2 = WidgetVoiceBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion2.show(parentFragmentManager, getChannelId(), voiceBottomSheetParams.getForwardToFullscreenIfVideoActivated(), voiceBottomSheetParams.getFeatureContext());
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_screen_share_nfx_sheet;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        StreamNavigator.handleActivityResult(requestCode, resultCode, intent, new C104441());
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        C12238m.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        maybeNavigateToVoiceBottomSheet();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f17418c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.WidgetScreenShareNfxSheet.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StreamNavigator.requestStartStream(WidgetScreenShareNfxSheet.this);
            }
        });
        getBinding().f17417b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.controls.WidgetScreenShareNfxSheet.onViewCreated.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetScreenShareNfxSheet.this.dismiss();
                WidgetScreenShareNfxSheet.this.maybeNavigateToVoiceBottomSheet();
            }
        });
    }
}
