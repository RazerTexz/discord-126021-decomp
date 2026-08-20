package p007b.p225i.p226a.p242c.p243a3.p244p0;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import p007b.p225i.p226a.p242c.InterfaceC2963w0;

/* JADX INFO: renamed from: b.i.a.c.a3.p0.a */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2560a implements InterfaceC2963w0.a {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ C2560a f5678a = new C2560a();

    @Override // p007b.p225i.p226a.p242c.InterfaceC2963w0.a
    /* JADX INFO: renamed from: a */
    public final InterfaceC2963w0 mo2576a(Bundle bundle) {
        long j = bundle.getLong(C2562c.a.m2579c(0));
        int i = bundle.getInt(C2562c.a.m2579c(1), -1);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(C2562c.a.m2579c(2));
        int[] intArray = bundle.getIntArray(C2562c.a.m2579c(3));
        long[] longArray = bundle.getLongArray(C2562c.a.m2579c(4));
        long j2 = bundle.getLong(C2562c.a.m2579c(5));
        boolean z2 = bundle.getBoolean(C2562c.a.m2579c(6));
        if (intArray == null) {
            intArray = new int[0];
        }
        return new C2562c.a(j, i, intArray, parcelableArrayList == null ? new Uri[0] : (Uri[]) parcelableArrayList.toArray(new Uri[0]), longArray == null ? new long[0] : longArray, j2, z2);
    }
}
