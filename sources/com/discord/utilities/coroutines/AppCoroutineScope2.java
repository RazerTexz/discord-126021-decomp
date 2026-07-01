package com.discord.utilities.coroutines;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.utilities.coroutines.AppErrorTag, reason: use source file name */
/* JADX INFO: compiled from: AppCoroutineScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AppCoroutineScope2 implements CoroutineContext.Element {
    private final String errorTag;
    private final CoroutineContext.Key<AppCoroutineScope2> key;

    /* JADX INFO: renamed from: com.discord.utilities.coroutines.AppErrorTag$Key */
    /* JADX INFO: compiled from: AppCoroutineScope.kt */
    public static final class Key implements CoroutineContext.Key<AppCoroutineScope2> {
        public static final Key INSTANCE = new Key();

        private Key() {
        }
    }

    public AppCoroutineScope2(String str) {
        Intrinsics3.checkNotNullParameter(str, "errorTag");
        this.errorTag = str;
        this.key = Key.INSTANCE;
    }

    public static /* synthetic */ AppCoroutineScope2 copy$default(AppCoroutineScope2 appCoroutineScope2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appCoroutineScope2.errorTag;
        }
        return appCoroutineScope2.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getErrorTag() {
        return this.errorTag;
    }

    public final AppCoroutineScope2 copy(String errorTag) {
        Intrinsics3.checkNotNullParameter(errorTag, "errorTag");
        return new AppCoroutineScope2(errorTag);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof AppCoroutineScope2) && Intrinsics3.areEqual(this.errorTag, ((AppCoroutineScope2) other).errorTag);
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics3.checkNotNullParameter(function2, "operation");
        return (R) CoroutineContext.Element.a.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics3.checkNotNullParameter(key, "key");
        return (E) CoroutineContext.Element.a.get(this, key);
    }

    public final String getErrorTag() {
        return this.errorTag;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<AppCoroutineScope2> getKey() {
        return this.key;
    }

    public int hashCode() {
        String str = this.errorTag;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics3.checkNotNullParameter(key, "key");
        return CoroutineContext.Element.a.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        return CoroutineContext.Element.a.plus(this, coroutineContext);
    }

    public String toString() {
        return outline.J(outline.U("AppErrorTag(errorTag="), this.errorTag, ")");
    }
}
