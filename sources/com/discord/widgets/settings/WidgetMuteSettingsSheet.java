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
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetMuteSettingsSheetBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.subscriptions.CompositeSubscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetMuteSettingsSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMuteSettingsSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void showForChannel(long channelId, FragmentManager fragmentManager) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetMuteSettingsSheet widgetMuteSettingsSheet = new WidgetMuteSettingsSheet();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetMuteSettingsSheet.ARG_CHANNEL_ID, channelId);
            widgetMuteSettingsSheet.setArguments(bundle);
            widgetMuteSettingsSheet.show(fragmentManager, WidgetMuteSettingsSheet.class.getName());
        }

        public final void showForGuild(long guildId, FragmentManager fragmentManager) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
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

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$bindSubscriptions$2 */
    /* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
    public static final /* synthetic */ class C96002 extends C12236k implements Function1<MuteSettingsSheetViewModel.ViewState, Unit> {
        public C96002(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
            super(1, widgetMuteSettingsSheet, WidgetMuteSettingsSheet.class, "updateViews", "updateViews(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MuteSettingsSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MuteSettingsSheetViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetMuteSettingsSheet) this.receiver).updateViews(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$bindSubscriptions$3 */
    /* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
    public static final /* synthetic */ class C96013 extends C12236k implements Function1<MuteSettingsSheetViewModel.Event, Unit> {
        public C96013(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
            super(1, widgetMuteSettingsSheet, WidgetMuteSettingsSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MuteSettingsSheetViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MuteSettingsSheetViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetMuteSettingsSheet) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$configureNotificationSettings$1 */
    /* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
    public static final class C96021 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public C96021() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(ColorCompat.getColor(WidgetMuteSettingsSheet.this.requireContext(), C5419R.color.status_red_500));
        }
    }

    public WidgetMuteSettingsSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetMuteSettingsSheet$binding$2.INSTANCE, null, 2, null);
        WidgetMuteSettingsSheet$viewModel$2 widgetMuteSettingsSheet$viewModel$2 = new WidgetMuteSettingsSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(MuteSettingsSheetViewModel.class), new WidgetMuteSettingsSheet$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetMuteSettingsSheet$viewModel$2));
    }

    private final void configureNotificationSettings(MuteSettingsSheetViewModel.ViewState.Loaded viewState) {
        CharSequence charSequenceM213e;
        CharSequence charSequenceM213e2;
        TextView textView = getBinding().f17280g;
        C12238m.checkNotNullExpressionValue(textView, "binding.notificationSettingsOverridesLabel");
        int notificationSetting = viewState.getNotificationSetting();
        if (notificationSetting == ModelNotificationSettings.FREQUENCY_ALL) {
            charSequenceM213e = C1107b.m213e(this, C5419R.string.form_label_all_messages_short, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
        } else if (notificationSetting == ModelNotificationSettings.FREQUENCY_MENTIONS) {
            charSequenceM213e = C1107b.m213e(this, C5419R.string.form_label_only_mentions_short, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
        } else {
            charSequenceM213e = notificationSetting == ModelNotificationSettings.FREQUENCY_NOTHING ? C1107b.m213e(this, C5419R.string.form_label_nothing, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null) : "";
        }
        textView.setText(charSequenceM213e);
        int iOrdinal = viewState.getSettingsType().ordinal();
        if (iOrdinal != 0) {
            boolean z2 = true;
            if (iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 5) {
                if (!viewState.isChannelMuted() && !viewState.isGuildMuted()) {
                    z2 = false;
                }
                if (z2) {
                    TextView textView2 = getBinding().f17279f;
                    C12238m.checkNotNullExpressionValue(textView2, "binding.notificationSettingsLabel");
                    textView2.setAlpha(0.2f);
                    getBinding().f17277d.setOnClickListener(null);
                    TextView textView3 = getBinding().f17275b;
                    C12238m.checkNotNullExpressionValue(textView3, "binding.channelMutedDetails");
                    textView3.setVisibility(0);
                    TextView textView4 = getBinding().f17275b;
                    C12238m.checkNotNullExpressionValue(textView4, "binding.channelMutedDetails");
                    if (viewState.isChannelMuted()) {
                        charSequenceM213e2 = C1107b.m213e(this, C5419R.string.form_description_mobile_notification_muted, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
                    } else {
                        charSequenceM213e2 = C1107b.m213e(this, C5419R.string.form_label_mobile_channel_override_guild_muted, new Object[0], new C96021());
                    }
                    textView4.setText(charSequenceM213e2);
                } else {
                    TextView textView5 = getBinding().f17279f;
                    C12238m.checkNotNullExpressionValue(textView5, "binding.notificationSettingsLabel");
                    textView5.setAlpha(1.0f);
                    getBinding().f17277d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetMuteSettingsSheet.configureNotificationSettings.2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            WidgetMuteSettingsSheet.this.getViewModel().onChannelSettingsSelected();
                        }
                    });
                    TextView textView6 = getBinding().f17275b;
                    C12238m.checkNotNullExpressionValue(textView6, "binding.channelMutedDetails");
                    textView6.setVisibility(8);
                }
                FrameLayout frameLayout = getBinding().f17278e;
                C12238m.checkNotNullExpressionValue(frameLayout, "binding.notificationSettingsButtonContainer");
                frameLayout.setVisibility(0);
                return;
            }
        }
        FrameLayout frameLayout2 = getBinding().f17278e;
        C12238m.checkNotNullExpressionValue(frameLayout2, "binding.notificationSettingsButtonContainer");
        frameLayout2.setVisibility(8);
        TextView textView7 = getBinding().f17275b;
        C12238m.checkNotNullExpressionValue(textView7, "binding.channelMutedDetails");
        textView7.setVisibility(8);
    }

    private final void configureUnmuteButton(MuteSettingsSheetViewModel.ViewState.Loaded viewState) {
        CharSequence charSequenceM213e;
        C9604xd6d92da2 c9604xd6d92da2 = new C9604xd6d92da2(this);
        if (!viewState.isChannelMuted()) {
            LinearLayout linearLayout = getBinding().f17288o;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.unmuteButton");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = getBinding().f17276c;
            C12238m.checkNotNullExpressionValue(linearLayout2, "binding.muteSettingsSheetMuteOptions");
            linearLayout2.setVisibility(0);
            return;
        }
        TextView textView = getBinding().f17290q;
        C12238m.checkNotNullExpressionValue(textView, "binding.unmuteButtonLabel");
        C1107b.m221m(textView, C5419R.string.unmute_channel, new Object[]{viewState.getSubtitle()}, c9604xd6d92da2);
        TextView textView2 = getBinding().f17289p;
        C12238m.checkNotNullExpressionValue(textView2, "binding.unmuteButtonDetailsLabel");
        int iOrdinal = viewState.getSettingsType().ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            String muteEndTime = viewState.getMuteEndTime();
            charSequenceM213e = muteEndTime == null ? C1107b.m213e(this, C5419R.string.form_label_mobile_dm_muted, new Object[0], c9604xd6d92da2) : C1107b.m213e(this, C5419R.string.form_label_mobile_dm_muted_until, new Object[]{parseMuteEndtime(muteEndTime)}, c9604xd6d92da2);
        } else {
            String muteEndTime2 = viewState.getMuteEndTime();
            charSequenceM213e = muteEndTime2 == null ? C1107b.m213e(this, C5419R.string.form_label_mobile_channel_muted, new Object[0], c9604xd6d92da2) : C1107b.m213e(this, C5419R.string.form_label_mobile_channel_muted_until, new Object[]{parseMuteEndtime(muteEndTime2)}, c9604xd6d92da2);
        }
        textView2.setText(charSequenceM213e);
        LinearLayout linearLayout3 = getBinding().f17288o;
        C12238m.checkNotNullExpressionValue(linearLayout3, "binding.unmuteButton");
        linearLayout3.setVisibility(0);
        LinearLayout linearLayout4 = getBinding().f17276c;
        C12238m.checkNotNullExpressionValue(linearLayout4, "binding.muteSettingsSheetMuteOptions");
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
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetChannelNotificationSettings.Companion.launch$default(companion, contextRequireContext, ((MuteSettingsSheetViewModel.Event.NavigateToChannelSettings) event).getChannelId(), false, 4, null);
        }
    }

    private final String parseMuteEndtime(String muteEndTime) {
        TimeUtils timeUtils = TimeUtils.INSTANCE;
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return TimeUtils.renderUtcDateTime$default(timeUtils, muteEndTime, contextRequireContext, null, 3, 3, 4, null);
    }

    public static final void showForChannel(long j, FragmentManager fragmentManager) {
        INSTANCE.showForChannel(j, fragmentManager);
    }

    private final void updateViews(MuteSettingsSheetViewModel.ViewState viewState) {
        Integer numValueOf;
        if (!(viewState instanceof MuteSettingsSheetViewModel.ViewState.Loaded)) {
            if (viewState instanceof MuteSettingsSheetViewModel.ViewState.Failure) {
                C0876m.m171i(this, C5419R.string.default_failure_to_perform_action_message, 0, 4);
                dismiss();
                return;
            }
            return;
        }
        MuteSettingsSheetViewModel.ViewState.Loaded loaded = (MuteSettingsSheetViewModel.ViewState.Loaded) viewState;
        int iOrdinal = loaded.getSettingsType().ordinal();
        if (iOrdinal == 0) {
            numValueOf = Integer.valueOf(C5419R.string.mute_settings_mute_server);
        } else if (iOrdinal == 1 || iOrdinal == 2) {
            numValueOf = Integer.valueOf(C5419R.string.mute_settings_mute_this_conversation);
        } else if (iOrdinal == 3) {
            numValueOf = Integer.valueOf(C5419R.string.mute_settings_mute_thread);
        } else if (iOrdinal != 4) {
            numValueOf = iOrdinal != 5 ? null : Integer.valueOf(C5419R.string.mute_settings_mute_category);
        } else {
            numValueOf = Integer.valueOf(C5419R.string.mute_settings_mute_channel);
        }
        TextView textView = getBinding().f17287n;
        C12238m.checkNotNullExpressionValue(textView, "binding.title");
        textView.setText(numValueOf != null ? C1107b.m213e(this, numValueOf.intValue(), new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null) : null);
        TextView textView2 = getBinding().f17286m;
        C12238m.checkNotNullExpressionValue(textView2, "binding.subtitle");
        textView2.setText(loaded.getSubtitle());
        configureUnmuteButton(loaded);
        configureNotificationSettings(loaded);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        C12238m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        getBinding().f17288o.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetMuteSettingsSheet.bindSubscriptions.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MuteSettingsSheetViewModel viewModel = WidgetMuteSettingsSheet.this.getViewModel();
                C12238m.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                viewModel.unmute(context);
            }
        });
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetMuteSettingsSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C96002(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetMuteSettingsSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C96013(this));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_mute_settings_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f17283j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetMuteSettingsSheet.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MuteSettingsSheetViewModel viewModel = WidgetMuteSettingsSheet.this.getViewModel();
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                viewModel.selectMuteDurationMs(900000L, context);
            }
        });
        getBinding().f17284k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetMuteSettingsSheet.onViewCreated.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MuteSettingsSheetViewModel viewModel = WidgetMuteSettingsSheet.this.getViewModel();
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                viewModel.selectMuteDurationMs(3600000L, context);
            }
        });
        getBinding().f17282i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetMuteSettingsSheet.onViewCreated.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MuteSettingsSheetViewModel viewModel = WidgetMuteSettingsSheet.this.getViewModel();
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                viewModel.selectMuteDurationMs(28800000L, context);
            }
        });
        getBinding().f17285l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetMuteSettingsSheet.onViewCreated.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MuteSettingsSheetViewModel viewModel = WidgetMuteSettingsSheet.this.getViewModel();
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                viewModel.selectMuteDurationMs(86400000L, context);
            }
        });
        getBinding().f17281h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetMuteSettingsSheet.onViewCreated.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MuteSettingsSheetViewModel viewModel = WidgetMuteSettingsSheet.this.getViewModel();
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                viewModel.selectMuteDurationMs(0L, context);
            }
        });
    }
}
