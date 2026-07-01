package d0.e0;

import kotlin.reflect.KType;

/* JADX INFO: compiled from: KParameter.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface f extends b {
    f$a getKind();

    String getName();

    KType getType();

    boolean isOptional();

    boolean isVararg();
}
