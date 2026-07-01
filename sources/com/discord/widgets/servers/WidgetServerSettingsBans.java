package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsBansBinding;
import com.discord.models.domain.ModelBan;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.notice.WidgetNoticeDialog$Builder;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsBans.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsBansBinding;", 0)};
    public static final WidgetServerSettingsBans$Companion Companion = new WidgetServerSettingsBans$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "GUILD_ID";
    private static final int VIEW_INDEX_BANS_LOADING = 0;
    private static final int VIEW_INDEX_BAN_LIST = 1;
    private static final int VIEW_INDEX_NO_BANS = 2;
    private static final int VIEW_INDEX_NO_RESULTS = 3;
    private WidgetServerSettingsBans$Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private AlertDialog dialog;
    private final BehaviorSubject<String> filterPublisher;
    private long guildId;
    private final LoggingConfig loggingConfig;

    public WidgetServerSettingsBans() {
        super(R$layout.widget_server_settings_bans);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsBans$binding$2.INSTANCE, null, 2, null);
        this.filterPublisher = BehaviorSubject.l0("");
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsBans$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsBans widgetServerSettingsBans, WidgetServerSettingsBans$Model widgetServerSettingsBans$Model) {
        widgetServerSettingsBans.configureUI(widgetServerSettingsBans$Model);
    }

    public static final /* synthetic */ BehaviorSubject access$getFilterPublisher$p(WidgetServerSettingsBans widgetServerSettingsBans) {
        return widgetServerSettingsBans.filterPublisher;
    }

    public static final /* synthetic */ void access$showConfirmUnbanDialog(WidgetServerSettingsBans widgetServerSettingsBans, long j, ModelBan modelBan) {
        widgetServerSettingsBans.showConfirmUnbanDialog(j, modelBan);
    }

    private final void configureToolbar(String guildName) {
        setActionBarTitle(2131887010);
        setActionBarSubtitle(guildName);
    }

    private final void configureUI(WidgetServerSettingsBans$Model model) throws Exception {
        if ((model != null ? model.getFilteredBannedUsers() : null) == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        configureToolbar(model.getGuildName());
        if (model.isLoading()) {
            AppViewFlipper appViewFlipper = getBinding().d;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsBansViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (model.getTotalBannedUsers() == 0) {
            AppViewFlipper appViewFlipper2 = getBinding().d;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.serverSettingsBansViewFlipper");
            appViewFlipper2.setDisplayedChild(2);
        } else if (model.getFilteredBannedUsers().isEmpty()) {
            AppViewFlipper appViewFlipper3 = getBinding().d;
            m.checkNotNullExpressionValue(appViewFlipper3, "binding.serverSettingsBansViewFlipper");
            appViewFlipper3.setDisplayedChild(3);
        } else {
            AppViewFlipper appViewFlipper4 = getBinding().d;
            m.checkNotNullExpressionValue(appViewFlipper4, "binding.serverSettingsBansViewFlipper");
            appViewFlipper4.setDisplayedChild(1);
        }
        WidgetServerSettingsBans$Adapter widgetServerSettingsBans$Adapter = this.adapter;
        if (widgetServerSettingsBans$Adapter != null) {
            widgetServerSettingsBans$Adapter.setOnBanSelectedListener(new WidgetServerSettingsBans$configureUI$1(this, model));
        }
        WidgetServerSettingsBans$Adapter widgetServerSettingsBans$Adapter2 = this.adapter;
        if (widgetServerSettingsBans$Adapter2 != null) {
            widgetServerSettingsBans$Adapter2.setData(model.getFilteredBannedUsers());
        }
    }

    public static final void create(Context context, long j) {
        Companion.create(context, j);
    }

    private final WidgetServerSettingsBansBinding getBinding() {
        return (WidgetServerSettingsBansBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void showConfirmUnbanDialog(long guildId, ModelBan ban) {
        String reason = ban.getReason();
        if (reason == null) {
            reason = getString(2131893237);
        }
        m.checkNotNullExpressionValue(reason, "ban.reason ?: getString(R.string.no_ban_reason)");
        StringBuilder sb = new StringBuilder();
        String string = getString(2131887003);
        m.checkNotNullExpressionValue(string, "getString(R.string.ban_reason)");
        Locale primaryLocale = new LocaleManager().getPrimaryLocale(getContext());
        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
        String upperCase = string.toUpperCase(primaryLocale);
        m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        sb.append(upperCase);
        sb.append("\n");
        sb.append(reason);
        WidgetNoticeDialog$Builder dialogAttrTheme = WidgetNoticeDialog$Builder.setNegativeButton$default(new WidgetNoticeDialog$Builder(requireContext()).setTitle(b.h(requireContext(), 2131896567, new Object[]{ban.getUser().getUsername()}, null, 4).toString()).setMessage(sb.toString()), 2131887437, (Function1) null, 2, (Object) null).setPositiveButton(2131896566, new WidgetServerSettingsBans$showConfirmUnbanDialog$1(this, guildId, ban)).setDialogAttrTheme(2130969885);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        dialogAttrTheme.show(parentFragmentManager);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.dialog = null;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BehaviorSubject<String> behaviorSubject = this.filterPublisher;
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsBansSearch");
        behaviorSubject.onNext(ViewExtensions.getTextOrEmpty(textInputLayout));
        TextInputLayout textInputLayout2 = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsBansSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new WidgetServerSettingsBans$onResume$1(this));
        WidgetServerSettingsBans$Model$Companion widgetServerSettingsBans$Model$Companion = WidgetServerSettingsBans$Model.Companion;
        long j = this.guildId;
        BehaviorSubject<String> behaviorSubject2 = this.filterPublisher;
        m.checkNotNullExpressionValue(behaviorSubject2, "filterPublisher");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(widgetServerSettingsBans$Model$Companion.get(j, behaviorSubject2), this, null, 2, null), WidgetServerSettingsBans.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsBans$onResume$2(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().f2544b;
        m.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsBansRecycler");
        this.adapter = (WidgetServerSettingsBans$Adapter) mGRecyclerAdapter$Companion.configure(new WidgetServerSettingsBans$Adapter(recyclerView));
        this.guildId = getMostRecentIntent().getLongExtra(INTENT_EXTRA_GUILD_ID, -1L);
    }
}
