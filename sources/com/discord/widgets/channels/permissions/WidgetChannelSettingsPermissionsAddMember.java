package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppFragment;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.SimpleMembersAdapter;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddMember;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0879o;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.C12650n;
import p637j0.p642l.p643a.C12657o2;
import p637j0.p642l.p643a.C12666r;
import p637j0.p642l.p647e.C12719i;
import p637j0.p642l.p647e.C12721k;
import p637j0.p642l.p647e.C12723m;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.functions.Func2;
import p658rx.functions.Func4;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.Subject;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetChannelSettingsPermissionsAddMember extends AppFragment {
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final int VIEW_INDEX_MEMBER_LIST = 0;
    private static final int VIEW_INDEX_NO_RESULTS = 1;

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f19372j = 0;
    private SimpleMembersAdapter membersAdapter;
    private RecyclerView membersRecycler;
    private final Subject<String, String> nameFilterPublisher;
    private TextInputLayout searchBox;
    private ViewFlipper viewFlipper;

    public static class Model {
        private final boolean canManage;
        private final Channel channel;
        private final List<SimpleMembersAdapter.MemberItem> memberItems;

        private Model(MeUser meUser, Guild guild, Channel channel, Long l, List<SimpleMembersAdapter.MemberItem> list) {
            this.channel = channel;
            this.memberItems = list;
            boolean mfaEnabled = meUser.getMfaEnabled();
            this.canManage = guild.getOwnerId() == meUser.getId() || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, l, mfaEnabled, guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, l, mfaEnabled, guild.getMfaLevel());
        }

        public static Observable<Model> get(final long j, final long j2, final Observable<String> observable) {
            return StoreStream.getChannels().observeChannel(j2).m11099Y(new InterfaceC12589b() { // from class: b.a.z.a.a.e
                @Override // p637j0.p641k.InterfaceC12589b
                public final Object call(Object obj) {
                    final long j3 = j;
                    long j4 = j2;
                    Observable observable2 = observable;
                    final Channel channel = (Channel) obj;
                    if (channel == null) {
                        return new C12721k(null);
                    }
                    Observable observableM11073h = Observable.m11073h(StoreStream.getUsers().observeMe(), StoreStream.getGuilds().observeGuild(j3), StoreStream.getPermissions().observePermissionsForChannel(j4), observable2.m11110p(300L, TimeUnit.MILLISECONDS).m11099Y(new InterfaceC12589b() { // from class: b.a.z.a.a.g
                        @Override // p637j0.p641k.InterfaceC12589b
                        public final Object call(Object obj2) {
                            return WidgetChannelSettingsPermissionsAddMember.Model.getMemberItems(j3, channel.m7655v(), (String) obj2);
                        }
                    }).m11112r(), new Func4() { // from class: b.a.z.a.a.j
                        @Override // p658rx.functions.Func4
                        public final Object call(Object obj2, Object obj3, Object obj4, Object obj5) {
                            return WidgetChannelSettingsPermissionsAddMember.Model.lambda$null$1(channel, (MeUser) obj2, (Guild) obj3, (Long) obj4, (List) obj5);
                        }
                    });
                    C12238m.checkNotNullExpressionValue(observableM11073h, "observable");
                    return ObservableExtensionsKt.computationBuffered(observableM11073h).m11112r();
                }
            });
        }

        private static Observable<List<SimpleMembersAdapter.MemberItem>> getMemberItems(long j, @Nullable final List<PermissionOverwrite> list, String str) {
            final String lowerCase = str.toLowerCase(Locale.getDefault());
            return StoreStream.getGuilds().observeComputed(j).m11099Y(new InterfaceC12589b() { // from class: b.a.z.a.a.i
                @Override // p637j0.p641k.InterfaceC12589b
                public final Object call(Object obj) {
                    final List list2 = list;
                    final String str2 = lowerCase;
                    final Map map = (Map) obj;
                    return StoreStream.getUsers().observeUsers(map.keySet()).m11099Y(new InterfaceC12589b() { // from class: b.a.z.a.a.h
                        @Override // p637j0.p641k.InterfaceC12589b
                        public final Object call(Object obj2) {
                            final List list3 = list2;
                            final Map map2 = map;
                            final String str3 = str2;
                            Observable observableM11074h0 = Observable.m11074h0(new C12666r(Observable.m11058B(((Map) obj2).values()).m11118y(new InterfaceC12589b() { // from class: b.a.z.a.a.l
                                @Override // p637j0.p641k.InterfaceC12589b
                                public final Object call(Object obj3) {
                                    List list4 = list3;
                                    User user = (User) obj3;
                                    if (list4 == null) {
                                        return Boolean.TRUE;
                                    }
                                    for (int i = 0; i < list4.size(); i++) {
                                        if (((PermissionOverwrite) list4.get(i)).m8131e() == user.getId()) {
                                            return Boolean.FALSE;
                                        }
                                    }
                                    return Boolean.TRUE;
                                }
                            }).m11118y(new InterfaceC12589b() { // from class: b.a.z.a.a.m
                                @Override // p637j0.p641k.InterfaceC12589b
                                public final Object call(Object obj3) {
                                    return Boolean.valueOf(C1643a.m849f((User) obj3, map2) != null);
                                }
                            }).m11118y(new InterfaceC12589b() { // from class: b.a.z.a.a.k
                                @Override // p637j0.p641k.InterfaceC12589b
                                public final Object call(Object obj3) {
                                    return Boolean.valueOf(((User) obj3).getUsername().toLowerCase(Locale.ROOT).contains(str3));
                                }
                            }).f27640j, new C12657o2(new Func2() { // from class: b.a.z.a.a.f
                                @Override // p658rx.functions.Func2
                                public final Object call(Object obj3, Object obj4) {
                                    Map map3 = map2;
                                    User user = (User) obj3;
                                    User user2 = (User) obj4;
                                    return Integer.valueOf(GuildMember.compareUserNames(user, user2, (GuildMember) C1643a.m849f(user, map3), (GuildMember) C1643a.m849f(user2, map3)));
                                }
                            }, 10)));
                            C12723m.a aVar = C12723m.a.INSTANCE;
                            return (observableM11074h0 instanceof C12721k ? Observable.m11074h0(new C12650n.b(((C12721k) observableM11074h0).f27288l, aVar)) : Observable.m11074h0(new C12650n(observableM11074h0, aVar, C12719i.f27283j))).m11083G(new InterfaceC12589b() { // from class: b.a.z.a.a.d
                                @Override // p637j0.p641k.InterfaceC12589b
                                public final Object call(Object obj3) {
                                    User user = (User) obj3;
                                    return new SimpleMembersAdapter.MemberItem(user, (GuildMember) C1643a.m849f(user, map2));
                                }
                            }).m11105f0();
                        }
                    });
                }
            });
        }

        private static boolean isValid(MeUser meUser, Guild guild, Channel channel, List<SimpleMembersAdapter.MemberItem> list) {
            return (channel == null || guild == null || meUser == null || list == null) ? false : true;
        }

        public static /* synthetic */ Model lambda$null$1(Channel channel, MeUser meUser, Guild guild, Long l, List list) {
            if (isValid(meUser, guild, channel, list)) {
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
            List<SimpleMembersAdapter.MemberItem> list = this.memberItems;
            List<SimpleMembersAdapter.MemberItem> list2 = model.memberItems;
            return list != null ? list.equals(list2) : list2 == null;
        }

        public int hashCode() {
            int i = this.canManage ? 79 : 97;
            Channel channel = this.channel;
            int iHashCode = ((i + 59) * 59) + (channel == null ? 43 : channel.hashCode());
            List<SimpleMembersAdapter.MemberItem> list = this.memberItems;
            return (iHashCode * 59) + (list != null ? list.hashCode() : 43);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("WidgetChannelSettingsPermissionsAddMember.Model(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", memberItems=");
            sbM833U.append(this.memberItems);
            sbM833U.append(", canManage=");
            return C1643a.m827O(sbM833U, this.canManage, ")");
        }
    }

    public WidgetChannelSettingsPermissionsAddMember() {
        super(C5419R.layout.widget_channel_settings_permissions_add_member);
        this.nameFilterPublisher = BehaviorSubject.m11130l0("");
    }

    private void configureToolbar(Channel channel) {
        setActionBarTitle(C5419R.string.add_a_member);
        setActionBarSubtitle(ChannelUtils.m7680d(channel, requireContext(), true));
    }

    private void configureUI(final Model model) {
        if (model == null || !model.canManage) {
            if (m95e() != null) {
                m95e().onBackPressed();
            }
        } else {
            configureToolbar(model.channel);
            this.membersAdapter.setData(model.memberItems, new Function1() { // from class: b.a.z.a.a.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    WidgetChannelSettingsPermissionsAddMember widgetChannelSettingsPermissionsAddMember = this.f2085j;
                    WidgetChannelSettingsPermissionsAddMember.Model model2 = model;
                    WidgetChannelSettingsEditPermissions.createForUser(widgetChannelSettingsPermissionsAddMember.getContext(), model2.channel.getGuildId(), model2.channel.getId(), ((User) obj).getId());
                    return Unit.f27425a;
                }
            });
            ViewFlipper viewFlipper = this.viewFlipper;
            if (viewFlipper != null) {
                viewFlipper.setDisplayedChild(model.memberItems.isEmpty() ? 1 : 0);
            }
        }
    }

    public static void create(Context context, long j, long j2) {
        Intent intent = new Intent();
        intent.putExtra("INTENT_EXTRA_GUILD_ID", j);
        intent.putExtra(INTENT_EXTRA_CHANNEL_ID, j2);
        C0870j.m156d(context, WidgetChannelSettingsPermissionsAddMember.class, intent);
    }

    /* JADX INFO: renamed from: h */
    public /* synthetic */ Unit m8626h(Editable editable) {
        this.nameFilterPublisher.onNext(editable.toString());
        return null;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(@NonNull View view) {
        super.onViewBound(view);
        this.membersRecycler = (RecyclerView) view.findViewById(C5419R.id.channel_settings_permissions_add_member_recycler);
        this.searchBox = (TextInputLayout) view.findViewById(C5419R.id.channel_settings_permissions_add_member_name_search);
        this.viewFlipper = (ViewFlipper) view.findViewById(C5419R.id.channel_settings_permissions_add_member_view_flipper);
        setActionBarDisplayHomeAsUpEnabled();
        this.membersAdapter = (SimpleMembersAdapter) MGRecyclerAdapter.configure(new SimpleMembersAdapter(this.membersRecycler));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        final long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        long longExtra2 = getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, -1L);
        ViewExtensions.addBindedTextWatcher(this.searchBox, this, new Function1() { // from class: b.a.z.a.a.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                this.f2103j.m8626h((Editable) obj);
                return null;
            }
        });
        this.nameFilterPublisher.onNext(ViewExtensions.getTextOrEmpty(this.searchBox));
        this.nameFilterPublisher.m11110p(750L, TimeUnit.MILLISECONDS).m11118y(new InterfaceC12589b() { // from class: b.a.z.a.a.o
            @Override // p637j0.p641k.InterfaceC12589b
            public final Object call(Object obj) {
                int i = WidgetChannelSettingsPermissionsAddMember.f19372j;
                return Boolean.valueOf(!TextUtils.isEmpty((String) obj));
            }
        }).m11108k(C0879o.m179e(new Action1() { // from class: b.a.z.a.a.b
            @Override // p658rx.functions.Action1
            public final void call(Object obj) {
                int i = WidgetChannelSettingsPermissionsAddMember.f19372j;
                StoreStream.getGatewaySocket().requestGuildMembers(longExtra, (String) obj);
            }
        }, getClass()));
        Observable<Model> observable = Model.get(longExtra, longExtra2, this.nameFilterPublisher);
        C12238m.checkNotNullParameter(this, "appComponent");
        C12238m.checkNotNullExpressionValue(observable, "it");
        ObservableExtensionsKt.m8519ui(observable, this, null).m11108k(C0879o.m179e(new Action1() { // from class: b.a.z.a.a.a
            @Override // p658rx.functions.Action1
            public final void call(Object obj) {
                this.f2083j.configureUI((WidgetChannelSettingsPermissionsAddMember.Model) obj);
            }
        }, getClass()));
    }
}
