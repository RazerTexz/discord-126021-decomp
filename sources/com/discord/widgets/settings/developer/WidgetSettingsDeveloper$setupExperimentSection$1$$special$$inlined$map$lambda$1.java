package com.discord.widgets.settings.developer;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.experiments.RegisteredExperiment;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1 implements ExperimentOverridesAdapter$Item {
    public final /* synthetic */ Map $allOverrides$inlined;
    public final /* synthetic */ RegisteredExperiment $registeredExperiment;
    private final String apiName;
    private final List<String> bucketDescriptions;
    private final String name;
    private final Integer overrideBucket;
    public final /* synthetic */ WidgetSettingsDeveloper$setupExperimentSection$1 this$0;
    private final Function1<Integer, Unit> onOverrideBucketSelected = new WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1$1(this);
    private final Function0<Unit> onOverrideBucketCleared = new WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1$2(this);

    public WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1(RegisteredExperiment registeredExperiment, WidgetSettingsDeveloper$setupExperimentSection$1 widgetSettingsDeveloper$setupExperimentSection$1, Map map) {
        this.$registeredExperiment = registeredExperiment;
        this.this$0 = widgetSettingsDeveloper$setupExperimentSection$1;
        this.$allOverrides$inlined = map;
        this.name = registeredExperiment.getReadableName();
        this.apiName = registeredExperiment.getName();
        this.overrideBucket = (Integer) map.get(registeredExperiment.getName());
        this.bucketDescriptions = registeredExperiment.getBuckets();
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter$Item
    public String getApiName() {
        return this.apiName;
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter$Item
    public List<String> getBucketDescriptions() {
        return this.bucketDescriptions;
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter$Item
    public String getName() {
        return this.name;
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter$Item
    public Function0<Unit> getOnOverrideBucketCleared() {
        return this.onOverrideBucketCleared;
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter$Item
    public Function1<Integer, Unit> getOnOverrideBucketSelected() {
        return this.onOverrideBucketSelected;
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter$Item
    public Integer getOverrideBucket() {
        return this.overrideBucket;
    }
}
