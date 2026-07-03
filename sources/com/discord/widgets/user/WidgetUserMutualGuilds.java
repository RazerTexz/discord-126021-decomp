package com.discord.widgets.user;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.user.UserProfile;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserMutualGuildsBinding;
import com.discord.databinding.WidgetUserProfileAdapterItemServerBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.user.UserProfileUtilsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.WidgetUserMutualGuilds;
import com.discord.widgets.user.profile.WidgetUserProfileEmptyListItem;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action0;

/* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualGuilds extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetUserMutualGuilds.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserMutualGuildsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
    public static final class Adapter extends MGRecyclerAdapterSimple<Model.Item> {
        private final Action0 guildSelectedCallback;

        /* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
        public static final class ViewHolder extends MGRecyclerViewHolder<Adapter, Model.Item> {
            private final WidgetUserProfileAdapterItemServerBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(@LayoutRes int i, Adapter adapter) {
                super(i, adapter);
                C12238m.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                int i2 = C5419R.id.guild_icon_barrier;
                Barrier barrier = (Barrier) view.findViewById(C5419R.id.guild_icon_barrier);
                if (barrier != null) {
                    i2 = C5419R.id.guild_member_avatar;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.guild_member_avatar);
                    if (simpleDraweeView != null) {
                        i2 = C5419R.id.guild_member_identity_barrier;
                        Barrier barrier2 = (Barrier) view.findViewById(C5419R.id.guild_member_identity_barrier);
                        if (barrier2 != null) {
                            i2 = C5419R.id.user_profile_adapter_item_server_image;
                            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(C5419R.id.user_profile_adapter_item_server_image);
                            if (simpleDraweeView2 != null) {
                                i2 = C5419R.id.user_profile_adapter_item_server_name;
                                TextView textView = (TextView) view.findViewById(C5419R.id.user_profile_adapter_item_server_name);
                                if (textView != null) {
                                    i2 = C5419R.id.user_profile_adapter_item_server_text;
                                    TextView textView2 = (TextView) view.findViewById(C5419R.id.user_profile_adapter_item_server_text);
                                    if (textView2 != null) {
                                        i2 = C5419R.id.user_profile_adapter_item_server_wrap;
                                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C5419R.id.user_profile_adapter_item_server_wrap);
                                        if (relativeLayout != null) {
                                            i2 = C5419R.id.user_profile_adapter_item_user_display_name;
                                            TextView textView3 = (TextView) view.findViewById(C5419R.id.user_profile_adapter_item_user_display_name);
                                            if (textView3 != null) {
                                                WidgetUserProfileAdapterItemServerBinding widgetUserProfileAdapterItemServerBinding = new WidgetUserProfileAdapterItemServerBinding((ConstraintLayout) view, barrier, simpleDraweeView, barrier2, simpleDraweeView2, textView, textView2, relativeLayout, textView3);
                                                C12238m.checkNotNullExpressionValue(widgetUserProfileAdapterItemServerBinding, "WidgetUserProfileAdapter…verBinding.bind(itemView)");
                                                this.binding = widgetUserProfileAdapterItemServerBinding;
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
            }

            public static final /* synthetic */ Adapter access$getAdapter$p(ViewHolder viewHolder) {
                return (Adapter) viewHolder.adapter;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public void onConfigure(int position, final Model.Item data) {
                C12238m.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                this.binding.f18371a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetUserMutualGuilds$Adapter$ViewHolder$onConfigure$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StoreGuildSelected guildSelected = StoreStream.INSTANCE.getGuildSelected();
                        Guild guild = data.getGuild();
                        guildSelected.set(guild != null ? guild.getId() : 0L);
                        WidgetUserMutualGuilds.Adapter.ViewHolder.access$getAdapter$p(this.this$0).guildSelectedCallback.call();
                    }
                });
                SimpleDraweeView simpleDraweeView = this.binding.f18373c;
                Guild guild = data.getGuild();
                simpleDraweeView.setVisibility((guild != null ? guild.getIcon() : null) == null ? 8 : 0);
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "this");
                IconUtils.setIcon$default((ImageView) simpleDraweeView, data.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
                TextView textView = this.binding.f18375e;
                Guild guild2 = data.getGuild();
                textView.setVisibility((guild2 != null ? guild2.getIcon() : null) == null ? 0 : 8);
                Guild guild3 = data.getGuild();
                textView.setText(guild3 != null ? guild3.getShortName() : null);
                TextView textView2 = this.binding.f18374d;
                Guild guild4 = data.getGuild();
                textView2.setText(guild4 != null ? guild4.getName() : null);
                GuildMember guildMember = data.getGuildMember();
                boolean z2 = true;
                boolean z3 = guildMember != null && guildMember.hasAvatar();
                TextView textView3 = this.binding.f18376f;
                String nick = data.getNick();
                if (nick == null) {
                    User user = data.getUser();
                    nick = user != null ? user.getUsername() : null;
                }
                textView3.setText(nick);
                if (data.getNick() == null && !z3) {
                    z2 = false;
                }
                textView3.setVisibility(z2 ? 0 : 8);
                SimpleDraweeView simpleDraweeView2 = this.binding.f18372b;
                simpleDraweeView2.setVisibility(z3 ? 0 : 8);
                if (guildMember != null) {
                    String forGuildMember$default = IconUtils.getForGuildMember$default(IconUtils.INSTANCE, guildMember, Integer.valueOf(DimenUtils.dpToPixels(16)), false, 4, null);
                    C12238m.checkNotNullExpressionValue(simpleDraweeView2, "this");
                    IconUtils.setIcon$default(simpleDraweeView2, forGuildMember$default, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView, Action0 action0) {
            super(recyclerView, false, 2, null);
            C12238m.checkNotNullParameter(recyclerView, "recyclerView");
            C12238m.checkNotNullParameter(action0, "guildSelectedCallback");
            this.guildSelectedCallback = action0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<?, Model.Item> onCreateViewHolder(ViewGroup parent, int viewType) {
            C12238m.checkNotNullParameter(parent, "parent");
            if (viewType == 0) {
                return new WidgetUserProfileEmptyListItem(C5419R.layout.widget_user_profile_adapter_item_empty, this, C5419R.attr.img_no_mutual_servers, C5419R.string.no_mutual_guilds);
            }
            if (viewType == 1) {
                return new ViewHolder(C5419R.layout.widget_user_profile_adapter_item_server, this);
            }
            throw invalidViewTypeException(viewType);
        }
    }

    /* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, long userId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_USER_ID", userId);
            C0870j.m156d(context, WidgetUserMutualGuilds.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Map<Long, Map<Long, GuildMember>> guildMembers;
        private final Map<Long, Guild> guilds;
        private final List<Item> list;
        private final int numMutualGuilds;
        private final UserProfile profile;
        private final User user;

        /* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
        public static final class Companion {
            private Companion() {
            }

            public static /* synthetic */ Observable get$default(Companion companion, long j, StoreUserProfile storeUserProfile, StoreGuildsSorted storeGuildsSorted, StoreUser storeUser, StoreGuilds storeGuilds, int i, Object obj) {
                if ((i & 2) != 0) {
                    storeUserProfile = StoreStream.INSTANCE.getUserProfile();
                }
                StoreUserProfile storeUserProfile2 = storeUserProfile;
                if ((i & 4) != 0) {
                    storeGuildsSorted = StoreStream.INSTANCE.getGuildsSorted();
                }
                StoreGuildsSorted storeGuildsSorted2 = storeGuildsSorted;
                if ((i & 8) != 0) {
                    storeUser = StoreStream.INSTANCE.getUsers();
                }
                StoreUser storeUser2 = storeUser;
                if ((i & 16) != 0) {
                    storeGuilds = StoreStream.INSTANCE.getGuilds();
                }
                return companion.get(j, storeUserProfile2, storeGuildsSorted2, storeUser2, storeGuilds);
            }

            public final Observable<Model> get(long userId, StoreUserProfile storeUserProfile, StoreGuildsSorted storeGuildsSorted, StoreUser storeUser, StoreGuilds storeGuilds) {
                C12238m.checkNotNullParameter(storeUserProfile, "storeUserProfile");
                C12238m.checkNotNullParameter(storeGuildsSorted, "storeGuildsSorted");
                C12238m.checkNotNullParameter(storeUser, "storeUser");
                C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
                Observable<Model> observableM11112r = ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck.UpdateSource[]{storeUserProfile, storeGuildsSorted, storeUser, storeGuilds}, false, null, null, new WidgetUserMutualGuilds$Model$Companion$get$1(storeUserProfile, userId, storeGuildsSorted, storeUser, storeGuilds), 14, null).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "ObservationDeckProvider.… }.distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(UserProfile userProfile, Map<Long, Guild> map, User user, Map<Long, ? extends Map<Long, GuildMember>> map2) {
            GuildMember guildMember;
            C12238m.checkNotNullParameter(userProfile, "profile");
            C12238m.checkNotNullParameter(map, "guilds");
            C12238m.checkNotNullParameter(map2, "guildMembers");
            this.profile = userProfile;
            this.guilds = map;
            this.user = user;
            this.guildMembers = map2;
            this.list = new ArrayList(userProfile.m8308d().size());
            for (Guild guild : map.values()) {
                UserProfile.GuildReference guildReference = (UserProfile.GuildReference) C1643a.m847e(guild, UserProfileUtilsKt.getMutualGuildsById(this.profile));
                if (guildReference != null) {
                    List<Item> list = this.list;
                    User user2 = this.user;
                    String nick = guildReference.getNick();
                    Map map3 = (Map) C1643a.m847e(guild, this.guildMembers);
                    if (map3 != null) {
                        User user3 = this.user;
                        guildMember = (GuildMember) map3.get(user3 != null ? Long.valueOf(user3.getId()) : null);
                    } else {
                        guildMember = null;
                    }
                    list.add(new Item(1, guild, nick, user2, guildMember));
                }
            }
            this.numMutualGuilds = this.list.size();
            if (this.list.isEmpty()) {
                this.list.add(new Item(0, null, null, null, null));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, UserProfile userProfile, Map map, User user, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                userProfile = model.profile;
            }
            if ((i & 2) != 0) {
                map = model.guilds;
            }
            if ((i & 4) != 0) {
                user = model.user;
            }
            if ((i & 8) != 0) {
                map2 = model.guildMembers;
            }
            return model.copy(userProfile, map, user, map2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final UserProfile getProfile() {
            return this.profile;
        }

        public final Map<Long, Guild> component2() {
            return this.guilds;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final Map<Long, Map<Long, GuildMember>> component4() {
            return this.guildMembers;
        }

        public final Model copy(UserProfile profile, Map<Long, Guild> guilds, User user, Map<Long, ? extends Map<Long, GuildMember>> guildMembers) {
            C12238m.checkNotNullParameter(profile, "profile");
            C12238m.checkNotNullParameter(guilds, "guilds");
            C12238m.checkNotNullParameter(guildMembers, "guildMembers");
            return new Model(profile, guilds, user, guildMembers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.profile, model.profile) && C12238m.areEqual(this.guilds, model.guilds) && C12238m.areEqual(this.user, model.user) && C12238m.areEqual(this.guildMembers, model.guildMembers);
        }

        public final Map<Long, Map<Long, GuildMember>> getGuildMembers() {
            return this.guildMembers;
        }

        public final Map<Long, Guild> getGuilds() {
            return this.guilds;
        }

        public final List<Item> getList() {
            return this.list;
        }

        public final int getNumMutualGuilds() {
            return this.numMutualGuilds;
        }

        public final UserProfile getProfile() {
            return this.profile;
        }

        public final User getUser() {
            return this.user;
        }

        public int hashCode() {
            UserProfile userProfile = this.profile;
            int iHashCode = (userProfile != null ? userProfile.hashCode() : 0) * 31;
            Map<Long, Guild> map = this.guilds;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            User user = this.user;
            int iHashCode3 = (iHashCode2 + (user != null ? user.hashCode() : 0)) * 31;
            Map<Long, Map<Long, GuildMember>> map2 = this.guildMembers;
            return iHashCode3 + (map2 != null ? map2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(profile=");
            sbM833U.append(this.profile);
            sbM833U.append(", guilds=");
            sbM833U.append(this.guilds);
            sbM833U.append(", user=");
            sbM833U.append(this.user);
            sbM833U.append(", guildMembers=");
            return C1643a.m825M(sbM833U, this.guildMembers, ")");
        }

        /* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
        public static final /* data */ class Item implements MGRecyclerDataPayload {
            public static final int TYPE_EMPTY = 0;
            public static final int TYPE_MUTUAL_SERVER = 1;
            private final Guild guild;
            private final GuildMember guildMember;
            private final String key;
            private final String nick;
            private final int type;
            private final User user;

            public Item(int i, Guild guild, String str, User user, GuildMember guildMember) {
                this.type = i;
                this.guild = guild;
                this.nick = str;
                this.user = user;
                this.guildMember = guildMember;
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(getType()));
                sb.append(String.valueOf(guild != null ? guild.getId() : 0L));
                this.key = sb.toString();
            }

            public static /* synthetic */ Item copy$default(Item item, int i, Guild guild, String str, User user, GuildMember guildMember, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = item.getType();
                }
                if ((i2 & 2) != 0) {
                    guild = item.guild;
                }
                Guild guild2 = guild;
                if ((i2 & 4) != 0) {
                    str = item.nick;
                }
                String str2 = str;
                if ((i2 & 8) != 0) {
                    user = item.user;
                }
                User user2 = user;
                if ((i2 & 16) != 0) {
                    guildMember = item.guildMember;
                }
                return item.copy(i, guild2, str2, user2, guildMember);
            }

            public final int component1() {
                return getType();
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getNick() {
                return this.nick;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final User getUser() {
                return this.user;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            public final Item copy(int type, Guild guild, String nick, User user, GuildMember guildMember) {
                return new Item(type, guild, nick, user, guildMember);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Item)) {
                    return false;
                }
                Item item = (Item) other;
                return getType() == item.getType() && C12238m.areEqual(this.guild, item.guild) && C12238m.areEqual(this.nick, item.nick) && C12238m.areEqual(this.user, item.user) && C12238m.areEqual(this.guildMember, item.guildMember);
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final String getNick() {
                return this.nick;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public final User getUser() {
                return this.user;
            }

            public int hashCode() {
                int type = getType() * 31;
                Guild guild = this.guild;
                int iHashCode = (type + (guild != null ? guild.hashCode() : 0)) * 31;
                String str = this.nick;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                User user = this.user;
                int iHashCode3 = (iHashCode2 + (user != null ? user.hashCode() : 0)) * 31;
                GuildMember guildMember = this.guildMember;
                return iHashCode3 + (guildMember != null ? guildMember.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Item(type=");
                sbM833U.append(getType());
                sbM833U.append(", guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", nick=");
                sbM833U.append(this.nick);
                sbM833U.append(", user=");
                sbM833U.append(this.user);
                sbM833U.append(", guildMember=");
                sbM833U.append(this.guildMember);
                sbM833U.append(")");
                return sbM833U.toString();
            }

            public /* synthetic */ Item(int i, Guild guild, String str, User user, GuildMember guildMember, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? 0 : i, guild, str, user, guildMember);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMutualGuilds$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
    public static final class C102191 extends AbstractC12240o implements Function1<Model, Unit> {
        public C102191() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "data");
            WidgetUserMutualGuilds.this.configureUI(model);
        }
    }

    public WidgetUserMutualGuilds() {
        super(C5419R.layout.widget_user_mutual_guilds);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserMutualGuilds$binding$2.INSTANCE, null, 2, null);
    }

    private final void configureUI(Model data) {
        int numMutualGuilds = data.getNumMutualGuilds();
        setActionBarTitle(StringResourceUtilsKt.getI18nPluralString(requireContext(), C5419R.plurals.user_profile_mutual_guilds_count, C5419R.string.mutual_guilds, Integer.valueOf(numMutualGuilds), Integer.valueOf(numMutualGuilds)));
        User user = data.getUser();
        setActionBarSubtitle(user != null ? user.getUsername() : null);
        Adapter adapter = this.adapter;
        if (adapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        adapter.setData(data.getList());
    }

    private final WidgetUserMutualGuildsBinding getBinding() {
        return (WidgetUserMutualGuildsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getUserId() {
        return getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_USER_ID", 0L);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f18343b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.userMutualGuildsRecyclerView");
        this.adapter = (Adapter) companion.configure(new Adapter(recyclerView, new Action0() { // from class: com.discord.widgets.user.WidgetUserMutualGuilds.onViewBound.1
            @Override // p658rx.functions.Action0
            public final void call() {
                Context contextRequireContext = WidgetUserMutualGuilds.this.requireContext();
                List<InterfaceC11230c<? extends AppFragment>> list = C0870j.f518a;
                C12238m.checkNotNullParameter(contextRequireContext, "context");
                Intent intent = new Intent();
                intent.addFlags(67108864);
                C0870j.m155c(contextRequireContext, false, intent, 2);
            }
        }));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StoreStream.INSTANCE.getUserProfile().fetchProfile(getUserId(), (12 & 2) != 0 ? null : null, (12 & 4) != 0 ? false : true, (12 & 8) != 0 ? null : null);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.Companion.get$default(Model.INSTANCE, getUserId(), null, null, null, null, 30, null), this, null, 2, null), (Class<?>) WidgetUserMutualGuilds.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C102191());
    }
}
