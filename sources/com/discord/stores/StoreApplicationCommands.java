package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.commands.ApplicationCommandAutocompleteResult;
import com.discord.api.commands.GuildApplicationCommands;
import com.discord.api.permission.Permission;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandLocalSendData3;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.NonceGenerator;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.CommandAutocompleteState;
import com.discord.stores.DiscoverCommands;
import com.discord.stores.LoadState;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import d0.d0._Ranges;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t.ReversedViews3;
import d0.t._Collections;
import d0.u.a;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;

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
    private Map<String, FrecencyRequest> frecencyRequests;
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

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ObservationDeck.UpdateSource DiscoverCommandsUpdate = new ObservationDeck.UpdateSource() { // from class: com.discord.stores.StoreApplicationCommands$Companion$DiscoverCommandsUpdate$1
    };
    private static final ObservationDeck.UpdateSource QueryCommandsUpdate = new ObservationDeck.UpdateSource() { // from class: com.discord.stores.StoreApplicationCommands$Companion$QueryCommandsUpdate$1
    };
    private static final ObservationDeck.UpdateSource GuildApplicationsUpdate = new ObservationDeck.UpdateSource() { // from class: com.discord.stores.StoreApplicationCommands$Companion$GuildApplicationsUpdate$1
    };
    private static final ObservationDeck.UpdateSource AutocompleteResultsUpdate = new ObservationDeck.UpdateSource() { // from class: com.discord.stores.StoreApplicationCommands$Companion$AutocompleteResultsUpdate$1
    };
    private static final ObservationDeck.UpdateSource FrecencyCommandsUpdate = new ObservationDeck.UpdateSource() { // from class: com.discord.stores.StoreApplicationCommands$Companion$FrecencyCommandsUpdate$1
    };

    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ObservationDeck.UpdateSource getAutocompleteResultsUpdate() {
            return StoreApplicationCommands.AutocompleteResultsUpdate;
        }

        public final ObservationDeck.UpdateSource getDiscoverCommandsUpdate() {
            return StoreApplicationCommands.DiscoverCommandsUpdate;
        }

        public final ObservationDeck.UpdateSource getFrecencyCommandsUpdate() {
            return StoreApplicationCommands.FrecencyCommandsUpdate;
        }

        public final ObservationDeck.UpdateSource getGuildApplicationsUpdate() {
            return StoreApplicationCommands.GuildApplicationsUpdate;
        }

        public final ObservationDeck.UpdateSource getQueryCommandsUpdate() {
            return StoreApplicationCommands.QueryCommandsUpdate;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final /* data */ class FrecencyRequest {
        private final List<String> applicationCommandIds;
        private final Long guildId;

        public FrecencyRequest(Long l, List<String> list) {
            Intrinsics3.checkNotNullParameter(list, "applicationCommandIds");
            this.guildId = l;
            this.applicationCommandIds = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FrecencyRequest copy$default(FrecencyRequest frecencyRequest, Long l, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                l = frecencyRequest.guildId;
            }
            if ((i & 2) != 0) {
                list = frecencyRequest.applicationCommandIds;
            }
            return frecencyRequest.copy(l, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        public final List<String> component2() {
            return this.applicationCommandIds;
        }

        public final FrecencyRequest copy(Long guildId, List<String> applicationCommandIds) {
            Intrinsics3.checkNotNullParameter(applicationCommandIds, "applicationCommandIds");
            return new FrecencyRequest(guildId, applicationCommandIds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FrecencyRequest)) {
                return false;
            }
            FrecencyRequest frecencyRequest = (FrecencyRequest) other;
            return Intrinsics3.areEqual(this.guildId, frecencyRequest.guildId) && Intrinsics3.areEqual(this.applicationCommandIds, frecencyRequest.applicationCommandIds);
        }

        public final List<String> getApplicationCommandIds() {
            return this.applicationCommandIds;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public int hashCode() {
            Long l = this.guildId;
            int iHashCode = (l != null ? l.hashCode() : 0) * 31;
            List<String> list = this.applicationCommandIds;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("FrecencyRequest(guildId=");
            sbU.append(this.guildId);
            sbU.append(", applicationCommandIds=");
            return outline.L(sbU, this.applicationCommandIds, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$clearAutocompleteResults$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationCommands.this.autocompleteOptionResults.clear();
            StoreApplicationCommands.this.markChanged(StoreApplicationCommands.INSTANCE.getAutocompleteResultsUpdate());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$clearQueryCommands$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationCommands.this.queryCommands.clear();
            StoreApplicationCommands.this.markChanged(StoreApplicationCommands.INSTANCE.getQueryCommandsUpdate());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$getApplicationCommandsViaRest$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends com.discord.api.commands.ApplicationCommand>, Unit> {
        public final /* synthetic */ long $applicationId;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$getApplicationCommandsViaRest$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreApplicationCommands.kt */
        public static final class C00821 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $commands;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00821(List list) {
                super(0);
                this.$commands = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX WARN: Code duplicated, block: B:51:0x0130  */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List listEmptyList;
                Collection collectionEmptyList;
                Object next;
                boolean z2;
                Object next2;
                com.discord.api.commands.ApplicationCommand applicationCommand;
                StoreApplicationCommands.this.discoverApplicationId = null;
                StoreApplicationCommands.this.isLoadingDiscoveryCommands = false;
                Iterator it = StoreApplicationCommands.this.applications.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else if (((Application) it.next()).getId() == AnonymousClass1.this.$applicationId) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    List list = this.$commands;
                    int size = list != null ? list.size() : 0;
                    ArrayList arrayList = new ArrayList(StoreApplicationCommands.this.applications);
                    Application application = (Application) arrayList.remove(i);
                    if (size > 0) {
                        List list2 = this.$commands;
                        if (list2 == null || (applicationCommand = (com.discord.api.commands.ApplicationCommand) list2.get(0)) == null) {
                            return;
                        } else {
                            arrayList.add(i, new Application(applicationCommand.getApplicationId(), application.getName(), application.getIcon(), null, size, application.getBot(), application.getBuiltIn(), 8, null));
                        }
                    }
                    StoreApplicationCommands.this.applications = arrayList;
                    List list3 = this.$commands;
                    if (list3 != null) {
                        listEmptyList = new ArrayList(Iterables2.collectionSizeOrDefault(list3, 10));
                        Iterator it2 = list3.iterator();
                        while (it2.hasNext()) {
                            listEmptyList.add(StoreApplicationCommandsKt.toSlashCommand((com.discord.api.commands.ApplicationCommand) it2.next()));
                        }
                    } else {
                        listEmptyList = Collections2.emptyList();
                    }
                    StoreApplicationCommands storeApplicationCommands = StoreApplicationCommands.this;
                    storeApplicationCommands.handleGuildApplicationsUpdate(_Collections.toList(storeApplicationCommands.applications));
                    List<String> topCommandIds = StoreApplicationCommands.this.storeApplicationCommandFrecency.getTopCommandIds(0L);
                    ArrayList<String> arrayList2 = new ArrayList();
                    for (Object obj : topCommandIds) {
                        String str = (String) obj;
                        Integer intOrNull = StringNumberConversions.toIntOrNull(str);
                        if ((intOrNull != null ? intOrNull.intValue() : 0) >= 0) {
                            Iterator it3 = listEmptyList.iterator();
                            do {
                                if (!it3.hasNext()) {
                                    next2 = null;
                                    break;
                                }
                                next2 = it3.next();
                            } while (!Intrinsics3.areEqual(((ApplicationCommand) next2).getId(), str));
                            if (next2 != null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            arrayList2.add(obj);
                        }
                    }
                    List listPlus = _Collections.plus((Collection) listEmptyList, (Iterable) StoreApplicationCommands.this.builtInCommandsProvider.getBuiltInCommands());
                    Map map = StoreApplicationCommands.this.frecencyCommands;
                    ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList2, 10));
                    for (String str2 : arrayList2) {
                        Iterator it4 = listPlus.iterator();
                        do {
                            if (!it4.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it4.next();
                        } while (!Intrinsics3.areEqual(((ApplicationCommand) next).getId(), str2));
                        arrayList3.add((ApplicationCommand) next);
                    }
                    map.put(0L, _Collections.filterNotNull(arrayList3));
                    StoreApplicationCommands.this.markChanged(StoreApplicationCommands.INSTANCE.getFrecencyCommandsUpdate());
                    StoreApplicationCommands.this.handleDiscoverCommandsUpdate(listEmptyList);
                    List list4 = this.$commands;
                    if (list4 != null) {
                        collectionEmptyList = new ArrayList(Iterables2.collectionSizeOrDefault(list4, 10));
                        Iterator it5 = list4.iterator();
                        while (it5.hasNext()) {
                            collectionEmptyList.add(StoreApplicationCommandsKt.toSlashCommand((com.discord.api.commands.ApplicationCommand) it5.next()));
                        }
                    } else {
                        collectionEmptyList = Collections2.emptyList();
                    }
                    StoreApplicationCommands.this.handleQueryCommandsUpdate(_Collections.plus(collectionEmptyList, (Iterable) StoreApplicationCommands.this.builtInCommandsProvider.getBuiltInCommands()));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$applicationId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.discord.api.commands.ApplicationCommand> list) {
            invoke2((List<com.discord.api.commands.ApplicationCommand>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<com.discord.api.commands.ApplicationCommand> list) {
            StoreApplicationCommands.this.dispatcher.schedule(new C00821(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$getApplicationCommandsViaRest$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$getApplicationCommandsViaRest$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationCommands.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreApplicationCommands.this.isLoadingDiscoveryCommands = false;
            }
        }

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
            StoreApplicationCommands.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$handleDmUserApplication$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ User $botUser;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(User user) {
            super(0);
            this.$botUser = user;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationCommands.this.frecencyCommands.put(0L, Collections2.emptyList());
            StoreApplicationCommands.this.pendingGatewayGuildId = null;
            StoreApplicationCommands.this.applications = Collections2.emptyList();
            StoreApplicationCommands.this.applicationCommandIndexes.clear();
            StoreApplicationCommands storeApplicationCommands = StoreApplicationCommands.this;
            storeApplicationCommands.handleGuildApplicationsUpdate(Collections2.listOf((Object[]) new Application[]{storeApplicationCommands.builtInCommandsProvider.getFrecencyApplication(), new Application(this.$botUser.getId(), this.$botUser.getUsername(), null, null, 0, UserUtils.INSTANCE.synthesizeApiUser(this.$botUser), false, 8, null), StoreApplicationCommands.this.builtInCommandsProvider.getBuiltInApplication()}));
            StoreApplicationCommands.this.markChanged(StoreApplicationCommands.INSTANCE.getFrecencyCommandsUpdate());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$observeAutocompleteResults$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<String, ? extends Map<String, ? extends CommandAutocompleteState>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> invoke() {
            return StoreApplicationCommands.this.getAutocompleteOptionResults();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$observeDiscoverCommands$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<DiscoverCommands> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DiscoverCommands invoke() {
            return StoreApplicationCommands.this.getDiscoverCommandsSnapshot();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$observeFrecencyCommands$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends ApplicationCommand>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends ApplicationCommand> invoke() {
            Experiment userExperiment = StoreApplicationCommands.this.storeExperiments.getUserExperiment("2021-09_android_app_commands_frecency", false);
            return (userExperiment == null || userExperiment.getBucket() != 1) ? Collections2.emptyList() : _Collections.take(StoreApplicationCommands.this.getFrecencyCommands(this.$guildId), 5);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$observeGuildApplications$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends Application>> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Application> invoke() {
            if (StoreApplicationCommands.this.shouldReturnApplicationCommands(StoreApplicationCommands.this.storePermissions.getPermissionsByChannel().get(Long.valueOf(this.$channelId)))) {
                return StoreApplicationCommands.this.getApplications();
            }
            List<Application> applications = StoreApplicationCommands.this.getApplications();
            ArrayList arrayList = new ArrayList();
            for (Object obj : applications) {
                if (((Application) obj).getBuiltIn()) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$observeQueryCommands$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends ApplicationCommand>> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends ApplicationCommand> invoke() {
            if (StoreApplicationCommands.this.shouldReturnApplicationCommands(StoreApplicationCommands.this.storePermissions.getPermissionsByChannel().get(Long.valueOf(this.$channelId)))) {
                return StoreApplicationCommands.this.getQueryCommands();
            }
            List<ApplicationCommand> queryCommands = StoreApplicationCommands.this.getQueryCommands();
            ArrayList arrayList = new ArrayList();
            for (Object obj : queryCommands) {
                if (((ApplicationCommand) obj).getBuiltIn()) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$requestApplicationCommandAutocompleteData$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ ApplicationCommandData $data;
        public final /* synthetic */ Long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreApplicationCommands.kt */
        public static final class C00831 extends Lambda implements Function1<Error, Unit> {
            public final /* synthetic */ ApplicationCommandValue $option;

            /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreApplicationCommands.kt */
            public static final class C00841 extends Lambda implements Function0<Unit> {
                public C00841() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C00831 c00831 = C00831.this;
                    StoreApplicationCommands.this.setAutocompleteFailed(c00831.$option.getName(), String.valueOf(C00831.this.$option.getValue()));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00831(ApplicationCommandValue applicationCommandValue) {
                super(1);
                this.$option = applicationCommandValue;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreApplicationCommands.this.dispatcher.schedule(new C00841());
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationCommands.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            public AnonymousClass2() {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ApplicationCommandData applicationCommandData, long j, Long l) {
            super(0);
            this.$data = applicationCommandData;
            this.$channelId = j;
            this.$guildId = l;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Object next;
            String strGenerateNonce = StoreApplicationCommands.this.generateNonce();
            String version = this.$data.getApplicationCommand().getVersion();
            Long guildId = this.$data.getApplicationCommand().getGuildId();
            com.discord.api.commands.ApplicationCommandData applicationCommandData = new com.discord.api.commands.ApplicationCommandData(version, guildId != null ? String.valueOf(guildId.longValue()) : null, this.$data.getApplicationCommand().getId(), this.$data.getApplicationCommand().getName(), ApplicationCommandLocalSendData3.toRestParams(this.$data.getValues(), StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$apiCommandData$1.INSTANCE), null);
            String strValueOf = String.valueOf(this.$channelId);
            String strValueOf2 = String.valueOf(this.$data.getApplication().getId());
            Long l = this.$guildId;
            RestAPIParams.ApplicationCommand applicationCommand = new RestAPIParams.ApplicationCommand(4L, strValueOf, strValueOf2, l != null ? String.valueOf(l.longValue()) : null, applicationCommandData, StoreApplicationCommands.this.sessionId, strGenerateNonce);
            Iterator<T> it = StoreApplicationCommandsKt.flatten(this.$data.getValues()).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics3.areEqual(((ApplicationCommandValue) next).getFocused(), Boolean.TRUE));
            ApplicationCommandValue applicationCommandValue = (ApplicationCommandValue) next;
            if (applicationCommandValue != null) {
                StoreApplicationCommands.this.autocompleteNonceData.put(strGenerateNonce, new CommandOptionAutocompleteQuery(String.valueOf(applicationCommandValue.getValue()), applicationCommandValue.getName()));
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(StoreApplicationCommands.this.restApi.sendApplicationCommand(applicationCommand), false, 1, null), (Class<?>) StoreApplicationCommands.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C00831(applicationCommandValue)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass2.INSTANCE);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$requestApplicationCommands$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $applicationId;
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ int $limit;
        public final /* synthetic */ int $offset;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l, int i, int i2, Long l2) {
            super(0);
            this.$guildId = l;
            this.$offset = i;
            this.$limit = i2;
            this.$applicationId = l2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreApplicationCommands.this.isLoadingDiscoveryCommands) {
                return;
            }
            String strGenerateNonce = StoreApplicationCommands.this.generateNonce();
            StoreApplicationCommands.this.discoverCommandsNonce = strGenerateNonce;
            LoadState loadState = (StoreApplicationCommands.this.loadDirectionDown || StoreApplicationCommands.this.loadDirectionUp) ? StoreApplicationCommands.this.discoverCommands.getLoadState() : LoadState.Loading.INSTANCE;
            if (!Intrinsics3.areEqual(StoreApplicationCommands.this.discoverGuildId, this.$guildId)) {
                StoreApplicationCommands storeApplicationCommands = StoreApplicationCommands.this;
                DiscoverCommands discoverCommands = storeApplicationCommands.discoverCommands;
                storeApplicationCommands.discoverCommands = discoverCommands.copy((126 & 1) != 0 ? discoverCommands.commands : Collections2.emptyList(), (126 & 2) != 0 ? discoverCommands.currentStartOffset : 0, (126 & 4) != 0 ? discoverCommands.currentEndOffset : 0, (126 & 8) != 0 ? discoverCommands.hasMoreBefore : false, (126 & 16) != 0 ? discoverCommands.hasMoreAfter : false, (126 & 32) != 0 ? discoverCommands.jumpedSequenceId : 0, (126 & 64) != 0 ? discoverCommands.jumpedApplicationId : null, (126 & 128) != 0 ? discoverCommands.loadState : loadState);
                StoreApplicationCommands.this.markChanged(StoreApplicationCommands.INSTANCE.getDiscoverCommandsUpdate());
            } else {
                StoreApplicationCommands storeApplicationCommands2 = StoreApplicationCommands.this;
                DiscoverCommands discoverCommands2 = storeApplicationCommands2.discoverCommands;
                storeApplicationCommands2.discoverCommands = discoverCommands2.copy((126 & 1) != 0 ? discoverCommands2.commands : null, (126 & 2) != 0 ? discoverCommands2.currentStartOffset : 0, (126 & 4) != 0 ? discoverCommands2.currentEndOffset : 0, (126 & 8) != 0 ? discoverCommands2.hasMoreBefore : false, (126 & 16) != 0 ? discoverCommands2.hasMoreAfter : false, (126 & 32) != 0 ? discoverCommands2.jumpedSequenceId : 0, (126 & 64) != 0 ? discoverCommands2.jumpedApplicationId : null, (126 & 128) != 0 ? discoverCommands2.loadState : loadState);
                StoreApplicationCommands.this.markChanged(StoreApplicationCommands.INSTANCE.getDiscoverCommandsUpdate());
            }
            StoreApplicationCommands.this.discoverGuildId = this.$guildId;
            Long l = this.$guildId;
            if (l == null || l.longValue() <= 0) {
                Long l2 = this.$applicationId;
                if (l2 == null) {
                    StoreApplicationCommands storeApplicationCommands3 = StoreApplicationCommands.this;
                    storeApplicationCommands3.handleDiscoverCommandsUpdate(storeApplicationCommands3.builtInCommandsProvider.getBuiltInCommands());
                } else if (!Intrinsics3.areEqual(l2, StoreApplicationCommands.this.discoverApplicationId)) {
                    StoreApplicationCommands.this.isLoadingDiscoveryCommands = true;
                    StoreApplicationCommands.this.getApplicationCommandsViaRest(this.$applicationId.longValue());
                }
            } else {
                boolean zRequestApplicationCommands = StoreApplicationCommands.this.storeGatewayConnection.requestApplicationCommands(this.$guildId.longValue(), strGenerateNonce, false, (72 & 8) != 0 ? null : null, (72 & 16) != 0 ? null : Integer.valueOf(this.$offset), this.$limit, (72 & 64) != 0 ? null : null);
                StoreApplicationCommands.this.isLoadingDiscoveryCommands = zRequestApplicationCommands;
                if (!zRequestApplicationCommands) {
                    StoreApplicationCommands storeApplicationCommands4 = StoreApplicationCommands.this;
                    storeApplicationCommands4.handleDiscoverCommandsUpdate(storeApplicationCommands4.builtInCommandsProvider.getBuiltInCommands());
                }
            }
            StoreApplicationCommands.this.discoverApplicationId = this.$applicationId;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$requestApplicationCommandsQuery$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ String $query;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l, String str) {
            super(0);
            this.$guildId = l;
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String strGenerateNonce = StoreApplicationCommands.this.generateNonce();
            StoreApplicationCommands.this.queryNonce = strGenerateNonce;
            if (!Intrinsics3.areEqual(StoreApplicationCommands.this.queryGuildId, this.$guildId)) {
                StoreApplicationCommands.this.queryCommands.clear();
                StoreApplicationCommands.this.markChanged(StoreApplicationCommands.INSTANCE.getQueryCommandsUpdate());
            }
            StoreApplicationCommands.this.queryGuildId = this.$guildId;
            StoreApplicationCommands.this.query = this.$query;
            Long l = this.$guildId;
            if (l == null || l.longValue() <= 0) {
                StoreApplicationCommands.this.handleQueryCommandsUpdate(Collections2.emptyList());
            } else {
                StoreApplicationCommands.this.storeGatewayConnection.requestApplicationCommands(this.$guildId.longValue(), strGenerateNonce, false, (72 & 8) != 0 ? null : this.$query, (72 & 16) != 0 ? null : null, 20, (72 & 64) != 0 ? null : null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$requestApplications$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l) {
            super(0);
            this.$guildId = l;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String strGenerateNonce = StoreApplicationCommands.this.generateNonce();
            StoreApplicationCommands.this.applicationNonce = strGenerateNonce;
            StoreApplicationCommands.this.applications = Collections2.emptyList();
            StoreApplicationCommands.this.applicationCommandIndexes.clear();
            StoreApplicationCommands.this.markChanged(StoreApplicationCommands.INSTANCE.getGuildApplicationsUpdate());
            Long l = this.$guildId;
            if (l != null && l.longValue() > 0) {
                StoreApplicationCommands.this.storeGatewayConnection.requestApplicationCommands(this.$guildId.longValue(), strGenerateNonce, true, (72 & 8) != 0 ? null : null, (72 & 16) != 0 ? null : null, 0, (72 & 64) != 0 ? null : null);
            } else {
                StoreApplicationCommands storeApplicationCommands = StoreApplicationCommands.this;
                storeApplicationCommands.handleGuildApplicationsUpdate(Collections2.listOf((Object[]) new Application[]{storeApplicationCommands.builtInCommandsProvider.getFrecencyApplication(), StoreApplicationCommands.this.builtInCommandsProvider.getBuiltInApplication()}));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$requestFrecencyCommands$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $nonce;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$nonce = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationCommands.this.handleFrecencyCommandsUpdate(this.$nonce, Collections2.emptyList());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$requestFrecencyCommands$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $nonce;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(0);
            this.$nonce = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationCommands.this.handleFrecencyCommandsUpdate(this.$nonce, Collections2.emptyList());
        }
    }

    public /* synthetic */ StoreApplicationCommands(StoreGatewayConnection storeGatewayConnection, StorePermissions storePermissions, StoreApplicationCommandFrecency storeApplicationCommandFrecency, StoreGuilds storeGuilds, StoreUser storeUser, StoreExperiments storeExperiments, Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, BuiltInCommandsProvider builtInCommandsProvider, NonceGenerator nonceGenerator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeGatewayConnection, storePermissions, storeApplicationCommandFrecency, storeGuilds, storeUser, storeExperiments, dispatcher, (i & 128) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 256) != 0 ? ObservationDeck4.get() : observationDeck, (i & 512) != 0 ? new BuiltInCommands() : builtInCommandsProvider, (i & 1024) != 0 ? new NonceGenerator() : nonceGenerator);
    }

    @Store3
    private final String generateNonce() {
        return String.valueOf(this.nonceGenerator.nonce());
    }

    private final void getApplicationCommandsViaRest(long applicationId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.getApplicationCommands(applicationId), false, 1, null), (Class<?>) StoreApplicationCommands.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(applicationId));
    }

    @Store3
    private final void handleDiscoverCommandsUpdate(List<? extends ApplicationCommand> commands) {
        this.isLoadingDiscoveryCommands = false;
        List mutableList = _Collections.toMutableList((Collection) this.discoverCommands.getCommands());
        int size = mutableList.size();
        Long l = this.jumpedApplicationId;
        if (l != null) {
            mutableList = _Collections.toMutableList((Collection) commands);
            Integer num = this.applicationCommandIndexes.get(l);
            this.currentStartOffset = num != null ? num.intValue() : 0;
        } else if (this.loadDirectionUp) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : commands) {
                ApplicationCommand applicationCommand = (ApplicationCommand) obj;
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(mutableList, 10));
                Iterator it = mutableList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((ApplicationCommand) it.next()).getId());
                }
                if (!arrayList2.contains(applicationCommand.getId())) {
                    arrayList.add(obj);
                }
            }
            Iterator it2 = ReversedViews3.asReversed(arrayList).iterator();
            while (it2.hasNext()) {
                mutableList.add(0, (ApplicationCommand) it2.next());
            }
            this.currentStartOffset -= mutableList.size() - size;
        } else if (this.loadDirectionDown) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : commands) {
                ApplicationCommand applicationCommand2 = (ApplicationCommand) obj2;
                ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(mutableList, 10));
                Iterator it3 = mutableList.iterator();
                while (it3.hasNext()) {
                    arrayList4.add(((ApplicationCommand) it3.next()).getId());
                }
                if (!arrayList4.contains(applicationCommand2.getId())) {
                    arrayList3.add(obj2);
                }
            }
            mutableList = _Collections.toMutableList((Collection) _Collections.plus((Collection) mutableList, (Iterable) arrayList3));
        } else {
            mutableList = _Collections.toMutableList((Collection) commands);
            this.currentStartOffset = 0;
        }
        List list = mutableList;
        if ((list.size() + this.currentStartOffset) - 1 == this.numRemoteCommands - 1) {
            list.addAll(this.builtInCommandsProvider.getBuiltInCommands());
        }
        this.currentEndOffset = (list.size() + this.currentStartOffset) - 1;
        this.discoverCommands = new DiscoverCommands(list, this.currentStartOffset, this.currentEndOffset, this.currentStartOffset > 0 && (list.isEmpty() ^ true), this.currentEndOffset < this.numRemoteCommands - 1, this.jumpedSequenceId, this.jumpedApplicationId, this.loadDirectionUp ? LoadState.JustLoadedUp.INSTANCE : this.loadDirectionDown ? LoadState.JustLoadedDown.INSTANCE : LoadState.JustLoadedAll.INSTANCE);
        markChanged(DiscoverCommandsUpdate);
    }

    @Store3
    private final void handleFrecencyCommandsUpdate(String nonce, List<? extends ApplicationCommand> commands) {
        int iIntValue;
        FrecencyRequest frecencyRequest = this.frecencyRequests.get(nonce);
        if (frecencyRequest != null) {
            this.frecencyRequests.remove(nonce);
            List<ApplicationCommand> listFlattenSubCommands = StoreApplicationCommandsKt.flattenSubCommands(commands);
            Map<Long, List<ApplicationCommand>> map = this.frecencyCommands;
            Long guildId = frecencyRequest.getGuildId();
            Long lValueOf = Long.valueOf(guildId != null ? guildId.longValue() : 0L);
            List<String> applicationCommandIds = frecencyRequest.getApplicationCommandIds();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(applicationCommandIds, 10));
            for (String str : applicationCommandIds) {
                Integer intOrNull = StringNumberConversions.toIntOrNull(str);
                Object obj = null;
                if (intOrNull != null && (iIntValue = intOrNull.intValue()) < 0) {
                    for (Object obj2 : this.builtInCommandsProvider.getBuiltInCommands()) {
                        Integer intOrNull2 = StringNumberConversions.toIntOrNull(((ApplicationCommand) obj2).getId());
                        if (intOrNull2 != null && intOrNull2.intValue() == iIntValue) {
                            obj = obj2;
                            break;
                        }
                    }
                } else {
                    for (Object obj3 : listFlattenSubCommands) {
                        if (Intrinsics3.areEqual(((ApplicationCommand) obj3).getId(), str)) {
                            obj = obj3;
                            break;
                        }
                    }
                }
                arrayList.add((ApplicationCommand) obj);
            }
            map.put(lValueOf, _Collections.filterNotNull(arrayList));
            markChanged(FrecencyCommandsUpdate);
        }
    }

    @Store3
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

    @Store3
    private final void handleQueryCommandsUpdate(List<? extends ApplicationCommand> commands) {
        this.queryCommands.clear();
        this.queryCommands.addAll(commands);
        String str = this.query;
        if (str != null) {
            List<ApplicationCommand> list = this.queryCommands;
            List<ApplicationCommand> builtInCommands = this.builtInCommandsProvider.getBuiltInCommands();
            ArrayList arrayList = new ArrayList();
            for (Object obj : builtInCommands) {
                if (StringsJVM.startsWith(((ApplicationCommand) obj).getName(), str, true)) {
                    arrayList.add(obj);
                }
            }
            list.addAll(arrayList);
        }
        markChanged(QueryCommandsUpdate);
    }

    private final void requestApplicationCommands(Long guildId, int offset, Long applicationId, int limit) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, offset, limit, applicationId));
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

    @Store3
    private final void setAutocompleteState(String commandOptionName, String queryString, CommandAutocompleteState state) {
        Map<String, CommandAutocompleteState> mapEmptyMap = this.autocompleteOptionResults.get(commandOptionName);
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        if (mapEmptyMap.get(queryString) instanceof CommandAutocompleteState.Choices) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, CommandAutocompleteState> mapEmptyMap2 = this.autocompleteOptionResults.get(commandOptionName);
        if (mapEmptyMap2 == null) {
            mapEmptyMap2 = Maps6.emptyMap();
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
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void clearQueryCommands() {
        this.dispatcher.schedule(new AnonymousClass1());
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
        return list != null ? list : Collections2.emptyList();
    }

    public final List<ApplicationCommand> getQueryCommands() {
        return this.queryCommandsSnapshot;
    }

    @Store3
    public final void handleApplicationCommandAutocompleteResult(ApplicationCommandAutocompleteResult autocompleteResult) {
        Intrinsics3.checkNotNullParameter(autocompleteResult, "autocompleteResult");
        CommandOptionAutocompleteQuery commandOptionAutocompleteQuery = this.autocompleteNonceData.get(autocompleteResult.getNonce());
        if (commandOptionAutocompleteQuery != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Map<String, CommandAutocompleteState> mapEmptyMap = this.autocompleteOptionResults.get(commandOptionAutocompleteQuery.getCommandOptionName());
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            linkedHashMap.putAll(mapEmptyMap);
            linkedHashMap.put(commandOptionAutocompleteQuery.getQueryString(), new CommandAutocompleteState.Choices(autocompleteResult.a()));
            this.autocompleteOptionResults.put(commandOptionAutocompleteQuery.getCommandOptionName(), linkedHashMap);
            markChanged(AutocompleteResultsUpdate);
        }
    }

    @Store3
    public final void handleApplicationCommandsUpdate(GuildApplicationCommands commandsGateway) {
        Intrinsics3.checkNotNullParameter(commandsGateway, "commandsGateway");
        if (this.frecencyRequests.containsKey(commandsGateway.getNonce())) {
            String nonce = commandsGateway.getNonce();
            List<com.discord.api.commands.ApplicationCommand> listA = commandsGateway.a();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listA, 10));
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(StoreApplicationCommandsKt.toSlashCommand((com.discord.api.commands.ApplicationCommand) it.next()));
            }
            handleFrecencyCommandsUpdate(nonce, arrayList);
            return;
        }
        String nonce2 = commandsGateway.getNonce();
        if (Intrinsics3.areEqual(nonce2, this.applicationNonce)) {
            List listListOf = CollectionsJVM.listOf(this.builtInCommandsProvider.getFrecencyApplication());
            List<com.discord.api.commands.Application> listB = commandsGateway.b();
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listB, 10));
            Iterator<T> it2 = listB.iterator();
            while (it2.hasNext()) {
                arrayList2.add(StoreApplicationCommandsKt.toDomainApplication((com.discord.api.commands.Application) it2.next()));
            }
            handleGuildApplicationsUpdate(_Collections.plus((Collection<? extends Application>) _Collections.plus((Collection) listListOf, (Iterable) _Collections.sortedWith(arrayList2, new Comparator() { // from class: com.discord.stores.StoreApplicationCommands$handleApplicationCommandsUpdate$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return a.compareValues(((Application) t).getName(), ((Application) t2).getName());
                }
            })), this.builtInCommandsProvider.getBuiltInApplication()));
            return;
        }
        if (Intrinsics3.areEqual(nonce2, this.queryNonce)) {
            List<com.discord.api.commands.ApplicationCommand> listA2 = commandsGateway.a();
            ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(listA2, 10));
            Iterator<T> it3 = listA2.iterator();
            while (it3.hasNext()) {
                arrayList3.add(StoreApplicationCommandsKt.toSlashCommand((com.discord.api.commands.ApplicationCommand) it3.next()));
            }
            handleQueryCommandsUpdate(arrayList3);
            return;
        }
        if (Intrinsics3.areEqual(nonce2, this.discoverCommandsNonce)) {
            List<com.discord.api.commands.ApplicationCommand> listA3 = commandsGateway.a();
            ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(listA3, 10));
            Iterator<T> it4 = listA3.iterator();
            while (it4.hasNext()) {
                arrayList4.add(StoreApplicationCommandsKt.toSlashCommand((com.discord.api.commands.ApplicationCommand) it4.next()));
            }
            handleDiscoverCommandsUpdate(arrayList4);
        }
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
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
        Intrinsics3.checkNotNullParameter(botUser, "botUser");
        if (botUser.getIsBot()) {
            if (this.connectionReady) {
                this.dispatcher.schedule(new AnonymousClass1(botUser));
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
        Observable<Map<String, Map<String, CommandAutocompleteState>>> observableT = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{AutocompleteResultsUpdate}, false, null, null, new AnonymousClass1(), 14, null).T(Maps6.emptyMap());
        Intrinsics3.checkNotNullExpressionValue(observableT, "observationDeck.connectR…  }.startWith(emptyMap())");
        return observableT;
    }

    public final Observable<DiscoverCommands> observeDiscoverCommands(long channelId) {
        Observable<DiscoverCommands> observableJ = Observable.j(ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{DiscoverCommandsUpdate}, false, null, null, new AnonymousClass1(), 14, null).r(), this.storePermissions.observePermissionsForChannel(channelId), new Func2<DiscoverCommands, Long, DiscoverCommands>() { // from class: com.discord.stores.StoreApplicationCommands.observeDiscoverCommands.2
            @Override // rx.functions.Func2
            public final DiscoverCommands call(DiscoverCommands discoverCommands, Long l) {
                if (StoreApplicationCommands.this.shouldReturnApplicationCommands(l)) {
                    return discoverCommands;
                }
                List<ApplicationCommand> builtInCommands = StoreApplicationCommands.this.builtInCommandsProvider.getBuiltInCommands();
                return new DiscoverCommands(builtInCommands, 0, builtInCommands.size(), false, false, 0, null, null, 128, null);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…  )\n          }\n        }");
        return observableJ;
    }

    public final Observable<List<ApplicationCommand>> observeFrecencyCommands(long guildId) {
        Observable<List<ApplicationCommand>> observableT = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{FrecencyCommandsUpdate, this.storeExperiments}, false, null, null, new AnonymousClass1(guildId), 14, null).T(Collections2.emptyList());
        Intrinsics3.checkNotNullExpressionValue(observableT, "observationDeck.connectR…st<ApplicationCommand>())");
        return observableT;
    }

    public final Observable<List<Application>> observeGuildApplications(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildApplicationsUpdate, this.storePermissions}, false, null, null, new AnonymousClass1(channelId), 14, null);
    }

    public final Observable<List<ApplicationCommand>> observeQueryCommands(long channelId) {
        Observable<List<ApplicationCommand>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{QueryCommandsUpdate, this.storePermissions}, false, null, null, new AnonymousClass1(channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void requestApplicationCommandAutocompleteData(Long guildId, long channelId, ApplicationCommandData data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.dispatcher.schedule(new AnonymousClass1(data, channelId, guildId));
    }

    public final void requestApplicationCommandsQuery(Long guildId, String query) {
        Intrinsics3.checkNotNullParameter(query, "query");
        this.dispatcher.schedule(new AnonymousClass1(guildId, query));
    }

    public final void requestApplications(Long guildId) {
        if (this.connectionReady) {
            this.dispatcher.schedule(new AnonymousClass1(guildId));
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
        FrecencyRequest frecencyRequest = new FrecencyRequest(Long.valueOf(guildId), topCommandIds);
        if (this.frecencyRequests.containsValue(frecencyRequest)) {
            return;
        }
        this.frecencyRequests.put(strGenerateNonce, frecencyRequest);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(topCommandIds, 10));
        for (String str : topCommandIds) {
            if (Strings4.contains$default((CharSequence) str, (CharSequence) " ", false, 2, (Object) null)) {
                str = (String) Strings4.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null).get(0);
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
            Long longOrNull = StringNumberConversions.toLongOrNull((String) next);
            if ((longOrNull != null ? longOrNull.longValue() : 0L) > 0) {
                arrayList2.add(next);
            }
        }
        if (!(!arrayList2.isEmpty())) {
            this.dispatcher.schedule(new AnonymousClass2(strGenerateNonce));
        } else {
            if (this.storeGatewayConnection.requestApplicationCommands(guildId, strGenerateNonce, false, (72 & 8) != 0 ? null : null, (72 & 16) != 0 ? null : null, 20, (72 & 64) != 0 ? null : _Collections.distinct(arrayList2))) {
                return;
            }
            this.dispatcher.schedule(new AnonymousClass1(strGenerateNonce));
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
            DiscoverCommands discoverCommands = this.discoverCommands;
            this.discoverCommands = discoverCommands.copy((126 & 1) != 0 ? discoverCommands.commands : Collections2.emptyList(), (126 & 2) != 0 ? discoverCommands.currentStartOffset : 0, (126 & 4) != 0 ? discoverCommands.currentEndOffset : 0, (126 & 8) != 0 ? discoverCommands.hasMoreBefore : false, (126 & 16) != 0 ? discoverCommands.hasMoreAfter : false, (126 & 32) != 0 ? discoverCommands.jumpedSequenceId : 0, (126 & 64) != 0 ? discoverCommands.jumpedApplicationId : null, (126 & 128) != 0 ? discoverCommands.loadState : null);
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
            DiscoverCommands discoverCommands = this.discoverCommands;
            this.discoverCommands = discoverCommands.copy((126 & 1) != 0 ? discoverCommands.commands : null, (126 & 2) != 0 ? discoverCommands.currentStartOffset : 0, (126 & 4) != 0 ? discoverCommands.currentEndOffset : 0, (126 & 8) != 0 ? discoverCommands.hasMoreBefore : false, (126 & 16) != 0 ? discoverCommands.hasMoreAfter : false, (126 & 32) != 0 ? discoverCommands.jumpedSequenceId : 0, (126 & 64) != 0 ? discoverCommands.jumpedApplicationId : null, (126 & 128) != 0 ? discoverCommands.loadState : LoadState.LoadingDown.INSTANCE);
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
            DiscoverCommands discoverCommands = this.discoverCommands;
            this.discoverCommands = discoverCommands.copy((126 & 1) != 0 ? discoverCommands.commands : null, (126 & 2) != 0 ? discoverCommands.currentStartOffset : 0, (126 & 4) != 0 ? discoverCommands.currentEndOffset : 0, (126 & 8) != 0 ? discoverCommands.hasMoreBefore : false, (126 & 16) != 0 ? discoverCommands.hasMoreAfter : false, (126 & 32) != 0 ? discoverCommands.jumpedSequenceId : 0, (126 & 64) != 0 ? discoverCommands.jumpedApplicationId : null, (126 & 128) != 0 ? discoverCommands.loadState : LoadState.LoadingUp.INSTANCE);
        }
    }

    @Store3
    public final void setAutocompleteFailed(String commandOptionName, String queryString) {
        Intrinsics3.checkNotNullParameter(commandOptionName, "commandOptionName");
        Intrinsics3.checkNotNullParameter(queryString, "queryString");
        setAutocompleteState(commandOptionName, queryString, CommandAutocompleteState.Failed.INSTANCE);
    }

    @Store3
    public final void setAutocompleteLoading(String commandOptionName, String queryString) {
        Intrinsics3.checkNotNullParameter(commandOptionName, "commandOptionName");
        Intrinsics3.checkNotNullParameter(queryString, "queryString");
        setAutocompleteState(commandOptionName, queryString, CommandAutocompleteState.Loading.INSTANCE);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        if (getUpdateSources().contains(DiscoverCommandsUpdate)) {
            DiscoverCommands discoverCommands = this.discoverCommands;
            this.discoverCommandsSnapshot = discoverCommands.copy((126 & 1) != 0 ? discoverCommands.commands : StoreApplicationCommandsKt.flattenSubCommands(discoverCommands.getCommands()), (126 & 2) != 0 ? discoverCommands.currentStartOffset : 0, (126 & 4) != 0 ? discoverCommands.currentEndOffset : 0, (126 & 8) != 0 ? discoverCommands.hasMoreBefore : false, (126 & 16) != 0 ? discoverCommands.hasMoreAfter : false, (126 & 32) != 0 ? discoverCommands.jumpedSequenceId : 0, (126 & 64) != 0 ? discoverCommands.jumpedApplicationId : null, (126 & 128) != 0 ? discoverCommands.loadState : null);
        }
        if (getUpdateSources().contains(QueryCommandsUpdate)) {
            this.queryCommandsSnapshot = new ArrayList(StoreApplicationCommandsKt.flattenSubCommands(this.queryCommands));
        }
        if (getUpdateSources().contains(GuildApplicationsUpdate)) {
            ArrayList arrayList = new ArrayList(this.applications);
            this.applicationsSnapshot = arrayList;
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList, 10)), 16));
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
        Intrinsics3.checkNotNullParameter(storeGatewayConnection, "storeGatewayConnection");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(storeApplicationCommandFrecency, "storeApplicationCommandFrecency");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUsers");
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(builtInCommandsProvider, "builtInCommandsProvider");
        Intrinsics3.checkNotNullParameter(nonceGenerator, "nonceGenerator");
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
        DiscoverCommands.Companion companion = DiscoverCommands.INSTANCE;
        this.discoverCommands = companion.getDefaultModelDiscoveryCommands();
        this.discoverCommandsSnapshot = companion.getDefaultModelDiscoveryCommands();
        this.applicationCommandIndexes = new LinkedHashMap();
        this.applications = Collections2.emptyList();
        this.applicationsSnapshot = Collections2.emptyList();
        this.applicationsMapSnapshot = Maps6.emptyMap();
        this.queryCommands = new ArrayList();
        this.queryCommandsSnapshot = Collections2.emptyList();
        this.autocompleteNonceData = new LinkedHashMap();
        this.autocompleteOptionResults = new LinkedHashMap();
        this.autocompleteOptionResultsSnapshot = Maps6.emptyMap();
        this.frecencyRequests = new LinkedHashMap();
        this.frecencyCommands = new LinkedHashMap();
        this.frecencyCommandsSnapshot = Maps6.emptyMap();
    }
}
