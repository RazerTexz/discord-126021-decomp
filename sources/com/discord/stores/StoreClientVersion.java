package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.BuildConfig;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreClientVersion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreClientVersion extends Store {
    private int clientMinVersion;
    private final int clientVersion = BuildConfig.VERSION_CODE;
    private final String clientMinVersionKey = "CLIENT_OUTDATED_KEY";
    private final SerializedSubject<Boolean, Boolean> clientOutdatedSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(Boolean.FALSE));

    /* JADX INFO: renamed from: com.discord.stores.StoreClientVersion$init$2 */
    /* JADX INFO: compiled from: StoreClientVersion.kt */
    public static final /* synthetic */ class C58482 extends C12236k implements Function1<Integer, Unit> {
        public C58482(StoreClientVersion storeClientVersion) {
            super(1, storeClientVersion, StoreClientVersion.class, "setClientMinVersion", "setClientMinVersion(I)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            ((StoreClientVersion) this.receiver).setClientMinVersion(i);
        }
    }

    private final synchronized void setClientMinVersion(int clientMinVersion) {
        if (this.clientMinVersion != clientMinVersion) {
            this.clientMinVersion = clientMinVersion;
            this.clientOutdatedSubject.f27653k.onNext(Boolean.valueOf(this.clientVersion < clientMinVersion));
            SharedPreferences.Editor editorEdit = getPrefs().edit();
            C12238m.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.putInt(this.clientMinVersionKey, clientMinVersion);
            editorEdit.apply();
        }
    }

    public final Observable<Boolean> getClientOutdated() {
        Observable<Boolean> observableM11112r = ObservableExtensionsKt.computationLatest(this.clientOutdatedSubject).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "clientOutdatedSubject\n  …  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.Store
    public synchronized void init(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        super.init(context);
        int i = getPrefs().getInt(this.clientMinVersionKey, 0);
        this.clientMinVersion = i;
        setClientMinVersion(i);
        Observable<R> observableM11082A = Observable.m11061E(0L, 1L, TimeUnit.HOURS).m11082A(new InterfaceC12589b<Long, Observable<? extends Integer>>() { // from class: com.discord.stores.StoreClientVersion.init.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Integer> call(Long l) {
                return RestAPI.INSTANCE.getApi().getClientVersion();
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11082A, "Observable\n        .inte…ClientVersion()\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationBuffered(observableM11082A), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C58482(this));
    }
}
