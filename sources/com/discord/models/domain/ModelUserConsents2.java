package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.restapi.RestAPIParams;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.models.domain.Consents, reason: use source file name */
/* JADX INFO: compiled from: ModelUserConsents.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelUserConsents2 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ModelUserConsents2 DEFAULT = new ModelUserConsents2(new ModelUserConsents(false, null, 3, null), new ModelUserConsents(false, null, 3, null));
    private final ModelUserConsents personalization;
    private final ModelUserConsents usageStatistics;

    /* JADX INFO: renamed from: com.discord.models.domain.Consents$Companion, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ModelUserConsents.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ModelUserConsents2 getDEFAULT() {
            return ModelUserConsents2.DEFAULT;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ModelUserConsents2(ModelUserConsents modelUserConsents, ModelUserConsents modelUserConsents2) {
        Intrinsics3.checkNotNullParameter(modelUserConsents, "usageStatistics");
        Intrinsics3.checkNotNullParameter(modelUserConsents2, RestAPIParams.Consents.Type.PERSONALIZATION);
        this.usageStatistics = modelUserConsents;
        this.personalization = modelUserConsents2;
    }

    public static /* synthetic */ ModelUserConsents2 copy$default(ModelUserConsents2 modelUserConsents2, ModelUserConsents modelUserConsents, ModelUserConsents modelUserConsents3, int i, Object obj) {
        if ((i & 1) != 0) {
            modelUserConsents = modelUserConsents2.usageStatistics;
        }
        if ((i & 2) != 0) {
            modelUserConsents3 = modelUserConsents2.personalization;
        }
        return modelUserConsents2.copy(modelUserConsents, modelUserConsents3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelUserConsents getUsageStatistics() {
        return this.usageStatistics;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ModelUserConsents getPersonalization() {
        return this.personalization;
    }

    public final ModelUserConsents2 copy(ModelUserConsents usageStatistics, ModelUserConsents personalization) {
        Intrinsics3.checkNotNullParameter(usageStatistics, "usageStatistics");
        Intrinsics3.checkNotNullParameter(personalization, RestAPIParams.Consents.Type.PERSONALIZATION);
        return new ModelUserConsents2(usageStatistics, personalization);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelUserConsents2)) {
            return false;
        }
        ModelUserConsents2 modelUserConsents2 = (ModelUserConsents2) other;
        return Intrinsics3.areEqual(this.usageStatistics, modelUserConsents2.usageStatistics) && Intrinsics3.areEqual(this.personalization, modelUserConsents2.personalization);
    }

    public final ModelUserConsents getPersonalization() {
        return this.personalization;
    }

    public final ModelUserConsents getUsageStatistics() {
        return this.usageStatistics;
    }

    public int hashCode() {
        ModelUserConsents modelUserConsents = this.usageStatistics;
        int iHashCode = (modelUserConsents != null ? modelUserConsents.hashCode() : 0) * 31;
        ModelUserConsents modelUserConsents2 = this.personalization;
        return iHashCode + (modelUserConsents2 != null ? modelUserConsents2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Consents(usageStatistics=");
        sbU.append(this.usageStatistics);
        sbU.append(", personalization=");
        sbU.append(this.personalization);
        sbU.append(")");
        return sbU.toString();
    }
}
