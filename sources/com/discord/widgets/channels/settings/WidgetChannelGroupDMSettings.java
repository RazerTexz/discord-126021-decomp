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
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelGroupDmSettingsBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.servers.NotificationMuteSettingsView;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
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
import rx.functions.Action1;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelGroupDMSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelGroupDMSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelGroupDmSettingsBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetChannelGroupDMSettings.INTENT_EXTRA_CHANNEL_ID, channelId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT…RA_CHANNEL_ID, channelId)");
            AppScreen2.d(context, WidgetChannelGroupDMSettings.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$configureIcon$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "dataUrl");
            WidgetChannelGroupDMSettings.this.getViewModel().onIconEdited(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$configureUi$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
            long j = this.$channelId;
            FragmentManager parentFragmentManager = WidgetChannelGroupDMSettings.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForChannel(j, parentFragmentManager);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$configureUi$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChannelGroupDMSettings.this.getViewModel().unmute(WidgetChannelGroupDMSettings.this.requireContext());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$confirmLeave$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Function0 $confirmed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(1);
            this.$confirmed = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            this.$confirmed.invoke();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ChannelGroupDMSettingsViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChannelGroupDMSettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChannelGroupDMSettingsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetChannelGroupDMSettings.this.configureUi(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<ChannelGroupDMSettingsViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChannelGroupDMSettingsViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChannelGroupDMSettingsViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetChannelGroupDMSettings.this.handleEvent(event);
        }
    }

    public WidgetChannelGroupDMSettings() {
        super(R.layout.widget_channel_group_dm_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelGroupDMSettings2.INSTANCE, null, 2, null);
        WidgetChannelGroupDMSettings5 widgetChannelGroupDMSettings5 = new WidgetChannelGroupDMSettings5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ChannelGroupDMSettingsViewModel.class), new WidgetChannelGroupDMSettings$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetChannelGroupDMSettings5));
        this.iconEditedResult = WidgetChannelGroupDMSettings3.INSTANCE;
        this.state = new StatefulViews(R.id.channel_settings_edit_name, R.id.settings_group_icon);
    }

    private final void configureIcon(ChannelGroupDMSettingsViewModel.ViewState.Valid viewState) {
        String currentIconUrl = viewState.getCurrentIconUrl();
        if (viewState.getHasUnsavedIconChange()) {
            StatefulViews statefulViews = this.state;
            SimpleDraweeView simpleDraweeView = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.settingsGroupIcon");
            statefulViews.put(simpleDraweeView.getId(), currentIconUrl != null ? currentIconUrl : "");
        } else {
            StatefulViews statefulViews2 = this.state;
            SimpleDraweeView simpleDraweeView2 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.settingsGroupIcon");
            statefulViews2.get(simpleDraweeView2.getId(), currentIconUrl != null ? currentIconUrl : "");
        }
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings.configureIcon.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelGroupDMSettings.this.openMediaChooser();
            }
        });
        this.iconEditedResult = new AnonymousClass2();
        SimpleDraweeView simpleDraweeView3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.settingsGroupIcon");
        IconUtils.setIcon$default(simpleDraweeView3, currentIconUrl, R.dimen.avatar_size_xxlarge, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsGroupIconLabel");
        textView.setVisibility(viewState.isDefaultPhoto() ? 0 : 8);
        TextView textView2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.settingsGroupIconRemove");
        textView2.setVisibility(viewState.isDefaultPhoto() ^ true ? 0 : 8);
        getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings.configureIcon.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelGroupDMSettings.this.getViewModel().removeEditedIcon();
            }
        });
        this.state.configureSaveActionView(getBinding().c);
    }

    private final void configureUi(ChannelGroupDMSettingsViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, ChannelGroupDMSettingsViewModel.ViewState.Invalid.INSTANCE)) {
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
            final String strD = ChannelUtils.d(channel, requireContext(), true);
            setActionBarTitle(R.string.channel_settings);
            setActionBarSubtitle(strD);
            AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
            AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_main_group_settings, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings.configureUi.1

                /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$configureUi$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
                public static final class C02481 extends Lambda implements Function0<Unit> {
                    public C02481() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        WidgetChannelGroupDMSettings.this.getViewModel().leaveGroup();
                    }
                }

                @Override // rx.functions.Action2
                public final void call(MenuItem menuItem, Context context) {
                    Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                    if (menuItem.getItemId() == R.id.menu_leave_group) {
                        WidgetChannelGroupDMSettings widgetChannelGroupDMSettings = WidgetChannelGroupDMSettings.this;
                        widgetChannelGroupDMSettings.confirmLeave(widgetChannelGroupDMSettings.requireContext(), new C02481(), strD);
                    }
                }
            }, null, 4, null);
            TextInputLayout textInputLayout = getBinding().f2257b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
            StatefulViews statefulViews = this.state;
            TextInputLayout textInputLayout2 = getBinding().f2257b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
            ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), strD));
            TextInputLayout textInputLayout3 = getBinding().f2257b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditName");
            ViewExtensions.setSelectionEnd(textInputLayout3);
            configureIcon(valid);
            this.state.configureSaveActionView(getBinding().c);
            getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings.configureUi.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChannelGroupDMSettingsViewModel viewModel = WidgetChannelGroupDMSettings.this.getViewModel();
                    long id2 = channel.getId();
                    StatefulViews statefulViews2 = WidgetChannelGroupDMSettings.this.state;
                    TextInputLayout textInputLayout4 = WidgetChannelGroupDMSettings.this.getBinding().f2257b;
                    Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditName");
                    viewModel.editGroup(id2, ((String) statefulViews2.get(textInputLayout4.getId(), strD)).toString());
                }
            });
            long id2 = channel.getId();
            getBinding().d.updateView(new NotificationMuteSettingsView.ViewState(channelSettings.isMuted(), channelSettings.getMuteEndTime(), FormatUtils.e(this, R.string.mute_conversation, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), FormatUtils.e(this, R.string.unmute_conversation, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), FormatUtils.e(this, R.string.form_label_mobile_dm_muted, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), R.string.form_label_mobile_dm_muted_until, null), new AnonymousClass3(id2), new AnonymousClass4());
        }
    }

    private final void confirmLeave(Context context, Function0<Unit> confirmed, CharSequence groupName) {
        WidgetNoticeDialog.Builder negativeButton$default = WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(context).setTitle(FormatUtils.e(this, R.string.leave_group_dm_title, new Object[]{groupName}, (4 & 4) != 0 ? FormatUtils.a.j : null)).setMessage(FormatUtils.e(this, R.string.leave_group_dm_body, new Object[]{groupName}, (4 & 4) != 0 ? FormatUtils.a.j : null)).setDialogAttrTheme(R.attr.notice_theme_positive_red).setPositiveButton(R.string.leave_group_dm, new AnonymousClass1(confirmed)), R.string.cancel, (Function1) null, 2, (Object) null);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        negativeButton$default.show(parentFragmentManager);
    }

    private final WidgetChannelGroupDmSettingsBinding getBinding() {
        return (WidgetChannelGroupDmSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ChannelGroupDMSettingsViewModel getViewModel() {
        return (ChannelGroupDMSettingsViewModel) this.viewModel.getValue();
    }

    private final void handleSettingsSaved() {
        AppToast.i(this, R.string.saved_settings, 0, 4);
        StatefulViews.clear$default(this.state, false, 1, null);
        AppFragment.hideKeyboard$default(this, null, 1, null);
        getBinding().e.fullScroll(33);
    }

    public final void handleEvent(ChannelGroupDMSettingsViewModel.Event event) {
        Intrinsics3.checkNotNullParameter(event, "event");
        if (!Intrinsics3.areEqual(event, ChannelGroupDMSettingsViewModel.Event.LeaveGroupSuccess.INSTANCE)) {
            if (Intrinsics3.areEqual(event, ChannelGroupDMSettingsViewModel.Event.SettingsSaved.INSTANCE)) {
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
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Function1<? super String, Unit> function1 = this.iconEditedResult;
        Object widgetChannelGroupDMSettings4 = function1;
        if (function1 != null) {
            widgetChannelGroupDMSettings4 = new WidgetChannelGroupDMSettings4(function1);
        }
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, (Action1) widgetChannelGroupDMSettings4, ImageUploadDialog.PreviewType.GUILD_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        Context context = getContext();
        Function1<? super String, Unit> function1 = this.iconEditedResult;
        Object widgetChannelGroupDMSettings4 = function1;
        if (function1 != null) {
            widgetChannelGroupDMSettings4 = new WidgetChannelGroupDMSettings4(function1);
        }
        MGImages.requestDataUrl(context, uri, mimeType, (Action1) widgetChannelGroupDMSettings4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsGroupIconLabel");
        textView.setText(FormatUtils.e(this, R.string.minimum_size, new Object[]{"128", "128"}, (4 & 4) != 0 ? FormatUtils.a.j : null));
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().c;
        TextInputLayout textInputLayout = getBinding().f2257b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetChannelGroupDMSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetChannelGroupDMSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
