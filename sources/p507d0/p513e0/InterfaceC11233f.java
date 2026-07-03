package p507d0.p513e0;

import kotlin.reflect.KType;

/* JADX INFO: renamed from: d0.e0.f */
/* JADX INFO: compiled from: KParameter.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11233f extends InterfaceC11229b {

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
