package com.discord.widgets.voice.sheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetVoiceSettingsBottomSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheet extends AppBottomSheet {
    private static final String ANALYTICS_SOURCE = "Voice Call";
    private static final String ARG_CHANNEL_ID = "ARG_CHANNEL_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetVoiceSettingsBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceSettingsBottomSheetBinding;", 0)};
    public static final WidgetVoiceSettingsBottomSheet$Companion Companion = new WidgetVoiceSettingsBottomSheet$Companion(null);

    public WidgetVoiceSettingsBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetVoiceSettingsBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.channelId = g.lazy(new WidgetVoiceSettingsBottomSheet$channelId$2(this));
        WidgetVoiceSettingsBottomSheet$viewModel$2 widgetVoiceSettingsBottomSheet$viewModel$2 = new WidgetVoiceSettingsBottomSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetVoiceSettingsBottomSheetViewModel.class), new WidgetVoiceSettingsBottomSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetVoiceSettingsBottomSheet$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet, WidgetVoiceSettingsBottomSheet$ViewState widgetVoiceSettingsBottomSheet$ViewState) {
        widgetVoiceSettingsBottomSheet.configureUI(widgetVoiceSettingsBottomSheet$ViewState);
    }

    public static final /* synthetic */ WidgetVoiceSettingsBottomSheetBinding access$getBinding$p(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet) {
        return widgetVoiceSettingsBottomSheet.getBinding();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet) {
        return widgetVoiceSettingsBottomSheet.getChannelId();
    }

    public static final /* synthetic */ WidgetVoiceSettingsBottomSheetViewModel access$getViewModel$p(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet) {
        return widgetVoiceSettingsBottomSheet.getViewModel();
    }

    private final void configureUI(WidgetVoiceSettingsBottomSheet$ViewState viewState) {
        Guild guild;
        getBinding().c.setOnClickListener(new WidgetVoiceSettingsBottomSheet$configureUI$1(this, viewState));
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.voiceSettingsInvite");
        textView.setVisibility(viewState.getShowInviteItem() ? 0 : 8);
        getBinding().h.setOnClickListener(new WidgetVoiceSettingsBottomSheet$configureUI$2(this));
        SwitchMaterial switchMaterial = getBinding().h;
        m.checkNotNullExpressionValue(switchMaterial, "binding.voiceSettingsToggleVideoParticipants");
        switchMaterial.setChecked(viewState.getShowVoiceParticipants());
        SwitchMaterial switchMaterial2 = getBinding().h;
        m.checkNotNullExpressionValue(switchMaterial2, "binding.voiceSettingsToggleVideoParticipants");
        switchMaterial2.setVisibility(viewState.getShowVoiceParticipantsToggle() ? 0 : 8);
        TextView textView2 = getBinding().g;
        m.checkNotNullExpressionValue(textView2, "binding.voiceSettingsStageSettings");
        textView2.setVisibility(viewState.getShowStageSettings() ? 0 : 8);
        getBinding().g.setOnClickListener(new WidgetVoiceSettingsBottomSheet$configureUI$3(this));
        TextView textView3 = getBinding().f2705b;
        m.checkNotNullExpressionValue(textView3, "binding.voiceSettingsEvents");
        textView3.setVisibility(ChannelUtils.w(viewState.getChannel()) ? 0 : 8);
        getBinding().f2705b.setOnClickListener(new WidgetVoiceSettingsBottomSheet$configureUI$4(this, viewState));
        getBinding().i.setOnClickListener(new WidgetVoiceSettingsBottomSheet$configureUI$5(this));
        TextView textView4 = getBinding().e;
        textView4.setVisibility(ChannelUtils.D(viewState.getChannel()) && (guild = viewState.getGuild()) != null && guild.hasFeature(GuildFeature.COMMUNITY) ? 0 : 8);
        textView4.setOnClickListener(new WidgetVoiceSettingsBottomSheet$configureUI$$inlined$apply$lambda$1(this, viewState));
        getBinding().d.setOnClickListener(new WidgetVoiceSettingsBottomSheet$configureUI$7(this));
        SwitchMaterial switchMaterial3 = getBinding().d;
        m.checkNotNullExpressionValue(switchMaterial3, "binding.voiceSettingsNoiseSuppression");
        switchMaterial3.setChecked(viewState.getNoiseCancellationEnabled());
        TextView textView5 = getBinding().f;
        m.checkNotNullExpressionValue(textView5, "binding.voiceSettingsReport");
        textView5.setVisibility(viewState.getShowReportItem() ? 0 : 8);
        getBinding().f.setOnClickListener(new WidgetVoiceSettingsBottomSheet$configureUI$8(this, viewState));
    }

    private final WidgetVoiceSettingsBottomSheetBinding getBinding() {
        return (WidgetVoiceSettingsBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final WidgetVoiceSettingsBottomSheetViewModel getViewModel() {
        return (WidgetVoiceSettingsBottomSheetViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_voice_settings_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetVoiceSettingsBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetVoiceSettingsBottomSheet$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetState(3);
    }
}
