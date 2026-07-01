package com.discord.stores;

import com.discord.models.domain.ModelLocationMetadata;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$requestConsentRequired$1 extends o implements Function1<ModelLocationMetadata, Unit> {
    public final /* synthetic */ StoreAuthentication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAuthentication$requestConsentRequired$1(StoreAuthentication storeAuthentication) {
        super(1);
        this.this$0 = storeAuthentication;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelLocationMetadata modelLocationMetadata) {
        invoke2(modelLocationMetadata);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelLocationMetadata modelLocationMetadata) {
        m.checkNotNullParameter(modelLocationMetadata, "it");
        StoreAuthentication.access$setConsentRequired$p(this.this$0, modelLocationMetadata.getConsentRequired());
        String countryCode = modelLocationMetadata.getCountryCode();
        if (countryCode != null) {
            StoreStream.Companion.getPhone().updateDefaultCountryCode(countryCode);
        }
    }
}
