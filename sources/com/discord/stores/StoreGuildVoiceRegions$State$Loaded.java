package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelVoiceRegion;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: StoreGuildVoiceRegions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGuildVoiceRegions$State$Loaded extends StoreGuildVoiceRegions$State {
    private final List<ModelVoiceRegion> data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StoreGuildVoiceRegions$State$Loaded(List<? extends ModelVoiceRegion> list) {
        super(null);
        m.checkNotNullParameter(list, "data");
        this.data = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreGuildVoiceRegions$State$Loaded copy$default(StoreGuildVoiceRegions$State$Loaded storeGuildVoiceRegions$State$Loaded, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = storeGuildVoiceRegions$State$Loaded.data;
        }
        return storeGuildVoiceRegions$State$Loaded.copy(list);
    }

    public final List<ModelVoiceRegion> component1() {
        return this.data;
    }

    public final StoreGuildVoiceRegions$State$Loaded copy(List<? extends ModelVoiceRegion> data) {
        m.checkNotNullParameter(data, "data");
        return new StoreGuildVoiceRegions$State$Loaded(data);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreGuildVoiceRegions$State$Loaded) && m.areEqual(this.data, ((StoreGuildVoiceRegions$State$Loaded) other).data);
        }
        return true;
    }

    public final List<ModelVoiceRegion> getData() {
        return this.data;
    }

    public int hashCode() {
        List<ModelVoiceRegion> list = this.data;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("Loaded(data="), this.data, ")");
    }
}
