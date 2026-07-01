package com.discord.widgets.settings.developer;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ExperimentOverridesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ExperimentOverridesAdapter$Item {
    String getApiName();

    List<String> getBucketDescriptions();

    String getName();

    Function0<Unit> getOnOverrideBucketCleared();

    Function1<Integer, Unit> getOnOverrideBucketSelected();

    Integer getOverrideBucket();
}
