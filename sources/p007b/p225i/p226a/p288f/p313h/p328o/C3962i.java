package p007b.p225i.p226a.p288f.p313h.p328o;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.zzf;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h;

/* JADX INFO: renamed from: b.i.a.f.h.o.i */
/* JADX INFO: loaded from: classes3.dex */
public class C3962i implements SafetyNetApi {

    /* JADX INFO: renamed from: b.i.a.f.h.o.i$a */
    public static abstract class a extends AbstractC3957d<SafetyNetApi.InterfaceC10813a> {

        /* JADX INFO: renamed from: l */
        public InterfaceC3958e f10495l;

        public a(AbstractC3268c abstractC3268c) {
            super(abstractC3268c);
            this.f10495l = new BinderC3964k(this);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        /* JADX INFO: renamed from: d */
        public /* synthetic */ InterfaceC3273h mo3987d(Status status) {
            return new b(status, null);
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.h.o.i$b */
    public static class b implements SafetyNetApi.InterfaceC10813a {

        /* JADX INFO: renamed from: j */
        public final Status f10496j;

        /* JADX INFO: renamed from: k */
        public final zzf f10497k;

        public b(Status status, zzf zzfVar) {
            this.f10496j = status;
            this.f10497k = zzfVar;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.InterfaceC10813a
        /* JADX INFO: renamed from: C */
        public final String mo5438C() {
            zzf zzfVar = this.f10497k;
            if (zzfVar == null) {
                return null;
            }
            return zzfVar.f20831j;
        }

        @Override // p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h
        /* JADX INFO: renamed from: b0 */
        public final Status mo4053b0() {
            return this.f10496j;
        }
    }
}
