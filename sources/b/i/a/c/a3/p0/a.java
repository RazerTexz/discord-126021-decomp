package b.i.a.c.a3.p0;

import android.net.Uri;
import android.os.Bundle;
import b.i.a.c.Bundleable;
import b.i.a.c.a3.p0.AdPlaybackState;
import java.util.ArrayList;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Bundleable.a {
    public static final /* synthetic */ a a = new a();

    @Override // b.i.a.c.Bundleable.a
    public final Bundleable a(Bundle bundle) {
        long j = bundle.getLong(AdPlaybackState.a.c(0));
        int i = bundle.getInt(AdPlaybackState.a.c(1), -1);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(AdPlaybackState.a.c(2));
        int[] intArray = bundle.getIntArray(AdPlaybackState.a.c(3));
        long[] longArray = bundle.getLongArray(AdPlaybackState.a.c(4));
        long j2 = bundle.getLong(AdPlaybackState.a.c(5));
        boolean z2 = bundle.getBoolean(AdPlaybackState.a.c(6));
        if (intArray == null) {
            intArray = new int[0];
        }
        return new AdPlaybackState.a(j, i, intArray, parcelableArrayList == null ? new Uri[0] : (Uri[]) parcelableArrayList.toArray(new Uri[0]), longArray == null ? new long[0] : longArray, j2, z2);
    }
}
