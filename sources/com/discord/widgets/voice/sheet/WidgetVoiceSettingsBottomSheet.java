package com.discord.widgets.voice.sheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetVoiceSettingsBottomSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import com.discord.widgets.settings.WidgetSettingsVoice;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet;
import com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheetViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetVoiceSettingsBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceSettingsBottomSheetBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
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

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetVoiceSettingsBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceSettingsBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetVoiceSettingsBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetVoiceSettingsBottomSheet.this.configureUI(viewState);
        }
    }

    public WidgetVoiceSettingsBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetVoiceSettingsBottomSheet2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetVoiceSettingsBottomSheet3(this));
        WidgetVoiceSettingsBottomSheet5 widgetVoiceSettingsBottomSheet5 = new WidgetVoiceSettingsBottomSheet5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetVoiceSettingsBottomSheetViewModel.class), new WidgetVoiceSettingsBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetVoiceSettingsBottomSheet5));
    }

    private final void configureUI(final ViewState viewState) {
        Guild guild;
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceSettingsBottomSheet.this.dismiss();
                ChannelInviteLaunchUtils.INSTANCE.inviteToChannel(WidgetVoiceSettingsBottomSheet.this, viewState.getChannel(), WidgetVoiceSettingsBottomSheet.ANALYTICS_SOURCE, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null);
            }
        });
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.voiceSettingsInvite");
        textView.setVisibility(viewState.getShowInviteItem() ? 0 : 8);
        getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceSettingsBottomSheet.this.getViewModel().onToggleVoiceParticipantsHidden();
            }
        });
        SwitchMaterial switchMaterial = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial, "binding.voiceSettingsToggleVideoParticipants");
        switchMaterial.setChecked(viewState.getShowVoiceParticipants());
        SwitchMaterial switchMaterial2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial2, "binding.voiceSettingsToggleVideoParticipants");
        switchMaterial2.setVisibility(viewState.getShowVoiceParticipantsToggle() ? 0 : 8);
        TextView textView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.voiceSettingsStageSettings");
        textView2.setVisibility(viewState.getShowStageSettings() ? 0 : 8);
        getBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceSettingsBottomSheet.this.dismiss();
                WidgetStageStartEventBottomSheet.Companion companion = WidgetStageStartEventBottomSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetVoiceSettingsBottomSheet.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                WidgetStageStartEventBottomSheet.Companion.show$default(companion, parentFragmentManager, WidgetVoiceSettingsBottomSheet.this.getChannelId(), null, 4, null);
            }
        });
        TextView textView3 = getBinding().f2705b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.voiceSettingsEvents");
        textView3.setVisibility(ChannelUtils.w(viewState.getChannel()) ? 0 : 8);
        getBinding().f2705b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceSettingsBottomSheet.this.dismiss();
                WidgetGuildScheduledEventListBottomSheet.Companion companion = WidgetGuildScheduledEventListBottomSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetVoiceSettingsBottomSheet.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, viewState.getChannel().getGuildId(), Long.valueOf(viewState.getChannel().getId()));
            }
        });
        getBinding().i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceSettingsBottomSheet.this.dismiss();
                WidgetSettingsVoice.Companion companion = WidgetSettingsVoice.INSTANCE;
                TextView textView4 = WidgetVoiceSettingsBottomSheet.this.getBinding().i;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.voiceSettingsVoiceSettings");
                Context context = textView4.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.voiceSettingsVoiceSettings.context");
                WidgetSettingsVoice.Companion.launch$default(companion, context, null, false, 6, null);
            }
        });
        TextView textView4 = getBinding().e;
        textView4.setVisibility(ChannelUtils.D(viewState.getChannel()) && (guild = viewState.getGuild()) != null && guild.hasFeature(GuildFeature.COMMUNITY) ? 0 : 8);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelNotificationSettings.Companion.launch$default(WidgetChannelNotificationSettings.INSTANCE, outline.x(view, "it", "it.context"), this.this$0.getChannelId(), false, 4, null);
            }
        });
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.configureUI.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceSettingsBottomSheet.this.getViewModel().onToggleNoiseCancellation();
            }
        });
        SwitchMaterial switchMaterial3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial3, "binding.voiceSettingsNoiseSuppression");
        switchMaterial3.setChecked(viewState.getNoiseCancellationEnabled());
        TextView textView5 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.voiceSettingsReport");
        textView5.setVisibility(viewState.getShowReportItem() ? 0 : 8);
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet.configureUI.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetMobileReports.Companion companion = WidgetMobileReports.INSTANCE;
                Context contextRequireContext = WidgetVoiceSettingsBottomSheet.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
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
        return R.layout.widget_voice_settings_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetVoiceSettingsBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetState(3);
    }
}
