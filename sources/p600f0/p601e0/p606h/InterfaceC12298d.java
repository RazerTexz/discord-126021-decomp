package p600f0.p601e0.p606h;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import p600f0.p601e0.p605g.C12290j;
import p615g0.InterfaceC12405v;
import p615g0.InterfaceC12407x;

/* JADX INFO: renamed from: f0.e0.h.d */
/* JADX INFO: compiled from: ExchangeCodec.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC12298d {
    /* JADX INFO: renamed from: a */
    void mo10213a() throws IOException;

    /* JADX INFO: renamed from: b */
    void mo10214b(Request request) throws IOException;

    /* JADX INFO: renamed from: c */
    InterfaceC12407x mo10215c(Response response) throws IOException;

    void cancel();

    /* JADX INFO: renamed from: d */
    Response.C12937a mo10216d(boolean z2) throws IOException;

    /* JADX INFO: renamed from: e */
    C12290j mo10217e();

    /* JADX INFO: renamed from: f */
    void mo10218f() throws IOException;

    /* JADX INFO: renamed from: g */
    long mo10219g(Response response) throws IOException;

    /* JADX INFO: renamed from: h */
    InterfaceC12405v mo10220h(Request request, long j) throws IOException;
}
