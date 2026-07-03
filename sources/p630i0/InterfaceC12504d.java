package p630i0;

import java.io.IOException;
import okhttp3.Request;
import retrofit2.Response;

/* JADX INFO: renamed from: i0.d */
/* JADX INFO: compiled from: Call.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC12504d<T> extends Cloneable {
    /* JADX INFO: renamed from: C */
    void mo10697C(InterfaceC12527f<T> interfaceC12527f);

    /* JADX INFO: renamed from: L */
    InterfaceC12504d<T> mo10698L();

    /* JADX INFO: renamed from: c */
    Request mo10699c();

    void cancel();

    /* JADX INFO: renamed from: d */
    boolean mo10700d();

    Response<T> execute() throws IOException;
}
