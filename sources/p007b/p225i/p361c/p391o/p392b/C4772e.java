package p007b.p225i.p361c.p391o.p392b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.C3267b;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p362j.p363a.InterfaceC4549a;
import p007b.p225i.p361c.p391o.AbstractC4767a;

/* JADX INFO: renamed from: b.i.c.o.b.e */
/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4772e extends AbstractC4767a {

    /* JADX INFO: renamed from: a */
    public final C3267b<C3266a.d.c> f12808a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final InterfaceC4549a f12809b;

    public C4772e(C4542c c4542c, @Nullable InterfaceC4549a interfaceC4549a) {
        c4542c.m6330a();
        this.f12808a = new C4770c(c4542c.f12118d);
        this.f12809b = interfaceC4549a;
        if (interfaceC4549a == null) {
            Log.w("FDL", "FDL logging failed. Add a dependency for Firebase Analytics to your app to enable logging of Dynamic Link events.");
        }
    }

    @Override // p007b.p225i.p361c.p391o.AbstractC4767a
    /* JADX INFO: renamed from: a */
    public final Task<PendingDynamicLinkData> mo6703a(@NonNull Intent intent) {
        DynamicLinkData dynamicLinkDataCreateFromParcel;
        Task taskM4046c = this.f12808a.m4046c(new C4776i(this.f12809b, intent.getDataString()));
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
        return pendingDynamicLinkData != null ? C3404f.m4264Z(pendingDynamicLinkData) : taskM4046c;
    }
}
