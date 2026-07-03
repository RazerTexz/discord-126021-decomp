package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.app.AppFragment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.channels.SimpleRolesAdapter;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddRole;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0878n;
import p007b.p008a.p018d.C0879o;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.C12662q;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.functions.Func4;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetChannelSettingsPermissionsAddRole extends AppFragment {
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private SimpleRolesAdapter rolesAdapter;
    private RecyclerView rolesRecycler;

    public static class Model {
        private final boolean canManage;
        private final Channel channel;
        private final List<SimpleRolesAdapter.RoleItem> roleItems;

        private Model(MeUser meUser, Guild guild, Channel channel, Long l, List<SimpleRolesAdapter.RoleItem> list) {
            this.channel = channel;
            this.roleItems = list;
            boolean mfaEnabled = meUser.getMfaEnabled();
            this.canManage = guild.getOwnerId() == meUser.getId() || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, l, mfaEnabled, guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, l, mfaEnabled, guild.getMfaLevel());
        }

        public static Observable<Model> get(final long j) {
            return StoreStream.getChannels().observeChannel(j).m11099Y(new InterfaceC12589b() { // from class: b.a.z.a.a.q
                @Override // p637j0.p641k.InterfaceC12589b
                public final Object call(Object obj) {
                    final Channel channel = (Channel) obj;
                    return channel == null ? new C12721k(null) : Observable.m11073h(StoreStream.getGuilds().observeGuild(channel.getGuildId()), StoreStream.getUsers().observeMe(), StoreStream.getPermissions().observePermissionsForChannel(j), StoreStream.getGuilds().observeSortedRoles(channel.getGuildId()).m11099Y(new InterfaceC12589b() { // from class: b.a.z.a.a.s
                        @Override // p637j0.p641k.InterfaceC12589b
                        public final Object call(Object obj2) {
                            final Channel channel2 = channel;
                            return Observable.m11074h0(new C12662q((List) obj2)).m11118y(new InterfaceC12589b() { // from class: b.a.z.a.a.t
                                @Override // p637j0.p641k.InterfaceC12589b
                                public final Object call(Object obj3) {
                                    Channel channel3 = channel2;
                                    GuildRole guildRole = (GuildRole) obj3;
                                    if (channel3.m7655v() == null) {
                                        return Boolean.TRUE;
                                    }
                                    for (int i = 0; i < channel3.m7655v().size(); i++) {
                                        if (channel3.m7655v().get(i).m8131e() == guildRole.getId()) {
                                            return Boolean.FALSE;
                                        }
                                    }
                                    return Boolean.TRUE;
                                }
                            }).m11083G(new InterfaceC12589b() { // from class: b.a.z.a.a.v
                                @Override // p637j0.p641k.InterfaceC12589b
                                public final Object call(Object obj3) {
                                    return new SimpleRolesAdapter.RoleItem((GuildRole) obj3);
                                }
                            }).m11105f0();
                        }
                    }), new Func4() { // from class: b.a.z.a.a.r
                        @Override // p658rx.functions.Func4
                        public final Object call(Object obj2, Object obj3, Object obj4, Object obj5) {
                            return WidgetChannelSettingsPermissionsAddRole.Model.lambda$null$2(channel, (Guild) obj2, (MeUser) obj3, (Long) obj4, (List) obj5);
                        }
                    });
                }
            }).m11108k(C0878n.f565j);
        }

        private static boolean isValid(Guild guild, Channel channel) {
            return (channel == null || guild == null) ? false : true;
        }

        public static /* synthetic */ Model lambda$null$2(Channel channel, Guild guild, MeUser meUser, Long l, List list) {
            if (isValid(guild, channel)) {
                return new Model(meUser, guild, channel, l, list);
            }
            return null;
        }

        public boolean canEqual(Object obj) {
            return obj instanceof Model;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Model)) {
                return false;
            }
            Model model = (Model) obj;
            if (!model.canEqual(this) || this.canManage != model.canManage) {
                return false;
            }
            Channel channel = this.channel;
            Channel channel2 = model.channel;
            if (channel != null ? !channel.equals(channel2) : channel2 != null) {
                return false;
            }
            List<SimpleRolesAdapter.RoleItem> list = this.roleItems;
            List<SimpleRolesAdapter.RoleItem> list2 = model.roleItems;
            return list != null ? list.equals(list2) : list2 == null;
        }

        public int hashCode() {
            int i = this.canManage ? 79 : 97;
            Channel channel = this.channel;
            int iHashCode = ((i + 59) * 59) + (channel == null ? 43 : channel.hashCode());
            List<SimpleRolesAdapter.RoleItem> list = this.roleItems;
            return (iHashCode * 59) + (list != null ? list.hashCode() : 43);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("WidgetChannelSettingsPermissionsAddRole.Model(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", roleItems=");
            sbM833U.append(this.roleItems);
            sbM833U.append(", canManage=");
            return C1643a.m827O(sbM833U, this.canManage, ")");
        }
    }

    public WidgetChannelSettingsPermissionsAddRole() {
        super(C5419R.layout.widget_channel_settings_permissions_add_role);
    }

    private void configureToolbar(Channel channel) {
        setActionBarTitle(C5419R.string.add_a_role);
        setActionBarSubtitle(ChannelUtils.m7680d(channel, requireContext(), true));
    }

    private void configureUI(final Model model) {
        if (model != null && model.canManage && !model.roleItems.isEmpty()) {
            configureToolbar(model.channel);
            this.rolesAdapter.setData(model.roleItems, new Function1() { // from class: b.a.z.a.a.u
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    WidgetChannelSettingsPermissionsAddRole widgetChannelSettingsPermissionsAddRole = this.f2110j;
                    WidgetChannelSettingsPermissionsAddRole.Model model2 = model;
                    WidgetChannelSettingsEditPermissions.createForRole(widgetChannelSettingsPermissionsAddRole.getContext(), model2.channel.getGuildId(), model2.channel.getId(), ((GuildRole) obj).getId());
                    return Unit.f27425a;
                }
            });
        } else if (m95e() != null) {
            m95e().onBackPressed();
        }
    }

    public static void create(Context context, long j) {
        Intent intent = new Intent();
        intent.putExtra(INTENT_EXTRA_CHANNEL_ID, j);
        C0870j.m156d(context, WidgetChannelSettingsPermissionsAddRole.class, intent);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(@NonNull View view) {
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled();
        this.rolesRecycler = (RecyclerView) view.findViewById(C5419R.id.channel_settings_permissions_add_role_recycler);
        this.rolesAdapter = (SimpleRolesAdapter) MGRecyclerAdapter.configure(new SimpleRolesAdapter(this.rolesRecycler));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observable = Model.get(getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, -1L));
        C12238m.checkNotNullParameter(this, "appComponent");
        C12238m.checkNotNullExpressionValue(observable, "it");
        ObservableExtensionsKt.m8519ui(observable, this, null).m11108k(C0879o.m179e(new Action1() { // from class: b.a.z.a.a.p
            @Override // p658rx.functions.Action1
            public final void call(Object obj) {
                this.f2105j.configureUI((WidgetChannelSettingsPermissionsAddRole.Model) obj);
            }
        }, getClass()));
    }
}
