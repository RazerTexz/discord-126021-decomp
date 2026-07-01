package b.b.a.d;

import android.content.ContentResolver;
import android.os.AsyncTask;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ThumbnailViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends o implements Function1<ContentResolver, Unit> {
    public final /* synthetic */ long $id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(long j) {
        super(1);
        this.$id = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ContentResolver contentResolver) {
        ContentResolver contentResolver2 = contentResolver;
        d0.z.d.m.checkNotNullParameter(contentResolver2, "contentResolver");
        AsyncTask.execute(new l(this, contentResolver2));
        return Unit.a;
    }
}
