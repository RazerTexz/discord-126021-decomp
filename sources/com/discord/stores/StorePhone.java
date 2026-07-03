package com.discord.stores;

import android.content.Context;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelPayload;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.utilities.persister.Persister;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12141k;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StorePhone.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePhone extends StoreV2 {
    private List<PhoneCountryCode> countryCodes;
    private PhoneCountryCode defaultCountryCode;
    private final Dispatcher dispatcher;
    private PhoneCountryCode selectedCountryCode;
    private final Persister<PhoneCountryCode> selectedCountryCodeCache;

    /* JADX INFO: renamed from: com.discord.stores.StorePhone$updateDefaultCountryCode$1 */
    /* JADX INFO: compiled from: StorePhone.kt */
    public static final class C63341 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $alpha2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63341(String str) {
            super(0);
            this.$alpha2 = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
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
            } while (!C12238m.areEqual(((PhoneCountryCode) next).getAlpha2(), this.$alpha2));
            PhoneCountryCode phoneCountryCode = (PhoneCountryCode) next;
            if (phoneCountryCode != null) {
                StorePhone.this.defaultCountryCode = phoneCountryCode;
                StorePhone.this.markChanged();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StorePhone$updateSelectedCountryCode$1 */
    /* JADX INFO: compiled from: StorePhone.kt */
    public static final class C63351 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ PhoneCountryCode $newSelectedCountryCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63351(PhoneCountryCode phoneCountryCode) {
            super(0);
            this.$newSelectedCountryCode = phoneCountryCode;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StorePhone.this.selectedCountryCode = this.$newSelectedCountryCode;
            StorePhone.this.markChanged();
        }
    }

    public StorePhone(Dispatcher dispatcher) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        PhoneCountryCode.Companion companion = PhoneCountryCode.INSTANCE;
        this.defaultCountryCode = companion.getDEFAULT_COUNTRY_CODE();
        this.selectedCountryCode = companion.getMISSING_COUNTRY_CODE();
        this.selectedCountryCodeCache = new Persister<>("CACHE_KEY_PHONE_COUNTRY_CODE_V2", this.selectedCountryCode);
    }

    public static final /* synthetic */ List access$getCountryCodes$p(StorePhone storePhone) {
        List<PhoneCountryCode> list = storePhone.countryCodes;
        if (list == null) {
            C12238m.throwUninitializedPropertyAccessException("countryCodes");
        }
        return list;
    }

    private final List<PhoneCountryCode> loadCountryCodesFromDisk(Context context) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(context.getAssets().open("data/countries.json"), Constants.ENCODING);
        try {
            Object objM9201e = new Gson().m9201e(inputStreamReader, PhoneCountryCode[].class);
            C12238m.checkNotNullExpressionValue(objM9201e, "Gson().fromJson(it, Arra…CountryCode>::class.java)");
            List<PhoneCountryCode> list = C12141k.toList((Object[]) objM9201e);
            C12201b.closeFinally(inputStreamReader, null);
            return list;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                C12201b.closeFinally(inputStreamReader, th);
                throw th2;
            }
        }
    }

    public final PhoneCountryCode getCountryCode() {
        return C12238m.areEqual(this.selectedCountryCode, PhoneCountryCode.INSTANCE.getMISSING_COUNTRY_CODE()) ? this.defaultCountryCode : this.selectedCountryCode;
    }

    public final List<PhoneCountryCode> getCountryCodes() {
        List<PhoneCountryCode> list = this.countryCodes;
        if (list == null) {
            C12238m.throwUninitializedPropertyAccessException("countryCodes");
        }
        return list;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        String countryCode = payload.getCountryCode();
        if (countryCode != null) {
            updateDefaultCountryCode(countryCode);
        }
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        C12238m.checkNotNullParameter(context, "context");
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
        C12238m.checkNotNullParameter(alpha2, "alpha2");
        this.dispatcher.schedule(new C63341(alpha2));
    }

    public final void updateSelectedCountryCode(PhoneCountryCode newSelectedCountryCode) {
        C12238m.checkNotNullParameter(newSelectedCountryCode, "newSelectedCountryCode");
        this.dispatcher.schedule(new C63351(newSelectedCountryCode));
    }
}
