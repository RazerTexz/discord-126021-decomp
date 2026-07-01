package i0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: renamed from: i0.e, reason: use source file name */
/* JADX INFO: compiled from: CallAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public interface CallAdapter<R, T> {

    /* JADX INFO: renamed from: i0.e$a */
    /* JADX INFO: compiled from: CallAdapter.java */
    public static abstract class a {
        public abstract CallAdapter<?, ?> a(Type type, Annotation[] annotationArr, Retrofit2 retrofit3);
    }

    Type a();

    T b(Call3<R> call3);
}
