package p007b.p452o.p453a.p455n.p456o;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p007b.p452o.p453a.p455n.C5130d;

/* JADX INFO: renamed from: b.o.a.n.o.e */
/* JADX INFO: compiled from: BaseAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class AbstractC5145e implements InterfaceC5141a {

    /* JADX INFO: renamed from: a */
    public final List<InterfaceC5142b> f13937a = new ArrayList();

    /* JADX INFO: renamed from: b */
    public int f13938b;

    /* JADX INFO: renamed from: c */
    public InterfaceC5143c f13939c;

    /* JADX INFO: renamed from: d */
    public boolean f13940d;

    @Override // p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: a */
    public final void mo7330a(@NonNull InterfaceC5143c interfaceC5143c) {
        ((C5130d) interfaceC5143c).f13814p0.remove(this);
        if (!m7338g()) {
            mo7335h(interfaceC5143c);
            m7341l(Integer.MAX_VALUE);
        }
        this.f13940d = false;
    }

    @Override // p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: b */
    public void mo7248b(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
    }

    @Override // p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    @CallSuper
    /* JADX INFO: renamed from: c */
    public void mo7331c(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest) {
        if (this.f13940d) {
            mo7249j(interfaceC5143c);
            this.f13940d = false;
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: d */
    public void mo7332d(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
    }

    @Override // p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
    /* JADX INFO: renamed from: e */
    public final void mo7333e(@NonNull InterfaceC5143c interfaceC5143c) {
        this.f13939c = interfaceC5143c;
        C5130d c5130d = (C5130d) interfaceC5143c;
        if (!c5130d.f13814p0.contains(this)) {
            c5130d.f13814p0.add(this);
        }
        if (((C5130d) interfaceC5143c).f13808j0 != null) {
            mo7249j(interfaceC5143c);
        } else {
            this.f13940d = true;
        }
    }

    /* JADX INFO: renamed from: f */
    public void m7337f(@NonNull InterfaceC5142b interfaceC5142b) {
        if (this.f13937a.contains(interfaceC5142b)) {
            return;
        }
        this.f13937a.add(interfaceC5142b);
        interfaceC5142b.mo7334a(this, this.f13938b);
    }

    /* JADX INFO: renamed from: g */
    public boolean m7338g() {
        return this.f13938b == Integer.MAX_VALUE;
    }

    /* JADX INFO: renamed from: h */
    public void mo7335h(@NonNull InterfaceC5143c interfaceC5143c) {
    }

    /* JADX INFO: renamed from: i */
    public void mo7339i(@NonNull InterfaceC5143c interfaceC5143c) {
    }

    @CallSuper
    /* JADX INFO: renamed from: j */
    public void mo7249j(@NonNull InterfaceC5143c interfaceC5143c) {
        this.f13939c = interfaceC5143c;
    }

    @NonNull
    /* JADX INFO: renamed from: k */
    public <T> T m7340k(@NonNull CameraCharacteristics.Key<T> key, @NonNull T t) {
        T t2 = (T) ((C5130d) this.f13939c).f13805g0.get(key);
        return t2 == null ? t : t2;
    }

    /* JADX INFO: renamed from: l */
    public final void m7341l(int i) {
        if (i != this.f13938b) {
            this.f13938b = i;
            Iterator<InterfaceC5142b> it = this.f13937a.iterator();
            while (it.hasNext()) {
                it.next().mo7334a(this, this.f13938b);
            }
            if (this.f13938b == Integer.MAX_VALUE) {
                ((C5130d) this.f13939c).f13814p0.remove(this);
                mo7339i(this.f13939c);
            }
        }
    }
}
