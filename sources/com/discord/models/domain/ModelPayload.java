package com.discord.models.domain;

import androidx.annotation.Nullable;
import b.a.m.a.a0;
import b.a.m.a.b0;
import b.a.m.a.f0;
import b.a.m.a.g0;
import b.a.m.a.l;
import b.a.m.a.m;
import b.a.m.a.n;
import b.a.m.a.s;
import b.a.m.a.v;
import b.a.m.a.w;
import b.a.m.a.x;
import b.a.m.a.y;
import b.a.m.a.z;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.guild.Guild;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.presence.Presence;
import com.discord.api.user.User;
import com.discord.api.user.UserSurvey;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
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
    private ModelPayload$VersionedReadStates readState;
    private List<ModelUserRelationship> relationships;
    private String requiredAction;
    private String sessionId;
    private List<ModelSession> sessions;
    private Object trace;
    private ModelPayload$VersionedUserGuildSettings userGuildSettings;
    private ModelUserSettings userSettings;
    private UserSurvey userSurvey;
    private List<User> users;
    private int v;

    public ModelPayload() {
    }

    private Object getTraces(Model$JsonReader model$JsonReader) throws IOException {
        model$JsonReader.getClass();
        List listNextList = model$JsonReader.nextList(new g0(model$JsonReader));
        if (listNextList.size() <= 0 || listNextList.get(0) == null) {
            return null;
        }
        return new Gson().f((String) listNextList.get(0), Object.class);
    }

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "auth_token":
                this.authToken = model$JsonReader.nextString(this.authToken);
                break;
            case "user_guild_settings":
                this.userGuildSettings = (ModelPayload$VersionedUserGuildSettings) model$JsonReader.parse(new ModelPayload$VersionedUserGuildSettings());
                break;
            case "_trace":
                this.trace = getTraces(model$JsonReader);
                break;
            case "merged_members":
                this.guildMembers = model$JsonReader.nextList(new s(model$JsonReader));
                break;
            case "merged_presences":
                ModelPayload$MergedPresences modelPayload$MergedPresences = (ModelPayload$MergedPresences) model$JsonReader.parse(new ModelPayload$MergedPresences());
                this.presences = ModelPayload$MergedPresences.access$000(modelPayload$MergedPresences);
                this.guildPresences = ModelPayload$MergedPresences.access$100(modelPayload$MergedPresences);
                break;
            case "guilds":
                this.guilds = model$JsonReader.nextList(new l(model$JsonReader));
                break;
            case "presences":
                this.presences = model$JsonReader.nextList(new v(model$JsonReader));
                break;
            case "guild_join_requests":
                this.guildJoinRequests = model$JsonReader.nextList(new y(model$JsonReader));
                break;
            case "read_state":
                this.readState = (ModelPayload$VersionedReadStates) model$JsonReader.parse(new ModelPayload$VersionedReadStates());
                break;
            case "user_survey":
                this.userSurvey = (UserSurvey) InboundGatewayGsonParser.fromJson(model$JsonReader, UserSurvey.class);
                break;
            case "v":
                this.v = model$JsonReader.nextInt(this.v);
                break;
            case "user":
                this.f2726me = (User) InboundGatewayGsonParser.fromJson(model$JsonReader, User.class);
                break;
            case "users":
                this.users = model$JsonReader.nextList(new w(model$JsonReader));
                break;
            case "connected_accounts":
                this.connectedAccounts = model$JsonReader.nextList(new n(model$JsonReader));
                break;
            case "guild_experiments":
                this.guildExperiments = model$JsonReader.nextList(new z(model$JsonReader));
                break;
            case "relationships":
                this.relationships = model$JsonReader.nextList(new x(model$JsonReader));
                break;
            case "required_action":
                this.requiredAction = model$JsonReader.nextString(this.requiredAction);
                break;
            case "analytics_token":
                this.analyticsToken = model$JsonReader.nextString(this.analyticsToken);
                break;
            case "friend_suggestion_count":
                this.friendSuggestionCount = model$JsonReader.nextInt(0);
                break;
            case "sessions":
                this.sessions = model$JsonReader.nextList(new m(model$JsonReader));
                break;
            case "country_code":
                this.countryCode = model$JsonReader.nextString(this.countryCode);
                break;
            case "user_settings":
                this.userSettings = (ModelUserSettings) model$JsonReader.parse(new ModelUserSettings());
                break;
            case "experiments":
                this.experiments = model$JsonReader.nextListAsMap(new a0(model$JsonReader), f0.a);
                break;
            case "session_id":
                this.sessionId = model$JsonReader.nextString(this.sessionId);
                break;
            case "private_channels":
                this.privateChannels = model$JsonReader.nextList(new b0(model$JsonReader));
                break;
            default:
                model$JsonReader.skipValue();
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
        ModelPayload$VersionedUserGuildSettings userGuildSettings = getUserGuildSettings();
        ModelPayload$VersionedUserGuildSettings userGuildSettings2 = modelPayload.getUserGuildSettings();
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
        ModelPayload$VersionedReadStates readState = getReadState();
        ModelPayload$VersionedReadStates readState2 = modelPayload.getReadState();
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

    public ModelPayload$VersionedReadStates getReadState() {
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

    public ModelPayload$VersionedUserGuildSettings getUserGuildSettings() {
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
        ModelPayload$VersionedUserGuildSettings userGuildSettings = getUserGuildSettings();
        int iHashCode3 = (iHashCode2 * 59) + (userGuildSettings == null ? 43 : userGuildSettings.hashCode());
        String sessionId = getSessionId();
        int iHashCode4 = (iHashCode3 * 59) + (sessionId == null ? 43 : sessionId.hashCode());
        List<ModelUserRelationship> relationships = getRelationships();
        int iHashCode5 = (iHashCode4 * 59) + (relationships == null ? 43 : relationships.hashCode());
        ModelPayload$VersionedReadStates readState = getReadState();
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
        StringBuilder sbU = a.U("ModelPayload(v=");
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
