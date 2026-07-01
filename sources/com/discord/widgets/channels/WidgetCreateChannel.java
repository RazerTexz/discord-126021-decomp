package com.discord.widgets.channels;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetCreateChannelBinding;
import com.discord.restapi.RestAPIParams$ChannelPermissionOverwrites;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.channel.GuildChannelIconUtilsKt;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stage.StageChannelUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.RadioManager;
import com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.t.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannel extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetCreateChannel.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCreateChannelBinding;", 0)};
    public static final WidgetCreateChannel$Companion Companion = new WidgetCreateChannel$Companion(null);
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
    private WidgetCreateChannel$RolesAdapter rolesAdapter;

    /* JADX INFO: renamed from: shouldChannelDefaultPrivate$delegate, reason: from kotlin metadata */
    private final Lazy shouldChannelDefaultPrivate;

    /* JADX INFO: renamed from: type$delegate, reason: from kotlin metadata */
    private final Lazy type;

    public WidgetCreateChannel() {
        super(R$layout.widget_create_channel);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetCreateChannel$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetCreateChannel$guildId$2(this));
        this.type = g.lazy(new WidgetCreateChannel$type$2(this));
        this.categoryId = g.lazy(new WidgetCreateChannel$categoryId$2(this));
        this.provideResultOnly = g.lazy(new WidgetCreateChannel$provideResultOnly$2(this));
        this.shouldChannelDefaultPrivate = g.lazy(new WidgetCreateChannel$shouldChannelDefaultPrivate$2(this));
        this.disablePrivateSwitch = g.lazy(new WidgetCreateChannel$disablePrivateSwitch$2(this));
        this.disableAnnouncementChannelType = g.lazy(new WidgetCreateChannel$disableAnnouncementChannelType$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetCreateChannel$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configurePrivateRoles(WidgetCreateChannel widgetCreateChannel) {
        widgetCreateChannel.configurePrivateRoles();
    }

    public static final /* synthetic */ void access$configureUI(WidgetCreateChannel widgetCreateChannel, WidgetCreateChannel$Model widgetCreateChannel$Model) {
        widgetCreateChannel.configureUI(widgetCreateChannel$Model);
    }

    public static final /* synthetic */ WidgetCreateChannelBinding access$getBinding$p(WidgetCreateChannel widgetCreateChannel) {
        return widgetCreateChannel.getBinding();
    }

    public static final /* synthetic */ Long access$getCategoryId$p(WidgetCreateChannel widgetCreateChannel) {
        return widgetCreateChannel.getCategoryId();
    }

    public static final /* synthetic */ int access$getChannelType$p(WidgetCreateChannel widgetCreateChannel) {
        return widgetCreateChannel.getChannelType();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetCreateChannel widgetCreateChannel) {
        return widgetCreateChannel.getGuildId();
    }

    public static final /* synthetic */ List access$getPermissionOverwrites(WidgetCreateChannel widgetCreateChannel) {
        return widgetCreateChannel.getPermissionOverwrites();
    }

    public static final /* synthetic */ void access$onChannelCreated(WidgetCreateChannel widgetCreateChannel, Channel channel) {
        widgetCreateChannel.onChannelCreated(channel);
    }

    private final void configurePrivateRoles() {
        boolean z2 = (getChannelType() == 13 || getDisablePrivateSwitch()) ? false : true;
        SwitchCompat switchCompat = getBinding().i;
        m.checkNotNullExpressionValue(switchCompat, "binding.createChannelPrivateSwitch");
        boolean zIsChecked = switchCompat.isChecked();
        RelativeLayout relativeLayout = getBinding().g;
        m.checkNotNullExpressionValue(relativeLayout, "binding.createChannelPrivateContainer");
        relativeLayout.setVisibility(z2 ? 0 : 8);
        View view = getBinding().l;
        m.checkNotNullExpressionValue(view, "binding.createChannelRoleDivider");
        view.setVisibility(z2 ? 0 : 8);
        TextView textView = getBinding().m;
        m.checkNotNullExpressionValue(textView, "binding.createChannelRoleHeader");
        textView.setVisibility(z2 && zIsChecked ? 0 : 8);
        RecyclerView recyclerView = getBinding().k;
        m.checkNotNullExpressionValue(recyclerView, "binding.createChannelRoleAccessRecycler");
        recyclerView.setVisibility(z2 && zIsChecked ? 0 : 8);
    }

    private final void configureUI(WidgetCreateChannel$Model model) {
        if (model == null || !model.getCanCreate()) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(getType() == 4 ? 2131888220 : 2131888221);
        AppFragment.setActionBarOptionsMenu$default(this, R$menu.menu_channel_create, new WidgetCreateChannel$configureUI$1(this), null, 4, null);
        ConstraintLayout constraintLayout = getBinding().f2357b;
        m.checkNotNullExpressionValue(constraintLayout, "binding.createChannelAnnouncementsContainer");
        constraintLayout.setVisibility(model.getCanCreateCommunityChannels() && !getDisableAnnouncementChannelType() ? 0 : 8);
        ConstraintLayout constraintLayout2 = getBinding().n;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.createChannelStageContainer");
        constraintLayout2.setVisibility(model.getCanCreateCommunityChannels() && model.getCanManageRoles() ? 0 : 8);
        ConstraintLayout constraintLayout3 = getBinding().d;
        m.checkNotNullExpressionValue(constraintLayout3, "binding.createChannelForumContainer");
        constraintLayout3.setVisibility(model.getCanCreateForumChannels() ? 0 : 8);
        WidgetCreateChannel$RolesAdapter widgetCreateChannel$RolesAdapter = this.rolesAdapter;
        if (widgetCreateChannel$RolesAdapter != null) {
            widgetCreateChannel$RolesAdapter.setData(model.getRoleItems());
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
        RadioButton radioButton = getBinding().t;
        m.checkNotNullExpressionValue(radioButton, "binding.createChannelVoiceRadio");
        if (radioButton.isChecked()) {
            return 2;
        }
        RadioButton radioButton2 = getBinding().c;
        m.checkNotNullExpressionValue(radioButton2, "binding.createChannelAnnouncementsRadio");
        if (radioButton2.isChecked()) {
            return 5;
        }
        RadioButton radioButton3 = getBinding().o;
        m.checkNotNullExpressionValue(radioButton3, "binding.createChannelStageRadio");
        if (radioButton3.isChecked()) {
            return 13;
        }
        RadioButton radioButton4 = getBinding().e;
        m.checkNotNullExpressionValue(radioButton4, "binding.createChannelForumRadio");
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
    private final List<RestAPIParams$ChannelPermissionOverwrites> getPermissionOverwrites() {
        Map<Long, Integer> checkedRoles;
        Set<Long> setKeySet;
        Map<Long, Integer> checkedRoles2;
        Set<Long> setKeySet2;
        if (!(getChannelType() != 13)) {
            if (getDisablePrivateSwitch()) {
            }
            return null;
        }
        SwitchCompat switchCompat = getBinding().i;
        m.checkNotNullExpressionValue(switchCompat, "binding.createChannelPrivateSwitch");
        if (!switchCompat.isChecked()) {
            if (getDisablePrivateSwitch() || !getShouldChannelDefaultPrivate()) {
                return null;
            }
        }
        WidgetCreateChannel$RolesAdapter widgetCreateChannel$RolesAdapter = this.rolesAdapter;
        if (widgetCreateChannel$RolesAdapter != null && (checkedRoles2 = widgetCreateChannel$RolesAdapter.getCheckedRoles()) != null && (setKeySet2 = checkedRoles2.keySet()) != null && setKeySet2.contains(Long.valueOf(getGuildId()))) {
            return null;
        }
        long j = (getChannelType() == 2 || getChannelType() == 13) ? Permission.CONNECT : Permission.VIEW_CHANNEL;
        ArrayList arrayList = new ArrayList();
        arrayList.add(RestAPIParams$ChannelPermissionOverwrites.Companion.createForRole(getGuildId(), 0L, Long.valueOf(j)));
        WidgetCreateChannel$RolesAdapter widgetCreateChannel$RolesAdapter2 = this.rolesAdapter;
        if (widgetCreateChannel$RolesAdapter2 != null && (checkedRoles = widgetCreateChannel$RolesAdapter2.getCheckedRoles()) != null && (setKeySet = checkedRoles.keySet()) != null) {
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(RestAPIParams$ChannelPermissionOverwrites.Companion.createForRole(((Number) it.next()).longValue(), Long.valueOf(j), 0L));
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
            intent.putExtra(RESULT_EXTRA_CHANNEL_NAME, ChannelUtils.c(channel));
            intent.putExtra(RESULT_EXTRA_CHANNEL_ICON_RES_ID, GuildChannelIconUtilsKt.guildChannelIcon(channel));
            fragmentActivityRequireActivity.setResult(-1, intent);
            finishActivity();
            return;
        }
        if (channel.getType() == 0) {
            ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), channel, null, null, 6, null);
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        boolean zComputeCanEditStageModerators = StageChannelUtils.computeCanEditStageModerators(storeStream$Companion.getPermissions(), storeStream$Companion.getGuilds(), storeStream$Companion.getUsers().getMeSnapshot().getId(), getGuildId(), channel);
        if (channel.getType() == 13 && zComputeCanEditStageModerators) {
            WidgetCreateChannelAddMember.Companion.create(requireContext(), channel.getId());
        }
        finishActivity();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().k;
        m.checkNotNullExpressionValue(recyclerView, "binding.createChannelRoleAccessRecycler");
        this.rolesAdapter = (WidgetCreateChannel$RolesAdapter) mGRecyclerAdapter$Companion.configure(new WidgetCreateChannel$RolesAdapter(recyclerView));
        getBinding().k.setHasFixedSize(false);
        RecyclerView recyclerView2 = getBinding().k;
        m.checkNotNullExpressionValue(recyclerView2, "binding.createChannelRoleAccessRecycler");
        recyclerView2.setNestedScrollingEnabled(false);
        SwitchCompat switchCompat = getBinding().i;
        m.checkNotNullExpressionValue(switchCompat, "binding.createChannelPrivateSwitch");
        switchCompat.setChecked(getShouldChannelDefaultPrivate() || getDisablePrivateSwitch());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetCreateChannel$Model.Companion.get(getGuildId(), getCategoryId()), this, null, 2, null), WidgetCreateChannel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetCreateChannel$onViewBoundOrOnResume$1(this), 62, (Object) null);
        RadioManager radioManager = new RadioManager(n.listOf((Object[]) new RadioButton[]{getBinding().q, getBinding().t, getBinding().c, getBinding().o, getBinding().e}));
        getBinding().p.setOnClickListener(new WidgetCreateChannel$onViewBoundOrOnResume$2(this, radioManager));
        getBinding().f2358s.setOnClickListener(new WidgetCreateChannel$onViewBoundOrOnResume$3(this, radioManager));
        getBinding().f2357b.setOnClickListener(new WidgetCreateChannel$onViewBoundOrOnResume$4(this, radioManager));
        getBinding().n.setOnClickListener(new WidgetCreateChannel$onViewBoundOrOnResume$5(this, radioManager));
        getBinding().d.setOnClickListener(new WidgetCreateChannel$onViewBoundOrOnResume$6(this, radioManager));
        int type = getType();
        if (type == 0) {
            RadioButton radioButton = getBinding().q;
            m.checkNotNullExpressionValue(radioButton, "binding.createChannelTextRadio");
            radioManager.a(radioButton);
        } else if (type == 2) {
            RadioButton radioButton2 = getBinding().t;
            m.checkNotNullExpressionValue(radioButton2, "binding.createChannelVoiceRadio");
            radioManager.a(radioButton2);
        } else if (type == 5) {
            RadioButton radioButton3 = getBinding().c;
            m.checkNotNullExpressionValue(radioButton3, "binding.createChannelAnnouncementsRadio");
            radioManager.a(radioButton3);
        } else if (type == 13) {
            RadioButton radioButton4 = getBinding().o;
            m.checkNotNullExpressionValue(radioButton4, "binding.createChannelStageRadio");
            radioManager.a(radioButton4);
        } else if (type == 15) {
            RadioButton radioButton5 = getBinding().e;
            m.checkNotNullExpressionValue(radioButton5, "binding.createChannelForumRadio");
            radioManager.a(radioButton5);
        }
        configurePrivateRoles();
        getBinding().g.setOnClickListener(new WidgetCreateChannel$onViewBoundOrOnResume$7(this));
        LinearLayout linearLayout = getBinding().r;
        m.checkNotNullExpressionValue(linearLayout, "binding.createChannelTypeContainer");
        linearLayout.setVisibility(getType() != 4 ? 0 : 8);
        getBinding().j.setText(getType() == 4 ? 2131894541 : 2131894544);
        getBinding().h.setText(getType() == 4 ? 2131894543 : 2131894568);
        getBinding().m.setText(getType() == 4 ? 2131889145 : 2131889149);
        TextInputLayout textInputLayout = getBinding().f;
        m.checkNotNullExpressionValue(textInputLayout, "binding.createChannelNameLayout");
        textInputLayout.setHint(getString(getType() == 4 ? 2131887468 : 2131889147));
    }
}
