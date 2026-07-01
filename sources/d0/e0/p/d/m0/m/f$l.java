package d0.e0.p.d.m0.m;

import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;

/* JADX INFO: compiled from: LockBasedStorageManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$l<K, V> implements i<K, V> {
    public final f j;
    public final ConcurrentMap<K, Object> k;
    public final Function1<? super K, ? extends V> l;

    public f$l(f fVar, ConcurrentMap<K, Object> concurrentMap, Function1<? super K, ? extends V> function1) {
        if (fVar == null) {
            a(0);
            throw null;
        }
        if (concurrentMap == null) {
            a(1);
            throw null;
        }
        if (function1 == null) {
            a(2);
            throw null;
        }
        this.j = fVar;
        this.k = concurrentMap;
        this.l = function1;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "map";
        } else if (i == 2) {
            objArr[0] = "compute";
        } else if (i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 3) {
            objArr[1] = "recursionDetected";
        } else if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
        } else {
            objArr[1] = "raceCondition";
        }
        if (i != 3 && i != 4) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public final AssertionError b(K k, Object obj) {
        AssertionError assertionError = new AssertionError("Race condition detected on input " + k + ". Old value is " + obj + " under " + this.j);
        f.d(assertionError);
        return assertionError;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0041 A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:8:0x001a, B:11:0x0026, B:13:0x002e, B:15:0x0034, B:17:0x003b, B:18:0x003e, B:20:0x0041, B:22:0x0049, B:24:0x004f, B:25:0x0054, B:26:0x0057, B:28:0x005a, B:38:0x008b, B:41:0x0093, B:43:0x009f, B:44:0x00a3, B:45:0x00a4, B:46:0x00ae, B:47:0x00af, B:48:0x00b9, B:49:0x00ba, B:50:0x00c1, B:31:0x0066, B:35:0x0085, B:36:0x0089), top: B:54:0x001a, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0049 A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:8:0x001a, B:11:0x0026, B:13:0x002e, B:15:0x0034, B:17:0x003b, B:18:0x003e, B:20:0x0041, B:22:0x0049, B:24:0x004f, B:25:0x0054, B:26:0x0057, B:28:0x005a, B:38:0x008b, B:41:0x0093, B:43:0x009f, B:44:0x00a3, B:45:0x00a4, B:46:0x00ae, B:47:0x00af, B:48:0x00b9, B:49:0x00ba, B:50:0x00c1, B:31:0x0066, B:35:0x0085, B:36:0x0089), top: B:54:0x001a, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x004f A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:8:0x001a, B:11:0x0026, B:13:0x002e, B:15:0x0034, B:17:0x003b, B:18:0x003e, B:20:0x0041, B:22:0x0049, B:24:0x004f, B:25:0x0054, B:26:0x0057, B:28:0x005a, B:38:0x008b, B:41:0x0093, B:43:0x009f, B:44:0x00a3, B:45:0x00a4, B:46:0x00ae, B:47:0x00af, B:48:0x00b9, B:49:0x00ba, B:50:0x00c1, B:31:0x0066, B:35:0x0085, B:36:0x0089), top: B:54:0x001a, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0054 A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:8:0x001a, B:11:0x0026, B:13:0x002e, B:15:0x0034, B:17:0x003b, B:18:0x003e, B:20:0x0041, B:22:0x0049, B:24:0x004f, B:25:0x0054, B:26:0x0057, B:28:0x005a, B:38:0x008b, B:41:0x0093, B:43:0x009f, B:44:0x00a3, B:45:0x00a4, B:46:0x00ae, B:47:0x00af, B:48:0x00b9, B:49:0x00ba, B:50:0x00c1, B:31:0x0066, B:35:0x0085, B:36:0x0089), top: B:54:0x001a, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0058 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x005a A[Catch: all -> 0x00c2, TRY_LEAVE, TryCatch #0 {all -> 0x00c2, blocks: (B:8:0x001a, B:11:0x0026, B:13:0x002e, B:15:0x0034, B:17:0x003b, B:18:0x003e, B:20:0x0041, B:22:0x0049, B:24:0x004f, B:25:0x0054, B:26:0x0057, B:28:0x005a, B:38:0x008b, B:41:0x0093, B:43:0x009f, B:44:0x00a3, B:45:0x00a4, B:46:0x00ae, B:47:0x00af, B:48:0x00b9, B:49:0x00ba, B:50:0x00c1, B:31:0x0066, B:35:0x0085, B:36:0x0089), top: B:54:0x001a, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x007d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0085 A[Catch: all -> 0x008a, TRY_ENTER, TryCatch #1 {all -> 0x008a, blocks: (B:31:0x0066, B:35:0x0085, B:36:0x0089), top: B:55:0x0066, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // kotlin.jvm.functions.Function1
    public V invoke(K k) {
        V vInvoke;
        Object objPut;
        V value;
        f$o<V> f_oC;
        f$n f_n = f$n.RECURSION_WAS_DETECTED;
        f$n f_n2 = f$n.COMPUTING;
        Object obj = this.k.get(k);
        if (obj != null && obj != f_n2) {
            return (V) WrappedValues.unescapeExceptionOrNull(obj);
        }
        this.j.c.lock();
        try {
            Object obj2 = this.k.get(k);
            AssertionError assertionErrorB = null;
            if (obj2 == f_n2) {
                f$o<V> f_oC2 = this.j.c("", k);
                if (f_oC2 == null) {
                    a(3);
                    throw null;
                }
                if (f_oC2.isFallThrough()) {
                    obj2 = f_n;
                    if (obj2 != f_n) {
                        f_oC = this.j.c("", k);
                        if (f_oC != null) {
                            a(3);
                            throw null;
                        }
                        if (!f_oC.isFallThrough()) {
                            value = f_oC.getValue();
                        } else {
                            if (obj2 != null) {
                                this.k.put(k, f_n2);
                                vInvoke = this.l.invoke(k);
                                objPut = this.k.put(k, WrappedValues.escapeNull(vInvoke));
                                if (objPut == f_n2) {
                                    this.j.c.unlock();
                                    return vInvoke;
                                }
                                assertionErrorB = b(k, objPut);
                                throw assertionErrorB;
                            }
                            value = (V) WrappedValues.unescapeExceptionOrNull(obj2);
                        }
                    } else {
                        if (obj2 != null) {
                            this.k.put(k, f_n2);
                            vInvoke = this.l.invoke(k);
                            objPut = this.k.put(k, WrappedValues.escapeNull(vInvoke));
                            if (objPut == f_n2) {
                                this.j.c.unlock();
                                return vInvoke;
                            }
                            assertionErrorB = b(k, objPut);
                            throw assertionErrorB;
                        }
                        value = (V) WrappedValues.unescapeExceptionOrNull(obj2);
                    }
                } else {
                    value = f_oC2.getValue();
                }
            } else if (obj2 != f_n) {
                f_oC = this.j.c("", k);
                if (f_oC != null) {
                    a(3);
                    throw null;
                }
                if (!f_oC.isFallThrough()) {
                    value = f_oC.getValue();
                } else {
                    if (obj2 != null) {
                        this.k.put(k, f_n2);
                        vInvoke = this.l.invoke(k);
                        objPut = this.k.put(k, WrappedValues.escapeNull(vInvoke));
                        if (objPut == f_n2) {
                            this.j.c.unlock();
                            return vInvoke;
                        }
                        assertionErrorB = b(k, objPut);
                        throw assertionErrorB;
                    }
                    value = (V) WrappedValues.unescapeExceptionOrNull(obj2);
                }
            } else {
                if (obj2 != null) {
                    try {
                        this.k.put(k, f_n2);
                        vInvoke = this.l.invoke(k);
                        objPut = this.k.put(k, WrappedValues.escapeNull(vInvoke));
                        if (objPut == f_n2) {
                            this.j.c.unlock();
                            return vInvoke;
                        }
                        assertionErrorB = b(k, objPut);
                        throw assertionErrorB;
                    } catch (Throwable th) {
                        if (d0.e0.p.d.m0.p.c.isProcessCanceledException(th)) {
                            this.k.remove(k);
                            throw th;
                        }
                        if (th == assertionErrorB) {
                            throw ((f$f$a) this.j.d).handleException(th);
                        }
                        Object objPut2 = this.k.put(k, WrappedValues.escapeThrowable(th));
                        if (objPut2 != f_n2) {
                            throw b(k, objPut2);
                        }
                        throw ((f$f$a) this.j.d).handleException(th);
                    }
                }
                value = (V) WrappedValues.unescapeExceptionOrNull(obj2);
            }
            this.j.c.unlock();
            return value;
        } catch (Throwable th2) {
            this.j.c.unlock();
            throw th2;
        }
    }
}
