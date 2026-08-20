package com.discord.widgets.voice.sheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetVoiceSettingsBottomSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import com.discord.widgets.settings.WidgetSettingsVoice;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet;
import com.google.android.material.switchmaterial.SwitchMaterial;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetVoiceSettingsBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceSettingsBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, Long l, FragmentManager fragmentManager, int i, Object obj) {
            if ((i & 1) != 0) {
                l = null;
            }
            companion.show(l, fragmentManager);
        }

        public final void show(Long channelId, FragmentManager fragmentManager) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet = new WidgetVoiceSettingsBottomSheet();
            Bundle bundle = new Bundle();
            if (channelId != null) {
                bundle.putLong(WidgetVoiceSettingsBottomSheet.ARG_CHANNEL_ID, channelId.longValue());
            }
            widgetVoiceSettingsBottomSheet.setArguments(bundle);
            widgetVoiceSettingsBottomSheet.show(fragmentManager, WidgetVoiceSettingsBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheet.kt */
    public interface ViewState {
        Channel getChannel();

        Guild getGuild();

        boolean getNoiseCancellationEnabled();

        boolean getShowInviteItem();

        boolean getShowReportItem();

        boolean getShowStageSettings();

        boolean getShowVoiceParticipants();

        boolean getShowVoiceParticipantsToggle();
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheet.kt */
    public static final class C106141 extends AbstractC12240o implements Function1<WidgetVoiceSettingsBottomSheetViewModel.ViewState, Unit> {
        public C106141() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceSettingsBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetVoiceSettingsBottomSheetViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetVoiceSettingsBottomSheet.this.configureUI(viewState);
        }
    }

    public WidgetVoiceSettingsBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetVoiceSettingsBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.channelId = C12083g.lazy(new WidgetVoiceSettingsBottomSheet$channelId$2(this));
        WidgetVoiceSettingsBottomSheet$viewModel$2 widgetVoiceSettingsBottomSheet$viewModel$2 = new WidgetVoiceSettingsBottomSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetVoiceSettingsBottomSheetViewModel.class), new C10605x247211e4(c0865g0), new C0869i0(widgetVoiceSettingsBottomSheet$viewModel$2));
    }

    private final void configureUI(final ViewState viewState) {
        Guild guild;
        getBinding().f18484c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceSettingsBottomSheet.this.dismiss();
                ChannelInviteLaunchUtils.INSTANCE.inviteToChannel(WidgetVoiceSettingsBottomSheet.this, viewState.getChannel(), WidgetVoiceSettingsBottomSheet.ANALYTICS_SOURCE, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null);
            }
        });
        TextView textView = getBinding().f18484c;
        C12238m.checkNotNullExpressionValue(textView, "binding.voiceSettingsInvite");
        textView.setVisibility(viewState.getShowInviteItem() ? 0 : 8);
        getBinding().f18489h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceSettingsBottomSheet.this.getViewModel().onToggleVoiceParticipantsHidden();
            }
        });
        SwitchMaterial switchMaterial = getBinding().f18489h;
        C12238m.checkNotNullExpressionValue(switchMaterial, "binding.voiceSettingsToggleVideoParticipants");
        switchMaterial.setChecked(viewState.getShowVoiceParticipants());
        SwitchMaterial switchMaterial2 = getBinding().f18489h;
        C12238m.checkNotNullExpressionValue(switchMaterial2, "binding.voiceSettingsToggleVideoParticipants");
        switchMaterial2.setVisibility(viewState.getShowVoiceParticipantsToggle() ? 0 : 8);
        TextView textView2 = getBinding().f18488g;
        C12238m.checkNotNullExpressionValue(textView2, "binding.voiceSettingsStageSettings");
        textView2.setVisibility(viewState.getShowStageSettings() ? 0 : 8);
        getBinding().f18488g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceSettingsBottomSheet.this.dismiss();
                WidgetStageStartEventBottomSheet.Companion companion = WidgetStageStartEventBottomSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetVoiceSettingsBottomSheet.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                WidgetStageStartEventBottomSheet.Companion.show$default(companion, parentFragmentManager, WidgetVoiceSettingsBottomSheet.this.getChannelId(), null, 4, null);
            }
        });
        TextView textView3 = getBinding().f18483b;
        C12238m.checkNotNullExpressionValue(textView3, "binding.voiceSettingsEvents");
        textView3.setVisibility(ChannelUtils.m7699w(viewState.getChannel()) ? 0 : 8);
        getBinding().f18483b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceSettingsBottomSheet.this.dismiss();
                WidgetGuildScheduledEventListBottomSheet.Companion companion = WidgetGuildScheduledEventListBottomSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetVoiceSettingsBottomSheet.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, viewState.getChannel().getGuildId(), Long.valueOf(viewState.getChannel().getId()));
            }
        });
        getBinding().f18490i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceSettingsBottomSheet.this.dismiss();
                WidgetSettingsVoice.Companion companion = WidgetSettingsVoice.INSTANCE;
                TextView textView4 = WidgetVoiceSettingsBottomSheet.this.getBinding().f18490i;
                C12238m.checkNotNullExpressionValue(textView4, "binding.voiceSettingsVoiceSettings");
                Context context = textView4.getContext();
                C12238m.checkNotNullExpressionValue(context, "binding.voiceSettingsVoiceSettings.context");
                WidgetSettingsVoice.Companion.launch$default(companion, context, null, false, 6, null);
            }
        });
        TextView textView4 = getBinding().f18486e;
        textView4.setVisibility(ChannelUtils.m7669D(viewState.getChannel()) && (guild = viewState.getGuild()) != null && guild.hasFeature(GuildFeature.COMMUNITY) ? 0 : 8);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelNotificationSettings.Companion.launch$default(WidgetChannelNotificationSettings.INSTANCE, C1643a.m885x(view, "it", "it.context"), this.this$0.getChannelId(), false, 4, null);
            }
        });
        getBinding().f18485d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.configureUI.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceSettingsBottomSheet.this.getViewModel().onToggleNoiseCancellation();
            }
        });
        SwitchMaterial switchMaterial3 = getBinding().f18485d;
        C12238m.checkNotNullExpressionValue(switchMaterial3, "binding.voiceSettingsNoiseSuppression");
        switchMaterial3.setChecked(viewState.getNoiseCancellationEnabled());
        TextView textView5 = getBinding().f18487f;
        C12238m.checkNotNullExpressionValue(textView5, "binding.voiceSettingsReport");
        textView5.setVisibility(viewState.getShowReportItem() ? 0 : 8);
        getBinding().f18487f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.configureUI.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetMobileReports.Companion companion = WidgetMobileReports.INSTANCE;
                Context contextRequireContext = WidgetVoiceSettingsBottomSheet.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.launchStageChannelReport(contextRequireContext, viewState.getChannel().getId());
            }
        });
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
        return C5419R.layout.widget_voice_settings_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetVoiceSettingsBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C106141());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetState(3);
    }
}
