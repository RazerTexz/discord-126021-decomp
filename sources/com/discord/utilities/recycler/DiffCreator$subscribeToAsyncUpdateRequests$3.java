package com.discord.utilities.recycler;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import d0.z.d.o;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [VH, T] */
/* JADX INFO: compiled from: DiffCreator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiffCreator$subscribeToAsyncUpdateRequests$3<T, VH> extends o implements Function1<Pair<? extends DiffCreator$UpdateRequest<T, VH>, ? extends DiffUtil$DiffResult>, Unit> {
    public final /* synthetic */ DiffCreator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiffCreator$subscribeToAsyncUpdateRequests$3(DiffCreator diffCreator) {
        super(1);
        this.this$0 = diffCreator;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke((Pair) obj);
        return Unit.a;
    }

    public final void invoke(Pair<DiffCreator$UpdateRequest<T, VH>, ? extends DiffUtil$DiffResult> pair) {
        DiffCreator$UpdateRequest<T, VH> diffCreator$UpdateRequestComponent1 = pair.component1();
        DiffCreator.access$setItemsAndDispatchUpdate(this.this$0, diffCreator$UpdateRequestComponent1.getAdapter(), diffCreator$UpdateRequestComponent1.getSetItems(), (List) diffCreator$UpdateRequestComponent1.getNewItems(), pair.component2());
    }
}
