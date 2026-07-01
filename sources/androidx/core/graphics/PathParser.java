package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class PathParser {
    private static final String LOGTAG = "PathParser";

    private PathParser() {
    }

    private static void addNode(ArrayList<PathParser$PathDataNode> arrayList, char c, float[] fArr) {
        arrayList.add(new PathParser$PathDataNode(c, fArr));
    }

    public static boolean canMorph(@Nullable PathParser$PathDataNode[] pathParser$PathDataNodeArr, @Nullable PathParser$PathDataNode[] pathParser$PathDataNodeArr2) {
        if (pathParser$PathDataNodeArr == null || pathParser$PathDataNodeArr2 == null || pathParser$PathDataNodeArr.length != pathParser$PathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
            if (pathParser$PathDataNodeArr[i].mType != pathParser$PathDataNodeArr2[i].mType || pathParser$PathDataNodeArr[i].mParams.length != pathParser$PathDataNodeArr2[i].mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int iMin = Math.min(i3, length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, iMin);
        return fArr2;
    }

    public static PathParser$PathDataNode[] createNodesFromPathData(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int iNextStart = nextStart(str, i);
            String strTrim = str.substring(i2, iNextStart).trim();
            if (strTrim.length() > 0) {
                addNode(arrayList, strTrim.charAt(0), getFloats(strTrim));
            }
            i2 = iNextStart;
            i = iNextStart + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            addNode(arrayList, str.charAt(i2), new float[0]);
        }
        return (PathParser$PathDataNode[]) arrayList.toArray(new PathParser$PathDataNode[arrayList.size()]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathParser$PathDataNode[] pathParser$PathDataNodeArrCreateNodesFromPathData = createNodesFromPathData(str);
        if (pathParser$PathDataNodeArrCreateNodesFromPathData == null) {
            return null;
        }
        try {
            PathParser$PathDataNode.nodesToPath(pathParser$PathDataNodeArrCreateNodesFromPathData, path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException(a.w("Error in parsing ", str), e);
        }
    }

    public static PathParser$PathDataNode[] deepCopyNodes(PathParser$PathDataNode[] pathParser$PathDataNodeArr) {
        if (pathParser$PathDataNodeArr == null) {
            return null;
        }
        PathParser$PathDataNode[] pathParser$PathDataNodeArr2 = new PathParser$PathDataNode[pathParser$PathDataNodeArr.length];
        for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
            pathParser$PathDataNodeArr2[i] = new PathParser$PathDataNode(pathParser$PathDataNodeArr[i]);
        }
        return pathParser$PathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x0031  */
    /* JADX WARN: Code duplicated, block: B:21:0x0035  */
    private static void extract(String str, int i, PathParser$ExtractFloatResult pathParser$ExtractFloatResult) {
        pathParser$ExtractFloatResult.mEndWithNegOrDot = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        for (int i2 = i; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == ' ') {
                z2 = false;
                z4 = true;
            } else if (cCharAt != 'E' && cCharAt != 'e') {
                switch (cCharAt) {
                    case ',':
                        z2 = false;
                        z4 = true;
                        break;
                    case '-':
                        if (i2 == i || z2) {
                            z2 = false;
                        } else {
                            pathParser$ExtractFloatResult.mEndWithNegOrDot = true;
                            z2 = false;
                            z4 = true;
                        }
                        break;
                    case '.':
                        if (z3) {
                            pathParser$ExtractFloatResult.mEndWithNegOrDot = true;
                            z2 = false;
                            z4 = true;
                        } else {
                            z2 = false;
                            z3 = true;
                        }
                        break;
                    default:
                        z2 = false;
                        break;
                }
            } else {
                z2 = true;
            }
            if (z4) {
                pathParser$ExtractFloatResult.mEndPosition = i2;
            }
        }
        pathParser$ExtractFloatResult.mEndPosition = i2;
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            PathParser$ExtractFloatResult pathParser$ExtractFloatResult = new PathParser$ExtractFloatResult();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                extract(str, i, pathParser$ExtractFloatResult);
                int i3 = pathParser$ExtractFloatResult.mEndPosition;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = pathParser$ExtractFloatResult.mEndWithNegOrDot ? i3 : i3 + 1;
            }
            return copyOfRange(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException(a.y("error in parsing \"", str, "\""), e);
        }
    }

    public static boolean interpolatePathDataNodes(PathParser$PathDataNode[] pathParser$PathDataNodeArr, PathParser$PathDataNode[] pathParser$PathDataNodeArr2, PathParser$PathDataNode[] pathParser$PathDataNodeArr3, float f) {
        if (pathParser$PathDataNodeArr == null || pathParser$PathDataNodeArr2 == null || pathParser$PathDataNodeArr3 == null) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
        }
        if (pathParser$PathDataNodeArr.length != pathParser$PathDataNodeArr2.length || pathParser$PathDataNodeArr2.length != pathParser$PathDataNodeArr3.length) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
        }
        if (!canMorph(pathParser$PathDataNodeArr2, pathParser$PathDataNodeArr3)) {
            return false;
        }
        for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
            pathParser$PathDataNodeArr[i].interpolatePathDataNode(pathParser$PathDataNodeArr2[i], pathParser$PathDataNodeArr3[i], f);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if ((cCharAt - 'Z') * (cCharAt - 'A') > 0) {
                if ((cCharAt - 'z') * (cCharAt - 'a') > 0) {
                    continue;
                } else if (cCharAt != 'e' && cCharAt != 'E') {
                    return i;
                }
            } else if (cCharAt != 'e') {
                continue;
            }
            i++;
        }
        return i;
    }

    public static void updateNodes(PathParser$PathDataNode[] pathParser$PathDataNodeArr, PathParser$PathDataNode[] pathParser$PathDataNodeArr2) {
        for (int i = 0; i < pathParser$PathDataNodeArr2.length; i++) {
            pathParser$PathDataNodeArr[i].mType = pathParser$PathDataNodeArr2[i].mType;
            for (int i2 = 0; i2 < pathParser$PathDataNodeArr2[i].mParams.length; i2++) {
                pathParser$PathDataNodeArr[i].mParams[i2] = pathParser$PathDataNodeArr2[i].mParams[i2];
            }
        }
    }
}
