package b.i.c.o.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.a.f.e.h.a;
import b.i.c.FirebaseApp2;
import com.google.android.gms.tasks.Task;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends b.i.c.o.a {
    public final b.i.a.f.e.h.b<a.d.c> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final b.i.c.j.a.a f1758b;

    public e(FirebaseApp2 firebaseApp2, @Nullable b.i.c.j.a.a aVar) {
        firebaseApp2.a();
        this.a = new c(firebaseApp2.d);
        this.f1758b = aVar;
        if (aVar == null) {
            Log.w("FDL", "FDL logging failed. Add a dependency for Firebase Analytics to your app to enable logging of Dynamic Link events.");
        }
    }

    @Override // b.i.c.o.a
    public final Task<PendingDynamicLinkData> a(@NonNull Intent intent) {
        DynamicLinkData dynamicLinkDataCreateFromParcel;
        Task taskC = this.a.c(new i(this.f1758b, intent.getDataString()));
        Parcelable.Creator<DynamicLinkData> creator = DynamicLinkData.CREATOR;
        byte[] byteArrayExtra = intent.getByteArrayExtra("com.google.firebase.dynamiclinks.DYNAMIC_LINK_DATA");
        if (byteArrayExtra == null) {
            dynamicLinkDataCreateFromParcel = null;
        } else {
            Objects.requireNonNull(creator, "null reference");
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
            parcelObtain.setDataPosition(0);
            dynamicLinkDataCreateFromParcel = creator.createFromParcel(parcelObtain);
            parcelObtain.recycle();
        }
        DynamicLinkData dynamicLinkData = dynamicLinkDataCreateFromParcel;
        PendingDynamicLinkData pendingDynamicLinkData = dynamicLinkData != null ? new PendingDynamicLinkData(dynamicLinkData) : null;
        return pendingDynamicLinkData != null ? b.i.a.f.e.o.f.Z(pendingDynamicLinkData) : taskC;
    }
}
