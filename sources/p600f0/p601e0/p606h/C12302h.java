package p600f0.p601e0.p606h;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import p507d0.p592z.p594d.C12238m;
import p615g0.InterfaceC12390g;

/* JADX INFO: renamed from: f0.e0.h.h */
/* JADX INFO: compiled from: RealResponseBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12302h extends ResponseBody {

    /* JADX INFO: renamed from: l */
    public final String f25540l;

    /* JADX INFO: renamed from: m */
    public final long f25541m;

    /* JADX INFO: renamed from: n */
    public final InterfaceC12390g f25542n;

    public C12302h(String str, long j, InterfaceC12390g interfaceC12390g) {
        C12238m.checkParameterIsNotNull(interfaceC12390g, "source");
        this.f25540l = str;
        this.f25541m = j;
        this.f25542n = interfaceC12390g;
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: a */
    public long mo10103a() {
        return this.f25541m;
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: b */
    public MediaType mo10104b() {
        String str = this.f25540l;
        if (str == null) {
            return null;
        }
        MediaType.Companion companion = MediaType.INSTANCE;
        return MediaType.Companion.m10968b(str);
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: c */
    public InterfaceC12390g mo10105c() {
        return this.f25542n;
    }
}
