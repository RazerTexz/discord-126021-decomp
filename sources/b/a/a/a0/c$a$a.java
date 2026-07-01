package b.a.a.a0;

import com.discord.stores.StoreGifting$GiftState;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c$a$a {
    public final StoreGifting$GiftState a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f44b;

    public c$a$a(StoreGifting$GiftState storeGifting$GiftState, boolean z2) {
        m.checkNotNullParameter(storeGifting$GiftState, "giftState");
        this.a = storeGifting$GiftState;
        this.f44b = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c$a$a)) {
            return false;
        }
        c$a$a c_a_a = (c$a$a) obj;
        return m.areEqual(this.a, c_a_a.a) && this.f44b == c_a_a.f44b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        StoreGifting$GiftState storeGifting$GiftState = this.a;
        int iHashCode = (storeGifting$GiftState != null ? storeGifting$GiftState.hashCode() : 0) * 31;
        boolean z2 = this.f44b;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("GiftUiState(giftState=");
        sbU.append(this.a);
        sbU.append(", reduceMotion=");
        return b.d.b.a.a.O(sbU, this.f44b, ")");
    }
}
