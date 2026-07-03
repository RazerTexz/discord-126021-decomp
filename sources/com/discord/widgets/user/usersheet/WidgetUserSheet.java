package com.discord.widgets.user.usersheet;

import android.content.Context;
import android.net.Uri;
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
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.activity.Activity;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.api.user.UserProfile;
import com.discord.app.AppActivity;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetUserSheetBinding;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.simpleast.core.node.Node;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreUserNotes;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.application.ApplicationUtils;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication;
import com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication;
import com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.roles.RolesListView;
import com.discord.widgets.servers.WidgetServerSettingsEditMember;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile;
import com.discord.widgets.stage.usersheet.UserProfileStageActionsView;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.WidgetBanUser;
import com.discord.widgets.user.WidgetKickUser;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import com.discord.widgets.user.presence.ViewHolderStreamRichPresence;
import com.discord.widgets.user.presence.ViewHolderUserRichPresence;
import com.discord.widgets.user.profile.UserProfileAdminView;
import com.discord.widgets.user.profile.UserProfileConnectionsView;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import com.discord.widgets.user.usersheet.UserProfileVoiceSettingsView;
import com.discord.widgets.user.usersheet.WidgetUserSheetViewModel;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import org.objectweb.asm.Opcodes;
import p000.C12807l;
import p007b.p008a.p009a.C0835l;
import p007b.p008a.p009a.p013d.C0817a;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.subscriptions.CompositeSubscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetUserSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void enqueueNotice$default(Companion companion, long j, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            companion.enqueueNotice(j, str);
        }

        private final String getNoticeName(long userId) {
            String str = "User Sheet Notice for user ID: " + userId;
            C12238m.checkNotNullExpressionValue(str, "StringBuilder(\"User Shee…)\n            .toString()");
            return str;
        }

        public static /* synthetic */ void show$default(Companion companion, long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool, StreamPreviewClickBehavior streamPreviewClickBehavior, String str, int i, Object obj) {
            companion.show(j, (i & 2) != 0 ? null : l, fragmentManager, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? StreamPreviewClickBehavior.TARGET_AND_LAUNCH_SPECTATE : streamPreviewClickBehavior, (i & 64) != 0 ? null : str);
        }

        public final void enqueueNotice(long userId, String friendToken) {
            StoreNotices notices = StoreStream.INSTANCE.getNotices();
            String noticeName = getNoticeName(userId);
            notices.requestToShow(new StoreNotices.Notice(noticeName, null, 0L, 0, false, null, 0L, false, 0L, new WidgetUserSheet$Companion$enqueueNotice$showUserSheetNotice$1(userId, friendToken, notices, noticeName), Opcodes.INVOKEVIRTUAL, null));
        }

        public final void show(long j, FragmentManager fragmentManager) {
            show$default(this, j, null, fragmentManager, null, null, null, null, 122, null);
        }

        public final void show(long j, Long l, FragmentManager fragmentManager) {
            show$default(this, j, l, fragmentManager, null, null, null, null, 120, null);
        }

        public final void show(long j, Long l, FragmentManager fragmentManager, Long l2) {
            show$default(this, j, l, fragmentManager, l2, null, null, null, 112, null);
        }

        public final void show(long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool) {
            show$default(this, j, l, fragmentManager, l2, bool, null, null, 96, null);
        }

        public final void show(long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool, StreamPreviewClickBehavior streamPreviewClickBehavior) {
            show$default(this, j, l, fragmentManager, l2, bool, streamPreviewClickBehavior, null, 64, null);
        }

        public final void show(long userId, Long channelId, FragmentManager fragmentManager, Long guildId, Boolean isVoiceContext, StreamPreviewClickBehavior streamPreviewClickBehavior, String friendToken) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(streamPreviewClickBehavior, "streamPreviewClickBehavior");
            WidgetUserSheet widgetUserSheet = new WidgetUserSheet();
            Bundle bundleM832T = C1643a.m832T(WidgetUserSheet.ARG_USER_ID, userId);
            if (channelId != null) {
                bundleM832T.putLong(WidgetUserSheet.ARG_CHANNEL_ID, channelId.longValue());
            }
            if (friendToken != null) {
                bundleM832T.putString(WidgetUserSheet.ARG_FRIEND_TOKEN, friendToken);
            }
            if (guildId != null) {
                bundleM832T.putLong(WidgetUserSheet.ARG_GUILD_ID, guildId.longValue());
            }
            bundleM832T.putBoolean(WidgetUserSheet.ARG_IS_VOICE_CONTEXT, isVoiceContext != null ? isVoiceContext.booleanValue() : false);
            bundleM832T.putSerializable(WidgetUserSheet.ARG_STREAM_PREVIEW_CLICK_BEHAVIOR, streamPreviewClickBehavior);
            widgetUserSheet.setArguments(bundleM832T);
            widgetUserSheet.show(fragmentManager, WidgetUserSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public enum StreamPreviewClickBehavior {
        TARGET_AND_LAUNCH_SPECTATE,
        TARGET_AND_DISMISS
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$bindSubscriptions$1 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final /* synthetic */ class C103411 extends C12236k implements Function1<WidgetUserSheetViewModel.ViewState, Unit> {
        public C103411(WidgetUserSheet widgetUserSheet) {
            super(1, widgetUserSheet, WidgetUserSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetUserSheetViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetUserSheet) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$bindSubscriptions$2 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final /* synthetic */ class C103422 extends C12236k implements Function1<WidgetUserSheetViewModel.Event, Unit> {
        public C103422(WidgetUserSheet widgetUserSheet) {
            super(1, widgetUserSheet, WidgetUserSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSheetViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetUserSheetViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetUserSheet) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureUI$1 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C103581 extends AbstractC12240o implements Function0<Unit> {
        public C103581() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.this.getViewModelUserProfileHeader().toggleAllowAnimationInReducedMotion();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureUI$3 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C103593 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ WidgetUserSheetViewModel.ViewState $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C103593(WidgetUserSheetViewModel.ViewState viewState) {
            super(0);
            this.$model = viewState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.this.onStreamPreviewClicked(((WidgetUserSheetViewModel.ViewState.Loaded) this.$model).getStreamContext());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureUI$4 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final /* synthetic */ class C103604 extends C12236k implements Function5<Context, Long, String, Long, Integer, Unit> {
        public C103604(WidgetUserSheetViewModel widgetUserSheetViewModel) {
            super(5, widgetUserSheetViewModel, WidgetUserSheetViewModel.class, "onActivityCustomButtonClicked", "onActivityCustomButtonClicked(Landroid/content/Context;JLjava/lang/String;JI)V", 0);
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(Context context, Long l, String str, Long l2, Integer num) {
            invoke(context, l.longValue(), str, l2.longValue(), num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(Context context, long j, String str, long j2, int i) {
            C12238m.checkNotNullParameter(context, "p1");
            C12238m.checkNotNullParameter(str, "p3");
            ((WidgetUserSheetViewModel) this.receiver).onActivityCustomButtonClicked(context, j, str, j2, i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$handleRequestPermissionsForSpectateStream$1 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C103611 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ WidgetUserSheetViewModel.Event.RequestPermissionsForSpectateStream $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C103611(WidgetUserSheetViewModel.Event.RequestPermissionsForSpectateStream requestPermissionsForSpectateStream) {
            super(0);
            this.$event = requestPermissionsForSpectateStream;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.this.getViewModel().onSpectatePermissionsGranted(this.$event.getStream());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$10 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C1036310 extends AbstractC12240o implements Function0<Unit> {
        public C1036310() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.this.getViewModel().disableCommunication();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$11 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C1036411 extends AbstractC12240o implements Function0<Unit> {
        public C1036411() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.this.getViewModel().guildMuteUser();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$12 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C1036512 extends AbstractC12240o implements Function0<Unit> {
        public C1036512() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.this.getViewModel().guildDeafenUser();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$13 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C1036613 extends AbstractC12240o implements Function0<Unit> {
        public C1036613() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.this.getViewModel().guildMoveForUser();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$14 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C1036714 extends AbstractC12240o implements Function0<Unit> {
        public C1036714() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheetViewModel.disconnectUser$default(WidgetUserSheet.this.getViewModel(), null, 1, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$16 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C1036916 extends AbstractC12240o implements Function1<TextView, Unit> {
        public final /* synthetic */ View $view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1036916(View view) {
            super(1);
            this.$view = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            C12238m.checkNotNullParameter(textView, "it");
            WidgetUserSheetViewModel viewModel = WidgetUserSheet.this.getViewModel();
            Context context = WidgetUserSheet.this.getContext();
            TextInputLayout textInputLayout = WidgetUserSheet.this.getBinding().f18388B;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
            viewModel.saveUserNote(context, ViewExtensions.getTextOrEmpty(textInputLayout));
            WidgetUserSheet.this.getBinding().f18388B.clearFocus();
            WidgetUserSheet.this.hideKeyboard(this.$view);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$18 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C1037118 extends AbstractC12240o implements Function2<Long, String, Unit> {
        public C1037118() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.f27425a;
        }

        public final void invoke(long j, String str) {
            C12238m.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetUserSheet.this.getViewModel().moveUserToChannel(j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$2 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C103722 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ boolean $isMe;

        /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetUserSheet.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C0876m.m169g(WidgetUserSheet.this.getContext(), C5419R.string.stage_channel_permission_microphone_denied, 0, null, 12);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetUserSheet.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetUserSheet.this.getViewModel().setUserSuppressedInChannel(false);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C103722(boolean z2) {
            super(0);
            this.$isMe = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$isMe) {
                WidgetUserSheet.this.requestMicrophone(new AnonymousClass1(), new AnonymousClass2());
            } else {
                WidgetUserSheet.this.getViewModel().inviteUserToSpeak();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$3 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C103733 extends AbstractC12240o implements Function0<Unit> {
        public C103733() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.this.getViewModel().setUserSuppressedInChannel(true);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$4 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C103744 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public C103744() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            WidgetUserSheet.this.getViewModel().toggleMute(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$5 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C103755 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public C103755() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            WidgetUserSheet.this.getViewModel().toggleDeafen(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$6 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C103766 extends AbstractC12240o implements Function2<Float, Boolean, Unit> {
        public C103766() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Float f, Boolean bool) {
            invoke(f.floatValue(), bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(float f, boolean z2) {
            if (z2) {
                WidgetUserSheet.this.getViewModel().setUserOutputVolume(f);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$7 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C103777 extends AbstractC12240o implements Function0<Unit> {
        public C103777() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.this.getViewModel().editMember();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$8 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C103788 extends AbstractC12240o implements Function0<Unit> {
        public C103788() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.this.getViewModel().kickUser();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$onViewCreated$9 */
    /* JADX INFO: compiled from: WidgetUserSheet.kt */
    public static final class C103799 extends AbstractC12240o implements Function0<Unit> {
        public C103799() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserSheet.this.getViewModel().banUser();
        }
    }

    public WidgetUserSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserSheet$binding$2.INSTANCE, null, 2, null);
        WidgetUserSheet$viewModelUserProfileHeader$2 widgetUserSheet$viewModelUserProfileHeader$2 = new WidgetUserSheet$viewModelUserProfileHeader$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModelUserProfileHeader = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(UserProfileHeaderViewModel.class), new WidgetUserSheet$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetUserSheet$viewModelUserProfileHeader$2));
        WidgetUserSheet$viewModel$2 widgetUserSheet$viewModel$2 = new WidgetUserSheet$viewModel$2(this);
        C0865g0 c0865g1 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetUserSheetViewModel.class), new WidgetUserSheet$appViewModels$$inlined$viewModels$2(c0865g1), new C0869i0(widgetUserSheet$viewModel$2));
    }

    private final void acceptFriendRequest(String username) {
        WidgetUserSheetViewModel.addRelationship$default(getViewModel(), null, username, C5419R.string.accept_request_button_after, null, 8, null);
    }

    private final void addFriend(String username) {
        WidgetUserSheetViewModel.addRelationship$default(getViewModel(), null, username, C5419R.string.friend_request_sent, null, 8, null);
    }

    private final void configureAboutMe(final WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        String strComputeShortName;
        List<Node<MessageRenderContext>> bioAst = viewState.getBioAst();
        getBinding().f18410f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheet.configureAboutMe.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (viewState.getHasGuildMemberBio()) {
                    C12238m.checkNotNullExpressionValue(view, "it");
                    C0876m.m170h(view.getContext(), C1107b.m213e(WidgetUserSheet.this, C5419R.string.guild_identity_bio_toast, new Object[]{viewState.getGuildName()}, (4 & 4) != 0 ? C1107b.a.f1490j : null), 0, null, 12);
                }
            }
        });
        TextView textView = getBinding().f18409e;
        C12238m.checkNotNullExpressionValue(textView, "binding.aboutMeHeader");
        textView.setVisibility(bioAst != null ? 0 : 8);
        SimpleDraweeView simpleDraweeView = getBinding().f18407c;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.aboutMeGuildIcon");
        simpleDraweeView.setVisibility(viewState.getHasGuildMemberBio() ? 0 : 8);
        String guildIconURL = viewState.getGuildIconURL();
        if (guildIconURL == null || guildIconURL.length() == 0) {
            SimpleDraweeView simpleDraweeView2 = getBinding().f18407c;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.aboutMeGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON_BLURPLE, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
            TextView textView2 = getBinding().f18408d;
            C12238m.checkNotNullExpressionValue(textView2, "binding.aboutMeGuildIconName");
            textView2.setVisibility(0);
            TextView textView3 = getBinding().f18408d;
            C12238m.checkNotNullExpressionValue(textView3, "binding.aboutMeGuildIconName");
            String guildName = viewState.getGuildName();
            if (guildName == null || (strComputeShortName = GuildUtilsKt.computeShortName(guildName)) == null) {
                strComputeShortName = "";
            }
            textView3.setText(strComputeShortName);
        } else {
            SimpleDraweeView simpleDraweeView3 = getBinding().f18407c;
            C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.aboutMeGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView3, viewState.getGuildIconURL(), 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
            TextView textView4 = getBinding().f18408d;
            C12238m.checkNotNullExpressionValue(textView4, "binding.aboutMeGuildIconName");
            textView4.setVisibility(8);
        }
        CardView cardView = getBinding().f18406b;
        C12238m.checkNotNullExpressionValue(cardView, "binding.aboutMeCard");
        cardView.setVisibility(bioAst != null ? 0 : 8);
        if (bioAst != null) {
            LinkifiedTextView linkifiedTextView = getBinding().f18411g;
            C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.aboutMeText");
            Context context = linkifiedTextView.getContext();
            C12238m.checkNotNullExpressionValue(context, "binding.aboutMeText.context");
            getBinding().f18411g.setDraweeSpanStringBuilder(AstRenderer.render(viewState.getBioAst(), new MessageRenderContext(context, 0L, false, null, null, null, 0, null, null, 0, 0, new WidgetUserSheet$configureAboutMe$renderContext$1(getViewModel()), null, null, 14328, null)));
        }
    }

    private final void configureConnectionsSection(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        UserProfileConnectionsView.ViewState connectionsViewState = viewState.getConnectionsViewState();
        TextView textView = getBinding().f18417m;
        C12238m.checkNotNullExpressionValue(textView, "binding.userSheetConnectionsHeader");
        textView.setVisibility(connectionsViewState.getShowConnectionsSection() ? 0 : 8);
        UserProfileConnectionsView userProfileConnectionsView = getBinding().f18418n;
        C12238m.checkNotNullExpressionValue(userProfileConnectionsView, "binding.userSheetConnectionsView");
        userProfileConnectionsView.setVisibility(connectionsViewState.getShowConnectionsSection() ? 0 : 8);
        C10344xa5617a90 c10344xa5617a90 = new C10344xa5617a90(this);
        User user = viewState.getUser();
        getBinding().f18418n.updateViewState(connectionsViewState, c10344xa5617a90, new C10346xf08aeacd(this, user), new C10345x54a729c2(this, user));
    }

    private final void configureDeveloperSection(final WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        final TextView textView = getBinding().f18419o;
        textView.setVisibility(StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode() ? 0 : 8);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheet$configureDeveloperSection$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Context context = textView.getContext();
                C12238m.checkNotNullExpressionValue(context, "context");
                C0876m.m165c(context, String.valueOf(viewState.getUser().getId()), 0, 4);
                this.dismiss();
            }
        });
        TextView textView2 = getBinding().f18419o;
        C12238m.checkNotNullExpressionValue(textView2, "binding.userSheetCopyId");
        boolean z2 = textView2.getVisibility() == 0;
        TextView textView3 = getBinding().f18420p;
        C12238m.checkNotNullExpressionValue(textView3, "binding.userSheetDeveloperHeader");
        textView3.setVisibility(z2 ? 0 : 8);
    }

    private final void configureGuildSection(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        List<GuildRole> roleItems = viewState.getRoleItems();
        UserProfileAdminView.ViewState adminViewState = viewState.getAdminViewState();
        boolean zShouldShowRoles = viewState.shouldShowRoles();
        boolean z2 = true;
        boolean z3 = adminViewState != null && adminViewState.isAdminSectionEnabled();
        LinearLayout linearLayout = getBinding().f18424t;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.userSheetGuildContainer");
        if (!zShouldShowRoles && !z3) {
            z2 = false;
        }
        linearLayout.setVisibility(z2 ? 0 : 8);
        RolesListView rolesListView = getBinding().f18402P;
        C12238m.checkNotNullExpressionValue(rolesListView, "binding.userSheetRolesList");
        rolesListView.setVisibility(zShouldShowRoles ? 0 : 8);
        Long guildId = viewState.getGuildId();
        if (zShouldShowRoles && guildId != null) {
            RolesListView rolesListView2 = getBinding().f18402P;
            RolesListView rolesListView3 = getBinding().f18402P;
            C12238m.checkNotNullExpressionValue(rolesListView3, "binding.userSheetRolesList");
            rolesListView2.updateView(roleItems, ColorCompat.getThemedColor(rolesListView3.getContext(), C5419R.attr.primary_300), guildId.longValue());
        }
        String guildSectionHeaderText = viewState.getGuildSectionHeaderText();
        if (guildSectionHeaderText != null) {
            TextView textView = getBinding().f18425u;
            C12238m.checkNotNullExpressionValue(textView, "binding.userSheetGuildHeader");
            textView.setText(guildSectionHeaderText);
        }
        CardView cardView = getBinding().f18414j;
        C12238m.checkNotNullExpressionValue(cardView, "binding.userSheetAdminCard");
        cardView.setVisibility(z3 ? 0 : 8);
        UserProfileAdminView userProfileAdminView = getBinding().f18415k;
        C12238m.checkNotNullExpressionValue(userProfileAdminView, "binding.userSheetAdminView");
        userProfileAdminView.setVisibility(z3 ? 0 : 8);
        if (adminViewState != null) {
            getBinding().f18415k.updateView(adminViewState);
        }
    }

    private final void configureIncomingFriendRequest(final WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        boolean z2 = ModelUserRelationship.getType(Integer.valueOf(viewState.getUserRelationshipType())) == 3;
        TextView textView = getBinding().f18426v;
        C12238m.checkNotNullExpressionValue(textView, "binding.userSheetIncomingFriendRequestHeader");
        textView.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = getBinding().f18423s;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.userSheetFriendRequestIncomingContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        getBinding().f18421q.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheet.configureIncomingFriendRequest.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetUserSheet.this.acceptFriendRequest(viewState.getUser().getUsername());
            }
        });
        getBinding().f18422r.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheet.configureIncomingFriendRequest.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetUserSheet.this.ignoreFriendRequest();
            }
        });
    }

    private final void configureNote(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        getBinding().f18387A.setRawInputType(1);
        StoreUserNotes.UserNoteState userNoteFetchState = viewState.getUserNoteFetchState();
        if (userNoteFetchState instanceof StoreUserNotes.UserNoteState.Empty) {
            TextInputLayout textInputLayout = getBinding().f18388B;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
            textInputLayout.setHint(getString(C5419R.string.note_placeholder_mobile));
            TextInputLayout textInputLayout2 = getBinding().f18388B;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.userSheetNoteTextFieldWrap");
            textInputLayout2.setEnabled(true);
        } else if (userNoteFetchState instanceof StoreUserNotes.UserNoteState.Loading) {
            TextInputLayout textInputLayout3 = getBinding().f18388B;
            C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.userSheetNoteTextFieldWrap");
            textInputLayout3.setHint(getString(C5419R.string.loading_note));
            TextInputLayout textInputLayout4 = getBinding().f18388B;
            C12238m.checkNotNullExpressionValue(textInputLayout4, "binding.userSheetNoteTextFieldWrap");
            textInputLayout4.setEnabled(false);
        } else if (userNoteFetchState instanceof StoreUserNotes.UserNoteState.Loaded) {
            TextInputLayout textInputLayout5 = getBinding().f18388B;
            C12238m.checkNotNullExpressionValue(textInputLayout5, "binding.userSheetNoteTextFieldWrap");
            textInputLayout5.setHint(getString(C5419R.string.note_placeholder_mobile));
            TextInputLayout textInputLayout6 = getBinding().f18388B;
            C12238m.checkNotNullExpressionValue(textInputLayout6, "binding.userSheetNoteTextFieldWrap");
            textInputLayout6.setEnabled(true);
        }
        if (viewState.getUserNote() != null) {
            TextInputLayout textInputLayout7 = getBinding().f18388B;
            C12238m.checkNotNullExpressionValue(textInputLayout7, "binding.userSheetNoteTextFieldWrap");
            ViewExtensions.setTextIfDifferent(textInputLayout7, viewState.getUserNote());
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007f  */
    private final void configureProfileActionButtons(final WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        boolean z2;
        boolean zIsMe = viewState.isMe();
        final Long currentGuildId = viewState.getCurrentGuildId();
        final UserProfile userProfile = viewState.getUserProfile();
        FrameLayout frameLayout = getBinding().f18393G;
        C12238m.checkNotNullExpressionValue(frameLayout, "binding.userSheetProfileAddToServerContainer");
        frameLayout.setVisibility(ApplicationUtils.INSTANCE.canInstallApplication(userProfile != null ? userProfile.getApplication() : null) ? 0 : 8);
        getBinding().f18392F.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheet.configureProfileActionButtons.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplicationUtils applicationUtils = ApplicationUtils.INSTANCE;
                UserProfile userProfile2 = userProfile;
                Uri applicationUri = applicationUtils.getApplicationUri(userProfile2 != null ? userProfile2.getApplication() : null);
                if (applicationUri != null) {
                    Context contextM885x = C1643a.m885x(view, "view", "view.context");
                    String string = applicationUri.toString();
                    C12238m.checkNotNullExpressionValue(string, "uri.toString()");
                    UriHandler.handleOrUntrusted$default(contextM885x, string, null, 4, null);
                }
            }
        });
        FlexboxLayout flexboxLayout = getBinding().f18395I;
        C12238m.checkNotNullExpressionValue(flexboxLayout, "binding.userSheetProfileEditContainer");
        flexboxLayout.setVisibility(zIsMe ? 0 : 8);
        getBinding().f18394H.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheet.configureProfileActionButtons.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetEditUserOrGuildMemberProfile.Companion companion = WidgetEditUserOrGuildMemberProfile.INSTANCE;
                Context contextRequireContext = WidgetUserSheet.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "this@WidgetUserSheet.requireContext()");
                WidgetEditUserOrGuildMemberProfile.Companion.launch$default(companion, contextRequireContext, null, null, 6, null);
            }
        });
        MaterialButton materialButton = getBinding().f18397K;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.userSheetProfileIdentityButton");
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
        getBinding().f18397K.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheet.configureProfileActionButtons.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (currentGuildId != null) {
                    Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-10_premium_guild_member_profiles", true);
                    if (userExperiment != null && userExperiment.getBucket() == 1) {
                        WidgetEditUserOrGuildMemberProfile.Companion.launch$default(WidgetEditUserOrGuildMemberProfile.INSTANCE, C1643a.m885x(view, "it", "it.context"), null, currentGuildId, 2, null);
                        return;
                    }
                    WidgetChangeGuildIdentity.Companion companion = WidgetChangeGuildIdentity.INSTANCE;
                    long jLongValue = currentGuildId.longValue();
                    C12238m.checkNotNullExpressionValue(view, "it");
                    Context context = view.getContext();
                    C12238m.checkNotNullExpressionValue(context, "it.context");
                    companion.launch(jLongValue, "User Bottom Sheet", context);
                }
            }
        });
        boolean isBot = viewState.getUser().getIsBot();
        boolean isSystemUser = viewState.getUser().getIsSystemUser();
        final int userRelationshipType = viewState.getUserRelationshipType();
        boolean z3 = (zIsMe || isSystemUser) ? false : true;
        View view = getBinding().f18391E;
        C12238m.checkNotNullExpressionValue(view, "binding.userSheetProfileActionsDivider");
        view.setVisibility(z3 ? 0 : 8);
        LinearLayout linearLayout = getBinding().f18390D;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.userSheetProfileActionsContainer");
        linearLayout.setVisibility(z3 ? 0 : 8);
        if (z3) {
            Button button = getBinding().f18428x;
            C12238m.checkNotNullExpressionValue(button, "binding.userSheetMessageActionButton");
            Channel channel = viewState.getChannel();
            button.setVisibility(channel == null || channel.getType() != 1 ? 0 : 8);
            getBinding().f18428x.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheet.configureProfileActionButtons.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ChannelSelector companion = ChannelSelector.INSTANCE.getInstance();
                    Context contextRequireContext = WidgetUserSheet.this.requireContext();
                    C12238m.checkNotNullExpressionValue(contextRequireContext, "this@WidgetUserSheet.requireContext()");
                    companion.findAndSetDirectMessage(contextRequireContext, viewState.getUser().getId());
                    WidgetUserSheet.this.dismiss();
                    StoreTabsNavigation.selectHomeTab$default(StoreStream.INSTANCE.getTabsNavigation(), StoreNavigation.PanelAction.CLOSE, false, 2, null);
                    AppActivity appActivityRequireAppActivity = WidgetUserSheet.this.requireAppActivity();
                    Context contextRequireContext2 = WidgetUserSheet.this.requireContext();
                    C12238m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                    appActivityRequireAppActivity.m8349j(contextRequireContext2);
                }
            });
            getBinding().f18416l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheet.configureProfileActionButtons.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WidgetUserSheet.this.getViewModel().launchVoiceCall();
                }
            });
            getBinding().f18403Q.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheet.configureProfileActionButtons.6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WidgetUserSheet.this.getViewModel().launchVideoCall();
                }
            });
            if (userRelationshipType == 0) {
                Button button2 = getBinding().f18413i;
                C12238m.checkNotNullExpressionValue(button2, "binding.userSheetAddFriendActionButton");
                button2.setVisibility(0);
                Button button3 = getBinding().f18389C;
                C12238m.checkNotNullExpressionValue(button3, "binding.userSheetPendingFriendRequestActionButton");
                button3.setVisibility(8);
            } else if (userRelationshipType == 3 || userRelationshipType == 4) {
                Button button4 = getBinding().f18413i;
                C12238m.checkNotNullExpressionValue(button4, "binding.userSheetAddFriendActionButton");
                button4.setVisibility(8);
                Button button5 = getBinding().f18389C;
                C12238m.checkNotNullExpressionValue(button5, "binding.userSheetPendingFriendRequestActionButton");
                button5.setVisibility(0);
            } else {
                Button button6 = getBinding().f18413i;
                C12238m.checkNotNullExpressionValue(button6, "binding.userSheetAddFriendActionButton");
                button6.setVisibility(8);
                Button button7 = getBinding().f18389C;
                C12238m.checkNotNullExpressionValue(button7, "binding.userSheetPendingFriendRequestActionButton");
                button7.setVisibility(8);
            }
            boolean z4 = (zIsMe || isBot || userRelationshipType != 0) ? false : true;
            Button button8 = getBinding().f18413i;
            C12238m.checkNotNullExpressionValue(button8, "binding.userSheetAddFriendActionButton");
            button8.setVisibility(z4 ? 0 : 8);
            getBinding().f18413i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheet.configureProfileActionButtons.7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WidgetUserSheet.this.addFriend(viewState.getUser().getUsername());
                }
            });
            getBinding().f18389C.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheet.configureProfileActionButtons.8

                /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$8$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetUserSheet.kt */
                public static final /* synthetic */ class AnonymousClass1 extends C12236k implements Function1<Integer, Unit> {
                    public AnonymousClass1(WidgetUserSheetViewModel widgetUserSheetViewModel) {
                        super(1, widgetUserSheetViewModel, WidgetUserSheetViewModel.class, "removeRelationship", "removeRelationship(I)V", 0);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.f27425a;
                    }

                    public final void invoke(int i) {
                        ((WidgetUserSheetViewModel) this.receiver).removeRelationship(i);
                    }
                }

                /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$8$2, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetUserSheet.kt */
                public static final class AnonymousClass2 extends AbstractC12240o implements Function0<Unit> {
                    public AnonymousClass2() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f27425a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ViewOnClickListenerC103578 viewOnClickListenerC103578 = ViewOnClickListenerC103578.this;
                        WidgetUserSheet.this.acceptFriendRequest(viewState.getUser().getUsername());
                    }
                }

                /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureProfileActionButtons$8$3, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetUserSheet.kt */
                public static final class AnonymousClass3 extends AbstractC12240o implements Function0<Unit> {
                    public AnonymousClass3() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f27425a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        WidgetUserSheet.this.ignoreFriendRequest();
                    }
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i = userRelationshipType;
                    Integer numValueOf = Integer.valueOf(C5419R.id.notice_ok);
                    if (i == 3) {
                        FragmentManager parentFragmentManager = WidgetUserSheet.this.getParentFragmentManager();
                        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                        Context contextRequireContext = WidgetUserSheet.this.requireContext();
                        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
                        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
                        C12238m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
                        C12238m.checkNotNullParameter(contextRequireContext, "context");
                        C12238m.checkNotNullParameter(anonymousClass2, "onAccept");
                        C12238m.checkNotNullParameter(anonymousClass3, "onIgnore");
                        WidgetNoticeDialog.Companion.show$default(WidgetNoticeDialog.INSTANCE, parentFragmentManager, C1107b.m210b(contextRequireContext, C5419R.string.incoming_friend_request, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null), C1107b.m210b(contextRequireContext, C5419R.string.user_profile_incoming_friend_request_dialog_body, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null), C1107b.m210b(contextRequireContext, C5419R.string.friend_request_accept, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null), C1107b.m210b(contextRequireContext, C5419R.string.friend_request_ignore, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null), C12136h0.mapOf(C12116o.m10073to(numValueOf, new C12807l(0, anonymousClass2)), C12116o.m10073to(Integer.valueOf(C5419R.id.notice_cancel), new C12807l(1, anonymousClass3))), null, null, null, null, null, null, 0, null, 16320, null);
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    User user = viewState.getUser();
                    Context contextRequireContext2 = WidgetUserSheet.this.requireContext();
                    C12238m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                    FragmentManager parentFragmentManager2 = WidgetUserSheet.this.getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(WidgetUserSheet.this.getViewModel());
                    C12238m.checkNotNullParameter(user, "user");
                    C12238m.checkNotNullParameter(contextRequireContext2, "context");
                    C12238m.checkNotNullParameter(parentFragmentManager2, "fragmentManager");
                    C12238m.checkNotNullParameter(anonymousClass1, "onConfirm");
                    WidgetNoticeDialog.Companion.show$default(WidgetNoticeDialog.INSTANCE, parentFragmentManager2, C1107b.m210b(contextRequireContext2, C5419R.string.outgoing_friend_request, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null), C1107b.m210b(contextRequireContext2, C5419R.string.outgoing_friend_request_delete_msg, new Object[]{user.getUsername()}, (4 & 4) != 0 ? C1107b.b.f1491j : null), C1107b.m210b(contextRequireContext2, C5419R.string.delete, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null), C1107b.m210b(contextRequireContext2, C5419R.string.cancel, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null), C12134g0.mapOf(C12116o.m10073to(numValueOf, new C0835l(anonymousClass1))), null, null, null, Integer.valueOf(C5419R.attr.notice_theme_positive_red), null, null, 0, null, 15808, null);
                }
            });
        }
    }

    private final void configureStageActionsSection(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        getBinding().f18399M.updateView(viewState.getStageViewState());
        CardView cardView = getBinding().f18398L;
        C12238m.checkNotNullExpressionValue(cardView, "binding.userSheetProfileStageActionsCard");
        UserProfileStageActionsView userProfileStageActionsView = getBinding().f18399M;
        C12238m.checkNotNullExpressionValue(userProfileStageActionsView, "binding.userSheetProfileStageActionsView");
        cardView.setVisibility(userProfileStageActionsView.getVisibility() == 0 ? 0 : 8);
    }

    private final void configureUI(WidgetUserSheetViewModel.ViewState model) {
        if (model instanceof WidgetUserSheetViewModel.ViewState.Uninitialized) {
            FrameLayout frameLayout = getBinding().f18427w;
            C12238m.checkNotNullExpressionValue(frameLayout, "binding.userSheetLoadingContainer");
            frameLayout.setVisibility(0);
            return;
        }
        if (!(model instanceof WidgetUserSheetViewModel.ViewState.Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        FrameLayout frameLayout2 = getBinding().f18427w;
        C12238m.checkNotNullExpressionValue(frameLayout2, "binding.userSheetLoadingContainer");
        frameLayout2.setVisibility(8);
        WidgetUserSheetViewModel.ViewState.Loaded loaded = (WidgetUserSheetViewModel.ViewState.Loaded) model;
        Presence presence = loaded.getPresence();
        Activity primaryActivity = presence != null ? PresenceUtils.INSTANCE.getPrimaryActivity(presence) : null;
        boolean zIsMe = loaded.isMe();
        boolean isSystemUser = loaded.getUser().getIsSystemUser();
        if (!getViewModel().getOpenPopoutLogged() && loaded.getProfileLoaded()) {
            AnalyticsTracker.INSTANCE.openUserSheet(loaded.getHasPremiumCustomization(), primaryActivity != null ? primaryActivity.getName() : null, primaryActivity != null ? ActivityUtilsKt.getGamePlatform(primaryActivity) : null, loaded.getGuildMember());
            getViewModel().setOpenPopoutLogged(true);
        }
        getBinding().f18396J.setOnBannerPress(new C103581());
        ImageView imageView = getBinding().f18429y;
        C12238m.checkNotNullExpressionValue(imageView, "binding.userSheetMoreButton");
        imageView.setVisibility((zIsMe || isSystemUser) ? false : true ? 0 : 8);
        if (loaded.getConnectionsViewState().getShowConnectionsSection()) {
            setPeekHeightBottomView(getBinding().f18417m);
        }
        ViewHolderUserRichPresence.Companion companion = ViewHolderUserRichPresence.INSTANCE;
        FrameLayout frameLayout3 = getBinding().f18412h;
        C12238m.checkNotNullExpressionValue(frameLayout3, "binding.richPresenceContainer");
        ViewHolderUserRichPresence richPresence = companion.setRichPresence(frameLayout3, primaryActivity, loaded.getStreamContext(), this.activityViewHolder);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        StreamContext streamContext = loaded.getStreamContext();
        boolean zIsMe2 = loaded.isMe();
        User user = loaded.getUser();
        Context applicationContext = requireAppActivity().getApplicationContext();
        C12238m.checkNotNullExpressionValue(applicationContext, "requireAppActivity().applicationContext");
        richPresence.configureUi(parentFragmentManager, streamContext, zIsMe2, user, applicationContext, loaded.getRichPresence(), loaded.getUserInSameVoiceChannel());
        richPresence.configureUiTimestamp(primaryActivity, this);
        this.activityViewHolder = richPresence;
        ViewHolderStreamRichPresence viewHolderStreamRichPresence = (ViewHolderStreamRichPresence) (richPresence instanceof ViewHolderStreamRichPresence ? richPresence : null);
        if (loaded.getStreamContext() != null && viewHolderStreamRichPresence != null) {
            viewHolderStreamRichPresence.setOnStreamPreviewClicked(new C103593(model));
        }
        ViewHolderUserRichPresence viewHolderUserRichPresence = this.activityViewHolder;
        if (viewHolderUserRichPresence != null) {
            viewHolderUserRichPresence.setOnActivityCustomButtonClicked(new C103604(getViewModel()));
        }
        configureProfileActionButtons(loaded);
        configureStageActionsSection(loaded);
        configureAboutMe(loaded);
        configureIncomingFriendRequest(loaded);
        configureVoiceSection(loaded);
        configureGuildSection(loaded);
        configureConnectionsSection(loaded);
        configureNote(loaded);
        configureDeveloperSection(loaded);
    }

    private final void configureVoiceSection(WidgetUserSheetViewModel.ViewState.Loaded viewState) {
        UserProfileVoiceSettingsView.ViewState voiceSettingsViewState = viewState.getVoiceSettingsViewState();
        boolean showVoiceSettings = viewState.getShowVoiceSettings();
        TextView textView = getBinding().f18400N;
        C12238m.checkNotNullExpressionValue(textView, "binding.userSheetProfileVoiceSettingsHeader");
        textView.setVisibility(showVoiceSettings ? 0 : 8);
        CardView cardView = getBinding().f18404R;
        C12238m.checkNotNullExpressionValue(cardView, "binding.voiceSettingsViewCard");
        cardView.setVisibility(showVoiceSettings ? 0 : 8);
        getBinding().f18401O.updateView(voiceSettingsViewState);
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

    private final void handleBanUser(WidgetUserSheetViewModel.Event.LaunchBanUser event) {
        WidgetBanUser.INSTANCE.launch(event.getUsername(), event.getGuildId(), event.getUserId(), getParentFragmentManager());
    }

    private final void handleDisableCommunication(WidgetUserSheetViewModel.Event.LaunchDisableCommunication event) {
        WidgetDisableGuildCommunication.Companion companion = WidgetDisableGuildCommunication.INSTANCE;
        long userId = event.getUserId();
        long guildId = event.getGuildId();
        WidgetUserSheetBinding binding = getBinding();
        C12238m.checkNotNullExpressionValue(binding, "binding");
        NestedScrollView nestedScrollView = binding.f18405a;
        C12238m.checkNotNullExpressionValue(nestedScrollView, "binding.root");
        Context context = nestedScrollView.getContext();
        C12238m.checkNotNullExpressionValue(context, "binding.root.context");
        companion.launch(userId, guildId, context);
    }

    private final void handleDismissSheet() {
        dismiss();
    }

    private final void handleEnableCommunication(WidgetUserSheetViewModel.Event.LaunchEnableCommunication event) {
        WidgetEnableGuildCommunication.Companion companion = WidgetEnableGuildCommunication.INSTANCE;
        long userId = event.getUserId();
        long guildId = event.getGuildId();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.launch(userId, guildId, parentFragmentManager);
    }

    private final void handleEvent(WidgetUserSheetViewModel.Event event) {
        if (event instanceof WidgetUserSheetViewModel.Event.ShowToast) {
            handleShowToast((WidgetUserSheetViewModel.Event.ShowToast) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.ShowFriendRequestErrorToast) {
            handleShowFriendRequestErrorToast((WidgetUserSheetViewModel.Event.ShowFriendRequestErrorToast) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchVoiceCall) {
            handleLaunchVoiceCall((WidgetUserSheetViewModel.Event.LaunchVoiceCall) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchVideoCall) {
            handleLaunchVideoCall((WidgetUserSheetViewModel.Event.LaunchVideoCall) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchSpectate) {
            handleLaunchSpectate((WidgetUserSheetViewModel.Event.LaunchSpectate) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchEditMember) {
            handleLaunchEditMember((WidgetUserSheetViewModel.Event.LaunchEditMember) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchKickUser) {
            handleKickUser((WidgetUserSheetViewModel.Event.LaunchKickUser) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchBanUser) {
            handleBanUser((WidgetUserSheetViewModel.Event.LaunchBanUser) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchDisableCommunication) {
            handleDisableCommunication((WidgetUserSheetViewModel.Event.LaunchDisableCommunication) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchEnableCommunication) {
            handleEnableCommunication((WidgetUserSheetViewModel.Event.LaunchEnableCommunication) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.LaunchMoveUser) {
            handleMoveUser((WidgetUserSheetViewModel.Event.LaunchMoveUser) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.RequestPermissionsForSpectateStream) {
            handleRequestPermissionsForSpectateStream((WidgetUserSheetViewModel.Event.RequestPermissionsForSpectateStream) event);
            return;
        }
        if (event instanceof WidgetUserSheetViewModel.Event.UserNotFound) {
            C0876m.m171i(this, C5419R.string.user_profile_failure_to_open_message, 0, 4);
            handleDismissSheet();
        } else {
            if (!(event instanceof WidgetUserSheetViewModel.Event.DismissSheet)) {
                throw new NoWhenBranchMatchedException();
            }
            handleDismissSheet();
        }
    }

    private final void handleKickUser(WidgetUserSheetViewModel.Event.LaunchKickUser event) {
        WidgetKickUser.Companion companion = WidgetKickUser.INSTANCE;
        String username = event.getUsername();
        long guildId = event.getGuildId();
        long userId = event.getUserId();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.launch(username, guildId, userId, parentFragmentManager);
    }

    private final void handleLaunchEditMember(WidgetUserSheetViewModel.Event.LaunchEditMember event) {
        WidgetServerSettingsEditMember.Companion companion = WidgetServerSettingsEditMember.INSTANCE;
        long guildId = event.getGuildId();
        long userId = event.getUserId();
        WidgetUserSheetBinding binding = getBinding();
        C12238m.checkNotNullExpressionValue(binding, "binding");
        NestedScrollView nestedScrollView = binding.f18405a;
        C12238m.checkNotNullExpressionValue(nestedScrollView, "binding.root");
        Context context = nestedScrollView.getContext();
        C12238m.checkNotNullExpressionValue(context, "binding.root.context");
        companion.launch(guildId, userId, context);
    }

    private final void handleLaunchSpectate(WidgetUserSheetViewModel.Event.LaunchSpectate event) {
        WidgetCallFullscreen.Companion companion = WidgetCallFullscreen.INSTANCE;
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetCallFullscreen.Companion.launch$default(companion, contextRequireContext, event.getStream().getChannelId(), false, event.getStream().getEncodedStreamKey(), null, 20, null);
        dismiss();
    }

    private final void handleLaunchVideoCall(WidgetUserSheetViewModel.Event.LaunchVideoCall event) {
        PrivateCallLauncher privateCallLauncher = this.privateCallLauncher;
        if (privateCallLauncher == null) {
            C12238m.throwUninitializedPropertyAccessException("privateCallLauncher");
        }
        privateCallLauncher.launchVideoCall(event.getChannelId());
    }

    private final void handleLaunchVoiceCall(WidgetUserSheetViewModel.Event.LaunchVoiceCall event) {
        PrivateCallLauncher privateCallLauncher = this.privateCallLauncher;
        if (privateCallLauncher == null) {
            C12238m.throwUninitializedPropertyAccessException("privateCallLauncher");
        }
        privateCallLauncher.launchVoiceCall(event.getChannelId());
    }

    private final void handleMoveUser(WidgetUserSheetViewModel.Event.LaunchMoveUser event) {
        WidgetChannelSelector.INSTANCE.launchForVocal(this, event.getGuildId(), REQUEST_KEY_MOVE_USER, (24 & 8) != 0 ? false : false, (24 & 16) != 0 ? C5419R.string.none : 0);
    }

    private final void handleRequestPermissionsForSpectateStream(WidgetUserSheetViewModel.Event.RequestPermissionsForSpectateStream event) {
        C1460d.m473S1(this, null, new C103611(event), 1, null);
    }

    private final void handleShowFriendRequestErrorToast(WidgetUserSheetViewModel.Event.ShowFriendRequestErrorToast event) {
        C0876m.m172j(this, RestAPIAbortMessages.ResponseResolver.INSTANCE.getRelationshipResponse(getContext(), event.getAbortCode(), event.getUsername()), 0, 4);
    }

    private final void handleShowToast(WidgetUserSheetViewModel.Event.ShowToast event) {
        C0876m.m171i(this, event.getStringRes(), 0, 4);
    }

    private final void ignoreFriendRequest() {
        getViewModel().removeRelationship(C5419R.string.friend_request_ignored);
    }

    private final void onStreamPreviewClicked(StreamContext streamContext) {
        getViewModel().onStreamPreviewClicked(streamContext);
    }

    public static final void show(long j, FragmentManager fragmentManager) {
        Companion.show$default(INSTANCE, j, null, fragmentManager, null, null, null, null, 122, null);
    }

    public static final void show(long j, Long l, FragmentManager fragmentManager) {
        Companion.show$default(INSTANCE, j, l, fragmentManager, null, null, null, null, 120, null);
    }

    public static final void show(long j, Long l, FragmentManager fragmentManager, Long l2) {
        Companion.show$default(INSTANCE, j, l, fragmentManager, l2, null, null, null, 112, null);
    }

    public static final void show(long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool) {
        Companion.show$default(INSTANCE, j, l, fragmentManager, l2, bool, null, null, 96, null);
    }

    public static final void show(long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool, StreamPreviewClickBehavior streamPreviewClickBehavior) {
        Companion.show$default(INSTANCE, j, l, fragmentManager, l2, bool, streamPreviewClickBehavior, null, 64, null);
    }

    public static final void show(long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool, StreamPreviewClickBehavior streamPreviewClickBehavior, String str) {
        INSTANCE.show(j, l, fragmentManager, l2, bool, streamPreviewClickBehavior, str);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        C12238m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetUserSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C103411(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetUserSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C103422(this));
        UserProfileHeaderView.Companion companion = UserProfileHeaderView.INSTANCE;
        UserProfileHeaderView userProfileHeaderView = getBinding().f18396J;
        C12238m.checkNotNullExpressionValue(userProfileHeaderView, "binding.userSheetProfileHeaderView");
        companion.bind(userProfileHeaderView, this, getViewModelUserProfileHeader().observeViewState());
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_user_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
            StoreStream.INSTANCE.getGuildSubscriptions().unsubscribeUser(j2, j);
        }
        hideKeyboard(getBinding().f18388B);
        WidgetUserSheetViewModel viewModel = getViewModel();
        Context context = getContext();
        TextInputLayout textInputLayout = getBinding().f18388B;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
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
        StoreStream.INSTANCE.getGuildSubscriptions().subscribeUser(j2, j);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final long j = getArgumentsOrDefault().getLong(ARG_USER_ID);
        boolean z2 = j == StoreStream.INSTANCE.getUsers().getMeSnapshot().getId();
        getBinding().f18429y.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheet.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C0817a.Companion bVar = C0817a.INSTANCE;
                FragmentManager parentFragmentManager = WidgetUserSheet.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                long j2 = j;
                long j3 = WidgetUserSheet.this.getArgumentsOrDefault().getLong(WidgetUserSheet.ARG_CHANNEL_ID);
                Objects.requireNonNull(bVar);
                C12238m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
                C0817a c0817a = new C0817a();
                Bundle bundleM832T = C1643a.m832T("com.discord.intent.extra.EXTRA_USER_ID", j2);
                bundleM832T.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", j3);
                c0817a.setArguments(bundleM832T);
                c0817a.show(parentFragmentManager, C0817a.class.getName());
            }
        });
        UserProfileHeaderView userProfileHeaderView = getBinding().f18396J;
        Badge.Companion companion = Badge.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        userProfileHeaderView.setOnBadgeClick(companion.onBadgeClick(parentFragmentManager, contextRequireContext));
        getBinding().f18399M.setOnInviteToSpeak(new C103722(z2));
        getBinding().f18399M.setOnMoveToAudience(new C103733());
        getBinding().f18401O.setOnMuteChecked(new C103744());
        getBinding().f18401O.setOnDeafenChecked(new C103755());
        getBinding().f18401O.setOnVolumeChange(new C103766());
        getBinding().f18415k.setOnEditMember(new C103777());
        getBinding().f18415k.setOnKick(new C103788());
        getBinding().f18415k.setOnBan(new C103799());
        getBinding().f18415k.setOnDisableCommunication(new C1036310());
        getBinding().f18415k.setOnServerMute(new C1036411());
        getBinding().f18415k.setOnServerDeafen(new C1036512());
        getBinding().f18415k.setOnServerMove(new C1036613());
        getBinding().f18415k.setOnDisconnect(new C1036714());
        TextInputLayout textInputLayout = getBinding().f18388B;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
        ViewExtensions.setOnEditTextFocusChangeListener(textInputLayout, new View.OnFocusChangeListener() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheet.onViewCreated.15
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z3) {
                if (z3) {
                    return;
                }
                WidgetUserSheetViewModel viewModel = WidgetUserSheet.this.getViewModel();
                Context context = WidgetUserSheet.this.getContext();
                TextInputLayout textInputLayout2 = WidgetUserSheet.this.getBinding().f18388B;
                C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.userSheetNoteTextFieldWrap");
                viewModel.saveUserNote(context, ViewExtensions.getTextOrEmpty(textInputLayout2));
            }
        });
        TextInputLayout textInputLayout2 = getBinding().f18388B;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.userSheetNoteTextFieldWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout2, false, new C1036916(view), 1, null);
        ViewCompat.setAccessibilityDelegate(getBinding().f18429y, new AccessibilityDelegateCompat() { // from class: com.discord.widgets.user.usersheet.WidgetUserSheet.onViewCreated.17
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                C12238m.checkNotNullParameter(host, "host");
                C12238m.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                info.setTraversalAfter(WidgetUserSheet.this.getBinding().f18419o);
            }
        });
        for (TextView textView : C12147n.listOf((Object[]) new TextView[]{getBinding().f18417m, getBinding().f18425u, getBinding().f18430z, getBinding().f18420p, getBinding().f18426v, getBinding().f18400N})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            C12238m.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
        WidgetChannelSelector.Companion.registerForResult$default(WidgetChannelSelector.INSTANCE, this, REQUEST_KEY_MOVE_USER, false, new C1037118(), 4, null);
    }
}
