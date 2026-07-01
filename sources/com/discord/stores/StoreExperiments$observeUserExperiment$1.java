package com.discord.stores;

import com.discord.models.experiments.domain.Experiment;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreExperiments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExperiments$observeUserExperiment$1 extends o implements Function0<Experiment> {
    public final /* synthetic */ String $name;
    public final /* synthetic */ boolean $trackExposure;
    public final /* synthetic */ StoreExperiments this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreExperiments$observeUserExperiment$1(StoreExperiments storeExperiments, String str, boolean z2) {
        super(0);
        this.this$0 = storeExperiments;
        this.$name = str;
        this.$trackExposure = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Experiment invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Experiment invoke() {
        return this.this$0.getUserExperiment(this.$name, this.$trackExposure);
    }
}
