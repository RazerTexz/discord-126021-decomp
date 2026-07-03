package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerNotificationOverrideSelectorBinding;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter;
import com.discord.utilities.mg_recycler.DragAndDropAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.servers.SettingsChannelListAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func3;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetServerNotificationsOverrideSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotificationsOverrideSelector extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerNotificationsOverrideSelector.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerNotificationOverrideSelectorBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private SettingsChannelListAdapter channelsAdapter;
    private final BehaviorSubject<String> filterPublisher;

    /* JADX INFO: compiled from: WidgetServerNotificationsOverrideSelector.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<List<CategoricalDragAndDropAdapter.Payload>> get(long guildId, BehaviorSubject<String> filterPublisher) {
            Observable observableM11075i = Observable.m11075i(StoreChannels.observeChannelsForGuild$default(StoreStream.INSTANCE.getChannels(), guildId, null, 2, null), GuildChannelsInfo.INSTANCE.get(guildId), ObservableExtensionsKt.leadingEdgeThrottle(filterPublisher, 100L, TimeUnit.MILLISECONDS), new Func3<Map<Long, ? extends Channel>, GuildChannelsInfo, String, List<? extends CategoricalDragAndDropAdapter.Payload>>() { // from class: com.discord.widgets.servers.WidgetServerNotificationsOverrideSelector$Companion$get$1
                @Override // p658rx.functions.Func3
                public /* bridge */ /* synthetic */ List<? extends CategoricalDragAndDropAdapter.Payload> call(Map<Long, ? extends Channel> map, GuildChannelsInfo guildChannelsInfo, String str) {
                    return call2((Map<Long, Channel>) map, guildChannelsInfo, str);
                }

                /* JADX WARN: Code duplicated, block: B:12:0x003c  */
                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final List<CategoricalDragAndDropAdapter.Payload> call2(Map<Long, Channel> map, GuildChannelsInfo guildChannelsInfo, String str) {
                    boolean z2;
                    C12238m.checkNotNullExpressionValue(map, "channels");
                    List<Channel> sortedVisibleChannels = guildChannelsInfo.getSortedVisibleChannels(map);
                    ArrayList<Channel> arrayList = new ArrayList();
                    for (Object obj : sortedVisibleChannels) {
                        Channel channel = (Channel) obj;
                        if (ChannelUtils.m7671F(channel) || ChannelUtils.m7687k(channel)) {
                            String strM7679c = ChannelUtils.m7679c(channel);
                            C12238m.checkNotNullExpressionValue(str, "filter");
                            z2 = C12106w.contains((CharSequence) strM7679c, (CharSequence) str, true);
                        }
                        if (z2) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Channel channel2 : arrayList) {
                        DragAndDropAdapter.Payload categoryItem = ChannelUtils.m7687k(channel2) ? new SettingsChannelListAdapter.CategoryItem(ChannelUtils.m7679c(channel2), channel2.getId(), channel2.getPosition(), false, false, false) : ChannelUtils.m7671F(channel2) ? new SettingsChannelListAdapter.ChannelItem(channel2, false, channel2.getParentId(), false) : null;
                        if (categoryItem != null) {
                            arrayList2.add(categoryItem);
                        }
                    }
                    return arrayList2;
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest…              }\n        }");
            return ObservableExtensionsKt.computationBuffered(observableM11075i).m11112r();
        }

        public final void launch(Context context, long guildId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE….EXTRA_GUILD_ID, guildId)");
            C0870j.m156d(context, WidgetServerNotificationsOverrideSelector.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerNotificationsOverrideSelector$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetServerNotificationsOverrideSelector.kt */
    public static final class C91671 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C91671() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "editable");
            WidgetServerNotificationsOverrideSelector.this.filterPublisher.onNext(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerNotificationsOverrideSelector$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetServerNotificationsOverrideSelector.kt */
    public static final class C91682 extends AbstractC12240o implements Function1<Long, Unit> {
        public C91682() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            Context context = WidgetServerNotificationsOverrideSelector.this.getContext();
            if (context != null) {
                WidgetChannelNotificationSettings.Companion companion = WidgetChannelNotificationSettings.INSTANCE;
                C12238m.checkNotNullExpressionValue(context, "it");
                WidgetChannelNotificationSettings.Companion.launch$default(companion, context, j, false, 4, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerNotificationsOverrideSelector$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerNotificationsOverrideSelector.kt */
    public static final class C91691 extends AbstractC12240o implements Function1<List<? extends CategoricalDragAndDropAdapter.Payload>, Unit> {
        public C91691() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends CategoricalDragAndDropAdapter.Payload> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends CategoricalDragAndDropAdapter.Payload> list) {
            SettingsChannelListAdapter settingsChannelListAdapterAccess$getChannelsAdapter$p = WidgetServerNotificationsOverrideSelector.access$getChannelsAdapter$p(WidgetServerNotificationsOverrideSelector.this);
            C12238m.checkNotNullExpressionValue(list, "it");
            settingsChannelListAdapterAccess$getChannelsAdapter$p.setData(C12163u.toMutableList((Collection) list));
        }
    }

    public WidgetServerNotificationsOverrideSelector() {
        super(C5419R.layout.widget_server_notification_override_selector);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerNotificationsOverrideSelector$binding$2.INSTANCE, null, 2, null);
        this.filterPublisher = BehaviorSubject.m11130l0("");
    }

    public static final /* synthetic */ SettingsChannelListAdapter access$getChannelsAdapter$p(WidgetServerNotificationsOverrideSelector widgetServerNotificationsOverrideSelector) {
        SettingsChannelListAdapter settingsChannelListAdapter = widgetServerNotificationsOverrideSelector.channelsAdapter;
        if (settingsChannelListAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("channelsAdapter");
        }
        return settingsChannelListAdapter;
    }

    private final WidgetServerNotificationOverrideSelectorBinding getBinding() {
        return (WidgetServerNotificationOverrideSelectorBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.notification_overrides);
        setActionBarSubtitle(C5419R.string.select_channel_or_category);
        TextInputLayout textInputLayout = getBinding().f17488c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.guildNotificationsChannelSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C91671());
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f17487b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.guildNotificationsChannelList");
        SettingsChannelListAdapter settingsChannelListAdapter = (SettingsChannelListAdapter) companion.configure(new SettingsChannelListAdapter(recyclerView, false));
        this.channelsAdapter = settingsChannelListAdapter;
        if (settingsChannelListAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("channelsAdapter");
        }
        settingsChannelListAdapter.setOnClickListener(new C91682());
        RecyclerView recyclerView2 = getBinding().f17487b;
        C12238m.checkNotNullExpressionValue(recyclerView2, "binding.guildNotificationsChannelList");
        recyclerView2.setNestedScrollingEnabled(false);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        Companion companion = INSTANCE;
        BehaviorSubject<String> behaviorSubject = this.filterPublisher;
        C12238m.checkNotNullExpressionValue(behaviorSubject, "filterPublisher");
        Observable observable = companion.get(longExtra, behaviorSubject);
        C12238m.checkNotNullExpressionValue(observable, "get(guildId, filterPublisher)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) WidgetServerNotificationsOverrideSelector.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C91691());
    }
}
