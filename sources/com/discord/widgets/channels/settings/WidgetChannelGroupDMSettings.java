package com.discord.widgets.channels.settings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelGroupDmSettingsBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.servers.NotificationMuteSettingsView;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Action2;

/* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelGroupDMSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChannelGroupDMSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelGroupDmSettingsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function1<? super String, Unit> iconEditedResult;
    private final StatefulViews state;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(long channelId, Context context) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetChannelGroupDMSettings.INTENT_EXTRA_CHANNEL_ID, channelId);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT…RA_CHANNEL_ID, channelId)");
            C0870j.m156d(context, WidgetChannelGroupDMSettings.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$configureIcon$2 */
    /* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
    public static final class C75762 extends AbstractC12240o implements Function1<String, Unit> {
        public C75762() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "dataUrl");
            WidgetChannelGroupDMSettings.this.getViewModel().onIconEdited(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$configureUi$3 */
    /* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
    public static final class C75803 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C75803(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
            long j = this.$channelId;
            FragmentManager parentFragmentManager = WidgetChannelGroupDMSettings.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForChannel(j, parentFragmentManager);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$configureUi$4 */
    /* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
    public static final class C75814 extends AbstractC12240o implements Function0<Unit> {
        public C75814() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChannelGroupDMSettings.this.getViewModel().unmute(WidgetChannelGroupDMSettings.this.requireContext());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$confirmLeave$1 */
    /* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
    public static final class C75821 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Function0 $confirmed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C75821(Function0 function0) {
            super(1);
            this.$confirmed = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            this.$confirmed.invoke();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
    public static final class C75831 extends AbstractC12240o implements Function1<ChannelGroupDMSettingsViewModel.ViewState, Unit> {
        public C75831() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChannelGroupDMSettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChannelGroupDMSettingsViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetChannelGroupDMSettings.this.configureUi(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
    public static final class C75842 extends AbstractC12240o implements Function1<ChannelGroupDMSettingsViewModel.Event, Unit> {
        public C75842() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChannelGroupDMSettingsViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChannelGroupDMSettingsViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            WidgetChannelGroupDMSettings.this.handleEvent(event);
        }
    }

    public WidgetChannelGroupDMSettings() {
        super(C5419R.layout.widget_channel_group_dm_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelGroupDMSettings$binding$2.INSTANCE, null, 2, null);
        WidgetChannelGroupDMSettings$viewModel$2 widgetChannelGroupDMSettings$viewModel$2 = new WidgetChannelGroupDMSettings$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(ChannelGroupDMSettingsViewModel.class), new WidgetChannelGroupDMSettings$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetChannelGroupDMSettings$viewModel$2));
        this.iconEditedResult = WidgetChannelGroupDMSettings$iconEditedResult$1.INSTANCE;
        this.state = new StatefulViews(C5419R.id.channel_settings_edit_name, C5419R.id.settings_group_icon);
    }

    private final void configureIcon(ChannelGroupDMSettingsViewModel.ViewState.Valid viewState) {
        String currentIconUrl = viewState.getCurrentIconUrl();
        if (viewState.getHasUnsavedIconChange()) {
            StatefulViews statefulViews = this.state;
            SimpleDraweeView simpleDraweeView = getBinding().f15850f;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.settingsGroupIcon");
            statefulViews.put(simpleDraweeView.getId(), currentIconUrl != null ? currentIconUrl : "");
        } else {
            StatefulViews statefulViews2 = this.state;
            SimpleDraweeView simpleDraweeView2 = getBinding().f15850f;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.settingsGroupIcon");
            statefulViews2.get(simpleDraweeView2.getId(), currentIconUrl != null ? currentIconUrl : "");
        }
        getBinding().f15850f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings.configureIcon.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelGroupDMSettings.this.openMediaChooser();
            }
        });
        this.iconEditedResult = new C75762();
        SimpleDraweeView simpleDraweeView3 = getBinding().f15850f;
        C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.settingsGroupIcon");
        IconUtils.setIcon$default(simpleDraweeView3, currentIconUrl, C5419R.dimen.avatar_size_xxlarge, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        TextView textView = getBinding().f15851g;
        C12238m.checkNotNullExpressionValue(textView, "binding.settingsGroupIconLabel");
        textView.setVisibility(viewState.isDefaultPhoto() ? 0 : 8);
        TextView textView2 = getBinding().f15852h;
        C12238m.checkNotNullExpressionValue(textView2, "binding.settingsGroupIconRemove");
        textView2.setVisibility(viewState.isDefaultPhoto() ^ true ? 0 : 8);
        getBinding().f15852h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings.configureIcon.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelGroupDMSettings.this.getViewModel().removeEditedIcon();
            }
        });
        this.state.configureSaveActionView(getBinding().f15847c);
    }

    private final void configureUi(ChannelGroupDMSettingsViewModel.ViewState viewState) {
        if (C12238m.areEqual(viewState, ChannelGroupDMSettingsViewModel.ViewState.Invalid.INSTANCE)) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        if (viewState instanceof ChannelGroupDMSettingsViewModel.ViewState.Valid) {
            ChannelGroupDMSettingsViewModel.ViewState.Valid valid = (ChannelGroupDMSettingsViewModel.ViewState.Valid) viewState;
            ChannelSettings channelSettings = valid.getChannelSettings();
            final Channel channel = channelSettings.getChannel();
            final String strM7680d = ChannelUtils.m7680d(channel, requireContext(), true);
            setActionBarTitle(C5419R.string.channel_settings);
            setActionBarSubtitle(strM7680d);
            AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
            AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_main_group_settings, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings.configureUi.1

                /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$configureUi$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
                public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                    public AnonymousClass1() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f27425a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        WidgetChannelGroupDMSettings.this.getViewModel().leaveGroup();
                    }
                }

                @Override // p658rx.functions.Action2
                public final void call(MenuItem menuItem, Context context) {
                    C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
                    if (menuItem.getItemId() == C5419R.id.menu_leave_group) {
                        WidgetChannelGroupDMSettings widgetChannelGroupDMSettings = WidgetChannelGroupDMSettings.this;
                        widgetChannelGroupDMSettings.confirmLeave(widgetChannelGroupDMSettings.requireContext(), new AnonymousClass1(), strM7680d);
                    }
                }
            }, null, 4, null);
            TextInputLayout textInputLayout = getBinding().f15846b;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
            StatefulViews statefulViews = this.state;
            TextInputLayout textInputLayout2 = getBinding().f15846b;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
            ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), strM7680d));
            TextInputLayout textInputLayout3 = getBinding().f15846b;
            C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditName");
            ViewExtensions.setSelectionEnd(textInputLayout3);
            configureIcon(valid);
            this.state.configureSaveActionView(getBinding().f15847c);
            getBinding().f15847c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings.configureUi.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChannelGroupDMSettingsViewModel viewModel = WidgetChannelGroupDMSettings.this.getViewModel();
                    long id2 = channel.getId();
                    StatefulViews statefulViews2 = WidgetChannelGroupDMSettings.this.state;
                    TextInputLayout textInputLayout4 = WidgetChannelGroupDMSettings.this.getBinding().f15846b;
                    C12238m.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditName");
                    viewModel.editGroup(id2, ((String) statefulViews2.get(textInputLayout4.getId(), strM7680d)).toString());
                }
            });
            long id2 = channel.getId();
            getBinding().f15848d.updateView(new NotificationMuteSettingsView.ViewState(channelSettings.isMuted(), channelSettings.getMuteEndTime(), C1107b.m213e(this, C5419R.string.mute_conversation, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), C1107b.m213e(this, C5419R.string.unmute_conversation, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), C1107b.m213e(this, C5419R.string.form_label_mobile_dm_muted, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), C5419R.string.form_label_mobile_dm_muted_until, null), new C75803(id2), new C75814());
        }
    }

    private final void confirmLeave(Context context, Function0<Unit> confirmed, CharSequence groupName) {
        WidgetNoticeDialog.Builder negativeButton$default = WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(context).setTitle(C1107b.m213e(this, C5419R.string.leave_group_dm_title, new Object[]{groupName}, (4 & 4) != 0 ? C1107b.a.f1490j : null)).setMessage(C1107b.m213e(this, C5419R.string.leave_group_dm_body, new Object[]{groupName}, (4 & 4) != 0 ? C1107b.a.f1490j : null)).setDialogAttrTheme(C5419R.attr.notice_theme_positive_red).setPositiveButton(C5419R.string.leave_group_dm, new C75821(confirmed)), C5419R.string.cancel, (Function1) null, 2, (Object) null);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        negativeButton$default.show(parentFragmentManager);
    }

    private final WidgetChannelGroupDmSettingsBinding getBinding() {
        return (WidgetChannelGroupDmSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ChannelGroupDMSettingsViewModel getViewModel() {
        return (ChannelGroupDMSettingsViewModel) this.viewModel.getValue();
    }

    private final void handleSettingsSaved() {
        C0876m.m171i(this, C5419R.string.saved_settings, 0, 4);
        StatefulViews.clear$default(this.state, false, 1, null);
        AppFragment.hideKeyboard$default(this, null, 1, null);
        getBinding().f15849e.fullScroll(33);
    }

    public final void handleEvent(ChannelGroupDMSettingsViewModel.Event event) {
        C12238m.checkNotNullParameter(event, "event");
        if (!C12238m.areEqual(event, ChannelGroupDMSettingsViewModel.Event.LeaveGroupSuccess.INSTANCE)) {
            if (C12238m.areEqual(event, ChannelGroupDMSettingsViewModel.Event.SettingsSaved.INSTANCE)) {
                handleSettingsSaved();
            }
        } else {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Function1<? super String, Unit> function1 = this.iconEditedResult;
        Object widgetChannelGroupDMSettings$sam$rx_functions_Action1$0 = function1;
        if (function1 != null) {
            widgetChannelGroupDMSettings$sam$rx_functions_Action1$0 = new WidgetChannelGroupDMSettings$sam$rx_functions_Action1$0(function1);
        }
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, (Action1) widgetChannelGroupDMSettings$sam$rx_functions_Action1$0, ImageUploadDialog.PreviewType.GUILD_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        Context context = getContext();
        Function1<? super String, Unit> function1 = this.iconEditedResult;
        Object widgetChannelGroupDMSettings$sam$rx_functions_Action1$0 = function1;
        if (function1 != null) {
            widgetChannelGroupDMSettings$sam$rx_functions_Action1$0 = new WidgetChannelGroupDMSettings$sam$rx_functions_Action1$0(function1);
        }
        MGImages.requestDataUrl(context, uri, mimeType, (Action1) widgetChannelGroupDMSettings$sam$rx_functions_Action1$0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f15851g;
        C12238m.checkNotNullExpressionValue(textView, "binding.settingsGroupIconLabel");
        textView.setText(C1107b.m213e(this, C5419R.string.minimum_size, new Object[]{"128", "128"}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().f15847c;
        TextInputLayout textInputLayout = getBinding().f15846b;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetChannelGroupDMSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75831());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetChannelGroupDMSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75842());
    }
}
