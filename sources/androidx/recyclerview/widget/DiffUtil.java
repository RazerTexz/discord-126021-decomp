package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class DiffUtil {
    private static final Comparator<DiffUtil$Diagonal> DIAGONAL_COMPARATOR = new DiffUtil$1();

    private DiffUtil() {
    }

    @Nullable
    private static DiffUtil$Snake backward(DiffUtil$Range diffUtil$Range, DiffUtil$Callback diffUtil$Callback, DiffUtil$CenteredArray diffUtil$CenteredArray, DiffUtil$CenteredArray diffUtil$CenteredArray2, int i) {
        int i2;
        int i3;
        int i4;
        boolean z2 = (diffUtil$Range.oldSize() - diffUtil$Range.newSize()) % 2 == 0;
        int iOldSize = diffUtil$Range.oldSize() - diffUtil$Range.newSize();
        int i5 = -i;
        for (int i6 = i5; i6 <= i; i6 += 2) {
            if (i6 == i5 || (i6 != i && diffUtil$CenteredArray2.get(i6 + 1) < diffUtil$CenteredArray2.get(i6 - 1))) {
                i2 = diffUtil$CenteredArray2.get(i6 + 1);
                i3 = i2;
            } else {
                i2 = diffUtil$CenteredArray2.get(i6 - 1);
                i3 = i2 - 1;
            }
            int i7 = diffUtil$Range.newListEnd - ((diffUtil$Range.oldListEnd - i3) - i6);
            int i8 = (i == 0 || i3 != i2) ? i7 : i7 + 1;
            while (i3 > diffUtil$Range.oldListStart && i7 > diffUtil$Range.newListStart && diffUtil$Callback.areItemsTheSame(i3 - 1, i7 - 1)) {
                i3--;
                i7--;
            }
            diffUtil$CenteredArray2.set(i6, i3);
            if (z2 && (i4 = iOldSize - i6) >= i5 && i4 <= i && diffUtil$CenteredArray.get(i4) >= i3) {
                DiffUtil$Snake diffUtil$Snake = new DiffUtil$Snake();
                diffUtil$Snake.startX = i3;
                diffUtil$Snake.startY = i7;
                diffUtil$Snake.endX = i2;
                diffUtil$Snake.endY = i8;
                diffUtil$Snake.reverse = true;
                return diffUtil$Snake;
            }
        }
        return null;
    }

    @NonNull
    public static DiffUtil$DiffResult calculateDiff(@NonNull DiffUtil$Callback diffUtil$Callback) {
        return calculateDiff(diffUtil$Callback, true);
    }

    @Nullable
    private static DiffUtil$Snake forward(DiffUtil$Range diffUtil$Range, DiffUtil$Callback diffUtil$Callback, DiffUtil$CenteredArray diffUtil$CenteredArray, DiffUtil$CenteredArray diffUtil$CenteredArray2, int i) {
        int i2;
        int i3;
        int i4;
        boolean z2 = Math.abs(diffUtil$Range.oldSize() - diffUtil$Range.newSize()) % 2 == 1;
        int iOldSize = diffUtil$Range.oldSize() - diffUtil$Range.newSize();
        int i5 = -i;
        for (int i6 = i5; i6 <= i; i6 += 2) {
            if (i6 == i5 || (i6 != i && diffUtil$CenteredArray.get(i6 + 1) > diffUtil$CenteredArray.get(i6 - 1))) {
                i2 = diffUtil$CenteredArray.get(i6 + 1);
                i3 = i2;
            } else {
                i2 = diffUtil$CenteredArray.get(i6 - 1);
                i3 = i2 + 1;
            }
            int i7 = ((i3 - diffUtil$Range.oldListStart) + diffUtil$Range.newListStart) - i6;
            int i8 = (i == 0 || i3 != i2) ? i7 : i7 - 1;
            while (i3 < diffUtil$Range.oldListEnd && i7 < diffUtil$Range.newListEnd && diffUtil$Callback.areItemsTheSame(i3, i7)) {
                i3++;
                i7++;
            }
            diffUtil$CenteredArray.set(i6, i3);
            if (z2 && (i4 = iOldSize - i6) >= i5 + 1 && i4 <= i - 1 && diffUtil$CenteredArray2.get(i4) <= i3) {
                DiffUtil$Snake diffUtil$Snake = new DiffUtil$Snake();
                diffUtil$Snake.startX = i2;
                diffUtil$Snake.startY = i8;
                diffUtil$Snake.endX = i3;
                diffUtil$Snake.endY = i7;
                diffUtil$Snake.reverse = false;
                return diffUtil$Snake;
            }
        }
        return null;
    }

    @Nullable
    private static DiffUtil$Snake midPoint(DiffUtil$Range diffUtil$Range, DiffUtil$Callback diffUtil$Callback, DiffUtil$CenteredArray diffUtil$CenteredArray, DiffUtil$CenteredArray diffUtil$CenteredArray2) {
        if (diffUtil$Range.oldSize() >= 1 && diffUtil$Range.newSize() >= 1) {
            int iNewSize = ((diffUtil$Range.newSize() + diffUtil$Range.oldSize()) + 1) / 2;
            diffUtil$CenteredArray.set(1, diffUtil$Range.oldListStart);
            diffUtil$CenteredArray2.set(1, diffUtil$Range.oldListEnd);
            for (int i = 0; i < iNewSize; i++) {
                DiffUtil$Snake diffUtil$SnakeForward = forward(diffUtil$Range, diffUtil$Callback, diffUtil$CenteredArray, diffUtil$CenteredArray2, i);
                if (diffUtil$SnakeForward != null) {
                    return diffUtil$SnakeForward;
                }
                DiffUtil$Snake diffUtil$SnakeBackward = backward(diffUtil$Range, diffUtil$Callback, diffUtil$CenteredArray, diffUtil$CenteredArray2, i);
                if (diffUtil$SnakeBackward != null) {
                    return diffUtil$SnakeBackward;
                }
            }
        }
        return null;
    }

    @NonNull
    public static DiffUtil$DiffResult calculateDiff(@NonNull DiffUtil$Callback diffUtil$Callback, boolean z2) {
        int oldListSize = diffUtil$Callback.getOldListSize();
        int newListSize = diffUtil$Callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new DiffUtil$Range(0, oldListSize, 0, newListSize));
        int i = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        DiffUtil$CenteredArray diffUtil$CenteredArray = new DiffUtil$CenteredArray(i);
        DiffUtil$CenteredArray diffUtil$CenteredArray2 = new DiffUtil$CenteredArray(i);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            DiffUtil$Range diffUtil$Range = (DiffUtil$Range) arrayList2.remove(arrayList2.size() - 1);
            DiffUtil$Snake diffUtil$SnakeMidPoint = midPoint(diffUtil$Range, diffUtil$Callback, diffUtil$CenteredArray, diffUtil$CenteredArray2);
            if (diffUtil$SnakeMidPoint != null) {
                if (diffUtil$SnakeMidPoint.diagonalSize() > 0) {
                    arrayList.add(diffUtil$SnakeMidPoint.toDiagonal());
                }
                DiffUtil$Range diffUtil$Range2 = arrayList3.isEmpty() ? new DiffUtil$Range() : (DiffUtil$Range) arrayList3.remove(arrayList3.size() - 1);
                diffUtil$Range2.oldListStart = diffUtil$Range.oldListStart;
                diffUtil$Range2.newListStart = diffUtil$Range.newListStart;
                diffUtil$Range2.oldListEnd = diffUtil$SnakeMidPoint.startX;
                diffUtil$Range2.newListEnd = diffUtil$SnakeMidPoint.startY;
                arrayList2.add(diffUtil$Range2);
                diffUtil$Range.oldListEnd = diffUtil$Range.oldListEnd;
                diffUtil$Range.newListEnd = diffUtil$Range.newListEnd;
                diffUtil$Range.oldListStart = diffUtil$SnakeMidPoint.endX;
                diffUtil$Range.newListStart = diffUtil$SnakeMidPoint.endY;
                arrayList2.add(diffUtil$Range);
            } else {
                arrayList3.add(diffUtil$Range);
            }
        }
        Collections.sort(arrayList, DIAGONAL_COMPARATOR);
        return new DiffUtil$DiffResult(diffUtil$Callback, arrayList, diffUtil$CenteredArray.backingData(), diffUtil$CenteredArray2.backingData(), z2);
    }
}
