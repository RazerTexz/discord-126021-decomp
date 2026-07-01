package com.discord.widgets.user.usersheet;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.activity.ActivityMetadata;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.api.user.UserProfile;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelUserNote;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.CoreUser;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.nullserializable.NullSerializable;
import com.discord.restapi.RestAPIParams;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserNotes;
import com.discord.stores.StoreUserProfile;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.permissions.PermissionsContexts3;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.voice.PerceptualVolumeUtils;
import com.discord.widgets.captcha.WidgetCaptcha4;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet;
import com.discord.widgets.stage.StageChannelAPI;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.usersheet.UserProfileStageActionsView;
import com.discord.widgets.user.presence.ModelRichPresence;
import com.discord.widgets.user.profile.UserProfileAdminView;
import com.discord.widgets.user.profile.UserProfileConnectionsView;
import com.discord.widgets.user.usersheet.UserProfileVoiceSettingsView;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheetViewModel extends AppViewModel<ViewState> {
    public static final String LOCATION = "User Profile";
    private final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> bioParser;
    private final long channelId;
    private final PublishSubject<Event> eventSubject;
    private Set<String> fetchedPreviews;
    private final String friendToken;
    private final Long guildId;
    private final boolean isVoiceContext;
    private StoreState mostRecentStoreState;
    private boolean openPopoutLogged;
    private final RestAPI restAPI;
    private final RestAPI restAPISerializeNulls;
    private final Set<Integer> revealedBioIndices;
    private final StoreApplicationStreamPreviews storeApplicationStreamPreviews;
    private final StoreApplicationStreaming storeApplicationStreaming;
    private final StoreMediaSettings storeMediaSettings;
    private final StoreUserNotes storeUserNotes;
    private final StoreUserProfile storeUserProfile;
    private final WidgetUserSheet.StreamPreviewClickBehavior streamPreviewClickBehavior;
    private final long userId;

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetUserSheetViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final class DismissSheet extends Event {
            public static final DismissSheet INSTANCE = new DismissSheet();

            private DismissSheet() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final /* data */ class LaunchBanUser extends Event {
            private final long guildId;
            private final long userId;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LaunchBanUser(String str, long j, long j2) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "username");
                this.username = str;
                this.guildId = j;
                this.userId = j2;
            }

            public static /* synthetic */ LaunchBanUser copy$default(LaunchBanUser launchBanUser, String str, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = launchBanUser.username;
                }
                if ((i & 2) != 0) {
                    j = launchBanUser.guildId;
                }
                long j3 = j;
                if ((i & 4) != 0) {
                    j2 = launchBanUser.userId;
                }
                return launchBanUser.copy(str, j3, j2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUsername() {
                return this.username;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final long getUserId() {
                return this.userId;
            }

            public final LaunchBanUser copy(String username, long guildId, long userId) {
                Intrinsics3.checkNotNullParameter(username, "username");
                return new LaunchBanUser(username, guildId, userId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchBanUser)) {
                    return false;
                }
                LaunchBanUser launchBanUser = (LaunchBanUser) other;
                return Intrinsics3.areEqual(this.username, launchBanUser.username) && this.guildId == launchBanUser.guildId && this.userId == launchBanUser.userId;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final long getUserId() {
                return this.userId;
            }

            public final String getUsername() {
                return this.username;
            }

            public int hashCode() {
                String str = this.username;
                return b.a(this.userId) + ((b.a(this.guildId) + ((str != null ? str.hashCode() : 0) * 31)) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("LaunchBanUser(username=");
                sbU.append(this.username);
                sbU.append(", guildId=");
                sbU.append(this.guildId);
                sbU.append(", userId=");
                return outline.C(sbU, this.userId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final /* data */ class LaunchDisableCommunication extends Event {
            private final long guildId;
            private final long userId;

            public LaunchDisableCommunication(long j, long j2) {
                super(null);
                this.userId = j;
                this.guildId = j2;
            }

            public static /* synthetic */ LaunchDisableCommunication copy$default(LaunchDisableCommunication launchDisableCommunication, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchDisableCommunication.userId;
                }
                if ((i & 2) != 0) {
                    j2 = launchDisableCommunication.guildId;
                }
                return launchDisableCommunication.copy(j, j2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getUserId() {
                return this.userId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final LaunchDisableCommunication copy(long userId, long guildId) {
                return new LaunchDisableCommunication(userId, guildId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchDisableCommunication)) {
                    return false;
                }
                LaunchDisableCommunication launchDisableCommunication = (LaunchDisableCommunication) other;
                return this.userId == launchDisableCommunication.userId && this.guildId == launchDisableCommunication.guildId;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final long getUserId() {
                return this.userId;
            }

            public int hashCode() {
                return b.a(this.guildId) + (b.a(this.userId) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("LaunchDisableCommunication(userId=");
                sbU.append(this.userId);
                sbU.append(", guildId=");
                return outline.C(sbU, this.guildId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final /* data */ class LaunchEditMember extends Event {
            private final long guildId;
            private final long userId;

            public LaunchEditMember(long j, long j2) {
                super(null);
                this.guildId = j;
                this.userId = j2;
            }

            public static /* synthetic */ LaunchEditMember copy$default(LaunchEditMember launchEditMember, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchEditMember.guildId;
                }
                if ((i & 2) != 0) {
                    j2 = launchEditMember.userId;
                }
                return launchEditMember.copy(j, j2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getUserId() {
                return this.userId;
            }

            public final LaunchEditMember copy(long guildId, long userId) {
                return new LaunchEditMember(guildId, userId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchEditMember)) {
                    return false;
                }
                LaunchEditMember launchEditMember = (LaunchEditMember) other;
                return this.guildId == launchEditMember.guildId && this.userId == launchEditMember.userId;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final long getUserId() {
                return this.userId;
            }

            public int hashCode() {
                return b.a(this.userId) + (b.a(this.guildId) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("LaunchEditMember(guildId=");
                sbU.append(this.guildId);
                sbU.append(", userId=");
                return outline.C(sbU, this.userId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final /* data */ class LaunchEnableCommunication extends Event {
            private final long guildId;
            private final long userId;

            public LaunchEnableCommunication(long j, long j2) {
                super(null);
                this.userId = j;
                this.guildId = j2;
            }

            public static /* synthetic */ LaunchEnableCommunication copy$default(LaunchEnableCommunication launchEnableCommunication, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchEnableCommunication.userId;
                }
                if ((i & 2) != 0) {
                    j2 = launchEnableCommunication.guildId;
                }
                return launchEnableCommunication.copy(j, j2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getUserId() {
                return this.userId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final LaunchEnableCommunication copy(long userId, long guildId) {
                return new LaunchEnableCommunication(userId, guildId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchEnableCommunication)) {
                    return false;
                }
                LaunchEnableCommunication launchEnableCommunication = (LaunchEnableCommunication) other;
                return this.userId == launchEnableCommunication.userId && this.guildId == launchEnableCommunication.guildId;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final long getUserId() {
                return this.userId;
            }

            public int hashCode() {
                return b.a(this.guildId) + (b.a(this.userId) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("LaunchEnableCommunication(userId=");
                sbU.append(this.userId);
                sbU.append(", guildId=");
                return outline.C(sbU, this.guildId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final /* data */ class LaunchKickUser extends Event {
            private final long guildId;
            private final long userId;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LaunchKickUser(String str, long j, long j2) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "username");
                this.username = str;
                this.guildId = j;
                this.userId = j2;
            }

            public static /* synthetic */ LaunchKickUser copy$default(LaunchKickUser launchKickUser, String str, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = launchKickUser.username;
                }
                if ((i & 2) != 0) {
                    j = launchKickUser.guildId;
                }
                long j3 = j;
                if ((i & 4) != 0) {
                    j2 = launchKickUser.userId;
                }
                return launchKickUser.copy(str, j3, j2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUsername() {
                return this.username;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final long getUserId() {
                return this.userId;
            }

            public final LaunchKickUser copy(String username, long guildId, long userId) {
                Intrinsics3.checkNotNullParameter(username, "username");
                return new LaunchKickUser(username, guildId, userId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchKickUser)) {
                    return false;
                }
                LaunchKickUser launchKickUser = (LaunchKickUser) other;
                return Intrinsics3.areEqual(this.username, launchKickUser.username) && this.guildId == launchKickUser.guildId && this.userId == launchKickUser.userId;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final long getUserId() {
                return this.userId;
            }

            public final String getUsername() {
                return this.username;
            }

            public int hashCode() {
                String str = this.username;
                return b.a(this.userId) + ((b.a(this.guildId) + ((str != null ? str.hashCode() : 0) * 31)) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("LaunchKickUser(username=");
                sbU.append(this.username);
                sbU.append(", guildId=");
                sbU.append(this.guildId);
                sbU.append(", userId=");
                return outline.C(sbU, this.userId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final /* data */ class LaunchMoveUser extends Event {
            private final long guildId;

            public LaunchMoveUser(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ LaunchMoveUser copy$default(LaunchMoveUser launchMoveUser, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchMoveUser.guildId;
                }
                return launchMoveUser.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final LaunchMoveUser copy(long guildId) {
                return new LaunchMoveUser(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LaunchMoveUser) && this.guildId == ((LaunchMoveUser) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return b.a(this.guildId);
            }

            public String toString() {
                return outline.C(outline.U("LaunchMoveUser(guildId="), this.guildId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final /* data */ class LaunchSpectate extends Event {
            private final ModelApplicationStream stream;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LaunchSpectate(ModelApplicationStream modelApplicationStream) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelApplicationStream, "stream");
                this.stream = modelApplicationStream;
            }

            public static /* synthetic */ LaunchSpectate copy$default(LaunchSpectate launchSpectate, ModelApplicationStream modelApplicationStream, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelApplicationStream = launchSpectate.stream;
                }
                return launchSpectate.copy(modelApplicationStream);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelApplicationStream getStream() {
                return this.stream;
            }

            public final LaunchSpectate copy(ModelApplicationStream stream) {
                Intrinsics3.checkNotNullParameter(stream, "stream");
                return new LaunchSpectate(stream);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LaunchSpectate) && Intrinsics3.areEqual(this.stream, ((LaunchSpectate) other).stream);
                }
                return true;
            }

            public final ModelApplicationStream getStream() {
                return this.stream;
            }

            public int hashCode() {
                ModelApplicationStream modelApplicationStream = this.stream;
                if (modelApplicationStream != null) {
                    return modelApplicationStream.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("LaunchSpectate(stream=");
                sbU.append(this.stream);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final /* data */ class LaunchVideoCall extends Event {
            private final long channelId;

            public LaunchVideoCall(long j) {
                super(null);
                this.channelId = j;
            }

            public static /* synthetic */ LaunchVideoCall copy$default(LaunchVideoCall launchVideoCall, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchVideoCall.channelId;
                }
                return launchVideoCall.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            public final LaunchVideoCall copy(long channelId) {
                return new LaunchVideoCall(channelId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LaunchVideoCall) && this.channelId == ((LaunchVideoCall) other).channelId;
                }
                return true;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public int hashCode() {
                return b.a(this.channelId);
            }

            public String toString() {
                return outline.C(outline.U("LaunchVideoCall(channelId="), this.channelId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final /* data */ class LaunchVoiceCall extends Event {
            private final long channelId;

            public LaunchVoiceCall(long j) {
                super(null);
                this.channelId = j;
            }

            public static /* synthetic */ LaunchVoiceCall copy$default(LaunchVoiceCall launchVoiceCall, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchVoiceCall.channelId;
                }
                return launchVoiceCall.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            public final LaunchVoiceCall copy(long channelId) {
                return new LaunchVoiceCall(channelId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LaunchVoiceCall) && this.channelId == ((LaunchVoiceCall) other).channelId;
                }
                return true;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public int hashCode() {
                return b.a(this.channelId);
            }

            public String toString() {
                return outline.C(outline.U("LaunchVoiceCall(channelId="), this.channelId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final /* data */ class RequestPermissionsForSpectateStream extends Event {
            private final ModelApplicationStream stream;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RequestPermissionsForSpectateStream(ModelApplicationStream modelApplicationStream) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelApplicationStream, "stream");
                this.stream = modelApplicationStream;
            }

            public static /* synthetic */ RequestPermissionsForSpectateStream copy$default(RequestPermissionsForSpectateStream requestPermissionsForSpectateStream, ModelApplicationStream modelApplicationStream, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelApplicationStream = requestPermissionsForSpectateStream.stream;
                }
                return requestPermissionsForSpectateStream.copy(modelApplicationStream);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelApplicationStream getStream() {
                return this.stream;
            }

            public final RequestPermissionsForSpectateStream copy(ModelApplicationStream stream) {
                Intrinsics3.checkNotNullParameter(stream, "stream");
                return new RequestPermissionsForSpectateStream(stream);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof RequestPermissionsForSpectateStream) && Intrinsics3.areEqual(this.stream, ((RequestPermissionsForSpectateStream) other).stream);
                }
                return true;
            }

            public final ModelApplicationStream getStream() {
                return this.stream;
            }

            public int hashCode() {
                ModelApplicationStream modelApplicationStream = this.stream;
                if (modelApplicationStream != null) {
                    return modelApplicationStream.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("RequestPermissionsForSpectateStream(stream=");
                sbU.append(this.stream);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final /* data */ class ShowFriendRequestErrorToast extends Event {
            private final int abortCode;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowFriendRequestErrorToast(int i, String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "username");
                this.abortCode = i;
                this.username = str;
            }

            public static /* synthetic */ ShowFriendRequestErrorToast copy$default(ShowFriendRequestErrorToast showFriendRequestErrorToast, int i, String str, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showFriendRequestErrorToast.abortCode;
                }
                if ((i2 & 2) != 0) {
                    str = showFriendRequestErrorToast.username;
                }
                return showFriendRequestErrorToast.copy(i, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getAbortCode() {
                return this.abortCode;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getUsername() {
                return this.username;
            }

            public final ShowFriendRequestErrorToast copy(int abortCode, String username) {
                Intrinsics3.checkNotNullParameter(username, "username");
                return new ShowFriendRequestErrorToast(abortCode, username);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowFriendRequestErrorToast)) {
                    return false;
                }
                ShowFriendRequestErrorToast showFriendRequestErrorToast = (ShowFriendRequestErrorToast) other;
                return this.abortCode == showFriendRequestErrorToast.abortCode && Intrinsics3.areEqual(this.username, showFriendRequestErrorToast.username);
            }

            public final int getAbortCode() {
                return this.abortCode;
            }

            public final String getUsername() {
                return this.username;
            }

            public int hashCode() {
                int i = this.abortCode * 31;
                String str = this.username;
                return i + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ShowFriendRequestErrorToast(abortCode=");
                sbU.append(this.abortCode);
                sbU.append(", username=");
                return outline.J(sbU, this.username, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final /* data */ class ShowToast extends Event {
            private final int stringRes;

            public ShowToast(int i) {
                super(null);
                this.stringRes = i;
            }

            public static /* synthetic */ ShowToast copy$default(ShowToast showToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showToast.stringRes;
                }
                return showToast.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getStringRes() {
                return this.stringRes;
            }

            public final ShowToast copy(int stringRes) {
                return new ShowToast(stringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowToast) && this.stringRes == ((ShowToast) other).stringRes;
                }
                return true;
            }

            public final int getStringRes() {
                return this.stringRes;
            }

            public int hashCode() {
                return this.stringRes;
            }

            public String toString() {
                return outline.B(outline.U("ShowToast(stringRes="), this.stringRes, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final class UserNotFound extends Event {
            public static final UserNotFound INSTANCE = new UserNotFound();

            private UserNotFound() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final boolean canDisableCommunication;
        private final Channel channel;
        private final Map<Long, GuildMember> computedMembers;
        private final Map<Long, VoiceState> currentChannelVoiceStates;
        private final Guild guild;
        private final Map<Long, GuildRole> guildRoles;
        private final MeUser me;
        private final boolean muted;
        private final Map<Long, VoiceState> mySelectedVoiceChannelVoiceStates;
        private final StageRoles myStageRoles;
        private final float outputVolume;
        private final Long permissions;
        private final ModelRichPresence richPresence;
        private final boolean selfDeafened;
        private final boolean selfMuted;
        private final Channel stageChannel;
        private final StreamContext streamContext;
        private final User user;
        private final StoreUserNotes.UserNoteState userNoteFetchState;
        private final UserProfile userProfile;
        private final Integer userRelationshipType;
        private final StageRequestToSpeakState userRequestToSpeakState;
        private final StageRoles userStageRoles;

        private StoreState(User user, MeUser meUser, Channel channel, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, VoiceState> map3, Map<Long, VoiceState> map4, boolean z2, boolean z3, boolean z4, float f, ModelRichPresence modelRichPresence, Guild guild, Long l, StreamContext streamContext, UserProfile userProfile, Integer num, StoreUserNotes.UserNoteState userNoteState, Channel channel2, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, StageRoles stageRoles2, boolean z5) {
            this.user = user;
            this.me = meUser;
            this.channel = channel;
            this.computedMembers = map;
            this.guildRoles = map2;
            this.mySelectedVoiceChannelVoiceStates = map3;
            this.currentChannelVoiceStates = map4;
            this.muted = z2;
            this.selfMuted = z3;
            this.selfDeafened = z4;
            this.outputVolume = f;
            this.richPresence = modelRichPresence;
            this.guild = guild;
            this.permissions = l;
            this.streamContext = streamContext;
            this.userProfile = userProfile;
            this.userRelationshipType = num;
            this.userNoteFetchState = userNoteState;
            this.stageChannel = channel2;
            this.userStageRoles = stageRoles;
            this.userRequestToSpeakState = stageRequestToSpeakState;
            this.myStageRoles = stageRoles2;
            this.canDisableCommunication = z5;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final boolean getSelfDeafened() {
            return this.selfDeafened;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final float getOutputVolume() {
            return this.outputVolume;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final ModelRichPresence getRichPresence() {
            return this.richPresence;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Long getPermissions() {
            return this.permissions;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final StreamContext getStreamContext() {
            return this.streamContext;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final Integer getUserRelationshipType() {
            return this.userRelationshipType;
        }

        /* JADX INFO: renamed from: component18, reason: from getter */
        public final StoreUserNotes.UserNoteState getUserNoteFetchState() {
            return this.userNoteFetchState;
        }

        /* JADX INFO: renamed from: component19, reason: from getter */
        public final Channel getStageChannel() {
            return this.stageChannel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* JADX INFO: renamed from: component20-twRsX-0, reason: not valid java name and from getter */
        public final StageRoles getUserStageRoles() {
            return this.userStageRoles;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final StageRequestToSpeakState getUserRequestToSpeakState() {
            return this.userRequestToSpeakState;
        }

        /* JADX INFO: renamed from: component22-twRsX-0, reason: not valid java name and from getter */
        public final StageRoles getMyStageRoles() {
            return this.myStageRoles;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final boolean getCanDisableCommunication() {
            return this.canDisableCommunication;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, GuildMember> component4() {
            return this.computedMembers;
        }

        public final Map<Long, GuildRole> component5() {
            return this.guildRoles;
        }

        public final Map<Long, VoiceState> component6() {
            return this.mySelectedVoiceChannelVoiceStates;
        }

        public final Map<Long, VoiceState> component7() {
            return this.currentChannelVoiceStates;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getMuted() {
            return this.muted;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getSelfMuted() {
            return this.selfMuted;
        }

        /* JADX INFO: renamed from: copy-U9gTzXU, reason: not valid java name */
        public final StoreState m58copyU9gTzXU(User user, MeUser me2, Channel channel, Map<Long, GuildMember> computedMembers, Map<Long, GuildRole> guildRoles, Map<Long, VoiceState> mySelectedVoiceChannelVoiceStates, Map<Long, VoiceState> currentChannelVoiceStates, boolean muted, boolean selfMuted, boolean selfDeafened, float outputVolume, ModelRichPresence richPresence, Guild guild, Long permissions, StreamContext streamContext, UserProfile userProfile, Integer userRelationshipType, StoreUserNotes.UserNoteState userNoteFetchState, Channel stageChannel, StageRoles userStageRoles, StageRequestToSpeakState userRequestToSpeakState, StageRoles myStageRoles, boolean canDisableCommunication) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(computedMembers, "computedMembers");
            Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
            Intrinsics3.checkNotNullParameter(mySelectedVoiceChannelVoiceStates, "mySelectedVoiceChannelVoiceStates");
            Intrinsics3.checkNotNullParameter(currentChannelVoiceStates, "currentChannelVoiceStates");
            Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
            Intrinsics3.checkNotNullParameter(userNoteFetchState, "userNoteFetchState");
            Intrinsics3.checkNotNullParameter(userRequestToSpeakState, "userRequestToSpeakState");
            return new StoreState(user, me2, channel, computedMembers, guildRoles, mySelectedVoiceChannelVoiceStates, currentChannelVoiceStates, muted, selfMuted, selfDeafened, outputVolume, richPresence, guild, permissions, streamContext, userProfile, userRelationshipType, userNoteFetchState, stageChannel, userStageRoles, userRequestToSpeakState, myStageRoles, canDisableCommunication);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.user, storeState.user) && Intrinsics3.areEqual(this.me, storeState.me) && Intrinsics3.areEqual(this.channel, storeState.channel) && Intrinsics3.areEqual(this.computedMembers, storeState.computedMembers) && Intrinsics3.areEqual(this.guildRoles, storeState.guildRoles) && Intrinsics3.areEqual(this.mySelectedVoiceChannelVoiceStates, storeState.mySelectedVoiceChannelVoiceStates) && Intrinsics3.areEqual(this.currentChannelVoiceStates, storeState.currentChannelVoiceStates) && this.muted == storeState.muted && this.selfMuted == storeState.selfMuted && this.selfDeafened == storeState.selfDeafened && Float.compare(this.outputVolume, storeState.outputVolume) == 0 && Intrinsics3.areEqual(this.richPresence, storeState.richPresence) && Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.permissions, storeState.permissions) && Intrinsics3.areEqual(this.streamContext, storeState.streamContext) && Intrinsics3.areEqual(this.userProfile, storeState.userProfile) && Intrinsics3.areEqual(this.userRelationshipType, storeState.userRelationshipType) && Intrinsics3.areEqual(this.userNoteFetchState, storeState.userNoteFetchState) && Intrinsics3.areEqual(this.stageChannel, storeState.stageChannel) && Intrinsics3.areEqual(this.userStageRoles, storeState.userStageRoles) && Intrinsics3.areEqual(this.userRequestToSpeakState, storeState.userRequestToSpeakState) && Intrinsics3.areEqual(this.myStageRoles, storeState.myStageRoles) && this.canDisableCommunication == storeState.canDisableCommunication;
        }

        public final boolean getCanDisableCommunication() {
            return this.canDisableCommunication;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, GuildMember> getComputedMembers() {
            return this.computedMembers;
        }

        public final Map<Long, VoiceState> getCurrentChannelVoiceStates() {
            return this.currentChannelVoiceStates;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, GuildRole> getGuildRoles() {
            return this.guildRoles;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final boolean getMuted() {
            return this.muted;
        }

        public final Map<Long, VoiceState> getMySelectedVoiceChannelVoiceStates() {
            return this.mySelectedVoiceChannelVoiceStates;
        }

        /* JADX INFO: renamed from: getMyStageRoles-twRsX-0, reason: not valid java name */
        public final StageRoles m59getMyStageRolestwRsX0() {
            return this.myStageRoles;
        }

        public final float getOutputVolume() {
            return this.outputVolume;
        }

        public final Long getPermissions() {
            return this.permissions;
        }

        public final ModelRichPresence getRichPresence() {
            return this.richPresence;
        }

        public final boolean getSelfDeafened() {
            return this.selfDeafened;
        }

        public final boolean getSelfMuted() {
            return this.selfMuted;
        }

        public final Channel getStageChannel() {
            return this.stageChannel;
        }

        public final StreamContext getStreamContext() {
            return this.streamContext;
        }

        public final User getUser() {
            return this.user;
        }

        public final StoreUserNotes.UserNoteState getUserNoteFetchState() {
            return this.userNoteFetchState;
        }

        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        public final Integer getUserRelationshipType() {
            return this.userRelationshipType;
        }

        public final StageRequestToSpeakState getUserRequestToSpeakState() {
            return this.userRequestToSpeakState;
        }

        /* JADX INFO: renamed from: getUserStageRoles-twRsX-0, reason: not valid java name */
        public final StageRoles m60getUserStageRolestwRsX0() {
            return this.userStageRoles;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v16, types: [int] */
        /* JADX WARN: Type inference failed for: r2v19, types: [int] */
        /* JADX WARN: Type inference failed for: r2v21, types: [int] */
        /* JADX WARN: Type inference failed for: r2v23, types: [int] */
        /* JADX WARN: Type inference failed for: r2v50, types: [int] */
        /* JADX WARN: Type inference failed for: r2v51 */
        /* JADX WARN: Type inference failed for: r2v52 */
        /* JADX WARN: Type inference failed for: r2v53 */
        /* JADX WARN: Type inference failed for: r2v60 */
        /* JADX WARN: Type inference failed for: r2v61 */
        /* JADX WARN: Type inference failed for: r2v62 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            MeUser meUser = this.me;
            int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
            Map<Long, GuildMember> map = this.computedMembers;
            int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map2 = this.guildRoles;
            int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, VoiceState> map3 = this.mySelectedVoiceChannelVoiceStates;
            int iHashCode6 = (iHashCode5 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, VoiceState> map4 = this.currentChannelVoiceStates;
            int iHashCode7 = (iHashCode6 + (map4 != null ? map4.hashCode() : 0)) * 31;
            boolean z2 = this.muted;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode7 + r2) * 31;
            boolean z3 = this.selfMuted;
            ?? r3 = z3;
            if (z3) {
                r3 = 1;
            }
            int i2 = (i + r3) * 31;
            boolean z4 = this.selfDeafened;
            ?? r4 = z4;
            if (z4) {
                r4 = 1;
            }
            int iFloatToIntBits = (Float.floatToIntBits(this.outputVolume) + ((i2 + r4) * 31)) * 31;
            ModelRichPresence modelRichPresence = this.richPresence;
            int iHashCode8 = (iFloatToIntBits + (modelRichPresence != null ? modelRichPresence.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode9 = (iHashCode8 + (guild != null ? guild.hashCode() : 0)) * 31;
            Long l = this.permissions;
            int iHashCode10 = (iHashCode9 + (l != null ? l.hashCode() : 0)) * 31;
            StreamContext streamContext = this.streamContext;
            int iHashCode11 = (iHashCode10 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
            UserProfile userProfile = this.userProfile;
            int iHashCode12 = (iHashCode11 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
            Integer num = this.userRelationshipType;
            int iHashCode13 = (iHashCode12 + (num != null ? num.hashCode() : 0)) * 31;
            StoreUserNotes.UserNoteState userNoteState = this.userNoteFetchState;
            int iHashCode14 = (iHashCode13 + (userNoteState != null ? userNoteState.hashCode() : 0)) * 31;
            Channel channel2 = this.stageChannel;
            int iHashCode15 = (iHashCode14 + (channel2 != null ? channel2.hashCode() : 0)) * 31;
            StageRoles stageRoles = this.userStageRoles;
            int iHashCode16 = (iHashCode15 + (stageRoles != null ? stageRoles.hashCode() : 0)) * 31;
            StageRequestToSpeakState stageRequestToSpeakState = this.userRequestToSpeakState;
            int iHashCode17 = (iHashCode16 + (stageRequestToSpeakState != null ? stageRequestToSpeakState.hashCode() : 0)) * 31;
            StageRoles stageRoles2 = this.myStageRoles;
            int iHashCode18 = (iHashCode17 + (stageRoles2 != null ? stageRoles2.hashCode() : 0)) * 31;
            boolean z5 = this.canDisableCommunication;
            return iHashCode18 + (z5 ? 1 : z5);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(user=");
            sbU.append(this.user);
            sbU.append(", me=");
            sbU.append(this.me);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", computedMembers=");
            sbU.append(this.computedMembers);
            sbU.append(", guildRoles=");
            sbU.append(this.guildRoles);
            sbU.append(", mySelectedVoiceChannelVoiceStates=");
            sbU.append(this.mySelectedVoiceChannelVoiceStates);
            sbU.append(", currentChannelVoiceStates=");
            sbU.append(this.currentChannelVoiceStates);
            sbU.append(", muted=");
            sbU.append(this.muted);
            sbU.append(", selfMuted=");
            sbU.append(this.selfMuted);
            sbU.append(", selfDeafened=");
            sbU.append(this.selfDeafened);
            sbU.append(", outputVolume=");
            sbU.append(this.outputVolume);
            sbU.append(", richPresence=");
            sbU.append(this.richPresence);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", permissions=");
            sbU.append(this.permissions);
            sbU.append(", streamContext=");
            sbU.append(this.streamContext);
            sbU.append(", userProfile=");
            sbU.append(this.userProfile);
            sbU.append(", userRelationshipType=");
            sbU.append(this.userRelationshipType);
            sbU.append(", userNoteFetchState=");
            sbU.append(this.userNoteFetchState);
            sbU.append(", stageChannel=");
            sbU.append(this.stageChannel);
            sbU.append(", userStageRoles=");
            sbU.append(this.userStageRoles);
            sbU.append(", userRequestToSpeakState=");
            sbU.append(this.userRequestToSpeakState);
            sbU.append(", myStageRoles=");
            sbU.append(this.myStageRoles);
            sbU.append(", canDisableCommunication=");
            return outline.O(sbU, this.canDisableCommunication, ")");
        }

        public /* synthetic */ StoreState(User user, MeUser meUser, Channel channel, Map map, Map map2, Map map3, Map map4, boolean z2, boolean z3, boolean z4, float f, ModelRichPresence modelRichPresence, Guild guild, Long l, StreamContext streamContext, UserProfile userProfile, Integer num, StoreUserNotes.UserNoteState userNoteState, Channel channel2, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, StageRoles stageRoles2, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
            this(user, meUser, channel, map, map2, map3, map4, z2, z3, z4, f, modelRichPresence, guild, l, streamContext, userProfile, num, userNoteState, channel2, stageRoles, stageRequestToSpeakState, stageRoles2, z5);
        }
    }

    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final UserProfileAdminView.ViewState adminViewState;
            private final List<Node<MessageRenderContext>> bioAst;
            private final Channel channel;
            private final VoiceState channelVoiceState;
            private final UserProfileConnectionsView.ViewState connectionsViewState;
            private final Long currentGuildId;
            private final String guildIcon;
            private final String guildIconURL;
            private final Long guildId;
            private final GuildMember guildMember;
            private final String guildName;
            private final String guildSectionHeaderText;
            private final boolean hasGuildMemberBio;
            private final boolean hasPremiumCustomization;
            private final boolean isMe;
            private final boolean profileLoaded;
            private final ModelRichPresence richPresence;
            private final List<GuildRole> roleItems;
            private final boolean showVoiceSettings;
            private final UserProfileStageActionsView.ViewState stageViewState;
            private final StreamContext streamContext;
            private final User user;
            private final boolean userInSameVoiceChannel;
            private final String userNote;
            private final StoreUserNotes.UserNoteState userNoteFetchState;
            private final UserProfile userProfile;
            private final int userRelationshipType;
            private final UserProfileVoiceSettingsView.ViewState voiceSettingsViewState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(User user, boolean z2, boolean z3, UserProfileVoiceSettingsView.ViewState viewState, VoiceState voiceState, ModelRichPresence modelRichPresence, String str, List<GuildRole> list, UserProfileAdminView.ViewState viewState2, UserProfileStageActionsView.ViewState viewState3, Channel channel, StreamContext streamContext, String str2, String str3, int i, UserProfileConnectionsView.ViewState viewState4, StoreUserNotes.UserNoteState userNoteState, String str4, boolean z4, List<Node<MessageRenderContext>> list2, boolean z5, Long l, GuildMember guildMember, UserProfile userProfile) {
                String avatar;
                super(0 == true ? 1 : 0);
                Intrinsics3.checkNotNullParameter(user, "user");
                Intrinsics3.checkNotNullParameter(viewState, "voiceSettingsViewState");
                Intrinsics3.checkNotNullParameter(list, "roleItems");
                Intrinsics3.checkNotNullParameter(viewState3, "stageViewState");
                Intrinsics3.checkNotNullParameter(viewState4, "connectionsViewState");
                Intrinsics3.checkNotNullParameter(userNoteState, "userNoteFetchState");
                this.user = user;
                this.isMe = z2;
                this.showVoiceSettings = z3;
                this.voiceSettingsViewState = viewState;
                this.channelVoiceState = voiceState;
                this.richPresence = modelRichPresence;
                this.guildSectionHeaderText = str;
                this.roleItems = list;
                this.adminViewState = viewState2;
                this.stageViewState = viewState3;
                this.channel = channel;
                this.streamContext = streamContext;
                this.guildName = str2;
                this.guildIcon = str3;
                this.userRelationshipType = i;
                this.connectionsViewState = viewState4;
                this.userNoteFetchState = userNoteState;
                this.userNote = str4;
                this.userInSameVoiceChannel = z4;
                this.bioAst = list2;
                this.profileLoaded = z5;
                this.guildId = l;
                this.guildMember = guildMember;
                this.userProfile = userProfile;
                this.hasPremiumCustomization = user.getBanner() != null || ((avatar = user.getAvatar()) != null && IconUtils.INSTANCE.isImageHashAnimated(avatar));
                this.currentGuildId = channel != null ? Long.valueOf(channel.getGuildId()) : l;
                String bio = guildMember != null ? guildMember.getBio() : null;
                this.hasGuildMemberBio = !(bio == null || bio.length() == 0);
                this.guildIconURL = str3 != null ? IconUtils.getForGuild$default(l, str3, null, false, Integer.valueOf(DimenUtils.dpToPixels(16)), 4, null) : null;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, User user, boolean z2, boolean z3, UserProfileVoiceSettingsView.ViewState viewState, VoiceState voiceState, ModelRichPresence modelRichPresence, String str, List list, UserProfileAdminView.ViewState viewState2, UserProfileStageActionsView.ViewState viewState3, Channel channel, StreamContext streamContext, String str2, String str3, int i, UserProfileConnectionsView.ViewState viewState4, StoreUserNotes.UserNoteState userNoteState, String str4, boolean z4, List list2, boolean z5, Long l, GuildMember guildMember, UserProfile userProfile, int i2, Object obj) {
                return loaded.copy((i2 & 1) != 0 ? loaded.user : user, (i2 & 2) != 0 ? loaded.isMe : z2, (i2 & 4) != 0 ? loaded.showVoiceSettings : z3, (i2 & 8) != 0 ? loaded.voiceSettingsViewState : viewState, (i2 & 16) != 0 ? loaded.channelVoiceState : voiceState, (i2 & 32) != 0 ? loaded.richPresence : modelRichPresence, (i2 & 64) != 0 ? loaded.guildSectionHeaderText : str, (i2 & 128) != 0 ? loaded.roleItems : list, (i2 & 256) != 0 ? loaded.adminViewState : viewState2, (i2 & 512) != 0 ? loaded.stageViewState : viewState3, (i2 & 1024) != 0 ? loaded.channel : channel, (i2 & 2048) != 0 ? loaded.streamContext : streamContext, (i2 & 4096) != 0 ? loaded.guildName : str2, (i2 & 8192) != 0 ? loaded.guildIcon : str3, (i2 & 16384) != 0 ? loaded.userRelationshipType : i, (i2 & 32768) != 0 ? loaded.connectionsViewState : viewState4, (i2 & 65536) != 0 ? loaded.userNoteFetchState : userNoteState, (i2 & 131072) != 0 ? loaded.userNote : str4, (i2 & 262144) != 0 ? loaded.userInSameVoiceChannel : z4, (i2 & 524288) != 0 ? loaded.bioAst : list2, (i2 & 1048576) != 0 ? loaded.profileLoaded : z5, (i2 & 2097152) != 0 ? loaded.guildId : l, (i2 & 4194304) != 0 ? loaded.guildMember : guildMember, (i2 & 8388608) != 0 ? loaded.userProfile : userProfile);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final User getUser() {
                return this.user;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final UserProfileStageActionsView.ViewState getStageViewState() {
                return this.stageViewState;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* JADX INFO: renamed from: component12, reason: from getter */
            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            /* JADX INFO: renamed from: component13, reason: from getter */
            public final String getGuildName() {
                return this.guildName;
            }

            /* JADX INFO: renamed from: component14, reason: from getter */
            public final String getGuildIcon() {
                return this.guildIcon;
            }

            /* JADX INFO: renamed from: component15, reason: from getter */
            public final int getUserRelationshipType() {
                return this.userRelationshipType;
            }

            /* JADX INFO: renamed from: component16, reason: from getter */
            public final UserProfileConnectionsView.ViewState getConnectionsViewState() {
                return this.connectionsViewState;
            }

            /* JADX INFO: renamed from: component17, reason: from getter */
            public final StoreUserNotes.UserNoteState getUserNoteFetchState() {
                return this.userNoteFetchState;
            }

            /* JADX INFO: renamed from: component18, reason: from getter */
            public final String getUserNote() {
                return this.userNote;
            }

            /* JADX INFO: renamed from: component19, reason: from getter */
            public final boolean getUserInSameVoiceChannel() {
                return this.userInSameVoiceChannel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsMe() {
                return this.isMe;
            }

            public final List<Node<MessageRenderContext>> component20() {
                return this.bioAst;
            }

            /* JADX INFO: renamed from: component21, reason: from getter */
            public final boolean getProfileLoaded() {
                return this.profileLoaded;
            }

            /* JADX INFO: renamed from: component22, reason: from getter */
            public final Long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component23, reason: from getter */
            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            /* JADX INFO: renamed from: component24, reason: from getter */
            public final UserProfile getUserProfile() {
                return this.userProfile;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getShowVoiceSettings() {
                return this.showVoiceSettings;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final UserProfileVoiceSettingsView.ViewState getVoiceSettingsViewState() {
                return this.voiceSettingsViewState;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final VoiceState getChannelVoiceState() {
                return this.channelVoiceState;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final ModelRichPresence getRichPresence() {
                return this.richPresence;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final String getGuildSectionHeaderText() {
                return this.guildSectionHeaderText;
            }

            public final List<GuildRole> component8() {
                return this.roleItems;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final UserProfileAdminView.ViewState getAdminViewState() {
                return this.adminViewState;
            }

            public final Loaded copy(User user, boolean isMe, boolean showVoiceSettings, UserProfileVoiceSettingsView.ViewState voiceSettingsViewState, VoiceState channelVoiceState, ModelRichPresence richPresence, String guildSectionHeaderText, List<GuildRole> roleItems, UserProfileAdminView.ViewState adminViewState, UserProfileStageActionsView.ViewState stageViewState, Channel channel, StreamContext streamContext, String guildName, String guildIcon, int userRelationshipType, UserProfileConnectionsView.ViewState connectionsViewState, StoreUserNotes.UserNoteState userNoteFetchState, String userNote, boolean userInSameVoiceChannel, List<Node<MessageRenderContext>> bioAst, boolean profileLoaded, Long guildId, GuildMember guildMember, UserProfile userProfile) {
                Intrinsics3.checkNotNullParameter(user, "user");
                Intrinsics3.checkNotNullParameter(voiceSettingsViewState, "voiceSettingsViewState");
                Intrinsics3.checkNotNullParameter(roleItems, "roleItems");
                Intrinsics3.checkNotNullParameter(stageViewState, "stageViewState");
                Intrinsics3.checkNotNullParameter(connectionsViewState, "connectionsViewState");
                Intrinsics3.checkNotNullParameter(userNoteFetchState, "userNoteFetchState");
                return new Loaded(user, isMe, showVoiceSettings, voiceSettingsViewState, channelVoiceState, richPresence, guildSectionHeaderText, roleItems, adminViewState, stageViewState, channel, streamContext, guildName, guildIcon, userRelationshipType, connectionsViewState, userNoteFetchState, userNote, userInSameVoiceChannel, bioAst, profileLoaded, guildId, guildMember, userProfile);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.user, loaded.user) && this.isMe == loaded.isMe && this.showVoiceSettings == loaded.showVoiceSettings && Intrinsics3.areEqual(this.voiceSettingsViewState, loaded.voiceSettingsViewState) && Intrinsics3.areEqual(this.channelVoiceState, loaded.channelVoiceState) && Intrinsics3.areEqual(this.richPresence, loaded.richPresence) && Intrinsics3.areEqual(this.guildSectionHeaderText, loaded.guildSectionHeaderText) && Intrinsics3.areEqual(this.roleItems, loaded.roleItems) && Intrinsics3.areEqual(this.adminViewState, loaded.adminViewState) && Intrinsics3.areEqual(this.stageViewState, loaded.stageViewState) && Intrinsics3.areEqual(this.channel, loaded.channel) && Intrinsics3.areEqual(this.streamContext, loaded.streamContext) && Intrinsics3.areEqual(this.guildName, loaded.guildName) && Intrinsics3.areEqual(this.guildIcon, loaded.guildIcon) && this.userRelationshipType == loaded.userRelationshipType && Intrinsics3.areEqual(this.connectionsViewState, loaded.connectionsViewState) && Intrinsics3.areEqual(this.userNoteFetchState, loaded.userNoteFetchState) && Intrinsics3.areEqual(this.userNote, loaded.userNote) && this.userInSameVoiceChannel == loaded.userInSameVoiceChannel && Intrinsics3.areEqual(this.bioAst, loaded.bioAst) && this.profileLoaded == loaded.profileLoaded && Intrinsics3.areEqual(this.guildId, loaded.guildId) && Intrinsics3.areEqual(this.guildMember, loaded.guildMember) && Intrinsics3.areEqual(this.userProfile, loaded.userProfile);
            }

            public final UserProfileAdminView.ViewState getAdminViewState() {
                return this.adminViewState;
            }

            public final List<Node<MessageRenderContext>> getBioAst() {
                return this.bioAst;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final VoiceState getChannelVoiceState() {
                return this.channelVoiceState;
            }

            public final UserProfileConnectionsView.ViewState getConnectionsViewState() {
                return this.connectionsViewState;
            }

            public final Long getCurrentGuildId() {
                return this.currentGuildId;
            }

            public final String getGuildIcon() {
                return this.guildIcon;
            }

            public final String getGuildIconURL() {
                return this.guildIconURL;
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            public final String getGuildName() {
                return this.guildName;
            }

            public final String getGuildSectionHeaderText() {
                return this.guildSectionHeaderText;
            }

            public final boolean getHasGuildMemberBio() {
                return this.hasGuildMemberBio;
            }

            public final boolean getHasPremiumCustomization() {
                return this.hasPremiumCustomization;
            }

            public final Presence getPresence() {
                ModelRichPresence modelRichPresence = this.richPresence;
                if (modelRichPresence != null) {
                    return modelRichPresence.getPresence();
                }
                return null;
            }

            public final boolean getProfileLoaded() {
                return this.profileLoaded;
            }

            public final ModelRichPresence getRichPresence() {
                return this.richPresence;
            }

            public final List<GuildRole> getRoleItems() {
                return this.roleItems;
            }

            public final boolean getShowVoiceSettings() {
                return this.showVoiceSettings;
            }

            public final UserProfileStageActionsView.ViewState getStageViewState() {
                return this.stageViewState;
            }

            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            public final User getUser() {
                return this.user;
            }

            public final boolean getUserInSameVoiceChannel() {
                return this.userInSameVoiceChannel;
            }

            public final String getUserNote() {
                return this.userNote;
            }

            public final StoreUserNotes.UserNoteState getUserNoteFetchState() {
                return this.userNoteFetchState;
            }

            public final UserProfile getUserProfile() {
                return this.userProfile;
            }

            public final int getUserRelationshipType() {
                return this.userRelationshipType;
            }

            public final UserProfileVoiceSettingsView.ViewState getVoiceSettingsViewState() {
                return this.voiceSettingsViewState;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3, types: [int] */
            /* JADX WARN: Type inference failed for: r2v48, types: [int] */
            /* JADX WARN: Type inference failed for: r2v63 */
            /* JADX WARN: Type inference failed for: r2v78 */
            /* JADX WARN: Type inference failed for: r2v79 */
            /* JADX WARN: Type inference failed for: r2v80 */
            /* JADX WARN: Type inference failed for: r2v81 */
            /* JADX WARN: Type inference failed for: r2v82 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                User user = this.user;
                int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                boolean z2 = this.isMe;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode + r2) * 31;
                boolean z3 = this.showVoiceSettings;
                ?? r3 = z3;
                if (z3) {
                    r3 = 1;
                }
                int i2 = (i + r3) * 31;
                UserProfileVoiceSettingsView.ViewState viewState = this.voiceSettingsViewState;
                int iHashCode2 = (i2 + (viewState != null ? viewState.hashCode() : 0)) * 31;
                VoiceState voiceState = this.channelVoiceState;
                int iHashCode3 = (iHashCode2 + (voiceState != null ? voiceState.hashCode() : 0)) * 31;
                ModelRichPresence modelRichPresence = this.richPresence;
                int iHashCode4 = (iHashCode3 + (modelRichPresence != null ? modelRichPresence.hashCode() : 0)) * 31;
                String str = this.guildSectionHeaderText;
                int iHashCode5 = (iHashCode4 + (str != null ? str.hashCode() : 0)) * 31;
                List<GuildRole> list = this.roleItems;
                int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
                UserProfileAdminView.ViewState viewState2 = this.adminViewState;
                int iHashCode7 = (iHashCode6 + (viewState2 != null ? viewState2.hashCode() : 0)) * 31;
                UserProfileStageActionsView.ViewState viewState3 = this.stageViewState;
                int iHashCode8 = (iHashCode7 + (viewState3 != null ? viewState3.hashCode() : 0)) * 31;
                Channel channel = this.channel;
                int iHashCode9 = (iHashCode8 + (channel != null ? channel.hashCode() : 0)) * 31;
                StreamContext streamContext = this.streamContext;
                int iHashCode10 = (iHashCode9 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
                String str2 = this.guildName;
                int iHashCode11 = (iHashCode10 + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.guildIcon;
                int iHashCode12 = (((iHashCode11 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.userRelationshipType) * 31;
                UserProfileConnectionsView.ViewState viewState4 = this.connectionsViewState;
                int iHashCode13 = (iHashCode12 + (viewState4 != null ? viewState4.hashCode() : 0)) * 31;
                StoreUserNotes.UserNoteState userNoteState = this.userNoteFetchState;
                int iHashCode14 = (iHashCode13 + (userNoteState != null ? userNoteState.hashCode() : 0)) * 31;
                String str4 = this.userNote;
                int iHashCode15 = (iHashCode14 + (str4 != null ? str4.hashCode() : 0)) * 31;
                boolean z4 = this.userInSameVoiceChannel;
                ?? r4 = z4;
                if (z4) {
                    r4 = 1;
                }
                int i3 = (iHashCode15 + r4) * 31;
                List<Node<MessageRenderContext>> list2 = this.bioAst;
                int iHashCode16 = (i3 + (list2 != null ? list2.hashCode() : 0)) * 31;
                boolean z5 = this.profileLoaded;
                int i4 = (iHashCode16 + (z5 ? 1 : z5)) * 31;
                Long l = this.guildId;
                int iHashCode17 = (i4 + (l != null ? l.hashCode() : 0)) * 31;
                GuildMember guildMember = this.guildMember;
                int iHashCode18 = (iHashCode17 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
                UserProfile userProfile = this.userProfile;
                return iHashCode18 + (userProfile != null ? userProfile.hashCode() : 0);
            }

            public final boolean isMe() {
                return this.isMe;
            }

            public final boolean shouldShowRoles() {
                Long l = this.currentGuildId;
                return (this.roleItems.isEmpty() ^ true) && (l != null && (l.longValue() > 0L ? 1 : (l.longValue() == 0L ? 0 : -1)) > 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(user=");
                sbU.append(this.user);
                sbU.append(", isMe=");
                sbU.append(this.isMe);
                sbU.append(", showVoiceSettings=");
                sbU.append(this.showVoiceSettings);
                sbU.append(", voiceSettingsViewState=");
                sbU.append(this.voiceSettingsViewState);
                sbU.append(", channelVoiceState=");
                sbU.append(this.channelVoiceState);
                sbU.append(", richPresence=");
                sbU.append(this.richPresence);
                sbU.append(", guildSectionHeaderText=");
                sbU.append(this.guildSectionHeaderText);
                sbU.append(", roleItems=");
                sbU.append(this.roleItems);
                sbU.append(", adminViewState=");
                sbU.append(this.adminViewState);
                sbU.append(", stageViewState=");
                sbU.append(this.stageViewState);
                sbU.append(", channel=");
                sbU.append(this.channel);
                sbU.append(", streamContext=");
                sbU.append(this.streamContext);
                sbU.append(", guildName=");
                sbU.append(this.guildName);
                sbU.append(", guildIcon=");
                sbU.append(this.guildIcon);
                sbU.append(", userRelationshipType=");
                sbU.append(this.userRelationshipType);
                sbU.append(", connectionsViewState=");
                sbU.append(this.connectionsViewState);
                sbU.append(", userNoteFetchState=");
                sbU.append(this.userNoteFetchState);
                sbU.append(", userNote=");
                sbU.append(this.userNote);
                sbU.append(", userInSameVoiceChannel=");
                sbU.append(this.userInSameVoiceChannel);
                sbU.append(", bioAst=");
                sbU.append(this.bioAst);
                sbU.append(", profileLoaded=");
                sbU.append(this.profileLoaded);
                sbU.append(", guildId=");
                sbU.append(this.guildId);
                sbU.append(", guildMember=");
                sbU.append(this.guildMember);
                sbU.append(", userProfile=");
                sbU.append(this.userProfile);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            StoreMediaSettings.SelfMuteFailure.values();
            int[] iArr = new int[1];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreMediaSettings.SelfMuteFailure.CANNOT_USE_VAD.ordinal()] = 1;
            WidgetUserSheet.StreamPreviewClickBehavior.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[WidgetUserSheet.StreamPreviewClickBehavior.TARGET_AND_LAUNCH_SPECTATE.ordinal()] = 1;
            iArr2[WidgetUserSheet.StreamPreviewClickBehavior.TARGET_AND_DISMISS.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$addRelationship$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ int $successMessageStringRes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i) {
            super(1);
            this.$successMessageStringRes = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            WidgetUserSheetViewModel.this.emitShowToastEvent(this.$successMessageStringRes);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$addRelationship$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ int $successMessageStringRes;
        public final /* synthetic */ Integer $type;
        public final /* synthetic */ String $username;

        /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$addRelationship$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$addRelationship$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
            public static final class C03541 extends Lambda implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
                public C03541() {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
                    invoke2(appFragment, captchaPayload);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
                    Intrinsics3.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
                    Intrinsics3.checkNotNullParameter(captchaPayload, "captchaPayload");
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    WidgetUserSheetViewModel.this.addRelationship(anonymousClass2.$type, anonymousClass2.$username, anonymousClass2.$successMessageStringRes, captchaPayload);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (WidgetCaptcha4.isCaptchaError(this.$error)) {
                    WidgetCaptchaBottomSheet.Companion.enqueue$default(WidgetCaptchaBottomSheet.INSTANCE, "Add Friend Captcha", new C03541(), null, CaptchaErrorBody.INSTANCE.createFromError(this.$error), 4, null);
                    return;
                }
                WidgetUserSheetViewModel widgetUserSheetViewModel = WidgetUserSheetViewModel.this;
                Error.Response response = this.$error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                widgetUserSheetViewModel.emitShowFriendRequestAbortToast(response.getCode(), AnonymousClass2.this.$username);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$addRelationship$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
        public static final class C03552 extends Lambda implements Function0<Boolean> {
            public C03552() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                WidgetUserSheetViewModel.this.emitShowToastEvent(R.string.default_failure_to_perform_action_message);
                return false;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Integer num, String str, int i) {
            super(1);
            this.$type = num;
            this.$username = str;
            this.$successMessageStringRes = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            RestAPIAbortMessages.INSTANCE.handleAbortCodeOrDefault(error, new AnonymousClass1(error), new C03552());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$disconnectUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            WidgetUserSheetViewModel.this.emitShowToastEvent(R.string.disconnect_user_success);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$disconnectUser$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetUserSheetViewModel.this.emitShowToastEvent(R.string.default_failure_to_perform_action_message);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$guildDeafenUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
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

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$guildDeafenUser$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetUserSheetViewModel.this.emitShowToastEvent(R.string.default_failure_to_perform_action_message);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$guildMuteUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
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

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$guildMuteUser$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetUserSheetViewModel.this.emitShowToastEvent(R.string.default_failure_to_perform_action_message);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$inviteUserToSpeak$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r30) {
            ViewState viewStateAccess$getViewState$p = WidgetUserSheetViewModel.access$getViewState$p(WidgetUserSheetViewModel.this);
            if (!(viewStateAccess$getViewState$p instanceof ViewState.Loaded)) {
                viewStateAccess$getViewState$p = null;
            }
            ViewState.Loaded loaded = (ViewState.Loaded) viewStateAccess$getViewState$p;
            if (loaded != null) {
                WidgetUserSheetViewModel widgetUserSheetViewModel = WidgetUserSheetViewModel.this;
                UserProfileStageActionsView.ViewState stageViewState = loaded.getStageViewState();
                widgetUserSheetViewModel.updateViewState(ViewState.Loaded.copy$default(loaded, null, false, false, null, null, null, null, null, null, stageViewState.m53copyam1GJgw((Opcodes.LAND & 1) != 0 ? stageViewState.isMe : false, (Opcodes.LAND & 2) != 0 ? stageViewState.channel : null, (Opcodes.LAND & 4) != 0 ? stageViewState.userStageRole : null, (Opcodes.LAND & 8) != 0 ? stageViewState.userRequestToSpeakState : null, (Opcodes.LAND & 16) != 0 ? stageViewState.userInSameVoiceChannel : false, (Opcodes.LAND & 32) != 0 ? stageViewState.canMuteMembers : false, (Opcodes.LAND & 64) != 0 ? stageViewState.isUpdatingSuppressed : false, (Opcodes.LAND & 128) != 0 ? stageViewState.isInvitingToSpeak : false), null, null, null, null, 0, null, null, null, false, null, false, null, null, null, 16776703, null));
                WidgetUserSheetViewModel.this.emitDismissSheetEvent();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$kickUser$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            WidgetUserSheetViewModel.this.emitDismissSheetEvent();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$launchVideoCall$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            WidgetUserSheetViewModel.this.emitLaunchVideoCallEvent(channel.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$launchVideoCall$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetUserSheetViewModel.this.emitShowToastEvent(R.string.default_failure_to_perform_action_message);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$launchVoiceCall$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            WidgetUserSheetViewModel.this.emitLaunchVoiceCallEvent(channel.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$launchVoiceCall$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetUserSheetViewModel.this.emitShowToastEvent(R.string.default_failure_to_perform_action_message);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$moveUserToChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            WidgetUserSheetViewModel.this.emitShowToastEvent(R.string.move_to_success);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$moveUserToChannel$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetUserSheetViewModel.this.emitShowToastEvent(R.string.default_failure_to_perform_action_message);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$onActivityCustomButtonClicked$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ActivityMetadata, Unit> {
        public final /* synthetic */ Context $applicationContext;
        public final /* synthetic */ int $buttonIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, Context context) {
            super(1);
            this.$buttonIndex = i;
            this.$applicationContext = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ActivityMetadata activityMetadata) {
            invoke2(activityMetadata);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ActivityMetadata activityMetadata) {
            List<String> listB;
            String str;
            if (activityMetadata == null || (listB = activityMetadata.b()) == null || (str = (String) _Collections.getOrNull(listB, this.$buttonIndex)) == null) {
                return;
            }
            UriHandler.handleOrUntrusted(this.$applicationContext, str, "");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$removeRelationship$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ int $successMessageStringRes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i) {
            super(1);
            this.$successMessageStringRes = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            WidgetUserSheetViewModel.this.emitShowToastEvent(this.$successMessageStringRes);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$removeRelationship$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetUserSheetViewModel.this.emitShowToastEvent(R.string.default_failure_to_perform_action_message);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheetViewModel$setUserSuppressedInChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r30) {
            ViewState viewStateAccess$getViewState$p = WidgetUserSheetViewModel.access$getViewState$p(WidgetUserSheetViewModel.this);
            if (!(viewStateAccess$getViewState$p instanceof ViewState.Loaded)) {
                viewStateAccess$getViewState$p = null;
            }
            ViewState.Loaded loaded = (ViewState.Loaded) viewStateAccess$getViewState$p;
            if (loaded != null) {
                WidgetUserSheetViewModel widgetUserSheetViewModel = WidgetUserSheetViewModel.this;
                UserProfileStageActionsView.ViewState stageViewState = loaded.getStageViewState();
                widgetUserSheetViewModel.updateViewState(ViewState.Loaded.copy$default(loaded, null, false, false, null, null, null, null, null, null, stageViewState.m53copyam1GJgw((Opcodes.LAND & 1) != 0 ? stageViewState.isMe : false, (Opcodes.LAND & 2) != 0 ? stageViewState.channel : null, (Opcodes.LAND & 4) != 0 ? stageViewState.userStageRole : null, (Opcodes.LAND & 8) != 0 ? stageViewState.userRequestToSpeakState : null, (Opcodes.LAND & 16) != 0 ? stageViewState.userInSameVoiceChannel : false, (Opcodes.LAND & 32) != 0 ? stageViewState.canMuteMembers : false, (Opcodes.LAND & 64) != 0 ? stageViewState.isUpdatingSuppressed : false, (Opcodes.LAND & 128) != 0 ? stageViewState.isInvitingToSpeak : false), null, null, null, null, 0, null, null, null, false, null, false, null, null, null, 16776703, null));
                WidgetUserSheetViewModel.this.emitDismissSheetEvent();
            }
        }
    }

    public /* synthetic */ WidgetUserSheetViewModel(long j, long j2, Long l, String str, boolean z2, Observable observable, WidgetUserSheet.StreamPreviewClickBehavior streamPreviewClickBehavior, StoreMediaSettings storeMediaSettings, StoreApplicationStreaming storeApplicationStreaming, StoreUserNotes storeUserNotes, StoreUserProfile storeUserProfile, RestAPI restAPI, RestAPI restAPI2, StoreApplicationStreamPreviews storeApplicationStreamPreviews, Parser parser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, l, str, z2, (i & 32) != 0 ? WidgetUserSheetViewModelStoreState.observeStoreState$default(WidgetUserSheetViewModelStoreState.INSTANCE, j, Long.valueOf(j2), l, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131064, null) : observable, streamPreviewClickBehavior, (i & 128) != 0 ? StoreStream.INSTANCE.getMediaSettings() : storeMediaSettings, (i & 256) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming, (i & 512) != 0 ? StoreStream.INSTANCE.getUsersNotes() : storeUserNotes, (i & 1024) != 0 ? StoreStream.INSTANCE.getUserProfile() : storeUserProfile, (i & 2048) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4096) != 0 ? RestAPI.INSTANCE.getApiSerializeNulls() : restAPI2, (i & 8192) != 0 ? StoreStream.INSTANCE.getApplicationStreamPreviews() : storeApplicationStreamPreviews, (i & 16384) != 0 ? DiscordParser.createParser$default(false, false, false, false, false, 28, null) : parser);
    }

    public static final /* synthetic */ ViewState access$getViewState$p(WidgetUserSheetViewModel widgetUserSheetViewModel) {
        return widgetUserSheetViewModel.getViewState();
    }

    public static /* synthetic */ void addRelationship$default(WidgetUserSheetViewModel widgetUserSheetViewModel, Integer num, String str, int i, CaptchaHelper.CaptchaPayload captchaPayload, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            captchaPayload = null;
        }
        widgetUserSheetViewModel.addRelationship(num, str, i, captchaPayload);
    }

    private final UserProfileAdminView.ViewState createAdminViewState(Channel channel, boolean isChannelOwner, boolean isMe, PermissionsContexts3 manageUserContext, VoiceState channelVoiceState, boolean canDisableCommunication, boolean isCommunicationDisabled) {
        boolean z2;
        if (channel == null) {
            return null;
        }
        boolean z3 = manageUserContext != null && (manageUserContext.getCanChangeNickname() || manageUserContext.getCanManageRoles());
        boolean z4 = !ChannelUtils.z(channel) ? manageUserContext == null || !manageUserContext.getCanKick() : ChannelUtils.y(channel) || !isChannelOwner || isMe;
        boolean z5 = canDisableCommunication && manageUserContext != null && manageUserContext.getCanDisableCommunication() && !isMe;
        boolean z6 = ChannelUtils.z(channel);
        boolean z7 = manageUserContext != null && manageUserContext.getCanBan();
        boolean z8 = (channelVoiceState == null || manageUserContext == null || !manageUserContext.getCanMute() || ChannelUtils.D(channel)) ? false : true;
        boolean z9 = channelVoiceState != null && channelVoiceState.getMute();
        boolean z10 = (channelVoiceState == null || manageUserContext == null || !manageUserContext.getCanDeafen()) ? false : true;
        boolean z11 = channelVoiceState != null && channelVoiceState.getDeaf();
        boolean z12 = (channelVoiceState == null || manageUserContext == null || !manageUserContext.getCanMove()) ? false : true;
        Boolean[] boolArr = {Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z7), Boolean.valueOf(z5), Boolean.valueOf(z8), Boolean.valueOf(z10), Boolean.valueOf(z12)};
        for (int i = 0; i < 7; i++) {
            if (boolArr[i].booleanValue()) {
                z2 = true;
                return new UserProfileAdminView.ViewState(z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, z2, isMe, isCommunicationDisabled);
            }
        }
        z2 = false;
        return new UserProfileAdminView.ViewState(z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, z2, isMe, isCommunicationDisabled);
    }

    private final List<Node<MessageRenderContext>> createAndProcessBioAstFromText(String bio) {
        if (bio == null || StringsJVM.isBlank(bio)) {
            return null;
        }
        List<Node<MessageRenderContext>> listGenerateAst = generateAst(bio);
        createMessagePreprocessor().process(listGenerateAst);
        return listGenerateAst;
    }

    private final UserProfileConnectionsView.ViewState createConnectionsViewState(UserProfile userProfile, boolean isMe, boolean isSystemUser) {
        List<ConnectedAccount> listB = userProfile.b();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listB, 10));
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(new UserProfileConnectionsView.ConnectedAccountItem((ConnectedAccount) it.next()));
        }
        boolean z2 = (isMe || isSystemUser) ? false : true;
        return new UserProfileConnectionsView.ViewState(z2 || (arrayList.isEmpty() ^ true), z2, arrayList);
    }

    private final MessagePreprocessor createMessagePreprocessor() {
        return new MessagePreprocessor(-1L, this.revealedBioIndices, null, false, null, 28, null);
    }

    private final Observable<Channel> createPrivateChannelWithUser(long userId) {
        return this.restAPI.createOrFetchDM(userId);
    }

    public static /* synthetic */ void disconnectUser$default(WidgetUserSheetViewModel widgetUserSheetViewModel, Channel channel, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = null;
        }
        widgetUserSheetViewModel.disconnectUser(channel);
    }

    private final void emitDismissSheetEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.DismissSheet.INSTANCE);
    }

    private final void emitLaunchSpectateEvent(ModelApplicationStream stream) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.LaunchSpectate(stream));
    }

    private final void emitLaunchVideoCallEvent(long channelId) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.LaunchVideoCall(channelId));
    }

    private final void emitLaunchVoiceCallEvent(long channelId) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.LaunchVoiceCall(channelId));
    }

    private final void emitRequestStreamPermissionsEvent(ModelApplicationStream stream) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.RequestPermissionsForSpectateStream(stream));
    }

    private final void emitShowFriendRequestAbortToast(int abortCode, String username) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowFriendRequestErrorToast(abortCode, username));
    }

    private final void emitShowToastEvent(@StringRes int stringRes) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowToast(stringRes));
    }

    private final List<Node<MessageRenderContext>> generateAst(CharSequence text) {
        return Parser.parse$default(this.bioParser, text, MessageParseState.INSTANCE.getInitialState(), null, 4, null);
    }

    /* JADX WARN: Code duplicated, block: B:103:0x023a  */
    /* JADX WARN: Code duplicated, block: B:23:0x0091  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f9  */
    private final void handleStoreState(StoreState storeState) {
        List listEmptyList;
        String strC;
        Float fValueOf;
        boolean z2;
        User user;
        ModelUserNote note;
        String bio;
        User userMerge;
        ModelApplicationStream stream;
        String name;
        List<Long> roles;
        if (storeState == null) {
            this.eventSubject.k.onNext(Event.UserNotFound.INSTANCE);
            return;
        }
        User user2 = storeState.getUser();
        MeUser me2 = storeState.getMe();
        Channel channel = storeState.getChannel();
        Map<Long, GuildMember> computedMembers = storeState.getComputedMembers();
        Map<Long, GuildRole> guildRoles = storeState.getGuildRoles();
        Guild guild = storeState.getGuild();
        boolean z3 = false;
        boolean z4 = me2.getId() == user2.getId();
        boolean isSystemUser = user2.getIsSystemUser();
        GuildMember guildMember = (GuildMember) outline.f(user2, computedMembers);
        GuildMember guildMember2 = computedMembers.get(Long.valueOf(me2.getId()));
        if (guildMember == null || (roles = guildMember.getRoles()) == null) {
            listEmptyList = Collections2.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = roles.iterator();
            while (it.hasNext()) {
                GuildRole guildRole = guildRoles.get(Long.valueOf(((Number) it.next()).longValue()));
                if (guildRole != null) {
                    arrayList.add(guildRole);
                }
            }
            listEmptyList = _Collections.sortedWith(arrayList, RoleUtils.getROLE_COMPARATOR());
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
        }
        List list = listEmptyList;
        PermissionsContexts3 permissionsContexts3From = (guildMember == null || guildMember2 == null || guild == null) ? null : PermissionsContexts3.INSTANCE.from(guild, me2, user2, guildMember2.getRoles(), guildMember.getRoles(), storeState.getPermissions(), guildRoles);
        boolean zIsCommunicationDisabled = guildMember != null ? guildMember.isCommunicationDisabled() : false;
        boolean z5 = channel != null && channel.getOwnerId() == me2.getId();
        int type = ModelUserRelationship.getType(storeState.getUserRelationshipType());
        VoiceState voiceState = (VoiceState) outline.f(user2, storeState.getMySelectedVoiceChannelVoiceStates());
        VoiceState voiceState2 = storeState.getMySelectedVoiceChannelVoiceStates().get(Long.valueOf(me2.getId()));
        boolean zIsInSameVoiceChannel = isInSameVoiceChannel(voiceState2, voiceState);
        boolean z6 = this.isVoiceContext || zIsInSameVoiceChannel;
        boolean selfMuted = z4 ? storeState.getSelfMuted() : storeState.getMuted();
        Boolean boolValueOf = z4 ? Boolean.valueOf(storeState.getSelfDeafened()) : null;
        if (z4) {
            strC = null;
            fValueOf = null;
        } else {
            strC = null;
            fValueOf = Float.valueOf(PerceptualVolumeUtils.amplitudeToPerceptual$default(PerceptualVolumeUtils.INSTANCE, storeState.getOutputVolume(), 0.0f, 2, null));
        }
        UserProfileVoiceSettingsView.ViewState viewState = new UserProfileVoiceSettingsView.ViewState(selfMuted, boolValueOf, fValueOf);
        VoiceState voiceState3 = (VoiceState) outline.f(user2, storeState.getCurrentChannelVoiceStates());
        if (channel != null && ChannelUtils.z(channel)) {
            strC = ChannelUtils.c(channel);
        }
        String str = (guild == null || (name = guild.getName()) == null) ? strC : name;
        boolean z7 = z4;
        UserProfileAdminView.ViewState viewStateCreateAdminViewState = createAdminViewState(channel, z5, z4, permissionsContexts3From, voiceState3, storeState.getCanDisableCommunication(), zIsCommunicationDisabled);
        UserProfile userProfile = storeState.getUserProfile();
        UserProfileConnectionsView.ViewState viewStateCreateConnectionsViewState = createConnectionsViewState(userProfile, z7, isSystemUser);
        StreamContext streamContext = storeState.getStreamContext();
        String encodedStreamKey = (streamContext == null || (stream = streamContext.getStream()) == null) ? null : stream.getEncodedStreamKey();
        if (encodedStreamKey != null && !this.fetchedPreviews.contains(encodedStreamKey)) {
            this.storeApplicationStreamPreviews.fetchStreamPreviewIfNotFetching(streamContext);
            this.fetchedPreviews.add(encodedStreamKey);
        }
        UserProfileStageActionsView.ViewState viewState2 = new UserProfileStageActionsView.ViewState(z7, storeState.getStageChannel(), storeState.m60getUserStageRolestwRsX0(), storeState.getUserRequestToSpeakState(), isInSameVoiceChannel(voiceState2, voiceState), PermissionUtils.can(Permission.MUTE_MEMBERS, storeState.getPermissions()), false, false, Opcodes.CHECKCAST, null);
        Long l = this.guildId;
        if (l == null || (l != null && l.longValue() == 0)) {
            z2 = true;
        } else {
            if ((guildMember != null ? guildMember.getBio() : null) != null) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        boolean z8 = (Intrinsics3.areEqual(userProfile, StoreUserProfile.INSTANCE.getEMPTY_PROFILE()) ^ true) && z2;
        if (z8) {
            if (user2 instanceof MeUser) {
                userMerge = MeUser.INSTANCE.merge((MeUser) user2, userProfile.getUser());
            } else if (user2 instanceof CoreUser) {
                userMerge = CoreUser.INSTANCE.merge((CoreUser) user2, userProfile.getUser());
            } else {
                user = user2;
            }
            user = userMerge;
        } else {
            user = user2;
        }
        List<Node<MessageRenderContext>> listCreateAndProcessBioAstFromText = (guildMember == null || (bio = guildMember.getBio()) == null || !(StringsJVM.isBlank(bio) ^ true)) ? null : createAndProcessBioAstFromText(bio);
        if (listCreateAndProcessBioAstFromText == null) {
            String bio2 = user.getBio();
            listCreateAndProcessBioAstFromText = bio2 != null ? createAndProcessBioAstFromText(bio2) : null;
        }
        List<Node<MessageRenderContext>> list2 = listCreateAndProcessBioAstFromText;
        StoreUserNotes.UserNoteState userNoteFetchState = storeState.getUserNoteFetchState();
        if (!(userNoteFetchState instanceof StoreUserNotes.UserNoteState.Loaded)) {
            userNoteFetchState = null;
        }
        StoreUserNotes.UserNoteState.Loaded loaded = (StoreUserNotes.UserNoteState.Loaded) userNoteFetchState;
        String note2 = (loaded == null || (note = loaded.getNote()) == null) ? null : note.getNote();
        ViewState viewState3 = getViewState();
        if (!(viewState3 instanceof ViewState.Loaded)) {
            viewState3 = null;
        }
        ViewState.Loaded loaded2 = (ViewState.Loaded) viewState3;
        boolean z9 = ((loaded2 != null ? loaded2.getUserNoteFetchState() : null) instanceof StoreUserNotes.UserNoteState.Loading) && !(storeState.getUserNoteFetchState() instanceof StoreUserNotes.UserNoteState.Loading);
        if (getViewState() instanceof ViewState.Uninitialized) {
            if (!(note2 == null || note2.length() == 0)) {
                z3 = true;
            }
        }
        if (!z9 && !z3) {
            note2 = null;
        } else if (note2 == null) {
            note2 = "";
        }
        updateViewState(new ViewState.Loaded(user, z7, z6, viewState, voiceState3, storeState.getRichPresence(), str, list, viewStateCreateAdminViewState, viewState2, channel, streamContext, guild != null ? guild.getName() : null, guild != null ? guild.getIcon() : null, type, viewStateCreateConnectionsViewState, storeState.getUserNoteFetchState(), note2, zIsInSameVoiceChannel, list2, z8, this.guildId, guildMember, storeState.getUserProfile()));
        this.mostRecentStoreState = storeState;
    }

    private final boolean isInSameVoiceChannel(VoiceState myVoiceState, VoiceState userVoiceState) {
        Long channelId = userVoiceState != null ? userVoiceState.getChannelId() : null;
        Long channelId2 = myVoiceState != null ? myVoiceState.getChannelId() : null;
        if (channelId == null || channelId2 == null) {
            return false;
        }
        return Intrinsics3.areEqual(channelId, channelId2);
    }

    public final void addRelationship(Integer type, String username, @StringRes int successMessageStringRes, CaptchaHelper.CaptchaPayload captchaPayload) {
        Intrinsics3.checkNotNullParameter(username, "username");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.addRelationship("User Profile", this.userId, type, this.friendToken, captchaPayload), false, 1, null), this, null, 2, null), (Class<?>) WidgetUserSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2(type, username, successMessageStringRes)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(successMessageStringRes));
    }

    public final void banUser() {
        Channel channel;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (channel = loaded.getChannel()) == null) {
            return;
        }
        User user = loaded.getUser();
        this.eventSubject.k.onNext(new Event.LaunchBanUser(user.getUsername(), channel.getGuildId(), user.getId()));
    }

    public final void disableCommunication() {
        Channel channel;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (channel = loaded.getChannel()) == null) {
            return;
        }
        User user = loaded.getUser();
        GuildMember guildMember = loaded.getGuildMember();
        if (guildMember != null ? guildMember.isCommunicationDisabled() : false) {
            this.eventSubject.k.onNext(new Event.LaunchEnableCommunication(user.getId(), channel.getGuildId()));
        } else {
            this.eventSubject.k.onNext(new Event.LaunchDisableCommunication(user.getId(), channel.getGuildId()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void disconnectUser(Channel channel) {
        ViewState viewState = getViewState();
        Long l = null;
        Object[] objArr = 0;
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            if (channel == null) {
                channel = loaded.getChannel();
            }
            if (channel != null) {
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPISerializeNulls.disconnectGuildMember(channel.getGuildId(), loaded.getUser().getId(), new RestAPIParams.GuildMemberDisconnect(l, 1, objArr == true ? 1 : 0)), false, 1, null), this, null, 2, null), (Class<?>) WidgetUserSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
            }
        }
    }

    public final void editMember() {
        Channel channel;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (channel = loaded.getChannel()) == null) {
            return;
        }
        this.eventSubject.k.onNext(new Event.LaunchEditMember(channel.getGuildId(), this.userId));
    }

    public final boolean getOpenPopoutLogged() {
        return this.openPopoutLogged;
    }

    public final void guildDeafenUser() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            Channel channel = loaded.getChannel();
            User user = loaded.getUser();
            UserProfileAdminView.ViewState adminViewState = loaded.getAdminViewState();
            if (channel == null || adminViewState == null) {
                return;
            }
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.changeGuildMember(channel.getGuildId(), user.getId(), RestAPIParams.GuildMember.INSTANCE.createWithDeaf(!adminViewState.isServerDeafened())), false, 1, null), this, null, 2, null), (Class<?>) WidgetUserSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass1.INSTANCE);
        }
    }

    public final void guildMoveForUser() {
        Channel channel;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (channel = loaded.getChannel()) == null) {
            return;
        }
        this.eventSubject.k.onNext(new Event.LaunchMoveUser(channel.getGuildId()));
    }

    public final void guildMuteUser() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            Channel channel = loaded.getChannel();
            UserProfileAdminView.ViewState adminViewState = loaded.getAdminViewState();
            User user = loaded.getUser();
            if (channel == null || adminViewState == null) {
                return;
            }
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.changeGuildMember(channel.getGuildId(), user.getId(), RestAPIParams.GuildMember.INSTANCE.createWithMute(!loaded.getAdminViewState().isServerMuted())), false, 1, null), this, null, 2, null), (Class<?>) WidgetUserSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass1.INSTANCE);
        }
    }

    @MainThread
    public final void handleBioIndexClicked(SpoilerNode<?> spoilerNode) {
        StoreState storeState;
        UserProfile userProfile;
        com.discord.api.user.User user;
        NullSerializable<String> nullSerializableD;
        String strA;
        Intrinsics3.checkNotNullParameter(spoilerNode, "spoilerNode");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (storeState = this.mostRecentStoreState) == null || (userProfile = storeState.getUserProfile()) == null || (user = userProfile.getUser()) == null || (nullSerializableD = user.d()) == null || (strA = nullSerializableD.a()) == null) {
            return;
        }
        this.revealedBioIndices.add(Integer.valueOf(spoilerNode.getId()));
        updateViewState(ViewState.Loaded.copy$default(loaded, null, false, false, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, false, createAndProcessBioAstFromText(strA), false, null, null, null, 16252927, null));
    }

    public final void inviteUserToSpeak() {
        Channel channel;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (channel = loaded.getStageViewState().getChannel()) == null) {
            return;
        }
        long id2 = loaded.getUser().getId();
        UserProfileStageActionsView.ViewState stageViewState = loaded.getStageViewState();
        updateViewState(ViewState.Loaded.copy$default(loaded, null, false, false, null, null, null, null, null, null, stageViewState.m53copyam1GJgw((Opcodes.LAND & 1) != 0 ? stageViewState.isMe : false, (Opcodes.LAND & 2) != 0 ? stageViewState.channel : null, (Opcodes.LAND & 4) != 0 ? stageViewState.userStageRole : null, (Opcodes.LAND & 8) != 0 ? stageViewState.userRequestToSpeakState : null, (Opcodes.LAND & 16) != 0 ? stageViewState.userInSameVoiceChannel : false, (Opcodes.LAND & 32) != 0 ? stageViewState.canMuteMembers : false, (Opcodes.LAND & 64) != 0 ? stageViewState.isUpdatingSuppressed : false, (Opcodes.LAND & 128) != 0 ? stageViewState.isInvitingToSpeak : true), null, null, null, null, 0, null, null, null, false, null, false, null, null, null, 16776703, null));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.setUserSuppressedInChannel$default(StageChannelAPI.INSTANCE, channel, id2, false, 0L, 8, null), false, 1, null), this, null, 2, null), (Class<?>) WidgetUserSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final void kickUser() {
        Channel channel;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (channel = loaded.getChannel()) == null) {
            return;
        }
        User user = loaded.getUser();
        if (ChannelUtils.z(channel)) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().removeChannelRecipient(channel.getId(), user.getId()), false, 1, null), 0L, false, 1, null), this, null, 2, null), (117 & 1) != 0 ? null : null, "REST: remove group member", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass1(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
        } else {
            this.eventSubject.k.onNext(new Event.LaunchKickUser(user.getUsername(), channel.getGuildId(), user.getId()));
        }
    }

    public final void launchVideoCall() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(createPrivateChannelWithUser(this.userId), false, 1, null), this, null, 2, null), (Class<?>) WidgetUserSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final void launchVoiceCall() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(createPrivateChannelWithUser(this.userId), false, 1, null), this, null, 2, null), (Class<?>) WidgetUserSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final void moveUserToChannel(long channelId) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            Channel channel = loaded.getChannel();
            User user = loaded.getUser();
            if (channel != null) {
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.changeGuildMember(channel.getGuildId(), user.getId(), RestAPIParams.GuildMember.INSTANCE.createWithChannelId(channelId)), false, 1, null), this, null, 2, null), (Class<?>) WidgetUserSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
            }
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onActivityCustomButtonClicked(Context applicationContext, long userId, String sessionId, long applicationId, int buttonIndex) {
        Intrinsics3.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics3.checkNotNullParameter(sessionId, "sessionId");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getActivityMetadata(userId, sessionId, applicationId), false, 1, null), this, null, 2, null), (117 & 1) != 0 ? null : null, "REST: Custom Button GetActivityMetadata", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass1(buttonIndex, applicationContext), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
    }

    @MainThread
    public final void onSpectatePermissionsGranted(ModelApplicationStream stream) {
        Intrinsics3.checkNotNullParameter(stream, "stream");
        StoreApplicationStreaming.targetStream$default(this.storeApplicationStreaming, stream.getEncodedStreamKey(), false, 2, null);
        int iOrdinal = this.streamPreviewClickBehavior.ordinal();
        if (iOrdinal == 0) {
            emitLaunchSpectateEvent(stream);
        } else {
            if (iOrdinal != 1) {
                return;
            }
            emitDismissSheetEvent();
        }
    }

    public final void onStreamPreviewClicked(StreamContext streamContext) {
        Intrinsics3.checkNotNullParameter(streamContext, "streamContext");
        if (streamContext.getJoinability() == StreamContext.Joinability.MISSING_PERMISSIONS) {
            emitShowToastEvent(R.string.channel_locked);
        } else {
            emitRequestStreamPermissionsEvent(streamContext.getStream());
        }
    }

    public final void removeRelationship(@StringRes int successMessageStringRes) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.removeRelationship("User Profile", this.userId), false, 1, null), this, null, 2, null), (Class<?>) WidgetUserSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(successMessageStringRes));
    }

    public final void saveUserNote(Context context, String noteText) {
        Intrinsics3.checkNotNullParameter(noteText, "noteText");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            boolean z2 = true;
            if ((!(loaded.getUserNoteFetchState() instanceof StoreUserNotes.UserNoteState.Empty) || !(!Intrinsics3.areEqual(noteText, ""))) && (!(loaded.getUserNoteFetchState() instanceof StoreUserNotes.UserNoteState.Loaded) || !(!Intrinsics3.areEqual(((StoreUserNotes.UserNoteState.Loaded) loaded.getUserNoteFetchState()).getNote().getNote(), noteText)))) {
                z2 = false;
            }
            if (z2) {
                this.storeUserNotes.saveNote(context, this.userId, noteText);
            }
        }
    }

    public final void setOpenPopoutLogged(boolean z2) {
        this.openPopoutLogged = z2;
    }

    public final void setUserOutputVolume(float volume) {
        this.storeMediaSettings.setUserOutputVolume(this.userId, PerceptualVolumeUtils.perceptualToAmplitude$default(PerceptualVolumeUtils.INSTANCE, volume, 0.0f, 2, null));
    }

    public final void setUserSuppressedInChannel(boolean isSuppressed) {
        Channel channel;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (channel = loaded.getStageViewState().getChannel()) == null) {
            return;
        }
        long id2 = loaded.getUser().getId();
        UserProfileStageActionsView.ViewState stageViewState = loaded.getStageViewState();
        updateViewState(ViewState.Loaded.copy$default(loaded, null, false, false, null, null, null, null, null, null, stageViewState.m53copyam1GJgw((Opcodes.LAND & 1) != 0 ? stageViewState.isMe : false, (Opcodes.LAND & 2) != 0 ? stageViewState.channel : null, (Opcodes.LAND & 4) != 0 ? stageViewState.userStageRole : null, (Opcodes.LAND & 8) != 0 ? stageViewState.userRequestToSpeakState : null, (Opcodes.LAND & 16) != 0 ? stageViewState.userInSameVoiceChannel : false, (Opcodes.LAND & 32) != 0 ? stageViewState.canMuteMembers : false, (Opcodes.LAND & 64) != 0 ? stageViewState.isUpdatingSuppressed : true, (Opcodes.LAND & 128) != 0 ? stageViewState.isInvitingToSpeak : false), null, null, null, null, 0, null, null, null, false, null, false, null, null, null, 16776703, null));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.setUserSuppressedInChannel$default(StageChannelAPI.INSTANCE, channel, id2, isSuppressed, 0L, 8, null), false, 1, null), this, null, 2, null), (Class<?>) WidgetUserSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final void toggleDeafen(boolean isChecked) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null && loaded.isMe() && (!Intrinsics3.areEqual(loaded.getVoiceSettingsViewState().isDeafened(), Boolean.valueOf(isChecked)))) {
            this.storeMediaSettings.toggleSelfDeafened();
        }
    }

    public final void toggleMute(boolean isChecked) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || loaded.getVoiceSettingsViewState().isMuted() == isChecked) {
            return;
        }
        if (!loaded.isMe()) {
            this.storeMediaSettings.toggleUserMuted(this.userId);
            return;
        }
        StoreMediaSettings.SelfMuteFailure selfMuteFailure = this.storeMediaSettings.toggleSelfMuted();
        if (selfMuteFailure == null || selfMuteFailure.ordinal() != 0) {
            return;
        }
        emitShowToastEvent(R.string.vad_permission_small);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheetViewModel(long j, long j2, Long l, String str, boolean z2, Observable<StoreState> observable, WidgetUserSheet.StreamPreviewClickBehavior streamPreviewClickBehavior, StoreMediaSettings storeMediaSettings, StoreApplicationStreaming storeApplicationStreaming, StoreUserNotes storeUserNotes, StoreUserProfile storeUserProfile, RestAPI restAPI, RestAPI restAPI2, StoreApplicationStreamPreviews storeApplicationStreamPreviews, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        Intrinsics3.checkNotNullParameter(streamPreviewClickBehavior, "streamPreviewClickBehavior");
        Intrinsics3.checkNotNullParameter(storeMediaSettings, "storeMediaSettings");
        Intrinsics3.checkNotNullParameter(storeApplicationStreaming, "storeApplicationStreaming");
        Intrinsics3.checkNotNullParameter(storeUserNotes, "storeUserNotes");
        Intrinsics3.checkNotNullParameter(storeUserProfile, "storeUserProfile");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(restAPI2, "restAPISerializeNulls");
        Intrinsics3.checkNotNullParameter(storeApplicationStreamPreviews, "storeApplicationStreamPreviews");
        Intrinsics3.checkNotNullParameter(parser, "bioParser");
        this.userId = j;
        this.channelId = j2;
        this.guildId = l;
        this.friendToken = str;
        this.isVoiceContext = z2;
        this.streamPreviewClickBehavior = streamPreviewClickBehavior;
        this.storeMediaSettings = storeMediaSettings;
        this.storeApplicationStreaming = storeApplicationStreaming;
        this.storeUserNotes = storeUserNotes;
        this.storeUserProfile = storeUserProfile;
        this.restAPI = restAPI;
        this.restAPISerializeNulls = restAPI2;
        this.storeApplicationStreamPreviews = storeApplicationStreamPreviews;
        this.bioParser = parser;
        this.eventSubject = PublishSubject.k0();
        this.fetchedPreviews = new LinkedHashSet();
        this.revealedBioIndices = new LinkedHashSet();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetUserSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        storeUserNotes.loadNote(j);
        storeUserProfile.fetchProfile(j, (12 & 2) != 0 ? null : l, (12 & 4) != 0 ? false : false, (12 & 8) != 0 ? null : null);
    }
}
