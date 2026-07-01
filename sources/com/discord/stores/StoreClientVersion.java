package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.BuildConfig;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreClientVersion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreClientVersion extends Store {
    private int clientMinVersion;
    private final int clientVersion = BuildConfig.VERSION_CODE;
    private final String clientMinVersionKey = "CLIENT_OUTDATED_KEY";
    private final SerializedSubject<Boolean, Boolean> clientOutdatedSubject = new SerializedSubject<>(BehaviorSubject.l0(Boolean.FALSE));

    /* JADX INFO: renamed from: com.discord.stores.StoreClientVersion$init$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreClientVersion.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass2(StoreClientVersion storeClientVersion) {
            super(1, storeClientVersion, StoreClientVersion.class, "setClientMinVersion", "setClientMinVersion(I)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            ((StoreClientVersion) this.receiver).setClientMinVersion(i);
        }
    }

    private final synchronized void setClientMinVersion(int clientMinVersion) {
        if (this.clientMinVersion != clientMinVersion) {
            this.clientMinVersion = clientMinVersion;
            this.clientOutdatedSubject.k.onNext(Boolean.valueOf(this.clientVersion < clientMinVersion));
            SharedPreferences.Editor editorEdit = getPrefs().edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.putInt(this.clientMinVersionKey, clientMinVersion);
            editorEdit.apply();
        }
    }

    public final Observable<Boolean> getClientOutdated() {
        Observable<Boolean> observableR = ObservableExtensionsKt.computationLatest(this.clientOutdatedSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "clientOutdatedSubject\n  …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.Store
    public synchronized void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        int i = getPrefs().getInt(this.clientMinVersionKey, 0);
        this.clientMinVersion = i;
        setClientMinVersion(i);
        Observable<R> observableA = Observable.E(0L, 1L, TimeUnit.HOURS).A(new Func1<Long, Observable<? extends Integer>>() { // from class: com.discord.stores.StoreClientVersion.init.1
            @Override // j0.k.Func1
            public final Observable<? extends Integer> call(Long l) {
                return RestAPI.INSTANCE.getApi().getClientVersion();
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableA, "Observable\n        .inte…ClientVersion()\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationBuffered(observableA), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }
}
