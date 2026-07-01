package com.discord.widgets.channels.settings;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelGroupDmSettingsBinding;
import com.discord.dialogs.ImageUploadDialog$PreviewType;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.notice.WidgetNoticeDialog$Builder;
import com.discord.widgets.servers.NotificationMuteSettingsView$ViewState;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelGroupDMSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelGroupDMSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelGroupDmSettingsBinding;", 0)};
    public static final WidgetChannelGroupDMSettings$Companion Companion = new WidgetChannelGroupDMSettings$Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function1<? super String, Unit> iconEditedResult;
    private final StatefulViews state;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetChannelGroupDMSettings() {
        super(R$layout.widget_channel_group_dm_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelGroupDMSettings$binding$2.INSTANCE, null, 2, null);
        WidgetChannelGroupDMSettings$viewModel$2 widgetChannelGroupDMSettings$viewModel$2 = new WidgetChannelGroupDMSettings$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ChannelGroupDMSettingsViewModel.class), new WidgetChannelGroupDMSettings$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetChannelGroupDMSettings$viewModel$2));
        this.iconEditedResult = WidgetChannelGroupDMSettings$iconEditedResult$1.INSTANCE;
        this.state = new StatefulViews(R$id.channel_settings_edit_name, R$id.settings_group_icon);
    }

    public static final /* synthetic */ void access$configureUi(WidgetChannelGroupDMSettings widgetChannelGroupDMSettings, ChannelGroupDMSettingsViewModel$ViewState channelGroupDMSettingsViewModel$ViewState) {
        widgetChannelGroupDMSettings.configureUi(channelGroupDMSettingsViewModel$ViewState);
    }

    public static final /* synthetic */ void access$confirmLeave(WidgetChannelGroupDMSettings widgetChannelGroupDMSettings, Context context, Function0 function0, CharSequence charSequence) {
        widgetChannelGroupDMSettings.confirmLeave(context, function0, charSequence);
    }

    public static final /* synthetic */ WidgetChannelGroupDmSettingsBinding access$getBinding$p(WidgetChannelGroupDMSettings widgetChannelGroupDMSettings) {
        return widgetChannelGroupDMSettings.getBinding();
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetChannelGroupDMSettings widgetChannelGroupDMSettings) {
        return widgetChannelGroupDMSettings.state;
    }

    public static final /* synthetic */ ChannelGroupDMSettingsViewModel access$getViewModel$p(WidgetChannelGroupDMSettings widgetChannelGroupDMSettings) {
        return widgetChannelGroupDMSettings.getViewModel();
    }

    private final void configureIcon(ChannelGroupDMSettingsViewModel$ViewState$Valid viewState) {
        String currentIconUrl = viewState.getCurrentIconUrl();
        if (viewState.getHasUnsavedIconChange()) {
            StatefulViews statefulViews = this.state;
            SimpleDraweeView simpleDraweeView = getBinding().f;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.settingsGroupIcon");
            statefulViews.put(simpleDraweeView.getId(), currentIconUrl != null ? currentIconUrl : "");
        } else {
            StatefulViews statefulViews2 = this.state;
            SimpleDraweeView simpleDraweeView2 = getBinding().f;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.settingsGroupIcon");
            statefulViews2.get(simpleDraweeView2.getId(), currentIconUrl != null ? currentIconUrl : "");
        }
        getBinding().f.setOnClickListener(new WidgetChannelGroupDMSettings$configureIcon$1(this));
        this.iconEditedResult = new WidgetChannelGroupDMSettings$configureIcon$2(this);
        SimpleDraweeView simpleDraweeView3 = getBinding().f;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.settingsGroupIcon");
        IconUtils.setIcon$default(simpleDraweeView3, currentIconUrl, 2131165302, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
        TextView textView = getBinding().g;
        m.checkNotNullExpressionValue(textView, "binding.settingsGroupIconLabel");
        textView.setVisibility(viewState.isDefaultPhoto() ? 0 : 8);
        TextView textView2 = getBinding().h;
        m.checkNotNullExpressionValue(textView2, "binding.settingsGroupIconRemove");
        textView2.setVisibility(viewState.isDefaultPhoto() ^ true ? 0 : 8);
        getBinding().h.setOnClickListener(new WidgetChannelGroupDMSettings$configureIcon$3(this));
        this.state.configureSaveActionView(getBinding().c);
    }

    private final void configureUi(ChannelGroupDMSettingsViewModel$ViewState viewState) {
        if (m.areEqual(viewState, ChannelGroupDMSettingsViewModel$ViewState$Invalid.INSTANCE)) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        if (viewState instanceof ChannelGroupDMSettingsViewModel$ViewState$Valid) {
            ChannelGroupDMSettingsViewModel$ViewState$Valid channelGroupDMSettingsViewModel$ViewState$Valid = (ChannelGroupDMSettingsViewModel$ViewState$Valid) viewState;
            ChannelSettings channelSettings = channelGroupDMSettingsViewModel$ViewState$Valid.getChannelSettings();
            Channel channel = channelSettings.getChannel();
            String strD = ChannelUtils.d(channel, requireContext(), true);
            setActionBarTitle(2131887604);
            setActionBarSubtitle(strD);
            AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
            AppFragment.setActionBarOptionsMenu$default(this, R$menu.menu_main_group_settings, new WidgetChannelGroupDMSettings$configureUi$1(this, strD), null, 4, null);
            TextInputLayout textInputLayout = getBinding().f2257b;
            m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
            StatefulViews statefulViews = this.state;
            TextInputLayout textInputLayout2 = getBinding().f2257b;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
            ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), strD));
            TextInputLayout textInputLayout3 = getBinding().f2257b;
            m.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditName");
            ViewExtensions.setSelectionEnd(textInputLayout3);
            configureIcon(channelGroupDMSettingsViewModel$ViewState$Valid);
            this.state.configureSaveActionView(getBinding().c);
            getBinding().c.setOnClickListener(new WidgetChannelGroupDMSettings$configureUi$2(this, channel, strD));
            long id2 = channel.getId();
            getBinding().d.updateView(new NotificationMuteSettingsView$ViewState(channelSettings.isMuted(), channelSettings.getMuteEndTime(), b.k(this, 2131893141, new Object[0], null, 4), b.k(this, 2131896591, new Object[0], null, 4), b.k(this, 2131889198, new Object[0], null, 4), 2131889199, null), new WidgetChannelGroupDMSettings$configureUi$3(this, id2), new WidgetChannelGroupDMSettings$configureUi$4(this));
        }
    }

    private final void confirmLeave(Context context, Function0<Unit> confirmed, CharSequence groupName) {
        WidgetNoticeDialog$Builder negativeButton$default = WidgetNoticeDialog$Builder.setNegativeButton$default(new WidgetNoticeDialog$Builder(context).setTitle(b.k(this, 2131892533, new Object[]{groupName}, null, 4)).setMessage(b.k(this, 2131892527, new Object[]{groupName}, null, 4)).setDialogAttrTheme(2130969885).setPositiveButton(2131892526, new WidgetChannelGroupDMSettings$confirmLeave$1(confirmed)), 2131887437, (Function1) null, 2, (Object) null);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        negativeButton$default.show(parentFragmentManager);
    }

    private final WidgetChannelGroupDmSettingsBinding getBinding() {
        return (WidgetChannelGroupDmSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ChannelGroupDMSettingsViewModel getViewModel() {
        return (ChannelGroupDMSettingsViewModel) this.viewModel.getValue();
    }

    private final void handleSettingsSaved() {
        b.a.d.m.i(this, 2131895235, 0, 4);
        StatefulViews.clear$default(this.state, false, 1, null);
        AppFragment.hideKeyboard$default(this, null, 1, null);
        getBinding().e.fullScroll(33);
    }

    public final void handleEvent(ChannelGroupDMSettingsViewModel$Event event) {
        m.checkNotNullParameter(event, "event");
        if (!m.areEqual(event, ChannelGroupDMSettingsViewModel$Event$LeaveGroupSuccess.INSTANCE)) {
            if (m.areEqual(event, ChannelGroupDMSettingsViewModel$Event$SettingsSaved.INSTANCE)) {
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
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Function1<? super String, Unit> function1 = this.iconEditedResult;
        Object widgetChannelGroupDMSettings$sam$rx_functions_Action1$0 = function1;
        if (function1 != null) {
            widgetChannelGroupDMSettings$sam$rx_functions_Action1$0 = new WidgetChannelGroupDMSettings$sam$rx_functions_Action1$0(function1);
        }
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, (Action1) widgetChannelGroupDMSettings$sam$rx_functions_Action1$0, ImageUploadDialog$PreviewType.GUILD_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
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
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().g;
        m.checkNotNullExpressionValue(textView, "binding.settingsGroupIconLabel");
        textView.setText(b.k(this, 2131893003, new Object[]{"128", "128"}, null, 4));
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().c;
        TextInputLayout textInputLayout = getBinding().f2257b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelGroupDMSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelGroupDMSettings$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetChannelGroupDMSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelGroupDMSettings$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
