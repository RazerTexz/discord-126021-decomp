package i0;

import retrofit2.Response;

/* JADX INFO: renamed from: i0.f, reason: use source file name */
/* JADX INFO: compiled from: Callback.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Callback3<T> {
    void a(Call3<T> call3, Throwable th);

    void b(Call3<T> call3, Response<T> response);
}
