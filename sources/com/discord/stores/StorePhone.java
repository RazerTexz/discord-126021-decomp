package com.discord.stores;

import android.content.Context;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelPayload;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.models.phone.PhoneCountryCode$Companion;
import com.discord.utilities.persister.Persister;
import com.google.gson.Gson;
import d0.t.k;
import d0.y.b;
import d0.z.d.m;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/* JADX INFO: compiled from: StorePhone.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePhone extends StoreV2 {
    private List<PhoneCountryCode> countryCodes;
    private PhoneCountryCode defaultCountryCode;
    private final Dispatcher dispatcher;
    private PhoneCountryCode selectedCountryCode;
    private final Persister<PhoneCountryCode> selectedCountryCodeCache;

    public StorePhone(Dispatcher dispatcher) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        PhoneCountryCode$Companion phoneCountryCode$Companion = PhoneCountryCode.Companion;
        this.defaultCountryCode = phoneCountryCode$Companion.getDEFAULT_COUNTRY_CODE();
        this.selectedCountryCode = phoneCountryCode$Companion.getMISSING_COUNTRY_CODE();
        this.selectedCountryCodeCache = new Persister<>("CACHE_KEY_PHONE_COUNTRY_CODE_V2", this.selectedCountryCode);
    }

    public static final /* synthetic */ List access$getCountryCodes$p(StorePhone storePhone) {
        List<PhoneCountryCode> list = storePhone.countryCodes;
        if (list == null) {
            m.throwUninitializedPropertyAccessException("countryCodes");
        }
        return list;
    }

    public static final /* synthetic */ PhoneCountryCode access$getDefaultCountryCode$p(StorePhone storePhone) {
        return storePhone.defaultCountryCode;
    }

    public static final /* synthetic */ PhoneCountryCode access$getSelectedCountryCode$p(StorePhone storePhone) {
        return storePhone.selectedCountryCode;
    }

    public static final /* synthetic */ void access$setCountryCodes$p(StorePhone storePhone, List list) {
        storePhone.countryCodes = list;
    }

    public static final /* synthetic */ void access$setDefaultCountryCode$p(StorePhone storePhone, PhoneCountryCode phoneCountryCode) {
        storePhone.defaultCountryCode = phoneCountryCode;
    }

    public static final /* synthetic */ void access$setSelectedCountryCode$p(StorePhone storePhone, PhoneCountryCode phoneCountryCode) {
        storePhone.selectedCountryCode = phoneCountryCode;
    }

    private final List<PhoneCountryCode> loadCountryCodesFromDisk(Context context) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(context.getAssets().open("data/countries.json"), Constants.ENCODING);
        try {
            Object objE = new Gson().e(inputStreamReader, PhoneCountryCode[].class);
            m.checkNotNullExpressionValue(objE, "Gson().fromJson(it, Arra…CountryCode>::class.java)");
            List<PhoneCountryCode> list = k.toList((Object[]) objE);
            b.closeFinally(inputStreamReader, null);
            return list;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.closeFinally(inputStreamReader, th);
                throw th2;
            }
        }
    }

    public final PhoneCountryCode getCountryCode() {
        return m.areEqual(this.selectedCountryCode, PhoneCountryCode.Companion.getMISSING_COUNTRY_CODE()) ? this.defaultCountryCode : this.selectedCountryCode;
    }

    public final List<PhoneCountryCode> getCountryCodes() {
        List<PhoneCountryCode> list = this.countryCodes;
        if (list == null) {
            m.throwUninitializedPropertyAccessException("countryCodes");
        }
        return list;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        String countryCode = payload.getCountryCode();
        if (countryCode != null) {
            updateDefaultCountryCode(countryCode);
        }
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        this.countryCodes = loadCountryCodesFromDisk(context);
        this.selectedCountryCode = this.selectedCountryCodeCache.get();
        markChanged();
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        Persister.set$default(this.selectedCountryCodeCache, this.selectedCountryCode, false, 2, null);
    }

    public final void updateDefaultCountryCode(String alpha2) {
        m.checkNotNullParameter(alpha2, "alpha2");
        this.dispatcher.schedule(new StorePhone$updateDefaultCountryCode$1(this, alpha2));
    }

    public final void updateSelectedCountryCode(PhoneCountryCode newSelectedCountryCode) {
        m.checkNotNullParameter(newSelectedCountryCode, "newSelectedCountryCode");
        this.dispatcher.schedule(new StorePhone$updateSelectedCountryCode$1(this, newSelectedCountryCode));
    }
}
