package com.discord.utilities.persister;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister$getObservable$1$1 extends o implements Function1 {
    public final /* synthetic */ SerializedSubject $subject;
    public final /* synthetic */ Persister$getObservable$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Persister$getObservable$1$1(Persister$getObservable$1 persister$getObservable$1, SerializedSubject serializedSubject) {
        super(1);
        this.this$0 = persister$getObservable$1;
        this.$subject = serializedSubject;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Void) obj);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void invoke(Void r2) {
        this.$subject.k.onNext((T) this.this$0.this$0.get());
    }
}
