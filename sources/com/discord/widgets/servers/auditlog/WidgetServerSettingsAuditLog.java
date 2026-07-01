package com.discord.widgets.servers.auditlog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsAuditLogBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLog extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsAuditLog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsAuditLogBinding;", 0)};
    public static final WidgetServerSettingsAuditLog$Companion Companion = new WidgetServerSettingsAuditLog$Companion(null);
    private static final int DIRECTION_DOWN = 1;
    private static final String INTENT_EXTRA_GUILD_ID = "GUILD_ID";
    private static final String INTENT_EXTRA_GUILD_NAME = "GUILD_NAME";
    private static final int RESULTS_VIEW_INDEX_LOGS = 0;
    private static final int RESULTS_VIEW_INDEX_NO_LOGS = 1;
    private static final int VIEW_INDEX_LOGS_CONTENT = 1;
    private static final int VIEW_INDEX_LOGS_LOADING = 0;
    private WidgetServerSettingsAuditLogAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long guildId;
    private boolean loadingAuditLogs;
    private final LoggingConfig loggingConfig;

    public WidgetServerSettingsAuditLog() {
        super(R$layout.widget_server_settings_audit_log);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsAuditLog$binding$2.INSTANCE, null, 2, null);
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsAuditLog$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsAuditLog widgetServerSettingsAuditLog, WidgetServerSettingsAuditLog$Model widgetServerSettingsAuditLog$Model) {
        widgetServerSettingsAuditLog.configureUI(widgetServerSettingsAuditLog$Model);
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsAuditLog widgetServerSettingsAuditLog) {
        return widgetServerSettingsAuditLog.guildId;
    }

    public static final /* synthetic */ void access$setGuildId$p(WidgetServerSettingsAuditLog widgetServerSettingsAuditLog, long j) {
        widgetServerSettingsAuditLog.guildId = j;
    }

    private final void configureUI(WidgetServerSettingsAuditLog$Model model) {
        if (model instanceof WidgetServerSettingsAuditLog$Model$Loading) {
            AppViewFlipper appViewFlipper = getBinding().e;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsAuditLogsViewFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (model instanceof WidgetServerSettingsAuditLog$Model$Loaded) {
            WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter = this.adapter;
            if (widgetServerSettingsAuditLogAdapter != null) {
                widgetServerSettingsAuditLogAdapter.configure(((WidgetServerSettingsAuditLog$Model$Loaded) model).getAuditLogEntryItems());
            }
            AppViewFlipper appViewFlipper2 = getBinding().e;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.serverSettingsAuditLogsViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            TextView textView = getBinding().d;
            m.checkNotNullExpressionValue(textView, "binding.serverSettingsAuditLogsUserFilter");
            WidgetServerSettingsAuditLog$Model$Loaded widgetServerSettingsAuditLog$Model$Loaded = (WidgetServerSettingsAuditLog$Model$Loaded) model;
            textView.setText(widgetServerSettingsAuditLog$Model$Loaded.getUsernameFilterText());
            TextView textView2 = getBinding().f2539b;
            m.checkNotNullExpressionValue(textView2, "binding.serverSettingsAuditLogsActionFilter");
            textView2.setText(widgetServerSettingsAuditLog$Model$Loaded.getActionFilterText());
            if (!widgetServerSettingsAuditLog$Model$Loaded.getAuditLogEntryItems().isEmpty()) {
                AppViewFlipper appViewFlipper3 = getBinding().f;
                m.checkNotNullExpressionValue(appViewFlipper3, "binding.serverSettingsAuditLogsViewResultsFlipper");
                appViewFlipper3.setDisplayedChild(0);
            } else {
                AppViewFlipper appViewFlipper4 = getBinding().f;
                m.checkNotNullExpressionValue(appViewFlipper4, "binding.serverSettingsAuditLogsViewResultsFlipper");
                appViewFlipper4.setDisplayedChild(1);
            }
            this.loadingAuditLogs = false;
        }
    }

    public static final void create(Context context, long j, String str) {
        Companion.create(context, j, str);
    }

    private final WidgetServerSettingsAuditLogBinding getBinding() {
        return (WidgetServerSettingsAuditLogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        FragmentActivity activity = getActivity();
        if (activity != null && activity.isFinishing()) {
            StoreStream.Companion.getAuditLog().clearState();
        }
        super.onDestroy();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        long longExtra = getMostRecentIntent().getLongExtra(INTENT_EXTRA_GUILD_ID, -1L);
        this.guildId = longExtra;
        if (longExtra == -1) {
            b.a.d.m.g(getContext(), 2131888216, 0, null, 12);
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }
        setActionBarTitle(2131891231);
        setActionBarSubtitle(getMostRecentIntent().getStringExtra(INTENT_EXTRA_GUILD_NAME));
        setActionBarOptionsMenu(R$menu.menu_filter, null, new WidgetServerSettingsAuditLog$onViewBound$1(this));
        getBinding().c.addOnScrollListener(new WidgetServerSettingsAuditLog$onViewBound$2());
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsAuditLogsRecycler");
        WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter = (WidgetServerSettingsAuditLogAdapter) mGRecyclerAdapter$Companion.configure(new WidgetServerSettingsAuditLogAdapter(recyclerView));
        widgetServerSettingsAuditLogAdapter.setOnAuditLogAvatarClicked(new WidgetServerSettingsAuditLog$onViewBound$$inlined$apply$lambda$1(this));
        this.adapter = widgetServerSettingsAuditLogAdapter;
        getBinding().d.setOnClickListener(new WidgetServerSettingsAuditLog$onViewBound$4(this));
        getBinding().f2539b.setOnClickListener(new WidgetServerSettingsAuditLog$onViewBound$5(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(WidgetServerSettingsAuditLog$Model.Companion.get(this.guildId, requireContext())), this, null, 2, null), WidgetServerSettingsAuditLog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsAuditLog$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
