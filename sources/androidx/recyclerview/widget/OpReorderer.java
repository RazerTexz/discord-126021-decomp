package androidx.recyclerview.widget;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OpReorderer {
    public final OpReorderer$Callback mCallback;

    public OpReorderer(OpReorderer$Callback opReorderer$Callback) {
        this.mCallback = opReorderer$Callback;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper$UpdateOp> list) {
        boolean z2 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).cmd != 8) {
                z2 = true;
            } else if (z2) {
                return size;
            }
        }
        return -1;
    }

    private void swapMoveAdd(List<AdapterHelper$UpdateOp> list, int i, AdapterHelper$UpdateOp adapterHelper$UpdateOp, int i2, AdapterHelper$UpdateOp adapterHelper$UpdateOp2) {
        int i3 = adapterHelper$UpdateOp.itemCount;
        int i4 = adapterHelper$UpdateOp2.positionStart;
        int i5 = i3 < i4 ? -1 : 0;
        int i6 = adapterHelper$UpdateOp.positionStart;
        if (i6 < i4) {
            i5++;
        }
        if (i4 <= i6) {
            adapterHelper$UpdateOp.positionStart = i6 + adapterHelper$UpdateOp2.itemCount;
        }
        int i7 = adapterHelper$UpdateOp2.positionStart;
        if (i7 <= i3) {
            adapterHelper$UpdateOp.itemCount = i3 + adapterHelper$UpdateOp2.itemCount;
        }
        adapterHelper$UpdateOp2.positionStart = i7 + i5;
        list.set(i, adapterHelper$UpdateOp2);
        list.set(i2, adapterHelper$UpdateOp);
    }

    private void swapMoveOp(List<AdapterHelper$UpdateOp> list, int i, int i2) {
        AdapterHelper$UpdateOp adapterHelper$UpdateOp = list.get(i);
        AdapterHelper$UpdateOp adapterHelper$UpdateOp2 = list.get(i2);
        int i3 = adapterHelper$UpdateOp2.cmd;
        if (i3 == 1) {
            swapMoveAdd(list, i, adapterHelper$UpdateOp, i2, adapterHelper$UpdateOp2);
        } else if (i3 == 2) {
            swapMoveRemove(list, i, adapterHelper$UpdateOp, i2, adapterHelper$UpdateOp2);
        } else {
            if (i3 != 4) {
                return;
            }
            swapMoveUpdate(list, i, adapterHelper$UpdateOp, i2, adapterHelper$UpdateOp2);
        }
    }

    public void reorderOps(List<AdapterHelper$UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder == -1) {
                return;
            } else {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            }
        }
    }

    public void swapMoveRemove(List<AdapterHelper$UpdateOp> list, int i, AdapterHelper$UpdateOp adapterHelper$UpdateOp, int i2, AdapterHelper$UpdateOp adapterHelper$UpdateOp2) {
        boolean z2;
        int i3 = adapterHelper$UpdateOp.positionStart;
        int i4 = adapterHelper$UpdateOp.itemCount;
        boolean z3 = false;
        if (i3 < i4) {
            if (adapterHelper$UpdateOp2.positionStart == i3 && adapterHelper$UpdateOp2.itemCount == i4 - i3) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
            }
        } else if (adapterHelper$UpdateOp2.positionStart == i4 + 1 && adapterHelper$UpdateOp2.itemCount == i3 - i4) {
            z2 = true;
            z3 = true;
        } else {
            z2 = true;
        }
        int i5 = adapterHelper$UpdateOp2.positionStart;
        if (i4 < i5) {
            adapterHelper$UpdateOp2.positionStart = i5 - 1;
        } else {
            int i6 = adapterHelper$UpdateOp2.itemCount;
            if (i4 < i5 + i6) {
                adapterHelper$UpdateOp2.itemCount = i6 - 1;
                adapterHelper$UpdateOp.cmd = 2;
                adapterHelper$UpdateOp.itemCount = 1;
                if (adapterHelper$UpdateOp2.itemCount == 0) {
                    list.remove(i2);
                    this.mCallback.recycleUpdateOp(adapterHelper$UpdateOp2);
                    return;
                }
                return;
            }
        }
        int i7 = adapterHelper$UpdateOp.positionStart;
        int i8 = adapterHelper$UpdateOp2.positionStart;
        AdapterHelper$UpdateOp adapterHelper$UpdateOpObtainUpdateOp = null;
        if (i7 <= i8) {
            adapterHelper$UpdateOp2.positionStart = i8 + 1;
        } else {
            int i9 = adapterHelper$UpdateOp2.itemCount;
            if (i7 < i8 + i9) {
                adapterHelper$UpdateOpObtainUpdateOp = this.mCallback.obtainUpdateOp(2, i7 + 1, (i8 + i9) - i7, null);
                adapterHelper$UpdateOp2.itemCount = adapterHelper$UpdateOp.positionStart - adapterHelper$UpdateOp2.positionStart;
            }
        }
        if (z3) {
            list.set(i, adapterHelper$UpdateOp2);
            list.remove(i2);
            this.mCallback.recycleUpdateOp(adapterHelper$UpdateOp);
            return;
        }
        if (z2) {
            if (adapterHelper$UpdateOpObtainUpdateOp != null) {
                int i10 = adapterHelper$UpdateOp.positionStart;
                if (i10 > adapterHelper$UpdateOpObtainUpdateOp.positionStart) {
                    adapterHelper$UpdateOp.positionStart = i10 - adapterHelper$UpdateOpObtainUpdateOp.itemCount;
                }
                int i11 = adapterHelper$UpdateOp.itemCount;
                if (i11 > adapterHelper$UpdateOpObtainUpdateOp.positionStart) {
                    adapterHelper$UpdateOp.itemCount = i11 - adapterHelper$UpdateOpObtainUpdateOp.itemCount;
                }
            }
            int i12 = adapterHelper$UpdateOp.positionStart;
            if (i12 > adapterHelper$UpdateOp2.positionStart) {
                adapterHelper$UpdateOp.positionStart = i12 - adapterHelper$UpdateOp2.itemCount;
            }
            int i13 = adapterHelper$UpdateOp.itemCount;
            if (i13 > adapterHelper$UpdateOp2.positionStart) {
                adapterHelper$UpdateOp.itemCount = i13 - adapterHelper$UpdateOp2.itemCount;
            }
        } else {
            if (adapterHelper$UpdateOpObtainUpdateOp != null) {
                int i14 = adapterHelper$UpdateOp.positionStart;
                if (i14 >= adapterHelper$UpdateOpObtainUpdateOp.positionStart) {
                    adapterHelper$UpdateOp.positionStart = i14 - adapterHelper$UpdateOpObtainUpdateOp.itemCount;
                }
                int i15 = adapterHelper$UpdateOp.itemCount;
                if (i15 >= adapterHelper$UpdateOpObtainUpdateOp.positionStart) {
                    adapterHelper$UpdateOp.itemCount = i15 - adapterHelper$UpdateOpObtainUpdateOp.itemCount;
                }
            }
            int i16 = adapterHelper$UpdateOp.positionStart;
            if (i16 >= adapterHelper$UpdateOp2.positionStart) {
                adapterHelper$UpdateOp.positionStart = i16 - adapterHelper$UpdateOp2.itemCount;
            }
            int i17 = adapterHelper$UpdateOp.itemCount;
            if (i17 >= adapterHelper$UpdateOp2.positionStart) {
                adapterHelper$UpdateOp.itemCount = i17 - adapterHelper$UpdateOp2.itemCount;
            }
        }
        list.set(i, adapterHelper$UpdateOp2);
        if (adapterHelper$UpdateOp.positionStart != adapterHelper$UpdateOp.itemCount) {
            list.set(i2, adapterHelper$UpdateOp);
        } else {
            list.remove(i2);
        }
        if (adapterHelper$UpdateOpObtainUpdateOp != null) {
            list.add(i, adapterHelper$UpdateOpObtainUpdateOp);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0027  */
    /* JADX WARN: Code duplicated, block: B:12:0x002b  */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0056  */
    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    public void swapMoveUpdate(List<AdapterHelper$UpdateOp> list, int i, AdapterHelper$UpdateOp adapterHelper$UpdateOp, int i2, AdapterHelper$UpdateOp adapterHelper$UpdateOp2) {
        AdapterHelper$UpdateOp adapterHelper$UpdateOpObtainUpdateOp;
        int i3;
        int i4;
        int i5;
        int i6 = adapterHelper$UpdateOp.itemCount;
        int i7 = adapterHelper$UpdateOp2.positionStart;
        AdapterHelper$UpdateOp adapterHelper$UpdateOpObtainUpdateOp2 = null;
        if (i6 >= i7) {
            int i8 = adapterHelper$UpdateOp2.itemCount;
            if (i6 < i7 + i8) {
                adapterHelper$UpdateOp2.itemCount = i8 - 1;
                adapterHelper$UpdateOpObtainUpdateOp = this.mCallback.obtainUpdateOp(4, adapterHelper$UpdateOp.positionStart, 1, adapterHelper$UpdateOp2.payload);
            }
            i3 = adapterHelper$UpdateOp.positionStart;
            i4 = adapterHelper$UpdateOp2.positionStart;
            if (i3 <= i4) {
                adapterHelper$UpdateOp2.positionStart = i4 + 1;
            } else {
                i5 = adapterHelper$UpdateOp2.itemCount;
                if (i3 < i4 + i5) {
                    int i9 = (i4 + i5) - i3;
                    adapterHelper$UpdateOpObtainUpdateOp2 = this.mCallback.obtainUpdateOp(4, i3 + 1, i9, adapterHelper$UpdateOp2.payload);
                    adapterHelper$UpdateOp2.itemCount -= i9;
                }
            }
            list.set(i2, adapterHelper$UpdateOp);
            if (adapterHelper$UpdateOp2.itemCount > 0) {
                list.set(i, adapterHelper$UpdateOp2);
            } else {
                list.remove(i);
                this.mCallback.recycleUpdateOp(adapterHelper$UpdateOp2);
            }
            if (adapterHelper$UpdateOpObtainUpdateOp != null) {
                list.add(i, adapterHelper$UpdateOpObtainUpdateOp);
            }
            if (adapterHelper$UpdateOpObtainUpdateOp2 != null) {
                list.add(i, adapterHelper$UpdateOpObtainUpdateOp2);
            }
        }
        adapterHelper$UpdateOp2.positionStart = i7 - 1;
        adapterHelper$UpdateOpObtainUpdateOp = null;
        i3 = adapterHelper$UpdateOp.positionStart;
        i4 = adapterHelper$UpdateOp2.positionStart;
        if (i3 <= i4) {
            adapterHelper$UpdateOp2.positionStart = i4 + 1;
        } else {
            i5 = adapterHelper$UpdateOp2.itemCount;
            if (i3 < i4 + i5) {
                int i10 = (i4 + i5) - i3;
                adapterHelper$UpdateOpObtainUpdateOp2 = this.mCallback.obtainUpdateOp(4, i3 + 1, i10, adapterHelper$UpdateOp2.payload);
                adapterHelper$UpdateOp2.itemCount -= i10;
            }
        }
        list.set(i2, adapterHelper$UpdateOp);
        if (adapterHelper$UpdateOp2.itemCount > 0) {
            list.set(i, adapterHelper$UpdateOp2);
        } else {
            list.remove(i);
            this.mCallback.recycleUpdateOp(adapterHelper$UpdateOp2);
        }
        if (adapterHelper$UpdateOpObtainUpdateOp != null) {
            list.add(i, adapterHelper$UpdateOpObtainUpdateOp);
        }
        if (adapterHelper$UpdateOpObtainUpdateOp2 != null) {
            list.add(i, adapterHelper$UpdateOpObtainUpdateOp2);
        }
    }
}
