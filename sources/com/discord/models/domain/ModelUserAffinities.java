package com.discord.models.domain;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: ModelUserAffinities.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelUserAffinities {
    private final List<ModelUserAffinity> inverseUserAffinities;
    private final List<ModelUserAffinity> userAffinities;

    public ModelUserAffinities(List<ModelUserAffinity> list, List<ModelUserAffinity> list2) {
        Intrinsics3.checkNotNullParameter(list, "userAffinities");
        Intrinsics3.checkNotNullParameter(list2, "inverseUserAffinities");
        this.userAffinities = list;
        this.inverseUserAffinities = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelUserAffinities copy$default(ModelUserAffinities modelUserAffinities, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = modelUserAffinities.userAffinities;
        }
        if ((i & 2) != 0) {
            list2 = modelUserAffinities.inverseUserAffinities;
        }
        return modelUserAffinities.copy(list, list2);
    }

    public final List<ModelUserAffinity> component1() {
        return this.userAffinities;
    }

    public final List<ModelUserAffinity> component2() {
        return this.inverseUserAffinities;
    }

    public final ModelUserAffinities copy(List<ModelUserAffinity> userAffinities, List<ModelUserAffinity> inverseUserAffinities) {
        Intrinsics3.checkNotNullParameter(userAffinities, "userAffinities");
        Intrinsics3.checkNotNullParameter(inverseUserAffinities, "inverseUserAffinities");
        return new ModelUserAffinities(userAffinities, inverseUserAffinities);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelUserAffinities)) {
            return false;
        }
        ModelUserAffinities modelUserAffinities = (ModelUserAffinities) other;
        return Intrinsics3.areEqual(this.userAffinities, modelUserAffinities.userAffinities) && Intrinsics3.areEqual(this.inverseUserAffinities, modelUserAffinities.inverseUserAffinities);
    }

    public final List<ModelUserAffinity> getInverseUserAffinities() {
        return this.inverseUserAffinities;
    }

    public final List<ModelUserAffinity> getUserAffinities() {
        return this.userAffinities;
    }

    public int hashCode() {
        List<ModelUserAffinity> list = this.userAffinities;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<ModelUserAffinity> list2 = this.inverseUserAffinities;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelUserAffinities(userAffinities=");
        sbU.append(this.userAffinities);
        sbU.append(", inverseUserAffinities=");
        return outline.L(sbU, this.inverseUserAffinities, ")");
    }
}
