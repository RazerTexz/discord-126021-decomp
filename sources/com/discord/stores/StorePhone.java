package com.discord.stores;

import android.content.Context;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelPayload;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.utilities.persister.Persister;
import com.google.gson.Gson;
import d0.t._Arrays;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StorePhone.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePhone extends StoreV2 {
    private List<PhoneCountryCode> countryCodes;
    private PhoneCountryCode defaultCountryCode;
    private final Dispatcher dispatcher;
    private PhoneCountryCode selectedCountryCode;
    private final Persister<PhoneCountryCode> selectedCountryCodeCache;

    /* JADX INFO: renamed from: com.discord.stores.StorePhone$updateDefaultCountryCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: StorePhone.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $alpha2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$alpha2 = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Object next;
            Iterator<T> it = StorePhone.this.getCountryCodes().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics3.areEqual(((PhoneCountryCode) next).getAlpha2(), this.$alpha2));
            PhoneCountryCode phoneCountryCode = (PhoneCountryCode) next;
            if (phoneCountryCode != null) {
                StorePhone.this.defaultCountryCode = phoneCountryCode;
                StorePhone.this.markChanged();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StorePhone$updateSelectedCountryCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: StorePhone.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PhoneCountryCode $newSelectedCountryCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PhoneCountryCode phoneCountryCode) {
            super(0);
            this.$newSelectedCountryCode = phoneCountryCode;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StorePhone.this.selectedCountryCode = this.$newSelectedCountryCode;
            StorePhone.this.markChanged();
        }
    }

    public StorePhone(Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        PhoneCountryCode.Companion companion = PhoneCountryCode.INSTANCE;
        this.defaultCountryCode = companion.getDEFAULT_COUNTRY_CODE();
        this.selectedCountryCode = companion.getMISSING_COUNTRY_CODE();
        this.selectedCountryCodeCache = new Persister<>("CACHE_KEY_PHONE_COUNTRY_CODE_V2", this.selectedCountryCode);
    }

    public static final /* synthetic */ List access$getCountryCodes$p(StorePhone storePhone) {
        List<PhoneCountryCode> list = storePhone.countryCodes;
        if (list == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("countryCodes");
        }
        return list;
    }

    private final List<PhoneCountryCode> loadCountryCodesFromDisk(Context context) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(context.getAssets().open("data/countries.json"), Constants.ENCODING);
        try {
            Object objE = new Gson().e(inputStreamReader, PhoneCountryCode[].class);
            Intrinsics3.checkNotNullExpressionValue(objE, "Gson().fromJson(it, Arra…CountryCode>::class.java)");
            List<PhoneCountryCode> list = _Arrays.toList((Object[]) objE);
            Closeable.closeFinally(inputStreamReader, null);
            return list;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                Closeable.closeFinally(inputStreamReader, th);
                throw th2;
            }
        }
    }

    public final PhoneCountryCode getCountryCode() {
        return Intrinsics3.areEqual(this.selectedCountryCode, PhoneCountryCode.INSTANCE.getMISSING_COUNTRY_CODE()) ? this.defaultCountryCode : this.selectedCountryCode;
    }

    public final List<PhoneCountryCode> getCountryCodes() {
        List<PhoneCountryCode> list = this.countryCodes;
        if (list == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("countryCodes");
        }
        return list;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        String countryCode = payload.getCountryCode();
        if (countryCode != null) {
            updateDefaultCountryCode(countryCode);
        }
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.countryCodes = loadCountryCodesFromDisk(context);
        this.selectedCountryCode = this.selectedCountryCodeCache.get();
        markChanged();
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        Persister.set$default(this.selectedCountryCodeCache, this.selectedCountryCode, false, 2, null);
    }

    public final void updateDefaultCountryCode(String alpha2) {
        Intrinsics3.checkNotNullParameter(alpha2, "alpha2");
        this.dispatcher.schedule(new AnonymousClass1(alpha2));
    }

    public final void updateSelectedCountryCode(PhoneCountryCode newSelectedCountryCode) {
        Intrinsics3.checkNotNullParameter(newSelectedCountryCode, "newSelectedCountryCode");
        this.dispatcher.schedule(new AnonymousClass1(newSelectedCountryCode));
    }
}
