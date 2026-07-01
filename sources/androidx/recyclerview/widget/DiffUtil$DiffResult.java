package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DiffUtil$DiffResult {
    private static final int FLAG_CHANGED = 2;
    private static final int FLAG_MASK = 15;
    private static final int FLAG_MOVED = 12;
    private static final int FLAG_MOVED_CHANGED = 4;
    private static final int FLAG_MOVED_NOT_CHANGED = 8;
    private static final int FLAG_NOT_CHANGED = 1;
    private static final int FLAG_OFFSET = 4;
    public static final int NO_POSITION = -1;
    private final DiffUtil$Callback mCallback;
    private final boolean mDetectMoves;
    private final List<DiffUtil$Diagonal> mDiagonals;
    private final int[] mNewItemStatuses;
    private final int mNewListSize;
    private final int[] mOldItemStatuses;
    private final int mOldListSize;

    public DiffUtil$DiffResult(DiffUtil$Callback diffUtil$Callback, List<DiffUtil$Diagonal> list, int[] iArr, int[] iArr2, boolean z2) {
        this.mDiagonals = list;
        this.mOldItemStatuses = iArr;
        this.mNewItemStatuses = iArr2;
        Arrays.fill(iArr, 0);
        Arrays.fill(iArr2, 0);
        this.mCallback = diffUtil$Callback;
        this.mOldListSize = diffUtil$Callback.getOldListSize();
        this.mNewListSize = diffUtil$Callback.getNewListSize();
        this.mDetectMoves = z2;
        addEdgeDiagonals();
        findMatchingItems();
    }

    private void addEdgeDiagonals() {
        DiffUtil$Diagonal diffUtil$Diagonal = this.mDiagonals.isEmpty() ? null : this.mDiagonals.get(0);
        if (diffUtil$Diagonal == null || diffUtil$Diagonal.f36x != 0 || diffUtil$Diagonal.f37y != 0) {
            this.mDiagonals.add(0, new DiffUtil$Diagonal(0, 0, 0));
        }
        this.mDiagonals.add(new DiffUtil$Diagonal(this.mOldListSize, this.mNewListSize, 0));
    }

    private void findMatchingAddition(int i) {
        int size = this.mDiagonals.size();
        int iEndY = 0;
        for (int i2 = 0; i2 < size; i2++) {
            DiffUtil$Diagonal diffUtil$Diagonal = this.mDiagonals.get(i2);
            while (iEndY < diffUtil$Diagonal.f37y) {
                if (this.mNewItemStatuses[iEndY] == 0 && this.mCallback.areItemsTheSame(i, iEndY)) {
                    int i3 = this.mCallback.areContentsTheSame(i, iEndY) ? 8 : 4;
                    this.mOldItemStatuses[i] = (iEndY << 4) | i3;
                    this.mNewItemStatuses[iEndY] = (i << 4) | i3;
                    return;
                }
                iEndY++;
            }
            iEndY = diffUtil$Diagonal.endY();
        }
    }

    private void findMatchingItems() {
        for (DiffUtil$Diagonal diffUtil$Diagonal : this.mDiagonals) {
            for (int i = 0; i < diffUtil$Diagonal.size; i++) {
                int i2 = diffUtil$Diagonal.f36x + i;
                int i3 = diffUtil$Diagonal.f37y + i;
                int i4 = this.mCallback.areContentsTheSame(i2, i3) ? 1 : 2;
                this.mOldItemStatuses[i2] = (i3 << 4) | i4;
                this.mNewItemStatuses[i3] = (i2 << 4) | i4;
            }
        }
        if (this.mDetectMoves) {
            findMoveMatches();
        }
    }

    private void findMoveMatches() {
        int iEndX = 0;
        for (DiffUtil$Diagonal diffUtil$Diagonal : this.mDiagonals) {
            while (iEndX < diffUtil$Diagonal.f36x) {
                if (this.mOldItemStatuses[iEndX] == 0) {
                    findMatchingAddition(iEndX);
                }
                iEndX++;
            }
            iEndX = diffUtil$Diagonal.endX();
        }
    }

    @Nullable
    private static DiffUtil$PostponedUpdate getPostponedUpdate(Collection<DiffUtil$PostponedUpdate> collection, int i, boolean z2) {
        DiffUtil$PostponedUpdate next;
        Iterator<DiffUtil$PostponedUpdate> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.posInOwnerList == i && next.removal == z2) {
                it.remove();
                break;
            }
        }
        while (it.hasNext()) {
            DiffUtil$PostponedUpdate next2 = it.next();
            if (z2) {
                next2.currentPos--;
            } else {
                next2.currentPos++;
            }
        }
        return next;
    }

    public int convertNewPositionToOld(@IntRange(from = 0) int i) {
        if (i < 0 || i >= this.mNewListSize) {
            StringBuilder sbV = a.V("Index out of bounds - passed position = ", i, ", new list size = ");
            sbV.append(this.mNewListSize);
            throw new IndexOutOfBoundsException(sbV.toString());
        }
        int i2 = this.mNewItemStatuses[i];
        if ((i2 & 15) == 0) {
            return -1;
        }
        return i2 >> 4;
    }

    public int convertOldPositionToNew(@IntRange(from = 0) int i) {
        if (i < 0 || i >= this.mOldListSize) {
            StringBuilder sbV = a.V("Index out of bounds - passed position = ", i, ", old list size = ");
            sbV.append(this.mOldListSize);
            throw new IndexOutOfBoundsException(sbV.toString());
        }
        int i2 = this.mOldItemStatuses[i];
        if ((i2 & 15) == 0) {
            return -1;
        }
        return i2 >> 4;
    }

    public void dispatchUpdatesTo(@NonNull RecyclerView$Adapter recyclerView$Adapter) {
        dispatchUpdatesTo(new AdapterListUpdateCallback(recyclerView$Adapter));
    }

    public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
        int i;
        BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
        int i2 = this.mOldListSize;
        ArrayDeque arrayDeque = new ArrayDeque();
        int i3 = this.mOldListSize;
        int i4 = this.mNewListSize;
        for (int size = this.mDiagonals.size() - 1; size >= 0; size--) {
            DiffUtil$Diagonal diffUtil$Diagonal = this.mDiagonals.get(size);
            int iEndX = diffUtil$Diagonal.endX();
            int iEndY = diffUtil$Diagonal.endY();
            while (true) {
                if (i3 <= iEndX) {
                    break;
                }
                i3--;
                int i5 = this.mOldItemStatuses[i3];
                if ((i5 & 12) != 0) {
                    int i6 = i5 >> 4;
                    DiffUtil$PostponedUpdate postponedUpdate = getPostponedUpdate(arrayDeque, i6, false);
                    if (postponedUpdate != null) {
                        int i7 = (i2 - postponedUpdate.currentPos) - 1;
                        batchingListUpdateCallback.onMoved(i3, i7);
                        if ((i5 & 4) != 0) {
                            batchingListUpdateCallback.onChanged(i7, 1, this.mCallback.getChangePayload(i3, i6));
                        }
                    } else {
                        arrayDeque.add(new DiffUtil$PostponedUpdate(i3, (i2 - i3) - 1, true));
                    }
                } else {
                    batchingListUpdateCallback.onRemoved(i3, 1);
                    i2--;
                }
            }
            while (i4 > iEndY) {
                i4--;
                int i8 = this.mNewItemStatuses[i4];
                if ((i8 & 12) != 0) {
                    int i9 = i8 >> 4;
                    DiffUtil$PostponedUpdate postponedUpdate2 = getPostponedUpdate(arrayDeque, i9, true);
                    if (postponedUpdate2 == null) {
                        arrayDeque.add(new DiffUtil$PostponedUpdate(i4, i2 - i3, false));
                    } else {
                        batchingListUpdateCallback.onMoved((i2 - postponedUpdate2.currentPos) - 1, i3);
                        if ((i8 & 4) != 0) {
                            batchingListUpdateCallback.onChanged(i3, 1, this.mCallback.getChangePayload(i9, i4));
                        }
                    }
                } else {
                    batchingListUpdateCallback.onInserted(i3, 1);
                    i2++;
                }
            }
            int i10 = diffUtil$Diagonal.f36x;
            int i11 = diffUtil$Diagonal.f37y;
            for (i = 0; i < diffUtil$Diagonal.size; i++) {
                if ((this.mOldItemStatuses[i10] & 15) == 2) {
                    batchingListUpdateCallback.onChanged(i10, 1, this.mCallback.getChangePayload(i10, i11));
                }
                i10++;
                i11++;
            }
            i3 = diffUtil$Diagonal.f36x;
            i4 = diffUtil$Diagonal.f37y;
        }
        batchingListUpdateCallback.dispatchLastEvent();
    }
}
