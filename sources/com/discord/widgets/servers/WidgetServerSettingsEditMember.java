package com.discord.widgets.servers;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.GuildFeature;
import com.discord.api.role.GuildRole;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsEditMemberBinding;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.permissions.PermissionsContexts3;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication;
import com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication;
import com.discord.widgets.servers.WidgetServerSettingsEditMember;
import com.discord.widgets.servers.WidgetServerSettingsEditMemberRolesAdapter;
import com.discord.widgets.servers.WidgetServerSettingsTransferOwnership;
import com.discord.widgets.user.WidgetBanUser;
import com.discord.widgets.user.WidgetKickUser;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.Iterables2;
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
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func6;

/* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditMember extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsEditMember.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEditMemberBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_USER_ID = "INTENT_EXTRA_USER_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetServerSettingsEditMemberRolesAdapter rolesAdapter;
    private final StatefulViews state;

    /* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long guildId, long userId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetServerSettingsEditMember.INTENT_EXTRA_USER_ID, userId);
            AppScreen2.d(context, WidgetServerSettingsEditMember.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canBan;
        private final boolean canChangeNickname;
        private final boolean canDisableCommunication;
        private final boolean canKick;
        private final boolean canManage;
        private final boolean canTransferOwnership;
        private final Guild guild;
        private final long myId;
        private final List<WidgetServerSettingsEditMemberRolesAdapter.RoleItem> roleItems;
        private final User user;
        private final GuildMember userComputed;
        private final Set<Long> userRoles;

        /* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(final long guildId, final long userId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableR = Observable.f(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getUsers().observeUser(userId), companion.getGuilds().observeComputed(guildId), companion.getGuilds().observeGuild(guildId), companion.getGuilds().observeRoles(guildId), companion.getPermissions().observePermissionsForGuild(guildId), new Func6<MeUser, User, Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends GuildRole>, Long, Model>() { // from class: com.discord.widgets.servers.WidgetServerSettingsEditMember$Model$Companion$get$1
                    @Override // rx.functions.Func6
                    public /* bridge */ /* synthetic */ WidgetServerSettingsEditMember.Model call(MeUser meUser, User user, Map<Long, ? extends GuildMember> map, Guild guild, Map<Long, ? extends GuildRole> map2, Long l) {
                        return call2(meUser, user, (Map<Long, GuildMember>) map, guild, (Map<Long, GuildRole>) map2, l);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final WidgetServerSettingsEditMember.Model call2(MeUser meUser, User user, Map<Long, GuildMember> map, Guild guild, Map<Long, GuildRole> map2, Long l) {
                        Intrinsics3.checkNotNullExpressionValue(map2, "guildRoles");
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        Iterator<Map.Entry<Long, GuildRole>> it = map2.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Map.Entry<Long, GuildRole> next = it.next();
                            if (next.getKey().longValue() != guildId) {
                                linkedHashMap.put(next.getKey(), next.getValue());
                            }
                        }
                        GuildMember guildMember = map.get(Long.valueOf(meUser.getId()));
                        GuildMember guildMember2 = map.get(Long.valueOf(userId));
                        if (guild == null || user == null || l == null || guildMember == null || guildMember2 == null) {
                            return null;
                        }
                        PermissionsContexts3.Companion companion2 = PermissionsContexts3.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
                        PermissionsContexts3 permissionsContexts3From = companion2.from(guild, meUser, user, guildMember.getRoles(), guildMember2.getRoles(), l, linkedHashMap);
                        HashSet hashSet = new HashSet(guildMember2.getRoles());
                        GuildRole highestRole = RoleUtils.getHighestRole(linkedHashMap, guildMember);
                        ArrayList<GuildRole> arrayList = new ArrayList(linkedHashMap.values());
                        Collections.sort(arrayList, RoleUtils.getROLE_COMPARATOR());
                        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
                        for (GuildRole guildRole : arrayList) {
                            arrayList2.add(new WidgetServerSettingsEditMemberRolesAdapter.RoleItem(guildRole, hashSet.contains(Long.valueOf(guildRole.getId())), highestRole, meUser.getId() == guild.getOwnerId(), permissionsContexts3From.getCanManageRoles()));
                        }
                        return new WidgetServerSettingsEditMember.Model(meUser.getId(), guild, guildMember2, hashSet, user, arrayList2, permissionsContexts3From.canManage(), permissionsContexts3From.getCanKick(), permissionsContexts3From.getCanBan(), permissionsContexts3From.getCanChangeNickname(), meUser.getId() != userId && meUser.getId() == guild.getOwnerId(), permissionsContexts3From.getCanDisableCommunication());
                    }
                }).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
                return ObservableExtensionsKt.computationLatest(observableR);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(long j, Guild guild, GuildMember guildMember, Set<Long> set, User user, List<WidgetServerSettingsEditMemberRolesAdapter.RoleItem> list, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(guildMember, "userComputed");
            Intrinsics3.checkNotNullParameter(set, "userRoles");
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(list, "roleItems");
            this.myId = j;
            this.guild = guild;
            this.userComputed = guildMember;
            this.userRoles = set;
            this.user = user;
            this.roleItems = list;
            this.canManage = z2;
            this.canKick = z3;
            this.canBan = z4;
            this.canChangeNickname = z5;
            this.canTransferOwnership = z6;
            this.canDisableCommunication = z7;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getMyId() {
            return this.myId;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final boolean getCanChangeNickname() {
            return this.canChangeNickname;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getCanTransferOwnership() {
            return this.canTransferOwnership;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final boolean getCanDisableCommunication() {
            return this.canDisableCommunication;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final GuildMember getUserComputed() {
            return this.userComputed;
        }

        public final Set<Long> component4() {
            return this.userRoles;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final List<WidgetServerSettingsEditMemberRolesAdapter.RoleItem> component6() {
            return this.roleItems;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getCanManage() {
            return this.canManage;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getCanKick() {
            return this.canKick;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getCanBan() {
            return this.canBan;
        }

        public final Model copy(long myId, Guild guild, GuildMember userComputed, Set<Long> userRoles, User user, List<WidgetServerSettingsEditMemberRolesAdapter.RoleItem> roleItems, boolean canManage, boolean canKick, boolean canBan, boolean canChangeNickname, boolean canTransferOwnership, boolean canDisableCommunication) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(userComputed, "userComputed");
            Intrinsics3.checkNotNullParameter(userRoles, "userRoles");
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(roleItems, "roleItems");
            return new Model(myId, guild, userComputed, userRoles, user, roleItems, canManage, canKick, canBan, canChangeNickname, canTransferOwnership, canDisableCommunication);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.myId == model.myId && Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.userComputed, model.userComputed) && Intrinsics3.areEqual(this.userRoles, model.userRoles) && Intrinsics3.areEqual(this.user, model.user) && Intrinsics3.areEqual(this.roleItems, model.roleItems) && this.canManage == model.canManage && this.canKick == model.canKick && this.canBan == model.canBan && this.canChangeNickname == model.canChangeNickname && this.canTransferOwnership == model.canTransferOwnership && this.canDisableCommunication == model.canDisableCommunication;
        }

        public final boolean getCanBan() {
            return this.canBan;
        }

        public final boolean getCanChangeNickname() {
            return this.canChangeNickname;
        }

        public final boolean getCanDisableCommunication() {
            return this.canDisableCommunication;
        }

        public final boolean getCanKick() {
            return this.canKick;
        }

        public final boolean getCanManage() {
            return this.canManage;
        }

        public final boolean getCanTransferOwnership() {
            return this.canTransferOwnership;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final long getMyId() {
            return this.myId;
        }

        public final List<WidgetServerSettingsEditMemberRolesAdapter.RoleItem> getRoleItems() {
            return this.roleItems;
        }

        public final User getUser() {
            return this.user;
        }

        public final GuildMember getUserComputed() {
            return this.userComputed;
        }

        public final Set<Long> getUserRoles() {
            return this.userRoles;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v13, types: [int] */
        /* JADX WARN: Type inference failed for: r0v15, types: [int] */
        /* JADX WARN: Type inference failed for: r0v17, types: [int] */
        /* JADX WARN: Type inference failed for: r0v19, types: [int] */
        /* JADX WARN: Type inference failed for: r0v21, types: [int] */
        /* JADX WARN: Type inference failed for: r0v23, types: [int] */
        /* JADX WARN: Type inference failed for: r1v14, types: [int] */
        /* JADX WARN: Type inference failed for: r1v16, types: [int] */
        /* JADX WARN: Type inference failed for: r1v18, types: [int] */
        /* JADX WARN: Type inference failed for: r1v20, types: [int] */
        /* JADX WARN: Type inference failed for: r1v22, types: [int] */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r1v26 */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v33 */
        /* JADX WARN: Type inference failed for: r1v34 */
        /* JADX WARN: Type inference failed for: r1v35 */
        /* JADX WARN: Type inference failed for: r1v36 */
        /* JADX WARN: Type inference failed for: r1v37 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            int iA = b.a(this.myId) * 31;
            Guild guild = this.guild;
            int iHashCode = (iA + (guild != null ? guild.hashCode() : 0)) * 31;
            GuildMember guildMember = this.userComputed;
            int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            Set<Long> set = this.userRoles;
            int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
            User user = this.user;
            int iHashCode4 = (iHashCode3 + (user != null ? user.hashCode() : 0)) * 31;
            List<WidgetServerSettingsEditMemberRolesAdapter.RoleItem> list = this.roleItems;
            int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.canManage;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode5 + r1) * 31;
            boolean z3 = this.canKick;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.canBan;
            ?? r3 = z4;
            if (z4) {
                r3 = 1;
            }
            int i3 = (i2 + r3) * 31;
            boolean z5 = this.canChangeNickname;
            ?? r4 = z5;
            if (z5) {
                r4 = 1;
            }
            int i4 = (i3 + r4) * 31;
            boolean z6 = this.canTransferOwnership;
            ?? r5 = z6;
            if (z6) {
                r5 = 1;
            }
            int i5 = (i4 + r5) * 31;
            boolean z7 = this.canDisableCommunication;
            return i5 + (z7 ? 1 : z7);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(myId=");
            sbU.append(this.myId);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", userComputed=");
            sbU.append(this.userComputed);
            sbU.append(", userRoles=");
            sbU.append(this.userRoles);
            sbU.append(", user=");
            sbU.append(this.user);
            sbU.append(", roleItems=");
            sbU.append(this.roleItems);
            sbU.append(", canManage=");
            sbU.append(this.canManage);
            sbU.append(", canKick=");
            sbU.append(this.canKick);
            sbU.append(", canBan=");
            sbU.append(this.canBan);
            sbU.append(", canChangeNickname=");
            sbU.append(this.canChangeNickname);
            sbU.append(", canTransferOwnership=");
            sbU.append(this.canTransferOwnership);
            sbU.append(", canDisableCommunication=");
            return outline.O(sbU, this.canDisableCommunication, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMember$changeNickname$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $nickname;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$nickname = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            WidgetServerSettingsEditMember.this.onNicknameChangeSuccessful(this.$nickname);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMember$changeNickname$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $nickname;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$nickname = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            WidgetServerSettingsEditMember.this.onNicknameChangeSuccessful(this.$nickname);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMember$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsEditMember widgetServerSettingsEditMember) {
            super(1, widgetServerSettingsEditMember, WidgetServerSettingsEditMember.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsEditMember$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            ((WidgetServerSettingsEditMember) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMember$setupRoles$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Model $data;

        /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMember$setupRoles$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
        public static final class C03081 extends Lambda implements Function1<Void, Unit> {
            public static final C03081 INSTANCE = new C03081();

            public C03081() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$data = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetServerSettingsEditMember.this.getBinding().e.clearFocus();
            ArrayList arrayList = new ArrayList();
            if (this.$data.getUserRoles().contains(Long.valueOf(j))) {
                Iterator<Long> it = this.$data.getUserRoles().iterator();
                while (it.hasNext()) {
                    long jLongValue = it.next().longValue();
                    if (jLongValue != j) {
                        arrayList.add(Long.valueOf(jLongValue));
                    }
                }
            } else {
                arrayList.addAll(this.$data.getUserRoles());
                arrayList.add(Long.valueOf(j));
            }
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().changeGuildMember(this.$data.getGuild().getId(), this.$data.getUser().getId(), RestAPIParams.GuildMember.INSTANCE.createWithRoles(arrayList)), false, 1, null), WidgetServerSettingsEditMember.this, null, 2, null), (Class<?>) WidgetServerSettingsEditMember.this.getClass(), (58 & 2) != 0 ? null : WidgetServerSettingsEditMember.this.requireContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), C03081.INSTANCE);
        }
    }

    public WidgetServerSettingsEditMember() {
        super(R.layout.widget_server_settings_edit_member);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsEditMember3.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.edit_member_nickname);
    }

    private final void changeNickname(Model data, String nickname) {
        if (data.getUser().getId() == data.getMyId()) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().changeGuildNickname(data.getGuild().getId(), new RestAPIParams.Nick(nickname)), false, 1, null), this, null, 2, null), (Class<?>) WidgetServerSettingsEditMember.class, (58 & 2) != 0 ? null : requireContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(nickname));
        } else {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().changeGuildMember(data.getGuild().getId(), data.getUser().getId(), RestAPIParams.GuildMember.INSTANCE.createWithNick(nickname)), false, 1, null), this, null, 2, null), (Class<?>) WidgetServerSettingsEditMember.class, (58 & 2) != 0 ? null : requireContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(nickname));
        }
    }

    private final void configureUI(final Model data) {
        if (data == null || !data.getCanManage()) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        boolean z2 = true;
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        Context context = getContext();
        setActionBarTitle(context != null ? FormatUtils.b(context, R.string.guild_members_header, new Object[]{data.getGuild().getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null) : null);
        GuildMember.Companion companion = GuildMember.INSTANCE;
        setActionBarSubtitle(companion.getNickOrUsername(data.getUserComputed(), data.getUser()));
        setupNickname(data);
        setupRoles(data);
        this.state.configureSaveActionView(getBinding().h);
        getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsEditMember.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextInputLayout textInputLayout = WidgetServerSettingsEditMember.this.getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editMemberNickname");
                TextInputLayout textInputLayout2 = WidgetServerSettingsEditMember.this.getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editMemberNickname");
                String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
                int length = textOrEmpty.length() - 1;
                int i = 0;
                boolean z3 = false;
                while (i <= length) {
                    boolean z4 = Intrinsics3.compare(textOrEmpty.charAt(!z3 ? i : length), 32) <= 0;
                    if (z3) {
                        if (!z4) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z4) {
                        i++;
                    } else {
                        z3 = true;
                    }
                }
                ViewExtensions.setText(textInputLayout, textOrEmpty.subSequence(i, length + 1).toString());
                WidgetServerSettingsEditMember widgetServerSettingsEditMember = WidgetServerSettingsEditMember.this;
                Model model = data;
                TextInputLayout textInputLayout3 = widgetServerSettingsEditMember.getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.editMemberNickname");
                widgetServerSettingsEditMember.changeNickname(model, ViewExtensions.getTextOrEmpty(textInputLayout3));
            }
        });
        final String nickOrUsername = companion.getNickOrUsername(data.getUserComputed(), data.getUser());
        if (data.getCanDisableCommunication()) {
            final boolean zIsCommunicationDisabled = data.getUserComputed().isCommunicationDisabled();
            TextView textView = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.editMemberTimeoutButton");
            FormatUtils.m(textView, zIsCommunicationDisabled ? R.string.enable_guild_communication_for_user : R.string.disable_guild_communication_for_user, new Object[]{nickOrUsername}, (4 & 4) != 0 ? FormatUtils.g.j : null);
            TextView textView2 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.editMemberTimeoutButton");
            textView2.setVisibility(0);
            getBinding().i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsEditMember.configureUI.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long id2 = data.getUser().getId();
                    long id3 = data.getGuild().getId();
                    if (!zIsCommunicationDisabled) {
                        WidgetDisableGuildCommunication.INSTANCE.launch(id2, id3, WidgetServerSettingsEditMember.this.requireContext());
                        return;
                    }
                    WidgetEnableGuildCommunication.Companion companion2 = WidgetEnableGuildCommunication.INSTANCE;
                    FragmentManager parentFragmentManager = WidgetServerSettingsEditMember.this.getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion2.launch(id2, id3, parentFragmentManager);
                }
            });
        } else {
            TextView textView3 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.editMemberTimeoutButton");
            textView3.setVisibility(8);
            getBinding().i.setOnClickListener(null);
        }
        if (data.getCanKick()) {
            TextView textView4 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.editMemberKickButton");
            FormatUtils.m(textView4, R.string.kick_user, new Object[]{nickOrUsername}, (4 & 4) != 0 ? FormatUtils.g.j : null);
            TextView textView5 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.editMemberKickButton");
            textView5.setVisibility(0);
            getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsEditMember.configureUI.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetKickUser.Companion companion2 = WidgetKickUser.INSTANCE;
                    String str = nickOrUsername;
                    long id2 = data.getGuild().getId();
                    long id3 = data.getUser().getId();
                    FragmentManager parentFragmentManager = WidgetServerSettingsEditMember.this.getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion2.launch(str, id2, id3, parentFragmentManager);
                }
            });
        } else {
            TextView textView6 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.editMemberKickButton");
            textView6.setVisibility(8);
            getBinding().d.setOnClickListener(null);
        }
        if (data.getCanBan()) {
            TextView textView7 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView7, "binding.editMemberBanButton");
            FormatUtils.m(textView7, R.string.ban_user, new Object[]{nickOrUsername}, (4 & 4) != 0 ? FormatUtils.g.j : null);
            TextView textView8 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView8, "binding.editMemberBanButton");
            textView8.setVisibility(0);
            getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsEditMember.configureUI.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetBanUser.INSTANCE.launch(nickOrUsername, data.getGuild().getId(), data.getUser().getId(), WidgetServerSettingsEditMember.this.getParentFragmentManager());
                }
            });
        } else {
            TextView textView9 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView9, "binding.editMemberBanButton");
            textView9.setVisibility(8);
            getBinding().c.setOnClickListener(null);
        }
        if (data.getCanTransferOwnership()) {
            TextView textView10 = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textView10, "binding.editMemberTransferOwnershipButton");
            textView10.setVisibility(0);
            getBinding().j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsEditMember.configureUI.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (data.getGuild().getFeatures().contains(GuildFeature.VERIFIED) || data.getGuild().getFeatures().contains(GuildFeature.PARTNERED)) {
                        AppToast.i(WidgetServerSettingsEditMember.this, R.string.transfer_ownership_protected_guild, 0, 4);
                        return;
                    }
                    WidgetServerSettingsTransferOwnership.Companion companion2 = WidgetServerSettingsTransferOwnership.INSTANCE;
                    long id2 = data.getGuild().getId();
                    long id3 = data.getUser().getId();
                    FragmentManager parentFragmentManager = WidgetServerSettingsEditMember.this.getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion2.create(id2, id3, parentFragmentManager);
                }
            });
        } else {
            TextView textView11 = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textView11, "binding.editMemberTransferOwnershipButton");
            textView11.setVisibility(8);
            getBinding().j.setOnClickListener(null);
        }
        LinearLayout linearLayout = getBinding().f2561b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.editMemberAdministrativeContainer");
        if (!data.getCanKick() && !data.getCanBan() && !data.getCanTransferOwnership()) {
            z2 = false;
        }
        linearLayout.setVisibility(z2 ? 0 : 8);
    }

    private final WidgetServerSettingsEditMemberBinding getBinding() {
        return (WidgetServerSettingsEditMemberBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onNicknameChangeSuccessful(String nickname) {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        AppToast.j(this, nickname.length() > 0 ? FormatUtils.e(this, R.string.nickname_changed, new Object[]{nickname}, (4 & 4) != 0 ? FormatUtils.a.j : null) : FormatUtils.e(this, R.string.nickname_cleared, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), 0, 4);
    }

    private final void setupNickname(Model data) {
        String nick = data.getUserComputed().getNick();
        if (nick == null) {
            nick = "";
        }
        if (data.getCanChangeNickname()) {
            TextInputLayout textInputLayout = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editMemberNickname");
            textInputLayout.setEndIconVisible(false);
            TextInputLayout textInputLayout2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editMemberNickname");
            textInputLayout2.setEnabled(true);
        } else {
            TextInputLayout textInputLayout3 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.editMemberNickname");
            textInputLayout3.setEndIconVisible(true);
            TextInputLayout textInputLayout4 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.editMemberNickname");
            textInputLayout4.setEnabled(false);
            StatefulViews statefulViews = this.state;
            TextInputLayout textInputLayout5 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.editMemberNickname");
            statefulViews.put(textInputLayout5.getId(), nick);
        }
        TextInputLayout textInputLayout6 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout6, "binding.editMemberNickname");
        StatefulViews statefulViews2 = this.state;
        TextInputLayout textInputLayout7 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout7, "binding.editMemberNickname");
        ViewExtensions.setText(textInputLayout6, (CharSequence) statefulViews2.get(textInputLayout7.getId(), nick));
    }

    private final void setupRoles(Model data) {
        WidgetServerSettingsEditMemberRolesAdapter widgetServerSettingsEditMemberRolesAdapter;
        LinearLayout linearLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.editMemberRolesContainer");
        linearLayout.setVisibility(data.getRoleItems().isEmpty() ^ true ? 0 : 8);
        if (!(!data.getRoleItems().isEmpty()) || (widgetServerSettingsEditMemberRolesAdapter = this.rolesAdapter) == null) {
            return;
        }
        widgetServerSettingsEditMemberRolesAdapter.configure(data.getRoleItems(), new AnonymousClass1(data));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.editMemberRolesRecycler");
        this.rolesAdapter = (WidgetServerSettingsEditMemberRolesAdapter) companion.configure(new WidgetServerSettingsEditMemberRolesAdapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.editMemberRolesRecycler");
        recyclerView2.setNestedScrollingEnabled(false);
        getBinding().g.setHasFixedSize(false);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editMemberNickname");
        statefulViews.addOptionalFields(textInputLayout);
        StatefulViews statefulViews2 = this.state;
        FloatingActionButton floatingActionButton = getBinding().h;
        TextInputLayout textInputLayout2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editMemberNickname");
        statefulViews2.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        long longExtra2 = getMostRecentIntent().getLongExtra(INTENT_EXTRA_USER_ID, -1L);
        StoreStream.INSTANCE.getGuildSubscriptions().subscribeUser(longExtra, longExtra2);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(longExtra, longExtra2), this, null, 2, null), (Class<?>) WidgetServerSettingsEditMember.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
