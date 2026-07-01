package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerNotificationOverrideSelectorBinding;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetServerNotificationsOverrideSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotificationsOverrideSelector extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerNotificationsOverrideSelector.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerNotificationOverrideSelectorBinding;", 0)};
    public static final WidgetServerNotificationsOverrideSelector$Companion Companion = new WidgetServerNotificationsOverrideSelector$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private SettingsChannelListAdapter channelsAdapter;
    private final BehaviorSubject<String> filterPublisher;

    public WidgetServerNotificationsOverrideSelector() {
        super(R$layout.widget_server_notification_override_selector);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerNotificationsOverrideSelector$binding$2.INSTANCE, null, 2, null);
        this.filterPublisher = BehaviorSubject.l0("");
    }

    public static final /* synthetic */ SettingsChannelListAdapter access$getChannelsAdapter$p(WidgetServerNotificationsOverrideSelector widgetServerNotificationsOverrideSelector) {
        SettingsChannelListAdapter settingsChannelListAdapter = widgetServerNotificationsOverrideSelector.channelsAdapter;
        if (settingsChannelListAdapter == null) {
            m.throwUninitializedPropertyAccessException("channelsAdapter");
        }
        return settingsChannelListAdapter;
    }

    public static final /* synthetic */ BehaviorSubject access$getFilterPublisher$p(WidgetServerNotificationsOverrideSelector widgetServerNotificationsOverrideSelector) {
        return widgetServerNotificationsOverrideSelector.filterPublisher;
    }

    public static final /* synthetic */ void access$setChannelsAdapter$p(WidgetServerNotificationsOverrideSelector widgetServerNotificationsOverrideSelector, SettingsChannelListAdapter settingsChannelListAdapter) {
        widgetServerNotificationsOverrideSelector.channelsAdapter = settingsChannelListAdapter;
    }

    private final WidgetServerNotificationOverrideSelectorBinding getBinding() {
        return (WidgetServerNotificationOverrideSelectorBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(2131893377);
        setActionBarSubtitle(2131895397);
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildNotificationsChannelSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetServerNotificationsOverrideSelector$onViewBound$1(this));
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().f2537b;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildNotificationsChannelList");
        SettingsChannelListAdapter settingsChannelListAdapter = (SettingsChannelListAdapter) mGRecyclerAdapter$Companion.configure(new SettingsChannelListAdapter(recyclerView, false));
        this.channelsAdapter = settingsChannelListAdapter;
        if (settingsChannelListAdapter == null) {
            m.throwUninitializedPropertyAccessException("channelsAdapter");
        }
        settingsChannelListAdapter.setOnClickListener(new WidgetServerNotificationsOverrideSelector$onViewBound$2(this));
        RecyclerView recyclerView2 = getBinding().f2537b;
        m.checkNotNullExpressionValue(recyclerView2, "binding.guildNotificationsChannelList");
        recyclerView2.setNestedScrollingEnabled(false);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        WidgetServerNotificationsOverrideSelector$Companion widgetServerNotificationsOverrideSelector$Companion = Companion;
        BehaviorSubject<String> behaviorSubject = this.filterPublisher;
        m.checkNotNullExpressionValue(behaviorSubject, "filterPublisher");
        Observable observableAccess$get = WidgetServerNotificationsOverrideSelector$Companion.access$get(widgetServerNotificationsOverrideSelector$Companion, longExtra, behaviorSubject);
        m.checkNotNullExpressionValue(observableAccess$get, "get(guildId, filterPublisher)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableAccess$get, this, null, 2, null), WidgetServerNotificationsOverrideSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerNotificationsOverrideSelector$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
