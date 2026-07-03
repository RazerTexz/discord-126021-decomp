package p007b.p437j.p438a.p439f;

import com.hcaptcha.sdk.HCaptchaException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: b.j.a.f.d */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC5073d<TResult> {

    /* JADX INFO: renamed from: a */
    public TResult f13594a;

    /* JADX INFO: renamed from: b */
    public HCaptchaException f13595b;

    /* JADX INFO: renamed from: c */
    public final List<InterfaceC5072c<TResult>> f13596c = new ArrayList();

    /* JADX INFO: renamed from: d */
    public final List<InterfaceC5070a> f13597d = new ArrayList();

    /* JADX INFO: renamed from: a */
    public final void m7120a() {
        if (this.f13594a != null) {
            Iterator<InterfaceC5072c<TResult>> it = this.f13596c.iterator();
            while (it.hasNext()) {
                it.next().onSuccess(this.f13594a);
                it.remove();
            }
        }
        if (this.f13595b != null) {
            Iterator<InterfaceC5070a> it2 = this.f13597d.iterator();
            while (it2.hasNext()) {
                it2.next().onFailure(this.f13595b);
                it2.remove();
            }
        }
    }
}
