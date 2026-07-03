package com.discord.utilities;

import androidx.exifinterface.media.ExifInterface;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Quad.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class Quad<A, B, C, D> {
    private final A first;
    private final D fourth;
    private final B second;
    private final C third;

    public Quad(A a, B b2, C c, D d) {
        this.first = a;
        this.second = b2;
        this.third = c;
        this.fourth = d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Quad copy$default(Quad quad, Object obj, Object obj2, Object obj3, Object obj4, int i, Object obj5) {
        if ((i & 1) != 0) {
            obj = quad.first;
        }
        if ((i & 2) != 0) {
            obj2 = quad.second;
        }
        if ((i & 4) != 0) {
            obj3 = quad.third;
        }
        if ((i & 8) != 0) {
            obj4 = quad.fourth;
        }
        return quad.copy(obj, obj2, obj3, obj4);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    public final D component4() {
        return this.fourth;
    }

    public final Quad<A, B, C, D> copy(A first, B second, C third, D fourth) {
        return new Quad<>(first, second, third, fourth);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Quad)) {
            return false;
        }
        Quad quad = (Quad) other;
        return C12238m.areEqual(this.first, quad.first) && C12238m.areEqual(this.second, quad.second) && C12238m.areEqual(this.third, quad.third) && C12238m.areEqual(this.fourth, quad.fourth);
    }

    public final A getFirst() {
        return this.first;
    }

    public final D getFourth() {
        return this.fourth;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A a = this.first;
        int iHashCode = (a != null ? a.hashCode() : 0) * 31;
        B b2 = this.second;
        int iHashCode2 = (iHashCode + (b2 != null ? b2.hashCode() : 0)) * 31;
        C c = this.third;
        int iHashCode3 = (iHashCode2 + (c != null ? c.hashCode() : 0)) * 31;
        D d = this.fourth;
        return iHashCode3 + (d != null ? d.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM829Q = C1643a.m829Q('(');
        sbM829Q.append(this.first);
        sbM829Q.append(", ");
        sbM829Q.append(this.second);
        sbM829Q.append(", ");
        sbM829Q.append(this.third);
        sbM829Q.append(", ");
        sbM829Q.append(this.fourth);
        sbM829Q.append(')');
        return sbM829Q.toString();
    }
}
