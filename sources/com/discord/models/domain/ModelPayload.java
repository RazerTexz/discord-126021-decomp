package com.discord.models.domain;

import androidx.annotation.Nullable;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.guild.Guild;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.presence.Presence;
import com.discord.api.user.User;
import com.discord.api.user.UserSurvey;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelReadState;
import com.discord.models.domain.ModelSession;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.experiments.dto.GuildExperimentDto;
import com.discord.models.experiments.dto.UserExperimentDto;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ModelPayload implements Model {
    private String analyticsToken;
    private String authToken;
    private List<ConnectedAccount> connectedAccounts;
    private String countryCode;
    private Map<Long, UserExperimentDto> experiments;
    private int friendSuggestionCount;

    @Nullable
    private List<GuildExperimentDto> guildExperiments;
    private List<GuildJoinRequest> guildJoinRequests;
    private List<List<GuildMember>> guildMembers;
    private List<List<Presence>> guildPresences;
    private List<Guild> guilds;

    /* JADX INFO: renamed from: me, reason: collision with root package name */
    private User f2726me;
    private List<Presence> presences;
    private List<Channel> privateChannels;
    private VersionedReadStates readState;
    private List<ModelUserRelationship> relationships;
    private String requiredAction;
    private String sessionId;
    private List<ModelSession> sessions;
    private Object trace;
    private VersionedUserGuildSettings userGuildSettings;
    private ModelUserSettings userSettings;
    private UserSurvey userSurvey;
    private List<User> users;
    private int v;

    public static class Hello implements Model {
        private int heartbeatInterval;
        private List<String> trace;

        @Override // com.discord.models.domain.Model
        public void assignField(final Model.JsonReader jsonReader) throws IOException {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("_trace")) {
                this.trace = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.o
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        return jsonReader.nextString(null);
                    }
                });
            } else if (strNextName.equals("heartbeat_interval")) {
                this.heartbeatInterval = jsonReader.nextInt(this.heartbeatInterval);
            } else {
                jsonReader.skipValue();
            }
        }

        public boolean canEqual(Object obj) {
            return obj instanceof Hello;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Hello)) {
                return false;
            }
            Hello hello = (Hello) obj;
            if (!hello.canEqual(this) || getHeartbeatInterval() != hello.getHeartbeatInterval()) {
                return false;
            }
            List<String> trace = getTrace();
            List<String> trace2 = hello.getTrace();
            return trace != null ? trace.equals(trace2) : trace2 == null;
        }

        public int getHeartbeatInterval() {
            return this.heartbeatInterval;
        }

        public List<String> getTrace() {
            return this.trace;
        }

        public int hashCode() {
            int heartbeatInterval = getHeartbeatInterval() + 59;
            List<String> trace = getTrace();
            return (heartbeatInterval * 59) + (trace == null ? 43 : trace.hashCode());
        }

        public String toString() {
            StringBuilder sbU = outline.U("ModelPayload.Hello(heartbeatInterval=");
            sbU.append(getHeartbeatInterval());
            sbU.append(", trace=");
            sbU.append(getTrace());
            sbU.append(")");
            return sbU.toString();
        }
    }

    public static class MergedPresences implements Model {
        private List<Presence> friends;
        private List<List<Presence>> guilds;

        @Override // com.discord.models.domain.Model
        public void assignField(final Model.JsonReader jsonReader) throws IOException {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("guilds")) {
                this.guilds = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.r
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        final Model.JsonReader jsonReader2 = jsonReader;
                        return jsonReader2.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.q
                            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                            public final Object get() {
                                return (Presence) InboundGatewayGsonParser.fromJson(jsonReader2, Presence.class);
                            }
                        });
                    }
                });
            } else if (strNextName.equals("friends")) {
                this.friends = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.p
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        return (Presence) InboundGatewayGsonParser.fromJson(jsonReader, Presence.class);
                    }
                });
            } else {
                jsonReader.skipValue();
            }
        }

        public boolean canEqual(Object obj) {
            return obj instanceof MergedPresences;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MergedPresences)) {
                return false;
            }
            MergedPresences mergedPresences = (MergedPresences) obj;
            if (!mergedPresences.canEqual(this)) {
                return false;
            }
            List<Presence> friends = getFriends();
            List<Presence> friends2 = mergedPresences.getFriends();
            if (friends != null ? !friends.equals(friends2) : friends2 != null) {
                return false;
            }
            List<List<Presence>> guilds = getGuilds();
            List<List<Presence>> guilds2 = mergedPresences.getGuilds();
            return guilds != null ? guilds.equals(guilds2) : guilds2 == null;
        }

        public List<Presence> getFriends() {
            return this.friends;
        }

        public List<List<Presence>> getGuilds() {
            return this.guilds;
        }

        public int hashCode() {
            List<Presence> friends = getFriends();
            int iHashCode = friends == null ? 43 : friends.hashCode();
            List<List<Presence>> guilds = getGuilds();
            return ((iHashCode + 59) * 59) + (guilds != null ? guilds.hashCode() : 43);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ModelPayload.MergedPresences(friends=");
            sbU.append(getFriends());
            sbU.append(", guilds=");
            sbU.append(getGuilds());
            sbU.append(")");
            return sbU.toString();
        }
    }

    public static abstract class VersionedModel<T> implements Model {
        public static final int DEFAULT_VERSION = -1;
        private List<T> entries;
        private boolean partial;
        private int version;

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:4:0x000f  */
        @Override // com.discord.models.domain.Model
        public void assignField(final Model.JsonReader jsonReader) throws IOException {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "entries":
                    this.entries = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.t
                        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                        public final Object get() {
                            return this.a.parseEntry(jsonReader);
                        }
                    });
                    break;
                case "partial":
                    this.partial = jsonReader.nextBoolean(this.partial);
                    break;
                case "version":
                    this.version = jsonReader.nextInt(-1);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }

        public boolean canEqual(Object obj) {
            return obj instanceof VersionedModel;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof VersionedModel)) {
                return false;
            }
            VersionedModel versionedModel = (VersionedModel) obj;
            if (!versionedModel.canEqual(this) || getVersion() != versionedModel.getVersion() || isPartial() != versionedModel.isPartial()) {
                return false;
            }
            List<T> entries = getEntries();
            List<T> entries2 = versionedModel.getEntries();
            return entries != null ? entries.equals(entries2) : entries2 == null;
        }

        public List<T> getEntries() {
            return this.entries;
        }

        public int getVersion() {
            return this.version;
        }

        public int hashCode() {
            int version = ((getVersion() + 59) * 59) + (isPartial() ? 79 : 97);
            List<T> entries = getEntries();
            return (version * 59) + (entries == null ? 43 : entries.hashCode());
        }

        public boolean isPartial() {
            return this.partial;
        }

        public abstract T parseEntry(Model.JsonReader jsonReader) throws IOException;

        public String toString() {
            StringBuilder sbU = outline.U("ModelPayload.VersionedModel(version=");
            sbU.append(getVersion());
            sbU.append(", entries=");
            sbU.append(getEntries());
            sbU.append(", partial=");
            sbU.append(isPartial());
            sbU.append(")");
            return sbU.toString();
        }
    }

    public static class VersionedReadStates extends VersionedModel<ModelReadState> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.ModelPayload.VersionedModel
        public ModelReadState parseEntry(Model.JsonReader jsonReader) {
            return ModelReadState.Parser.INSTANCE.parse(jsonReader);
        }
    }

    public static class VersionedUserGuildSettings extends VersionedModel<ModelNotificationSettings> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.ModelPayload.VersionedModel
        public ModelNotificationSettings parseEntry(Model.JsonReader jsonReader) throws IOException {
            return (ModelNotificationSettings) jsonReader.parse(new ModelNotificationSettings());
        }
    }

    public ModelPayload() {
    }

    private Object getTraces(final Model.JsonReader jsonReader) throws IOException {
        jsonReader.getClass();
        List listNextList = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.g0
            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
            public final Object get() {
                return jsonReader.nextStringOrNull();
            }
        });
        if (listNextList.size() <= 0 || listNextList.get(0) == null) {
            return null;
        }
        return new Gson().f((String) listNextList.get(0), Object.class);
    }

    @Override // com.discord.models.domain.Model
    public void assignField(final Model.JsonReader jsonReader) throws IOException {
        String strNextName = jsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "auth_token":
                this.authToken = jsonReader.nextString(this.authToken);
                break;
            case "user_guild_settings":
                this.userGuildSettings = (VersionedUserGuildSettings) jsonReader.parse(new VersionedUserGuildSettings());
                break;
            case "_trace":
                this.trace = getTraces(jsonReader);
                break;
            case "merged_members":
                this.guildMembers = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.s
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        final Model.JsonReader jsonReader2 = jsonReader;
                        return jsonReader2.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.u
                            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                            public final Object get() {
                                return (GuildMember) InboundGatewayGsonParser.fromJson(jsonReader2, GuildMember.class);
                            }
                        });
                    }
                });
                break;
            case "merged_presences":
                MergedPresences mergedPresences = (MergedPresences) jsonReader.parse(new MergedPresences());
                this.presences = mergedPresences.friends;
                this.guildPresences = mergedPresences.guilds;
                break;
            case "guilds":
                this.guilds = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.l
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        return (Guild) InboundGatewayGsonParser.fromJson(jsonReader, Guild.class);
                    }
                });
                break;
            case "presences":
                this.presences = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.v
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        return (Presence) InboundGatewayGsonParser.fromJson(jsonReader, Presence.class);
                    }
                });
                break;
            case "guild_join_requests":
                this.guildJoinRequests = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.y
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        return (GuildJoinRequest) InboundGatewayGsonParser.fromJson(jsonReader, GuildJoinRequest.class);
                    }
                });
                break;
            case "read_state":
                this.readState = (VersionedReadStates) jsonReader.parse(new VersionedReadStates());
                break;
            case "user_survey":
                this.userSurvey = (UserSurvey) InboundGatewayGsonParser.fromJson(jsonReader, UserSurvey.class);
                break;
            case "v":
                this.v = jsonReader.nextInt(this.v);
                break;
            case "user":
                this.f2726me = (User) InboundGatewayGsonParser.fromJson(jsonReader, User.class);
                break;
            case "users":
                this.users = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.w
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        return (User) InboundGatewayGsonParser.fromJson(jsonReader, User.class);
                    }
                });
                break;
            case "connected_accounts":
                this.connectedAccounts = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.n
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        return (ConnectedAccount) InboundGatewayGsonParser.fromJson(jsonReader, ConnectedAccount.class);
                    }
                });
                break;
            case "guild_experiments":
                this.guildExperiments = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.z
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        return GuildExperimentDto.Parser.parse(jsonReader);
                    }
                });
                break;
            case "relationships":
                this.relationships = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.x
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        return (ModelUserRelationship) jsonReader.parse(new ModelUserRelationship());
                    }
                });
                break;
            case "required_action":
                this.requiredAction = jsonReader.nextString(this.requiredAction);
                break;
            case "analytics_token":
                this.analyticsToken = jsonReader.nextString(this.analyticsToken);
                break;
            case "friend_suggestion_count":
                this.friendSuggestionCount = jsonReader.nextInt(0);
                break;
            case "sessions":
                this.sessions = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.m
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        return (ModelSession) jsonReader.parse(new ModelSession());
                    }
                });
                break;
            case "country_code":
                this.countryCode = jsonReader.nextString(this.countryCode);
                break;
            case "user_settings":
                this.userSettings = (ModelUserSettings) jsonReader.parse(new ModelUserSettings());
                break;
            case "experiments":
                this.experiments = jsonReader.nextListAsMap(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.a0
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        return UserExperimentDto.Parser.parse(jsonReader);
                    }
                }, new Model.JsonReader.KeySelector() { // from class: b.a.m.a.f0
                    @Override // com.discord.models.domain.Model.JsonReader.KeySelector
                    public final Object get(Object obj) {
                        return Long.valueOf(((UserExperimentDto) obj).getNameHash());
                    }
                });
                break;
            case "session_id":
                this.sessionId = jsonReader.nextString(this.sessionId);
                break;
            case "private_channels":
                this.privateChannels = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.b0
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        return (Channel) InboundGatewayGsonParser.fromJson(jsonReader, Channel.class);
                    }
                });
                break;
            default:
                jsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelPayload;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelPayload)) {
            return false;
        }
        ModelPayload modelPayload = (ModelPayload) obj;
        if (!modelPayload.canEqual(this) || getV() != modelPayload.getV() || getFriendSuggestionCount() != modelPayload.getFriendSuggestionCount()) {
            return false;
        }
        User me2 = getMe();
        User me3 = modelPayload.getMe();
        if (me2 != null ? !me2.equals(me3) : me3 != null) {
            return false;
        }
        ModelUserSettings userSettings = getUserSettings();
        ModelUserSettings userSettings2 = modelPayload.getUserSettings();
        if (userSettings != null ? !userSettings.equals(userSettings2) : userSettings2 != null) {
            return false;
        }
        VersionedUserGuildSettings userGuildSettings = getUserGuildSettings();
        VersionedUserGuildSettings userGuildSettings2 = modelPayload.getUserGuildSettings();
        if (userGuildSettings != null ? !userGuildSettings.equals(userGuildSettings2) : userGuildSettings2 != null) {
            return false;
        }
        String sessionId = getSessionId();
        String sessionId2 = modelPayload.getSessionId();
        if (sessionId != null ? !sessionId.equals(sessionId2) : sessionId2 != null) {
            return false;
        }
        List<ModelUserRelationship> relationships = getRelationships();
        List<ModelUserRelationship> relationships2 = modelPayload.getRelationships();
        if (relationships != null ? !relationships.equals(relationships2) : relationships2 != null) {
            return false;
        }
        VersionedReadStates readState = getReadState();
        VersionedReadStates readState2 = modelPayload.getReadState();
        if (readState != null ? !readState.equals(readState2) : readState2 != null) {
            return false;
        }
        List<Channel> privateChannels = getPrivateChannels();
        List<Channel> privateChannels2 = modelPayload.getPrivateChannels();
        if (privateChannels != null ? !privateChannels.equals(privateChannels2) : privateChannels2 != null) {
            return false;
        }
        List<Guild> guilds = getGuilds();
        List<Guild> guilds2 = modelPayload.getGuilds();
        if (guilds != null ? !guilds.equals(guilds2) : guilds2 != null) {
            return false;
        }
        List<GuildJoinRequest> guildJoinRequests = getGuildJoinRequests();
        List<GuildJoinRequest> guildJoinRequests2 = modelPayload.getGuildJoinRequests();
        if (guildJoinRequests != null ? !guildJoinRequests.equals(guildJoinRequests2) : guildJoinRequests2 != null) {
            return false;
        }
        List<Presence> presences = getPresences();
        List<Presence> presences2 = modelPayload.getPresences();
        if (presences != null ? !presences.equals(presences2) : presences2 != null) {
            return false;
        }
        String analyticsToken = getAnalyticsToken();
        String analyticsToken2 = modelPayload.getAnalyticsToken();
        if (analyticsToken != null ? !analyticsToken.equals(analyticsToken2) : analyticsToken2 != null) {
            return false;
        }
        String authToken = getAuthToken();
        String authToken2 = modelPayload.getAuthToken();
        if (authToken != null ? !authToken.equals(authToken2) : authToken2 != null) {
            return false;
        }
        String requiredAction = getRequiredAction();
        String requiredAction2 = modelPayload.getRequiredAction();
        if (requiredAction != null ? !requiredAction.equals(requiredAction2) : requiredAction2 != null) {
            return false;
        }
        Map<Long, UserExperimentDto> experiments = getExperiments();
        Map<Long, UserExperimentDto> experiments2 = modelPayload.getExperiments();
        if (experiments != null ? !experiments.equals(experiments2) : experiments2 != null) {
            return false;
        }
        List<GuildExperimentDto> guildExperiments = getGuildExperiments();
        List<GuildExperimentDto> guildExperiments2 = modelPayload.getGuildExperiments();
        if (guildExperiments != null ? !guildExperiments.equals(guildExperiments2) : guildExperiments2 != null) {
            return false;
        }
        List<ConnectedAccount> connectedAccounts = getConnectedAccounts();
        List<ConnectedAccount> connectedAccounts2 = modelPayload.getConnectedAccounts();
        if (connectedAccounts != null ? !connectedAccounts.equals(connectedAccounts2) : connectedAccounts2 != null) {
            return false;
        }
        List<ModelSession> sessions = getSessions();
        List<ModelSession> sessions2 = modelPayload.getSessions();
        if (sessions != null ? !sessions.equals(sessions2) : sessions2 != null) {
            return false;
        }
        List<User> users = getUsers();
        List<User> users2 = modelPayload.getUsers();
        if (users != null ? !users.equals(users2) : users2 != null) {
            return false;
        }
        List<List<Presence>> guildPresences = getGuildPresences();
        List<List<Presence>> guildPresences2 = modelPayload.getGuildPresences();
        if (guildPresences != null ? !guildPresences.equals(guildPresences2) : guildPresences2 != null) {
            return false;
        }
        List<List<GuildMember>> guildMembers = getGuildMembers();
        List<List<GuildMember>> guildMembers2 = modelPayload.getGuildMembers();
        if (guildMembers != null ? !guildMembers.equals(guildMembers2) : guildMembers2 != null) {
            return false;
        }
        String countryCode = getCountryCode();
        String countryCode2 = modelPayload.getCountryCode();
        if (countryCode != null ? !countryCode.equals(countryCode2) : countryCode2 != null) {
            return false;
        }
        Object trace = getTrace();
        Object trace2 = modelPayload.getTrace();
        if (trace != null ? !trace.equals(trace2) : trace2 != null) {
            return false;
        }
        UserSurvey userSurvey = getUserSurvey();
        UserSurvey userSurvey2 = modelPayload.getUserSurvey();
        return userSurvey != null ? userSurvey.equals(userSurvey2) : userSurvey2 == null;
    }

    public String getAnalyticsToken() {
        return this.analyticsToken;
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public List<ConnectedAccount> getConnectedAccounts() {
        return this.connectedAccounts;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public Map<Long, UserExperimentDto> getExperiments() {
        return this.experiments;
    }

    public int getFriendSuggestionCount() {
        return this.friendSuggestionCount;
    }

    @Nullable
    public List<GuildExperimentDto> getGuildExperiments() {
        return this.guildExperiments;
    }

    public List<GuildJoinRequest> getGuildJoinRequests() {
        return this.guildJoinRequests;
    }

    public List<List<GuildMember>> getGuildMembers() {
        return this.guildMembers;
    }

    public List<List<Presence>> getGuildPresences() {
        return this.guildPresences;
    }

    public List<Guild> getGuilds() {
        return this.guilds;
    }

    public User getMe() {
        return this.f2726me;
    }

    public List<Presence> getPresences() {
        return this.presences;
    }

    public List<Channel> getPrivateChannels() {
        return this.privateChannels;
    }

    public VersionedReadStates getReadState() {
        return this.readState;
    }

    public List<ModelUserRelationship> getRelationships() {
        return this.relationships;
    }

    public String getRequiredAction() {
        return this.requiredAction;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public List<ModelSession> getSessions() {
        return this.sessions;
    }

    public Object getTrace() {
        return this.trace;
    }

    public VersionedUserGuildSettings getUserGuildSettings() {
        return this.userGuildSettings;
    }

    public ModelUserSettings getUserSettings() {
        return this.userSettings;
    }

    public UserSurvey getUserSurvey() {
        return this.userSurvey;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public int getV() {
        return this.v;
    }

    public int hashCode() {
        int friendSuggestionCount = getFriendSuggestionCount() + ((getV() + 59) * 59);
        User me2 = getMe();
        int iHashCode = (friendSuggestionCount * 59) + (me2 == null ? 43 : me2.hashCode());
        ModelUserSettings userSettings = getUserSettings();
        int iHashCode2 = (iHashCode * 59) + (userSettings == null ? 43 : userSettings.hashCode());
        VersionedUserGuildSettings userGuildSettings = getUserGuildSettings();
        int iHashCode3 = (iHashCode2 * 59) + (userGuildSettings == null ? 43 : userGuildSettings.hashCode());
        String sessionId = getSessionId();
        int iHashCode4 = (iHashCode3 * 59) + (sessionId == null ? 43 : sessionId.hashCode());
        List<ModelUserRelationship> relationships = getRelationships();
        int iHashCode5 = (iHashCode4 * 59) + (relationships == null ? 43 : relationships.hashCode());
        VersionedReadStates readState = getReadState();
        int iHashCode6 = (iHashCode5 * 59) + (readState == null ? 43 : readState.hashCode());
        List<Channel> privateChannels = getPrivateChannels();
        int iHashCode7 = (iHashCode6 * 59) + (privateChannels == null ? 43 : privateChannels.hashCode());
        List<Guild> guilds = getGuilds();
        int iHashCode8 = (iHashCode7 * 59) + (guilds == null ? 43 : guilds.hashCode());
        List<GuildJoinRequest> guildJoinRequests = getGuildJoinRequests();
        int iHashCode9 = (iHashCode8 * 59) + (guildJoinRequests == null ? 43 : guildJoinRequests.hashCode());
        List<Presence> presences = getPresences();
        int iHashCode10 = (iHashCode9 * 59) + (presences == null ? 43 : presences.hashCode());
        String analyticsToken = getAnalyticsToken();
        int iHashCode11 = (iHashCode10 * 59) + (analyticsToken == null ? 43 : analyticsToken.hashCode());
        String authToken = getAuthToken();
        int iHashCode12 = (iHashCode11 * 59) + (authToken == null ? 43 : authToken.hashCode());
        String requiredAction = getRequiredAction();
        int iHashCode13 = (iHashCode12 * 59) + (requiredAction == null ? 43 : requiredAction.hashCode());
        Map<Long, UserExperimentDto> experiments = getExperiments();
        int iHashCode14 = (iHashCode13 * 59) + (experiments == null ? 43 : experiments.hashCode());
        List<GuildExperimentDto> guildExperiments = getGuildExperiments();
        int iHashCode15 = (iHashCode14 * 59) + (guildExperiments == null ? 43 : guildExperiments.hashCode());
        List<ConnectedAccount> connectedAccounts = getConnectedAccounts();
        int iHashCode16 = (iHashCode15 * 59) + (connectedAccounts == null ? 43 : connectedAccounts.hashCode());
        List<ModelSession> sessions = getSessions();
        int iHashCode17 = (iHashCode16 * 59) + (sessions == null ? 43 : sessions.hashCode());
        List<User> users = getUsers();
        int iHashCode18 = (iHashCode17 * 59) + (users == null ? 43 : users.hashCode());
        List<List<Presence>> guildPresences = getGuildPresences();
        int iHashCode19 = (iHashCode18 * 59) + (guildPresences == null ? 43 : guildPresences.hashCode());
        List<List<GuildMember>> guildMembers = getGuildMembers();
        int iHashCode20 = (iHashCode19 * 59) + (guildMembers == null ? 43 : guildMembers.hashCode());
        String countryCode = getCountryCode();
        int iHashCode21 = (iHashCode20 * 59) + (countryCode == null ? 43 : countryCode.hashCode());
        Object trace = getTrace();
        int iHashCode22 = (iHashCode21 * 59) + (trace == null ? 43 : trace.hashCode());
        UserSurvey userSurvey = getUserSurvey();
        return (iHashCode22 * 59) + (userSurvey != null ? userSurvey.hashCode() : 43);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelPayload(v=");
        sbU.append(getV());
        sbU.append(", me=");
        sbU.append(getMe());
        sbU.append(", userSettings=");
        sbU.append(getUserSettings());
        sbU.append(", userGuildSettings=");
        sbU.append(getUserGuildSettings());
        sbU.append(", sessionId=");
        sbU.append(getSessionId());
        sbU.append(", relationships=");
        sbU.append(getRelationships());
        sbU.append(", readState=");
        sbU.append(getReadState());
        sbU.append(", privateChannels=");
        sbU.append(getPrivateChannels());
        sbU.append(", guilds=");
        sbU.append(getGuilds());
        sbU.append(", guildJoinRequests=");
        sbU.append(getGuildJoinRequests());
        sbU.append(", presences=");
        sbU.append(getPresences());
        sbU.append(", analyticsToken=");
        sbU.append(getAnalyticsToken());
        sbU.append(", authToken=");
        sbU.append(getAuthToken());
        sbU.append(", requiredAction=");
        sbU.append(getRequiredAction());
        sbU.append(", experiments=");
        sbU.append(getExperiments());
        sbU.append(", guildExperiments=");
        sbU.append(getGuildExperiments());
        sbU.append(", connectedAccounts=");
        sbU.append(getConnectedAccounts());
        sbU.append(", sessions=");
        sbU.append(getSessions());
        sbU.append(", users=");
        sbU.append(getUsers());
        sbU.append(", guildPresences=");
        sbU.append(getGuildPresences());
        sbU.append(", guildMembers=");
        sbU.append(getGuildMembers());
        sbU.append(", countryCode=");
        sbU.append(getCountryCode());
        sbU.append(", trace=");
        sbU.append(getTrace());
        sbU.append(", userSurvey=");
        sbU.append(getUserSurvey());
        sbU.append(", friendSuggestionCount=");
        sbU.append(getFriendSuggestionCount());
        sbU.append(")");
        return sbU.toString();
    }

    public ModelPayload withGuilds(List<Guild> list) {
        ModelPayload modelPayload = new ModelPayload(this);
        modelPayload.guilds = list;
        return modelPayload;
    }

    public ModelPayload withHydratedUserData(List<ModelUserRelationship> list, List<Channel> list2, List<List<Presence>> list3, List<List<GuildMember>> list4, List<Presence> list5) {
        ModelPayload modelPayload = new ModelPayload(this);
        modelPayload.relationships = list;
        modelPayload.privateChannels = list2;
        modelPayload.guildPresences = list3;
        modelPayload.guildMembers = list4;
        modelPayload.presences = list5;
        return modelPayload;
    }

    public ModelPayload(ModelPayload modelPayload) {
        this.v = modelPayload.v;
        this.f2726me = modelPayload.f2726me;
        this.userSettings = modelPayload.userSettings;
        this.userGuildSettings = modelPayload.userGuildSettings;
        this.sessionId = modelPayload.sessionId;
        this.relationships = modelPayload.relationships;
        this.readState = modelPayload.readState;
        this.privateChannels = modelPayload.privateChannels;
        this.guilds = modelPayload.guilds;
        this.guildJoinRequests = modelPayload.guildJoinRequests;
        this.presences = modelPayload.presences;
        this.analyticsToken = modelPayload.analyticsToken;
        this.authToken = modelPayload.authToken;
        this.requiredAction = modelPayload.requiredAction;
        this.experiments = modelPayload.experiments;
        this.guildExperiments = modelPayload.guildExperiments;
        this.connectedAccounts = modelPayload.connectedAccounts;
        this.sessions = modelPayload.sessions;
        this.users = modelPayload.users;
        this.guildPresences = modelPayload.guildPresences;
        this.guildMembers = modelPayload.guildMembers;
        this.countryCode = modelPayload.countryCode;
        this.trace = modelPayload.trace;
        this.userSurvey = modelPayload.userSurvey;
        this.friendSuggestionCount = modelPayload.friendSuggestionCount;
    }
}
