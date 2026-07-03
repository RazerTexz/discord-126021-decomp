package com.discord.restapi;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.media.AudioAttributesCompat;
import com.discord.api.application.Application;
import com.discord.api.botuikit.ComponentType;
import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.friendsuggestions.AllowedInSuggestionsType;
import com.discord.api.guild.Guild;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefit;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.message.allowedmentions.MessageAllowedMentionsTypes;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.presence.ClientStatus;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelCustomStatusSetting;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.models.domain.ModelMemberVerificationForm;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelSubscription;
import com.discord.nullserializable.NullSerializable;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p408d.C4906j;
import p007b.p225i.p408d.InterfaceC4908l;
import p007b.p225i.p408d.InterfaceC4909m;
import p507d0.C12116o;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams {

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class ActivateMfaSMS {
        private final String password;

        public ActivateMfaSMS(String str) {
            C12238m.checkNotNullParameter(str, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
            this.password = str;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class AddServerBody {
        private final String description;
        private final int primaryCategoryId;

        public AddServerBody(String str, int i) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
            this.description = str;
            this.primaryCategoryId = i;
        }

        public static /* synthetic */ AddServerBody copy$default(AddServerBody addServerBody, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = addServerBody.description;
            }
            if ((i2 & 2) != 0) {
                i = addServerBody.primaryCategoryId;
            }
            return addServerBody.copy(str, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getPrimaryCategoryId() {
            return this.primaryCategoryId;
        }

        public final AddServerBody copy(String description, int primaryCategoryId) {
            C12238m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
            return new AddServerBody(description, primaryCategoryId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddServerBody)) {
                return false;
            }
            AddServerBody addServerBody = (AddServerBody) other;
            return C12238m.areEqual(this.description, addServerBody.description) && this.primaryCategoryId == addServerBody.primaryCategoryId;
        }

        public final String getDescription() {
            return this.description;
        }

        public final int getPrimaryCategoryId() {
            return this.primaryCategoryId;
        }

        public int hashCode() {
            String str = this.description;
            return ((str != null ? str.hashCode() : 0) * 31) + this.primaryCategoryId;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("AddServerBody(description=");
            sbM833U.append(this.description);
            sbM833U.append(", primaryCategoryId=");
            return C1643a.m814B(sbM833U, this.primaryCategoryId, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class ApplicationCommand {
        private final String applicationId;
        private final String channelId;
        private final ApplicationCommandData data;
        private final String guildId;
        private final String nonce;
        private final String sessionId;
        private final long type;

        public ApplicationCommand(long j, String str, String str2, String str3, ApplicationCommandData applicationCommandData, String str4, String str5) {
            C12238m.checkNotNullParameter(str, "channelId");
            C12238m.checkNotNullParameter(str2, "applicationId");
            C12238m.checkNotNullParameter(applicationCommandData, "data");
            C12238m.checkNotNullParameter(str5, "nonce");
            this.type = j;
            this.channelId = str;
            this.applicationId = str2;
            this.guildId = str3;
            this.data = applicationCommandData;
            this.sessionId = str4;
            this.nonce = str5;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getApplicationId() {
            return this.applicationId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ApplicationCommandData getData() {
            return this.data;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getNonce() {
            return this.nonce;
        }

        public final ApplicationCommand copy(long type, String channelId, String applicationId, String guildId, ApplicationCommandData data, String sessionId, String nonce) {
            C12238m.checkNotNullParameter(channelId, "channelId");
            C12238m.checkNotNullParameter(applicationId, "applicationId");
            C12238m.checkNotNullParameter(data, "data");
            C12238m.checkNotNullParameter(nonce, "nonce");
            return new ApplicationCommand(type, channelId, applicationId, guildId, data, sessionId, nonce);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ApplicationCommand)) {
                return false;
            }
            ApplicationCommand applicationCommand = (ApplicationCommand) other;
            return this.type == applicationCommand.type && C12238m.areEqual(this.channelId, applicationCommand.channelId) && C12238m.areEqual(this.applicationId, applicationCommand.applicationId) && C12238m.areEqual(this.guildId, applicationCommand.guildId) && C12238m.areEqual(this.data, applicationCommand.data) && C12238m.areEqual(this.sessionId, applicationCommand.sessionId) && C12238m.areEqual(this.nonce, applicationCommand.nonce);
        }

        public final String getApplicationId() {
            return this.applicationId;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final ApplicationCommandData getData() {
            return this.data;
        }

        public final String getGuildId() {
            return this.guildId;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final long getType() {
            return this.type;
        }

        public int hashCode() {
            long j = this.type;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.channelId;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.applicationId;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.guildId;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            ApplicationCommandData applicationCommandData = this.data;
            int iHashCode4 = (iHashCode3 + (applicationCommandData != null ? applicationCommandData.hashCode() : 0)) * 31;
            String str4 = this.sessionId;
            int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.nonce;
            return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ApplicationCommand(type=");
            sbM833U.append(this.type);
            sbM833U.append(", channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", applicationId=");
            sbM833U.append(this.applicationId);
            sbM833U.append(", guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", data=");
            sbM833U.append(this.data);
            sbM833U.append(", sessionId=");
            sbM833U.append(this.sessionId);
            sbM833U.append(", nonce=");
            return C1643a.m822J(sbM833U, this.nonce, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class AuthLogin {
        private final String captchaKey;
        private final String captchaRqtoken;
        private final String login;
        private final String loginSource;
        private final String password;
        private final Boolean undelete;

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class LoginSource {
            public static final LoginSource INSTANCE = new LoginSource();
            public static final String LOGIN_SOURCE_KEYCHAIN_AUTO = "keychain_auto_login";

            private LoginSource() {
            }
        }

        public AuthLogin(String str, String str2, String str3, String str4, Boolean bool, String str5) {
            this.login = str;
            this.password = str2;
            this.captchaKey = str3;
            this.captchaRqtoken = str4;
            this.undelete = bool;
            this.loginSource = str5;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class AuthRegister {
        private final String captchaKey;
        private final String captchaRqtoken;
        private final boolean consent;
        private final String dateOfBirth;
        private final String email;
        private final String fingerprint;
        private final String guildTemplateCode;
        private final String invite;
        private final String password;
        private final String phoneToken;
        private final String username;

        public AuthRegister(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z2, String str10) {
            this.fingerprint = str;
            this.username = str2;
            this.email = str3;
            this.phoneToken = str4;
            this.password = str5;
            this.captchaKey = str6;
            this.captchaRqtoken = str7;
            this.invite = str8;
            this.guildTemplateCode = str9;
            this.consent = z2;
            this.dateOfBirth = str10;
        }

        public /* synthetic */ AuthRegister(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z2, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, str6, str7, str8, str9, z2, (i & 1024) != 0 ? null : str10);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class AuthRegisterPhone {
        private final String captchaKey;
        private final String captchaRqtoken;
        private final String phone;

        public AuthRegisterPhone(String str, String str2, String str3) {
            C12238m.checkNotNullParameter(str, "phone");
            this.phone = str;
            this.captchaKey = str2;
            this.captchaRqtoken = str3;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class AuthorizeIP {
        private final String token;

        public AuthorizeIP(String str) {
            this.token = str;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class BanGuildMember {
        private final Integer deleteMessageDays;

        /* JADX WARN: Multi-variable type inference failed */
        public BanGuildMember() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public BanGuildMember(Integer num) {
            this.deleteMessageDays = num;
        }

        public /* synthetic */ BanGuildMember(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class CaptchaCode {
        private final String captchaKey;
        private final String captchaRqtoken;

        public CaptchaCode(String str, String str2) {
            this.captchaKey = str;
            this.captchaRqtoken = str2;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class ChannelFollowerPost {
        private final long webhookChannelId;

        public ChannelFollowerPost(long j) {
            this.webhookChannelId = j;
        }

        public final long getWebhookChannelId() {
            return this.webhookChannelId;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class ChannelMessagesAck {
        private final Boolean manual;
        private final Integer mentionCount;

        public ChannelMessagesAck(Boolean bool, Integer num) {
            this.manual = bool;
            this.mentionCount = num;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class ChannelPermissionOverwrites {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Long allow;
        private final Long deny;
        private final String id;
        private final Integer type;

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class Companion {

            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    PermissionOverwrite.Type.values();
                    int[] iArr = new int[2];
                    $EnumSwitchMapping$0 = iArr;
                    iArr[PermissionOverwrite.Type.ROLE.ordinal()] = 1;
                    iArr[PermissionOverwrite.Type.MEMBER.ordinal()] = 2;
                }
            }

            private Companion() {
            }

            public final ChannelPermissionOverwrites createForMember(long id2, Long allow, Long deny) {
                return new ChannelPermissionOverwrites(1, String.valueOf(id2), allow, deny, null);
            }

            public final ChannelPermissionOverwrites createForRole(long id2, Long allow, Long deny) {
                return new ChannelPermissionOverwrites(0, String.valueOf(id2), allow, deny, null);
            }

            public final ChannelPermissionOverwrites fromPermissionOverwrite(PermissionOverwrite overwrite) {
                C12238m.checkNotNullParameter(overwrite, "overwrite");
                int iOrdinal = overwrite.getType().ordinal();
                int i = 1;
                if (iOrdinal == 0) {
                    i = 0;
                } else if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                return new ChannelPermissionOverwrites(Integer.valueOf(i), String.valueOf(overwrite.m8131e()), Long.valueOf(overwrite.getAllow()), Long.valueOf(overwrite.getDeny()), null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private ChannelPermissionOverwrites(Integer num, String str, Long l, Long l2) {
            this.type = num;
            this.id = str;
            this.allow = l;
            this.deny = l2;
        }

        public static final ChannelPermissionOverwrites createForMember(long j, Long l, Long l2) {
            return INSTANCE.createForMember(j, l, l2);
        }

        public static final ChannelPermissionOverwrites createForRole(long j, Long l, Long l2) {
            return INSTANCE.createForRole(j, l, l2);
        }

        public /* synthetic */ ChannelPermissionOverwrites(Integer num, String str, Long l, Long l2, DefaultConstructorMarker defaultConstructorMarker) {
            this(num, str, l, l2);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class ChannelPosition {
        public static final long PARENT_ID_NONE = -1;
        private final long id;
        private final Long parentId;
        private final int position;

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class Serializer implements InterfaceC4909m<ChannelPosition> {
            @Override // p007b.p225i.p408d.InterfaceC4909m
            public JsonElement serialize(ChannelPosition src, Type typeOfSrc, InterfaceC4908l context) {
                if (src == null || (!C12238m.areEqual(typeOfSrc, ChannelPosition.class))) {
                    return null;
                }
                JsonObject jsonObject = new JsonObject();
                jsonObject.m9215i(ModelAuditLogEntry.CHANGE_KEY_ID, Long.valueOf(src.getId()));
                jsonObject.m9215i(ModelAuditLogEntry.CHANGE_KEY_POSITION, Integer.valueOf(src.getPosition()));
                Long parentId = src.getParentId();
                if (parentId != null) {
                    long jLongValue = parentId.longValue();
                    if (jLongValue == -1) {
                        jsonObject.f21481a.put("parent_id", C4906j.f13106a);
                    } else {
                        jsonObject.m9215i("parent_id", Long.valueOf(jLongValue));
                    }
                }
                return jsonObject;
            }
        }

        public ChannelPosition(long j, int i, Long l) {
            this.id = j;
            this.position = i;
            this.parentId = l;
        }

        public final long getId() {
            return this.id;
        }

        public final Long getParentId() {
            return this.parentId;
        }

        public final int getPosition() {
            return this.position;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class ChannelVoiceStateUpdate {
        private final long channelId;
        private final UtcDateTime requestToSpeakTimestamp;
        private final Boolean suppress;

        public ChannelVoiceStateUpdate(long j, Boolean bool, UtcDateTime utcDateTime) {
            this.channelId = j;
            this.suppress = bool;
            this.requestToSpeakTimestamp = utcDateTime;
        }

        public static /* synthetic */ ChannelVoiceStateUpdate copy$default(ChannelVoiceStateUpdate channelVoiceStateUpdate, long j, Boolean bool, UtcDateTime utcDateTime, int i, Object obj) {
            if ((i & 1) != 0) {
                j = channelVoiceStateUpdate.channelId;
            }
            if ((i & 2) != 0) {
                bool = channelVoiceStateUpdate.suppress;
            }
            if ((i & 4) != 0) {
                utcDateTime = channelVoiceStateUpdate.requestToSpeakTimestamp;
            }
            return channelVoiceStateUpdate.copy(j, bool, utcDateTime);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getSuppress() {
            return this.suppress;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final UtcDateTime getRequestToSpeakTimestamp() {
            return this.requestToSpeakTimestamp;
        }

        public final ChannelVoiceStateUpdate copy(long channelId, Boolean suppress, UtcDateTime requestToSpeakTimestamp) {
            return new ChannelVoiceStateUpdate(channelId, suppress, requestToSpeakTimestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelVoiceStateUpdate)) {
                return false;
            }
            ChannelVoiceStateUpdate channelVoiceStateUpdate = (ChannelVoiceStateUpdate) other;
            return this.channelId == channelVoiceStateUpdate.channelId && C12238m.areEqual(this.suppress, channelVoiceStateUpdate.suppress) && C12238m.areEqual(this.requestToSpeakTimestamp, channelVoiceStateUpdate.requestToSpeakTimestamp);
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final UtcDateTime getRequestToSpeakTimestamp() {
            return this.requestToSpeakTimestamp;
        }

        public final Boolean getSuppress() {
            return this.suppress;
        }

        public int hashCode() {
            long j = this.channelId;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            Boolean bool = this.suppress;
            int iHashCode = (i + (bool != null ? bool.hashCode() : 0)) * 31;
            UtcDateTime utcDateTime = this.requestToSpeakTimestamp;
            return iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ChannelVoiceStateUpdate(channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", suppress=");
            sbM833U.append(this.suppress);
            sbM833U.append(", requestToSpeakTimestamp=");
            sbM833U.append(this.requestToSpeakTimestamp);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        public /* synthetic */ ChannelVoiceStateUpdate(long j, Boolean bool, UtcDateTime utcDateTime, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : utcDateTime);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class ComponentInteraction {
        private final long applicationId;
        private final long channelId;
        private final ComponentInteractionData data;
        private final Long guildId;
        private final Long messageFlags;
        private final long messageId;
        private final String nonce;
        private final String sessionId;
        private final long type;

        public ComponentInteraction(long j, long j2, long j3, Long l, long j4, Long l2, ComponentInteractionData componentInteractionData, String str, String str2) {
            C12238m.checkNotNullParameter(componentInteractionData, "data");
            C12238m.checkNotNullParameter(str2, "nonce");
            this.type = j;
            this.channelId = j2;
            this.applicationId = j3;
            this.guildId = l;
            this.messageId = j4;
            this.messageFlags = l2;
            this.data = componentInteractionData;
            this.sessionId = str;
            this.nonce = str2;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getApplicationId() {
            return this.applicationId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getMessageId() {
            return this.messageId;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Long getMessageFlags() {
            return this.messageFlags;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final ComponentInteractionData getData() {
            return this.data;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getNonce() {
            return this.nonce;
        }

        public final ComponentInteraction copy(long type, long channelId, long applicationId, Long guildId, long messageId, Long messageFlags, ComponentInteractionData data, String sessionId, String nonce) {
            C12238m.checkNotNullParameter(data, "data");
            C12238m.checkNotNullParameter(nonce, "nonce");
            return new ComponentInteraction(type, channelId, applicationId, guildId, messageId, messageFlags, data, sessionId, nonce);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ComponentInteraction)) {
                return false;
            }
            ComponentInteraction componentInteraction = (ComponentInteraction) other;
            return this.type == componentInteraction.type && this.channelId == componentInteraction.channelId && this.applicationId == componentInteraction.applicationId && C12238m.areEqual(this.guildId, componentInteraction.guildId) && this.messageId == componentInteraction.messageId && C12238m.areEqual(this.messageFlags, componentInteraction.messageFlags) && C12238m.areEqual(this.data, componentInteraction.data) && C12238m.areEqual(this.sessionId, componentInteraction.sessionId) && C12238m.areEqual(this.nonce, componentInteraction.nonce);
        }

        public final long getApplicationId() {
            return this.applicationId;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final ComponentInteractionData getData() {
            return this.data;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final Long getMessageFlags() {
            return this.messageFlags;
        }

        public final long getMessageId() {
            return this.messageId;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final long getType() {
            return this.type;
        }

        public int hashCode() {
            long j = this.type;
            long j2 = this.channelId;
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.applicationId;
            int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            Long l = this.guildId;
            int iHashCode = l != null ? l.hashCode() : 0;
            long j4 = this.messageId;
            int i3 = (((i2 + iHashCode) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            Long l2 = this.messageFlags;
            int iHashCode2 = (i3 + (l2 != null ? l2.hashCode() : 0)) * 31;
            ComponentInteractionData componentInteractionData = this.data;
            int iHashCode3 = (iHashCode2 + (componentInteractionData != null ? componentInteractionData.hashCode() : 0)) * 31;
            String str = this.sessionId;
            int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.nonce;
            return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ComponentInteraction(type=");
            sbM833U.append(this.type);
            sbM833U.append(", channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", applicationId=");
            sbM833U.append(this.applicationId);
            sbM833U.append(", guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", messageId=");
            sbM833U.append(this.messageId);
            sbM833U.append(", messageFlags=");
            sbM833U.append(this.messageFlags);
            sbM833U.append(", data=");
            sbM833U.append(this.data);
            sbM833U.append(", sessionId=");
            sbM833U.append(this.sessionId);
            sbM833U.append(", nonce=");
            return C1643a.m822J(sbM833U, this.nonce, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static abstract class ComponentInteractionData {

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final /* data */ class ButtonComponentInteractionData extends ComponentInteractionData {
            private final ComponentType componentType;
            private final String customId;

            public /* synthetic */ ButtonComponentInteractionData(ComponentType componentType, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? ComponentType.BUTTON : componentType, str);
            }

            public static /* synthetic */ ButtonComponentInteractionData copy$default(ButtonComponentInteractionData buttonComponentInteractionData, ComponentType componentType, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    componentType = buttonComponentInteractionData.componentType;
                }
                if ((i & 2) != 0) {
                    str = buttonComponentInteractionData.customId;
                }
                return buttonComponentInteractionData.copy(componentType, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ComponentType getComponentType() {
                return this.componentType;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getCustomId() {
                return this.customId;
            }

            public final ButtonComponentInteractionData copy(ComponentType componentType, String customId) {
                C12238m.checkNotNullParameter(componentType, "componentType");
                C12238m.checkNotNullParameter(customId, "customId");
                return new ButtonComponentInteractionData(componentType, customId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ButtonComponentInteractionData)) {
                    return false;
                }
                ButtonComponentInteractionData buttonComponentInteractionData = (ButtonComponentInteractionData) other;
                return C12238m.areEqual(this.componentType, buttonComponentInteractionData.componentType) && C12238m.areEqual(this.customId, buttonComponentInteractionData.customId);
            }

            public final ComponentType getComponentType() {
                return this.componentType;
            }

            public final String getCustomId() {
                return this.customId;
            }

            public int hashCode() {
                ComponentType componentType = this.componentType;
                int iHashCode = (componentType != null ? componentType.hashCode() : 0) * 31;
                String str = this.customId;
                return iHashCode + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("ButtonComponentInteractionData(componentType=");
                sbM833U.append(this.componentType);
                sbM833U.append(", customId=");
                return C1643a.m822J(sbM833U, this.customId, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ButtonComponentInteractionData(ComponentType componentType, String str) {
                super(null);
                C12238m.checkNotNullParameter(componentType, "componentType");
                C12238m.checkNotNullParameter(str, "customId");
                this.componentType = componentType;
                this.customId = str;
            }
        }

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final /* data */ class SelectComponentInteractionData extends ComponentInteractionData {
            private final ComponentType componentType;
            private final String customId;
            private final List<String> values;

            public /* synthetic */ SelectComponentInteractionData(ComponentType componentType, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? ComponentType.SELECT : componentType, str, list);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SelectComponentInteractionData copy$default(SelectComponentInteractionData selectComponentInteractionData, ComponentType componentType, String str, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    componentType = selectComponentInteractionData.componentType;
                }
                if ((i & 2) != 0) {
                    str = selectComponentInteractionData.customId;
                }
                if ((i & 4) != 0) {
                    list = selectComponentInteractionData.values;
                }
                return selectComponentInteractionData.copy(componentType, str, list);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ComponentType getComponentType() {
                return this.componentType;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getCustomId() {
                return this.customId;
            }

            public final List<String> component3() {
                return this.values;
            }

            public final SelectComponentInteractionData copy(ComponentType componentType, String customId, List<String> values) {
                C12238m.checkNotNullParameter(componentType, "componentType");
                C12238m.checkNotNullParameter(customId, "customId");
                C12238m.checkNotNullParameter(values, "values");
                return new SelectComponentInteractionData(componentType, customId, values);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SelectComponentInteractionData)) {
                    return false;
                }
                SelectComponentInteractionData selectComponentInteractionData = (SelectComponentInteractionData) other;
                return C12238m.areEqual(this.componentType, selectComponentInteractionData.componentType) && C12238m.areEqual(this.customId, selectComponentInteractionData.customId) && C12238m.areEqual(this.values, selectComponentInteractionData.values);
            }

            public final ComponentType getComponentType() {
                return this.componentType;
            }

            public final String getCustomId() {
                return this.customId;
            }

            public final List<String> getValues() {
                return this.values;
            }

            public int hashCode() {
                ComponentType componentType = this.componentType;
                int iHashCode = (componentType != null ? componentType.hashCode() : 0) * 31;
                String str = this.customId;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                List<String> list = this.values;
                return iHashCode2 + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("SelectComponentInteractionData(componentType=");
                sbM833U.append(this.componentType);
                sbM833U.append(", customId=");
                sbM833U.append(this.customId);
                sbM833U.append(", values=");
                return C1643a.m824L(sbM833U, this.values, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SelectComponentInteractionData(ComponentType componentType, String str, List<String> list) {
                super(null);
                C12238m.checkNotNullParameter(componentType, "componentType");
                C12238m.checkNotNullParameter(str, "customId");
                C12238m.checkNotNullParameter(list, "values");
                this.componentType = componentType;
                this.customId = str;
                this.values = list;
            }
        }

        private ComponentInteractionData() {
        }

        public /* synthetic */ ComponentInteractionData(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class ConnectedAccount {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean friend_sync;
        private final String id;
        private final String name;
        private final boolean revoked;
        private final boolean show_activity;
        private final String type;
        private final boolean verified;
        private final int visibility;

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class Companion {
            private Companion() {
            }

            public final ConnectedAccount create(com.discord.api.connectedaccounts.ConnectedAccount connectedAccount, boolean syncFriends, boolean showActivity, int visibility) {
                C12238m.checkNotNullParameter(connectedAccount, "connectedAccount");
                return new ConnectedAccount(syncFriends, connectedAccount.getId(), connectedAccount.getName(), connectedAccount.getRevoked(), showActivity, connectedAccount.getType(), connectedAccount.getVerified(), visibility);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ConnectedAccount(boolean z2, String str, String str2, boolean z3, boolean z4, String str3, boolean z5, int i) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
            C12238m.checkNotNullParameter(str3, "type");
            this.friend_sync = z2;
            this.id = str;
            this.name = str2;
            this.revoked = z3;
            this.show_activity = z4;
            this.type = str3;
            this.verified = z5;
            this.visibility = i;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class ConnectedAccountContacts {
        private final boolean friend_sync;
        private final String name;

        public ConnectedAccountContacts(String str, boolean z2) {
            this.name = str;
            this.friend_sync = z2;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        private final boolean getFriend_sync() {
            return this.friend_sync;
        }

        public static /* synthetic */ ConnectedAccountContacts copy$default(ConnectedAccountContacts connectedAccountContacts, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = connectedAccountContacts.name;
            }
            if ((i & 2) != 0) {
                z2 = connectedAccountContacts.friend_sync;
            }
            return connectedAccountContacts.copy(str, z2);
        }

        public final ConnectedAccountContacts copy(String name, boolean friend_sync) {
            return new ConnectedAccountContacts(name, friend_sync);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConnectedAccountContacts)) {
                return false;
            }
            ConnectedAccountContacts connectedAccountContacts = (ConnectedAccountContacts) other;
            return C12238m.areEqual(this.name, connectedAccountContacts.name) && this.friend_sync == connectedAccountContacts.friend_sync;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.friend_sync;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ConnectedAccountContacts(name=");
            sbM833U.append(this.name);
            sbM833U.append(", friend_sync=");
            return C1643a.m827O(sbM833U, this.friend_sync, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class ConnectedAccountNameOnly {
        private final String name;

        /* JADX WARN: Multi-variable type inference failed */
        public ConnectedAccountNameOnly() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public ConnectedAccountNameOnly(String str) {
            this.name = str;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final String getName() {
            return this.name;
        }

        public static /* synthetic */ ConnectedAccountNameOnly copy$default(ConnectedAccountNameOnly connectedAccountNameOnly, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = connectedAccountNameOnly.name;
            }
            return connectedAccountNameOnly.copy(str);
        }

        public final ConnectedAccountNameOnly copy(String name) {
            return new ConnectedAccountNameOnly(name);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ConnectedAccountNameOnly) && C12238m.areEqual(this.name, ((ConnectedAccountNameOnly) other).name);
            }
            return true;
        }

        public int hashCode() {
            String str = this.name;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return C1643a.m822J(C1643a.m833U("ConnectedAccountNameOnly(name="), this.name, ")");
        }

        public /* synthetic */ ConnectedAccountNameOnly(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class ConnectionState {
        private final String code;
        private final Boolean fromContinuation;
        private final Boolean insecure;
        private final String state;

        public ConnectionState(String str, String str2, Boolean bool, Boolean bool2) {
            this.code = str;
            this.state = str2;
            this.fromContinuation = bool;
            this.insecure = bool2;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class Consents {
        private final List<String> grant;
        private final List<String> revoke;

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class Type {
            public static final Type INSTANCE = new Type();
            public static final String PERSONALIZATION = "personalization";
            public static final String USAGE_STATS = "usage_statistics";

            private Type() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Consents() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public Consents(List<String> list, List<String> list2) {
            C12238m.checkNotNullParameter(list, "grant");
            C12238m.checkNotNullParameter(list2, "revoke");
            this.grant = list;
            this.revoke = list2;
        }

        public /* synthetic */ Consents(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? C12147n.emptyList() : list, (i & 2) != 0 ? C12147n.emptyList() : list2);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class ContactEntry {
        private final String friend_id;
        private final Map<String, String> metadata;
        private final String mutual_id_hash;

        public ContactEntry(String str, String str2, Map<String, String> map) {
            C12238m.checkNotNullParameter(str, "mutual_id_hash");
            C12238m.checkNotNullParameter(str2, "friend_id");
            C12238m.checkNotNullParameter(map, "metadata");
            this.mutual_id_hash = str;
            this.friend_id = str2;
            this.metadata = map;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class CreateGuild {
        private final List<CreateGuildChannel> channels;
        private final String icon;
        private final String name;
        private final Long systemChannelId;

        public CreateGuild(String str, String str2, List<CreateGuildChannel> list, Long l) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.name = str;
            this.icon = str2;
            this.channels = list;
            this.systemChannelId = l;
        }

        public /* synthetic */ CreateGuild(String str, String str2, List list, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : l);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class CreateGuildChannel {
        private final Long id;
        private final String name;
        private final Long parentId;
        private final List<ChannelPermissionOverwrites> permissionOverwrites;
        private final String topic;
        private final int type;

        public CreateGuildChannel(int i, Long l, String str, Long l2, List<ChannelPermissionOverwrites> list, String str2) {
            this.type = i;
            this.id = l;
            this.name = str;
            this.parentId = l2;
            this.permissionOverwrites = list;
            this.topic = str2;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class CreateGuildFromTemplate {
        private final String icon;
        private final String name;

        public CreateGuildFromTemplate(String str, String str2) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.name = str;
            this.icon = str2;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class CreateGuildRoleSubscriptionGroupListing {
        private final String description;
        private final Boolean fullServerGate;
        private final String image;

        public CreateGuildRoleSubscriptionGroupListing(String str, String str2, Boolean bool) {
            this.image = str;
            this.description = str2;
            this.fullServerGate = bool;
        }

        public static /* synthetic */ CreateGuildRoleSubscriptionGroupListing copy$default(CreateGuildRoleSubscriptionGroupListing createGuildRoleSubscriptionGroupListing, String str, String str2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = createGuildRoleSubscriptionGroupListing.image;
            }
            if ((i & 2) != 0) {
                str2 = createGuildRoleSubscriptionGroupListing.description;
            }
            if ((i & 4) != 0) {
                bool = createGuildRoleSubscriptionGroupListing.fullServerGate;
            }
            return createGuildRoleSubscriptionGroupListing.copy(str, str2, bool);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getFullServerGate() {
            return this.fullServerGate;
        }

        public final CreateGuildRoleSubscriptionGroupListing copy(String image, String description, Boolean fullServerGate) {
            return new CreateGuildRoleSubscriptionGroupListing(image, description, fullServerGate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateGuildRoleSubscriptionGroupListing)) {
                return false;
            }
            CreateGuildRoleSubscriptionGroupListing createGuildRoleSubscriptionGroupListing = (CreateGuildRoleSubscriptionGroupListing) other;
            return C12238m.areEqual(this.image, createGuildRoleSubscriptionGroupListing.image) && C12238m.areEqual(this.description, createGuildRoleSubscriptionGroupListing.description) && C12238m.areEqual(this.fullServerGate, createGuildRoleSubscriptionGroupListing.fullServerGate);
        }

        public final String getDescription() {
            return this.description;
        }

        public final Boolean getFullServerGate() {
            return this.fullServerGate;
        }

        public final String getImage() {
            return this.image;
        }

        public int hashCode() {
            String str = this.image;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.description;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Boolean bool = this.fullServerGate;
            return iHashCode2 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("CreateGuildRoleSubscriptionGroupListing(image=");
            sbM833U.append(this.image);
            sbM833U.append(", description=");
            sbM833U.append(this.description);
            sbM833U.append(", fullServerGate=");
            return C1643a.m816D(sbM833U, this.fullServerGate, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class CreateGuildRoleSubscriptionTierListing {
        private final List<GuildRoleSubscriptionBenefit> benefits;
        private final boolean canAccessAllChannels;
        private final String description;
        private final String image;
        private final String name;
        private final int priceTier;

        public CreateGuildRoleSubscriptionTierListing(String str, String str2, String str3, List<GuildRoleSubscriptionBenefit> list, int i, boolean z2) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(list, "benefits");
            this.name = str;
            this.image = str2;
            this.description = str3;
            this.benefits = list;
            this.priceTier = i;
            this.canAccessAllChannels = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CreateGuildRoleSubscriptionTierListing copy$default(CreateGuildRoleSubscriptionTierListing createGuildRoleSubscriptionTierListing, String str, String str2, String str3, List list, int i, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = createGuildRoleSubscriptionTierListing.name;
            }
            if ((i2 & 2) != 0) {
                str2 = createGuildRoleSubscriptionTierListing.image;
            }
            String str4 = str2;
            if ((i2 & 4) != 0) {
                str3 = createGuildRoleSubscriptionTierListing.description;
            }
            String str5 = str3;
            if ((i2 & 8) != 0) {
                list = createGuildRoleSubscriptionTierListing.benefits;
            }
            List list2 = list;
            if ((i2 & 16) != 0) {
                i = createGuildRoleSubscriptionTierListing.priceTier;
            }
            int i3 = i;
            if ((i2 & 32) != 0) {
                z2 = createGuildRoleSubscriptionTierListing.canAccessAllChannels;
            }
            return createGuildRoleSubscriptionTierListing.copy(str, str4, str5, list2, i3, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        public final List<GuildRoleSubscriptionBenefit> component4() {
            return this.benefits;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getPriceTier() {
            return this.priceTier;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getCanAccessAllChannels() {
            return this.canAccessAllChannels;
        }

        public final CreateGuildRoleSubscriptionTierListing copy(String name, String image, String description, List<GuildRoleSubscriptionBenefit> benefits, int priceTier, boolean canAccessAllChannels) {
            C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(benefits, "benefits");
            return new CreateGuildRoleSubscriptionTierListing(name, image, description, benefits, priceTier, canAccessAllChannels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateGuildRoleSubscriptionTierListing)) {
                return false;
            }
            CreateGuildRoleSubscriptionTierListing createGuildRoleSubscriptionTierListing = (CreateGuildRoleSubscriptionTierListing) other;
            return C12238m.areEqual(this.name, createGuildRoleSubscriptionTierListing.name) && C12238m.areEqual(this.image, createGuildRoleSubscriptionTierListing.image) && C12238m.areEqual(this.description, createGuildRoleSubscriptionTierListing.description) && C12238m.areEqual(this.benefits, createGuildRoleSubscriptionTierListing.benefits) && this.priceTier == createGuildRoleSubscriptionTierListing.priceTier && this.canAccessAllChannels == createGuildRoleSubscriptionTierListing.canAccessAllChannels;
        }

        public final List<GuildRoleSubscriptionBenefit> getBenefits() {
            return this.benefits;
        }

        public final boolean getCanAccessAllChannels() {
            return this.canAccessAllChannels;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getImage() {
            return this.image;
        }

        public final String getName() {
            return this.name;
        }

        public final int getPriceTier() {
            return this.priceTier;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.image;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.description;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            List<GuildRoleSubscriptionBenefit> list = this.benefits;
            int iHashCode4 = (((iHashCode3 + (list != null ? list.hashCode() : 0)) * 31) + this.priceTier) * 31;
            boolean z2 = this.canAccessAllChannels;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode4 + r1;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("CreateGuildRoleSubscriptionTierListing(name=");
            sbM833U.append(this.name);
            sbM833U.append(", image=");
            sbM833U.append(this.image);
            sbM833U.append(", description=");
            sbM833U.append(this.description);
            sbM833U.append(", benefits=");
            sbM833U.append(this.benefits);
            sbM833U.append(", priceTier=");
            sbM833U.append(this.priceTier);
            sbM833U.append(", canAccessAllChannels=");
            return C1643a.m827O(sbM833U, this.canAccessAllChannels, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class CreateGuildScheduledEventBody {
        private final Boolean broadcastToDirectoryChannels;
        private final Long channelId;
        private final String description;
        private final GuildScheduledEventEntityMetadata entityMetadata;
        private final GuildScheduledEventEntityType entityType;
        private final String name;
        private final StageInstancePrivacyLevel privacyLevel;
        private final String scheduledEndTime;
        private final String scheduledStartTime;

        public CreateGuildScheduledEventBody(String str, String str2, StageInstancePrivacyLevel stageInstancePrivacyLevel, String str3, String str4, Long l, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata, Boolean bool) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(stageInstancePrivacyLevel, "privacyLevel");
            C12238m.checkNotNullParameter(str3, "scheduledStartTime");
            C12238m.checkNotNullParameter(guildScheduledEventEntityType, "entityType");
            this.name = str;
            this.description = str2;
            this.privacyLevel = stageInstancePrivacyLevel;
            this.scheduledStartTime = str3;
            this.scheduledEndTime = str4;
            this.channelId = l;
            this.entityType = guildScheduledEventEntityType;
            this.entityMetadata = guildScheduledEventEntityMetadata;
            this.broadcastToDirectoryChannels = bool;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final StageInstancePrivacyLevel getPrivacyLevel() {
            return this.privacyLevel;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getScheduledStartTime() {
            return this.scheduledStartTime;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getScheduledEndTime() {
            return this.scheduledEndTime;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Long getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final GuildScheduledEventEntityType getEntityType() {
            return this.entityType;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final GuildScheduledEventEntityMetadata getEntityMetadata() {
            return this.entityMetadata;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Boolean getBroadcastToDirectoryChannels() {
            return this.broadcastToDirectoryChannels;
        }

        public final CreateGuildScheduledEventBody copy(String name, String description, StageInstancePrivacyLevel privacyLevel, String scheduledStartTime, String scheduledEndTime, Long channelId, GuildScheduledEventEntityType entityType, GuildScheduledEventEntityMetadata entityMetadata, Boolean broadcastToDirectoryChannels) {
            C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(privacyLevel, "privacyLevel");
            C12238m.checkNotNullParameter(scheduledStartTime, "scheduledStartTime");
            C12238m.checkNotNullParameter(entityType, "entityType");
            return new CreateGuildScheduledEventBody(name, description, privacyLevel, scheduledStartTime, scheduledEndTime, channelId, entityType, entityMetadata, broadcastToDirectoryChannels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateGuildScheduledEventBody)) {
                return false;
            }
            CreateGuildScheduledEventBody createGuildScheduledEventBody = (CreateGuildScheduledEventBody) other;
            return C12238m.areEqual(this.name, createGuildScheduledEventBody.name) && C12238m.areEqual(this.description, createGuildScheduledEventBody.description) && C12238m.areEqual(this.privacyLevel, createGuildScheduledEventBody.privacyLevel) && C12238m.areEqual(this.scheduledStartTime, createGuildScheduledEventBody.scheduledStartTime) && C12238m.areEqual(this.scheduledEndTime, createGuildScheduledEventBody.scheduledEndTime) && C12238m.areEqual(this.channelId, createGuildScheduledEventBody.channelId) && C12238m.areEqual(this.entityType, createGuildScheduledEventBody.entityType) && C12238m.areEqual(this.entityMetadata, createGuildScheduledEventBody.entityMetadata) && C12238m.areEqual(this.broadcastToDirectoryChannels, createGuildScheduledEventBody.broadcastToDirectoryChannels);
        }

        public final Boolean getBroadcastToDirectoryChannels() {
            return this.broadcastToDirectoryChannels;
        }

        public final Long getChannelId() {
            return this.channelId;
        }

        public final String getDescription() {
            return this.description;
        }

        public final GuildScheduledEventEntityMetadata getEntityMetadata() {
            return this.entityMetadata;
        }

        public final GuildScheduledEventEntityType getEntityType() {
            return this.entityType;
        }

        public final String getName() {
            return this.name;
        }

        public final StageInstancePrivacyLevel getPrivacyLevel() {
            return this.privacyLevel;
        }

        public final String getScheduledEndTime() {
            return this.scheduledEndTime;
        }

        public final String getScheduledStartTime() {
            return this.scheduledStartTime;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.description;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            StageInstancePrivacyLevel stageInstancePrivacyLevel = this.privacyLevel;
            int iHashCode3 = (iHashCode2 + (stageInstancePrivacyLevel != null ? stageInstancePrivacyLevel.hashCode() : 0)) * 31;
            String str3 = this.scheduledStartTime;
            int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.scheduledEndTime;
            int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            Long l = this.channelId;
            int iHashCode6 = (iHashCode5 + (l != null ? l.hashCode() : 0)) * 31;
            GuildScheduledEventEntityType guildScheduledEventEntityType = this.entityType;
            int iHashCode7 = (iHashCode6 + (guildScheduledEventEntityType != null ? guildScheduledEventEntityType.hashCode() : 0)) * 31;
            GuildScheduledEventEntityMetadata guildScheduledEventEntityMetadata = this.entityMetadata;
            int iHashCode8 = (iHashCode7 + (guildScheduledEventEntityMetadata != null ? guildScheduledEventEntityMetadata.hashCode() : 0)) * 31;
            Boolean bool = this.broadcastToDirectoryChannels;
            return iHashCode8 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("CreateGuildScheduledEventBody(name=");
            sbM833U.append(this.name);
            sbM833U.append(", description=");
            sbM833U.append(this.description);
            sbM833U.append(", privacyLevel=");
            sbM833U.append(this.privacyLevel);
            sbM833U.append(", scheduledStartTime=");
            sbM833U.append(this.scheduledStartTime);
            sbM833U.append(", scheduledEndTime=");
            sbM833U.append(this.scheduledEndTime);
            sbM833U.append(", channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", entityType=");
            sbM833U.append(this.entityType);
            sbM833U.append(", entityMetadata=");
            sbM833U.append(this.entityMetadata);
            sbM833U.append(", broadcastToDirectoryChannels=");
            return C1643a.m816D(sbM833U, this.broadcastToDirectoryChannels, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class DeleteGuild {
        private final String code;

        public DeleteGuild(String str) {
            this.code = str;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class DeletePhone {
        private final String password;

        public DeletePhone(String str) {
            C12238m.checkNotNullParameter(str, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
            this.password = str;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class DisableAccount {
        private final String code;
        private final String password;

        public DisableAccount(String str, String str2) {
            C12238m.checkNotNullParameter(str, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
            this.password = str;
            this.code = str2;
        }

        public /* synthetic */ DisableAccount(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class DisableGuildCommunication {
        private final String communicationDisabledUntil;

        /* JADX WARN: Multi-variable type inference failed */
        public DisableGuildCommunication() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public DisableGuildCommunication(String str) {
            this.communicationDisabledUntil = str;
        }

        public /* synthetic */ DisableGuildCommunication(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class DowngradeSubscriptionBody {
        private final String purchaseToken;
        private final String subscriptionId;
        private final String subscriptionSkuId;

        public DowngradeSubscriptionBody(String str, String str2, String str3) {
            C1643a.m872q0(str, "subscriptionId", str2, "purchaseToken", str3, "subscriptionSkuId");
            this.subscriptionId = str;
            this.purchaseToken = str2;
            this.subscriptionSkuId = str3;
        }

        public static /* synthetic */ DowngradeSubscriptionBody copy$default(DowngradeSubscriptionBody downgradeSubscriptionBody, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = downgradeSubscriptionBody.subscriptionId;
            }
            if ((i & 2) != 0) {
                str2 = downgradeSubscriptionBody.purchaseToken;
            }
            if ((i & 4) != 0) {
                str3 = downgradeSubscriptionBody.subscriptionSkuId;
            }
            return downgradeSubscriptionBody.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSubscriptionId() {
            return this.subscriptionId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPurchaseToken() {
            return this.purchaseToken;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSubscriptionSkuId() {
            return this.subscriptionSkuId;
        }

        public final DowngradeSubscriptionBody copy(String subscriptionId, String purchaseToken, String subscriptionSkuId) {
            C12238m.checkNotNullParameter(subscriptionId, "subscriptionId");
            C12238m.checkNotNullParameter(purchaseToken, "purchaseToken");
            C12238m.checkNotNullParameter(subscriptionSkuId, "subscriptionSkuId");
            return new DowngradeSubscriptionBody(subscriptionId, purchaseToken, subscriptionSkuId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DowngradeSubscriptionBody)) {
                return false;
            }
            DowngradeSubscriptionBody downgradeSubscriptionBody = (DowngradeSubscriptionBody) other;
            return C12238m.areEqual(this.subscriptionId, downgradeSubscriptionBody.subscriptionId) && C12238m.areEqual(this.purchaseToken, downgradeSubscriptionBody.purchaseToken) && C12238m.areEqual(this.subscriptionSkuId, downgradeSubscriptionBody.subscriptionSkuId);
        }

        public final String getPurchaseToken() {
            return this.purchaseToken;
        }

        public final String getSubscriptionId() {
            return this.subscriptionId;
        }

        public final String getSubscriptionSkuId() {
            return this.subscriptionSkuId;
        }

        public int hashCode() {
            String str = this.subscriptionId;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.purchaseToken;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.subscriptionSkuId;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("DowngradeSubscriptionBody(subscriptionId=");
            sbM833U.append(this.subscriptionId);
            sbM833U.append(", purchaseToken=");
            sbM833U.append(this.purchaseToken);
            sbM833U.append(", subscriptionSkuId=");
            return C1643a.m822J(sbM833U, this.subscriptionSkuId, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class EmptyBody {
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class EnableIntegration {
        private final String id;
        private final String type;

        public EnableIntegration(String str, String str2) {
            this.type = str;
            this.id = str2;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class EnableMFA {
        private final String code;
        private final String password;
        private final String secret;

        public EnableMFA(String str, String str2, String str3) {
            C1643a.m872q0(str, ModelAuditLogEntry.CHANGE_KEY_CODE, str2, "secret", str3, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
            this.code = str;
            this.secret = str2;
            this.password = str3;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class ForgotPassword {
        private final String captchaKey;
        private final String captchaRqtoken;
        private final String login;

        public ForgotPassword(String str, String str2, String str3) {
            this.login = str;
            this.captchaKey = str2;
            this.captchaRqtoken = str3;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class GenerateGiftCode {
        private final long skuId;
        private final Long subscriptionPlanId;

        public GenerateGiftCode(long j, Long l) {
            this.skuId = j;
            this.subscriptionPlanId = l;
        }

        public final long getSkuId() {
            return this.skuId;
        }

        public final Long getSubscriptionPlanId() {
            return this.subscriptionPlanId;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class GetForumPostData {
        private final List<Long> threadIds;

        public GetForumPostData(List<Long> list) {
            C12238m.checkNotNullParameter(list, "threadIds");
            this.threadIds = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GetForumPostData copy$default(GetForumPostData getForumPostData, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = getForumPostData.threadIds;
            }
            return getForumPostData.copy(list);
        }

        public final List<Long> component1() {
            return this.threadIds;
        }

        public final GetForumPostData copy(List<Long> threadIds) {
            C12238m.checkNotNullParameter(threadIds, "threadIds");
            return new GetForumPostData(threadIds);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GetForumPostData) && C12238m.areEqual(this.threadIds, ((GetForumPostData) other).threadIds);
            }
            return true;
        }

        public final List<Long> getThreadIds() {
            return this.threadIds;
        }

        public int hashCode() {
            List<Long> list = this.threadIds;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        public String toString() {
            return C1643a.m824L(C1643a.m833U("GetForumPostData(threadIds="), this.threadIds, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class GreetMessage {
        private final List<Long> sticker_ids;

        public GreetMessage(List<Long> list) {
            C12238m.checkNotNullParameter(list, "sticker_ids");
            this.sticker_ids = list;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class GroupDM {
        private final String icon;
        private final String name;

        public GroupDM(String str, String str2) {
            this.name = str;
            this.icon = str2;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class GuildBoosting {
        private final List<Long> userPremiumGuildSubscriptionSlotIds;

        public GuildBoosting(List<Long> list) {
            C12238m.checkNotNullParameter(list, "userPremiumGuildSubscriptionSlotIds");
            this.userPremiumGuildSubscriptionSlotIds = list;
        }

        public final List<Long> getUserPremiumGuildSubscriptionSlotIds() {
            return this.userPremiumGuildSubscriptionSlotIds;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class GuildFeatureAck {
        private final Boolean manual;
        private final Integer mentionCount;

        public GuildFeatureAck(Boolean bool, Integer num) {
            this.manual = bool;
            this.mentionCount = num;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class GuildIntegration {
        private final boolean enableEmoticons;
        private final int expireBehavior;
        private final int expireGracePeriod;

        public GuildIntegration(int i, int i2, boolean z2) {
            this.expireBehavior = i;
            this.expireGracePeriod = i2;
            this.enableEmoticons = z2;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class GuildMFA {
        private final String code;
        private final int level;

        public GuildMFA(int i, String str) {
            this.level = i;
            this.code = str;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class GuildMember {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Long channelId;
        private final Boolean deaf;
        private final Boolean mute;
        private final String nick;
        private final List<Long> roles;

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class Companion {
            private Companion() {
            }

            public final GuildMember createWithChannelId(long channelId) {
                return new GuildMember(null, null, null, null, Long.valueOf(channelId), 15, null);
            }

            public final GuildMember createWithDeaf(boolean deaf) {
                return new GuildMember(null, null, null, Boolean.valueOf(deaf), null, 23, null);
            }

            public final GuildMember createWithMute(boolean mute) {
                return new GuildMember(null, null, Boolean.valueOf(mute), null, null, 27, null);
            }

            public final GuildMember createWithNick(String nick) {
                return new GuildMember(nick, null, null, null, null, 30, null);
            }

            public final GuildMember createWithRoles(List<Long> roles) {
                return new GuildMember(null, roles, null, null, null, 29, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public GuildMember() {
            this(null, null, null, null, null, 31, null);
        }

        public GuildMember(String str, List<Long> list, Boolean bool, Boolean bool2, Long l) {
            this.nick = str;
            this.roles = list;
            this.mute = bool;
            this.deaf = bool2;
            this.channelId = l;
        }

        public static final GuildMember createWithChannelId(long j) {
            return INSTANCE.createWithChannelId(j);
        }

        public static final GuildMember createWithDeaf(boolean z2) {
            return INSTANCE.createWithDeaf(z2);
        }

        public static final GuildMember createWithMute(boolean z2) {
            return INSTANCE.createWithMute(z2);
        }

        public static final GuildMember createWithNick(String str) {
            return INSTANCE.createWithNick(str);
        }

        public static final GuildMember createWithRoles(List<Long> list) {
            return INSTANCE.createWithRoles(list);
        }

        public /* synthetic */ GuildMember(String str, List list, Boolean bool, Boolean bool2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : l);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class GuildMemberDisconnect {
        private final Long channelId;

        /* JADX WARN: Multi-variable type inference failed */
        public GuildMemberDisconnect() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public GuildMemberDisconnect(Long l) {
            this.channelId = l;
        }

        public /* synthetic */ GuildMemberDisconnect(Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class HubWaitlist {
        private final String email;
        private final String school;

        public HubWaitlist(String str, String str2) {
            C12238m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
            C12238m.checkNotNullParameter(str2, "school");
            this.email = str;
            this.school = str2;
        }

        public static /* synthetic */ HubWaitlist copy$default(HubWaitlist hubWaitlist, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = hubWaitlist.email;
            }
            if ((i & 2) != 0) {
                str2 = hubWaitlist.school;
            }
            return hubWaitlist.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEmail() {
            return this.email;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSchool() {
            return this.school;
        }

        public final HubWaitlist copy(String email, String school) {
            C12238m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
            C12238m.checkNotNullParameter(school, "school");
            return new HubWaitlist(email, school);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HubWaitlist)) {
                return false;
            }
            HubWaitlist hubWaitlist = (HubWaitlist) other;
            return C12238m.areEqual(this.email, hubWaitlist.email) && C12238m.areEqual(this.school, hubWaitlist.school);
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getSchool() {
            return this.school;
        }

        public int hashCode() {
            String str = this.email;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.school;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("HubWaitlist(email=");
            sbM833U.append(this.email);
            sbM833U.append(", school=");
            return C1643a.m822J(sbM833U, this.school, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class Invite {
        private final int maxAge;
        private final int maxUses;
        private final String regenerate;
        private final boolean temporary;

        public Invite(int i, int i2, boolean z2, String str) {
            this.maxAge = i;
            this.maxUses = i2;
            this.temporary = z2;
            this.regenerate = str;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class InviteCode {
        private final String captchaKey;
        private final String captchaRqtoken;

        public InviteCode(String str, String str2) {
            this.captchaKey = str;
            this.captchaRqtoken = str2;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class InvoicePreviewBody {
        private final boolean applyEntitlements;
        private final boolean renewal;
        private final String subscriptionId;

        public InvoicePreviewBody(String str, boolean z2, boolean z3) {
            C12238m.checkNotNullParameter(str, "subscriptionId");
            this.subscriptionId = str;
            this.renewal = z2;
            this.applyEntitlements = z3;
        }

        public static /* synthetic */ InvoicePreviewBody copy$default(InvoicePreviewBody invoicePreviewBody, String str, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invoicePreviewBody.subscriptionId;
            }
            if ((i & 2) != 0) {
                z2 = invoicePreviewBody.renewal;
            }
            if ((i & 4) != 0) {
                z3 = invoicePreviewBody.applyEntitlements;
            }
            return invoicePreviewBody.copy(str, z2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSubscriptionId() {
            return this.subscriptionId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getRenewal() {
            return this.renewal;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getApplyEntitlements() {
            return this.applyEntitlements;
        }

        public final InvoicePreviewBody copy(String subscriptionId, boolean renewal, boolean applyEntitlements) {
            C12238m.checkNotNullParameter(subscriptionId, "subscriptionId");
            return new InvoicePreviewBody(subscriptionId, renewal, applyEntitlements);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvoicePreviewBody)) {
                return false;
            }
            InvoicePreviewBody invoicePreviewBody = (InvoicePreviewBody) other;
            return C12238m.areEqual(this.subscriptionId, invoicePreviewBody.subscriptionId) && this.renewal == invoicePreviewBody.renewal && this.applyEntitlements == invoicePreviewBody.applyEntitlements;
        }

        public final boolean getApplyEntitlements() {
            return this.applyEntitlements;
        }

        public final boolean getRenewal() {
            return this.renewal;
        }

        public final String getSubscriptionId() {
            return this.subscriptionId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            String str = this.subscriptionId;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.renewal;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode + r1) * 31;
            boolean z3 = this.applyEntitlements;
            return i + (z3 ? 1 : z3);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("InvoicePreviewBody(subscriptionId=");
            sbM833U.append(this.subscriptionId);
            sbM833U.append(", renewal=");
            sbM833U.append(this.renewal);
            sbM833U.append(", applyEntitlements=");
            return C1643a.m827O(sbM833U, this.applyEntitlements, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class LeaveGuildBody {
        private final boolean lurking;

        public LeaveGuildBody() {
            this(false, 1, null);
        }

        public LeaveGuildBody(boolean z2) {
            this.lurking = z2;
        }

        public static /* synthetic */ LeaveGuildBody copy$default(LeaveGuildBody leaveGuildBody, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = leaveGuildBody.lurking;
            }
            return leaveGuildBody.copy(z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getLurking() {
            return this.lurking;
        }

        public final LeaveGuildBody copy(boolean lurking) {
            return new LeaveGuildBody(lurking);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof LeaveGuildBody) && this.lurking == ((LeaveGuildBody) other).lurking;
            }
            return true;
        }

        public final boolean getLurking() {
            return this.lurking;
        }

        public int hashCode() {
            boolean z2 = this.lurking;
            if (z2) {
                return 1;
            }
            return z2 ? 1 : 0;
        }

        public String toString() {
            return C1643a.m827O(C1643a.m833U("LeaveGuildBody(lurking="), this.lurking, ")");
        }

        public /* synthetic */ LeaveGuildBody(boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class MFALogin {
        private final String code;
        private final String ticket;

        public MFALogin(String str, String str2) {
            this.ticket = str;
            this.code = str2;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class MemberVerificationForm {
        private final List<ModelMemberVerificationForm.FormField> formFields;
        private final String version;

        /* JADX WARN: Multi-variable type inference failed */
        public MemberVerificationForm() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public MemberVerificationForm(List<ModelMemberVerificationForm.FormField> list, String str) {
            this.formFields = list;
            this.version = str;
        }

        public /* synthetic */ MemberVerificationForm(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class Message {
        private final Activity activity;
        private final AllowedMentions allowedMentions;
        private final Long applicationId;
        private final String captchaKey;
        private final String captchaRqtoken;
        private final String content;
        private final MessageReference messageReference;
        private final String nonce;
        private final List<Long> stickerIds;

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class Activity {
            private final String partyId;
            private final String sessionId;
            private final MessageActivityType type;

            public Activity(MessageActivityType messageActivityType, String str, String str2) {
                C12238m.checkNotNullParameter(messageActivityType, "type");
                C12238m.checkNotNullParameter(str, "partyId");
                C12238m.checkNotNullParameter(str2, "sessionId");
                this.type = messageActivityType;
                this.partyId = str;
                this.sessionId = str2;
            }

            public final String getPartyId() {
                return this.partyId;
            }

            public final String getSessionId() {
                return this.sessionId;
            }

            public final MessageActivityType getType() {
                return this.type;
            }
        }

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class AllowedMentions {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final List<String> parse;
            private final Boolean repliedUser;
            private final List<Long> roles;
            private final List<Long> users;

            /* JADX INFO: compiled from: RestAPIParams.kt */
            public static final class Companion {
                private Companion() {
                }

                public final AllowedMentions create(MessageAllowedMentions model) {
                    ArrayList arrayList;
                    C12238m.checkNotNullParameter(model, "model");
                    List<MessageAllowedMentionsTypes> listM8060a = model.m8060a();
                    if (listM8060a != null) {
                        arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listM8060a, 10));
                        Iterator<T> it = listM8060a.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((MessageAllowedMentionsTypes) it.next()).getApiStringRepresentation());
                        }
                    } else {
                        arrayList = null;
                    }
                    return new AllowedMentions(arrayList, model.m8063d(), model.m8062c(), model.getRepliedUser());
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public AllowedMentions(List<String> list, List<Long> list2, List<Long> list3, Boolean bool) {
                this.parse = list;
                this.users = list2;
                this.roles = list3;
                this.repliedUser = bool;
            }

            public final List<String> getParse() {
                return this.parse;
            }

            public final Boolean getRepliedUser() {
                return this.repliedUser;
            }

            public final List<Long> getRoles() {
                return this.roles;
            }

            public final List<Long> getUsers() {
                return this.users;
            }
        }

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class MessageReference {
            private final long channelId;
            private final Long guildId;
            private final Long messageId;

            public MessageReference(Long l, long j, Long l2) {
                this.guildId = l;
                this.channelId = j;
                this.messageId = l2;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public final Long getMessageId() {
                return this.messageId;
            }
        }

        public Message(String str, String str2, Long l, Activity activity, List<Long> list, MessageReference messageReference, AllowedMentions allowedMentions, String str3, String str4) {
            this.content = str;
            this.nonce = str2;
            this.applicationId = l;
            this.activity = activity;
            this.stickerIds = list;
            this.messageReference = messageReference;
            this.allowedMentions = allowedMentions;
            this.captchaKey = str3;
            this.captchaRqtoken = str4;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getNonce() {
            return this.nonce;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getApplicationId() {
            return this.applicationId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Activity getActivity() {
            return this.activity;
        }

        public final List<Long> component5() {
            return this.stickerIds;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final MessageReference getMessageReference() {
            return this.messageReference;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final AllowedMentions getAllowedMentions() {
            return this.allowedMentions;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getCaptchaKey() {
            return this.captchaKey;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getCaptchaRqtoken() {
            return this.captchaRqtoken;
        }

        public final Message copy(String content, String nonce, Long applicationId, Activity activity, List<Long> stickerIds, MessageReference messageReference, AllowedMentions allowedMentions, String captchaKey, String captchaRqtoken) {
            return new Message(content, nonce, applicationId, activity, stickerIds, messageReference, allowedMentions, captchaKey, captchaRqtoken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Message)) {
                return false;
            }
            Message message = (Message) other;
            return C12238m.areEqual(this.content, message.content) && C12238m.areEqual(this.nonce, message.nonce) && C12238m.areEqual(this.applicationId, message.applicationId) && C12238m.areEqual(this.activity, message.activity) && C12238m.areEqual(this.stickerIds, message.stickerIds) && C12238m.areEqual(this.messageReference, message.messageReference) && C12238m.areEqual(this.allowedMentions, message.allowedMentions) && C12238m.areEqual(this.captchaKey, message.captchaKey) && C12238m.areEqual(this.captchaRqtoken, message.captchaRqtoken);
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final AllowedMentions getAllowedMentions() {
            return this.allowedMentions;
        }

        public final Long getApplicationId() {
            return this.applicationId;
        }

        public final String getCaptchaKey() {
            return this.captchaKey;
        }

        public final String getCaptchaRqtoken() {
            return this.captchaRqtoken;
        }

        public final String getContent() {
            return this.content;
        }

        public final MessageReference getMessageReference() {
            return this.messageReference;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public final List<Long> getStickerIds() {
            return this.stickerIds;
        }

        public int hashCode() {
            String str = this.content;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.nonce;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Long l = this.applicationId;
            int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
            Activity activity = this.activity;
            int iHashCode4 = (iHashCode3 + (activity != null ? activity.hashCode() : 0)) * 31;
            List<Long> list = this.stickerIds;
            int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
            MessageReference messageReference = this.messageReference;
            int iHashCode6 = (iHashCode5 + (messageReference != null ? messageReference.hashCode() : 0)) * 31;
            AllowedMentions allowedMentions = this.allowedMentions;
            int iHashCode7 = (iHashCode6 + (allowedMentions != null ? allowedMentions.hashCode() : 0)) * 31;
            String str3 = this.captchaKey;
            int iHashCode8 = (iHashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.captchaRqtoken;
            return iHashCode8 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Message(content=");
            sbM833U.append(this.content);
            sbM833U.append(", nonce=");
            sbM833U.append(this.nonce);
            sbM833U.append(", applicationId=");
            sbM833U.append(this.applicationId);
            sbM833U.append(", activity=");
            sbM833U.append(this.activity);
            sbM833U.append(", stickerIds=");
            sbM833U.append(this.stickerIds);
            sbM833U.append(", messageReference=");
            sbM833U.append(this.messageReference);
            sbM833U.append(", allowedMentions=");
            sbM833U.append(this.allowedMentions);
            sbM833U.append(", captchaKey=");
            sbM833U.append(this.captchaKey);
            sbM833U.append(", captchaRqtoken=");
            return C1643a.m822J(sbM833U, this.captchaRqtoken, ")");
        }

        public /* synthetic */ Message(String str, String str2, Long l, Activity activity, List list, MessageReference messageReference, AllowedMentions allowedMentions, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : activity, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : messageReference, (i & 64) != 0 ? null : allowedMentions, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : str4);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class ModalInteraction {
        private final long applicationId;
        private final long channelId;
        private final ModalInteractionData data;
        private final Long guildId;
        private final Long messageId;
        private final long nonce;
        private final String sessionId;
        private final long type;

        public ModalInteraction(long j, long j2, Long l, long j3, Long l2, String str, long j4, ModalInteractionData modalInteractionData) {
            C12238m.checkNotNullParameter(modalInteractionData, "data");
            this.type = j;
            this.applicationId = j2;
            this.messageId = l;
            this.channelId = j3;
            this.guildId = l2;
            this.sessionId = str;
            this.nonce = j4;
            this.data = modalInteractionData;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getApplicationId() {
            return this.applicationId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getMessageId() {
            return this.messageId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final long getNonce() {
            return this.nonce;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final ModalInteractionData getData() {
            return this.data;
        }

        public final ModalInteraction copy(long type, long applicationId, Long messageId, long channelId, Long guildId, String sessionId, long nonce, ModalInteractionData data) {
            C12238m.checkNotNullParameter(data, "data");
            return new ModalInteraction(type, applicationId, messageId, channelId, guildId, sessionId, nonce, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModalInteraction)) {
                return false;
            }
            ModalInteraction modalInteraction = (ModalInteraction) other;
            return this.type == modalInteraction.type && this.applicationId == modalInteraction.applicationId && C12238m.areEqual(this.messageId, modalInteraction.messageId) && this.channelId == modalInteraction.channelId && C12238m.areEqual(this.guildId, modalInteraction.guildId) && C12238m.areEqual(this.sessionId, modalInteraction.sessionId) && this.nonce == modalInteraction.nonce && C12238m.areEqual(this.data, modalInteraction.data);
        }

        public final long getApplicationId() {
            return this.applicationId;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final ModalInteractionData getData() {
            return this.data;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final Long getMessageId() {
            return this.messageId;
        }

        public final long getNonce() {
            return this.nonce;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final long getType() {
            return this.type;
        }

        public int hashCode() {
            long j = this.type;
            long j2 = this.applicationId;
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            Long l = this.messageId;
            int iHashCode = l != null ? l.hashCode() : 0;
            long j3 = this.channelId;
            int i2 = (((i + iHashCode) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            Long l2 = this.guildId;
            int iHashCode2 = (i2 + (l2 != null ? l2.hashCode() : 0)) * 31;
            String str = this.sessionId;
            int iHashCode3 = str != null ? str.hashCode() : 0;
            long j4 = this.nonce;
            int i3 = (((iHashCode2 + iHashCode3) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            ModalInteractionData modalInteractionData = this.data;
            return i3 + (modalInteractionData != null ? modalInteractionData.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ModalInteraction(type=");
            sbM833U.append(this.type);
            sbM833U.append(", applicationId=");
            sbM833U.append(this.applicationId);
            sbM833U.append(", messageId=");
            sbM833U.append(this.messageId);
            sbM833U.append(", channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", sessionId=");
            sbM833U.append(this.sessionId);
            sbM833U.append(", nonce=");
            sbM833U.append(this.nonce);
            sbM833U.append(", data=");
            sbM833U.append(this.data);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class ModalInteractionData {
        private final List<ModalInteractionDataComponent> components;
        private final String customId;
        private final long id;

        public ModalInteractionData(long j, String str, List<ModalInteractionDataComponent> list) {
            C12238m.checkNotNullParameter(str, "customId");
            C12238m.checkNotNullParameter(list, "components");
            this.id = j;
            this.customId = str;
            this.components = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ModalInteractionData copy$default(ModalInteractionData modalInteractionData, long j, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = modalInteractionData.id;
            }
            if ((i & 2) != 0) {
                str = modalInteractionData.customId;
            }
            if ((i & 4) != 0) {
                list = modalInteractionData.components;
            }
            return modalInteractionData.copy(j, str, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCustomId() {
            return this.customId;
        }

        public final List<ModalInteractionDataComponent> component3() {
            return this.components;
        }

        public final ModalInteractionData copy(long id2, String customId, List<ModalInteractionDataComponent> components) {
            C12238m.checkNotNullParameter(customId, "customId");
            C12238m.checkNotNullParameter(components, "components");
            return new ModalInteractionData(id2, customId, components);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModalInteractionData)) {
                return false;
            }
            ModalInteractionData modalInteractionData = (ModalInteractionData) other;
            return this.id == modalInteractionData.id && C12238m.areEqual(this.customId, modalInteractionData.customId) && C12238m.areEqual(this.components, modalInteractionData.components);
        }

        public final List<ModalInteractionDataComponent> getComponents() {
            return this.components;
        }

        public final String getCustomId() {
            return this.customId;
        }

        public final long getId() {
            return this.id;
        }

        public int hashCode() {
            long j = this.id;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.customId;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            List<ModalInteractionDataComponent> list = this.components;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ModalInteractionData(id=");
            sbM833U.append(this.id);
            sbM833U.append(", customId=");
            sbM833U.append(this.customId);
            sbM833U.append(", components=");
            return C1643a.m824L(sbM833U, this.components, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class ModalInteractionDataComponent {
        private final List<ModalInteractionDataComponent> components;
        private final String customId;
        private final ComponentType type;
        private final String value;

        public ModalInteractionDataComponent(ComponentType componentType, List<ModalInteractionDataComponent> list, String str, String str2) {
            C12238m.checkNotNullParameter(componentType, "type");
            this.type = componentType;
            this.components = list;
            this.customId = str;
            this.value = str2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ModalInteractionDataComponent copy$default(ModalInteractionDataComponent modalInteractionDataComponent, ComponentType componentType, List list, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                componentType = modalInteractionDataComponent.type;
            }
            if ((i & 2) != 0) {
                list = modalInteractionDataComponent.components;
            }
            if ((i & 4) != 0) {
                str = modalInteractionDataComponent.customId;
            }
            if ((i & 8) != 0) {
                str2 = modalInteractionDataComponent.value;
            }
            return modalInteractionDataComponent.copy(componentType, list, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ComponentType getType() {
            return this.type;
        }

        public final List<ModalInteractionDataComponent> component2() {
            return this.components;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getCustomId() {
            return this.customId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final ModalInteractionDataComponent copy(ComponentType type, List<ModalInteractionDataComponent> components, String customId, String value) {
            C12238m.checkNotNullParameter(type, "type");
            return new ModalInteractionDataComponent(type, components, customId, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModalInteractionDataComponent)) {
                return false;
            }
            ModalInteractionDataComponent modalInteractionDataComponent = (ModalInteractionDataComponent) other;
            return C12238m.areEqual(this.type, modalInteractionDataComponent.type) && C12238m.areEqual(this.components, modalInteractionDataComponent.components) && C12238m.areEqual(this.customId, modalInteractionDataComponent.customId) && C12238m.areEqual(this.value, modalInteractionDataComponent.value);
        }

        public final List<ModalInteractionDataComponent> getComponents() {
            return this.components;
        }

        public final String getCustomId() {
            return this.customId;
        }

        public final ComponentType getType() {
            return this.type;
        }

        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            ComponentType componentType = this.type;
            int iHashCode = (componentType != null ? componentType.hashCode() : 0) * 31;
            List<ModalInteractionDataComponent> list = this.components;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            String str = this.customId;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.value;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ModalInteractionDataComponent(type=");
            sbM833U.append(this.type);
            sbM833U.append(", components=");
            sbM833U.append(this.components);
            sbM833U.append(", customId=");
            sbM833U.append(this.customId);
            sbM833U.append(", value=");
            return C1643a.m822J(sbM833U, this.value, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class Nick {
        private final String nick;

        public Nick(String str) {
            this.nick = str;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class OAuth2Authorize {
        public static final OAuth2Authorize INSTANCE = new OAuth2Authorize();

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class ResponseGet {
            private final Application application;
            private final List<ConnectedAccount> connections;
            private final List<Guild> guilds;
            private final User user;

            public ResponseGet(User user, Application application, List<ConnectedAccount> list, List<Guild> list2) {
                C12238m.checkNotNullParameter(user, "user");
                C12238m.checkNotNullParameter(application, "application");
                C12238m.checkNotNullParameter(list, "connections");
                C12238m.checkNotNullParameter(list2, "guilds");
                this.user = user;
                this.application = application;
                this.connections = list;
                this.guilds = list2;
            }

            public final Application getApplication() {
                return this.application;
            }

            public final List<ConnectedAccount> getConnections() {
                return this.connections;
            }

            public final List<Guild> getGuilds() {
                return this.guilds;
            }

            public final User getUser() {
                return this.user;
            }
        }

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class ResponsePost {
            private final String location;

            public ResponsePost(String str) {
                C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
                this.location = str;
            }

            public final String getLocation() {
                return this.location;
            }
        }

        private OAuth2Authorize() {
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class PatchGuildEmoji {
        private final String name;

        public PatchGuildEmoji(String str) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.name = str;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class Phone {
        private final String captchaKey;
        private final String captchaRqtoken;
        private final String phone;
        private final String source;

        public Phone(String str, String str2, String str3, String str4) {
            this.phone = str;
            this.source = str2;
            this.captchaKey = str3;
            this.captchaRqtoken = str4;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class PostGuildEmoji {
        private final String image;
        private final String name;

        public PostGuildEmoji(String str, String str2) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(str2, "image");
            this.name = str;
            this.image = str2;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class PruneGuild {
        private final Boolean computePruneCount;
        private final Integer days;

        /* JADX WARN: Multi-variable type inference failed */
        public PruneGuild() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public PruneGuild(Integer num, Boolean bool) {
            this.days = num;
            this.computePruneCount = bool;
        }

        public /* synthetic */ PruneGuild(Integer num, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? Boolean.FALSE : bool);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class PurchaseMetadataBody {
        private final String paymentGatewaySkuId;
        private final long skuId;

        public PurchaseMetadataBody(long j, String str) {
            C12238m.checkNotNullParameter(str, "paymentGatewaySkuId");
            this.skuId = j;
            this.paymentGatewaySkuId = str;
        }

        public static /* synthetic */ PurchaseMetadataBody copy$default(PurchaseMetadataBody purchaseMetadataBody, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = purchaseMetadataBody.skuId;
            }
            if ((i & 2) != 0) {
                str = purchaseMetadataBody.paymentGatewaySkuId;
            }
            return purchaseMetadataBody.copy(j, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getSkuId() {
            return this.skuId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPaymentGatewaySkuId() {
            return this.paymentGatewaySkuId;
        }

        public final PurchaseMetadataBody copy(long skuId, String paymentGatewaySkuId) {
            C12238m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
            return new PurchaseMetadataBody(skuId, paymentGatewaySkuId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PurchaseMetadataBody)) {
                return false;
            }
            PurchaseMetadataBody purchaseMetadataBody = (PurchaseMetadataBody) other;
            return this.skuId == purchaseMetadataBody.skuId && C12238m.areEqual(this.paymentGatewaySkuId, purchaseMetadataBody.paymentGatewaySkuId);
        }

        public final String getPaymentGatewaySkuId() {
            return this.paymentGatewaySkuId;
        }

        public final long getSkuId() {
            return this.skuId;
        }

        public int hashCode() {
            long j = this.skuId;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.paymentGatewaySkuId;
            return i + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("PurchaseMetadataBody(skuId=");
            sbM833U.append(this.skuId);
            sbM833U.append(", paymentGatewaySkuId=");
            return C1643a.m822J(sbM833U, this.paymentGatewaySkuId, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class RemoteAuthCancel {
        private final String handshakeToken;

        public RemoteAuthCancel(String str) {
            C12238m.checkNotNullParameter(str, "handshakeToken");
            this.handshakeToken = str;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class RemoteAuthFinish {
        private final String handshakeToken;
        private final boolean temporary;

        public RemoteAuthFinish(boolean z2, String str) {
            C12238m.checkNotNullParameter(str, "handshakeToken");
            this.temporary = z2;
            this.handshakeToken = str;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class RemoteAuthInitialize {
        private final String fingerprint;

        public RemoteAuthInitialize(String str) {
            C12238m.checkNotNullParameter(str, "fingerprint");
            this.fingerprint = str;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class Report {
        private final Long channelId;
        private final Long messageId;
        private final int reason;

        public Report(int i, Long l, Long l2) {
            this.reason = i;
            this.channelId = l;
            this.messageId = l2;
        }

        public /* synthetic */ Report(int i, Long l, Long l2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : l, (i2 & 4) != 0 ? null : l2);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class Ring {
        private final List<Long> recipients;

        public Ring(List<Long> list) {
            this.recipients = list;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class Role {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private Integer color;
        private Boolean hoist;
        private String icon;
        private long id;
        private Boolean mentionable;
        private String name;
        private Long permissions;
        private Integer position;

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Role createForPosition(long id2, int position) {
                return new Role(null, null, null, null, Integer.valueOf(position), null, id2, null, 175, null);
            }

            public final Role createWithRole(GuildRole role) {
                C12238m.checkNotNullParameter(role, "role");
                return new Role(Boolean.valueOf(role.getHoist()), role.getName(), Boolean.valueOf(role.getMentionable()), Integer.valueOf(role.getColor()), Integer.valueOf(role.getPosition()), Long.valueOf(role.getPermissions()), role.getId(), null, 128, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Role() {
            this(null, null, null, null, null, null, 0L, null, 255, null);
        }

        public Role(Boolean bool, String str, Boolean bool2, Integer num, Integer num2, Long l, long j, String str2) {
            this.hoist = bool;
            this.name = str;
            this.mentionable = bool2;
            this.color = num;
            this.position = num2;
            this.permissions = l;
            this.id = j;
            this.icon = str2;
        }

        public static final Role createForPosition(long j, int i) {
            return INSTANCE.createForPosition(j, i);
        }

        public static final Role createWithRole(GuildRole guildRole) {
            return INSTANCE.createWithRole(guildRole);
        }

        public final Integer getColor() {
            return this.color;
        }

        public final Boolean getHoist() {
            return this.hoist;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final long getId() {
            return this.id;
        }

        public final Boolean getMentionable() {
            return this.mentionable;
        }

        public final String getName() {
            return this.name;
        }

        public final Long getPermissions() {
            return this.permissions;
        }

        public final Integer getPosition() {
            return this.position;
        }

        public final void setColor(Integer num) {
            this.color = num;
        }

        public final void setHoist(Boolean bool) {
            this.hoist = bool;
        }

        public final void setIcon(String str) {
            this.icon = str;
        }

        public final void setId(long j) {
            this.id = j;
        }

        public final void setMentionable(Boolean bool) {
            this.mentionable = bool;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final void setPermissions(Long l) {
            this.permissions = l;
        }

        public final void setPosition(Integer num) {
            this.position = num;
        }

        public /* synthetic */ Role(Boolean bool, String str, Boolean bool2, Integer num, Integer num2, Long l, long j, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : l, (i & 64) != 0 ? 0L : j, (i & 128) == 0 ? str2 : null);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class StartStageInstanceBody {
        private final long channelId;
        private final String guildScheduledEventId;
        private final StageInstancePrivacyLevel privacyLevel;
        private final boolean sendStartNotification;
        private final String topic;

        public StartStageInstanceBody(long j, String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, boolean z2, String str2) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
            C12238m.checkNotNullParameter(stageInstancePrivacyLevel, "privacyLevel");
            this.channelId = j;
            this.topic = str;
            this.privacyLevel = stageInstancePrivacyLevel;
            this.sendStartNotification = z2;
            this.guildScheduledEventId = str2;
        }

        public static /* synthetic */ StartStageInstanceBody copy$default(StartStageInstanceBody startStageInstanceBody, long j, String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, boolean z2, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = startStageInstanceBody.channelId;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = startStageInstanceBody.topic;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                stageInstancePrivacyLevel = startStageInstanceBody.privacyLevel;
            }
            StageInstancePrivacyLevel stageInstancePrivacyLevel2 = stageInstancePrivacyLevel;
            if ((i & 8) != 0) {
                z2 = startStageInstanceBody.sendStartNotification;
            }
            boolean z3 = z2;
            if ((i & 16) != 0) {
                str2 = startStageInstanceBody.guildScheduledEventId;
            }
            return startStageInstanceBody.copy(j2, str3, stageInstancePrivacyLevel2, z3, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTopic() {
            return this.topic;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final StageInstancePrivacyLevel getPrivacyLevel() {
            return this.privacyLevel;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getSendStartNotification() {
            return this.sendStartNotification;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getGuildScheduledEventId() {
            return this.guildScheduledEventId;
        }

        public final StartStageInstanceBody copy(long channelId, String topic, StageInstancePrivacyLevel privacyLevel, boolean sendStartNotification, String guildScheduledEventId) {
            C12238m.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
            C12238m.checkNotNullParameter(privacyLevel, "privacyLevel");
            return new StartStageInstanceBody(channelId, topic, privacyLevel, sendStartNotification, guildScheduledEventId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartStageInstanceBody)) {
                return false;
            }
            StartStageInstanceBody startStageInstanceBody = (StartStageInstanceBody) other;
            return this.channelId == startStageInstanceBody.channelId && C12238m.areEqual(this.topic, startStageInstanceBody.topic) && C12238m.areEqual(this.privacyLevel, startStageInstanceBody.privacyLevel) && this.sendStartNotification == startStageInstanceBody.sendStartNotification && C12238m.areEqual(this.guildScheduledEventId, startStageInstanceBody.guildScheduledEventId);
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final String getGuildScheduledEventId() {
            return this.guildScheduledEventId;
        }

        public final StageInstancePrivacyLevel getPrivacyLevel() {
            return this.privacyLevel;
        }

        public final boolean getSendStartNotification() {
            return this.sendStartNotification;
        }

        public final String getTopic() {
            return this.topic;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6, types: [int] */
        public int hashCode() {
            long j = this.channelId;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.topic;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            StageInstancePrivacyLevel stageInstancePrivacyLevel = this.privacyLevel;
            int iHashCode2 = (iHashCode + (stageInstancePrivacyLevel != null ? stageInstancePrivacyLevel.hashCode() : 0)) * 31;
            boolean z2 = this.sendStartNotification;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i2 = (iHashCode2 + r0) * 31;
            String str2 = this.guildScheduledEventId;
            return i2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StartStageInstanceBody(channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", topic=");
            sbM833U.append(this.topic);
            sbM833U.append(", privacyLevel=");
            sbM833U.append(this.privacyLevel);
            sbM833U.append(", sendStartNotification=");
            sbM833U.append(this.sendStartNotification);
            sbM833U.append(", guildScheduledEventId=");
            return C1643a.m822J(sbM833U, this.guildScheduledEventId, ")");
        }

        public /* synthetic */ StartStageInstanceBody(long j, String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, boolean z2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, str, stageInstancePrivacyLevel, z2, (i & 16) != 0 ? null : str2);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class TextChannel {
        private final Integer defaultAutoArchiveDuration;
        private final String name;
        private final Boolean nsfw;
        private final Integer rateLimitPerUser;
        private final String topic;
        private final Integer type;

        public TextChannel(String str, Integer num, String str2, Boolean bool, Integer num2, Integer num3) {
            this.name = str;
            this.type = num;
            this.topic = str2;
            this.nsfw = bool;
            this.rateLimitPerUser = num2;
            this.defaultAutoArchiveDuration = num3;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class ThreadCreationSettings {
        private final Integer autoArchiveDuration;
        private final String name;
        private final int type;

        public ThreadCreationSettings(String str, int i, Integer num) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.name = str;
            this.type = i;
            this.autoArchiveDuration = num;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        private final int getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        private final Integer getAutoArchiveDuration() {
            return this.autoArchiveDuration;
        }

        public static /* synthetic */ ThreadCreationSettings copy$default(ThreadCreationSettings threadCreationSettings, String str, int i, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = threadCreationSettings.name;
            }
            if ((i2 & 2) != 0) {
                i = threadCreationSettings.type;
            }
            if ((i2 & 4) != 0) {
                num = threadCreationSettings.autoArchiveDuration;
            }
            return threadCreationSettings.copy(str, i, num);
        }

        public final ThreadCreationSettings copy(String name, int type, Integer autoArchiveDuration) {
            C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return new ThreadCreationSettings(name, type, autoArchiveDuration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThreadCreationSettings)) {
                return false;
            }
            ThreadCreationSettings threadCreationSettings = (ThreadCreationSettings) other;
            return C12238m.areEqual(this.name, threadCreationSettings.name) && this.type == threadCreationSettings.type && C12238m.areEqual(this.autoArchiveDuration, threadCreationSettings.autoArchiveDuration);
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.type) * 31;
            Integer num = this.autoArchiveDuration;
            return iHashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ThreadCreationSettings(name=");
            sbM833U.append(this.name);
            sbM833U.append(", type=");
            sbM833U.append(this.type);
            sbM833U.append(", autoArchiveDuration=");
            return C1643a.m818F(sbM833U, this.autoArchiveDuration, ")");
        }

        public /* synthetic */ ThreadCreationSettings(String str, int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, (i2 & 4) != 0 ? null : num);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class ThreadMemberSettings {
        private final Integer flags;
        private final ModelMuteConfig muteConfig;
        private final Boolean muted;

        public ThreadMemberSettings() {
            this(null, null, null, 7, null);
        }

        public ThreadMemberSettings(Integer num, Boolean bool, ModelMuteConfig modelMuteConfig) {
            this.flags = num;
            this.muted = bool;
            this.muteConfig = modelMuteConfig;
        }

        public static /* synthetic */ ThreadMemberSettings copy$default(ThreadMemberSettings threadMemberSettings, Integer num, Boolean bool, ModelMuteConfig modelMuteConfig, int i, Object obj) {
            if ((i & 1) != 0) {
                num = threadMemberSettings.flags;
            }
            if ((i & 2) != 0) {
                bool = threadMemberSettings.muted;
            }
            if ((i & 4) != 0) {
                modelMuteConfig = threadMemberSettings.muteConfig;
            }
            return threadMemberSettings.copy(num, bool, modelMuteConfig);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getFlags() {
            return this.flags;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getMuted() {
            return this.muted;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ModelMuteConfig getMuteConfig() {
            return this.muteConfig;
        }

        public final ThreadMemberSettings copy(Integer flags, Boolean muted, ModelMuteConfig muteConfig) {
            return new ThreadMemberSettings(flags, muted, muteConfig);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThreadMemberSettings)) {
                return false;
            }
            ThreadMemberSettings threadMemberSettings = (ThreadMemberSettings) other;
            return C12238m.areEqual(this.flags, threadMemberSettings.flags) && C12238m.areEqual(this.muted, threadMemberSettings.muted) && C12238m.areEqual(this.muteConfig, threadMemberSettings.muteConfig);
        }

        public final Integer getFlags() {
            return this.flags;
        }

        public final ModelMuteConfig getMuteConfig() {
            return this.muteConfig;
        }

        public final Boolean getMuted() {
            return this.muted;
        }

        public int hashCode() {
            Integer num = this.flags;
            int iHashCode = (num != null ? num.hashCode() : 0) * 31;
            Boolean bool = this.muted;
            int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
            ModelMuteConfig modelMuteConfig = this.muteConfig;
            return iHashCode2 + (modelMuteConfig != null ? modelMuteConfig.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ThreadMemberSettings(flags=");
            sbM833U.append(this.flags);
            sbM833U.append(", muted=");
            sbM833U.append(this.muted);
            sbM833U.append(", muteConfig=");
            sbM833U.append(this.muteConfig);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        public /* synthetic */ ThreadMemberSettings(Integer num, Boolean bool, ModelMuteConfig modelMuteConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : modelMuteConfig);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class ThreadSettings {
        private final Boolean archived;
        private final Integer autoArchiveDuration;
        private final Boolean locked;

        public ThreadSettings() {
            this(null, null, null, 7, null);
        }

        public ThreadSettings(Boolean bool, Boolean bool2, Integer num) {
            this.archived = bool;
            this.locked = bool2;
            this.autoArchiveDuration = num;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final Boolean getArchived() {
            return this.archived;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        private final Boolean getLocked() {
            return this.locked;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        private final Integer getAutoArchiveDuration() {
            return this.autoArchiveDuration;
        }

        public static /* synthetic */ ThreadSettings copy$default(ThreadSettings threadSettings, Boolean bool, Boolean bool2, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = threadSettings.archived;
            }
            if ((i & 2) != 0) {
                bool2 = threadSettings.locked;
            }
            if ((i & 4) != 0) {
                num = threadSettings.autoArchiveDuration;
            }
            return threadSettings.copy(bool, bool2, num);
        }

        public final ThreadSettings copy(Boolean archived, Boolean locked, Integer autoArchiveDuration) {
            return new ThreadSettings(archived, locked, autoArchiveDuration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThreadSettings)) {
                return false;
            }
            ThreadSettings threadSettings = (ThreadSettings) other;
            return C12238m.areEqual(this.archived, threadSettings.archived) && C12238m.areEqual(this.locked, threadSettings.locked) && C12238m.areEqual(this.autoArchiveDuration, threadSettings.autoArchiveDuration);
        }

        public int hashCode() {
            Boolean bool = this.archived;
            int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
            Boolean bool2 = this.locked;
            int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
            Integer num = this.autoArchiveDuration;
            return iHashCode2 + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ThreadSettings(archived=");
            sbM833U.append(this.archived);
            sbM833U.append(", locked=");
            sbM833U.append(this.locked);
            sbM833U.append(", autoArchiveDuration=");
            return C1643a.m818F(sbM833U, this.autoArchiveDuration, ")");
        }

        public /* synthetic */ ThreadSettings(Boolean bool, Boolean bool2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : num);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class Thumbnail {
        private final String thumbnail;

        public Thumbnail(String str) {
            C12238m.checkNotNullParameter(str, "thumbnail");
            this.thumbnail = str;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class TopicalChannel {
        private final String name;
        private final String topic;
        private final Integer type;

        public TopicalChannel(String str, Integer num, String str2) {
            this.name = str;
            this.type = num;
            this.topic = str2;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class TransferGuildOwnership {
        private final String code;
        private final long ownerId;

        public TransferGuildOwnership(long j, String str) {
            this.ownerId = j;
            this.code = str;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class UpdateGuild {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Long afkChannelId;
        private final Integer afkTimeout;
        private final String banner;
        private final Integer defaultMessageNotifications;
        private final GuildExplicitContentFilter explicitContentFilter;
        private final List<GuildFeature> features;
        private final String icon;
        private final String name;
        private final String preferredLocale;
        private final Long publicUpdatesChannelId;
        private final Long rulesChannelId;
        private final String splash;
        private final Integer systemChannelFlags;
        private final Long systemChannelId;
        private final GuildVerificationLevel verificationLevel;

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class Companion {
            private Companion() {
            }

            public final UpdateGuild createForExplicitContentFilter(GuildExplicitContentFilter explicitContentFilter) {
                C12238m.checkNotNullParameter(explicitContentFilter, "explicitContentFilter");
                return new UpdateGuild(null, null, null, null, null, null, null, explicitContentFilter, null, null, null, null, null, null, null, 32639, null);
            }

            public final UpdateGuild createForVerificationLevel(GuildVerificationLevel verificationLevel) {
                C12238m.checkNotNullParameter(verificationLevel, "verificationLevel");
                return new UpdateGuild(null, null, null, null, null, null, verificationLevel, null, null, null, null, null, null, null, null, 32703, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public UpdateGuild() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public UpdateGuild(Long l, Integer num, Long l2, Integer num2, String str, String str2, GuildVerificationLevel guildVerificationLevel, GuildExplicitContentFilter guildExplicitContentFilter, String str3, String str4, Integer num3, List<? extends GuildFeature> list, Long l3, Long l4, String str5) {
            this.afkChannelId = l;
            this.afkTimeout = num;
            this.systemChannelId = l2;
            this.defaultMessageNotifications = num2;
            this.icon = str;
            this.name = str2;
            this.verificationLevel = guildVerificationLevel;
            this.explicitContentFilter = guildExplicitContentFilter;
            this.splash = str3;
            this.banner = str4;
            this.systemChannelFlags = num3;
            this.features = list;
            this.rulesChannelId = l3;
            this.publicUpdatesChannelId = l4;
            this.preferredLocale = str5;
        }

        public static final UpdateGuild createForExplicitContentFilter(GuildExplicitContentFilter guildExplicitContentFilter) {
            return INSTANCE.createForExplicitContentFilter(guildExplicitContentFilter);
        }

        public static final UpdateGuild createForVerificationLevel(GuildVerificationLevel guildVerificationLevel) {
            return INSTANCE.createForVerificationLevel(guildVerificationLevel);
        }

        public final List<GuildFeature> getFeatures() {
            return this.features;
        }

        public final String getPreferredLocale() {
            return this.preferredLocale;
        }

        public final Long getPublicUpdatesChannelId() {
            return this.publicUpdatesChannelId;
        }

        public final Long getRulesChannelId() {
            return this.rulesChannelId;
        }

        public /* synthetic */ UpdateGuild(Long l, Integer num, Long l2, Integer num2, String str, String str2, GuildVerificationLevel guildVerificationLevel, GuildExplicitContentFilter guildExplicitContentFilter, String str3, String str4, Integer num3, List list, Long l3, Long l4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : guildVerificationLevel, (i & 128) != 0 ? null : guildExplicitContentFilter, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : str4, (i & 1024) != 0 ? null : num3, (i & 2048) != 0 ? null : list, (i & 4096) != 0 ? null : l3, (i & 8192) != 0 ? null : l4, (i & 16384) == 0 ? str5 : null);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class UpdateGuildRoleSubscriptionGroupListing {
        private final String description;
        private final Boolean fullServerGate;
        private final String image;

        public UpdateGuildRoleSubscriptionGroupListing(String str, String str2, Boolean bool) {
            this.image = str;
            this.description = str2;
            this.fullServerGate = bool;
        }

        public static /* synthetic */ UpdateGuildRoleSubscriptionGroupListing copy$default(UpdateGuildRoleSubscriptionGroupListing updateGuildRoleSubscriptionGroupListing, String str, String str2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updateGuildRoleSubscriptionGroupListing.image;
            }
            if ((i & 2) != 0) {
                str2 = updateGuildRoleSubscriptionGroupListing.description;
            }
            if ((i & 4) != 0) {
                bool = updateGuildRoleSubscriptionGroupListing.fullServerGate;
            }
            return updateGuildRoleSubscriptionGroupListing.copy(str, str2, bool);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getFullServerGate() {
            return this.fullServerGate;
        }

        public final UpdateGuildRoleSubscriptionGroupListing copy(String image, String description, Boolean fullServerGate) {
            return new UpdateGuildRoleSubscriptionGroupListing(image, description, fullServerGate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateGuildRoleSubscriptionGroupListing)) {
                return false;
            }
            UpdateGuildRoleSubscriptionGroupListing updateGuildRoleSubscriptionGroupListing = (UpdateGuildRoleSubscriptionGroupListing) other;
            return C12238m.areEqual(this.image, updateGuildRoleSubscriptionGroupListing.image) && C12238m.areEqual(this.description, updateGuildRoleSubscriptionGroupListing.description) && C12238m.areEqual(this.fullServerGate, updateGuildRoleSubscriptionGroupListing.fullServerGate);
        }

        public final String getDescription() {
            return this.description;
        }

        public final Boolean getFullServerGate() {
            return this.fullServerGate;
        }

        public final String getImage() {
            return this.image;
        }

        public int hashCode() {
            String str = this.image;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.description;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Boolean bool = this.fullServerGate;
            return iHashCode2 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("UpdateGuildRoleSubscriptionGroupListing(image=");
            sbM833U.append(this.image);
            sbM833U.append(", description=");
            sbM833U.append(this.description);
            sbM833U.append(", fullServerGate=");
            return C1643a.m816D(sbM833U, this.fullServerGate, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class UpdateGuildRoleSubscriptionTierFreeTrial {
        private final NullSerializable<Integer> maxNumActiveTrialUsers;
        private final NullSerializable<SubscriptionTrialInterval> trial;

        public UpdateGuildRoleSubscriptionTierFreeTrial(NullSerializable<SubscriptionTrialInterval> nullSerializable, NullSerializable<Integer> nullSerializable2) {
            this.trial = nullSerializable;
            this.maxNumActiveTrialUsers = nullSerializable2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UpdateGuildRoleSubscriptionTierFreeTrial copy$default(UpdateGuildRoleSubscriptionTierFreeTrial updateGuildRoleSubscriptionTierFreeTrial, NullSerializable nullSerializable, NullSerializable nullSerializable2, int i, Object obj) {
            if ((i & 1) != 0) {
                nullSerializable = updateGuildRoleSubscriptionTierFreeTrial.trial;
            }
            if ((i & 2) != 0) {
                nullSerializable2 = updateGuildRoleSubscriptionTierFreeTrial.maxNumActiveTrialUsers;
            }
            return updateGuildRoleSubscriptionTierFreeTrial.copy(nullSerializable, nullSerializable2);
        }

        public final NullSerializable<SubscriptionTrialInterval> component1() {
            return this.trial;
        }

        public final NullSerializable<Integer> component2() {
            return this.maxNumActiveTrialUsers;
        }

        public final UpdateGuildRoleSubscriptionTierFreeTrial copy(NullSerializable<SubscriptionTrialInterval> trial, NullSerializable<Integer> maxNumActiveTrialUsers) {
            return new UpdateGuildRoleSubscriptionTierFreeTrial(trial, maxNumActiveTrialUsers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateGuildRoleSubscriptionTierFreeTrial)) {
                return false;
            }
            UpdateGuildRoleSubscriptionTierFreeTrial updateGuildRoleSubscriptionTierFreeTrial = (UpdateGuildRoleSubscriptionTierFreeTrial) other;
            return C12238m.areEqual(this.trial, updateGuildRoleSubscriptionTierFreeTrial.trial) && C12238m.areEqual(this.maxNumActiveTrialUsers, updateGuildRoleSubscriptionTierFreeTrial.maxNumActiveTrialUsers);
        }

        public final NullSerializable<Integer> getMaxNumActiveTrialUsers() {
            return this.maxNumActiveTrialUsers;
        }

        public final NullSerializable<SubscriptionTrialInterval> getTrial() {
            return this.trial;
        }

        public int hashCode() {
            NullSerializable<SubscriptionTrialInterval> nullSerializable = this.trial;
            int iHashCode = (nullSerializable != null ? nullSerializable.hashCode() : 0) * 31;
            NullSerializable<Integer> nullSerializable2 = this.maxNumActiveTrialUsers;
            return iHashCode + (nullSerializable2 != null ? nullSerializable2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("UpdateGuildRoleSubscriptionTierFreeTrial(trial=");
            sbM833U.append(this.trial);
            sbM833U.append(", maxNumActiveTrialUsers=");
            sbM833U.append(this.maxNumActiveTrialUsers);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class UpdateGuildRoleSubscriptionTierListing {
        private final List<GuildRoleSubscriptionBenefit> benefits;
        private final Boolean canAccessAllChannels;
        private final String description;
        private final String image;
        private final String name;
        private final Integer priceTier;
        private final Boolean published;

        public UpdateGuildRoleSubscriptionTierListing(String str, String str2, String str3, Integer num, List<GuildRoleSubscriptionBenefit> list, Boolean bool, Boolean bool2) {
            this.name = str;
            this.image = str2;
            this.description = str3;
            this.priceTier = num;
            this.benefits = list;
            this.published = bool;
            this.canAccessAllChannels = bool2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UpdateGuildRoleSubscriptionTierListing copy$default(UpdateGuildRoleSubscriptionTierListing updateGuildRoleSubscriptionTierListing, String str, String str2, String str3, Integer num, List list, Boolean bool, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updateGuildRoleSubscriptionTierListing.name;
            }
            if ((i & 2) != 0) {
                str2 = updateGuildRoleSubscriptionTierListing.image;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                str3 = updateGuildRoleSubscriptionTierListing.description;
            }
            String str5 = str3;
            if ((i & 8) != 0) {
                num = updateGuildRoleSubscriptionTierListing.priceTier;
            }
            Integer num2 = num;
            if ((i & 16) != 0) {
                list = updateGuildRoleSubscriptionTierListing.benefits;
            }
            List list2 = list;
            if ((i & 32) != 0) {
                bool = updateGuildRoleSubscriptionTierListing.published;
            }
            Boolean bool3 = bool;
            if ((i & 64) != 0) {
                bool2 = updateGuildRoleSubscriptionTierListing.canAccessAllChannels;
            }
            return updateGuildRoleSubscriptionTierListing.copy(str, str4, str5, num2, list2, bool3, bool2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getPriceTier() {
            return this.priceTier;
        }

        public final List<GuildRoleSubscriptionBenefit> component5() {
            return this.benefits;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getPublished() {
            return this.published;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getCanAccessAllChannels() {
            return this.canAccessAllChannels;
        }

        public final UpdateGuildRoleSubscriptionTierListing copy(String name, String image, String description, Integer priceTier, List<GuildRoleSubscriptionBenefit> benefits, Boolean published, Boolean canAccessAllChannels) {
            return new UpdateGuildRoleSubscriptionTierListing(name, image, description, priceTier, benefits, published, canAccessAllChannels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateGuildRoleSubscriptionTierListing)) {
                return false;
            }
            UpdateGuildRoleSubscriptionTierListing updateGuildRoleSubscriptionTierListing = (UpdateGuildRoleSubscriptionTierListing) other;
            return C12238m.areEqual(this.name, updateGuildRoleSubscriptionTierListing.name) && C12238m.areEqual(this.image, updateGuildRoleSubscriptionTierListing.image) && C12238m.areEqual(this.description, updateGuildRoleSubscriptionTierListing.description) && C12238m.areEqual(this.priceTier, updateGuildRoleSubscriptionTierListing.priceTier) && C12238m.areEqual(this.benefits, updateGuildRoleSubscriptionTierListing.benefits) && C12238m.areEqual(this.published, updateGuildRoleSubscriptionTierListing.published) && C12238m.areEqual(this.canAccessAllChannels, updateGuildRoleSubscriptionTierListing.canAccessAllChannels);
        }

        public final List<GuildRoleSubscriptionBenefit> getBenefits() {
            return this.benefits;
        }

        public final Boolean getCanAccessAllChannels() {
            return this.canAccessAllChannels;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getImage() {
            return this.image;
        }

        public final String getName() {
            return this.name;
        }

        public final Integer getPriceTier() {
            return this.priceTier;
        }

        public final Boolean getPublished() {
            return this.published;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.image;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.description;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            Integer num = this.priceTier;
            int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
            List<GuildRoleSubscriptionBenefit> list = this.benefits;
            int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
            Boolean bool = this.published;
            int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
            Boolean bool2 = this.canAccessAllChannels;
            return iHashCode6 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("UpdateGuildRoleSubscriptionTierListing(name=");
            sbM833U.append(this.name);
            sbM833U.append(", image=");
            sbM833U.append(this.image);
            sbM833U.append(", description=");
            sbM833U.append(this.description);
            sbM833U.append(", priceTier=");
            sbM833U.append(this.priceTier);
            sbM833U.append(", benefits=");
            sbM833U.append(this.benefits);
            sbM833U.append(", published=");
            sbM833U.append(this.published);
            sbM833U.append(", canAccessAllChannels=");
            return C1643a.m816D(sbM833U, this.canAccessAllChannels, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class UpdateGuildScheduledEventBody {
        private final Boolean broadcastToDirectoryChannels;
        private final NullSerializable<Long> channelId;
        private final String description;
        private final NullSerializable<GuildScheduledEventEntityMetadata> entityMetadata;
        private final GuildScheduledEventEntityType entityType;
        private final String name;
        private final StageInstancePrivacyLevel privacyLevel;
        private final String scheduledEndTime;
        private final String scheduledStartTime;
        private final GuildScheduledEventStatus status;

        public UpdateGuildScheduledEventBody() {
            this(null, null, null, null, null, null, null, null, null, null, AudioAttributesCompat.FLAG_ALL, null);
        }

        public UpdateGuildScheduledEventBody(String str, String str2, StageInstancePrivacyLevel stageInstancePrivacyLevel, String str3, String str4, NullSerializable<Long> nullSerializable, GuildScheduledEventEntityType guildScheduledEventEntityType, NullSerializable<GuildScheduledEventEntityMetadata> nullSerializable2, GuildScheduledEventStatus guildScheduledEventStatus, Boolean bool) {
            this.name = str;
            this.description = str2;
            this.privacyLevel = stageInstancePrivacyLevel;
            this.scheduledStartTime = str3;
            this.scheduledEndTime = str4;
            this.channelId = nullSerializable;
            this.entityType = guildScheduledEventEntityType;
            this.entityMetadata = nullSerializable2;
            this.status = guildScheduledEventStatus;
            this.broadcastToDirectoryChannels = bool;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Boolean getBroadcastToDirectoryChannels() {
            return this.broadcastToDirectoryChannels;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final StageInstancePrivacyLevel getPrivacyLevel() {
            return this.privacyLevel;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getScheduledStartTime() {
            return this.scheduledStartTime;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getScheduledEndTime() {
            return this.scheduledEndTime;
        }

        public final NullSerializable<Long> component6() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final GuildScheduledEventEntityType getEntityType() {
            return this.entityType;
        }

        public final NullSerializable<GuildScheduledEventEntityMetadata> component8() {
            return this.entityMetadata;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final GuildScheduledEventStatus getStatus() {
            return this.status;
        }

        public final UpdateGuildScheduledEventBody copy(String name, String description, StageInstancePrivacyLevel privacyLevel, String scheduledStartTime, String scheduledEndTime, NullSerializable<Long> channelId, GuildScheduledEventEntityType entityType, NullSerializable<GuildScheduledEventEntityMetadata> entityMetadata, GuildScheduledEventStatus status, Boolean broadcastToDirectoryChannels) {
            return new UpdateGuildScheduledEventBody(name, description, privacyLevel, scheduledStartTime, scheduledEndTime, channelId, entityType, entityMetadata, status, broadcastToDirectoryChannels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateGuildScheduledEventBody)) {
                return false;
            }
            UpdateGuildScheduledEventBody updateGuildScheduledEventBody = (UpdateGuildScheduledEventBody) other;
            return C12238m.areEqual(this.name, updateGuildScheduledEventBody.name) && C12238m.areEqual(this.description, updateGuildScheduledEventBody.description) && C12238m.areEqual(this.privacyLevel, updateGuildScheduledEventBody.privacyLevel) && C12238m.areEqual(this.scheduledStartTime, updateGuildScheduledEventBody.scheduledStartTime) && C12238m.areEqual(this.scheduledEndTime, updateGuildScheduledEventBody.scheduledEndTime) && C12238m.areEqual(this.channelId, updateGuildScheduledEventBody.channelId) && C12238m.areEqual(this.entityType, updateGuildScheduledEventBody.entityType) && C12238m.areEqual(this.entityMetadata, updateGuildScheduledEventBody.entityMetadata) && C12238m.areEqual(this.status, updateGuildScheduledEventBody.status) && C12238m.areEqual(this.broadcastToDirectoryChannels, updateGuildScheduledEventBody.broadcastToDirectoryChannels);
        }

        public final Boolean getBroadcastToDirectoryChannels() {
            return this.broadcastToDirectoryChannels;
        }

        public final NullSerializable<Long> getChannelId() {
            return this.channelId;
        }

        public final String getDescription() {
            return this.description;
        }

        public final NullSerializable<GuildScheduledEventEntityMetadata> getEntityMetadata() {
            return this.entityMetadata;
        }

        public final GuildScheduledEventEntityType getEntityType() {
            return this.entityType;
        }

        public final String getName() {
            return this.name;
        }

        public final StageInstancePrivacyLevel getPrivacyLevel() {
            return this.privacyLevel;
        }

        public final String getScheduledEndTime() {
            return this.scheduledEndTime;
        }

        public final String getScheduledStartTime() {
            return this.scheduledStartTime;
        }

        public final GuildScheduledEventStatus getStatus() {
            return this.status;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.description;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            StageInstancePrivacyLevel stageInstancePrivacyLevel = this.privacyLevel;
            int iHashCode3 = (iHashCode2 + (stageInstancePrivacyLevel != null ? stageInstancePrivacyLevel.hashCode() : 0)) * 31;
            String str3 = this.scheduledStartTime;
            int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.scheduledEndTime;
            int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            NullSerializable<Long> nullSerializable = this.channelId;
            int iHashCode6 = (iHashCode5 + (nullSerializable != null ? nullSerializable.hashCode() : 0)) * 31;
            GuildScheduledEventEntityType guildScheduledEventEntityType = this.entityType;
            int iHashCode7 = (iHashCode6 + (guildScheduledEventEntityType != null ? guildScheduledEventEntityType.hashCode() : 0)) * 31;
            NullSerializable<GuildScheduledEventEntityMetadata> nullSerializable2 = this.entityMetadata;
            int iHashCode8 = (iHashCode7 + (nullSerializable2 != null ? nullSerializable2.hashCode() : 0)) * 31;
            GuildScheduledEventStatus guildScheduledEventStatus = this.status;
            int iHashCode9 = (iHashCode8 + (guildScheduledEventStatus != null ? guildScheduledEventStatus.hashCode() : 0)) * 31;
            Boolean bool = this.broadcastToDirectoryChannels;
            return iHashCode9 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("UpdateGuildScheduledEventBody(name=");
            sbM833U.append(this.name);
            sbM833U.append(", description=");
            sbM833U.append(this.description);
            sbM833U.append(", privacyLevel=");
            sbM833U.append(this.privacyLevel);
            sbM833U.append(", scheduledStartTime=");
            sbM833U.append(this.scheduledStartTime);
            sbM833U.append(", scheduledEndTime=");
            sbM833U.append(this.scheduledEndTime);
            sbM833U.append(", channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", entityType=");
            sbM833U.append(this.entityType);
            sbM833U.append(", entityMetadata=");
            sbM833U.append(this.entityMetadata);
            sbM833U.append(", status=");
            sbM833U.append(this.status);
            sbM833U.append(", broadcastToDirectoryChannels=");
            return C1643a.m816D(sbM833U, this.broadcastToDirectoryChannels, ")");
        }

        public /* synthetic */ UpdateGuildScheduledEventBody(String str, String str2, StageInstancePrivacyLevel stageInstancePrivacyLevel, String str3, String str4, NullSerializable nullSerializable, GuildScheduledEventEntityType guildScheduledEventEntityType, NullSerializable nullSerializable2, GuildScheduledEventStatus guildScheduledEventStatus, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : stageInstancePrivacyLevel, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : nullSerializable, (i & 64) != 0 ? null : guildScheduledEventEntityType, (i & 128) != 0 ? null : nullSerializable2, (i & 256) != 0 ? null : guildScheduledEventStatus, (i & 512) == 0 ? bool : null);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class UpdateStageInstanceBody {
        private final StageInstancePrivacyLevel privacyLevel;
        private final String topic;

        /* JADX WARN: Multi-variable type inference failed */
        public UpdateStageInstanceBody() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public UpdateStageInstanceBody(String str, StageInstancePrivacyLevel stageInstancePrivacyLevel) {
            this.topic = str;
            this.privacyLevel = stageInstancePrivacyLevel;
        }

        public static /* synthetic */ UpdateStageInstanceBody copy$default(UpdateStageInstanceBody updateStageInstanceBody, String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updateStageInstanceBody.topic;
            }
            if ((i & 2) != 0) {
                stageInstancePrivacyLevel = updateStageInstanceBody.privacyLevel;
            }
            return updateStageInstanceBody.copy(str, stageInstancePrivacyLevel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTopic() {
            return this.topic;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StageInstancePrivacyLevel getPrivacyLevel() {
            return this.privacyLevel;
        }

        public final UpdateStageInstanceBody copy(String topic, StageInstancePrivacyLevel privacyLevel) {
            return new UpdateStageInstanceBody(topic, privacyLevel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateStageInstanceBody)) {
                return false;
            }
            UpdateStageInstanceBody updateStageInstanceBody = (UpdateStageInstanceBody) other;
            return C12238m.areEqual(this.topic, updateStageInstanceBody.topic) && C12238m.areEqual(this.privacyLevel, updateStageInstanceBody.privacyLevel);
        }

        public final StageInstancePrivacyLevel getPrivacyLevel() {
            return this.privacyLevel;
        }

        public final String getTopic() {
            return this.topic;
        }

        public int hashCode() {
            String str = this.topic;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            StageInstancePrivacyLevel stageInstancePrivacyLevel = this.privacyLevel;
            return iHashCode + (stageInstancePrivacyLevel != null ? stageInstancePrivacyLevel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("UpdateStageInstanceBody(topic=");
            sbM833U.append(this.topic);
            sbM833U.append(", privacyLevel=");
            sbM833U.append(this.privacyLevel);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        public /* synthetic */ UpdateStageInstanceBody(String str, StageInstancePrivacyLevel stageInstancePrivacyLevel, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : stageInstancePrivacyLevel);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class UpdateSubscription {
        private final List<ModelSubscription.SubscriptionAdditionalPlan> additionalPlans;
        private final String paymentSourceId;
        private final Long planId;
        private final Integer status;

        public UpdateSubscription() {
            this(null, null, null, null, 15, null);
        }

        public UpdateSubscription(Integer num, String str, Long l, List<ModelSubscription.SubscriptionAdditionalPlan> list) {
            this.status = num;
            this.paymentSourceId = str;
            this.planId = l;
            this.additionalPlans = list;
        }

        public /* synthetic */ UpdateSubscription(Integer num, String str, Long l, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : list);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class UploadContacts {
        private final boolean background;
        private final List<ContactEntry> friend_list_entries;
        private final AllowedInSuggestionsType set_use_for_suggestions;

        public UploadContacts(List<ContactEntry> list, boolean z2, AllowedInSuggestionsType allowedInSuggestionsType) {
            C12238m.checkNotNullParameter(list, "friend_list_entries");
            this.friend_list_entries = list;
            this.background = z2;
            this.set_use_for_suggestions = allowedInSuggestionsType;
        }

        public /* synthetic */ UploadContacts(List list, boolean z2, AllowedInSuggestionsType allowedInSuggestionsType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, z2, (i & 4) != 0 ? AllowedInSuggestionsType.DISABLED : allowedInSuggestionsType);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class UserAgreements {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean acknowledgment;
        private final Boolean privacy;
        private final Boolean terms;

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class Companion {
            private Companion() {
            }

            public final UserAgreements acknowledge() {
                return new UserAgreements(null, null, Boolean.TRUE, 3, null);
            }

            public final UserAgreements agree() {
                Boolean bool = Boolean.TRUE;
                return new UserAgreements(bool, bool, null, 4, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public UserAgreements() {
            this(null, null, null, 7, null);
        }

        public UserAgreements(Boolean bool, Boolean bool2, Boolean bool3) {
            this.terms = bool;
            this.privacy = bool2;
            this.acknowledgment = bool3;
        }

        public /* synthetic */ UserAgreements(Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class UserBulkRelationship {
        private final String token;
        private final List<Long> user_ids;

        public UserBulkRelationship(List<Long> list, String str) {
            C12238m.checkNotNullParameter(list, "user_ids");
            C12238m.checkNotNullParameter(str, "token");
            this.user_ids = list;
            this.token = str;
        }

        private final List<Long> component1() {
            return this.user_ids;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        private final String getToken() {
            return this.token;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UserBulkRelationship copy$default(UserBulkRelationship userBulkRelationship, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = userBulkRelationship.user_ids;
            }
            if ((i & 2) != 0) {
                str = userBulkRelationship.token;
            }
            return userBulkRelationship.copy(list, str);
        }

        public final UserBulkRelationship copy(List<Long> user_ids, String token) {
            C12238m.checkNotNullParameter(user_ids, "user_ids");
            C12238m.checkNotNullParameter(token, "token");
            return new UserBulkRelationship(user_ids, token);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserBulkRelationship)) {
                return false;
            }
            UserBulkRelationship userBulkRelationship = (UserBulkRelationship) other;
            return C12238m.areEqual(this.user_ids, userBulkRelationship.user_ids) && C12238m.areEqual(this.token, userBulkRelationship.token);
        }

        public int hashCode() {
            List<Long> list = this.user_ids;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            String str = this.token;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("UserBulkRelationship(user_ids=");
            sbM833U.append(this.user_ids);
            sbM833U.append(", token=");
            return C1643a.m822J(sbM833U, this.token, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class UserDevices {
        private final String provider = "gcm";
        private final String token;

        public UserDevices(String str) {
            this.token = str;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class UserEmailConfirmCode {
        private final String code;

        public UserEmailConfirmCode(String str) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            this.code = str;
        }

        public static /* synthetic */ UserEmailConfirmCode copy$default(UserEmailConfirmCode userEmailConfirmCode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = userEmailConfirmCode.code;
            }
            return userEmailConfirmCode.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        public final UserEmailConfirmCode copy(String code) {
            C12238m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
            return new UserEmailConfirmCode(code);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof UserEmailConfirmCode) && C12238m.areEqual(this.code, ((UserEmailConfirmCode) other).code);
            }
            return true;
        }

        public final String getCode() {
            return this.code;
        }

        public int hashCode() {
            String str = this.code;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return C1643a.m822J(C1643a.m833U("UserEmailConfirmCode(code="), this.code, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class UserGuildSettings {
        private final Map<Long, ChannelOverride> channelOverrides;
        private final Integer messageNotifications;
        private final Boolean mobilePush;
        private final ModelMuteConfig muteConfig;
        private final Boolean muted;
        private final Integer notifyHighlights;
        private final Boolean suppressEveryone;
        private final Boolean suppressRoles;

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class ChannelOverride {
            private final Integer flags;
            private final Integer messageNotifications;
            private final ModelMuteConfig muteConfig;
            private final Boolean muted;

            public ChannelOverride(Boolean bool, ModelMuteConfig modelMuteConfig, Integer num, Integer num2) {
                this.muted = bool;
                this.muteConfig = modelMuteConfig;
                this.messageNotifications = num;
                this.flags = num2;
            }

            public final Integer getFlags() {
                return this.flags;
            }

            public final Integer getMessageNotifications() {
                return this.messageNotifications;
            }

            public final ModelMuteConfig getMuteConfig() {
                return this.muteConfig;
            }

            public final Boolean getMuted() {
                return this.muted;
            }

            public /* synthetic */ ChannelOverride(Boolean bool, ModelMuteConfig modelMuteConfig, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(bool, modelMuteConfig, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2);
            }

            public ChannelOverride(Integer num, Integer num2) {
                this(null, null, num, num2);
            }
        }

        public UserGuildSettings() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        public UserGuildSettings(Boolean bool, Boolean bool2, Boolean bool3, ModelMuteConfig modelMuteConfig, Boolean bool4, Integer num, Map<Long, ChannelOverride> map, Integer num2) {
            this.suppressEveryone = bool;
            this.suppressRoles = bool2;
            this.muted = bool3;
            this.muteConfig = modelMuteConfig;
            this.mobilePush = bool4;
            this.messageNotifications = num;
            this.channelOverrides = map;
            this.notifyHighlights = num2;
        }

        public final Map<Long, ChannelOverride> getChannelOverrides() {
            return this.channelOverrides;
        }

        public final Integer getMessageNotifications() {
            return this.messageNotifications;
        }

        public final Boolean getMobilePush() {
            return this.mobilePush;
        }

        public final ModelMuteConfig getMuteConfig() {
            return this.muteConfig;
        }

        public final Boolean getMuted() {
            return this.muted;
        }

        public final Integer getNotifyHighlights() {
            return this.notifyHighlights;
        }

        public final Boolean getSuppressEveryone() {
            return this.suppressEveryone;
        }

        public final Boolean getSuppressRoles() {
            return this.suppressRoles;
        }

        public /* synthetic */ UserGuildSettings(Boolean bool, Boolean bool2, Boolean bool3, ModelMuteConfig modelMuteConfig, Boolean bool4, Integer num, Map map, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3, (i & 8) != 0 ? null : modelMuteConfig, (i & 16) != 0 ? null : bool4, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : map, (i & 128) == 0 ? num2 : null);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public UserGuildSettings(long j, ChannelOverride channelOverride) {
            this(null, null, null, null, null, null, C12134g0.mapOf(C12116o.m10073to(Long.valueOf(j), channelOverride)), null, Opcodes.ATHROW, null);
            C12238m.checkNotNullParameter(channelOverride, "channelOverride");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class UserNoteUpdate {
        private final String note;

        public UserNoteUpdate(String str) {
            this.note = str;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final String getNote() {
            return this.note;
        }

        public static /* synthetic */ UserNoteUpdate copy$default(UserNoteUpdate userNoteUpdate, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = userNoteUpdate.note;
            }
            return userNoteUpdate.copy(str);
        }

        public final UserNoteUpdate copy(String note) {
            return new UserNoteUpdate(note);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof UserNoteUpdate) && C12238m.areEqual(this.note, ((UserNoteUpdate) other).note);
            }
            return true;
        }

        public int hashCode() {
            String str = this.note;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return C1643a.m822J(C1643a.m833U("UserNoteUpdate(note="), this.note, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class UserRelationship {
        private final String captchaKey;
        private final String captchaRqtoken;
        private final String friendToken;
        private final Integer type;

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class Add {
            private final String captchaKey;
            private final String captchaRqtoken;
            private final int discriminator;
            private final String username;

            public Add(String str, int i, String str2, String str3) {
                C12238m.checkNotNullParameter(str, "username");
                this.username = str;
                this.discriminator = i;
                this.captchaKey = str2;
                this.captchaRqtoken = str3;
            }
        }

        public UserRelationship(Integer num, String str, String str2, String str3) {
            this.type = num;
            this.friendToken = str;
            this.captchaKey = str2;
            this.captchaRqtoken = str3;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class UserSettings {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean allowAccessibilityDetection;
        private final Boolean animateEmoji;
        private final Integer animateStickers;
        private final Boolean blockedMessageBar;
        private final Boolean contactSyncEnabled;
        private final Boolean defaultGuildsRestricted;
        private final Boolean developerMode;
        private final Integer explicitContentFilter;
        private final Integer friendDiscoveryFlags;
        private final FriendSourceFlags friendSourceFlags;
        private final Collection<ModelGuildFolder> guildFolders;
        private final Boolean inlineAttachmentMedia;
        private final Boolean inlineEmbedMedia;
        private final String locale;
        private final Boolean renderEmbeds;
        private final Collection<Long> restrictedGuilds;
        private final Boolean showCurrentGame;
        private final String status;
        private final String theme;

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class Companion {
            private Companion() {
            }

            public final UserSettings createWithAllowAccessibilityDetection(Boolean allowAccessibilityDetection) {
                return new UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, allowAccessibilityDetection, null, null, null, 491519, null);
            }

            public final UserSettings createWithAllowAnimatedEmojis(Boolean allowAnimatedEmojis) {
                return new UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, null, allowAnimatedEmojis, null, null, null, null, 507903, null);
            }

            public final UserSettings createWithBlockedMessageBar(boolean blockedMessageBar) {
                return new UserSettings(null, null, null, null, null, Boolean.valueOf(blockedMessageBar), null, null, null, null, null, null, null, null, null, null, null, null, null, 524255, null);
            }

            public final UserSettings createWithContactSyncUpsellShown() {
                return new UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Boolean.TRUE, null, 393215, null);
            }

            public final UserSettings createWithDeveloperMode(boolean developerMode) {
                return new UserSettings(null, Boolean.valueOf(developerMode), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524285, null);
            }

            public final UserSettings createWithExplicitContentFilter(int explicitContentFilter) {
                return new UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(explicitContentFilter), null, null, null, null, null, 516095, null);
            }

            public final UserSettings createWithFriendDiscoveryFlags(Integer friendDiscoveryFlags) {
                return new UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, friendDiscoveryFlags, 262143, null);
            }

            public final UserSettings createWithFriendSourceFlags(Boolean all, Boolean mutualGuilds, Boolean mutualFriends) {
                return new UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, new FriendSourceFlags(all, mutualGuilds, mutualFriends), null, null, null, null, null, null, 520191, null);
            }

            public final UserSettings createWithGuildFolders(List<ModelGuildFolder> guildFolders) {
                C12238m.checkNotNullParameter(guildFolders, "guildFolders");
                return new UserSettings(null, null, null, null, null, null, null, null, null, null, guildFolders, null, null, null, null, null, null, null, null, 523263, null);
            }

            public final UserSettings createWithInlineAttachmentMedia(boolean inlineAttachmentMedia) {
                return new UserSettings(null, null, null, null, Boolean.valueOf(inlineAttachmentMedia), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524271, null);
            }

            public final UserSettings createWithInlineEmbedMedia(boolean inlineEmbedMedia) {
                return new UserSettings(null, null, null, Boolean.valueOf(inlineEmbedMedia), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524279, null);
            }

            public final UserSettings createWithLocale(String locale) {
                C12238m.checkNotNullParameter(locale, "locale");
                return new UserSettings(null, null, null, null, null, null, locale, null, null, null, null, null, null, null, null, null, null, null, null, 524223, null);
            }

            public final UserSettings createWithRenderEmbeds(boolean renderEmbeds) {
                return new UserSettings(null, null, Boolean.valueOf(renderEmbeds), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524283, null);
            }

            public final UserSettings createWithRestrictedGuilds(Boolean defaultGuildsRestricted, Collection<Long> restrictedGuilds) {
                return new UserSettings(null, null, null, null, null, null, null, restrictedGuilds, null, null, null, defaultGuildsRestricted, null, null, null, null, null, null, null, 522111, null);
            }

            public final UserSettings createWithShowCurrentGame(boolean showCurrentGame) {
                return new UserSettings(null, null, null, null, null, null, null, null, null, Boolean.valueOf(showCurrentGame), null, null, null, null, null, null, null, null, null, 523775, null);
            }

            public final UserSettings createWithStatus(ClientStatus status) {
                C12238m.checkNotNullParameter(status, "status");
                String strName = status.name();
                Locale locale = Locale.ROOT;
                C12238m.checkNotNullExpressionValue(locale, "Locale.ROOT");
                Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = strName.toLowerCase(locale);
                C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                return new UserSettings(null, null, null, null, null, null, null, null, lowerCase, null, null, null, null, null, null, null, null, null, null, 524031, null);
            }

            public final UserSettings createWithStickerAnimationSettings(Integer stickerAnimationSettings) {
                return new UserSettings(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, stickerAnimationSettings, null, null, 458751, null);
            }

            public final UserSettings createWithTheme(String theme) {
                C12238m.checkNotNullParameter(theme, "theme");
                return new UserSettings(theme, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524286, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class FriendSourceFlags {
            private final Boolean all;
            private final Boolean mutualFriends;
            private final Boolean mutualGuilds;

            public FriendSourceFlags(Boolean bool, Boolean bool2, Boolean bool3) {
                this.all = bool;
                this.mutualGuilds = bool2;
                this.mutualFriends = bool3;
            }
        }

        private UserSettings(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str2, Collection<Long> collection, String str3, Boolean bool6, Collection<ModelGuildFolder> collection2, Boolean bool7, FriendSourceFlags friendSourceFlags, Integer num, Boolean bool8, Boolean bool9, Integer num2, Boolean bool10, Integer num3) {
            this.theme = str;
            this.developerMode = bool;
            this.renderEmbeds = bool2;
            this.inlineEmbedMedia = bool3;
            this.inlineAttachmentMedia = bool4;
            this.blockedMessageBar = bool5;
            this.locale = str2;
            this.restrictedGuilds = collection;
            this.status = str3;
            this.showCurrentGame = bool6;
            this.guildFolders = collection2;
            this.defaultGuildsRestricted = bool7;
            this.friendSourceFlags = friendSourceFlags;
            this.explicitContentFilter = num;
            this.animateEmoji = bool8;
            this.allowAccessibilityDetection = bool9;
            this.animateStickers = num2;
            this.contactSyncEnabled = bool10;
            this.friendDiscoveryFlags = num3;
        }

        public static final UserSettings createWithAllowAccessibilityDetection(Boolean bool) {
            return INSTANCE.createWithAllowAccessibilityDetection(bool);
        }

        public static final UserSettings createWithAllowAnimatedEmojis(Boolean bool) {
            return INSTANCE.createWithAllowAnimatedEmojis(bool);
        }

        public static final UserSettings createWithBlockedMessageBar(boolean z2) {
            return INSTANCE.createWithBlockedMessageBar(z2);
        }

        public static final UserSettings createWithContactSyncUpsellShown() {
            return INSTANCE.createWithContactSyncUpsellShown();
        }

        public static final UserSettings createWithDeveloperMode(boolean z2) {
            return INSTANCE.createWithDeveloperMode(z2);
        }

        public static final UserSettings createWithExplicitContentFilter(int i) {
            return INSTANCE.createWithExplicitContentFilter(i);
        }

        public static final UserSettings createWithFriendDiscoveryFlags(Integer num) {
            return INSTANCE.createWithFriendDiscoveryFlags(num);
        }

        public static final UserSettings createWithFriendSourceFlags(Boolean bool, Boolean bool2, Boolean bool3) {
            return INSTANCE.createWithFriendSourceFlags(bool, bool2, bool3);
        }

        public static final UserSettings createWithGuildFolders(List<ModelGuildFolder> list) {
            return INSTANCE.createWithGuildFolders(list);
        }

        public static final UserSettings createWithInlineAttachmentMedia(boolean z2) {
            return INSTANCE.createWithInlineAttachmentMedia(z2);
        }

        public static final UserSettings createWithInlineEmbedMedia(boolean z2) {
            return INSTANCE.createWithInlineEmbedMedia(z2);
        }

        public static final UserSettings createWithLocale(String str) {
            return INSTANCE.createWithLocale(str);
        }

        public static final UserSettings createWithRenderEmbeds(boolean z2) {
            return INSTANCE.createWithRenderEmbeds(z2);
        }

        public static final UserSettings createWithRestrictedGuilds(Boolean bool, Collection<Long> collection) {
            return INSTANCE.createWithRestrictedGuilds(bool, collection);
        }

        public static final UserSettings createWithShowCurrentGame(boolean z2) {
            return INSTANCE.createWithShowCurrentGame(z2);
        }

        public static final UserSettings createWithStatus(ClientStatus clientStatus) {
            return INSTANCE.createWithStatus(clientStatus);
        }

        public static final UserSettings createWithStickerAnimationSettings(Integer num) {
            return INSTANCE.createWithStickerAnimationSettings(num);
        }

        public static final UserSettings createWithTheme(String str) {
            return INSTANCE.createWithTheme(str);
        }

        public /* synthetic */ UserSettings(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str2, Collection collection, String str3, Boolean bool6, Collection collection2, Boolean bool7, FriendSourceFlags friendSourceFlags, Integer num, Boolean bool8, Boolean bool9, Integer num2, Boolean bool10, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : bool3, (i & 16) != 0 ? null : bool4, (i & 32) != 0 ? null : bool5, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : collection, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : bool6, (i & 1024) != 0 ? null : collection2, (i & 2048) != 0 ? null : bool7, (i & 4096) != 0 ? null : friendSourceFlags, (i & 8192) != 0 ? null : num, (i & 16384) != 0 ? null : bool8, (i & 32768) != 0 ? null : bool9, (i & 65536) != 0 ? null : num2, (i & 131072) != 0 ? null : bool10, (i & 262144) != 0 ? null : num3);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class UserSettingsCustomStatus {
        private final ModelCustomStatusSetting customStatus;

        public UserSettingsCustomStatus(ModelCustomStatusSetting modelCustomStatusSetting) {
            this.customStatus = modelCustomStatusSetting;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class VanityUrl {
        private final String code;

        /* JADX WARN: Multi-variable type inference failed */
        public VanityUrl() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public VanityUrl(String str) {
            this.code = str;
        }

        public /* synthetic */ VanityUrl(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class VerificationCode {
        private final String code;
        private final String phone;

        public VerificationCode(String str, String str2) {
            C12238m.checkNotNullParameter(str, "phone");
            C12238m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_CODE);
            this.phone = str;
            this.code = str2;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class VerificationCodeOnly {
        private final String code;

        public VerificationCodeOnly(String str) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            this.code = str;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class VerificationCodeResend {
        private final String phone;

        public VerificationCodeResend(String str) {
            C12238m.checkNotNullParameter(str, "phone");
            this.phone = str;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class VerificationPhoneCode {
        private final String password;
        private final String phoneToken;
        private final String source;

        public VerificationPhoneCode(String str, String str2, String str3) {
            C1643a.m872q0(str, "phoneToken", str2, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, str3, "source");
            this.phoneToken = str;
            this.password = str2;
            this.source = str3;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class VerifyEmail {
        private final boolean allowMultipleGuilds;
        private final String email;
        private final Long guildId;
        private final boolean useVerificationCode;

        public VerifyEmail(String str, Long l, boolean z2, boolean z3) {
            C12238m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
            this.email = str;
            this.guildId = l;
            this.allowMultipleGuilds = z2;
            this.useVerificationCode = z3;
        }

        public static /* synthetic */ VerifyEmail copy$default(VerifyEmail verifyEmail, String str, Long l, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = verifyEmail.email;
            }
            if ((i & 2) != 0) {
                l = verifyEmail.guildId;
            }
            if ((i & 4) != 0) {
                z2 = verifyEmail.allowMultipleGuilds;
            }
            if ((i & 8) != 0) {
                z3 = verifyEmail.useVerificationCode;
            }
            return verifyEmail.copy(str, l, z2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEmail() {
            return this.email;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getAllowMultipleGuilds() {
            return this.allowMultipleGuilds;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getUseVerificationCode() {
            return this.useVerificationCode;
        }

        public final VerifyEmail copy(String email, Long guildId, boolean allowMultipleGuilds, boolean useVerificationCode) {
            C12238m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
            return new VerifyEmail(email, guildId, allowMultipleGuilds, useVerificationCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerifyEmail)) {
                return false;
            }
            VerifyEmail verifyEmail = (VerifyEmail) other;
            return C12238m.areEqual(this.email, verifyEmail.email) && C12238m.areEqual(this.guildId, verifyEmail.guildId) && this.allowMultipleGuilds == verifyEmail.allowMultipleGuilds && this.useVerificationCode == verifyEmail.useVerificationCode;
        }

        public final boolean getAllowMultipleGuilds() {
            return this.allowMultipleGuilds;
        }

        public final String getEmail() {
            return this.email;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final boolean getUseVerificationCode() {
            return this.useVerificationCode;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        public int hashCode() {
            String str = this.email;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            Long l = this.guildId;
            int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
            boolean z2 = this.allowMultipleGuilds;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode2 + r1) * 31;
            boolean z3 = this.useVerificationCode;
            return i + (z3 ? 1 : z3);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("VerifyEmail(email=");
            sbM833U.append(this.email);
            sbM833U.append(", guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", allowMultipleGuilds=");
            sbM833U.append(this.allowMultipleGuilds);
            sbM833U.append(", useVerificationCode=");
            return C1643a.m827O(sbM833U, this.useVerificationCode, ")");
        }

        public /* synthetic */ VerifyEmail(String str, Long l, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? true : z3);
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class VerifyEmailCode {
        private final String code;
        private final String email;
        private final Long guildId;

        public VerifyEmailCode(String str, String str2, Long l) {
            C12238m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
            C12238m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_CODE);
            this.email = str;
            this.code = str2;
            this.guildId = l;
        }

        public static /* synthetic */ VerifyEmailCode copy$default(VerifyEmailCode verifyEmailCode, String str, String str2, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                str = verifyEmailCode.email;
            }
            if ((i & 2) != 0) {
                str2 = verifyEmailCode.code;
            }
            if ((i & 4) != 0) {
                l = verifyEmailCode.guildId;
            }
            return verifyEmailCode.copy(str, str2, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEmail() {
            return this.email;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        public final VerifyEmailCode copy(String email, String code, Long guildId) {
            C12238m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
            C12238m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
            return new VerifyEmailCode(email, code, guildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerifyEmailCode)) {
                return false;
            }
            VerifyEmailCode verifyEmailCode = (VerifyEmailCode) other;
            return C12238m.areEqual(this.email, verifyEmailCode.email) && C12238m.areEqual(this.code, verifyEmailCode.code) && C12238m.areEqual(this.guildId, verifyEmailCode.guildId);
        }

        public final String getCode() {
            return this.code;
        }

        public final String getEmail() {
            return this.email;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public int hashCode() {
            String str = this.email;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.code;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Long l = this.guildId;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("VerifyEmailCode(email=");
            sbM833U.append(this.email);
            sbM833U.append(", code=");
            sbM833U.append(this.code);
            sbM833U.append(", guildId=");
            return C1643a.m819G(sbM833U, this.guildId, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class VerifyPurchaseResponse {
        private final String giftCode;
        private final Long subscriptionPlanId;
        private final long verifiedSkuId;

        public VerifyPurchaseResponse(long j, Long l, String str) {
            this.verifiedSkuId = j;
            this.subscriptionPlanId = l;
            this.giftCode = str;
        }

        public static /* synthetic */ VerifyPurchaseResponse copy$default(VerifyPurchaseResponse verifyPurchaseResponse, long j, Long l, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = verifyPurchaseResponse.verifiedSkuId;
            }
            if ((i & 2) != 0) {
                l = verifyPurchaseResponse.subscriptionPlanId;
            }
            if ((i & 4) != 0) {
                str = verifyPurchaseResponse.giftCode;
            }
            return verifyPurchaseResponse.copy(j, l, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getVerifiedSkuId() {
            return this.verifiedSkuId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getSubscriptionPlanId() {
            return this.subscriptionPlanId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getGiftCode() {
            return this.giftCode;
        }

        public final VerifyPurchaseResponse copy(long verifiedSkuId, Long subscriptionPlanId, String giftCode) {
            return new VerifyPurchaseResponse(verifiedSkuId, subscriptionPlanId, giftCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerifyPurchaseResponse)) {
                return false;
            }
            VerifyPurchaseResponse verifyPurchaseResponse = (VerifyPurchaseResponse) other;
            return this.verifiedSkuId == verifyPurchaseResponse.verifiedSkuId && C12238m.areEqual(this.subscriptionPlanId, verifyPurchaseResponse.subscriptionPlanId) && C12238m.areEqual(this.giftCode, verifyPurchaseResponse.giftCode);
        }

        public final String getGiftCode() {
            return this.giftCode;
        }

        public final Long getSubscriptionPlanId() {
            return this.subscriptionPlanId;
        }

        public final long getVerifiedSkuId() {
            return this.verifiedSkuId;
        }

        public int hashCode() {
            long j = this.verifiedSkuId;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            Long l = this.subscriptionPlanId;
            int iHashCode = (i + (l != null ? l.hashCode() : 0)) * 31;
            String str = this.giftCode;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("VerifyPurchaseResponse(verifiedSkuId=");
            sbM833U.append(this.verifiedSkuId);
            sbM833U.append(", subscriptionPlanId=");
            sbM833U.append(this.subscriptionPlanId);
            sbM833U.append(", giftCode=");
            return C1643a.m822J(sbM833U, this.giftCode, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final /* data */ class VerifyPurchaseTokenBody {
        private final String oneTimePurchaseSkuId;
        private final String packageName;
        private final String purchaseToken;
        private final String subscriptionSkuId;
        private final long userId;

        public VerifyPurchaseTokenBody(String str, long j, String str2, String str3, String str4) {
            C12238m.checkNotNullParameter(str, "purchaseToken");
            C12238m.checkNotNullParameter(str2, "packageName");
            this.purchaseToken = str;
            this.userId = j;
            this.packageName = str2;
            this.subscriptionSkuId = str3;
            this.oneTimePurchaseSkuId = str4;
        }

        public static /* synthetic */ VerifyPurchaseTokenBody copy$default(VerifyPurchaseTokenBody verifyPurchaseTokenBody, String str, long j, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = verifyPurchaseTokenBody.purchaseToken;
            }
            if ((i & 2) != 0) {
                j = verifyPurchaseTokenBody.userId;
            }
            long j2 = j;
            if ((i & 4) != 0) {
                str2 = verifyPurchaseTokenBody.packageName;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                str3 = verifyPurchaseTokenBody.subscriptionSkuId;
            }
            String str6 = str3;
            if ((i & 16) != 0) {
                str4 = verifyPurchaseTokenBody.oneTimePurchaseSkuId;
            }
            return verifyPurchaseTokenBody.copy(str, j2, str5, str6, str4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPurchaseToken() {
            return this.purchaseToken;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getUserId() {
            return this.userId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPackageName() {
            return this.packageName;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSubscriptionSkuId() {
            return this.subscriptionSkuId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getOneTimePurchaseSkuId() {
            return this.oneTimePurchaseSkuId;
        }

        public final VerifyPurchaseTokenBody copy(String purchaseToken, long userId, String packageName, String subscriptionSkuId, String oneTimePurchaseSkuId) {
            C12238m.checkNotNullParameter(purchaseToken, "purchaseToken");
            C12238m.checkNotNullParameter(packageName, "packageName");
            return new VerifyPurchaseTokenBody(purchaseToken, userId, packageName, subscriptionSkuId, oneTimePurchaseSkuId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerifyPurchaseTokenBody)) {
                return false;
            }
            VerifyPurchaseTokenBody verifyPurchaseTokenBody = (VerifyPurchaseTokenBody) other;
            return C12238m.areEqual(this.purchaseToken, verifyPurchaseTokenBody.purchaseToken) && this.userId == verifyPurchaseTokenBody.userId && C12238m.areEqual(this.packageName, verifyPurchaseTokenBody.packageName) && C12238m.areEqual(this.subscriptionSkuId, verifyPurchaseTokenBody.subscriptionSkuId) && C12238m.areEqual(this.oneTimePurchaseSkuId, verifyPurchaseTokenBody.oneTimePurchaseSkuId);
        }

        public final String getOneTimePurchaseSkuId() {
            return this.oneTimePurchaseSkuId;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final String getPurchaseToken() {
            return this.purchaseToken;
        }

        public final String getSubscriptionSkuId() {
            return this.subscriptionSkuId;
        }

        public final long getUserId() {
            return this.userId;
        }

        public int hashCode() {
            String str = this.purchaseToken;
            int iHashCode = str != null ? str.hashCode() : 0;
            long j = this.userId;
            int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            String str2 = this.packageName;
            int iHashCode2 = (i + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.subscriptionSkuId;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.oneTimePurchaseSkuId;
            return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("VerifyPurchaseTokenBody(purchaseToken=");
            sbM833U.append(this.purchaseToken);
            sbM833U.append(", userId=");
            sbM833U.append(this.userId);
            sbM833U.append(", packageName=");
            sbM833U.append(this.packageName);
            sbM833U.append(", subscriptionSkuId=");
            sbM833U.append(this.subscriptionSkuId);
            sbM833U.append(", oneTimePurchaseSkuId=");
            return C1643a.m822J(sbM833U, this.oneTimePurchaseSkuId, ")");
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class VoiceChannel {
        private final Integer bitrate;
        private final String name;
        private final Boolean nsfw;
        private final String rtcRegion;
        private final String topic;
        private final Integer type;
        private final Integer userLimit;

        public VoiceChannel(String str, String str2, Integer num, Boolean bool, Integer num2, Integer num3, String str3) {
            this.name = str;
            this.topic = str2;
            this.type = num;
            this.nsfw = bool;
            this.userLimit = num2;
            this.bitrate = num3;
            this.rtcRegion = str3;
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class CreateChannel {
        private final List<Long> recipients;

        public CreateChannel(List<Long> list) {
            this.recipients = list == null ? C12147n.emptyList() : list;
        }

        public CreateChannel(long j) {
            this((List<Long>) C12145m.listOf(Long.valueOf(j)));
        }
    }

    /* JADX INFO: compiled from: RestAPIParams.kt */
    public static final class UserInfo {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String avatar;
        private final String code;
        private final String dateOfBirth;
        private final String discriminator;
        private final String email;
        private final String emailToken;
        private final Integer flags;
        private final String newPassword;
        private final String password;
        private final String pushProvider;
        private final String pushToken;
        private final String username;

        /* JADX INFO: compiled from: RestAPIParams.kt */
        public static final class Companion {
            private Companion() {
            }

            public final UserInfo createForEmail(CharSequence email, CharSequence password) {
                C12238m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
                C12238m.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
                return new UserInfo(null, email.toString(), null, password.toString(), null, null, null, null, null, null, null, 2037, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public UserInfo() {
            this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        }

        public UserInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, String str10) {
            this.avatar = str;
            this.email = str2;
            this.emailToken = str3;
            this.password = str4;
            this.newPassword = str5;
            this.username = str6;
            this.pushToken = str7;
            this.code = str8;
            this.discriminator = str9;
            this.flags = num;
            this.dateOfBirth = str10;
            this.pushProvider = "gcm";
        }

        public static final UserInfo createForEmail(CharSequence charSequence, CharSequence charSequence2) {
            return INSTANCE.createForEmail(charSequence, charSequence2);
        }

        public /* synthetic */ UserInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : num, (i & 1024) == 0 ? str10 : null);
        }
    }
}
