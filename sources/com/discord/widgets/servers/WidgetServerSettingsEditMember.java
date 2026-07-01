package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsEditMemberBinding;
import com.discord.models.member.GuildMember;
import com.discord.models.member.GuildMember$Companion;
import com.discord.restapi.RestAPIParams$GuildMember;
import com.discord.restapi.RestAPIParams$Nick;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditMember extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsEditMember.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEditMemberBinding;", 0)};
    public static final WidgetServerSettingsEditMember$Companion Companion = new WidgetServerSettingsEditMember$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_USER_ID = "INTENT_EXTRA_USER_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetServerSettingsEditMemberRolesAdapter rolesAdapter;
    private final StatefulViews state;

    public WidgetServerSettingsEditMember() {
        super(R$layout.widget_server_settings_edit_member);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsEditMember$binding$2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R$id.edit_member_nickname);
    }

    public static final /* synthetic */ void access$changeNickname(WidgetServerSettingsEditMember widgetServerSettingsEditMember, WidgetServerSettingsEditMember$Model widgetServerSettingsEditMember$Model, String str) {
        widgetServerSettingsEditMember.changeNickname(widgetServerSettingsEditMember$Model, str);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsEditMember widgetServerSettingsEditMember, WidgetServerSettingsEditMember$Model widgetServerSettingsEditMember$Model) {
        widgetServerSettingsEditMember.configureUI(widgetServerSettingsEditMember$Model);
    }

    public static final /* synthetic */ WidgetServerSettingsEditMemberBinding access$getBinding$p(WidgetServerSettingsEditMember widgetServerSettingsEditMember) {
        return widgetServerSettingsEditMember.getBinding();
    }

    public static final /* synthetic */ void access$onNicknameChangeSuccessful(WidgetServerSettingsEditMember widgetServerSettingsEditMember, String str) {
        widgetServerSettingsEditMember.onNicknameChangeSuccessful(str);
    }

    private final void changeNickname(WidgetServerSettingsEditMember$Model data, String nickname) {
        if (data.getUser().getId() == data.getMyId()) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().changeGuildNickname(data.getGuild().getId(), new RestAPIParams$Nick(nickname)), false, 1, null), this, null, 2, null), WidgetServerSettingsEditMember.class, requireContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsEditMember$changeNickname$1(this, nickname), 60, (Object) null);
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().changeGuildMember(data.getGuild().getId(), data.getUser().getId(), RestAPIParams$GuildMember.Companion.createWithNick(nickname)), false, 1, null), this, null, 2, null), WidgetServerSettingsEditMember.class, requireContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsEditMember$changeNickname$2(this, nickname), 60, (Object) null);
        }
    }

    private final void configureUI(WidgetServerSettingsEditMember$Model data) {
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
        setActionBarTitle(context != null ? b.h(context, 2131890313, new Object[]{data.getGuild().getName()}, null, 4) : null);
        GuildMember$Companion guildMember$Companion = GuildMember.Companion;
        setActionBarSubtitle(guildMember$Companion.getNickOrUsername(data.getUserComputed(), data.getUser()));
        setupNickname(data);
        setupRoles(data);
        this.state.configureSaveActionView(getBinding().h);
        getBinding().h.setOnClickListener(new WidgetServerSettingsEditMember$configureUI$1(this, data));
        String nickOrUsername = guildMember$Companion.getNickOrUsername(data.getUserComputed(), data.getUser());
        if (data.getCanDisableCommunication()) {
            boolean zIsCommunicationDisabled = data.getUserComputed().isCommunicationDisabled();
            TextView textView = getBinding().i;
            m.checkNotNullExpressionValue(textView, "binding.editMemberTimeoutButton");
            b.n(textView, zIsCommunicationDisabled ? 2131888851 : 2131888473, new Object[]{nickOrUsername}, null, 4);
            TextView textView2 = getBinding().i;
            m.checkNotNullExpressionValue(textView2, "binding.editMemberTimeoutButton");
            textView2.setVisibility(0);
            getBinding().i.setOnClickListener(new WidgetServerSettingsEditMember$configureUI$2(this, data, zIsCommunicationDisabled));
        } else {
            TextView textView3 = getBinding().i;
            m.checkNotNullExpressionValue(textView3, "binding.editMemberTimeoutButton");
            textView3.setVisibility(8);
            getBinding().i.setOnClickListener(null);
        }
        if (data.getCanKick()) {
            TextView textView4 = getBinding().d;
            m.checkNotNullExpressionValue(textView4, "binding.editMemberKickButton");
            b.n(textView4, 2131892499, new Object[]{nickOrUsername}, null, 4);
            TextView textView5 = getBinding().d;
            m.checkNotNullExpressionValue(textView5, "binding.editMemberKickButton");
            textView5.setVisibility(0);
            getBinding().d.setOnClickListener(new WidgetServerSettingsEditMember$configureUI$3(this, nickOrUsername, data));
        } else {
            TextView textView6 = getBinding().d;
            m.checkNotNullExpressionValue(textView6, "binding.editMemberKickButton");
            textView6.setVisibility(8);
            getBinding().d.setOnClickListener(null);
        }
        if (data.getCanBan()) {
            TextView textView7 = getBinding().c;
            m.checkNotNullExpressionValue(textView7, "binding.editMemberBanButton");
            b.n(textView7, 2131887004, new Object[]{nickOrUsername}, null, 4);
            TextView textView8 = getBinding().c;
            m.checkNotNullExpressionValue(textView8, "binding.editMemberBanButton");
            textView8.setVisibility(0);
            getBinding().c.setOnClickListener(new WidgetServerSettingsEditMember$configureUI$4(this, nickOrUsername, data));
        } else {
            TextView textView9 = getBinding().c;
            m.checkNotNullExpressionValue(textView9, "binding.editMemberBanButton");
            textView9.setVisibility(8);
            getBinding().c.setOnClickListener(null);
        }
        if (data.getCanTransferOwnership()) {
            TextView textView10 = getBinding().j;
            m.checkNotNullExpressionValue(textView10, "binding.editMemberTransferOwnershipButton");
            textView10.setVisibility(0);
            getBinding().j.setOnClickListener(new WidgetServerSettingsEditMember$configureUI$5(this, data));
        } else {
            TextView textView11 = getBinding().j;
            m.checkNotNullExpressionValue(textView11, "binding.editMemberTransferOwnershipButton");
            textView11.setVisibility(8);
            getBinding().j.setOnClickListener(null);
        }
        LinearLayout linearLayout = getBinding().f2561b;
        m.checkNotNullExpressionValue(linearLayout, "binding.editMemberAdministrativeContainer");
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
        b.a.d.m.j(this, nickname.length() > 0 ? b.k(this, 2131893216, new Object[]{nickname}, null, 4) : b.k(this, 2131893217, new Object[0], null, 4), 0, 4);
    }

    private final void setupNickname(WidgetServerSettingsEditMember$Model data) {
        String nick = data.getUserComputed().getNick();
        if (nick == null) {
            nick = "";
        }
        if (data.getCanChangeNickname()) {
            TextInputLayout textInputLayout = getBinding().e;
            m.checkNotNullExpressionValue(textInputLayout, "binding.editMemberNickname");
            textInputLayout.setEndIconVisible(false);
            TextInputLayout textInputLayout2 = getBinding().e;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.editMemberNickname");
            textInputLayout2.setEnabled(true);
        } else {
            TextInputLayout textInputLayout3 = getBinding().e;
            m.checkNotNullExpressionValue(textInputLayout3, "binding.editMemberNickname");
            textInputLayout3.setEndIconVisible(true);
            TextInputLayout textInputLayout4 = getBinding().e;
            m.checkNotNullExpressionValue(textInputLayout4, "binding.editMemberNickname");
            textInputLayout4.setEnabled(false);
            StatefulViews statefulViews = this.state;
            TextInputLayout textInputLayout5 = getBinding().e;
            m.checkNotNullExpressionValue(textInputLayout5, "binding.editMemberNickname");
            statefulViews.put(textInputLayout5.getId(), nick);
        }
        TextInputLayout textInputLayout6 = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout6, "binding.editMemberNickname");
        StatefulViews statefulViews2 = this.state;
        TextInputLayout textInputLayout7 = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout7, "binding.editMemberNickname");
        ViewExtensions.setText(textInputLayout6, (CharSequence) statefulViews2.get(textInputLayout7.getId(), nick));
    }

    private final void setupRoles(WidgetServerSettingsEditMember$Model data) {
        WidgetServerSettingsEditMemberRolesAdapter widgetServerSettingsEditMemberRolesAdapter;
        LinearLayout linearLayout = getBinding().f;
        m.checkNotNullExpressionValue(linearLayout, "binding.editMemberRolesContainer");
        linearLayout.setVisibility(data.getRoleItems().isEmpty() ^ true ? 0 : 8);
        if (!(!data.getRoleItems().isEmpty()) || (widgetServerSettingsEditMemberRolesAdapter = this.rolesAdapter) == null) {
            return;
        }
        widgetServerSettingsEditMemberRolesAdapter.configure(data.getRoleItems(), new WidgetServerSettingsEditMember$setupRoles$1(this, data));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().g;
        m.checkNotNullExpressionValue(recyclerView, "binding.editMemberRolesRecycler");
        this.rolesAdapter = (WidgetServerSettingsEditMemberRolesAdapter) mGRecyclerAdapter$Companion.configure(new WidgetServerSettingsEditMemberRolesAdapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().g;
        m.checkNotNullExpressionValue(recyclerView2, "binding.editMemberRolesRecycler");
        recyclerView2.setNestedScrollingEnabled(false);
        getBinding().g.setHasFixedSize(false);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout, "binding.editMemberNickname");
        statefulViews.addOptionalFields(textInputLayout);
        StatefulViews statefulViews2 = this.state;
        FloatingActionButton floatingActionButton = getBinding().h;
        TextInputLayout textInputLayout2 = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.editMemberNickname");
        statefulViews2.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        long longExtra2 = getMostRecentIntent().getLongExtra(INTENT_EXTRA_USER_ID, -1L);
        StoreStream.Companion.getGuildSubscriptions().subscribeUser(longExtra, longExtra2);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetServerSettingsEditMember$Model.Companion.get(longExtra, longExtra2), this, null, 2, null), WidgetServerSettingsEditMember.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsEditMember$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
