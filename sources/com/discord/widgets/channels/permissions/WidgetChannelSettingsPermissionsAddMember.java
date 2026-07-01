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
import b.a.d.AppScreen2;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.R;
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
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.SimpleMembersAdapter;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddMember;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.a.OnSubscribeFlattenIterable2;
import j0.l.a.OnSubscribeLift;
import j0.l.a.OperatorToObservableSortedList;
import j0.l.e.RxRingBuffer;
import j0.l.e.ScalarSynchronousObservable;
import j0.l.e.UtilityFunctions;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.functions.Func4;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetChannelSettingsPermissionsAddMember extends AppFragment {
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final int VIEW_INDEX_MEMBER_LIST = 0;
    private static final int VIEW_INDEX_NO_RESULTS = 1;
    public static final /* synthetic */ int j = 0;
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
            return StoreStream.getChannels().observeChannel(j2).Y(new Func1() { // from class: b.a.z.a.a.e
                @Override // j0.k.Func1
                public final Object call(Object obj) {
                    final long j3 = j;
                    long j4 = j2;
                    Observable observable2 = observable;
                    final Channel channel = (Channel) obj;
                    if (channel == null) {
                        return new ScalarSynchronousObservable(null);
                    }
                    Observable observableH = Observable.h(StoreStream.getUsers().observeMe(), StoreStream.getGuilds().observeGuild(j3), StoreStream.getPermissions().observePermissionsForChannel(j4), observable2.p(300L, TimeUnit.MILLISECONDS).Y(new Func1() { // from class: b.a.z.a.a.g
                        @Override // j0.k.Func1
                        public final Object call(Object obj2) {
                            return WidgetChannelSettingsPermissionsAddMember.Model.getMemberItems(j3, channel.v(), (String) obj2);
                        }
                    }).r(), new Func4() { // from class: b.a.z.a.a.j
                        @Override // rx.functions.Func4
                        public final Object call(Object obj2, Object obj3, Object obj4, Object obj5) {
                            return WidgetChannelSettingsPermissionsAddMember.Model.lambda$null$1(channel, (MeUser) obj2, (Guild) obj3, (Long) obj4, (List) obj5);
                        }
                    });
                    Intrinsics3.checkNotNullExpressionValue(observableH, "observable");
                    return ObservableExtensionsKt.computationBuffered(observableH).r();
                }
            });
        }

        private static Observable<List<SimpleMembersAdapter.MemberItem>> getMemberItems(long j, @Nullable final List<PermissionOverwrite> list, String str) {
            final String lowerCase = str.toLowerCase(Locale.getDefault());
            return StoreStream.getGuilds().observeComputed(j).Y(new Func1() { // from class: b.a.z.a.a.i
                @Override // j0.k.Func1
                public final Object call(Object obj) {
                    final List list2 = list;
                    final String str2 = lowerCase;
                    final Map map = (Map) obj;
                    return StoreStream.getUsers().observeUsers(map.keySet()).Y(new Func1() { // from class: b.a.z.a.a.h
                        @Override // j0.k.Func1
                        public final Object call(Object obj2) {
                            final List list3 = list2;
                            final Map map2 = map;
                            final String str3 = str2;
                            Observable observableH0 = Observable.h0(new OnSubscribeLift(Observable.B(((Map) obj2).values()).y(new Func1() { // from class: b.a.z.a.a.l
                                @Override // j0.k.Func1
                                public final Object call(Object obj3) {
                                    List list4 = list3;
                                    User user = (User) obj3;
                                    if (list4 == null) {
                                        return Boolean.TRUE;
                                    }
                                    for (int i = 0; i < list4.size(); i++) {
                                        if (((PermissionOverwrite) list4.get(i)).e() == user.getId()) {
                                            return Boolean.FALSE;
                                        }
                                    }
                                    return Boolean.TRUE;
                                }
                            }).y(new Func1() { // from class: b.a.z.a.a.m
                                @Override // j0.k.Func1
                                public final Object call(Object obj3) {
                                    return Boolean.valueOf(outline.f((User) obj3, map2) != null);
                                }
                            }).y(new Func1() { // from class: b.a.z.a.a.k
                                @Override // j0.k.Func1
                                public final Object call(Object obj3) {
                                    return Boolean.valueOf(((User) obj3).getUsername().toLowerCase(Locale.ROOT).contains(str3));
                                }
                            }).j, new OperatorToObservableSortedList(new Func2() { // from class: b.a.z.a.a.f
                                @Override // rx.functions.Func2
                                public final Object call(Object obj3, Object obj4) {
                                    Map map3 = map2;
                                    User user = (User) obj3;
                                    User user2 = (User) obj4;
                                    return Integer.valueOf(GuildMember.compareUserNames(user, user2, (GuildMember) outline.f(user, map3), (GuildMember) outline.f(user2, map3)));
                                }
                            }, 10)));
                            UtilityFunctions.a aVar = UtilityFunctions.a.INSTANCE;
                            return (observableH0 instanceof ScalarSynchronousObservable ? Observable.h0(new OnSubscribeFlattenIterable2.b(((ScalarSynchronousObservable) observableH0).l, aVar)) : Observable.h0(new OnSubscribeFlattenIterable2(observableH0, aVar, RxRingBuffer.j))).G(new Func1() { // from class: b.a.z.a.a.d
                                @Override // j0.k.Func1
                                public final Object call(Object obj3) {
                                    User user = (User) obj3;
                                    return new SimpleMembersAdapter.MemberItem(user, (GuildMember) outline.f(user, map2));
                                }
                            }).f0();
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
            StringBuilder sbU = outline.U("WidgetChannelSettingsPermissionsAddMember.Model(channel=");
            sbU.append(this.channel);
            sbU.append(", memberItems=");
            sbU.append(this.memberItems);
            sbU.append(", canManage=");
            return outline.O(sbU, this.canManage, ")");
        }
    }

    public WidgetChannelSettingsPermissionsAddMember() {
        super(R.layout.widget_channel_settings_permissions_add_member);
        this.nameFilterPublisher = BehaviorSubject.l0("");
    }

    private void configureToolbar(Channel channel) {
        setActionBarTitle(R.string.add_a_member);
        setActionBarSubtitle(ChannelUtils.d(channel, requireContext(), true));
    }

    private void configureUI(final Model model) {
        if (model == null || !model.canManage) {
            if (e() != null) {
                e().onBackPressed();
            }
        } else {
            configureToolbar(model.channel);
            this.membersAdapter.setData(model.memberItems, new Function1() { // from class: b.a.z.a.a.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    WidgetChannelSettingsPermissionsAddMember widgetChannelSettingsPermissionsAddMember = this.j;
                    WidgetChannelSettingsPermissionsAddMember.Model model2 = model;
                    WidgetChannelSettingsEditPermissions.createForUser(widgetChannelSettingsPermissionsAddMember.getContext(), model2.channel.getGuildId(), model2.channel.getId(), ((User) obj).getId());
                    return Unit.a;
                }
            });
            ViewFlipper viewFlipper = this.viewFlipper;
            if (viewFlipper != null) {
                viewFlipper.setDisplayedChild(model.memberItems.isEmpty() ? 1 : 0);
            }
        }
    }

    public static void create(Context context, long j2, long j3) {
        Intent intent = new Intent();
        intent.putExtra("INTENT_EXTRA_GUILD_ID", j2);
        intent.putExtra(INTENT_EXTRA_CHANNEL_ID, j3);
        AppScreen2.d(context, WidgetChannelSettingsPermissionsAddMember.class, intent);
    }

    public /* synthetic */ Unit h(Editable editable) {
        this.nameFilterPublisher.onNext(editable.toString());
        return null;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(@NonNull View view) {
        super.onViewBound(view);
        this.membersRecycler = (RecyclerView) view.findViewById(R.id.channel_settings_permissions_add_member_recycler);
        this.searchBox = (TextInputLayout) view.findViewById(R.id.channel_settings_permissions_add_member_name_search);
        this.viewFlipper = (ViewFlipper) view.findViewById(R.id.channel_settings_permissions_add_member_view_flipper);
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
                this.j.h((Editable) obj);
                return null;
            }
        });
        this.nameFilterPublisher.onNext(ViewExtensions.getTextOrEmpty(this.searchBox));
        this.nameFilterPublisher.p(750L, TimeUnit.MILLISECONDS).y(new Func1() { // from class: b.a.z.a.a.o
            @Override // j0.k.Func1
            public final Object call(Object obj) {
                int i = WidgetChannelSettingsPermissionsAddMember.j;
                return Boolean.valueOf(!TextUtils.isEmpty((String) obj));
            }
        }).k(o.e(new Action1() { // from class: b.a.z.a.a.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                int i = WidgetChannelSettingsPermissionsAddMember.j;
                StoreStream.getGatewaySocket().requestGuildMembers(longExtra, (String) obj);
            }
        }, getClass()));
        Observable<Model> observable = Model.get(longExtra, longExtra2, this.nameFilterPublisher);
        Intrinsics3.checkNotNullParameter(this, "appComponent");
        Intrinsics3.checkNotNullExpressionValue(observable, "it");
        ObservableExtensionsKt.ui(observable, this, null).k(o.e(new Action1() { // from class: b.a.z.a.a.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.j.configureUI((WidgetChannelSettingsPermissionsAddMember.Model) obj);
            }
        }, getClass()));
    }
}
