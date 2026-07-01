package com.discord.stores;

import android.content.Context;
import com.discord.api.commands.ApplicationCommandAutocompleteResult;
import com.discord.api.commands.GuildApplicationCommands;
import com.discord.api.permission.Permission;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.NonceGenerator;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import d0.d0.f;
import d0.g0.t;
import d0.g0.w;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.t.o;
import d0.t.s;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands extends StoreV2 {
    public static final int COMMANDS_LIMIT_PER_REQUEST = 20;
    public static final long TYPE_APPLICATION_COMMAND = 2;
    public static final long TYPE_APPLICATION_COMMAND_AUTOCOMPLETE = 4;
    private Map<Long, Integer> applicationCommandIndexes;
    private String applicationNonce;
    private List<Application> applications;
    private Map<Long, Application> applicationsMapSnapshot;
    private List<Application> applicationsSnapshot;
    private Map<String, CommandOptionAutocompleteQuery> autocompleteNonceData;
    private Map<String, Map<String, CommandAutocompleteState>> autocompleteOptionResults;
    private Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> autocompleteOptionResultsSnapshot;
    private final BuiltInCommandsProvider builtInCommandsProvider;
    private boolean connectionReady;
    private int currentEndOffset;
    private int currentStartOffset;
    private Long discoverApplicationId;
    private DiscoverCommands discoverCommands;
    private String discoverCommandsNonce;
    private DiscoverCommands discoverCommandsSnapshot;
    private Long discoverGuildId;
    private final Dispatcher dispatcher;
    private Map<Long, List<ApplicationCommand>> frecencyCommands;
    private Map<Long, ? extends List<? extends ApplicationCommand>> frecencyCommandsSnapshot;
    private Map<String, StoreApplicationCommands$FrecencyRequest> frecencyRequests;
    private boolean initialApplicationsRequested;
    private boolean isLoadingDiscoveryCommands;
    private Long jumpedApplicationId;
    private int jumpedSequenceId;
    private boolean loadDirectionDown;
    private boolean loadDirectionUp;
    private final NonceGenerator nonceGenerator;
    private int numRemoteCommands;
    private final ObservationDeck observationDeck;
    private User pendingBotUser;
    private Long pendingGatewayGuildId;
    private String query;
    private final List<ApplicationCommand> queryCommands;
    private List<? extends ApplicationCommand> queryCommandsSnapshot;
    private Long queryGuildId;
    private String queryNonce;
    private final RestAPI restApi;
    private String sessionId;
    private final StoreApplicationCommandFrecency storeApplicationCommandFrecency;
    private final StoreExperiments storeExperiments;
    private final StoreGatewayConnection storeGatewayConnection;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final StoreUser storeUsers;
    public static final StoreApplicationCommands$Companion Companion = new StoreApplicationCommands$Companion(null);
    private static final ObservationDeck$UpdateSource DiscoverCommandsUpdate = new StoreApplicationCommands$Companion$DiscoverCommandsUpdate$1();
    private static final ObservationDeck$UpdateSource QueryCommandsUpdate = new StoreApplicationCommands$Companion$QueryCommandsUpdate$1();
    private static final ObservationDeck$UpdateSource GuildApplicationsUpdate = new StoreApplicationCommands$Companion$GuildApplicationsUpdate$1();
    private static final ObservationDeck$UpdateSource AutocompleteResultsUpdate = new StoreApplicationCommands$Companion$AutocompleteResultsUpdate$1();
    private static final ObservationDeck$UpdateSource FrecencyCommandsUpdate = new StoreApplicationCommands$Companion$FrecencyCommandsUpdate$1();

    public /* synthetic */ StoreApplicationCommands(StoreGatewayConnection storeGatewayConnection, StorePermissions storePermissions, StoreApplicationCommandFrecency storeApplicationCommandFrecency, StoreGuilds storeGuilds, StoreUser storeUser, StoreExperiments storeExperiments, Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, BuiltInCommandsProvider builtInCommandsProvider, NonceGenerator nonceGenerator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeGatewayConnection, storePermissions, storeApplicationCommandFrecency, storeGuilds, storeUser, storeExperiments, dispatcher, (i & 128) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 256) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 512) != 0 ? new BuiltInCommands() : builtInCommandsProvider, (i & 1024) != 0 ? new NonceGenerator() : nonceGenerator);
    }

    public static final /* synthetic */ String access$generateNonce(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.generateNonce();
    }

    public static final /* synthetic */ Map access$getApplicationCommandIndexes$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.applicationCommandIndexes;
    }

    public static final /* synthetic */ void access$getApplicationCommandsViaRest(StoreApplicationCommands storeApplicationCommands, long j) {
        storeApplicationCommands.getApplicationCommandsViaRest(j);
    }

    public static final /* synthetic */ String access$getApplicationNonce$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.applicationNonce;
    }

    public static final /* synthetic */ List access$getApplications$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.applications;
    }

    public static final /* synthetic */ Map access$getAutocompleteNonceData$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.autocompleteNonceData;
    }

    public static final /* synthetic */ Map access$getAutocompleteOptionResults$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.autocompleteOptionResults;
    }

    public static final /* synthetic */ ObservationDeck$UpdateSource access$getAutocompleteResultsUpdate$cp() {
        return AutocompleteResultsUpdate;
    }

    public static final /* synthetic */ BuiltInCommandsProvider access$getBuiltInCommandsProvider$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.builtInCommandsProvider;
    }

    public static final /* synthetic */ Long access$getDiscoverApplicationId$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.discoverApplicationId;
    }

    public static final /* synthetic */ DiscoverCommands access$getDiscoverCommands$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.discoverCommands;
    }

    public static final /* synthetic */ String access$getDiscoverCommandsNonce$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.discoverCommandsNonce;
    }

    public static final /* synthetic */ ObservationDeck$UpdateSource access$getDiscoverCommandsUpdate$cp() {
        return DiscoverCommandsUpdate;
    }

    public static final /* synthetic */ Long access$getDiscoverGuildId$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.discoverGuildId;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.dispatcher;
    }

    public static final /* synthetic */ Map access$getFrecencyCommands$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.frecencyCommands;
    }

    public static final /* synthetic */ ObservationDeck$UpdateSource access$getFrecencyCommandsUpdate$cp() {
        return FrecencyCommandsUpdate;
    }

    public static final /* synthetic */ ObservationDeck$UpdateSource access$getGuildApplicationsUpdate$cp() {
        return GuildApplicationsUpdate;
    }

    public static final /* synthetic */ boolean access$getLoadDirectionDown$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.loadDirectionDown;
    }

    public static final /* synthetic */ boolean access$getLoadDirectionUp$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.loadDirectionUp;
    }

    public static final /* synthetic */ Long access$getPendingGatewayGuildId$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.pendingGatewayGuildId;
    }

    public static final /* synthetic */ String access$getQuery$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.query;
    }

    public static final /* synthetic */ List access$getQueryCommands$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.queryCommands;
    }

    public static final /* synthetic */ ObservationDeck$UpdateSource access$getQueryCommandsUpdate$cp() {
        return QueryCommandsUpdate;
    }

    public static final /* synthetic */ Long access$getQueryGuildId$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.queryGuildId;
    }

    public static final /* synthetic */ String access$getQueryNonce$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.queryNonce;
    }

    public static final /* synthetic */ RestAPI access$getRestApi$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.restApi;
    }

    public static final /* synthetic */ String access$getSessionId$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.sessionId;
    }

    public static final /* synthetic */ StoreApplicationCommandFrecency access$getStoreApplicationCommandFrecency$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.storeApplicationCommandFrecency;
    }

    public static final /* synthetic */ StoreExperiments access$getStoreExperiments$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.storeExperiments;
    }

    public static final /* synthetic */ StoreGatewayConnection access$getStoreGatewayConnection$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.storeGatewayConnection;
    }

    public static final /* synthetic */ StorePermissions access$getStorePermissions$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.storePermissions;
    }

    public static final /* synthetic */ void access$handleDiscoverCommandsUpdate(StoreApplicationCommands storeApplicationCommands, List list) {
        storeApplicationCommands.handleDiscoverCommandsUpdate(list);
    }

    public static final /* synthetic */ void access$handleFrecencyCommandsUpdate(StoreApplicationCommands storeApplicationCommands, String str, List list) {
        storeApplicationCommands.handleFrecencyCommandsUpdate(str, list);
    }

    public static final /* synthetic */ void access$handleGuildApplicationsUpdate(StoreApplicationCommands storeApplicationCommands, List list) {
        storeApplicationCommands.handleGuildApplicationsUpdate(list);
    }

    public static final /* synthetic */ void access$handleQueryCommandsUpdate(StoreApplicationCommands storeApplicationCommands, List list) {
        storeApplicationCommands.handleQueryCommandsUpdate(list);
    }

    public static final /* synthetic */ boolean access$isLoadingDiscoveryCommands$p(StoreApplicationCommands storeApplicationCommands) {
        return storeApplicationCommands.isLoadingDiscoveryCommands;
    }

    public static final /* synthetic */ void access$setApplicationCommandIndexes$p(StoreApplicationCommands storeApplicationCommands, Map map) {
        storeApplicationCommands.applicationCommandIndexes = map;
    }

    public static final /* synthetic */ void access$setApplicationNonce$p(StoreApplicationCommands storeApplicationCommands, String str) {
        storeApplicationCommands.applicationNonce = str;
    }

    public static final /* synthetic */ void access$setApplications$p(StoreApplicationCommands storeApplicationCommands, List list) {
        storeApplicationCommands.applications = list;
    }

    public static final /* synthetic */ void access$setAutocompleteNonceData$p(StoreApplicationCommands storeApplicationCommands, Map map) {
        storeApplicationCommands.autocompleteNonceData = map;
    }

    public static final /* synthetic */ void access$setAutocompleteOptionResults$p(StoreApplicationCommands storeApplicationCommands, Map map) {
        storeApplicationCommands.autocompleteOptionResults = map;
    }

    public static final /* synthetic */ void access$setDiscoverApplicationId$p(StoreApplicationCommands storeApplicationCommands, Long l) {
        storeApplicationCommands.discoverApplicationId = l;
    }

    public static final /* synthetic */ void access$setDiscoverCommands$p(StoreApplicationCommands storeApplicationCommands, DiscoverCommands discoverCommands) {
        storeApplicationCommands.discoverCommands = discoverCommands;
    }

    public static final /* synthetic */ void access$setDiscoverCommandsNonce$p(StoreApplicationCommands storeApplicationCommands, String str) {
        storeApplicationCommands.discoverCommandsNonce = str;
    }

    public static final /* synthetic */ void access$setDiscoverGuildId$p(StoreApplicationCommands storeApplicationCommands, Long l) {
        storeApplicationCommands.discoverGuildId = l;
    }

    public static final /* synthetic */ void access$setFrecencyCommands$p(StoreApplicationCommands storeApplicationCommands, Map map) {
        storeApplicationCommands.frecencyCommands = map;
    }

    public static final /* synthetic */ void access$setLoadDirectionDown$p(StoreApplicationCommands storeApplicationCommands, boolean z2) {
        storeApplicationCommands.loadDirectionDown = z2;
    }

    public static final /* synthetic */ void access$setLoadDirectionUp$p(StoreApplicationCommands storeApplicationCommands, boolean z2) {
        storeApplicationCommands.loadDirectionUp = z2;
    }

    public static final /* synthetic */ void access$setLoadingDiscoveryCommands$p(StoreApplicationCommands storeApplicationCommands, boolean z2) {
        storeApplicationCommands.isLoadingDiscoveryCommands = z2;
    }

    public static final /* synthetic */ void access$setPendingGatewayGuildId$p(StoreApplicationCommands storeApplicationCommands, Long l) {
        storeApplicationCommands.pendingGatewayGuildId = l;
    }

    public static final /* synthetic */ void access$setQuery$p(StoreApplicationCommands storeApplicationCommands, String str) {
        storeApplicationCommands.query = str;
    }

    public static final /* synthetic */ void access$setQueryGuildId$p(StoreApplicationCommands storeApplicationCommands, Long l) {
        storeApplicationCommands.queryGuildId = l;
    }

    public static final /* synthetic */ void access$setQueryNonce$p(StoreApplicationCommands storeApplicationCommands, String str) {
        storeApplicationCommands.queryNonce = str;
    }

    public static final /* synthetic */ void access$setSessionId$p(StoreApplicationCommands storeApplicationCommands, String str) {
        storeApplicationCommands.sessionId = str;
    }

    public static final /* synthetic */ boolean access$shouldReturnApplicationCommands(StoreApplicationCommands storeApplicationCommands, Long l) {
        return storeApplicationCommands.shouldReturnApplicationCommands(l);
    }

    @StoreThread
    private final String generateNonce() {
        return String.valueOf(this.nonceGenerator.nonce());
    }

    private final void getApplicationCommandsViaRest(long applicationId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.getApplicationCommands(applicationId), false, 1, null), StoreApplicationCommands.class, (Context) null, (Function1) null, new StoreApplicationCommands$getApplicationCommandsViaRest$2(this), (Function0) null, (Function0) null, new StoreApplicationCommands$getApplicationCommandsViaRest$1(this, applicationId), 54, (Object) null);
    }

    @StoreThread
    private final void handleDiscoverCommandsUpdate(List<? extends ApplicationCommand> commands) {
        this.isLoadingDiscoveryCommands = false;
        List mutableList = u.toMutableList((Collection) this.discoverCommands.getCommands());
        int size = mutableList.size();
        Long l = this.jumpedApplicationId;
        if (l != null) {
            mutableList = u.toMutableList((Collection) commands);
            Integer num = this.applicationCommandIndexes.get(l);
            this.currentStartOffset = num != null ? num.intValue() : 0;
        } else if (this.loadDirectionUp) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : commands) {
                ApplicationCommand applicationCommand = (ApplicationCommand) obj;
                ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(mutableList, 10));
                Iterator it = mutableList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((ApplicationCommand) it.next()).getId());
                }
                if (!arrayList2.contains(applicationCommand.getId())) {
                    arrayList.add(obj);
                }
            }
            Iterator it2 = s.asReversed(arrayList).iterator();
            while (it2.hasNext()) {
                mutableList.add(0, (ApplicationCommand) it2.next());
            }
            this.currentStartOffset -= mutableList.size() - size;
        } else if (this.loadDirectionDown) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : commands) {
                ApplicationCommand applicationCommand2 = (ApplicationCommand) obj2;
                ArrayList arrayList4 = new ArrayList(o.collectionSizeOrDefault(mutableList, 10));
                Iterator it3 = mutableList.iterator();
                while (it3.hasNext()) {
                    arrayList4.add(((ApplicationCommand) it3.next()).getId());
                }
                if (!arrayList4.contains(applicationCommand2.getId())) {
                    arrayList3.add(obj2);
                }
            }
            mutableList = u.toMutableList((Collection) u.plus((Collection) mutableList, (Iterable) arrayList3));
        } else {
            mutableList = u.toMutableList((Collection) commands);
            this.currentStartOffset = 0;
        }
        List list = mutableList;
        if ((list.size() + this.currentStartOffset) - 1 == this.numRemoteCommands - 1) {
            list.addAll(this.builtInCommandsProvider.getBuiltInCommands());
        }
        this.currentEndOffset = (list.size() + this.currentStartOffset) - 1;
        this.discoverCommands = new DiscoverCommands(list, this.currentStartOffset, this.currentEndOffset, this.currentStartOffset > 0 && (list.isEmpty() ^ true), this.currentEndOffset < this.numRemoteCommands - 1, this.jumpedSequenceId, this.jumpedApplicationId, this.loadDirectionUp ? LoadState$JustLoadedUp.INSTANCE : this.loadDirectionDown ? LoadState$JustLoadedDown.INSTANCE : LoadState$JustLoadedAll.INSTANCE);
        markChanged(DiscoverCommandsUpdate);
    }

    @StoreThread
    private final void handleFrecencyCommandsUpdate(String nonce, List<? extends ApplicationCommand> commands) {
        int iIntValue;
        StoreApplicationCommands$FrecencyRequest storeApplicationCommands$FrecencyRequest = this.frecencyRequests.get(nonce);
        if (storeApplicationCommands$FrecencyRequest != null) {
            this.frecencyRequests.remove(nonce);
            List<ApplicationCommand> listFlattenSubCommands = StoreApplicationCommandsKt.flattenSubCommands(commands);
            Map<Long, List<ApplicationCommand>> map = this.frecencyCommands;
            Long guildId = storeApplicationCommands$FrecencyRequest.getGuildId();
            Long lValueOf = Long.valueOf(guildId != null ? guildId.longValue() : 0L);
            List<String> applicationCommandIds = storeApplicationCommands$FrecencyRequest.getApplicationCommandIds();
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(applicationCommandIds, 10));
            for (String str : applicationCommandIds) {
                Integer intOrNull = d0.g0.s.toIntOrNull(str);
                Object obj = null;
                if (intOrNull != null && (iIntValue = intOrNull.intValue()) < 0) {
                    for (Object obj2 : this.builtInCommandsProvider.getBuiltInCommands()) {
                        Integer intOrNull2 = d0.g0.s.toIntOrNull(((ApplicationCommand) obj2).getId());
                        if (intOrNull2 != null && intOrNull2.intValue() == iIntValue) {
                            obj = obj2;
                            break;
                        }
                    }
                } else {
                    for (Object obj3 : listFlattenSubCommands) {
                        if (m.areEqual(((ApplicationCommand) obj3).getId(), str)) {
                            obj = obj3;
                            break;
                        }
                    }
                }
                arrayList.add((ApplicationCommand) obj);
            }
            map.put(lValueOf, u.filterNotNull(arrayList));
            markChanged(FrecencyCommandsUpdate);
        }
    }

    @StoreThread
    private final void handleGuildApplicationsUpdate(List<Application> commands) {
        this.applications = commands;
        this.numRemoteCommands = 0;
        int commandCount = 0;
        for (Application application : commands) {
            this.applicationCommandIndexes.put(Long.valueOf(application.getId()), Integer.valueOf(commandCount));
            commandCount += application.getCommandCount();
            if (!application.getBuiltIn()) {
                this.numRemoteCommands = application.getCommandCount() + this.numRemoteCommands;
            }
        }
        markChanged(GuildApplicationsUpdate);
    }

    @StoreThread
    private final void handleQueryCommandsUpdate(List<? extends ApplicationCommand> commands) {
        this.queryCommands.clear();
        this.queryCommands.addAll(commands);
        String str = this.query;
        if (str != null) {
            List<ApplicationCommand> list = this.queryCommands;
            List<ApplicationCommand> builtInCommands = this.builtInCommandsProvider.getBuiltInCommands();
            ArrayList arrayList = new ArrayList();
            for (Object obj : builtInCommands) {
                if (t.startsWith(((ApplicationCommand) obj).getName(), str, true)) {
                    arrayList.add(obj);
                }
            }
            list.addAll(arrayList);
        }
        markChanged(QueryCommandsUpdate);
    }

    private final void requestApplicationCommands(Long guildId, int offset, Long applicationId, int limit) {
        this.dispatcher.schedule(new StoreApplicationCommands$requestApplicationCommands$1(this, guildId, offset, limit, applicationId));
    }

    public static /* synthetic */ void requestApplicationCommands$default(StoreApplicationCommands storeApplicationCommands, Long l, int i, Long l2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            l2 = null;
        }
        if ((i3 & 8) != 0) {
            i2 = 20;
        }
        storeApplicationCommands.requestApplicationCommands(l, i, l2, i2);
    }

    public static /* synthetic */ void requestInitialApplicationCommands$default(StoreApplicationCommands storeApplicationCommands, Long l, Long l2, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        storeApplicationCommands.requestInitialApplicationCommands(l, l2, z2);
    }

    @StoreThread
    private final void setAutocompleteState(String commandOptionName, String queryString, CommandAutocompleteState state) {
        Map<String, CommandAutocompleteState> mapEmptyMap = this.autocompleteOptionResults.get(commandOptionName);
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        if (mapEmptyMap.get(queryString) instanceof CommandAutocompleteState$Choices) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, CommandAutocompleteState> mapEmptyMap2 = this.autocompleteOptionResults.get(commandOptionName);
        if (mapEmptyMap2 == null) {
            mapEmptyMap2 = h0.emptyMap();
        }
        linkedHashMap.putAll(mapEmptyMap2);
        linkedHashMap.put(queryString, state);
        this.autocompleteOptionResults.put(commandOptionName, linkedHashMap);
        markChanged(AutocompleteResultsUpdate);
    }

    private final boolean shouldReturnApplicationCommands(Long channelPermissions) {
        Long l = this.discoverGuildId;
        return l == null || (l != null && l.longValue() == 0) || PermissionUtils.can(Permission.USE_APPLICATION_COMMANDS, channelPermissions);
    }

    public final void clearAutocompleteResults() {
        this.dispatcher.schedule(new StoreApplicationCommands$clearAutocompleteResults$1(this));
    }

    public final void clearQueryCommands() {
        this.dispatcher.schedule(new StoreApplicationCommands$clearQueryCommands$1(this));
    }

    public final Map<Long, Application> getApplicationMap() {
        return this.applicationsMapSnapshot;
    }

    public final List<Application> getApplications() {
        return this.applicationsSnapshot;
    }

    public final Map<String, Map<String, CommandAutocompleteState>> getAutocompleteOptionResults() {
        return this.autocompleteOptionResultsSnapshot;
    }

    /* JADX INFO: renamed from: getDiscoverCommands, reason: from getter */
    public final DiscoverCommands getDiscoverCommandsSnapshot() {
        return this.discoverCommandsSnapshot;
    }

    public final List<ApplicationCommand> getFrecencyCommands(long guildId) {
        List<ApplicationCommand> list = (List) this.frecencyCommandsSnapshot.get(Long.valueOf(guildId));
        return list != null ? list : n.emptyList();
    }

    public final List<ApplicationCommand> getQueryCommands() {
        return this.queryCommandsSnapshot;
    }

    @StoreThread
    public final void handleApplicationCommandAutocompleteResult(ApplicationCommandAutocompleteResult autocompleteResult) {
        m.checkNotNullParameter(autocompleteResult, "autocompleteResult");
        CommandOptionAutocompleteQuery commandOptionAutocompleteQuery = this.autocompleteNonceData.get(autocompleteResult.getNonce());
        if (commandOptionAutocompleteQuery != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Map<String, CommandAutocompleteState> mapEmptyMap = this.autocompleteOptionResults.get(commandOptionAutocompleteQuery.getCommandOptionName());
            if (mapEmptyMap == null) {
                mapEmptyMap = h0.emptyMap();
            }
            linkedHashMap.putAll(mapEmptyMap);
            linkedHashMap.put(commandOptionAutocompleteQuery.getQueryString(), new CommandAutocompleteState$Choices(autocompleteResult.a()));
            this.autocompleteOptionResults.put(commandOptionAutocompleteQuery.getCommandOptionName(), linkedHashMap);
            markChanged(AutocompleteResultsUpdate);
        }
    }

    @StoreThread
    public final void handleApplicationCommandsUpdate(GuildApplicationCommands commandsGateway) {
        m.checkNotNullParameter(commandsGateway, "commandsGateway");
        if (this.frecencyRequests.containsKey(commandsGateway.getNonce())) {
            String nonce = commandsGateway.getNonce();
            List<com.discord.api.commands.ApplicationCommand> listA = commandsGateway.a();
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listA, 10));
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(StoreApplicationCommandsKt.toSlashCommand((com.discord.api.commands.ApplicationCommand) it.next()));
            }
            handleFrecencyCommandsUpdate(nonce, arrayList);
            return;
        }
        String nonce2 = commandsGateway.getNonce();
        if (m.areEqual(nonce2, this.applicationNonce)) {
            List listListOf = d0.t.m.listOf(this.builtInCommandsProvider.getFrecencyApplication());
            List<com.discord.api.commands.Application> listB = commandsGateway.b();
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(listB, 10));
            Iterator<T> it2 = listB.iterator();
            while (it2.hasNext()) {
                arrayList2.add(StoreApplicationCommandsKt.toDomainApplication((com.discord.api.commands.Application) it2.next()));
            }
            handleGuildApplicationsUpdate(u.plus((Collection<? extends Application>) u.plus((Collection) listListOf, (Iterable) u.sortedWith(arrayList2, new StoreApplicationCommands$handleApplicationCommandsUpdate$$inlined$sortedBy$1())), this.builtInCommandsProvider.getBuiltInApplication()));
            return;
        }
        if (m.areEqual(nonce2, this.queryNonce)) {
            List<com.discord.api.commands.ApplicationCommand> listA2 = commandsGateway.a();
            ArrayList arrayList3 = new ArrayList(o.collectionSizeOrDefault(listA2, 10));
            Iterator<T> it3 = listA2.iterator();
            while (it3.hasNext()) {
                arrayList3.add(StoreApplicationCommandsKt.toSlashCommand((com.discord.api.commands.ApplicationCommand) it3.next()));
            }
            handleQueryCommandsUpdate(arrayList3);
            return;
        }
        if (m.areEqual(nonce2, this.discoverCommandsNonce)) {
            List<com.discord.api.commands.ApplicationCommand> listA3 = commandsGateway.a();
            ArrayList arrayList4 = new ArrayList(o.collectionSizeOrDefault(listA3, 10));
            Iterator<T> it4 = listA3.iterator();
            while (it4.hasNext()) {
                arrayList4.add(StoreApplicationCommandsKt.toSlashCommand((com.discord.api.commands.ApplicationCommand) it4.next()));
            }
            handleDiscoverCommandsUpdate(arrayList4);
        }
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
    }

    public final void handleConnectionReady(boolean connectionReady) {
        this.connectionReady = connectionReady;
        if (!connectionReady || this.initialApplicationsRequested) {
            return;
        }
        Long l = this.pendingGatewayGuildId;
        requestFrecencyCommands(l != null ? l.longValue() : 0L);
        Long l2 = this.pendingGatewayGuildId;
        if (l2 != null) {
            requestApplications(l2);
        }
        User user = this.pendingBotUser;
        if (user != null) {
            handleDmUserApplication(user);
        }
        if (this.pendingGatewayGuildId == null && this.pendingBotUser == null) {
            requestApplications(null);
        }
        this.initialApplicationsRequested = true;
        this.pendingGatewayGuildId = null;
        this.pendingBotUser = null;
    }

    public final void handleDmUserApplication(User botUser) {
        m.checkNotNullParameter(botUser, "botUser");
        if (botUser.getIsBot()) {
            if (this.connectionReady) {
                this.dispatcher.schedule(new StoreApplicationCommands$handleDmUserApplication$1(this, botUser));
            } else {
                this.pendingBotUser = botUser;
            }
        }
    }

    public final boolean hasFetchedApplicationCommands(long applicationId) {
        Integer num = this.applicationCommandIndexes.get(Long.valueOf(applicationId));
        if (num == null) {
            return false;
        }
        int iIntValue = num.intValue();
        return this.currentStartOffset <= iIntValue && this.currentEndOffset >= iIntValue;
    }

    public final Observable<Map<String, Map<String, CommandAutocompleteState>>> observeAutocompleteResults() {
        Observable<Map<String, Map<String, CommandAutocompleteState>>> observableT = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{AutocompleteResultsUpdate}, false, null, null, new StoreApplicationCommands$observeAutocompleteResults$1(this), 14, null).T(h0.emptyMap());
        m.checkNotNullExpressionValue(observableT, "observationDeck.connectR…  }.startWith(emptyMap())");
        return observableT;
    }

    public final Observable<DiscoverCommands> observeDiscoverCommands(long channelId) {
        Observable<DiscoverCommands> observableJ = Observable.j(ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{DiscoverCommandsUpdate}, false, null, null, new StoreApplicationCommands$observeDiscoverCommands$1(this), 14, null).r(), this.storePermissions.observePermissionsForChannel(channelId), new StoreApplicationCommands$observeDiscoverCommands$2(this));
        m.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…  )\n          }\n        }");
        return observableJ;
    }

    public final Observable<List<ApplicationCommand>> observeFrecencyCommands(long guildId) {
        Observable<List<ApplicationCommand>> observableT = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{FrecencyCommandsUpdate, this.storeExperiments}, false, null, null, new StoreApplicationCommands$observeFrecencyCommands$1(this, guildId), 14, null).T(n.emptyList());
        m.checkNotNullExpressionValue(observableT, "observationDeck.connectR…st<ApplicationCommand>())");
        return observableT;
    }

    public final Observable<List<Application>> observeGuildApplications(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{GuildApplicationsUpdate, this.storePermissions}, false, null, null, new StoreApplicationCommands$observeGuildApplications$1(this, channelId), 14, null);
    }

    public final Observable<List<ApplicationCommand>> observeQueryCommands(long channelId) {
        Observable<List<ApplicationCommand>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{QueryCommandsUpdate, this.storePermissions}, false, null, null, new StoreApplicationCommands$observeQueryCommands$1(this, channelId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void requestApplicationCommandAutocompleteData(Long guildId, long channelId, ApplicationCommandData data) {
        m.checkNotNullParameter(data, "data");
        this.dispatcher.schedule(new StoreApplicationCommands$requestApplicationCommandAutocompleteData$1(this, data, channelId, guildId));
    }

    public final void requestApplicationCommandsQuery(Long guildId, String query) {
        m.checkNotNullParameter(query, "query");
        this.dispatcher.schedule(new StoreApplicationCommands$requestApplicationCommandsQuery$1(this, guildId, query));
    }

    public final void requestApplications(Long guildId) {
        if (this.connectionReady) {
            this.dispatcher.schedule(new StoreApplicationCommands$requestApplications$1(this, guildId));
        } else {
            this.pendingGatewayGuildId = guildId;
        }
    }

    public final void requestDiscoverCommands(long applicationId) {
        Long l = this.discoverGuildId;
        if (l != null) {
            l.longValue();
            requestInitialApplicationCommands$default(this, l, Long.valueOf(applicationId), false, 4, null);
        }
    }

    public final void requestFrecencyCommands(long guildId) {
        List<String> topCommandIds = this.storeApplicationCommandFrecency.getTopCommandIds(Long.valueOf(guildId));
        String strGenerateNonce = generateNonce();
        StoreApplicationCommands$FrecencyRequest storeApplicationCommands$FrecencyRequest = new StoreApplicationCommands$FrecencyRequest(Long.valueOf(guildId), topCommandIds);
        if (this.frecencyRequests.containsValue(storeApplicationCommands$FrecencyRequest)) {
            return;
        }
        this.frecencyRequests.put(strGenerateNonce, storeApplicationCommands$FrecencyRequest);
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(topCommandIds, 10));
        for (String str : topCommandIds) {
            if (w.contains$default((CharSequence) str, (CharSequence) " ", false, 2, (Object) null)) {
                str = (String) w.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null).get(0);
            }
            arrayList.add(str);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Long longOrNull = d0.g0.s.toLongOrNull((String) next);
            if ((longOrNull != null ? longOrNull.longValue() : 0L) > 0) {
                arrayList2.add(next);
            }
        }
        if (!(!arrayList2.isEmpty())) {
            this.dispatcher.schedule(new StoreApplicationCommands$requestFrecencyCommands$2(this, strGenerateNonce));
        } else {
            if (StoreGatewayConnection.requestApplicationCommands$default(this.storeGatewayConnection, guildId, strGenerateNonce, false, null, null, 20, u.distinct(arrayList2), 24, null)) {
                return;
            }
            this.dispatcher.schedule(new StoreApplicationCommands$requestFrecencyCommands$1(this, strGenerateNonce));
        }
    }

    public final void requestInitialApplicationCommands(Long guildId, Long applicationId, boolean forDmDiscover) {
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        this.loadDirectionUp = false;
        this.loadDirectionDown = false;
        if (!forDmDiscover) {
            this.jumpedApplicationId = applicationId;
        }
        if (this.jumpedApplicationId != null) {
            this.jumpedSequenceId++;
        }
        if (applicationId != null) {
            long jLongValue = applicationId.longValue();
            this.discoverCommands = DiscoverCommands.copy$default(this.discoverCommands, n.emptyList(), 0, 0, false, false, 0, null, null, 254, null);
            if (this.applicationCommandIndexes.containsKey(Long.valueOf(jLongValue))) {
                Integer num = this.applicationCommandIndexes.get(Long.valueOf(jLongValue));
                int iIntValue = num != null ? num.intValue() : 0;
                ref$IntRef.element = iIntValue;
                this.currentStartOffset = iIntValue;
                this.currentEndOffset = iIntValue;
            }
            if (jLongValue == this.builtInCommandsProvider.getBuiltInApplication().getId()) {
                this.dispatcher.schedule(new StoreApplicationCommands$requestInitialApplicationCommands$$inlined$let$lambda$1(this, ref$IntRef));
                return;
            }
        }
        requestApplicationCommands$default(this, guildId, ref$IntRef.element, applicationId, 0, 8, null);
    }

    public final void requestLoadMoreDown() {
        Long l = this.discoverGuildId;
        if (l != null) {
            long jLongValue = l.longValue();
            requestApplicationCommands$default(this, Long.valueOf(jLongValue), this.currentEndOffset + 1, null, 20, 4, null);
            this.loadDirectionUp = false;
            this.loadDirectionDown = true;
            this.jumpedApplicationId = null;
            this.discoverCommands = DiscoverCommands.copy$default(this.discoverCommands, null, 0, 0, false, false, 0, null, LoadState$LoadingDown.INSTANCE, Opcodes.LAND, null);
        }
    }

    public final void requestLoadMoreUp() {
        int i;
        int i2;
        Long l = this.discoverGuildId;
        if (l != null) {
            long jLongValue = l.longValue();
            int i3 = this.currentStartOffset;
            int i4 = i3 - 20;
            if (i4 < 0) {
                i2 = i3;
                i = 0;
            } else {
                i = i4;
                i2 = 20;
            }
            requestApplicationCommands$default(this, Long.valueOf(jLongValue), i, null, i2, 4, null);
            this.loadDirectionUp = true;
            this.loadDirectionDown = false;
            this.jumpedApplicationId = null;
            this.discoverCommands = DiscoverCommands.copy$default(this.discoverCommands, null, 0, 0, false, false, 0, null, LoadState$LoadingUp.INSTANCE, Opcodes.LAND, null);
        }
    }

    @StoreThread
    public final void setAutocompleteFailed(String commandOptionName, String queryString) {
        m.checkNotNullParameter(commandOptionName, "commandOptionName");
        m.checkNotNullParameter(queryString, "queryString");
        setAutocompleteState(commandOptionName, queryString, CommandAutocompleteState$Failed.INSTANCE);
    }

    @StoreThread
    public final void setAutocompleteLoading(String commandOptionName, String queryString) {
        m.checkNotNullParameter(commandOptionName, "commandOptionName");
        m.checkNotNullParameter(queryString, "queryString");
        setAutocompleteState(commandOptionName, queryString, CommandAutocompleteState$Loading.INSTANCE);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        if (getUpdateSources().contains(DiscoverCommandsUpdate)) {
            DiscoverCommands discoverCommands = this.discoverCommands;
            this.discoverCommandsSnapshot = DiscoverCommands.copy$default(discoverCommands, StoreApplicationCommandsKt.flattenSubCommands(discoverCommands.getCommands()), 0, 0, false, false, 0, null, null, 254, null);
        }
        if (getUpdateSources().contains(QueryCommandsUpdate)) {
            this.queryCommandsSnapshot = new ArrayList(StoreApplicationCommandsKt.flattenSubCommands(this.queryCommands));
        }
        if (getUpdateSources().contains(GuildApplicationsUpdate)) {
            ArrayList arrayList = new ArrayList(this.applications);
            this.applicationsSnapshot = arrayList;
            LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(arrayList, 10)), 16));
            for (Object obj : arrayList) {
                linkedHashMap.put(Long.valueOf(((Application) obj).getId()), obj);
            }
            this.applicationsMapSnapshot = linkedHashMap;
        }
        if (getUpdateSources().contains(AutocompleteResultsUpdate)) {
            this.autocompleteOptionResultsSnapshot = new HashMap(this.autocompleteOptionResults);
        }
        if (getUpdateSources().contains(FrecencyCommandsUpdate)) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.putAll(this.frecencyCommands);
            this.frecencyCommandsSnapshot = linkedHashMap2;
        }
    }

    public StoreApplicationCommands(StoreGatewayConnection storeGatewayConnection, StorePermissions storePermissions, StoreApplicationCommandFrecency storeApplicationCommandFrecency, StoreGuilds storeGuilds, StoreUser storeUser, StoreExperiments storeExperiments, Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, BuiltInCommandsProvider builtInCommandsProvider, NonceGenerator nonceGenerator) {
        m.checkNotNullParameter(storeGatewayConnection, "storeGatewayConnection");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(storeApplicationCommandFrecency, "storeApplicationCommandFrecency");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeUser, "storeUsers");
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(restAPI, "restApi");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(builtInCommandsProvider, "builtInCommandsProvider");
        m.checkNotNullParameter(nonceGenerator, "nonceGenerator");
        this.storeGatewayConnection = storeGatewayConnection;
        this.storePermissions = storePermissions;
        this.storeApplicationCommandFrecency = storeApplicationCommandFrecency;
        this.storeGuilds = storeGuilds;
        this.storeUsers = storeUser;
        this.storeExperiments = storeExperiments;
        this.dispatcher = dispatcher;
        this.restApi = restAPI;
        this.observationDeck = observationDeck;
        this.builtInCommandsProvider = builtInCommandsProvider;
        this.nonceGenerator = nonceGenerator;
        DiscoverCommands$Companion discoverCommands$Companion = DiscoverCommands.Companion;
        this.discoverCommands = discoverCommands$Companion.getDefaultModelDiscoveryCommands();
        this.discoverCommandsSnapshot = discoverCommands$Companion.getDefaultModelDiscoveryCommands();
        this.applicationCommandIndexes = new LinkedHashMap();
        this.applications = n.emptyList();
        this.applicationsSnapshot = n.emptyList();
        this.applicationsMapSnapshot = h0.emptyMap();
        this.queryCommands = new ArrayList();
        this.queryCommandsSnapshot = n.emptyList();
        this.autocompleteNonceData = new LinkedHashMap();
        this.autocompleteOptionResults = new LinkedHashMap();
        this.autocompleteOptionResultsSnapshot = h0.emptyMap();
        this.frecencyRequests = new LinkedHashMap();
        this.frecencyCommands = new LinkedHashMap();
        this.frecencyCommandsSnapshot = h0.emptyMap();
    }
}
