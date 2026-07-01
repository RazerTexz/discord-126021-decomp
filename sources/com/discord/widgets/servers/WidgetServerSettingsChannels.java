package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsChannelsBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import com.discord.widgets.chat.AutocompleteUtils2;
import com.discord.widgets.servers.SettingsChannelListAdapter;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment;
import com.discord.widgets.servers.WidgetServerSettingsChannelsSortActions;
import com.discord.widgets.voice.settings.WidgetVoiceChannelSettings;
import d0.f0._Sequences2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func7;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannels extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsChannels.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsChannelsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private SettingsChannelListAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<Integer> channelSortTypeSubject;
    private final AppLogger2 loggingConfig;

    /* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed(AutocompleteUtils2.CHANNELS, guildId);
            Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsChannels.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Map<Long, Long> channelPermissions;
        private final Map<Long, Channel> channels;
        private final Guild guild;
        private final boolean isSorting;
        private final List<CategoricalDragAndDropAdapter.Payload> items;

        /* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId, Observable<Integer> channelTypeObservable) {
                Intrinsics3.checkNotNullParameter(channelTypeObservable, "channelTypeObservable");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableE = Observable.e(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForGuild(guildId), companion.getGuilds().observeGuild(guildId), StoreChannels.observeChannelsForGuild$default(companion.getChannels(), guildId, null, 2, null), companion.getChannels().observeChannelCategories(guildId), companion.getPermissions().observeChannelPermissionsForGuild(guildId), channelTypeObservable, new Func7<MeUser, Long, Guild, Map<Long, ? extends Channel>, List<? extends Channel>, Map<Long, ? extends Long>, Integer, Model>() { // from class: com.discord.widgets.servers.WidgetServerSettingsChannels$Model$Companion$get$1
                    @Override // rx.functions.Func7
                    public /* bridge */ /* synthetic */ WidgetServerSettingsChannels.Model call(MeUser meUser, Long l, Guild guild, Map<Long, ? extends Channel> map, List<? extends Channel> list, Map<Long, ? extends Long> map2, Integer num) {
                        return call2(meUser, l, guild, (Map<Long, Channel>) map, (List<Channel>) list, (Map<Long, Long>) map2, num);
                    }

                    /* JADX WARN: Code duplicated, block: B:31:0x00d6  */
                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final WidgetServerSettingsChannels.Model call2(MeUser meUser, Long l, Guild guild, Map<Long, Channel> map, List<Channel> list, Map<Long, Long> map2, Integer num) {
                        List list2;
                        List list3;
                        if (guild == null || l == null || map2 == null) {
                            return null;
                        }
                        WidgetServerSettingsChannels.Model.Companion companion2 = WidgetServerSettingsChannels.Model.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(map, "guildChannels");
                        Intrinsics3.checkNotNullExpressionValue(num, "sortType");
                        LinkedHashMap<Long, Channel> sortedGuildChannels = companion2.getSortedGuildChannels(map, num.intValue());
                        boolean z2 = num.intValue() != -1;
                        long j = 16;
                        boolean zCanAndIsElevated = PermissionUtils.canAndIsElevated(16L, l, meUser.getMfaEnabled(), guild.getMfaLevel());
                        ArrayList arrayList = new ArrayList();
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        HashSet hashSet = new HashSet();
                        if (!z2 || zCanAndIsElevated) {
                            hashSet.add(0L);
                            linkedHashMap.put(0L, new ArrayList());
                            List list4 = (List) linkedHashMap.get(0L);
                            if (list4 != null) {
                                list4.add(new SettingsChannelListAdapter.CategoryItem(null, 0L, 0, false, false, true));
                            }
                        }
                        Collections.sort(list, ChannelUtils.h(Channel.INSTANCE));
                        for (Channel channel : list) {
                            if (PermissionUtils.hasAccess(channel, map2) || channel.getId() == 0) {
                                ArrayList arrayList2 = new ArrayList();
                                boolean zCan = PermissionUtils.can(j, (Long) outline.d(channel, map2));
                                if (zCan || zCanAndIsElevated) {
                                    hashSet.add(Long.valueOf(channel.getId()));
                                }
                                if (!z2 || zCan) {
                                    arrayList2.add(new SettingsChannelListAdapter.CategoryItem(ChannelUtils.c(channel), channel.getId(), channel.getPosition(), num.intValue() == 4, zCanAndIsElevated, zCan));
                                    linkedHashMap.put(Long.valueOf(channel.getId()), arrayList2);
                                }
                            }
                            hashSet = hashSet;
                            j = 16;
                        }
                        HashSet hashSet2 = hashSet;
                        if (hashSet2.isEmpty()) {
                            return null;
                        }
                        ArrayList<SettingsChannelListAdapter.ChannelItem> arrayList3 = new ArrayList();
                        ArrayList<SettingsChannelListAdapter.ChannelItem> arrayList4 = new ArrayList();
                        Iterator<Channel> it = sortedGuildChannels.values().iterator();
                        while (it.hasNext()) {
                            Channel next = it.next();
                            Intrinsics3.checkNotNullExpressionValue(next, "channel");
                            LinkedHashMap linkedHashMap2 = linkedHashMap;
                            Iterator<Channel> it2 = it;
                            LinkedHashMap<Long, Channel> linkedHashMap3 = sortedGuildChannels;
                            HashSet hashSet3 = hashSet2;
                            SettingsChannelListAdapter.ChannelItem channelItem = new SettingsChannelListAdapter.ChannelItem(next, z2, next.getParentId(), hashSet2.contains(Long.valueOf(next.getParentId())));
                            if (!z2 || hashSet3.contains(Long.valueOf(next.getParentId()))) {
                                if (ChannelUtils.v(next) && PermissionUtils.hasAccess(next, map2)) {
                                    arrayList3.add(channelItem);
                                } else if (ChannelUtils.w(next) && PermissionUtils.hasAccess(next, map2)) {
                                    arrayList4.add(channelItem);
                                }
                            }
                            hashSet2 = hashSet3;
                            linkedHashMap = linkedHashMap2;
                            it = it2;
                            sortedGuildChannels = linkedHashMap3;
                        }
                        LinkedHashMap<Long, Channel> linkedHashMap4 = sortedGuildChannels;
                        LinkedHashMap linkedHashMap5 = linkedHashMap;
                        for (SettingsChannelListAdapter.ChannelItem channelItem2 : arrayList3) {
                            if (linkedHashMap5.containsKey(Long.valueOf(channelItem2.getChannel().getParentId())) && (list3 = (List) linkedHashMap5.get(Long.valueOf(channelItem2.getChannel().getParentId()))) != null) {
                                list3.add(channelItem2);
                            }
                        }
                        for (SettingsChannelListAdapter.ChannelItem channelItem3 : arrayList4) {
                            if (linkedHashMap5.containsKey(Long.valueOf(channelItem3.getChannel().getParentId())) && (list2 = (List) linkedHashMap5.get(Long.valueOf(channelItem3.getChannel().getParentId()))) != null) {
                                list2.add(channelItem3);
                            }
                        }
                        for (List list5 : linkedHashMap5.values()) {
                            Intrinsics3.checkNotNullExpressionValue(list5, "list");
                            arrayList.addAll(list5);
                        }
                        return new WidgetServerSettingsChannels.Model(guild, arrayList, z2, linkedHashMap4, map2);
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableE, "Observable\n            .…ermissions)\n            }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableE).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
                return observableR;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final LinkedHashMap<Long, Channel> getSortedGuildChannels(Map<Long, Channel> guildChannels, int channelType) {
                Intrinsics3.checkNotNullParameter(guildChannels, "guildChannels");
                LinkedHashMap<Long, Channel> linkedHashMap = new LinkedHashMap<>();
                for (Object obj : _Sequences2.sortedWith(_Sequences2.filter(_Collections.asSequence(guildChannels.values()), new WidgetServerSettingsChannels3(guildChannels, channelType)), ChannelUtils.h(Channel.INSTANCE))) {
                    linkedHashMap.put(Long.valueOf(((Channel) obj).getId()), obj);
                }
                return linkedHashMap;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Guild guild, List<? extends CategoricalDragAndDropAdapter.Payload> list, boolean z2, Map<Long, Channel> map, Map<Long, Long> map2) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(list, "items");
            Intrinsics3.checkNotNullParameter(map, "channels");
            Intrinsics3.checkNotNullParameter(map2, "channelPermissions");
            this.guild = guild;
            this.items = list;
            this.isSorting = z2;
            this.channels = map;
            this.channelPermissions = map2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, Guild guild, List list, boolean z2, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                list = model.items;
            }
            List list2 = list;
            if ((i & 4) != 0) {
                z2 = model.isSorting;
            }
            boolean z3 = z2;
            if ((i & 8) != 0) {
                map = model.channels;
            }
            Map map3 = map;
            if ((i & 16) != 0) {
                map2 = model.channelPermissions;
            }
            return model.copy(guild, list2, z3, map3, map2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final List<CategoricalDragAndDropAdapter.Payload> component2() {
            return this.items;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsSorting() {
            return this.isSorting;
        }

        public final Map<Long, Channel> component4() {
            return this.channels;
        }

        public final Map<Long, Long> component5() {
            return this.channelPermissions;
        }

        public final Model copy(Guild guild, List<? extends CategoricalDragAndDropAdapter.Payload> items, boolean isSorting, Map<Long, Channel> channels, Map<Long, Long> channelPermissions) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(items, "items");
            Intrinsics3.checkNotNullParameter(channels, "channels");
            Intrinsics3.checkNotNullParameter(channelPermissions, "channelPermissions");
            return new Model(guild, items, isSorting, channels, channelPermissions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.items, model.items) && this.isSorting == model.isSorting && Intrinsics3.areEqual(this.channels, model.channels) && Intrinsics3.areEqual(this.channelPermissions, model.channelPermissions);
        }

        public final Map<Long, Long> getChannelPermissions() {
            return this.channelPermissions;
        }

        public final Map<Long, Channel> getChannels() {
            return this.channels;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final List<CategoricalDragAndDropAdapter.Payload> getItems() {
            return this.items;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            List<CategoricalDragAndDropAdapter.Payload> list = this.items;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.isSorting;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode2 + r2) * 31;
            Map<Long, Channel> map = this.channels;
            int iHashCode3 = (i + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Long> map2 = this.channelPermissions;
            return iHashCode3 + (map2 != null ? map2.hashCode() : 0);
        }

        public final boolean isSorting() {
            return this.isSorting;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", items=");
            sbU.append(this.items);
            sbU.append(", isSorting=");
            sbU.append(this.isSorting);
            sbU.append(", channels=");
            sbU.append(this.channels);
            sbU.append(", channelPermissions=");
            return outline.M(sbU, this.channelPermissions, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsChannels widgetServerSettingsChannels) {
            super(1, widgetServerSettingsChannels, WidgetServerSettingsChannels.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsChannels$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            ((WidgetServerSettingsChannels) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$reorderChannels$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            AppToast.i(WidgetServerSettingsChannels.this, R.string.channel_order_updated, 0, 4);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$reorderChannels$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Model $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Model model) {
            super(1);
            this.$data = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) throws Exception {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) throws Exception {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetServerSettingsChannels.this.configureUI(this.$data);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$setOnClickListener$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$setOnClickListener$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            if (PermissionUtils.can(16L, this.$model.getChannelPermissions().get(Long.valueOf(j)))) {
                Channel channel = this.$model.getChannels().get(Long.valueOf(j));
                if (channel == null || !ChannelUtils.w(channel)) {
                    WidgetTextChannelSettings.INSTANCE.launch(j, WidgetServerSettingsChannels.this.requireContext());
                } else {
                    WidgetVoiceChannelSettings.INSTANCE.launch(j, WidgetServerSettingsChannels.this.requireContext());
                }
            }
        }
    }

    public WidgetServerSettingsChannels() {
        super(R.layout.widget_server_settings_channels);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsChannels4.INSTANCE, null, 2, null);
        this.channelSortTypeSubject = BehaviorSubject.l0(-1);
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsChannels6.INSTANCE, 3);
    }

    private final void configureFabVisibility(final Model model) {
        final WidgetServerSettingsChannels5 widgetServerSettingsChannels5 = new WidgetServerSettingsChannels5(this, model);
        widgetServerSettingsChannels5.invoke();
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsChannels.configureFabVisibility.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsChannelsFabMenuFragment.Companion companion = WidgetServerSettingsChannelsFabMenuFragment.INSTANCE;
                long id2 = model.getGuild().getId();
                FragmentManager childFragmentManager = WidgetServerSettingsChannels.this.getChildFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                companion.show(id2, childFragmentManager, new Action0() { // from class: com.discord.widgets.servers.WidgetServerSettingsChannels.configureFabVisibility.1.1
                    @Override // rx.functions.Action0
                    public final void call() {
                        widgetServerSettingsChannels5.invoke();
                    }
                });
                WidgetServerSettingsChannels.this.getBinding().c.hide();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void configureUI(final Model model) throws Exception {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        setActionBarDisplayHomeAsUpEnabled(!model.isSorting());
        setActionBarTitle(!model.isSorting() ? R.string.channels : R.string.sorting);
        setActionBarSubtitle(model.getGuild().getName());
        setActionBarOptionsMenu(R.menu.menu_channel_sort, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.servers.WidgetServerSettingsChannels.configureUI.1

            /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$configureUI$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
            public static final class C03061 extends Lambda implements Function1<Integer, Unit> {
                public C03061() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.a;
                }

                public final void invoke(int i) {
                    WidgetServerSettingsChannels.this.channelSortTypeSubject.onNext(Integer.valueOf(i));
                }
            }

            @Override // rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                switch (menuItem.getItemId()) {
                    case R.id.menu_sort_channel /* 2131364413 */:
                        WidgetServerSettingsChannelsSortActions.Companion companion = WidgetServerSettingsChannelsSortActions.INSTANCE;
                        FragmentManager childFragmentManager = WidgetServerSettingsChannels.this.getChildFragmentManager();
                        Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                        companion.show(childFragmentManager, new C03061());
                        break;
                    case R.id.menu_sort_done /* 2131364414 */:
                        WidgetServerSettingsChannels.this.channelSortTypeSubject.onNext(-1);
                        break;
                }
            }
        }, new Action1<Menu>() { // from class: com.discord.widgets.servers.WidgetServerSettingsChannels.configureUI.2
            @Override // rx.functions.Action1
            public final void call(Menu menu) {
                MenuItem menuItemFindItem = menu.findItem(R.id.menu_sort_channel);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_sort_channel)");
                menuItemFindItem.setVisible(!model.isSorting());
                MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_sort_done);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem2, "menu.findItem(R.id.menu_sort_done)");
                menuItemFindItem2.setVisible(model.isSorting());
            }
        });
        configureFabVisibility(model);
        SettingsChannelListAdapter settingsChannelListAdapter = this.adapter;
        if (settingsChannelListAdapter != null) {
            settingsChannelListAdapter.setData(model.getItems());
        }
        SettingsChannelListAdapter settingsChannelListAdapter2 = this.adapter;
        if (settingsChannelListAdapter2 != 0) {
            settingsChannelListAdapter2.setPositionUpdateListener(new Action1<Map<Long, ? extends SettingsChannelListAdapter.UpdatedPosition>>() { // from class: com.discord.widgets.servers.WidgetServerSettingsChannels.configureUI.3
                @Override // rx.functions.Action1
                public /* bridge */ /* synthetic */ void call(Map<Long, ? extends SettingsChannelListAdapter.UpdatedPosition> map) {
                    call2((Map<Long, SettingsChannelListAdapter.UpdatedPosition>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final void call2(Map<Long, SettingsChannelListAdapter.UpdatedPosition> map) {
                    WidgetServerSettingsChannels widgetServerSettingsChannels = WidgetServerSettingsChannels.this;
                    Model model2 = model;
                    Intrinsics3.checkNotNullExpressionValue(map, "newPositions");
                    widgetServerSettingsChannels.reorderChannels(model2, map);
                }
            });
        }
        SettingsChannelListAdapter settingsChannelListAdapter3 = this.adapter;
        if (settingsChannelListAdapter3 != null) {
            setOnClickListener(settingsChannelListAdapter3, model);
        }
    }

    private final WidgetServerSettingsChannelsBinding getBinding() {
        return (WidgetServerSettingsChannelsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void reorderChannels(Model data, Map<Long, SettingsChannelListAdapter.UpdatedPosition> newPositions) {
        ArrayList arrayList = new ArrayList(newPositions.size());
        for (Map.Entry<Long, SettingsChannelListAdapter.UpdatedPosition> entry : newPositions.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            SettingsChannelListAdapter.UpdatedPosition value = entry.getValue();
            arrayList.add(new RestAPIParams.ChannelPosition(jLongValue, value.getPosition(), value.getParentId()));
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSerializeNulls().reorderChannels(data.getGuild().getId(), arrayList), false, 1, null), getBinding().f2550b, 0L, 2, null), this, null, 2, null), (Class<?>) WidgetServerSettingsChannels.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2(data)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    private final void setOnClickListener(SettingsChannelListAdapter settingsChannelListAdapter, Model model) {
        settingsChannelListAdapter.setOnClickListener(model.isSorting() ? AnonymousClass1.INSTANCE : new AnonymousClass2(model));
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsChannelsTextRecycler");
        this.adapter = (SettingsChannelListAdapter) companion.configure(new SettingsChannelListAdapter(recyclerView, true));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra(INTENT_EXTRA_GUILD_ID, -1L);
        Model.Companion companion = Model.INSTANCE;
        BehaviorSubject<Integer> behaviorSubject = this.channelSortTypeSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "channelSortTypeSubject");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(companion.get(longExtra, behaviorSubject), this, null, 2, null), (Class<?>) WidgetServerSettingsChannels.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
