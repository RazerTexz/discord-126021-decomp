package d0.e0;

import kotlin.reflect.KType;

/* JADX INFO: renamed from: d0.e0.f, reason: use source file name */
/* JADX INFO: compiled from: KParameter.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface KParameter extends KAnnotatedElement {

    /* JADX INFO: renamed from: d0.e0.f$a */
    /* JADX INFO: compiled from: KParameter.kt */
    public enum a {
        INSTANCE,
        EXTENSION_RECEIVER,
        VALUE
    }

    a getKind();

    String getName();

    KType getType();

    boolean isOptional();

    boolean isVararg();
}
