package lombok.core;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [C] */
/* JADX INFO: loaded from: app.apk:lombok/core/SpiLoadUtil$1$1.SCL.lombok */
class SpiLoadUtil$1$1<C> implements Iterator<C> {
    final /* synthetic */ SpiLoadUtil$1 this$1;
    private final /* synthetic */ Iterator val$names;
    private final /* synthetic */ Class val$target;
    private final /* synthetic */ ClassLoader val$fLoader;

    SpiLoadUtil$1$1(SpiLoadUtil$1 spiLoadUtil$1, Iterator it, Class cls, ClassLoader classLoader) {
        this.this$1 = spiLoadUtil$1;
        this.val$names = it;
        this.val$target = cls;
        this.val$fLoader = classLoader;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.val$names.hasNext();
    }

    @Override // java.util.Iterator
    public C next() {
        try {
            return (C) this.val$target.cast(Class.forName((String) this.val$names.next(), true, this.val$fLoader).getConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Exception e) {
            Throwable cause = e;
            if (cause instanceof InvocationTargetException) {
                cause = cause.getCause();
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
