package b.i.a.c.a3.p0;

import android.net.Uri;
import android.os.Bundle;
import b.i.a.c.w0;
import b.i.a.c.w0$a;
import java.util.ArrayList;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements w0$a {
    public static final /* synthetic */ a a = new a();

    @Override // b.i.a.c.w0$a
    public final w0 a(Bundle bundle) {
        long j = bundle.getLong(c$a.c(0));
        int i = bundle.getInt(c$a.c(1), -1);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(c$a.c(2));
        int[] intArray = bundle.getIntArray(c$a.c(3));
        long[] longArray = bundle.getLongArray(c$a.c(4));
        long j2 = bundle.getLong(c$a.c(5));
        boolean z2 = bundle.getBoolean(c$a.c(6));
        if (intArray == null) {
            intArray = new int[0];
        }
        return new c$a(j, i, intArray, parcelableArrayList == null ? new Uri[0] : (Uri[]) parcelableArrayList.toArray(new Uri[0]), longArray == null ? new long[0] : longArray, j2, z2);
    }
}
