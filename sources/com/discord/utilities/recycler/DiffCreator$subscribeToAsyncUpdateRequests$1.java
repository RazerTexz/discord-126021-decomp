package com.discord.utilities.recycler;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import j0.k.b;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: Add missing generic type declarations: [VH] */
/* JADX INFO: compiled from: DiffCreator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiffCreator$subscribeToAsyncUpdateRequests$1<T, R, VH> implements b<DiffCreator$UpdateRequest<T, VH>, Pair<? extends DiffCreator$UpdateRequest<T, VH>, ? extends DiffUtil$DiffResult>> {
    public final /* synthetic */ DiffCreator this$0;

    public DiffCreator$subscribeToAsyncUpdateRequests$1(DiffCreator diffCreator) {
        this.this$0 = diffCreator;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((DiffCreator$UpdateRequest) obj);
    }

    public final Pair<DiffCreator$UpdateRequest<T, VH>, DiffUtil$DiffResult> call(DiffCreator$UpdateRequest<T, VH> diffCreator$UpdateRequest) {
        return new Pair<>(diffCreator$UpdateRequest, this.this$0.calculateDiffResult((List) diffCreator$UpdateRequest.getOldItems(), (List) diffCreator$UpdateRequest.getNewItems()));
    }
}
