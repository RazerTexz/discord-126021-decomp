package com.discord.stores.updates;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.k;
import d0.z.d.m;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ObservationDeck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservationDeck$connect$observer$1 extends ObservationDeck$Observer {
    public final /* synthetic */ String $observerName;
    public final /* synthetic */ Function0 $onUpdate;
    public final /* synthetic */ ObservationDeck$UpdateSource[] $updateSources;
    private final String name;
    private final Set<ObservationDeck$UpdateSource> observingUpdates;
    private Function0<Unit> onUpdate;

    public ObservationDeck$connect$observer$1(ObservationDeck$UpdateSource[] observationDeck$UpdateSourceArr, Function0 function0, String str) {
        this.$updateSources = observationDeck$UpdateSourceArr;
        this.$onUpdate = function0;
        this.$observerName = str;
        this.observingUpdates = k.toSet(observationDeck$UpdateSourceArr);
        this.onUpdate = function0;
        this.name = str == null ? String.valueOf(hashCode()) : str;
    }

    @Override // com.discord.stores.updates.ObservationDeck$Observer
    public String getName() {
        return this.name;
    }

    @Override // com.discord.stores.updates.ObservationDeck$Observer
    public Set<ObservationDeck$UpdateSource> getObservingUpdates() {
        return this.observingUpdates;
    }

    @Override // com.discord.stores.updates.ObservationDeck$Observer
    public Function0<Unit> getOnUpdate() {
        return this.onUpdate;
    }

    @Override // com.discord.stores.updates.ObservationDeck$Observer
    public void setOnUpdate(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onUpdate = function0;
    }
}
