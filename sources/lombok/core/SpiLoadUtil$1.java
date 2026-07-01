package lombok.core;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [C] */
/* JADX INFO: loaded from: app.apk:lombok/core/SpiLoadUtil$1.SCL.lombok */
class SpiLoadUtil$1<C> implements Iterable<C> {
    private final /* synthetic */ Iterator val$names;
    private final /* synthetic */ Class val$target;
    private final /* synthetic */ ClassLoader val$fLoader;

    SpiLoadUtil$1(Iterator it, Class cls, ClassLoader classLoader) {
        this.val$names = it;
        this.val$target = cls;
        this.val$fLoader = classLoader;
    }

    @Override // java.lang.Iterable
    public Iterator<C> iterator() {
        return new SpiLoadUtil$1$1(this, this.val$names, this.val$target, this.val$fLoader);
    }
}
