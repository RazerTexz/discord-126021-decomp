package d0.e0.p.d.m0.m;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;

/* JADX INFO: compiled from: LockBasedStorageManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$h<T> implements k<T> {
    public final f j;
    public final Function0<? extends T> k;
    public volatile Object l;

    public f$h(f fVar, Function0<? extends T> function0) {
        if (fVar == null) {
            a(0);
            throw null;
        }
        if (function0 == null) {
            a(1);
            throw null;
        }
        this.l = f$n.NOT_COMPUTED;
        this.j = fVar;
        this.k = function0;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 2 || i == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "computable";
        } else if (i == 2 || i == 3) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 2) {
            objArr[1] = "recursionDetected";
        } else if (i != 3) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
        } else {
            objArr[1] = "renderDebugInformation";
        }
        if (i != 2 && i != 3) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public void b(T t) {
    }

    public f$o<T> c(boolean z2) {
        f$o<T> f_oC = this.j.c("in a lazy value", null);
        if (f_oC != null) {
            return f_oC;
        }
        a(2);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x003e A[Catch: all -> 0x007f, TryCatch #1 {all -> 0x007f, blocks: (B:7:0x0016, B:9:0x001c, B:13:0x002a, B:15:0x0037, B:17:0x003e, B:19:0x0049, B:20:0x004e, B:24:0x005d, B:26:0x0063, B:28:0x0067, B:29:0x006d, B:30:0x0077, B:31:0x0078, B:32:0x007e, B:21:0x0050), top: B:38:0x0016, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0049 A[Catch: all -> 0x007f, TryCatch #1 {all -> 0x007f, blocks: (B:7:0x0016, B:9:0x001c, B:13:0x002a, B:15:0x0037, B:17:0x003e, B:19:0x0049, B:20:0x004e, B:24:0x005d, B:26:0x0063, B:28:0x0067, B:29:0x006d, B:30:0x0077, B:31:0x0078, B:32:0x007e, B:21:0x0050), top: B:38:0x0016, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x004e A[Catch: all -> 0x007f, TRY_LEAVE, TryCatch #1 {all -> 0x007f, blocks: (B:7:0x0016, B:9:0x001c, B:13:0x002a, B:15:0x0037, B:17:0x003e, B:19:0x0049, B:20:0x004e, B:24:0x005d, B:26:0x0063, B:28:0x0067, B:29:0x006d, B:30:0x0077, B:31:0x0078, B:32:0x007e, B:21:0x0050), top: B:38:0x0016, inners: #0 }] */
    @Override // kotlin.jvm.functions.Function0
    public T invoke() {
        T tInvoke;
        f$o<T> f_oC;
        f$n f_n = f$n.RECURSION_WAS_DETECTED;
        f$n f_n2 = f$n.COMPUTING;
        Object obj = this.l;
        if (!(obj instanceof f$n)) {
            return (T) WrappedValues.unescapeThrowable(obj);
        }
        this.j.c.lock();
        try {
            Object obj2 = this.l;
            if (!(obj2 instanceof f$n)) {
                tInvoke = (T) WrappedValues.unescapeThrowable(obj2);
            } else if (obj2 == f_n2) {
                this.l = f_n;
                f$o<T> f_oC2 = c(true);
                if (!f_oC2.isFallThrough()) {
                    tInvoke = f_oC2.getValue();
                } else if (obj2 == f_n) {
                    f_oC = c(false);
                    if (f_oC.isFallThrough()) {
                        this.l = f_n2;
                        try {
                            tInvoke = this.k.invoke();
                            b(tInvoke);
                            this.l = tInvoke;
                        } catch (Throwable th) {
                            if (d0.e0.p.d.m0.p.c.isProcessCanceledException(th)) {
                                this.l = f$n.NOT_COMPUTED;
                                throw th;
                            }
                            if (this.l == f_n2) {
                                this.l = WrappedValues.escapeThrowable(th);
                            }
                            throw ((f$f$a) this.j.d).handleException(th);
                        }
                    } else {
                        tInvoke = f_oC.getValue();
                    }
                } else {
                    this.l = f_n2;
                    tInvoke = this.k.invoke();
                    b(tInvoke);
                    this.l = tInvoke;
                }
            } else if (obj2 == f_n) {
                f_oC = c(false);
                if (f_oC.isFallThrough()) {
                    tInvoke = f_oC.getValue();
                } else {
                    this.l = f_n2;
                    tInvoke = this.k.invoke();
                    b(tInvoke);
                    this.l = tInvoke;
                }
            } else {
                this.l = f_n2;
                tInvoke = this.k.invoke();
                b(tInvoke);
                this.l = tInvoke;
            }
            this.j.c.unlock();
            return tInvoke;
        } catch (Throwable th2) {
            this.j.c.unlock();
            throw th2;
        }
    }

    public boolean isComputed() {
        return (this.l == f$n.NOT_COMPUTED || this.l == f$n.COMPUTING) ? false : true;
    }
}
