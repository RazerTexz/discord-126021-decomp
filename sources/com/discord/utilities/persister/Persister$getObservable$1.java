package com.discord.utilities.persister;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import j0.l.e.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister$getObservable$1<T> extends o implements Function0<Subject<T, T>> {
    public final /* synthetic */ Persister this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Persister$getObservable$1(Persister persister) {
        super(0);
        this.this$0 = persister;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        return invoke();
    }

    @Override // kotlin.jvm.functions.Function0
    public final Subject<T, T> invoke() {
        SerializedSubject serializedSubject = new SerializedSubject(BehaviorSubject.k0());
        k kVar = new k(null);
        m.checkNotNullExpressionValue(kVar, "Observable\n          .just(null)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(kVar), this.this$0.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new Persister$getObservable$1$1(this, serializedSubject), 62, (Object) null);
        return serializedSubject;
    }
}
