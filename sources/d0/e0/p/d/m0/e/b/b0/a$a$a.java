package d0.e0.p.d.m0.e.b.b0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: KotlinClassHeader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a$a {
    public a$a$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final a$a getById(int i) {
        a$a a_a = (a$a) a$a.access$getEntryById$cp().get(Integer.valueOf(i));
        return a_a == null ? a$a.UNKNOWN : a_a;
    }
}
