package p000;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import kotlinx.coroutines.android.AndroidDispatcherFactory;
import kotlinx.coroutines.android.AndroidExceptionPreHandler;

/* JADX INFO: renamed from: a */
/* JADX INFO: compiled from: ServiceLoader */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0000a {
    /* JADX INFO: renamed from: a */
    public static Iterator m0a() {
        try {
            return Arrays.asList(new AndroidExceptionPreHandler()).iterator();
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }

    /* JADX INFO: renamed from: b */
    public static Iterator m1b() {
        try {
            return Arrays.asList(new AndroidDispatcherFactory()).iterator();
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
