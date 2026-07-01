package com.google.android.flexbox;

import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class FlexboxLayoutManager$b {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2991b;
    public int c;
    public int d = 0;
    public boolean e;
    public boolean f;
    public boolean g;
    public final /* synthetic */ FlexboxLayoutManager h;

    public FlexboxLayoutManager$b(FlexboxLayoutManager flexboxLayoutManager, FlexboxLayoutManager$a flexboxLayoutManager$a) {
        this.h = flexboxLayoutManager;
    }

    public static void a(FlexboxLayoutManager$b flexboxLayoutManager$b) {
        if (!flexboxLayoutManager$b.h.i()) {
            FlexboxLayoutManager flexboxLayoutManager = flexboxLayoutManager$b.h;
            if (flexboxLayoutManager.o) {
                flexboxLayoutManager$b.c = flexboxLayoutManager$b.e ? flexboxLayoutManager.w.getEndAfterPadding() : flexboxLayoutManager.getWidth() - flexboxLayoutManager$b.h.w.getStartAfterPadding();
                return;
            }
        }
        flexboxLayoutManager$b.c = flexboxLayoutManager$b.e ? flexboxLayoutManager$b.h.w.getEndAfterPadding() : flexboxLayoutManager$b.h.w.getStartAfterPadding();
    }

    public static void b(FlexboxLayoutManager$b flexboxLayoutManager$b) {
        flexboxLayoutManager$b.a = -1;
        flexboxLayoutManager$b.f2991b = -1;
        flexboxLayoutManager$b.c = Integer.MIN_VALUE;
        flexboxLayoutManager$b.f = false;
        flexboxLayoutManager$b.g = false;
        if (flexboxLayoutManager$b.h.i()) {
            FlexboxLayoutManager flexboxLayoutManager = flexboxLayoutManager$b.h;
            int i = flexboxLayoutManager.l;
            if (i == 0) {
                flexboxLayoutManager$b.e = flexboxLayoutManager.k == 1;
                return;
            } else {
                flexboxLayoutManager$b.e = i == 2;
                return;
            }
        }
        FlexboxLayoutManager flexboxLayoutManager2 = flexboxLayoutManager$b.h;
        int i2 = flexboxLayoutManager2.l;
        if (i2 == 0) {
            flexboxLayoutManager$b.e = flexboxLayoutManager2.k == 3;
        } else {
            flexboxLayoutManager$b.e = i2 == 2;
        }
    }

    public String toString() {
        StringBuilder sbU = a.U("AnchorInfo{mPosition=");
        sbU.append(this.a);
        sbU.append(", mFlexLinePosition=");
        sbU.append(this.f2991b);
        sbU.append(", mCoordinate=");
        sbU.append(this.c);
        sbU.append(", mPerpendicularCoordinate=");
        sbU.append(this.d);
        sbU.append(", mLayoutFromEnd=");
        sbU.append(this.e);
        sbU.append(", mValid=");
        sbU.append(this.f);
        sbU.append(", mAssignedFromSavedState=");
        sbU.append(this.g);
        sbU.append('}');
        return sbU.toString();
    }
}
