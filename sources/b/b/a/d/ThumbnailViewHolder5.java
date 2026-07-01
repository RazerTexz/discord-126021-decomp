package b.b.a.d;

import android.content.ContentResolver;
import android.os.AsyncTask;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.b.a.d.m, reason: use source file name */
/* JADX INFO: compiled from: ThumbnailViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ThumbnailViewHolder5 extends Lambda implements Function1<ContentResolver, Unit> {
    public final /* synthetic */ long $id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThumbnailViewHolder5(long j) {
        super(1);
        this.$id = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ContentResolver contentResolver) {
        ContentResolver contentResolver2 = contentResolver;
        Intrinsics3.checkNotNullParameter(contentResolver2, "contentResolver");
        AsyncTask.execute(new ThumbnailViewHolder4(this, contentResolver2));
        return Unit.a;
    }
}
