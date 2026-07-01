package b.j.a.f;

import com.hcaptcha.sdk.HCaptchaException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d<TResult> {
    public TResult a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HCaptchaException f1897b;
    public final List<c<TResult>> c = new ArrayList();
    public final List<a> d = new ArrayList();

    public final void a() {
        if (this.a != null) {
            Iterator<c<TResult>> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().onSuccess(this.a);
                it.remove();
            }
        }
        if (this.f1897b != null) {
            Iterator<a> it2 = this.d.iterator();
            while (it2.hasNext()) {
                it2.next().onFailure(this.f1897b);
                it2.remove();
            }
        }
    }
}
