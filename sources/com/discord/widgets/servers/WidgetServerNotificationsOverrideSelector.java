package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
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
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.servers.SettingsChannelListAdapter;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.Strings4;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
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
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetServerNotificationsOverrideSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotificationsOverrideSelector extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerNotificationsOverrideSelector.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerNotificationOverrideSelectorBinding;", 0)};

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
            Observable observableI = Observable.i(StoreChannels.observeChannelsForGuild$default(StoreStream.INSTANCE.getChannels(), guildId, null, 2, null), GuildChannelsInfo.INSTANCE.get(guildId), ObservableExtensionsKt.leadingEdgeThrottle(filterPublisher, 100L, TimeUnit.MILLISECONDS), new Func3<Map<Long, ? extends Channel>, GuildChannelsInfo, String, List<? extends CategoricalDragAndDropAdapter.Payload>>() { // from class: com.discord.widgets.servers.WidgetServerNotificationsOverrideSelector$Companion$get$1
                @Override // rx.functions.Func3
                public /* bridge */ /* synthetic */ List<? extends CategoricalDragAndDropAdapter.Payload> call(Map<Long, ? extends Channel> map, GuildChannelsInfo guildChannelsInfo, String str) {
                    return call2((Map<Long, Channel>) map, guildChannelsInfo, str);
                }

                /* JADX WARN: Code duplicated, block: B:12:0x003c  */
                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final List<CategoricalDragAndDropAdapter.Payload> call2(Map<Long, Channel> map, GuildChannelsInfo guildChannelsInfo, String str) {
                    boolean z2;
                    Intrinsics3.checkNotNullExpressionValue(map, "channels");
                    List<Channel> sortedVisibleChannels = guildChannelsInfo.getSortedVisibleChannels(map);
                    ArrayList<Channel> arrayList = new ArrayList();
                    for (Object obj : sortedVisibleChannels) {
                        Channel channel = (Channel) obj;
                        if (ChannelUtils.F(channel) || ChannelUtils.k(channel)) {
                            String strC = ChannelUtils.c(channel);
                            Intrinsics3.checkNotNullExpressionValue(str, "filter");
                            z2 = Strings4.contains((CharSequence) strC, (CharSequence) str, true);
                        }
                        if (z2) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Channel channel2 : arrayList) {
                        DragAndDropAdapter.Payload categoryItem = ChannelUtils.k(channel2) ? new SettingsChannelListAdapter.CategoryItem(ChannelUtils.c(channel2), channel2.getId(), channel2.getPosition(), false, false, false) : ChannelUtils.F(channel2) ? new SettingsChannelListAdapter.ChannelItem(channel2, false, channel2.getParentId(), false) : null;
                        if (categoryItem != null) {
                            arrayList2.add(categoryItem);
                        }
                    }
                    return arrayList2;
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…              }\n        }");
            return ObservableExtensionsKt.computationBuffered(observableI).r();
        }

        public final void launch(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE….EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerNotificationsOverrideSelector.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerNotificationsOverrideSelector$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerNotificationsOverrideSelector.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetServerNotificationsOverrideSelector.this.filterPublisher.onNext(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerNotificationsOverrideSelector$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerNotificationsOverrideSelector.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            Context context = WidgetServerNotificationsOverrideSelector.this.getContext();
            if (context != null) {
                WidgetChannelNotificationSettings.Companion companion = WidgetChannelNotificationSettings.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(context, "it");
                WidgetChannelNotificationSettings.Companion.launch$default(companion, context, j, false, 4, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerNotificationsOverrideSelector$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerNotificationsOverrideSelector.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends CategoricalDragAndDropAdapter.Payload>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends CategoricalDragAndDropAdapter.Payload> list) {
            invoke2(list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends CategoricalDragAndDropAdapter.Payload> list) {
            SettingsChannelListAdapter settingsChannelListAdapterAccess$getChannelsAdapter$p = WidgetServerNotificationsOverrideSelector.access$getChannelsAdapter$p(WidgetServerNotificationsOverrideSelector.this);
            Intrinsics3.checkNotNullExpressionValue(list, "it");
            settingsChannelListAdapterAccess$getChannelsAdapter$p.setData(_Collections.toMutableList((Collection) list));
        }
    }

    public WidgetServerNotificationsOverrideSelector() {
        super(R.layout.widget_server_notification_override_selector);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerNotificationsOverrideSelector3.INSTANCE, null, 2, null);
        this.filterPublisher = BehaviorSubject.l0("");
    }

    public static final /* synthetic */ SettingsChannelListAdapter access$getChannelsAdapter$p(WidgetServerNotificationsOverrideSelector widgetServerNotificationsOverrideSelector) {
        SettingsChannelListAdapter settingsChannelListAdapter = widgetServerNotificationsOverrideSelector.channelsAdapter;
        if (settingsChannelListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("channelsAdapter");
        }
        return settingsChannelListAdapter;
    }

    private final WidgetServerNotificationOverrideSelectorBinding getBinding() {
        return (WidgetServerNotificationOverrideSelectorBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.notification_overrides);
        setActionBarSubtitle(R.string.select_channel_or_category);
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildNotificationsChannelSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass1());
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2537b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildNotificationsChannelList");
        SettingsChannelListAdapter settingsChannelListAdapter = (SettingsChannelListAdapter) companion.configure(new SettingsChannelListAdapter(recyclerView, false));
        this.channelsAdapter = settingsChannelListAdapter;
        if (settingsChannelListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("channelsAdapter");
        }
        settingsChannelListAdapter.setOnClickListener(new AnonymousClass2());
        RecyclerView recyclerView2 = getBinding().f2537b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.guildNotificationsChannelList");
        recyclerView2.setNestedScrollingEnabled(false);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        Companion companion = INSTANCE;
        BehaviorSubject<String> behaviorSubject = this.filterPublisher;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "filterPublisher");
        Observable observable = companion.get(longExtra, behaviorSubject);
        Intrinsics3.checkNotNullExpressionValue(observable, "get(guildId, filterPublisher)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) WidgetServerNotificationsOverrideSelector.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
