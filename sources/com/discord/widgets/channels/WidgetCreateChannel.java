package com.discord.widgets.channels;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionChannelCreate;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.ViewCheckableRoleListItemThemedBinding;
import com.discord.databinding.WidgetCreateChannelBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.channel.GuildChannelIconUtilsKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.mg_recycler.SingleTypePayload;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.stage.StageChannelUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.channels.WidgetCreateChannel;
import com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember;
import com.discord.widgets.forums.ForumUtils;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action2;
import p658rx.functions.Func6;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannel extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetCreateChannel.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCreateChannelBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_CATEGORY_ID = "INTENT_CATEGORY_ID";
    private static final String INTENT_DISABLE_ANNOUNCEMENT_CHANNEL_TYPE = "INTENT_DISABLE_ANNOUNCEMENT_CHANNEL_TYPE";
    private static final String INTENT_DISABLE_PRIVATE_SWITCH = "INTENT_DISABLE_PRIVATE_SWITCH";
    private static final String INTENT_GUILD_ID = "INTENT_GUILD_ID";
    private static final String INTENT_PROVIDE_RESULT_ONLY = "INTENT_PROVIDE_RESULT_ONLY";
    private static final String INTENT_SHOULD_CHANNEL_DEFAULT_PRIVATE = "INTENT_SHOULD_CHANNEL_DEFAULT_PRIVATE";
    private static final String INTENT_TYPE = "INTENT_TYPE";
    private static final String RESULT_EXTRA_CHANNEL_ICON_RES_ID = "RESULT_EXTRA_CHANNEL_ICON_RES_ID";
    private static final String RESULT_EXTRA_CHANNEL_ID = "RESULT_EXTRA_CHANNEL_ID";
    private static final String RESULT_EXTRA_CHANNEL_NAME = "RESULT_EXTRA_CHANNEL_NAME";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: categoryId$delegate, reason: from kotlin metadata */
    private final Lazy categoryId;

    /* JADX INFO: renamed from: disableAnnouncementChannelType$delegate, reason: from kotlin metadata */
    private final Lazy disableAnnouncementChannelType;

    /* JADX INFO: renamed from: disablePrivateSwitch$delegate, reason: from kotlin metadata */
    private final Lazy disablePrivateSwitch;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: provideResultOnly$delegate, reason: from kotlin metadata */
    private final Lazy provideResultOnly;
    private RolesAdapter rolesAdapter;

    /* JADX INFO: renamed from: shouldChannelDefaultPrivate$delegate, reason: from kotlin metadata */
    private final Lazy shouldChannelDefaultPrivate;

    /* JADX INFO: renamed from: type$delegate, reason: from kotlin metadata */
    private final Lazy type;

    /* JADX INFO: compiled from: WidgetCreateChannel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, Context context, long j, int i, Long l, int i2, Object obj) {
            int i3 = (i2 & 4) != 0 ? 0 : i;
            if ((i2 & 8) != 0) {
                l = null;
            }
            companion.show(context, j, i3, l);
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, long guildId, int type, Long categoryId, boolean shouldChannelDefaultPrivate, boolean provideResultOnly, boolean disablePrivateSwitch, boolean disableAnnouncementChannelType) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(launcher, "launcher");
            C0870j c0870j = C0870j.f524g;
            Intent intent = new Intent();
            intent.putExtra(WidgetCreateChannel.INTENT_GUILD_ID, guildId);
            intent.putExtra(WidgetCreateChannel.INTENT_TYPE, type);
            intent.putExtra(WidgetCreateChannel.INTENT_CATEGORY_ID, categoryId);
            intent.putExtra(WidgetCreateChannel.INTENT_PROVIDE_RESULT_ONLY, provideResultOnly);
            intent.putExtra(WidgetCreateChannel.INTENT_SHOULD_CHANNEL_DEFAULT_PRIVATE, shouldChannelDefaultPrivate);
            intent.putExtra(WidgetCreateChannel.INTENT_DISABLE_PRIVATE_SWITCH, disablePrivateSwitch);
            intent.putExtra(WidgetCreateChannel.INTENT_DISABLE_ANNOUNCEMENT_CHANNEL_TYPE, disableAnnouncementChannelType);
            c0870j.m160f(context, launcher, WidgetCreateChannel.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, final Function3<? super Long, ? super String, ? super Integer, Unit> callback) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.channels.WidgetCreateChannel$Companion$registerForResult$1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(ActivityResult activityResult) {
                    Intent data;
                    C12238m.checkNotNullExpressionValue(activityResult, "activityResult");
                    if (activityResult.getResultCode() != -1 || (data = activityResult.getData()) == null) {
                        return;
                    }
                    long longExtra = data.getLongExtra("RESULT_EXTRA_CHANNEL_ID", -1L);
                    String stringExtra = data.getStringExtra("RESULT_EXTRA_CHANNEL_NAME");
                    int intExtra = data.getIntExtra("RESULT_EXTRA_CHANNEL_ICON_RES_ID", -1);
                    if (longExtra != -1) {
                        if ((stringExtra == null || C12103t.isBlank(stringExtra)) || intExtra == -1) {
                            return;
                        }
                        callback.invoke(Long.valueOf(longExtra), stringExtra, Integer.valueOf(intExtra));
                    }
                }
            });
            C12238m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public final void show(Context context, long guildId, int type, Long categoryId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra(WidgetCreateChannel.INTENT_GUILD_ID, guildId);
            intent.putExtra(WidgetCreateChannel.INTENT_TYPE, type);
            intent.putExtra(WidgetCreateChannel.INTENT_CATEGORY_ID, categoryId);
            C0870j.m156d(context, WidgetCreateChannel.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetCreateChannel.kt */
    public static final class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canCreate;
        private final boolean canCreateCommunityChannels;
        private final boolean canCreateForumChannels;
        private final boolean canManageRoles;
        private final List<SingleTypePayload<GuildRole>> roleItems;

        /* JADX INFO: compiled from: WidgetCreateChannel.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId, Long categoryId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11071f = Observable.m11071f(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeGuild(guildId), companion.getPermissions().observePermissionsForGuild(guildId), companion.getPermissions().observePermissionsForChannel(categoryId != null ? categoryId.longValue() : 0L), companion.getGuilds().observeSortedRoles(guildId), ForumUtils.observeCanCreateForumChannels$default(ForumUtils.INSTANCE, guildId, null, null, 6, null), new Func6<MeUser, Guild, Long, Long, List<? extends GuildRole>, Boolean, Model>() { // from class: com.discord.widgets.channels.WidgetCreateChannel$Model$Companion$get$1
                    @Override // p658rx.functions.Func6
                    public /* bridge */ /* synthetic */ WidgetCreateChannel.Model call(MeUser meUser, Guild guild, Long l, Long l2, List<? extends GuildRole> list, Boolean bool) {
                        return call2(meUser, guild, l, l2, (List<GuildRole>) list, bool);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final WidgetCreateChannel.Model call2(MeUser meUser, Guild guild, Long l, Long l2, List<GuildRole> list, Boolean bool) {
                        if (guild == null || l == null || list == null) {
                            return null;
                        }
                        C12238m.checkNotNullExpressionValue(bool, "canCreateForumChannels");
                        boolean zBooleanValue = bool.booleanValue();
                        boolean zCanAndIsElevated = PermissionUtils.canAndIsElevated(16L, Long.valueOf(l2 != null ? l2.longValue() : l.longValue()), meUser.getMfaEnabled(), guild.getMfaLevel());
                        boolean zContains = guild.getFeatures().contains(GuildFeature.COMMUNITY);
                        boolean zCanAndIsElevated2 = PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, Long.valueOf(l2 != null ? l2.longValue() : l.longValue()), meUser.getMfaEnabled(), guild.getMfaLevel());
                        ArrayList arrayList = new ArrayList();
                        for (GuildRole guildRole : list) {
                            SingleTypePayload singleTypePayload = guildRole.getId() != guild.getId() ? new SingleTypePayload(guildRole, String.valueOf(guildRole.getId()), 0) : null;
                            if (singleTypePayload != null) {
                                arrayList.add(singleTypePayload);
                            }
                        }
                        return new WidgetCreateChannel.Model(zBooleanValue, zCanAndIsElevated, zCanAndIsElevated2, zContains, arrayList, null);
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11071f, "Observable\n            .…          }\n            }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11071f).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "Observable\n            .…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Model(boolean z2, boolean z3, boolean z4, boolean z5, List<SingleTypePayload<GuildRole>> list) {
            this.canCreateForumChannels = z2;
            this.canCreate = z3;
            this.canManageRoles = z4;
            this.canCreateCommunityChannels = z5;
            this.roleItems = list;
        }

        public final boolean getCanCreate() {
            return this.canCreate;
        }

        public final boolean getCanCreateCommunityChannels() {
            return this.canCreateCommunityChannels;
        }

        public final boolean getCanCreateForumChannels() {
            return this.canCreateForumChannels;
        }

        public final boolean getCanManageRoles() {
            return this.canManageRoles;
        }

        public final List<SingleTypePayload<GuildRole>> getRoleItems() {
            return this.roleItems;
        }

        public /* synthetic */ Model(boolean z2, boolean z3, boolean z4, boolean z5, List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, z3, z4, z5, list);
        }
    }

    /* JADX INFO: compiled from: WidgetCreateChannel.kt */
    public static final class RolesAdapter extends MGRecyclerAdapterSimple<SingleTypePayload<GuildRole>> {
        private final Map<Long, Integer> checkedRoles;

        /* JADX INFO: compiled from: WidgetCreateChannel.kt */
        public static final class RoleListItem extends MGRecyclerViewHolder<RolesAdapter, SingleTypePayload<GuildRole>> {
            private final ViewCheckableRoleListItemThemedBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RoleListItem(RolesAdapter rolesAdapter) {
                super(C5419R.layout.view_checkable_role_list_item_themed, rolesAdapter);
                C12238m.checkNotNullParameter(rolesAdapter, "adapter");
                View view = this.itemView;
                Objects.requireNonNull(view, "rootView");
                CheckedSetting checkedSetting = (CheckedSetting) view;
                ViewCheckableRoleListItemThemedBinding viewCheckableRoleListItemThemedBinding = new ViewCheckableRoleListItemThemedBinding(checkedSetting, checkedSetting);
                C12238m.checkNotNullExpressionValue(viewCheckableRoleListItemThemedBinding, "ViewCheckableRoleListIte…medBinding.bind(itemView)");
                this.binding = viewCheckableRoleListItemThemedBinding;
            }

            public static final /* synthetic */ RolesAdapter access$getAdapter$p(RoleListItem roleListItem) {
                return (RolesAdapter) roleListItem.adapter;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public void onConfigure(int position, SingleTypePayload<GuildRole> data) {
                C12238m.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                final GuildRole data2 = data.getData();
                boolean zContainsKey = ((RolesAdapter) this.adapter).getCheckedRoles().containsKey(Long.valueOf(data2.getId()));
                CheckedSetting checkedSetting = this.binding.f15400b;
                C12238m.checkNotNullExpressionValue(checkedSetting, "binding.roleItemCheckedSetting");
                checkedSetting.setChecked(zContainsKey);
                this.binding.f15400b.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetCreateChannel$RolesAdapter$RoleListItem$onConfigure$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetCreateChannel.RolesAdapter rolesAdapterAccess$getAdapter$p = WidgetCreateChannel.RolesAdapter.RoleListItem.access$getAdapter$p(this.this$0);
                        CheckedSetting checkedSetting2 = this.this$0.binding.f15400b;
                        C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.roleItemCheckedSetting");
                        rolesAdapterAccess$getAdapter$p.onRoleClicked(!checkedSetting2.isChecked(), this.this$0.getAdapterPosition(), data2.getId());
                    }
                });
                this.binding.f15400b.setText(data2.getName());
                CheckedSetting checkedSetting2 = this.binding.f15400b;
                C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.roleItemCheckedSetting");
                Context context = checkedSetting2.getContext();
                C12238m.checkNotNullExpressionValue(context, "binding.roleItemCheckedSetting.context");
                checkedSetting2.setTextColor(RoleUtils.getRoleColor$default(data2, context, null, 2, null));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RolesAdapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            C12238m.checkNotNullParameter(recyclerView, "recycler");
            this.checkedRoles = new HashMap();
        }

        private final void onRoleClicked(boolean checked, int position, long roleId) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(position));
            if (checked) {
                this.checkedRoles.put(Long.valueOf(roleId), Integer.valueOf(position));
            } else {
                this.checkedRoles.remove(Long.valueOf(roleId));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                if (iIntValue < getPageSize()) {
                    notifyItemChanged(iIntValue);
                }
            }
        }

        public final Map<Long, Integer> getCheckedRoles() {
            return this.checkedRoles;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple
        public void setData(List<SingleTypePayload<GuildRole>> data) {
            C12238m.checkNotNullParameter(data, "data");
            super.setData(data);
            this.checkedRoles.clear();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<?, SingleTypePayload<GuildRole>> onCreateViewHolder(ViewGroup parent, int viewType) {
            C12238m.checkNotNullParameter(parent, "parent");
            return new RoleListItem(this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetCreateChannel$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetCreateChannel.kt */
    public static final /* synthetic */ class C73711 extends C12236k implements Function1<Model, Unit> {
        public C73711(WidgetCreateChannel widgetCreateChannel) {
            super(1, widgetCreateChannel, WidgetCreateChannel.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/WidgetCreateChannel$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            ((WidgetCreateChannel) this.receiver).configureUI(model);
        }
    }

    public WidgetCreateChannel() {
        super(C5419R.layout.widget_create_channel);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetCreateChannel$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetCreateChannel$guildId$2(this));
        this.type = C12083g.lazy(new WidgetCreateChannel$type$2(this));
        this.categoryId = C12083g.lazy(new WidgetCreateChannel$categoryId$2(this));
        this.provideResultOnly = C12083g.lazy(new WidgetCreateChannel$provideResultOnly$2(this));
        this.shouldChannelDefaultPrivate = C12083g.lazy(new WidgetCreateChannel$shouldChannelDefaultPrivate$2(this));
        this.disablePrivateSwitch = C12083g.lazy(new WidgetCreateChannel$disablePrivateSwitch$2(this));
        this.disableAnnouncementChannelType = C12083g.lazy(new WidgetCreateChannel$disableAnnouncementChannelType$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetCreateChannel$loggingConfig$1.INSTANCE, 3);
    }

    private final void configurePrivateRoles() {
        boolean z2 = (getChannelType() == 13 || getDisablePrivateSwitch()) ? false : true;
        SwitchCompat switchCompat = getBinding().f16427i;
        C12238m.checkNotNullExpressionValue(switchCompat, "binding.createChannelPrivateSwitch");
        boolean zIsChecked = switchCompat.isChecked();
        RelativeLayout relativeLayout = getBinding().f16425g;
        C12238m.checkNotNullExpressionValue(relativeLayout, "binding.createChannelPrivateContainer");
        relativeLayout.setVisibility(z2 ? 0 : 8);
        View view = getBinding().f16430l;
        C12238m.checkNotNullExpressionValue(view, "binding.createChannelRoleDivider");
        view.setVisibility(z2 ? 0 : 8);
        TextView textView = getBinding().f16431m;
        C12238m.checkNotNullExpressionValue(textView, "binding.createChannelRoleHeader");
        textView.setVisibility(z2 && zIsChecked ? 0 : 8);
        RecyclerView recyclerView = getBinding().f16429k;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.createChannelRoleAccessRecycler");
        recyclerView.setVisibility(z2 && zIsChecked ? 0 : 8);
    }

    private final void configureUI(Model model) {
        if (model == null || !model.getCanCreate()) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(getType() == 4 ? C5419R.string.create_category : C5419R.string.create_channel);
        AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_channel_create, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.channels.WidgetCreateChannel.configureUI.1

            /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetCreateChannel$configureUI$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetCreateChannel.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Channel, TrackNetworkMetadataReceiver> {
                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final TrackNetworkMetadataReceiver invoke(Channel channel) {
                    List<PermissionOverwrite> listM7655v;
                    return new TrackNetworkActionChannelCreate((channel == null || (listM7655v = channel.m7655v()) == null) ? null : Boolean.valueOf(!listM7655v.isEmpty()), channel != null ? Long.valueOf(channel.getType()) : null, channel != null ? Long.valueOf(channel.getId()) : null, channel != null ? Long.valueOf(channel.getParentId()) : null, Long.valueOf(WidgetCreateChannel.this.getGuildId()));
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetCreateChannel$configureUI$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetCreateChannel.kt */
            public static final /* synthetic */ class AnonymousClass2 extends C12236k implements Function1<Channel, Unit> {
                public AnonymousClass2(WidgetCreateChannel widgetCreateChannel) {
                    super(1, widgetCreateChannel, WidgetCreateChannel.class, "onChannelCreated", "onChannelCreated(Lcom/discord/api/channel/Channel;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
                    invoke2(channel);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Channel channel) {
                    C12238m.checkNotNullParameter(channel, "p1");
                    ((WidgetCreateChannel) this.receiver).onChannelCreated(channel);
                }
            }

            @Override // p658rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                C12238m.checkNotNullParameter(menuItem, "menuItem");
                if (menuItem.getItemId() == C5419R.id.menu_sort_channel) {
                    RestAPI api = RestAPI.INSTANCE.getApi();
                    long guildId = WidgetCreateChannel.this.getGuildId();
                    int channelType = WidgetCreateChannel.this.getChannelType();
                    TextInputLayout textInputLayout = WidgetCreateChannel.this.getBinding().f16424f;
                    C12238m.checkNotNullExpressionValue(textInputLayout, "binding.createChannelNameLayout");
                    ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(api.createGuildChannel(guildId, new RestAPIParams.CreateGuildChannel(channelType, null, ViewExtensions.getTextOrEmpty(textInputLayout), WidgetCreateChannel.this.getCategoryId(), WidgetCreateChannel.this.getPermissionOverwrites(), null)), new AnonymousClass1()), false, 1, null), WidgetCreateChannel.this, null, 2, null), (Class<?>) WidgetCreateChannel.this.getClass(), (58 & 2) != 0 ? null : WidgetCreateChannel.this.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass2(WidgetCreateChannel.this));
                }
            }
        }, null, 4, null);
        ConstraintLayout constraintLayout = getBinding().f16420b;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.createChannelAnnouncementsContainer");
        constraintLayout.setVisibility(model.getCanCreateCommunityChannels() && !getDisableAnnouncementChannelType() ? 0 : 8);
        ConstraintLayout constraintLayout2 = getBinding().f16432n;
        C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.createChannelStageContainer");
        constraintLayout2.setVisibility(model.getCanCreateCommunityChannels() && model.getCanManageRoles() ? 0 : 8);
        ConstraintLayout constraintLayout3 = getBinding().f16422d;
        C12238m.checkNotNullExpressionValue(constraintLayout3, "binding.createChannelForumContainer");
        constraintLayout3.setVisibility(model.getCanCreateForumChannels() ? 0 : 8);
        RolesAdapter rolesAdapter = this.rolesAdapter;
        if (rolesAdapter != null) {
            rolesAdapter.setData(model.getRoleItems());
        }
    }

    private final void finishActivity() {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }

    private final WidgetCreateChannelBinding getBinding() {
        return (WidgetCreateChannelBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getCategoryId() {
        return (Long) this.categoryId.getValue();
    }

    private final int getChannelType() {
        if (getType() == 4) {
            return 4;
        }
        RadioButton radioButton = getBinding().f16438t;
        C12238m.checkNotNullExpressionValue(radioButton, "binding.createChannelVoiceRadio");
        if (radioButton.isChecked()) {
            return 2;
        }
        RadioButton radioButton2 = getBinding().f16421c;
        C12238m.checkNotNullExpressionValue(radioButton2, "binding.createChannelAnnouncementsRadio");
        if (radioButton2.isChecked()) {
            return 5;
        }
        RadioButton radioButton3 = getBinding().f16433o;
        C12238m.checkNotNullExpressionValue(radioButton3, "binding.createChannelStageRadio");
        if (radioButton3.isChecked()) {
            return 13;
        }
        RadioButton radioButton4 = getBinding().f16423e;
        C12238m.checkNotNullExpressionValue(radioButton4, "binding.createChannelForumRadio");
        return radioButton4.isChecked() ? 15 : 0;
    }

    private final boolean getDisableAnnouncementChannelType() {
        return ((Boolean) this.disableAnnouncementChannelType.getValue()).booleanValue();
    }

    private final boolean getDisablePrivateSwitch() {
        return ((Boolean) this.disablePrivateSwitch.getValue()).booleanValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    private final List<RestAPIParams.ChannelPermissionOverwrites> getPermissionOverwrites() {
        Map<Long, Integer> checkedRoles;
        Set<Long> setKeySet;
        Map<Long, Integer> checkedRoles2;
        Set<Long> setKeySet2;
        if (!(getChannelType() != 13)) {
            if (getDisablePrivateSwitch()) {
            }
            return null;
        }
        SwitchCompat switchCompat = getBinding().f16427i;
        C12238m.checkNotNullExpressionValue(switchCompat, "binding.createChannelPrivateSwitch");
        if (!switchCompat.isChecked()) {
            if (getDisablePrivateSwitch() || !getShouldChannelDefaultPrivate()) {
                return null;
            }
        }
        RolesAdapter rolesAdapter = this.rolesAdapter;
        if (rolesAdapter != null && (checkedRoles2 = rolesAdapter.getCheckedRoles()) != null && (setKeySet2 = checkedRoles2.keySet()) != null && setKeySet2.contains(Long.valueOf(getGuildId()))) {
            return null;
        }
        long j = (getChannelType() == 2 || getChannelType() == 13) ? Permission.CONNECT : Permission.VIEW_CHANNEL;
        ArrayList arrayList = new ArrayList();
        arrayList.add(RestAPIParams.ChannelPermissionOverwrites.INSTANCE.createForRole(getGuildId(), 0L, Long.valueOf(j)));
        RolesAdapter rolesAdapter2 = this.rolesAdapter;
        if (rolesAdapter2 != null && (checkedRoles = rolesAdapter2.getCheckedRoles()) != null && (setKeySet = checkedRoles.keySet()) != null) {
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(RestAPIParams.ChannelPermissionOverwrites.INSTANCE.createForRole(((Number) it.next()).longValue(), Long.valueOf(j), 0L));
            }
        }
        return arrayList;
    }

    private final boolean getProvideResultOnly() {
        return ((Boolean) this.provideResultOnly.getValue()).booleanValue();
    }

    private final boolean getShouldChannelDefaultPrivate() {
        return ((Boolean) this.shouldChannelDefaultPrivate.getValue()).booleanValue();
    }

    private final int getType() {
        return ((Number) this.type.getValue()).intValue();
    }

    private final void onChannelCreated(Channel channel) {
        if (getProvideResultOnly()) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intent intent = new Intent();
            intent.putExtra(RESULT_EXTRA_CHANNEL_ID, channel.getId());
            intent.putExtra(RESULT_EXTRA_CHANNEL_NAME, ChannelUtils.m7679c(channel));
            intent.putExtra(RESULT_EXTRA_CHANNEL_ICON_RES_ID, GuildChannelIconUtilsKt.guildChannelIcon(channel));
            fragmentActivityRequireActivity.setResult(-1, intent);
            finishActivity();
            return;
        }
        if (channel.getType() == 0) {
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel, null, null, 6, null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        boolean zComputeCanEditStageModerators = StageChannelUtils.computeCanEditStageModerators(companion.getPermissions(), companion.getGuilds(), companion.getUsers().getMeSnapshot().getId(), getGuildId(), channel);
        if (channel.getType() == 13 && zComputeCanEditStageModerators) {
            WidgetCreateChannelAddMember.INSTANCE.create(requireContext(), channel.getId());
        }
        finishActivity();
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
        RecyclerView recyclerView = getBinding().f16429k;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.createChannelRoleAccessRecycler");
        this.rolesAdapter = (RolesAdapter) companion.configure(new RolesAdapter(recyclerView));
        getBinding().f16429k.setHasFixedSize(false);
        RecyclerView recyclerView2 = getBinding().f16429k;
        C12238m.checkNotNullExpressionValue(recyclerView2, "binding.createChannelRoleAccessRecycler");
        recyclerView2.setNestedScrollingEnabled(false);
        SwitchCompat switchCompat = getBinding().f16427i;
        C12238m.checkNotNullExpressionValue(switchCompat, "binding.createChannelPrivateSwitch");
        switchCompat.setChecked(getShouldChannelDefaultPrivate() || getDisablePrivateSwitch());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getGuildId(), getCategoryId()), this, null, 2, null), (Class<?>) WidgetCreateChannel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C73711(this));
        final RadioManager radioManager = new RadioManager(C12147n.listOf((Object[]) new RadioButton[]{getBinding().f16435q, getBinding().f16438t, getBinding().f16421c, getBinding().f16433o, getBinding().f16423e}));
        getBinding().f16434p.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetCreateChannel.onViewBoundOrOnResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RadioManager radioManager2 = radioManager;
                RadioButton radioButton = WidgetCreateChannel.this.getBinding().f16435q;
                C12238m.checkNotNullExpressionValue(radioButton, "binding.createChannelTextRadio");
                radioManager2.m8550a(radioButton);
                WidgetCreateChannel.this.configurePrivateRoles();
            }
        });
        getBinding().f16437s.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetCreateChannel.onViewBoundOrOnResume.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RadioManager radioManager2 = radioManager;
                RadioButton radioButton = WidgetCreateChannel.this.getBinding().f16438t;
                C12238m.checkNotNullExpressionValue(radioButton, "binding.createChannelVoiceRadio");
                radioManager2.m8550a(radioButton);
                WidgetCreateChannel.this.configurePrivateRoles();
            }
        });
        getBinding().f16420b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetCreateChannel.onViewBoundOrOnResume.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RadioManager radioManager2 = radioManager;
                RadioButton radioButton = WidgetCreateChannel.this.getBinding().f16421c;
                C12238m.checkNotNullExpressionValue(radioButton, "binding.createChannelAnnouncementsRadio");
                radioManager2.m8550a(radioButton);
                WidgetCreateChannel.this.configurePrivateRoles();
            }
        });
        getBinding().f16432n.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetCreateChannel.onViewBoundOrOnResume.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RadioManager radioManager2 = radioManager;
                RadioButton radioButton = WidgetCreateChannel.this.getBinding().f16433o;
                C12238m.checkNotNullExpressionValue(radioButton, "binding.createChannelStageRadio");
                radioManager2.m8550a(radioButton);
                WidgetCreateChannel.this.configurePrivateRoles();
            }
        });
        getBinding().f16422d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetCreateChannel.onViewBoundOrOnResume.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RadioManager radioManager2 = radioManager;
                RadioButton radioButton = WidgetCreateChannel.this.getBinding().f16423e;
                C12238m.checkNotNullExpressionValue(radioButton, "binding.createChannelForumRadio");
                radioManager2.m8550a(radioButton);
                WidgetCreateChannel.this.configurePrivateRoles();
            }
        });
        int type = getType();
        if (type == 0) {
            RadioButton radioButton = getBinding().f16435q;
            C12238m.checkNotNullExpressionValue(radioButton, "binding.createChannelTextRadio");
            radioManager.m8550a(radioButton);
        } else if (type == 2) {
            RadioButton radioButton2 = getBinding().f16438t;
            C12238m.checkNotNullExpressionValue(radioButton2, "binding.createChannelVoiceRadio");
            radioManager.m8550a(radioButton2);
        } else if (type == 5) {
            RadioButton radioButton3 = getBinding().f16421c;
            C12238m.checkNotNullExpressionValue(radioButton3, "binding.createChannelAnnouncementsRadio");
            radioManager.m8550a(radioButton3);
        } else if (type == 13) {
            RadioButton radioButton4 = getBinding().f16433o;
            C12238m.checkNotNullExpressionValue(radioButton4, "binding.createChannelStageRadio");
            radioManager.m8550a(radioButton4);
        } else if (type == 15) {
            RadioButton radioButton5 = getBinding().f16423e;
            C12238m.checkNotNullExpressionValue(radioButton5, "binding.createChannelForumRadio");
            radioManager.m8550a(radioButton5);
        }
        configurePrivateRoles();
        getBinding().f16425g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetCreateChannel.onViewBoundOrOnResume.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SwitchCompat switchCompat = WidgetCreateChannel.this.getBinding().f16427i;
                C12238m.checkNotNullExpressionValue(switchCompat, "binding.createChannelPrivateSwitch");
                SwitchCompat switchCompat2 = WidgetCreateChannel.this.getBinding().f16427i;
                C12238m.checkNotNullExpressionValue(switchCompat2, "binding.createChannelPrivateSwitch");
                switchCompat.setChecked(!switchCompat2.isChecked());
                WidgetCreateChannel.this.configurePrivateRoles();
            }
        });
        LinearLayout linearLayout = getBinding().f16436r;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.createChannelTypeContainer");
        linearLayout.setVisibility(getType() != 4 ? 0 : 8);
        getBinding().f16428j.setText(getType() == 4 ? C5419R.string.private_category : C5419R.string.private_channel);
        getBinding().f16426h.setText(getType() == 4 ? C5419R.string.private_category_note : C5419R.string.private_channel_note);
        getBinding().f16431m.setText(getType() == 4 ? C5419R.string.form_label_category_permissions : C5419R.string.form_label_channel_permissions);
        TextInputLayout textInputLayout = getBinding().f16424f;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.createChannelNameLayout");
        textInputLayout.setHint(getString(getType() == 4 ? C5419R.string.category_name : C5419R.string.form_label_channel_name));
    }
}
