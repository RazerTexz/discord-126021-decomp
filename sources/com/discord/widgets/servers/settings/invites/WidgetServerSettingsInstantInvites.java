package com.discord.widgets.servers.settings.invites;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.User;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsInstantInvitesBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvites extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsInstantInvites.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsInstantInvitesBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final int VIEW_INDEX_INVITES_LIST = 1;
    private static final int VIEW_INDEX_INVITES_LOADING = 0;
    private static final int VIEW_INDEX_NO_INVITES = 2;
    private Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final LoggingConfig loggingConfig;
    private final StoreInstantInvites storeInstantInvites;

    /* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
    public static final class Adapter extends MGRecyclerAdapterSimple<Model.InviteItem> {
        private Function1<? super ModelInvite, Unit> onInviteExpiredListener;
        private Function1<? super ModelInvite, Unit> onInviteSelectedListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            C12238m.checkNotNullParameter(recyclerView, "recycler");
            this.onInviteSelectedListener = C9582xad423dea.INSTANCE;
            this.onInviteExpiredListener = C9581x3952eed8.INSTANCE;
        }

        public final void configure(List<Model.InviteItem> data, Function1<? super ModelInvite, Unit> onInviteSelectedListener, Function1<? super ModelInvite, Unit> onInviteExpiredListener) {
            C12238m.checkNotNullParameter(data, "data");
            C12238m.checkNotNullParameter(onInviteSelectedListener, "onInviteSelectedListener");
            C12238m.checkNotNullParameter(onInviteExpiredListener, "onInviteExpiredListener");
            this.onInviteSelectedListener = onInviteSelectedListener;
            this.onInviteExpiredListener = onInviteExpiredListener;
            setData(data);
        }

        public final void onInviteExpired(ModelInvite invite) {
            C12238m.checkNotNullParameter(invite, "invite");
            this.onInviteExpiredListener.invoke(invite);
        }

        public final void onInviteSelected(ModelInvite invite) {
            C12238m.checkNotNullParameter(invite, "invite");
            this.onInviteSelectedListener.invoke(invite);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<?, Model.InviteItem> onCreateViewHolder(ViewGroup parent, int viewType) {
            C12238m.checkNotNullParameter(parent, "parent");
            if (viewType == 0) {
                return new WidgetServerSettingsInstantInvitesListItem(this);
            }
            throw invalidViewTypeException(viewType);
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            C12238m.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("INSTANT_INVITES", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            C0870j.m156d(context, WidgetServerSettingsInstantInvites.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Guild guild;
        private final List<InviteItem> inviteItems;

        /* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
        public static final class Companion {
            private Companion() {
            }

            public static /* synthetic */ Observable get$default(Companion companion, long j, StoreGuilds storeGuilds, StoreInstantInvites storeInstantInvites, int i, Object obj) {
                if ((i & 2) != 0) {
                    storeGuilds = StoreStream.INSTANCE.getGuilds();
                }
                if ((i & 4) != 0) {
                    storeInstantInvites = StoreStream.INSTANCE.getInstantInvites();
                }
                return companion.get(j, storeGuilds, storeInstantInvites);
            }

            public final Observable<Model> get(long guildId, StoreGuilds storeGuilds, StoreInstantInvites storeInstantInvites) {
                C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
                C12238m.checkNotNullParameter(storeInstantInvites, "storeInstantInvites");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck.UpdateSource[]{storeGuilds, storeInstantInvites}, false, null, null, new WidgetServerSettingsInstantInvites$Model$Companion$get$1(storeGuilds, guildId, storeInstantInvites), 14, null)).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "ObservationDeckProvider.…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
        public static final /* data */ class InviteItem implements MGRecyclerDataPayload, Comparable<InviteItem> {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            public static final int TYPE_INVITE = 0;
            private final long guildId;
            private final GuildMember guildMember;
            private final ModelInvite invite;
            private final String key;
            private final int type;

            /* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
            public static final class Companion {
                private Companion() {
                }

                public final List<InviteItem> createList(Map<String, ? extends ModelInvite> invites, long guildId, Map<Long, GuildMember> guildMembers) {
                    C12238m.checkNotNullParameter(invites, "invites");
                    C12238m.checkNotNullParameter(guildMembers, "guildMembers");
                    Collection<? extends ModelInvite> collectionValues = invites.values();
                    ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(collectionValues, 10));
                    for (ModelInvite modelInvite : collectionValues) {
                        User inviter = modelInvite.getInviter();
                        arrayList.add(new InviteItem(modelInvite, guildId, inviter != null ? guildMembers.get(Long.valueOf(inviter.getId())) : null));
                    }
                    return C12163u.sorted(arrayList);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public InviteItem(ModelInvite modelInvite, long j, GuildMember guildMember) {
                C12238m.checkNotNullParameter(modelInvite, "invite");
                this.invite = modelInvite;
                this.guildId = j;
                this.guildMember = guildMember;
                String str = modelInvite.code;
                C12238m.checkNotNullExpressionValue(str, "invite.code");
                this.key = str;
            }

            public static /* synthetic */ InviteItem copy$default(InviteItem inviteItem, ModelInvite modelInvite, long j, GuildMember guildMember, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvite = inviteItem.invite;
                }
                if ((i & 2) != 0) {
                    j = inviteItem.guildId;
                }
                if ((i & 4) != 0) {
                    guildMember = inviteItem.guildMember;
                }
                return inviteItem.copy(modelInvite, j, guildMember);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelInvite getInvite() {
                return this.invite;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            public final InviteItem copy(ModelInvite invite, long guildId, GuildMember guildMember) {
                C12238m.checkNotNullParameter(invite, "invite");
                return new InviteItem(invite, guildId, guildMember);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof InviteItem)) {
                    return false;
                }
                InviteItem inviteItem = (InviteItem) other;
                return C12238m.areEqual(this.invite, inviteItem.invite) && this.guildId == inviteItem.guildId && C12238m.areEqual(this.guildMember, inviteItem.guildMember);
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            public final ModelInvite getInvite() {
                return this.invite;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                ModelInvite modelInvite = this.invite;
                int iM3a = (C0002b.m3a(this.guildId) + ((modelInvite != null ? modelInvite.hashCode() : 0) * 31)) * 31;
                GuildMember guildMember = this.guildMember;
                return iM3a + (guildMember != null ? guildMember.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("InviteItem(invite=");
                sbM833U.append(this.invite);
                sbM833U.append(", guildId=");
                sbM833U.append(this.guildId);
                sbM833U.append(", guildMember=");
                sbM833U.append(this.guildMember);
                sbM833U.append(")");
                return sbM833U.toString();
            }

            @Override // java.lang.Comparable
            public int compareTo(InviteItem other) {
                String username;
                String username2;
                C12238m.checkNotNullParameter(other, "other");
                Channel channel = this.invite.getChannel();
                String strM7679c = channel != null ? ChannelUtils.m7679c(channel) : null;
                Channel channel2 = other.invite.getChannel();
                String strM7679c2 = channel2 != null ? ChannelUtils.m7679c(channel2) : null;
                int iCompareTo = (strM7679c == null || strM7679c2 == null) ? 0 : C12103t.compareTo(strM7679c, strM7679c2, true);
                User inviter = this.invite.getInviter();
                User inviter2 = other.invite.getInviter();
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                UserUtils userUtils = UserUtils.INSTANCE;
                if (inviter == null || (username = inviter.getUsername()) == null) {
                    username = "";
                }
                if (inviter2 == null || (username2 = inviter2.getUsername()) == null) {
                    username2 = "";
                }
                return userUtils.compareUserNames(username, username2, null, null, inviter != null ? inviter.getId() : 0L, inviter2 != null ? inviter2.getId() : 0L);
            }
        }

        public Model(Guild guild, List<InviteItem> list) {
            C12238m.checkNotNullParameter(guild, "guild");
            this.guild = guild;
            this.inviteItems = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, Guild guild, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                list = model.inviteItems;
            }
            return model.copy(guild, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final List<InviteItem> component2() {
            return this.inviteItems;
        }

        public final Model copy(Guild guild, List<InviteItem> inviteItems) {
            C12238m.checkNotNullParameter(guild, "guild");
            return new Model(guild, inviteItems);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.guild, model.guild) && C12238m.areEqual(this.inviteItems, model.inviteItems);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final List<InviteItem> getInviteItems() {
            return this.inviteItems;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            List<InviteItem> list = this.inviteItems;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", inviteItems=");
            return C1643a.m824L(sbM833U, this.inviteItems, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites$configureUI$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
    public static final class C95831 extends AbstractC12240o implements Function1<ModelInvite, Unit> {
        public C95831() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            C12238m.checkNotNullParameter(modelInvite, "invite");
            WidgetServerSettingsInstantInvitesActions.Companion companion = WidgetServerSettingsInstantInvitesActions.INSTANCE;
            FragmentManager parentFragmentManager = WidgetServerSettingsInstantInvites.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            String str = modelInvite.code;
            C12238m.checkNotNullExpressionValue(str, "invite.code");
            companion.create(parentFragmentManager, str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites$configureUI$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
    public static final class C95842 extends AbstractC12240o implements Function1<ModelInvite, Unit> {
        public static final C95842 INSTANCE = new C95842();

        public C95842() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            C12238m.checkNotNullParameter(modelInvite, "invite");
            StoreStream.INSTANCE.getInstantInvites().onInviteRemoved(modelInvite);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
    public static final /* synthetic */ class C95851 extends C12236k implements Function1<Model, Unit> {
        public C95851(WidgetServerSettingsInstantInvites widgetServerSettingsInstantInvites) {
            super(1, widgetServerSettingsInstantInvites, WidgetServerSettingsInstantInvites.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            ((WidgetServerSettingsInstantInvites) this.receiver).configureUI(model);
        }
    }

    public WidgetServerSettingsInstantInvites() {
        super(C5419R.layout.widget_server_settings_instant_invites);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsInstantInvites$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetServerSettingsInstantInvites$guildId$2(this));
        this.storeInstantInvites = StoreStream.INSTANCE.getInstantInvites();
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsInstantInvites$loggingConfig$1.INSTANCE, 3);
    }

    private final void configureUI(Model data) throws Exception {
        if (data == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        if (data.getInviteItems() == null) {
            AppViewFlipper appViewFlipper = getBinding().f17689c;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsInstantInvitesViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (data.getInviteItems().isEmpty()) {
            AppViewFlipper appViewFlipper2 = getBinding().f17689c;
            C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.serverSettingsInstantInvitesViewFlipper");
            appViewFlipper2.setDisplayedChild(2);
        } else {
            AppViewFlipper appViewFlipper3 = getBinding().f17689c;
            C12238m.checkNotNullExpressionValue(appViewFlipper3, "binding.serverSettingsInstantInvitesViewFlipper");
            appViewFlipper3.setDisplayedChild(1);
            Adapter adapter = this.adapter;
            if (adapter != null) {
                adapter.configure(data.getInviteItems(), new C95831(), C95842.INSTANCE);
            }
        }
        setActionBarTitle(C5419R.string.instant_invites);
        setActionBarSubtitle(data.getGuild().getName());
    }

    private final WidgetServerSettingsInstantInvitesBinding getBinding() {
        return (WidgetServerSettingsInstantInvitesBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f17688b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsInstantInvitesRecycler");
        this.adapter = (Adapter) companion.configure(new Adapter(recyclerView));
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.storeInstantInvites.clearInvites(getGuildId());
        this.storeInstantInvites.fetchGuildInvites(getGuildId());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.Companion.get$default(Model.INSTANCE, getGuildId(), null, null, 6, null), this, null, 2, null), (Class<?>) WidgetServerSettingsInstantInvites.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C95851(this));
    }
}
