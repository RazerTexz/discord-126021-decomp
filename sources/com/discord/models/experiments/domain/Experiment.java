package com.discord.models.experiments.domain;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Experiment.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Experiment {
    private final int bucket;
    private final boolean isOverride;
    private final int population;
    private final int revision;
    private final Function0<Unit> trackExposure;

    public Experiment(int i, int i2, int i3, boolean z2, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "trackExposure");
        this.revision = i;
        this.bucket = i2;
        this.population = i3;
        this.isOverride = z2;
        this.trackExposure = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Experiment copy$default(Experiment experiment, int i, int i2, int i3, boolean z2, Function0 function0, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = experiment.revision;
        }
        if ((i4 & 2) != 0) {
            i2 = experiment.bucket;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = experiment.population;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            z2 = experiment.isOverride;
        }
        boolean z3 = z2;
        if ((i4 & 16) != 0) {
            function0 = experiment.trackExposure;
        }
        return experiment.copy(i, i5, i6, z3, function0);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getRevision() {
        return this.revision;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getBucket() {
        return this.bucket;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPopulation() {
        return this.population;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsOverride() {
        return this.isOverride;
    }

    public final Function0<Unit> component5() {
        return this.trackExposure;
    }

    public final Experiment copy(int revision, int bucket, int population, boolean isOverride, Function0<Unit> trackExposure) {
        Intrinsics3.checkNotNullParameter(trackExposure, "trackExposure");
        return new Experiment(revision, bucket, population, isOverride, trackExposure);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Experiment)) {
            return false;
        }
        Experiment experiment = (Experiment) other;
        return this.revision == experiment.revision && this.bucket == experiment.bucket && this.population == experiment.population && this.isOverride == experiment.isOverride && Intrinsics3.areEqual(this.trackExposure, experiment.trackExposure);
    }

    public final int getBucket() {
        return this.bucket;
    }

    public final int getPopulation() {
        return this.population;
    }

    public final int getRevision() {
        return this.revision;
    }

    public final Function0<Unit> getTrackExposure() {
        return this.trackExposure;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int i = ((((this.revision * 31) + this.bucket) * 31) + this.population) * 31;
        boolean z2 = this.isOverride;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i2 = (i + r1) * 31;
        Function0<Unit> function0 = this.trackExposure;
        return i2 + (function0 != null ? function0.hashCode() : 0);
    }

    public final boolean isOverride() {
        return this.isOverride;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Experiment(revision=");
        sbU.append(this.revision);
        sbU.append(", bucket=");
        sbU.append(this.bucket);
        sbU.append(", population=");
        sbU.append(this.population);
        sbU.append(", isOverride=");
        sbU.append(this.isOverride);
        sbU.append(", trackExposure=");
        sbU.append(this.trackExposure);
        sbU.append(")");
        return sbU.toString();
    }
}
