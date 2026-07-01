package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelAuditLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelAuditLogEntry$ActionType;
import com.discord.models.domain.ModelAuditLogEntry$Change;
import com.discord.models.domain.ModelAuditLogEntry$Options;
import com.discord.models.domain.ModelAuditLogEntry$TargetType;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.auditlogs.AuditLogChangeUtils;
import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
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
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuditLog extends StoreV2 {
    public static final StoreAuditLog$Companion Companion = new StoreAuditLog$Companion(null);
    private static final long NO_GUILD = -1;
    private Long cutoffTimestamp;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private StoreAuditLog$AuditLogState state;
    private StoreAuditLog$AuditLogState stateSnapshot;

    public StoreAuditLog(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        StoreAuditLog$AuditLogState storeAuditLog$AuditLogState = new StoreAuditLog$AuditLogState(0L, null, null, null, null, null, null, null, null, null, false, 2047, null);
        this.state = storeAuditLog$AuditLogState;
        this.stateSnapshot = storeAuditLog$AuditLogState;
    }

    public static final /* synthetic */ void access$clearStateInternal(StoreAuditLog storeAuditLog) {
        storeAuditLog.clearStateInternal();
    }

    public static final /* synthetic */ void access$fetchAuditLogs(StoreAuditLog storeAuditLog, long j, StoreAuditLog$AuditLogFilter storeAuditLog$AuditLogFilter) {
        storeAuditLog.fetchAuditLogs(j, storeAuditLog$AuditLogFilter);
    }

    public static final /* synthetic */ StoreAuditLog$AuditLogState access$getState$p(StoreAuditLog storeAuditLog) {
        return storeAuditLog.state;
    }

    public static final /* synthetic */ void access$handleFetchFailure(StoreAuditLog storeAuditLog) {
        storeAuditLog.handleFetchFailure();
    }

    public static final /* synthetic */ void access$handleFetchSuccess(StoreAuditLog storeAuditLog, long j, ModelAuditLog modelAuditLog) {
        storeAuditLog.handleFetchSuccess(j, modelAuditLog);
    }

    public static final /* synthetic */ void access$setState$p(StoreAuditLog storeAuditLog, StoreAuditLog$AuditLogState storeAuditLog$AuditLogState) {
        storeAuditLog.state = storeAuditLog$AuditLogState;
    }

    public static final /* synthetic */ List access$transformEntries(StoreAuditLog storeAuditLog, long j, List list) {
        return storeAuditLog.transformEntries(j, list);
    }

    @StoreThread
    private final void clearStateInternal() {
        this.cutoffTimestamp = null;
        this.state = new StoreAuditLog$AuditLogState(0L, null, null, null, null, null, null, null, null, null, false, 2047, null);
        markChanged();
    }

    @StoreThread
    private final void fetchAuditLogs(long guildId, StoreAuditLog$AuditLogFilter filter) {
        ModelAuditLogEntry modelAuditLogEntry;
        List<ModelAuditLogEntry> entries = this.state.getEntries();
        Long lValueOf = (entries == null || (modelAuditLogEntry = (ModelAuditLogEntry) u.lastOrNull((List) entries)) == null) ? null : Long.valueOf(modelAuditLogEntry.getId());
        if (this.cutoffTimestamp == null) {
            this.cutoffTimestamp = 0L;
        }
        if (m.areEqual(lValueOf, this.cutoffTimestamp)) {
            return;
        }
        this.cutoffTimestamp = lValueOf;
        this.state = StoreAuditLog$AuditLogState.copy$default(this.state, guildId, null, null, null, null, null, null, null, null, null, true, 1022, null);
        markChanged();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getAuditLogs(guildId, lValueOf, Long.valueOf(filter.getUserFilter()), Integer.valueOf(filter.getActionFilter())), false, 1, null), StoreAuditLog.class, (Context) null, (Function1) null, new StoreAuditLog$fetchAuditLogs$1(this), (Function0) null, (Function0) null, new StoreAuditLog$fetchAuditLogs$2(this, guildId), 54, (Object) null);
    }

    private final void handleFetchFailure() {
        this.dispatcher.schedule(new StoreAuditLog$handleFetchFailure$1(this));
    }

    private final void handleFetchSuccess(long guildId, ModelAuditLog newAuditLog) {
        this.dispatcher.schedule(new StoreAuditLog$handleFetchSuccess$1(this, newAuditLog, guildId));
    }

    private final boolean shouldMergeEntries(ModelAuditLogEntry prevEntry, ModelAuditLogEntry entry, int numMerges, int timeWindowMins, int maxMerges) {
        if (prevEntry != null && prevEntry.getActionTypeId() == entry.getActionTypeId() && prevEntry.getTargetId() == entry.getTargetId() && prevEntry.getUserId() == entry.getUserId() && m.areEqual(prevEntry.getOptions(), entry.getOptions()) && numMerges < maxMerges && entry.getTargetType() != ModelAuditLogEntry$TargetType.INVITE && entry.getActionTypeId() != 72 && entry.getActionTypeId() != 73 && entry.getActionTypeId() != 26 && entry.getActionTypeId() != 27) {
            AuditLogUtils auditLogUtils = AuditLogUtils.INSTANCE;
            if (Math.abs(auditLogUtils.getTimestampStart(entry) - auditLogUtils.getTimestampStart(prevEntry)) < ((long) timeWindowMins) * 60000) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean shouldMergeEntries$default(StoreAuditLog storeAuditLog, ModelAuditLogEntry modelAuditLogEntry, ModelAuditLogEntry modelAuditLogEntry2, int i, int i2, int i3, int i4, Object obj) {
        return storeAuditLog.shouldMergeEntries(modelAuditLogEntry, modelAuditLogEntry2, i, (i4 & 8) != 0 ? 30 : i2, (i4 & 16) != 0 ? 50 : i3);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final List<ModelAuditLogEntry> transformEntries(long guildId, List<? extends ModelAuditLogEntry> rawEntries) {
        ModelAuditLogEntry$Change modelAuditLogEntry$Change;
        ModelAuditLogEntry$Change modelAuditLogEntry$Change2;
        ModelAuditLogEntry$Options options;
        List<ModelAuditLogEntry$Change> changes;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i = 0;
            for (ModelAuditLogEntry modelAuditLogEntry : s.asReversed(rawEntries)) {
                ArrayList arrayList2 = new ArrayList();
                if (modelAuditLogEntry.getReason() != null) {
                    arrayList2.add(new ModelAuditLogEntry$Change(ModelAuditLogEntry.CHANGE_KEY_REASON, null, modelAuditLogEntry.getReason()));
                }
                List<ModelAuditLogEntry$Change> changes2 = modelAuditLogEntry.getChanges();
                if (changes2 != null) {
                    ModelAuditLogEntry$Change modelAuditLogEntry$Change3 = null;
                    ModelAuditLogEntry$Change modelAuditLogEntry$Change4 = null;
                    for (ModelAuditLogEntry$Change modelAuditLogEntry$Change5 : changes2) {
                        m.checkNotNullExpressionValue(modelAuditLogEntry$Change5, "change");
                        String key = modelAuditLogEntry$Change5.getKey();
                        if (key != null) {
                            switch (key.hashCode()) {
                                case 3079692:
                                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_DENIED)) {
                                        arrayList2.addAll(AuditLogChangeUtils.INSTANCE.transformPermissionOverride(modelAuditLogEntry$Change5));
                                    }
                                    break;
                                case 92906313:
                                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED)) {
                                        arrayList2.addAll(AuditLogChangeUtils.INSTANCE.transformPermissionOverride(modelAuditLogEntry$Change5));
                                    }
                                    break;
                                case 108404047:
                                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET)) {
                                        arrayList2.addAll(AuditLogChangeUtils.INSTANCE.transformPermissionOverride(modelAuditLogEntry$Change5));
                                    }
                                    break;
                                case 1133704324:
                                    if (key.equals(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS)) {
                                        arrayList2.addAll(AuditLogChangeUtils.INSTANCE.transformPermissionChange(modelAuditLogEntry$Change5));
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                        arrayList2.add(modelAuditLogEntry$Change5);
                        String key2 = modelAuditLogEntry$Change5.getKey();
                        if (key2 != null) {
                            int iHashCode = key2.hashCode();
                            if (iHashCode != 3373707) {
                                if (iHashCode == 3575610 && key2.equals("type")) {
                                    modelAuditLogEntry$Change4 = modelAuditLogEntry$Change5;
                                }
                            } else if (key2.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                                modelAuditLogEntry$Change3 = modelAuditLogEntry$Change5;
                            }
                        }
                    }
                    modelAuditLogEntry$Change = modelAuditLogEntry$Change3;
                    modelAuditLogEntry$Change2 = modelAuditLogEntry$Change4;
                } else {
                    modelAuditLogEntry$Change = null;
                    modelAuditLogEntry$Change2 = null;
                }
                if (modelAuditLogEntry.getActionTypeId() == 21) {
                    ModelAuditLogEntry$Options options2 = modelAuditLogEntry.getOptions();
                    arrayList2.add(new ModelAuditLogEntry$Change(ModelAuditLogEntry.CHANGE_KEY_PRUNE_DELETE_DAYS, null, Integer.valueOf(options2 != null ? options2.getDeleteMemberDays() : 1)));
                }
                ModelAuditLogEntry modelAuditLogEntry2 = new ModelAuditLogEntry(modelAuditLogEntry.getId(), modelAuditLogEntry.getActionTypeId(), modelAuditLogEntry.getTargetId(), modelAuditLogEntry.getUserId(), arrayList2, modelAuditLogEntry.getOptions(), guildId, null);
                ModelAuditLogEntry modelAuditLogEntry3 = (ModelAuditLogEntry) u.firstOrNull((List) arrayList);
                List mutableList = null;
                if (shouldMergeEntries$default(this, modelAuditLogEntry3, modelAuditLogEntry2, i, 0, 0, 24, null)) {
                    long id2 = modelAuditLogEntry3 != null ? modelAuditLogEntry3.getId() : modelAuditLogEntry2.getId();
                    int actionTypeId = modelAuditLogEntry3 != null ? modelAuditLogEntry3.getActionTypeId() : modelAuditLogEntry2.getActionTypeId();
                    long targetId = modelAuditLogEntry3 != null ? modelAuditLogEntry3.getTargetId() : modelAuditLogEntry2.getTargetId();
                    long userId = modelAuditLogEntry3 != null ? modelAuditLogEntry3.getUserId() : modelAuditLogEntry2.getUserId();
                    if (modelAuditLogEntry3 != null && (changes = modelAuditLogEntry3.getChanges()) != null) {
                        mutableList = u.toMutableList((Collection) changes);
                    }
                    if (mutableList != null) {
                        List<ModelAuditLogEntry$Change> changes3 = modelAuditLogEntry2.getChanges();
                        if (changes3 == null) {
                            changes3 = n.emptyList();
                        }
                        mutableList.addAll(changes3);
                    } else {
                        modelAuditLogEntry2.getChanges();
                    }
                    if (modelAuditLogEntry3 == null || (options = modelAuditLogEntry3.getOptions()) == null) {
                        options = modelAuditLogEntry2.getOptions();
                    }
                    arrayList.set(0, new ModelAuditLogEntry(id2, actionTypeId, targetId, userId, mutableList, options, guildId, Long.valueOf(AuditLogUtils.INSTANCE.getTimestampStart(modelAuditLogEntry2))));
                    i++;
                } else {
                    Map mutableMap = h0.toMutableMap(this.state.getDeletedTargets());
                    if (modelAuditLogEntry2.getActionType() == ModelAuditLogEntry$ActionType.DELETE && modelAuditLogEntry$Change != null) {
                        String str = (String) modelAuditLogEntry$Change.getOldValue();
                        if (modelAuditLogEntry2.getTargetType() == ModelAuditLogEntry$TargetType.CHANNEL) {
                            if (m.areEqual(modelAuditLogEntry$Change2 != null ? modelAuditLogEntry$Change2.getOldValue() : null, (Object) 0)) {
                                str = MentionUtilsKt.CHANNELS_CHAR + str;
                            }
                        }
                        if (mutableMap.get(modelAuditLogEntry2.getTargetType()) == null) {
                            ModelAuditLogEntry$TargetType targetType = modelAuditLogEntry2.getTargetType();
                            m.checkNotNullExpressionValue(targetType, "entry.targetType");
                            mutableMap.put(targetType, h0.mutableMapOf(o.to(Long.valueOf(modelAuditLogEntry2.getTargetId()), str)));
                        } else {
                            Map map = (Map) mutableMap.get(modelAuditLogEntry2.getTargetType());
                            if (map != null) {
                            }
                        }
                        this.state = StoreAuditLog$AuditLogState.copy$default(this.state, 0L, null, null, null, null, null, null, null, null, mutableMap, false, 1535, null);
                    }
                    arrayList.add(0, modelAuditLogEntry2);
                }
            }
            return arrayList;
        }
    }

    public final void clearState() {
        this.dispatcher.schedule(new StoreAuditLog$clearState$1(this));
    }

    public final void fetchAuditLogIfNeeded(long guildId) {
        this.dispatcher.schedule(new StoreAuditLog$fetchAuditLogIfNeeded$1(this, guildId));
    }

    public final void fetchMoreAuditLogEntries() {
        this.dispatcher.schedule(new StoreAuditLog$fetchMoreAuditLogEntries$1(this));
    }

    public final StoreAuditLog$AuditLogState getAuditLogState(long guildId) {
        StoreAuditLog$AuditLogState storeAuditLog$AuditLogState = this.stateSnapshot;
        if (guildId == storeAuditLog$AuditLogState.getGuildId()) {
            return storeAuditLog$AuditLogState;
        }
        return null;
    }

    public final Observable<StoreAuditLog$AuditLogState> observeAuditLogState(long guildId) {
        Observable observableU = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreAuditLog$observeAuditLogState$1(this, guildId), 14, null).r().u(new StoreAuditLog$observeAuditLogState$2(this, guildId));
        m.checkNotNullExpressionValue(observableU, "observationDeck.connectR…ditLogIfNeeded(guildId) }");
        Observable<StoreAuditLog$AuditLogState> observableG = observableU.y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        return observableG;
    }

    public final void setAuditLogFilterActionId(int actionId) {
        this.dispatcher.schedule(new StoreAuditLog$setAuditLogFilterActionId$1(this, actionId));
    }

    public final void setAuditLogFilterUserId(long userId) {
        this.dispatcher.schedule(new StoreAuditLog$setAuditLogFilterUserId$1(this, userId));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        StoreAuditLog$AuditLogState storeAuditLog$AuditLogState = this.state;
        HashMap map = new HashMap(this.state.getUsers());
        List<ModelAuditLogEntry> entries = this.state.getEntries();
        ArrayList arrayList = entries != null ? new ArrayList(entries) : null;
        ArrayList arrayList2 = new ArrayList(this.state.getWebhooks());
        ArrayList arrayList3 = new ArrayList(this.state.getIntegrations());
        ArrayList arrayList4 = new ArrayList(this.state.getGuildScheduledEvents());
        ArrayList arrayList5 = new ArrayList(this.state.getThreads());
        Map<ModelAuditLogEntry$TargetType, Map<Long, CharSequence>> deletedTargets = this.state.getDeletedTargets();
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(deletedTargets.size()));
        Iterator<T> it = deletedTargets.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            linkedHashMap.put(map$Entry.getKey(), new HashMap((Map) map$Entry.getValue()));
        }
        this.stateSnapshot = StoreAuditLog$AuditLogState.copy$default(storeAuditLog$AuditLogState, 0L, map, arrayList, arrayList2, arrayList3, arrayList4, arrayList5, null, null, linkedHashMap, false, 1409, null);
    }

    public final void toggleSelectedState(long selectedItemId) {
        this.dispatcher.schedule(new StoreAuditLog$toggleSelectedState$1(this, selectedItemId));
    }
}
