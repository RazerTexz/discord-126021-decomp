package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsChannelsBinding;
import com.discord.restapi.RestAPIParams$ChannelPosition;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannels extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsChannels.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsChannelsBinding;", 0)};
    public static final WidgetServerSettingsChannels$Companion Companion = new WidgetServerSettingsChannels$Companion(null);
    public static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private SettingsChannelListAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<Integer> channelSortTypeSubject;
    private final LoggingConfig loggingConfig;

    public WidgetServerSettingsChannels() {
        super(R$layout.widget_server_settings_channels);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsChannels$binding$2.INSTANCE, null, 2, null);
        this.channelSortTypeSubject = BehaviorSubject.l0(-1);
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsChannels$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsChannels widgetServerSettingsChannels, WidgetServerSettingsChannels$Model widgetServerSettingsChannels$Model) throws Exception {
        widgetServerSettingsChannels.configureUI(widgetServerSettingsChannels$Model);
    }

    public static final /* synthetic */ WidgetServerSettingsChannelsBinding access$getBinding$p(WidgetServerSettingsChannels widgetServerSettingsChannels) {
        return widgetServerSettingsChannels.getBinding();
    }

    public static final /* synthetic */ BehaviorSubject access$getChannelSortTypeSubject$p(WidgetServerSettingsChannels widgetServerSettingsChannels) {
        return widgetServerSettingsChannels.channelSortTypeSubject;
    }

    public static final /* synthetic */ void access$reorderChannels(WidgetServerSettingsChannels widgetServerSettingsChannels, WidgetServerSettingsChannels$Model widgetServerSettingsChannels$Model, Map map) {
        widgetServerSettingsChannels.reorderChannels(widgetServerSettingsChannels$Model, map);
    }

    private final void configureFabVisibility(WidgetServerSettingsChannels$Model model) {
        WidgetServerSettingsChannels$configureFabVisibility$setFabVisibility$1 widgetServerSettingsChannels$configureFabVisibility$setFabVisibility$1 = new WidgetServerSettingsChannels$configureFabVisibility$setFabVisibility$1(this, model);
        widgetServerSettingsChannels$configureFabVisibility$setFabVisibility$1.invoke();
        getBinding().c.setOnClickListener(new WidgetServerSettingsChannels$configureFabVisibility$1(this, model, widgetServerSettingsChannels$configureFabVisibility$setFabVisibility$1));
    }

    private final void configureUI(WidgetServerSettingsChannels$Model model) throws Exception {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        setActionBarDisplayHomeAsUpEnabled(!model.isSorting());
        setActionBarTitle(!model.isSorting() ? 2131887633 : 2131895681);
        setActionBarSubtitle(model.getGuild().getName());
        setActionBarOptionsMenu(R$menu.menu_channel_sort, new WidgetServerSettingsChannels$configureUI$1(this), new WidgetServerSettingsChannels$configureUI$2(model));
        configureFabVisibility(model);
        SettingsChannelListAdapter settingsChannelListAdapter = this.adapter;
        if (settingsChannelListAdapter != null) {
            settingsChannelListAdapter.setData(model.getItems());
        }
        SettingsChannelListAdapter settingsChannelListAdapter2 = this.adapter;
        if (settingsChannelListAdapter2 != null) {
            settingsChannelListAdapter2.setPositionUpdateListener(new WidgetServerSettingsChannels$configureUI$3(this, model));
        }
        SettingsChannelListAdapter settingsChannelListAdapter3 = this.adapter;
        if (settingsChannelListAdapter3 != null) {
            setOnClickListener(settingsChannelListAdapter3, model);
        }
    }

    private final WidgetServerSettingsChannelsBinding getBinding() {
        return (WidgetServerSettingsChannelsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void reorderChannels(WidgetServerSettingsChannels$Model data, Map<Long, SettingsChannelListAdapter$UpdatedPosition> newPositions) {
        ArrayList arrayList = new ArrayList(newPositions.size());
        for (Map$Entry<Long, SettingsChannelListAdapter$UpdatedPosition> map$Entry : newPositions.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            SettingsChannelListAdapter$UpdatedPosition value = map$Entry.getValue();
            arrayList.add(new RestAPIParams$ChannelPosition(jLongValue, value.getPosition(), value.getParentId()));
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApiSerializeNulls().reorderChannels(data.getGuild().getId(), arrayList), false, 1, null), getBinding().f2550b, 0L, 2, null), this, null, 2, null), WidgetServerSettingsChannels.class, getContext(), (Function1) null, new WidgetServerSettingsChannels$reorderChannels$2(this, data), (Function0) null, (Function0) null, new WidgetServerSettingsChannels$reorderChannels$1(this), 52, (Object) null);
    }

    private final void setOnClickListener(SettingsChannelListAdapter settingsChannelListAdapter, WidgetServerSettingsChannels$Model widgetServerSettingsChannels$Model) {
        settingsChannelListAdapter.setOnClickListener(widgetServerSettingsChannels$Model.isSorting() ? WidgetServerSettingsChannels$setOnClickListener$1.INSTANCE : new WidgetServerSettingsChannels$setOnClickListener$2(this, widgetServerSettingsChannels$Model));
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().d;
        m.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsChannelsTextRecycler");
        this.adapter = (SettingsChannelListAdapter) mGRecyclerAdapter$Companion.configure(new SettingsChannelListAdapter(recyclerView, true));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra(INTENT_EXTRA_GUILD_ID, -1L);
        WidgetServerSettingsChannels$Model$Companion widgetServerSettingsChannels$Model$Companion = WidgetServerSettingsChannels$Model.Companion;
        BehaviorSubject<Integer> behaviorSubject = this.channelSortTypeSubject;
        m.checkNotNullExpressionValue(behaviorSubject, "channelSortTypeSubject");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(widgetServerSettingsChannels$Model$Companion.get(longExtra, behaviorSubject), this, null, 2, null), WidgetServerSettingsChannels.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsChannels$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
