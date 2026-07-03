package p007b.p225i.p361c.p391o.p392b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3349d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3347c;

/* JADX INFO: renamed from: b.i.c.o.b.d */
/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4771d extends AbstractC3349d<InterfaceC4777j> {
    public C4771d(Context context, Looper looper, C3347c c3347c, AbstractC3268c.a aVar, AbstractC3268c.b bVar) {
        super(context, looper, Opcodes.LXOR, c3347c, aVar, bVar);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b, p007b.p225i.p226a.p288f.p299e.p300h.C3266a.f
    /* JADX INFO: renamed from: l */
    public final int mo3982l() {
        return 12451000;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    @Nullable
    /* JADX INFO: renamed from: r */
    public final /* synthetic */ IInterface mo3983r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.dynamiclinks.internal.IDynamicLinksService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC4777j ? (InterfaceC4777j) iInterfaceQueryLocalInterface : new C4779l(iBinder);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    @NonNull
    /* JADX INFO: renamed from: x */
    public final String mo3984x() {
        return "com.google.firebase.dynamiclinks.internal.IDynamicLinksService";
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b
    @NonNull
    /* JADX INFO: renamed from: y */
    public final String mo3985y() {
        return "com.google.firebase.dynamiclinks.service.START";
    }
}
