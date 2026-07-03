package p007b.p076b.p077a.p079d;

import android.content.ContentResolver;
import android.os.AsyncTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.b.a.d.m */
/* JADX INFO: compiled from: ThumbnailViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C1443m extends AbstractC12240o implements Function1<ContentResolver, Unit> {
    public final /* synthetic */ long $id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1443m(long j) {
        super(1);
        this.$id = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ContentResolver contentResolver) {
        ContentResolver contentResolver2 = contentResolver;
        C12238m.checkNotNullParameter(contentResolver2, "contentResolver");
        AsyncTask.execute(new RunnableC1442l(this, contentResolver2));
        return Unit.f27425a;
    }
}
