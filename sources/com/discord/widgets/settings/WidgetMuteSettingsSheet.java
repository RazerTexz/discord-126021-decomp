package com.discord.widgets.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetMuteSettingsSheetBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.settings.MuteSettingsSheetViewModel;
import d0.z.d.FunctionReferenceImpl;
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
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMuteSettingsSheet extends AppBottomSheet {
    private static final float ACTIVE_OPACITY = 1.0f;
    private static final String ARG_CHANNEL_ID = "ARG_CHANNEL_ID";
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
    private static final float INACTIVE_OPACITY = 0.2f;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetMuteSettingsSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMuteSettingsSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void showForChannel(long channelId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetMuteSettingsSheet widgetMuteSettingsSheet = new WidgetMuteSettingsSheet();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetMuteSettingsSheet.ARG_CHANNEL_ID, channelId);
            widgetMuteSettingsSheet.setArguments(bundle);
            widgetMuteSettingsSheet.show(fragmentManager, WidgetMuteSettingsSheet.class.getName());
        }

        public final void showForGuild(long guildId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetMuteSettingsSheet widgetMuteSettingsSheet = new WidgetMuteSettingsSheet();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetMuteSettingsSheet.ARG_GUILD_ID, guildId);
            widgetMuteSettingsSheet.setArguments(bundle);
            widgetMuteSettingsSheet.show(fragmentManager, WidgetMuteSettingsSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            MuteSettingsSheetViewModel.SettingsType.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            MuteSettingsSheetViewModel.SettingsType settingsType = MuteSettingsSheetViewModel.SettingsType.GUILD;
            iArr[settingsType.ordinal()] = 1;
            MuteSettingsSheetViewModel.SettingsType settingsType2 = MuteSettingsSheetViewModel.SettingsType.DM;
            iArr[settingsType2.ordinal()] = 2;
            MuteSettingsSheetViewModel.SettingsType settingsType3 = MuteSettingsSheetViewModel.SettingsType.GROUP_DM;
            iArr[settingsType3.ordinal()] = 3;
            iArr[MuteSettingsSheetViewModel.SettingsType.GUILD_CHANNEL.ordinal()] = 4;
            iArr[MuteSettingsSheetViewModel.SettingsType.THREAD.ordinal()] = 5;
            MuteSettingsSheetViewModel.SettingsType settingsType4 = MuteSettingsSheetViewModel.SettingsType.CATEGORY;
            iArr[settingsType4.ordinal()] = 6;
            MuteSettingsSheetViewModel.SettingsType.values();
            int[] iArr2 = new int[7];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[settingsType3.ordinal()] = 1;
            iArr2[settingsType2.ordinal()] = 2;
            MuteSettingsSheetViewModel.SettingsType.values();
            int[] iArr3 = new int[7];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[settingsType2.ordinal()] = 1;
            iArr3[settingsType3.ordinal()] = 2;
            iArr3[settingsType.ordinal()] = 3;
            iArr3[settingsType4.ordinal()] = 4;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$bindSubscriptions$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<MuteSettingsSheetViewModel.ViewState, Unit> {
        public AnonymousClass2(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
            super(1, widgetMuteSettingsSheet, WidgetMuteSettingsSheet.class, "updateViews", "updateViews(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MuteSettingsSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MuteSettingsSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetMuteSettingsSheet) this.receiver).updateViews(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$bindSubscriptions$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<MuteSettingsSheetViewModel.Event, Unit> {
        public AnonymousClass3(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
            super(1, widgetMuteSettingsSheet, WidgetMuteSettingsSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MuteSettingsSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MuteSettingsSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((WidgetMuteSettingsSheet) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$configureNotificationSettings$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(ColorCompat.getColor(WidgetMuteSettingsSheet.this.requireContext(), R.color.status_red_500));
        }
    }

    public WidgetMuteSettingsSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetMuteSettingsSheet2.INSTANCE, null, 2, null);
        WidgetMuteSettingsSheet4 widgetMuteSettingsSheet4 = new WidgetMuteSettingsSheet4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(MuteSettingsSheetViewModel.class), new WidgetMuteSettingsSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetMuteSettingsSheet4));
    }

    private final void configureNotificationSettings(MuteSettingsSheetViewModel.ViewState.Loaded viewState) {
        CharSequence charSequenceE;
        CharSequence charSequenceE2;
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.notificationSettingsOverridesLabel");
        int notificationSetting = viewState.getNotificationSetting();
        if (notificationSetting == ModelNotificationSettings.FREQUENCY_ALL) {
            charSequenceE = FormatUtils.e(this, R.string.form_label_all_messages_short, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
        } else if (notificationSetting == ModelNotificationSettings.FREQUENCY_MENTIONS) {
            charSequenceE = FormatUtils.e(this, R.string.form_label_only_mentions_short, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
        } else {
            charSequenceE = notificationSetting == ModelNotificationSettings.FREQUENCY_NOTHING ? FormatUtils.e(this, R.string.form_label_nothing, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null) : "";
        }
        textView.setText(charSequenceE);
        int iOrdinal = viewState.getSettingsType().ordinal();
        if (iOrdinal != 0) {
            boolean z2 = true;
            if (iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 5) {
                if (!viewState.isChannelMuted() && !viewState.isGuildMuted()) {
                    z2 = false;
                }
                if (z2) {
                    TextView textView2 = getBinding().f;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.notificationSettingsLabel");
                    textView2.setAlpha(0.2f);
                    getBinding().d.setOnClickListener(null);
                    TextView textView3 = getBinding().f2498b;
                    Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelMutedDetails");
                    textView3.setVisibility(0);
                    TextView textView4 = getBinding().f2498b;
                    Intrinsics3.checkNotNullExpressionValue(textView4, "binding.channelMutedDetails");
                    if (viewState.isChannelMuted()) {
                        charSequenceE2 = FormatUtils.e(this, R.string.form_description_mobile_notification_muted, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
                    } else {
                        charSequenceE2 = FormatUtils.e(this, R.string.form_label_mobile_channel_override_guild_muted, new Object[0], new AnonymousClass1());
                    }
                    textView4.setText(charSequenceE2);
                } else {
                    TextView textView5 = getBinding().f;
                    Intrinsics3.checkNotNullExpressionValue(textView5, "binding.notificationSettingsLabel");
                    textView5.setAlpha(1.0f);
                    getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetMuteSettingsSheet.configureNotificationSettings.2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            WidgetMuteSettingsSheet.this.getViewModel().onChannelSettingsSelected();
                        }
                    });
                    TextView textView6 = getBinding().f2498b;
                    Intrinsics3.checkNotNullExpressionValue(textView6, "binding.channelMutedDetails");
                    textView6.setVisibility(8);
                }
                FrameLayout frameLayout = getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.notificationSettingsButtonContainer");
                frameLayout.setVisibility(0);
                return;
            }
        }
        FrameLayout frameLayout2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.notificationSettingsButtonContainer");
        frameLayout2.setVisibility(8);
        TextView textView7 = getBinding().f2498b;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.channelMutedDetails");
        textView7.setVisibility(8);
    }

    private final void configureUnmuteButton(MuteSettingsSheetViewModel.ViewState.Loaded viewState) {
        CharSequence charSequenceE;
        WidgetMuteSettingsSheet3 widgetMuteSettingsSheet3 = new WidgetMuteSettingsSheet3(this);
        if (!viewState.isChannelMuted()) {
            LinearLayout linearLayout = getBinding().o;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.unmuteButton");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.muteSettingsSheetMuteOptions");
            linearLayout2.setVisibility(0);
            return;
        }
        TextView textView = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.unmuteButtonLabel");
        FormatUtils.m(textView, R.string.unmute_channel, new Object[]{viewState.getSubtitle()}, widgetMuteSettingsSheet3);
        TextView textView2 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.unmuteButtonDetailsLabel");
        int iOrdinal = viewState.getSettingsType().ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            String muteEndTime = viewState.getMuteEndTime();
            charSequenceE = muteEndTime == null ? FormatUtils.e(this, R.string.form_label_mobile_dm_muted, new Object[0], widgetMuteSettingsSheet3) : FormatUtils.e(this, R.string.form_label_mobile_dm_muted_until, new Object[]{parseMuteEndtime(muteEndTime)}, widgetMuteSettingsSheet3);
        } else {
            String muteEndTime2 = viewState.getMuteEndTime();
            charSequenceE = muteEndTime2 == null ? FormatUtils.e(this, R.string.form_label_mobile_channel_muted, new Object[0], widgetMuteSettingsSheet3) : FormatUtils.e(this, R.string.form_label_mobile_channel_muted_until, new Object[]{parseMuteEndtime(muteEndTime2)}, widgetMuteSettingsSheet3);
        }
        textView2.setText(charSequenceE);
        LinearLayout linearLayout3 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.unmuteButton");
        linearLayout3.setVisibility(0);
        LinearLayout linearLayout4 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout4, "binding.muteSettingsSheetMuteOptions");
        linearLayout4.setVisibility(8);
    }

    private final WidgetMuteSettingsSheetBinding getBinding() {
        return (WidgetMuteSettingsSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final MuteSettingsSheetViewModel getViewModel() {
        return (MuteSettingsSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(MuteSettingsSheetViewModel.Event event) {
        if (event instanceof MuteSettingsSheetViewModel.Event.Dismiss) {
            dismiss();
        } else if (event instanceof MuteSettingsSheetViewModel.Event.NavigateToChannelSettings) {
            WidgetChannelNotificationSettings.Companion companion = WidgetChannelNotificationSettings.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetChannelNotificationSettings.Companion.launch$default(companion, contextRequireContext, ((MuteSettingsSheetViewModel.Event.NavigateToChannelSettings) event).getChannelId(), false, 4, null);
        }
    }

    private final String parseMuteEndtime(String muteEndTime) {
        TimeUtils timeUtils = TimeUtils.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return TimeUtils.renderUtcDateTime$default(timeUtils, muteEndTime, contextRequireContext, null, 3, 3, 4, null);
    }

    public static final void showForChannel(long j, FragmentManager fragmentManager) {
        INSTANCE.showForChannel(j, fragmentManager);
    }

    private final void updateViews(MuteSettingsSheetViewModel.ViewState viewState) {
        Integer numValueOf;
        if (!(viewState instanceof MuteSettingsSheetViewModel.ViewState.Loaded)) {
            if (viewState instanceof MuteSettingsSheetViewModel.ViewState.Failure) {
                AppToast.i(this, R.string.default_failure_to_perform_action_message, 0, 4);
                dismiss();
                return;
            }
            return;
        }
        MuteSettingsSheetViewModel.ViewState.Loaded loaded = (MuteSettingsSheetViewModel.ViewState.Loaded) viewState;
        int iOrdinal = loaded.getSettingsType().ordinal();
        if (iOrdinal == 0) {
            numValueOf = Integer.valueOf(R.string.mute_settings_mute_server);
        } else if (iOrdinal == 1 || iOrdinal == 2) {
            numValueOf = Integer.valueOf(R.string.mute_settings_mute_this_conversation);
        } else if (iOrdinal == 3) {
            numValueOf = Integer.valueOf(R.string.mute_settings_mute_thread);
        } else if (iOrdinal != 4) {
            numValueOf = iOrdinal != 5 ? null : Integer.valueOf(R.string.mute_settings_mute_category);
        } else {
            numValueOf = Integer.valueOf(R.string.mute_settings_mute_channel);
        }
        TextView textView = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.title");
        textView.setText(numValueOf != null ? FormatUtils.e(this, numValueOf.intValue(), new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null) : null);
        TextView textView2 = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.subtitle");
        textView2.setText(loaded.getSubtitle());
        configureUnmuteButton(loaded);
        configureNotificationSettings(loaded);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        getBinding().o.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetMuteSettingsSheet.bindSubscriptions.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MuteSettingsSheetViewModel viewModel = WidgetMuteSettingsSheet.this.getViewModel();
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                viewModel.unmute(context);
            }
        });
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetMuteSettingsSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetMuteSettingsSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3(this));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_mute_settings_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetMuteSettingsSheet.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MuteSettingsSheetViewModel viewModel = WidgetMuteSettingsSheet.this.getViewModel();
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                viewModel.selectMuteDurationMs(900000L, context);
            }
        });
        getBinding().k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetMuteSettingsSheet.onViewCreated.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MuteSettingsSheetViewModel viewModel = WidgetMuteSettingsSheet.this.getViewModel();
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                viewModel.selectMuteDurationMs(3600000L, context);
            }
        });
        getBinding().i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetMuteSettingsSheet.onViewCreated.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MuteSettingsSheetViewModel viewModel = WidgetMuteSettingsSheet.this.getViewModel();
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                viewModel.selectMuteDurationMs(28800000L, context);
            }
        });
        getBinding().l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetMuteSettingsSheet.onViewCreated.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MuteSettingsSheetViewModel viewModel = WidgetMuteSettingsSheet.this.getViewModel();
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                viewModel.selectMuteDurationMs(86400000L, context);
            }
        });
        getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetMuteSettingsSheet.onViewCreated.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MuteSettingsSheetViewModel viewModel = WidgetMuteSettingsSheet.this.getViewModel();
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                viewModel.selectMuteDurationMs(0L, context);
            }
        });
    }
}
