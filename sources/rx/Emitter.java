package rx;

import j0.Observer2;

/* JADX INFO: loaded from: classes3.dex */
public interface Emitter<T> extends Observer2<T> {

    public enum BackpressureMode {
        NONE,
        ERROR,
        BUFFER,
        DROP,
        LATEST
    }
}
