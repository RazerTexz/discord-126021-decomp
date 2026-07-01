package com.discord.stores;

import com.discord.utilities.search.query.node.QueryNode;
import d0.z.d.k;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreSearchInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreSearchInput$init$3 extends k implements Function1<List<? extends QueryNode>, Unit> {
    public StoreSearchInput$init$3(SerializedSubject serializedSubject) {
        super(1, serializedSubject, SerializedSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends QueryNode> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends QueryNode> list) {
        ((SerializedSubject) this.receiver).k.onNext((T) list);
    }
}
