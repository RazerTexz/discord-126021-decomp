package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences$Editor;
import com.discord.BuildConfig;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreClientVersion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreClientVersion extends Store {
    private int clientMinVersion;
    private final int clientVersion = BuildConfig.VERSION_CODE;
    private final String clientMinVersionKey = "CLIENT_OUTDATED_KEY";
    private final SerializedSubject<Boolean, Boolean> clientOutdatedSubject = new SerializedSubject<>(BehaviorSubject.l0(Boolean.FALSE));

    public static final /* synthetic */ void access$setClientMinVersion(StoreClientVersion storeClientVersion, int i) {
        storeClientVersion.setClientMinVersion(i);
    }

    private final synchronized void setClientMinVersion(int clientMinVersion) {
        if (this.clientMinVersion != clientMinVersion) {
            this.clientMinVersion = clientMinVersion;
            this.clientOutdatedSubject.k.onNext(Boolean.valueOf(this.clientVersion < clientMinVersion));
            SharedPreferences$Editor sharedPreferences$EditorEdit = getPrefs().edit();
            m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
            sharedPreferences$EditorEdit.putInt(this.clientMinVersionKey, clientMinVersion);
            sharedPreferences$EditorEdit.apply();
        }
    }

    public final Observable<Boolean> getClientOutdated() {
        Observable<Boolean> observableR = ObservableExtensionsKt.computationLatest(this.clientOutdatedSubject).r();
        m.checkNotNullExpressionValue(observableR, "clientOutdatedSubject\n  …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.Store
    public synchronized void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        int i = getPrefs().getInt(this.clientMinVersionKey, 0);
        this.clientMinVersion = i;
        setClientMinVersion(i);
        Observable<R> observableA = Observable.E(0L, 1L, TimeUnit.HOURS).A(StoreClientVersion$init$1.INSTANCE);
        m.checkNotNullExpressionValue(observableA, "Observable\n        .inte…ClientVersion()\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableA), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreClientVersion$init$2(this), 62, (Object) null);
    }
}
