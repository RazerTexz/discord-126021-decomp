package com.discord.widgets.settings.developer;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreExperiments;
import com.discord.utilities.experiments.ExperimentRegistry;
import com.discord.utilities.experiments.RegisteredExperiment;
import d0.t.o;
import d0.z.d.m;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$setupExperimentSection$1<T, R> implements b<Map<String, ? extends Integer>, List<? extends WidgetSettingsDeveloper$setupExperimentSection$1$1$1>> {
    public final /* synthetic */ StoreExperiments $experimentStore;

    public WidgetSettingsDeveloper$setupExperimentSection$1(StoreExperiments storeExperiments) {
        this.$experimentStore = storeExperiments;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends WidgetSettingsDeveloper$setupExperimentSection$1$1$1> call(Map<String, ? extends Integer> map) {
        return call2((Map<String, Integer>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<WidgetSettingsDeveloper$setupExperimentSection$1$1$1> call2(Map<String, Integer> map) {
        Collection<RegisteredExperiment> collectionValues = ExperimentRegistry.INSTANCE.getRegisteredExperiments().values();
        m.checkNotNullExpressionValue(collectionValues, "ExperimentRegistry\n     …nts\n              .values");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(collectionValues, 10));
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            arrayList.add(new WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1((RegisteredExperiment) it.next(), this, map));
        }
        return arrayList;
    }
}
