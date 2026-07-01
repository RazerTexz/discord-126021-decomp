package com.discord.widgets.user.usersheet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.activity.Activity;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.api.user.UserProfile;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetUserSheetBinding;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.simpleast.core.node.Node;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserNotes$UserNoteState;
import com.discord.stores.StoreUserNotes$UserNoteState$Empty;
import com.discord.stores.StoreUserNotes$UserNoteState$Loaded;
import com.discord.stores.StoreUserNotes$UserNoteState$Loading;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.application.ApplicationUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rest.RestAPIAbortMessages$ResponseResolver;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.channels.WidgetChannelSelector$Companion;
import com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication;
import com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$Companion;
import com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication;
import com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$Companion;
import com.discord.widgets.roles.RolesListView;
import com.discord.widgets.servers.WidgetServerSettingsEditMember;
import com.discord.widgets.servers.WidgetServerSettingsEditMember$Companion;
import com.discord.widgets.stage.usersheet.UserProfileStageActionsView;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.Badge$Companion;
import com.discord.widgets.user.WidgetBanUser;
import com.discord.widgets.user.WidgetKickUser;
import com.discord.widgets.user.WidgetKickUser$Companion;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import com.discord.widgets.user.presence.ViewHolderStreamRichPresence;
import com.discord.widgets.user.presence.ViewHolderUserRichPresence;
import com.discord.widgets.user.presence.ViewHolderUserRichPresence$Companion;
import com.discord.widgets.user.profile.UserProfileAdminView;
import com.discord.widgets.user.profile.UserProfileAdminView$ViewState;
import com.discord.widgets.user.profile.UserProfileConnectionsView;
import com.discord.widgets.user.profile.UserProfileConnectionsView$ViewState;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.discord.widgets.user.profile.UserProfileHeaderView$Companion;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen$Companion;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet extends AppBottomSheet {
    private static final String ARG_CHANNEL_ID = "ARG_CHANNEL_ID";
    private static final String ARG_FRIEND_TOKEN = "ARG_FRIEND_TOKEN";
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
    private static final String ARG_IS_VOICE_CONTEXT = "ARG_IS_VOICE_CONTEXT";
    private static final String ARG_STREAM_PREVIEW_CLICK_BEHAVIOR = "ARG_STREAM_PREVIEW_CLICK_BEHAVIOR";
    private static final String ARG_USER_ID = "ARG_USER_ID";
    private static final String REQUEST_KEY_MOVE_USER = "REQUEST_KEY_MOVE_USER";
    private ViewHolderUserRichPresence activityViewHolder;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private PrivateCallLauncher privateCallLauncher;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: viewModelUserProfileHeader$delegate, reason: from kotlin metadata */
    private final Lazy viewModelUserProfileHeader;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUserSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserSheetBinding;", 0)};
    public static final WidgetUserSheet$Companion Companion = new WidgetUserSheet$Companion(null);

    public WidgetUserSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserSheet$binding$2.INSTANCE, null, 2, null);
        WidgetUserSheet$viewModelUserProfileHeader$2 widgetUserSheet$viewModelUserProfileHeader$2 = new WidgetUserSheet$viewModelUserProfileHeader$2(this);
        g0 g0Var = new g0(this);
        this.viewModelUserProfileHeader = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(UserProfileHeaderViewModel.class), new WidgetUserSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetUserSheet$viewModelUserProfileHeader$2));
        WidgetUserSheet$viewModel$2 widgetUserSheet$viewModel$2 = new WidgetUserSheet$viewModel$2(this);
        g0 g0Var2 = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetUserSheetViewModel.class), new WidgetUserSheet$appViewModels$$inlined$viewModels$2(g0Var2), new i0(widgetUserSheet$viewModel$2));
    }

    private final void acceptFriendRequest(String username) {
        WidgetUserSheetViewModel.addRelationship$default(getViewModel(), null, username, 2131886131, null, 8, null);
    }

    public static final /* synthetic */ void access$acceptFriendRequest(WidgetUserSheet widgetUserSheet, String str) {
        widgetUserSheet.acceptFriendRequest(str);
    }

    public static final /* synthetic */ void access$addFriend(WidgetUserSheet widgetUserSheet, String str) {
        widgetUserSheet.addFriend(str);
    }

    public static final /* synthetic */ void access$configureUI(WidgetUserSheet widgetUserSheet, WidgetUserSheetViewModel$ViewState widgetUserSheetViewModel$ViewState) {
        widgetUserSheet.configureUI(widgetUserSheetViewModel$ViewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetUserSheet widgetUserSheet) {
        return widgetUserSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetUserSheetBinding access$getBinding$p(WidgetUserSheet widgetUserSheet) {
        return widgetUserSheet.getBinding();
    }

    public static final /* synthetic */ WidgetUserSheetViewModel access$getViewModel$p(WidgetUserSheet widgetUserSheet) {
        return widgetUserSheet.getViewModel();
    }

    public static final /* synthetic */ UserProfileHeaderViewModel access$getViewModelUserProfileHeader$p(WidgetUserSheet widgetUserSheet) {
        return widgetUserSheet.getViewModelUserProfileHeader();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetUserSheet widgetUserSheet, WidgetUserSheetViewModel$Event widgetUserSheetViewModel$Event) {
        widgetUserSheet.handleEvent(widgetUserSheetViewModel$Event);
    }

    public static final /* synthetic */ void access$ignoreFriendRequest(WidgetUserSheet widgetUserSheet) {
        widgetUserSheet.ignoreFriendRequest();
    }

    public static final /* synthetic */ void access$onStreamPreviewClicked(WidgetUserSheet widgetUserSheet, StreamContext streamContext) {
        widgetUserSheet.onStreamPreviewClicked(streamContext);
    }

    private final void addFriend(String username) {
        WidgetUserSheetViewModel.addRelationship$default(getViewModel(), null, username, 2131889469, null, 8, null);
    }

    private final void configureAboutMe(WidgetUserSheetViewModel$ViewState$Loaded viewState) {
        String strComputeShortName;
        List<Node<MessageRenderContext>> bioAst = viewState.getBioAst();
        getBinding().f.setOnClickListener(new WidgetUserSheet$configureAboutMe$1(this, viewState));
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.aboutMeHeader");
        textView.setVisibility(bioAst != null ? 0 : 8);
        SimpleDraweeView simpleDraweeView = getBinding().c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.aboutMeGuildIcon");
        simpleDraweeView.setVisibility(viewState.getHasGuildMemberBio() ? 0 : 8);
        String guildIconURL = viewState.getGuildIconURL();
        if (guildIconURL == null || guildIconURL.length() == 0) {
            SimpleDraweeView simpleDraweeView2 = getBinding().c;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.aboutMeGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON_BLURPLE, 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
            TextView textView2 = getBinding().d;
            m.checkNotNullExpressionValue(textView2, "binding.aboutMeGuildIconName");
            textView2.setVisibility(0);
            TextView textView3 = getBinding().d;
            m.checkNotNullExpressionValue(textView3, "binding.aboutMeGuildIconName");
            String guildName = viewState.getGuildName();
            if (guildName == null || (strComputeShortName = GuildUtilsKt.computeShortName(guildName)) == null) {
                strComputeShortName = "";
            }
            textView3.setText(strComputeShortName);
        } else {
            SimpleDraweeView simpleDraweeView3 = getBinding().c;
            m.checkNotNullExpressionValue(simpleDraweeView3, "binding.aboutMeGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView3, viewState.getGuildIconURL(), 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
            TextView textView4 = getBinding().d;
            m.checkNotNullExpressionValue(textView4, "binding.aboutMeGuildIconName");
            textView4.setVisibility(8);
        }
        CardView cardView = getBinding().f2693b;
        m.checkNotNullExpressionValue(cardView, "binding.aboutMeCard");
        cardView.setVisibility(bioAst != null ? 0 : 8);
        if (bioAst != null) {
            LinkifiedTextView linkifiedTextView = getBinding().g;
            m.checkNotNullExpressionValue(linkifiedTextView, "binding.aboutMeText");
            Context context = linkifiedTextView.getContext();
            m.checkNotNullExpressionValue(context, "binding.aboutMeText.context");
            getBinding().g.setDraweeSpanStringBuilder(AstRenderer.render(viewState.getBioAst(), new MessageRenderContext(context, 0L, false, null, null, null, 0, null, null, 0, 0, new WidgetUserSheet$configureAboutMe$renderContext$1(getViewModel()), null, null, 14328, null)));
        }
    }

    private final void configureConnectionsSection(WidgetUserSheetViewModel$ViewState$Loaded viewState) {
        UserProfileConnectionsView$ViewState connectionsViewState = viewState.getConnectionsViewState();
        TextView textView = getBinding().m;
        m.checkNotNullExpressionValue(textView, "binding.userSheetConnectionsHeader");
        textView.setVisibility(connectionsViewState.getShowConnectionsSection() ? 0 : 8);
        UserProfileConnectionsView userProfileConnectionsView = getBinding().n;
        m.checkNotNullExpressionValue(userProfileConnectionsView, "binding.userSheetConnectionsView");
        userProfileConnectionsView.setVisibility(connectionsViewState.getShowConnectionsSection() ? 0 : 8);
        WidgetUserSheet$configureConnectionsSection$onConnectedAccountClick$1 widgetUserSheet$configureConnectionsSection$onConnectedAccountClick$1 = new WidgetUserSheet$configureConnectionsSection$onConnectedAccountClick$1(this);
        User user = viewState.getUser();
        getBinding().n.updateViewState(connectionsViewState, widgetUserSheet$configureConnectionsSection$onConnectedAccountClick$1, new WidgetUserSheet$configureConnectionsSection$onMutualGuildsItemClick$1(this, user), new WidgetUserSheet$configureConnectionsSection$onMutualFriendsItemClick$1(this, user));
    }

    private final void configureDeveloperSection(WidgetUserSheetViewModel$ViewState$Loaded viewState) {
        TextView textView = getBinding().o;
        textView.setVisibility(StoreStream.Companion.getUserSettings().getIsDeveloperMode() ? 0 : 8);
        textView.setOnClickListener(new WidgetUserSheet$configureDeveloperSection$$inlined$apply$lambda$1(textView, this, viewState));
        TextView textView2 = getBinding().o;
        m.checkNotNullExpressionValue(textView2, "binding.userSheetCopyId");
        boolean z2 = textView2.getVisibility() == 0;
        TextView textView3 = getBinding().p;
        m.checkNotNullExpressionValue(textView3, "binding.userSheetDeveloperHeader");
        textView3.setVisibility(z2 ? 0 : 8);
    }

    private final void configureGuildSection(WidgetUserSheetViewModel$ViewState$Loaded viewState) {
        List<GuildRole> roleItems = viewState.getRoleItems();
        UserProfileAdminView$ViewState adminViewState = viewState.getAdminViewState();
        boolean zShouldShowRoles = viewState.shouldShowRoles();
        boolean z2 = true;
        boolean z3 = adminViewState != null && adminViewState.isAdminSectionEnabled();
        LinearLayout linearLayout = getBinding().t;
        m.checkNotNullExpressionValue(linearLayout, "binding.userSheetGuildContainer");
        if (!zShouldShowRoles && !z3) {
            z2 = false;
        }
        linearLayout.setVisibility(z2 ? 0 : 8);
        RolesListView rolesListView = getBinding().P;
        m.checkNotNullExpressionValue(rolesListView, "binding.userSheetRolesList");
        rolesListView.setVisibility(zShouldShowRoles ? 0 : 8);
        Long guildId = viewState.getGuildId();
        if (zShouldShowRoles && guildId != null) {
            RolesListView rolesListView2 = getBinding().P;
            RolesListView rolesListView3 = getBinding().P;
            m.checkNotNullExpressionValue(rolesListView3, "binding.userSheetRolesList");
            rolesListView2.updateView(roleItems, ColorCompat.getThemedColor(rolesListView3.getContext(), 2130969978), guildId.longValue());
        }
        String guildSectionHeaderText = viewState.getGuildSectionHeaderText();
        if (guildSectionHeaderText != null) {
            TextView textView = getBinding().u;
            m.checkNotNullExpressionValue(textView, "binding.userSheetGuildHeader");
            textView.setText(guildSectionHeaderText);
        }
        CardView cardView = getBinding().j;
        m.checkNotNullExpressionValue(cardView, "binding.userSheetAdminCard");
        cardView.setVisibility(z3 ? 0 : 8);
        UserProfileAdminView userProfileAdminView = getBinding().k;
        m.checkNotNullExpressionValue(userProfileAdminView, "binding.userSheetAdminView");
        userProfileAdminView.setVisibility(z3 ? 0 : 8);
        if (adminViewState != null) {
            getBinding().k.updateView(adminViewState);
        }
    }

    private final void configureIncomingFriendRequest(WidgetUserSheetViewModel$ViewState$Loaded viewState) {
        boolean z2 = ModelUserRelationship.getType(Integer.valueOf(viewState.getUserRelationshipType())) == 3;
        TextView textView = getBinding().v;
        m.checkNotNullExpressionValue(textView, "binding.userSheetIncomingFriendRequestHeader");
        textView.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = getBinding().f2694s;
        m.checkNotNullExpressionValue(linearLayout, "binding.userSheetFriendRequestIncomingContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        getBinding().q.setOnClickListener(new WidgetUserSheet$configureIncomingFriendRequest$1(this, viewState));
        getBinding().r.setOnClickListener(new WidgetUserSheet$configureIncomingFriendRequest$2(this));
    }

    private final void configureNote(WidgetUserSheetViewModel$ViewState$Loaded viewState) {
        getBinding().A.setRawInputType(1);
        StoreUserNotes$UserNoteState userNoteFetchState = viewState.getUserNoteFetchState();
        if (userNoteFetchState instanceof StoreUserNotes$UserNoteState$Empty) {
            TextInputLayout textInputLayout = getBinding().B;
            m.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
            textInputLayout.setHint(getString(2131893311));
            TextInputLayout textInputLayout2 = getBinding().B;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.userSheetNoteTextFieldWrap");
            textInputLayout2.setEnabled(true);
        } else if (userNoteFetchState instanceof StoreUserNotes$UserNoteState$Loading) {
            TextInputLayout textInputLayout3 = getBinding().B;
            m.checkNotNullExpressionValue(textInputLayout3, "binding.userSheetNoteTextFieldWrap");
            textInputLayout3.setHint(getString(2131892591));
            TextInputLayout textInputLayout4 = getBinding().B;
            m.checkNotNullExpressionValue(textInputLayout4, "binding.userSheetNoteTextFieldWrap");
            textInputLayout4.setEnabled(false);
        } else if (userNoteFetchState instanceof StoreUserNotes$UserNoteState$Loaded) {
            TextInputLayout textInputLayout5 = getBinding().B;
            m.checkNotNullExpressionValue(textInputLayout5, "binding.userSheetNoteTextFieldWrap");
            textInputLayout5.setHint(getString(2131893311));
            TextInputLayout textInputLayout6 = getBinding().B;
            m.checkNotNullExpressionValue(textInputLayout6, "binding.userSheetNoteTextFieldWrap");
            textInputLayout6.setEnabled(true);
        }
        if (viewState.getUserNote() != null) {
            TextInputLayout textInputLayout7 = getBinding().B;
            m.checkNotNullExpressionValue(textInputLayout7, "binding.userSheetNoteTextFieldWrap");
            ViewExtensions.setTextIfDifferent(textInputLayout7, viewState.getUserNote());
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007f  */
    private final void configureProfileActionButtons(WidgetUserSheetViewModel$ViewState$Loaded viewState) {
        boolean z2;
        boolean zIsMe = viewState.isMe();
        Long currentGuildId = viewState.getCurrentGuildId();
        UserProfile userProfile = viewState.getUserProfile();
        FrameLayout frameLayout = getBinding().G;
        m.checkNotNullExpressionValue(frameLayout, "binding.userSheetProfileAddToServerContainer");
        frameLayout.setVisibility(ApplicationUtils.INSTANCE.canInstallApplication(userProfile != null ? userProfile.getApplication() : null) ? 0 : 8);
        getBinding().F.setOnClickListener(new WidgetUserSheet$configureProfileActionButtons$1(userProfile));
        FlexboxLayout flexboxLayout = getBinding().I;
        m.checkNotNullExpressionValue(flexboxLayout, "binding.userSheetProfileEditContainer");
        flexboxLayout.setVisibility(zIsMe ? 0 : 8);
        getBinding().H.setOnClickListener(new WidgetUserSheet$configureProfileActionButtons$2(this));
        MaterialButton materialButton = getBinding().K;
        m.checkNotNullExpressionValue(materialButton, "binding.userSheetProfileIdentityButton");
        if (zIsMe) {
            if ((currentGuildId != null ? currentGuildId.longValue() : 0L) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        materialButton.setVisibility(z2 ? 0 : 8);
        getBinding().K.setOnClickListener(new WidgetUserSheet$configureProfileActionButtons$3(currentGuildId));
        boolean isBot = viewState.getUser().getIsBot();
        boolean isSystemUser = viewState.getUser().getIsSystemUser();
        int userRelationshipType = viewState.getUserRelationshipType();
        boolean z3 = (zIsMe || isSystemUser) ? false : true;
        View view = getBinding().E;
        m.checkNotNullExpressionValue(view, "binding.userSheetProfileActionsDivider");
        view.setVisibility(z3 ? 0 : 8);
        LinearLayout linearLayout = getBinding().D;
        m.checkNotNullExpressionValue(linearLayout, "binding.userSheetProfileActionsContainer");
        linearLayout.setVisibility(z3 ? 0 : 8);
        if (z3) {
            Button button = getBinding().f2695x;
            m.checkNotNullExpressionValue(button, "binding.userSheetMessageActionButton");
            Channel channel = viewState.getChannel();
            button.setVisibility(channel == null || channel.getType() != 1 ? 0 : 8);
            getBinding().f2695x.setOnClickListener(new WidgetUserSheet$configureProfileActionButtons$4(this, viewState));
            getBinding().l.setOnClickListener(new WidgetUserSheet$configureProfileActionButtons$5(this));
            getBinding().Q.setOnClickListener(new WidgetUserSheet$configureProfileActionButtons$6(this));
            if (userRelationshipType == 0) {
                Button button2 = getBinding().i;
                m.checkNotNullExpressionValue(button2, "binding.userSheetAddFriendActionButton");
                button2.setVisibility(0);
                Button button3 = getBinding().C;
                m.checkNotNullExpressionValue(button3, "binding.userSheetPendingFriendRequestActionButton");
                button3.setVisibility(8);
            } else if (userRelationshipType == 3 || userRelationshipType == 4) {
                Button button4 = getBinding().i;
                m.checkNotNullExpressionValue(button4, "binding.userSheetAddFriendActionButton");
                button4.setVisibility(8);
                Button button5 = getBinding().C;
                m.checkNotNullExpressionValue(button5, "binding.userSheetPendingFriendRequestActionButton");
                button5.setVisibility(0);
            } else {
                Button button6 = getBinding().i;
                m.checkNotNullExpressionValue(button6, "binding.userSheetAddFriendActionButton");
                button6.setVisibility(8);
                Button button7 = getBinding().C;
                m.checkNotNullExpressionValue(button7, "binding.userSheetPendingFriendRequestActionButton");
                button7.setVisibility(8);
            }
            boolean z4 = (zIsMe || isBot || userRelationshipType != 0) ? false : true;
            Button button8 = getBinding().i;
            m.checkNotNullExpressionValue(button8, "binding.userSheetAddFriendActionButton");
            button8.setVisibility(z4 ? 0 : 8);
            getBinding().i.setOnClickListener(new WidgetUserSheet$configureProfileActionButtons$7(this, viewState));
            getBinding().C.setOnClickListener(new WidgetUserSheet$configureProfileActionButtons$8(this, userRelationshipType, viewState));
        }
    }

    private final void configureStageActionsSection(WidgetUserSheetViewModel$ViewState$Loaded viewState) {
        getBinding().M.updateView(viewState.getStageViewState());
        CardView cardView = getBinding().L;
        m.checkNotNullExpressionValue(cardView, "binding.userSheetProfileStageActionsCard");
        UserProfileStageActionsView userProfileStageActionsView = getBinding().M;
        m.checkNotNullExpressionValue(userProfileStageActionsView, "binding.userSheetProfileStageActionsView");
        cardView.setVisibility(userProfileStageActionsView.getVisibility() == 0 ? 0 : 8);
    }

    private final void configureUI(WidgetUserSheetViewModel$ViewState model) {
        if (model instanceof WidgetUserSheetViewModel$ViewState$Uninitialized) {
            FrameLayout frameLayout = getBinding().w;
            m.checkNotNullExpressionValue(frameLayout, "binding.userSheetLoadingContainer");
            frameLayout.setVisibility(0);
            return;
        }
        if (!(model instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        FrameLayout frameLayout2 = getBinding().w;
        m.checkNotNullExpressionValue(frameLayout2, "binding.userSheetLoadingContainer");
        frameLayout2.setVisibility(8);
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) model;
        Presence presence = widgetUserSheetViewModel$ViewState$Loaded.getPresence();
        Activity primaryActivity = presence != null ? PresenceUtils.INSTANCE.getPrimaryActivity(presence) : null;
        boolean zIsMe = widgetUserSheetViewModel$ViewState$Loaded.isMe();
        boolean isSystemUser = widgetUserSheetViewModel$ViewState$Loaded.getUser().getIsSystemUser();
        if (!getViewModel().getOpenPopoutLogged() && widgetUserSheetViewModel$ViewState$Loaded.getProfileLoaded()) {
            AnalyticsTracker.INSTANCE.openUserSheet(widgetUserSheetViewModel$ViewState$Loaded.getHasPremiumCustomization(), primaryActivity != null ? primaryActivity.getName() : null, primaryActivity != null ? ActivityUtilsKt.getGamePlatform(primaryActivity) : null, widgetUserSheetViewModel$ViewState$Loaded.getGuildMember());
            getViewModel().setOpenPopoutLogged(true);
        }
        getBinding().J.setOnBannerPress(new WidgetUserSheet$configureUI$1(this));
        ImageView imageView = getBinding().f2696y;
        m.checkNotNullExpressionValue(imageView, "binding.userSheetMoreButton");
        imageView.setVisibility((zIsMe || isSystemUser) ? false : true ? 0 : 8);
        if (widgetUserSheetViewModel$ViewState$Loaded.getConnectionsViewState().getShowConnectionsSection()) {
            setPeekHeightBottomView(getBinding().m);
        }
        ViewHolderUserRichPresence$Companion viewHolderUserRichPresence$Companion = ViewHolderUserRichPresence.Companion;
        FrameLayout frameLayout3 = getBinding().h;
        m.checkNotNullExpressionValue(frameLayout3, "binding.richPresenceContainer");
        ViewHolderUserRichPresence richPresence = viewHolderUserRichPresence$Companion.setRichPresence(frameLayout3, primaryActivity, widgetUserSheetViewModel$ViewState$Loaded.getStreamContext(), this.activityViewHolder);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        StreamContext streamContext = widgetUserSheetViewModel$ViewState$Loaded.getStreamContext();
        boolean zIsMe2 = widgetUserSheetViewModel$ViewState$Loaded.isMe();
        User user = widgetUserSheetViewModel$ViewState$Loaded.getUser();
        Context applicationContext = requireAppActivity().getApplicationContext();
        m.checkNotNullExpressionValue(applicationContext, "requireAppActivity().applicationContext");
        richPresence.configureUi(parentFragmentManager, streamContext, zIsMe2, user, applicationContext, widgetUserSheetViewModel$ViewState$Loaded.getRichPresence(), widgetUserSheetViewModel$ViewState$Loaded.getUserInSameVoiceChannel());
        richPresence.configureUiTimestamp(primaryActivity, this);
        this.activityViewHolder = richPresence;
        ViewHolderStreamRichPresence viewHolderStreamRichPresence = (ViewHolderStreamRichPresence) (richPresence instanceof ViewHolderStreamRichPresence ? richPresence : null);
        if (widgetUserSheetViewModel$ViewState$Loaded.getStreamContext() != null && viewHolderStreamRichPresence != null) {
            viewHolderStreamRichPresence.setOnStreamPreviewClicked(new WidgetUserSheet$configureUI$3(this, model));
        }
        ViewHolderUserRichPresence viewHolderUserRichPresence = this.activityViewHolder;
        if (viewHolderUserRichPresence != null) {
            viewHolderUserRichPresence.setOnActivityCustomButtonClicked(new WidgetUserSheet$configureUI$4(getViewModel()));
        }
        configureProfileActionButtons(widgetUserSheetViewModel$ViewState$Loaded);
        configureStageActionsSection(widgetUserSheetViewModel$ViewState$Loaded);
        configureAboutMe(widgetUserSheetViewModel$ViewState$Loaded);
        configureIncomingFriendRequest(widgetUserSheetViewModel$ViewState$Loaded);
        configureVoiceSection(widgetUserSheetViewModel$ViewState$Loaded);
        configureGuildSection(widgetUserSheetViewModel$ViewState$Loaded);
        configureConnectionsSection(widgetUserSheetViewModel$ViewState$Loaded);
        configureNote(widgetUserSheetViewModel$ViewState$Loaded);
        configureDeveloperSection(widgetUserSheetViewModel$ViewState$Loaded);
    }

    private final void configureVoiceSection(WidgetUserSheetViewModel$ViewState$Loaded viewState) {
        UserProfileVoiceSettingsView$ViewState voiceSettingsViewState = viewState.getVoiceSettingsViewState();
        boolean showVoiceSettings = viewState.getShowVoiceSettings();
        TextView textView = getBinding().N;
        m.checkNotNullExpressionValue(textView, "binding.userSheetProfileVoiceSettingsHeader");
        textView.setVisibility(showVoiceSettings ? 0 : 8);
        CardView cardView = getBinding().R;
        m.checkNotNullExpressionValue(cardView, "binding.voiceSettingsViewCard");
        cardView.setVisibility(showVoiceSettings ? 0 : 8);
        getBinding().O.updateView(voiceSettingsViewState);
    }

    private final WidgetUserSheetBinding getBinding() {
        return (WidgetUserSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetUserSheetViewModel getViewModel() {
        return (WidgetUserSheetViewModel) this.viewModel.getValue();
    }

    private final UserProfileHeaderViewModel getViewModelUserProfileHeader() {
        return (UserProfileHeaderViewModel) this.viewModelUserProfileHeader.getValue();
    }

    private final void handleBanUser(WidgetUserSheetViewModel$Event$LaunchBanUser event) {
        WidgetBanUser.Companion.launch(event.getUsername(), event.getGuildId(), event.getUserId(), getParentFragmentManager());
    }

    private final void handleDisableCommunication(WidgetUserSheetViewModel$Event$LaunchDisableCommunication event) {
        WidgetDisableGuildCommunication$Companion widgetDisableGuildCommunication$Companion = WidgetDisableGuildCommunication.Companion;
        long userId = event.getUserId();
        long guildId = event.getGuildId();
        WidgetUserSheetBinding binding = getBinding();
        m.checkNotNullExpressionValue(binding, "binding");
        NestedScrollView nestedScrollView = binding.a;
        m.checkNotNullExpressionValue(nestedScrollView, "binding.root");
        Context context = nestedScrollView.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        widgetDisableGuildCommunication$Companion.launch(userId, guildId, context);
    }

    private final void handleDismissSheet() {
        dismiss();
    }

    private final void handleEnableCommunication(WidgetUserSheetViewModel$Event$LaunchEnableCommunication event) {
        WidgetEnableGuildCommunication$Companion widgetEnableGuildCommunication$Companion = WidgetEnableGuildCommunication.Companion;
        long userId = event.getUserId();
        long guildId = event.getGuildId();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetEnableGuildCommunication$Companion.launch(userId, guildId, parentFragmentManager);
    }

    private final void handleEvent(WidgetUserSheetViewModel$Event event) {
        if (event instanceof WidgetUserSheetViewModel$Event$ShowToast) {
            handleShowToast((WidgetUserSheetViewModel$Event$ShowToast) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel$Event$ShowFriendRequestErrorToast) {
            handleShowFriendRequestErrorToast((WidgetUserSheetViewModel$Event$ShowFriendRequestErrorToast) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel$Event$LaunchVoiceCall) {
            handleLaunchVoiceCall((WidgetUserSheetViewModel$Event$LaunchVoiceCall) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel$Event$LaunchVideoCall) {
            handleLaunchVideoCall((WidgetUserSheetViewModel$Event$LaunchVideoCall) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel$Event$LaunchSpectate) {
            handleLaunchSpectate((WidgetUserSheetViewModel$Event$LaunchSpectate) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel$Event$LaunchEditMember) {
            handleLaunchEditMember((WidgetUserSheetViewModel$Event$LaunchEditMember) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel$Event$LaunchKickUser) {
            handleKickUser((WidgetUserSheetViewModel$Event$LaunchKickUser) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel$Event$LaunchBanUser) {
            handleBanUser((WidgetUserSheetViewModel$Event$LaunchBanUser) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel$Event$LaunchDisableCommunication) {
            handleDisableCommunication((WidgetUserSheetViewModel$Event$LaunchDisableCommunication) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel$Event$LaunchEnableCommunication) {
            handleEnableCommunication((WidgetUserSheetViewModel$Event$LaunchEnableCommunication) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel$Event$LaunchMoveUser) {
            handleMoveUser((WidgetUserSheetViewModel$Event$LaunchMoveUser) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream) {
            handleRequestPermissionsForSpectateStream((WidgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel$Event$UserNotFound) {
            b.a.d.m.i(this, 2131896780, 0, 4);
            handleDismissSheet();
        } else {
            if (!(event instanceof WidgetUserSheetViewModel$Event$DismissSheet)) {
                throw new NoWhenBranchMatchedException();
            }
            handleDismissSheet();
        }
    }

    private final void handleKickUser(WidgetUserSheetViewModel$Event$LaunchKickUser event) {
        WidgetKickUser$Companion widgetKickUser$Companion = WidgetKickUser.Companion;
        String username = event.getUsername();
        long guildId = event.getGuildId();
        long userId = event.getUserId();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetKickUser$Companion.launch(username, guildId, userId, parentFragmentManager);
    }

    private final void handleLaunchEditMember(WidgetUserSheetViewModel$Event$LaunchEditMember event) {
        WidgetServerSettingsEditMember$Companion widgetServerSettingsEditMember$Companion = WidgetServerSettingsEditMember.Companion;
        long guildId = event.getGuildId();
        long userId = event.getUserId();
        WidgetUserSheetBinding binding = getBinding();
        m.checkNotNullExpressionValue(binding, "binding");
        NestedScrollView nestedScrollView = binding.a;
        m.checkNotNullExpressionValue(nestedScrollView, "binding.root");
        Context context = nestedScrollView.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        widgetServerSettingsEditMember$Companion.launch(guildId, userId, context);
    }

    private final void handleLaunchSpectate(WidgetUserSheetViewModel$Event$LaunchSpectate event) {
        WidgetCallFullscreen$Companion widgetCallFullscreen$Companion = WidgetCallFullscreen.Companion;
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetCallFullscreen$Companion.launch$default(widgetCallFullscreen$Companion, contextRequireContext, event.getStream().getChannelId(), false, event.getStream().getEncodedStreamKey(), null, 20, null);
        dismiss();
    }

    private final void handleLaunchVideoCall(WidgetUserSheetViewModel$Event$LaunchVideoCall event) {
        PrivateCallLauncher privateCallLauncher = this.privateCallLauncher;
        if (privateCallLauncher == null) {
            m.throwUninitializedPropertyAccessException("privateCallLauncher");
        }
        privateCallLauncher.launchVideoCall(event.getChannelId());
    }

    private final void handleLaunchVoiceCall(WidgetUserSheetViewModel$Event$LaunchVoiceCall event) {
        PrivateCallLauncher privateCallLauncher = this.privateCallLauncher;
        if (privateCallLauncher == null) {
            m.throwUninitializedPropertyAccessException("privateCallLauncher");
        }
        privateCallLauncher.launchVoiceCall(event.getChannelId());
    }

    private final void handleMoveUser(WidgetUserSheetViewModel$Event$LaunchMoveUser event) {
        WidgetChannelSelector$Companion.launchForVocal$default(WidgetChannelSelector.Companion, this, event.getGuildId(), REQUEST_KEY_MOVE_USER, false, 0, 24, null);
    }

    private final void handleRequestPermissionsForSpectateStream(WidgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream event) {
        d.S1(this, null, new WidgetUserSheet$handleRequestPermissionsForSpectateStream$1(this, event), 1, null);
    }

    private final void handleShowFriendRequestErrorToast(WidgetUserSheetViewModel$Event$ShowFriendRequestErrorToast event) {
        b.a.d.m.j(this, RestAPIAbortMessages$ResponseResolver.INSTANCE.getRelationshipResponse(getContext(), event.getAbortCode(), event.getUsername()), 0, 4);
    }

    private final void handleShowToast(WidgetUserSheetViewModel$Event$ShowToast event) {
        b.a.d.m.i(this, event.getStringRes(), 0, 4);
    }

    private final void ignoreFriendRequest() {
        getViewModel().removeRelationship(2131889460);
    }

    private final void onStreamPreviewClicked(StreamContext streamContext) {
        getViewModel().onStreamPreviewClicked(streamContext);
    }

    public static final void show(long j, FragmentManager fragmentManager) {
        WidgetUserSheet$Companion.show$default(Companion, j, null, fragmentManager, null, null, null, null, 122, null);
    }

    public static final void show(long j, Long l, FragmentManager fragmentManager) {
        WidgetUserSheet$Companion.show$default(Companion, j, l, fragmentManager, null, null, null, null, 120, null);
    }

    public static final void show(long j, Long l, FragmentManager fragmentManager, Long l2) {
        WidgetUserSheet$Companion.show$default(Companion, j, l, fragmentManager, l2, null, null, null, 112, null);
    }

    public static final void show(long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool) {
        WidgetUserSheet$Companion.show$default(Companion, j, l, fragmentManager, l2, bool, null, null, 96, null);
    }

    public static final void show(long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool, WidgetUserSheet$StreamPreviewClickBehavior widgetUserSheet$StreamPreviewClickBehavior) {
        WidgetUserSheet$Companion.show$default(Companion, j, l, fragmentManager, l2, bool, widgetUserSheet$StreamPreviewClickBehavior, null, 64, null);
    }

    public static final void show(long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool, WidgetUserSheet$StreamPreviewClickBehavior widgetUserSheet$StreamPreviewClickBehavior, String str) {
        Companion.show(j, l, fragmentManager, l2, bool, widgetUserSheet$StreamPreviewClickBehavior, str);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetUserSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserSheet$bindSubscriptions$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetUserSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserSheet$bindSubscriptions$2(this), 62, (Object) null);
        UserProfileHeaderView$Companion userProfileHeaderView$Companion = UserProfileHeaderView.Companion;
        UserProfileHeaderView userProfileHeaderView = getBinding().J;
        m.checkNotNullExpressionValue(userProfileHeaderView, "binding.userSheetProfileHeaderView");
        userProfileHeaderView$Companion.bind(userProfileHeaderView, this, getViewModelUserProfileHeader().observeViewState());
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_user_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        this.privateCallLauncher = new PrivateCallLauncher(this, this, contextRequireContext, parentFragmentManager);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        ViewHolderUserRichPresence viewHolderUserRichPresence = this.activityViewHolder;
        if (viewHolderUserRichPresence != null) {
            viewHolderUserRichPresence.disposeSubscriptions();
        }
        long j = getArgumentsOrDefault().getLong(ARG_USER_ID);
        long j2 = getArgumentsOrDefault().getLong(ARG_GUILD_ID);
        if (j > 0 && j2 > 0) {
            StoreStream.Companion.getGuildSubscriptions().unsubscribeUser(j2, j);
        }
        hideKeyboard(getBinding().B);
        WidgetUserSheetViewModel viewModel = getViewModel();
        Context context = getContext();
        TextInputLayout textInputLayout = getBinding().B;
        m.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
        viewModel.saveUserNote(context, ViewExtensions.getTextOrEmpty(textInputLayout));
        super.onPause();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        long j = getArgumentsOrDefault().getLong(ARG_USER_ID);
        long j2 = getArgumentsOrDefault().getLong(ARG_GUILD_ID);
        if (j <= 0 || j2 <= 0) {
            return;
        }
        StoreStream.Companion.getGuildSubscriptions().subscribeUser(j2, j);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        long j = getArgumentsOrDefault().getLong(ARG_USER_ID);
        boolean z2 = j == StoreStream.Companion.getUsers().getMeSnapshot().getId();
        getBinding().f2696y.setOnClickListener(new WidgetUserSheet$onViewCreated$1(this, j));
        UserProfileHeaderView userProfileHeaderView = getBinding().J;
        Badge$Companion badge$Companion = Badge.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        userProfileHeaderView.setOnBadgeClick(badge$Companion.onBadgeClick(parentFragmentManager, contextRequireContext));
        getBinding().M.setOnInviteToSpeak(new WidgetUserSheet$onViewCreated$2(this, z2));
        getBinding().M.setOnMoveToAudience(new WidgetUserSheet$onViewCreated$3(this));
        getBinding().O.setOnMuteChecked(new WidgetUserSheet$onViewCreated$4(this));
        getBinding().O.setOnDeafenChecked(new WidgetUserSheet$onViewCreated$5(this));
        getBinding().O.setOnVolumeChange(new WidgetUserSheet$onViewCreated$6(this));
        getBinding().k.setOnEditMember(new WidgetUserSheet$onViewCreated$7(this));
        getBinding().k.setOnKick(new WidgetUserSheet$onViewCreated$8(this));
        getBinding().k.setOnBan(new WidgetUserSheet$onViewCreated$9(this));
        getBinding().k.setOnDisableCommunication(new WidgetUserSheet$onViewCreated$10(this));
        getBinding().k.setOnServerMute(new WidgetUserSheet$onViewCreated$11(this));
        getBinding().k.setOnServerDeafen(new WidgetUserSheet$onViewCreated$12(this));
        getBinding().k.setOnServerMove(new WidgetUserSheet$onViewCreated$13(this));
        getBinding().k.setOnDisconnect(new WidgetUserSheet$onViewCreated$14(this));
        TextInputLayout textInputLayout = getBinding().B;
        m.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
        ViewExtensions.setOnEditTextFocusChangeListener(textInputLayout, new WidgetUserSheet$onViewCreated$15(this));
        TextInputLayout textInputLayout2 = getBinding().B;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.userSheetNoteTextFieldWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout2, false, new WidgetUserSheet$onViewCreated$16(this, view), 1, null);
        ViewCompat.setAccessibilityDelegate(getBinding().f2696y, new WidgetUserSheet$onViewCreated$17(this));
        for (TextView textView : n.listOf((Object[]) new TextView[]{getBinding().m, getBinding().u, getBinding().f2697z, getBinding().p, getBinding().v, getBinding().N})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
        WidgetChannelSelector$Companion.registerForResult$default(WidgetChannelSelector.Companion, this, REQUEST_KEY_MOVE_USER, false, new WidgetUserSheet$onViewCreated$18(this), 4, null);
    }
}
